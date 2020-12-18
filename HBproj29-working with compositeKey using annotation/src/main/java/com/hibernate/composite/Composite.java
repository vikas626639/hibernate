package com.hibernate.composite;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Composite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer pid,projid;
}
