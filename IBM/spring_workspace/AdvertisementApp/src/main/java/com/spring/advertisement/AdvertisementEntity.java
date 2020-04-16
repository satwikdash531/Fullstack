package com.spring.advertisement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spring.user.UserEntity;

@Entity
@Table(name = "ADVERTISES")
public class AdvertisementEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue
	@Id
	@Column(name = "ADV_ID")
	private long advId;
	@Column(name = "POST_ID")
	private String postId;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;
	
	public AdvertisementEntity() {
		
	}
	public AdvertisementEntity(long advId, String postId, String status, String title, String name, String category,
			String description) {
		super();
		this.advId = advId;
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public AdvertisementEntity(String postId, String status, String title, String name, String category,
			String description) {
		super();
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
	}
	public long getAdvId() {
		return advId;
	}
	public void setAdvId(long advId) {
		this.advId = advId;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Advertisement [advId=" + advId + ", postId=" + postId + ", status=" + status + ", title=" + title
				+ ", name=" + name + ", category=" + category + ", description=" + description + "]";
	}
	
	
	

}
