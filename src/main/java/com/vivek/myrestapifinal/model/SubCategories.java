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
@Table(name="Sub_Categories")
@EntityListeners(AuditingEntityListener.class)

public class SubCategories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long SubCategoriesId;
	
	@NotBlank
	private String SubCategoriesDesc;
	
	@NotBlank
	private String subCategoriesImage;
	
	private Long categoriesId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date createdTstamp;

	public long getSubCategoriesId() {
		return SubCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		SubCategoriesId = subCategoriesId;
	}

	public String getSubCategoriesDesc() {
		return SubCategoriesDesc;
	}

	public void setSubCategoriesDesc(String subCategoriesDesc) {
		SubCategoriesDesc = subCategoriesDesc;
	}

	public Long getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(Long categoriesId) {
		this.categoriesId = categoriesId;
	}

	public Date getCreatedTstamp() {
		return createdTstamp;
	}

	public void setCreatedTstamp(Date createdTstamp) {
		this.createdTstamp = createdTstamp;
	}

	public String getSubCategoriesImage() {
		return subCategoriesImage;
	}

	public void setSubCategoriesImage(String subCategoriesImage) {
		this.subCategoriesImage = subCategoriesImage;
	}
}
