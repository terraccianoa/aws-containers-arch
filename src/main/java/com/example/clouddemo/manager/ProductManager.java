package com.example.clouddemo.manager;

import com.example.clouddemo.DTOs.ProductDTO;
import com.example.clouddemo.entity.ProductEntity;
import com.example.clouddemo.mapper.ProductMapper;
import com.example.clouddemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductManager {

    private final ProductRepository repository;
    private final ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        log.info("Start method get all products to retrieve all db products");
        return repository.findAll(Sort.by("id"))
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public void saveProduct(ProductDTO productDTO) {
        log.info("Start saveProduct. DTO received: {}", productDTO.toString());
        ProductEntity productEntity = productMapper.toEntity(productDTO);
        ProductEntity savedEntity = repository.save(productEntity);
        log.info("Product saved with id: {}", savedEntity.getId());
    }

    public Optional<ProductDTO> getProduct(Long id) {
        log.info("Getting product by id {}", id);
        return repository.findById(id).map(productMapper::toDTO);
    }
}
