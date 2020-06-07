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
@Table(name="Item_Profile")
@EntityListeners(AuditingEntityListener.class)

public class ItemProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long itemId;
	
	@NotBlank
	private String itemShortDesc;
	
	@NotBlank
	private String itemLongDesc;
	
	private int itemPrice;
	
	@NotBlank
	private String itemCoo;
	
	@NotBlank
	private String itemImage;
	
	
	private long subCategoriesId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	public Date createdTstamp;

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemShortDesc() {
		return itemShortDesc;
	}

	public void setItemShortDesc(String itemShortDesc) {
		this.itemShortDesc = itemShortDesc;
	}

	public String getItemLongDesc() {
		return itemLongDesc;
	}

	public void setItemLongDesc(String itemLongDesc) {
		this.itemLongDesc = itemLongDesc;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemCoo() {
		return itemCoo;
	}

	public void setItemCoo(String itemCoo) {
		this.itemCoo = itemCoo;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public long getSubCategoriesId() {
		return subCategoriesId;
	}

	public void setSubCategoriesId(long subCategoriesId) {
		this.subCategoriesId = subCategoriesId;
	}

	public Date getCreatedTstamp() {
		return createdTstamp;
	}

	public void setCreatedTstamp(Date createdTstamp) {
		this.createdTstamp = createdTstamp;
	}

	
	
}
