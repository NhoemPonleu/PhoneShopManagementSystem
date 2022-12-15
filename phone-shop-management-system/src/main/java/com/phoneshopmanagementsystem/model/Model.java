package com.phoneshopmanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="tblmodels")
public class Model {
	@Id
	@GeneratedValue(generator = "model_seq_generator")
	@SequenceGenerator(name="model_seq_generator",initialValue = 1,sequenceName = "model_seq")
   private Integer id;
   private String name;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="the_brand_id")
   private Brand brand;
}
