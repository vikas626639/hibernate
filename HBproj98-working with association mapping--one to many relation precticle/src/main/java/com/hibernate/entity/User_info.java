package com.hibernate.entity;

import java.util.Set;

import lombok.Data;

@Data
public class User_info {
	private Integer user_id;
	private String user_name;
	private String address;
	private Set<Phone_Number> phone;
}
