package com.ee417.website.group.models;

import java.time.LocalDate;

/**
 * @author Peter Staunton
 * @date 06/04/2024
 * @category model
 * Provides object to interact with clients
 */
public class CampusOccupancy {
	private long id;
	private LocalDate time_date;
	private TrafficType type;
	private int num_in;
	private int num_out;
	
	/**
	 * @param id, time_date, type, num_in, num_out
	 */
	public CampusOccupancy(long id, LocalDate time_date, TrafficType type, int num_in, int num_out) {
		super();
		this.id = id;
		this.time_date = time_date;
		this.type = type;
		this.num_in = num_in;
		this.num_out = num_out;
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LocalDate getTime_date() {
		return time_date;
	}
	public void setTime_date(LocalDate time_date) {
		this.time_date = time_date;
	}
	public TrafficType getType() {
		return type;
	}
	public void setType(TrafficType type) {
		this.type = type;
	}
	public int getNum_in() {
		return num_in;
	}
	public void setNum_in(int num_in) {
		this.num_in = num_in;
	}
	public int getNum_out() {
		return num_out;
	}
	public void setNum_out(int num_out) {
		this.num_out = num_out;
	}
}
