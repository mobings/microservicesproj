package com.movie.App.model;

import javax.persistence.*;

//@Entity
//@Table(name = "Cinema")
public class Cinema {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "C_name")
	private String C_name;

	@Column(name = "C_city")
	private String C_city;

	@Column(name = "C_start_dat")
	private String C_start_dat;
	
	
	@Column(name = "MID")
	private long MID;

	@Column(name = "C_boxoffice")
	private long C_boxoffice;
	
	
	public String getC_name() {
		return C_name;
	}







	public void setC_name(String c_name) {
		this.C_name = c_name;
	}







	public String getC_city() {
		return C_city;
	}







	public void setC_city(String c_city) {
		this.C_city = c_city;
	}







	public String getC_start_dat() {
		return C_start_dat;
	}







	public void setC_start_dat(String c_start_dat) {
		this.C_start_dat = c_start_dat;
	}







	public long getMID() {
		return MID;
	}







	public void setMID(long MID) {
		this.MID = MID;
	}







	public long getC_boxoffice() {
		return C_boxoffice;
	}







	public void setC_boxoffice(long c_boxoffice) {
		this.C_boxoffice = c_boxoffice;
	}



public Cinema() {};





	public Cinema(String c_name, String c_city, String c_start_dat, long MID, long c_boxoffice) {
		super();
	
		this.C_name = c_name;
		this.C_city = c_city;
		this.C_start_dat = c_start_dat;
		this.MID = MID;
		this.C_boxoffice = c_boxoffice;
	}



}
