package com.barclayadunn.controllers;

import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import com.barclayadunn.product.ProductManager;

public class FoodController implements Controller {

	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager prodMan;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("\nFoodController - returning hello view");

		String now = (new java.util.Date()).toString();
		logger.info("returning hello view with " + now);

		Map myModel = new HashMap();
		myModel.put("now", now);
		myModel.put("products", getProductManager().getProducts());

		return new ModelAndView("hello", "model", myModel);
	}

	public void setProductManager(ProductManager pm) {
		prodMan = pm;
	}

	public ProductManager getProductManager() {
		return prodMan;
	}
}