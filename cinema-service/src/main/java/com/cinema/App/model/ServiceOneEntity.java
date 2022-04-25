package com.cinema.App.model;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class ServiceOneEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "description")
	private String serviceDescription;

	public ServiceOneEntity() {
	}

	public ServiceOneEntity(Integer id, String serviceDescription) {
		this.id = id;
		this.serviceDescription = serviceDescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

}