package com.phoneshopmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tblBrand")
@Data
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_seq_generator")
	@SequenceGenerator(name="brand_seq_generator",initialValue = 1,sequenceName = "brand_seq")
  private Integer id;
  private String name;
 // private String model;
  
}
