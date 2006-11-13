package com.barclayadunn.food;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: bdunn
 * Date: Nov 3, 2006
 * Time: 4:46:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Food implements Serializable {

	private int id = 0;
	private String description = "";
	private int calories = 0;
	private double fat = 0d;
	private double fiber = 0d;
	private int measureId = 0;

	public Food(int id, String description, int calories, double fat, double fiber, int measure_id) {
		this.id = id;
		this.description = description;
		this.calories = calories;
		this.fat = fat;
		this.fiber = fiber;
		this.measureId = measure_id;
	}

	public Food() {
		super();
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

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getFiber() {
		return fiber;
	}

	public void setFiber(double fiber) {
		this.fiber = fiber;
	}

	public int getMeasureId() {
		return measureId;
	}

	public void setMeasureId(int measureId) {
		this.measureId = measureId;
	}
}