package com.barclayadunn.food;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: bdunn
 * Date: Nov 7, 2006
 * Time: 6:13:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Measure implements Serializable {

	private int id = 0;
	private String description = "";

	public Measure(int id, String description) {
		this.id = id;
		this.description = description;
	}

	public Measure() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
