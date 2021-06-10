package com.ggozlo.score.dto;

import com.ggozlo.score.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;

    private String name;

    private int count;

    private int price;

    private Integer profit;

    private Integer rank;

    public static ProductDto toDTO(Product p) {
        return new ProductDto(p.getId(), p.getName(), p.getCount(), p.getPrice(), p.getCount()*p.getPrice());
    }

    public static Product toDomain(ProductDto dto) {
        return new Product(dto.getId(), dto.getName(), dto.getCount(), dto.getPrice());
    }

    public ProductDto(Long id, String name, int count, int price, Integer profit) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.profit = profit;
    }
}
