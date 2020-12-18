package com.hibernate.composite;

import java.io.Serializable;

import lombok.Data;

@Data
public class Composite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer pid,projid;
}
