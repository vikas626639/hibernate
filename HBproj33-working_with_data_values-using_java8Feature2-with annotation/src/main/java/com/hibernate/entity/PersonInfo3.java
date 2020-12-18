package com.hibernate.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import net.bytebuddy.asm.Advice.Local;

@Data
@Entity
public class PersonInfo3 implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "gen2",strategy = "identity")
	@GeneratedValue(generator = "gen2")
	private Integer personid;
	private String person_name;
	private String person_addrs;
	//working with java8 feature localData
	private LocalDateTime dob;
	private LocalDateTime doj;
	private LocalDate dom;
}
