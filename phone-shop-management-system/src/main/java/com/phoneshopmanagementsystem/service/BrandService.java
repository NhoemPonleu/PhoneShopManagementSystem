package com.phoneshopmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import com.phoneshopmanagementsystem.dto.BrandDTO;
import com.phoneshopmanagementsystem.exception.ApiException;
import com.phoneshopmanagementsystem.model.Brand;

public interface BrandService {
   Brand save(Brand entity);
  Brand getById(Integer id) ;
   Brand update(Integer id,BrandDTO dto) ;
   void delete(Integer id) ;
  List<Brand>getList();
}
