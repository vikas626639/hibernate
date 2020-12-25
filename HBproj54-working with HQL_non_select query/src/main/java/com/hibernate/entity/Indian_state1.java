package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Indian_state1 {
	@Id
	private Integer sno;
	private String State_name;
	private String State_language;
}
