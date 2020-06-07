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
	private long categoriesId;
	
	@NotBlank
	private String categoriesDesc;
	
	@NotBlank
	private String categoriesImage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date createdTstamp;

	public long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(long categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getCategoriesDesc() {
		return categoriesDesc;
	}

	public void setCategoriesDesc(String categoriesDesc) {
		this.categoriesDesc = categoriesDesc;
	}	

	public String getCategoriesImage() {
		return categoriesImage;
	}

	public void setCategoriesImage(String categoriesImage) {
		this.categoriesImage = categoriesImage;
	}

	public Date getCreatedTstamp() {
		return createdTstamp;
	}

	public void setCreatedTstamp(Date createdTstamp) {
		this.createdTstamp = createdTstamp;
	}

	
}
