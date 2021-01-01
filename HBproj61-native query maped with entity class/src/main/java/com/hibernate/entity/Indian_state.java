package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
public class Indian_state {
	@Id
	private Integer sno;
	private String State_name;
	private String State_language;
}
