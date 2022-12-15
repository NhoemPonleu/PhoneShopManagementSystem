package com.phoneshopmanagementsystem.serviceImpl;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.MapUtils;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.phoneshopmanagementsystem.dto.ModelDTO;
import com.phoneshopmanagementsystem.exception.ResourceNotFoundException;
import com.phoneshopmanagementsystem.model.Model;
import com.phoneshopmanagementsystem.repository.BrandRepository;
import com.phoneshopmanagementsystem.repository.ModelRepostitory;
import com.phoneshopmanagementsystem.service.BrandService;
import com.phoneshopmanagementsystem.service.ModelService;
import com.phoneshopmanagementsystem.spec.ModelFilter;
import com.phoneshopmanagementsystem.spec.ModelSpec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService{
    private final ModelRepostitory modelRepostitory;
   // private final BrandRepository brandRepository;
    private final BrandService brandService;
	@Override
	public Model save(Model dto){
		// TODO Auto-generated method stub
		//Integer id = dto.getBrandDTO().getId();
		//brandService.getById(id);
		//Model model=modelRepostitory.save(dto);
		//Model model = ModelMapper.INSTANCE.toModel(dto);
		return modelRepostitory.save(dto);
	}
	@Override
	public Model update(Integer id, ModelDTO dto){
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Model getByIdModel(Integer id) {
		 return modelRepostitory.findById(id).orElseThrow(()-> new ResourceNotFoundException("Model",id));
}
	
	public List<Model>getListmodel(Map<String ,String> params){
		ModelFilter modelFilter=new ModelFilter();
		if(params.containsKey("modelId")) {
			modelFilter.setModelId(MapUtils.getInteger(params, "modelId"));
		}
		if(params.containsKey("modelName")) {
			modelFilter.setModelName(MapUtils.getString(params, "modelName"));
		}
		if(params.containsKey("brandId")) {
			modelFilter.setBrandId(MapUtils.getInteger(params, "brandId"));
		}
		if(params.containsKey("brandName")) {
			modelFilter.setBrandName(MapUtils.getString(params, "brandName"));
		}
		ModelSpec modelSpec=new ModelSpec(modelFilter);
		return modelRepostitory.findAll(modelSpec, Sort.by(Order.asc("id")));
	}

//	public List<Model> getListModel(Map<String ,String >param) {
//		String modelName=null;
//		if(param.containsKey("name")) {
//			//param.get(name);
//			modelName=param.get("name");
//		}
//		Specification<Model> model=new Specification<Model>() {
//			
//			@Override
//			public Predicate toPredicate(Root<Model> model, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				//cb.like(model.get("name"), null)
//				if(param.containsKey("name")) {
//					//cb.like(model.get("name"), null)
//					String modelName=param.get("name");
//					Predicate equal = cb.like(model.get("name"), "%"+modelName+"%");
//					return equal;
//				}
//				// TODO Auto-generated method stub
//				return null;
//			}
//		};
//		Specification<Model> specification=( model,  query,  cb)->{
//			if(param.containsKey("name")) {
//				//cb.like(model.get("name"), null)
//			String modelName=param.get("name");
//				Predicate equal = cb.like(model.get("name"), "%"+modelName+"%");
//				return equal;
//			}
//			return null;
//		};
		//List<Model>list = modelRepostitory.findAll(specification,Sort.by(Order.asc("id")));
		// TODO Auto-generated method stub
		
		//return list;
		//return null;
	//}
}