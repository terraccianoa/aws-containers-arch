package com.example.clouddemo.mapper;

import com.example.clouddemo.DTOs.ProductDTO;
import com.example.clouddemo.entity.ProductEntity;
import org.mapstruct.Mapper;

//questa proprietà fa sì che il mapper diventi automaticamente un bean Spring e possa essere iniettato
@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductEntity toEntity(ProductDTO dto);

    ProductDTO toDTO(ProductEntity entity);
}