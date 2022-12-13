package com.phoneshopmanagementsystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoneshopmanagementsystem.dto.BrandDTO;
import com.phoneshopmanagementsystem.mapper.BrandMapper;
import com.phoneshopmanagementsystem.model.Brand;
import com.phoneshopmanagementsystem.service.BrandService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/brands")

public class BrandController {
	@Autowired
  private  BrandService brandService;
	@PostMapping("/create")
	public ResponseEntity<Brand>saveBrand(@RequestBody BrandDTO brandDtO){
		Brand brand=BrandMapper.INSTANCE.toEntity(brandDtO);
		brand=brandService.save(brand);
		return ResponseEntity.ok(brand);
	}
	@GetMapping("{id}")
	public ResponseEntity<Brand>getById(@PathVariable("id") Integer id){
		Brand byId = brandService.getById(id);
		return ResponseEntity.ok(byId);
	}
	@PutMapping("{id}")
	public ResponseEntity<Brand> update(@PathVariable("id") int id,@RequestBody BrandDTO brandDTO){
		return ResponseEntity.ok(brandService.update(id, brandDTO));
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?>deleteBrand(@PathVariable int id){
		brandService.delete(id);
		return ResponseEntity.ok().build();	
	}
	@GetMapping
	public ResponseEntity<?>getLIst(){
		List<Brand> list = brandService.getList();
		list.stream().map(b->BrandMapper.INSTANCE.toDTO(b)).collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
	
}
