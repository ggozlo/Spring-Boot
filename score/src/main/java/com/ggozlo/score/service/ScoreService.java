package com.ggozlo.score.service;

import com.ggozlo.score.domain.Score;
import com.ggozlo.score.dto.ScoreDto;
import com.ggozlo.score.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository repository;

    @Transactional
    public void saveOne(ScoreDto dto) {
        repository.save(ScoreDto.toDomain(dto));
    }

    @Transactional(readOnly = true)
    public ScoreDto findOne(Long id) {
        return ScoreDto.toDTO(repository.findById(id).get());
    }


    @Transactional(readOnly = true)
    public List<ScoreDto> findAll() {
        AtomicInteger rank = new AtomicInteger(1);

        return repository.findAll().stream().map(ScoreDto::toDTO)
                .sorted(Comparator.comparing(ScoreDto::getTotal).reversed()).
                peek(s->s.setRank(rank.getAndIncrement()))
                .sorted(Comparator.comparing(ScoreDto::getNum).reversed().thenComparing(ScoreDto::getTotal).reversed())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<ScoreDto> findAllName(String name) {
        return repository.findByNameContaining(name).stream().map(ScoreDto::toDTO)
                .sorted(Comparator.comparing(ScoreDto::getNum).reversed().thenComparing(ScoreDto::getTotal).reversed())
                .collect(Collectors.toList());
    }

    @Transactional
    public void removeOne(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void updateOne(ScoreDto dto) {
        Score score = repository.findById(dto.getId()).get();
        score.setName(dto.getName());
        score.setNum(dto.getNum());
        score.setKor(dto.getKor());
        score.setEng(dto.getEng());
        score.setMat(dto.getMat());
    }


}
