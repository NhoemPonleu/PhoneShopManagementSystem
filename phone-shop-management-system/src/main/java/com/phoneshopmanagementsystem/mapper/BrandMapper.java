package com.phoneshopmanagementsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.phoneshopmanagementsystem.dto.BrandDTO;
import com.phoneshopmanagementsystem.model.Brand;


@Mapper
public interface BrandMapper {
   BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);
   Brand toEntity(BrandDTO dto);
   BrandDTO toDTO(Brand entity);
}
