package com.phoneshopmanagementsystem.service;

import java.util.List;
import java.util.Map;

import com.phoneshopmanagementsystem.dto.ModelDTO;
import com.phoneshopmanagementsystem.exception.ApiException;
import com.phoneshopmanagementsystem.model.Model;

public interface ModelService {
  Model save(Model entity);
   Model update(Integer id, ModelDTO dto) ;
   Model getByIdModel(Integer id);
   List<Model>getListmodel(Map<String ,String> param);
//Model save(Model entity) throws ApiException;
//Model save(Model model) throws ApiException;
//Model save(ModelDTO dto) throws ApiException;
//Model save(ModelDTO dto);
//List<Model> getListModel();
}
