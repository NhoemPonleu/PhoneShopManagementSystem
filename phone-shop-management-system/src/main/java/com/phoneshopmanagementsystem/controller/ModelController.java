package com.phoneshopmanagementsystem.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phoneshopmanagementsystem.dto.ModelDTO;
import com.phoneshopmanagementsystem.exception.ApiException;
import com.phoneshopmanagementsystem.mapper.ModelMapper;
import com.phoneshopmanagementsystem.model.Model;
import com.phoneshopmanagementsystem.service.ModelService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/models")
@RequiredArgsConstructor
public class ModelController {
  private final ModelService modelService;
 // private final ModelMapper modelMapper;
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO dto){
		Model model = ModelMapper.INSTANCE.toModel(dto);
		modelService.save(model);
		return ResponseEntity.ok(model);
	}
	@GetMapping("{id}")
	public ResponseEntity<?>getById(@PathVariable("id") Integer id) throws ApiException{
		Model byId = modelService.getByIdModel(id);
		return ResponseEntity.ok(ModelMapper.INSTANCE.toDTO(byId));
	}
	@GetMapping
	public ResponseEntity<?>getModelList(@RequestParam Map<String,String> param){
		List<ModelDTO> listModel = modelService.getListmodel(param).stream().map(m->ModelMapper.INSTANCE.toDTO(m)).toList();
		return ResponseEntity.ok(listModel);
	}
}
