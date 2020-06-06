package com.vivek.myrestapifinal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Categories")
@EntityListeners(AuditingEntityListener.class)

public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long categorId;
	
	@NotBlank
	private String categoryDesc;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date createTstamp;

	public long getCategorId() {
		return categorId;
	}

	public void setCategorId(long id) {
		this.categorId = categorId;
	}

	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	public Date getCreateTstamp() {
		return createTstamp;
	}

	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}	

}
