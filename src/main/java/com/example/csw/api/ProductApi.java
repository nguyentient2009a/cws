package com.example.csw.api;

import com.example.csw.entity.ProductEntity;
import com.example.csw.repository.ProductRepository;
import com.example.csw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin("*")
public class ProductApi {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @RequestMapping(method = RequestMethod.POST, path = "{id}/{quantity}")
    public ResponseEntity<?> sellProduct(@PathVariable int id,
                                         @PathVariable int quantity) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity product = optionalProduct.get();
            product.setQuantity(product.getQuantity() - quantity);
            return ResponseEntity.ok(productService.sellProduct(product));
        }
        return ResponseEntity.badRequest().build();
    }
}
