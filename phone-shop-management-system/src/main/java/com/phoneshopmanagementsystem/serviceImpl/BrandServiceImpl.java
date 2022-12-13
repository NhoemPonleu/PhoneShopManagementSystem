package com.phoneshopmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.mysql.cj.log.Log;
import com.phoneshopmanagementsystem.dto.BrandDTO;
import com.phoneshopmanagementsystem.model.Brand;
import com.phoneshopmanagementsystem.repository.BrandRepository;
import com.phoneshopmanagementsystem.service.BrandService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService{
	@Autowired
    private final BrandRepository brandRepository;
	@Override
	public Brand save(Brand entity) {
		// TODO Auto-generated method stub
		return brandRepository.save(entity);
	}
	@Override
	public Brand getById(Integer id) {
		// TODO Auto-generated method stub
		 Optional<Brand> findById = brandRepository.findById(id);
		 if(findById.isPresent()) {
			 return findById.get();
		 }
		 else {
			 throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("not found for id=%id", id));
		 }
		
	}
	@Override
	public Brand update(Integer id, BrandDTO dto) {
		// TODO Auto-generated method stub
		Brand brand=getById(id);
		brand.setName(dto.getName());
	
		return brandRepository.save(brand);
	}
	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Brand brand=getById(id);
		brandRepository.delete(brand);
		log.info("brand with id=%id is delete ".formatted(id));
		//log.info(String.format(null, null));
		
	}
	@Override
	public List<Brand> getList() {
		// TODO Auto-generated method stub
		List<Brand> findAll = brandRepository.findAll();
		return findAll;
	}
	

	
}
