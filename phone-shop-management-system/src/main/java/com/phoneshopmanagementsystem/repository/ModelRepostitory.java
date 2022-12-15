package com.phoneshopmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.phoneshopmanagementsystem.model.Model;

public interface ModelRepostitory extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model>{

}
