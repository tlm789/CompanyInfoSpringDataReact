package com.tessamarelic.CompanyInfoSpringDataReact;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class CompanyIdentity implements Serializable {
	
	private @Id Long id; //auto generated primary key
	
	@NotNull
	@Size(max = 60)
	private String idName;
	
	public CompanyIdentity() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}
	
	
}
