package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import lombok.Data;

@Data
@Entity
@NamedQuery(name = "HQl_transefer_indian_state_record", 
			query ="INSERT INTO com.hibernate.entity.Indian_state2(sno,State_name,State_language) "
					+ "SELECT i.sno,i.State_name,i.State_language from com.hibernate.entity.Indian_state as i WHERE i.sno>=:num")
public class Indian_state {
	@Id
	private Integer sno;
	private String State_name;
	private String State_language;
}


/*if we configure named quriey in mapping xml file
so we have to use query tag after class tag and mention also <![cdata][.......]> tag*/