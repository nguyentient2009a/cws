package com.example.csw.seeder;

import com.example.csw.entity.ProductEntity;
import com.example.csw.repository.ProductRepository;
import com.example.csw.util.NumberUtil;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ProductSeeder {

    @Autowired
    ProductRepository productRepository;

    public static List<ProductEntity> products;
    Faker faker = new Faker();
    public void productSeeder() {
        products = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            products.add(ProductEntity.builder()
                    .name(faker.food().sushi())
                    .price(NumberUtil.getRandomNumber(100, 9999) * 1000)
                    .quantity(NumberUtil.getRandomNumber(1,100))
                    .build());
        }
        productRepository.saveAll(products);
    }
}

