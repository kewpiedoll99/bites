package com.barclayadunn.food;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: bdunn
 * Date: Nov 7, 2006
 * Time: 6:08:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Intake implements Serializable {

	private int id = 0;
	private int userId = 0;
	private Date dateOfMeal = new Date();
	private int mealId = 0;
	private int foodId = 0;
	private double quantity = 0d;

	public Intake(int id, int userId, Date dateOfMeal, int mealId, int foodId, double quantity) {
		this.id = id;
		this.userId = userId;
		this.dateOfMeal = dateOfMeal;
		this.mealId = mealId;
		this.foodId = foodId;
		this.quantity = quantity;
	}

	public Intake() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getDateOfMeal() {
		return dateOfMeal;
	}

	public void setDateOfMeal(Date dateOfMeal) {
		this.dateOfMeal = dateOfMeal;
	}

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
