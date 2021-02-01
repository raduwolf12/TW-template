package com.examen.model;

public class DateVal {

	private String date;
	private int row;
	
	public DateVal(){
	}
	
	public DateVal(String date, int row) {
		super();
		this.date = date;
		this.row = row;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	
}
