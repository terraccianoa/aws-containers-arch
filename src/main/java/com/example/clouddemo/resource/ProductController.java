package com.example.clouddemo.resource;

import com.example.clouddemo.DTOs.ProductDTO;
import com.example.clouddemo.manager.ProductManager;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductManager productManager;

    @GetMapping
    public List<ProductDTO> getProducts() {
        return productManager.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return productManager.getProduct(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDTO productDTO) {
        productManager.saveProduct(productDTO);
    }
}
