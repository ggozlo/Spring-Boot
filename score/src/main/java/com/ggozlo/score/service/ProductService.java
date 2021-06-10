package com.ggozlo.score.service;

import com.ggozlo.score.domain.Product;
import com.ggozlo.score.domain.Score;
import com.ggozlo.score.dto.ProductDto;
import com.ggozlo.score.dto.ScoreDto;
import com.ggozlo.score.dto.summaryDto;
import com.ggozlo.score.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService {

    private  final ProductRepository repository;

    @Transactional
    public void saveOne(ProductDto dto) {
        repository.save(ProductDto.toDomain(dto));
    }

    @Transactional(readOnly = true)
    public ProductDto findOne(Long id) {
        return ProductDto.toDTO(repository.findById(id).get());
    }


    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        AtomicInteger i = new AtomicInteger(1);
        List<Product> list = repository.findAll();
        return list.stream().map(ProductDto::toDTO)
                .sorted(Comparator.comparing(ProductDto::getProfit).reversed())
                .peek(o->o.setRank(i.getAndIncrement())).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ProductDto> findAllName(String name) {
        return repository.findByNameContaining(name).stream().map(ProductDto::toDTO)
                .sorted(Comparator.comparing(ProductDto::getProfit).reversed())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<summaryDto> profitMap() {

        List<summaryDto> collect = repository.findAll().stream().map(ProductDto::toDTO)
                .collect(Collectors.groupingBy(ProductDto::getName,
                        Collectors.summingInt(ProductDto::getProfit)))
                .entrySet().stream().map(e -> new summaryDto(e.getKey(), e.getValue())).
        sorted(Comparator.comparing(summaryDto::getProfit).reversed()).collect(Collectors.toList());

        return collect;

    }

    @Transactional
    public void removeOne(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void updateOne(ProductDto dto) {
        Product product = repository.findById(dto.getId()).get();
        product.setName(dto.getName());
        product.setCount(dto.getCount());
        product.setPrice(dto.getPrice());
    }
}
