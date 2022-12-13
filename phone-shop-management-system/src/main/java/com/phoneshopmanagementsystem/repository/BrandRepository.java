package com.phoneshopmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phoneshopmanagementsystem.model.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
