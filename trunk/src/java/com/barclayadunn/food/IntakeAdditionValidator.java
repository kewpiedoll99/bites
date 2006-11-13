package com.barclayadunn.food;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.barclayadunn.product.PriceIncrease;

public class IntakeAdditionValidator implements Validator {

	private int DEFAULT_MIN_PERCENTAGE = 0;
	private int DEFAULT_MAX_PERCENTAGE = 50;
	private int minPercentage = DEFAULT_MIN_PERCENTAGE;
	private int maxPercentage = DEFAULT_MAX_PERCENTAGE;
	protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
		return clazz.equals(PriceIncrease.class);
	}

	// todo - make right for intake, not product prices
	public void validate(Object obj, Errors errors) {
		PriceIncrease pi = (PriceIncrease) obj;
		if (pi == null) {
			errors.rejectValue("percentage", "error.not-specified", null, "Value required.");
		} else {
			logger.info("Validating with " + pi + ": " + pi.getPercentage());
			if (pi.getPercentage() > maxPercentage) {
				errors.rejectValue("percentage", "error.too-high",
						new Object[]{new Integer(maxPercentage)}, "Value too high.");
			}
			if (pi.getPercentage() <= minPercentage) {
				errors.rejectValue("percentage", "error.too-low",
						new Object[]{new Integer(minPercentage)}, "Value too low.");
			}
		}
	}

	// todo - make right for intake, not product prices
	public void setMinPercentage(int i) {
		minPercentage = i;
	}

	// todo - make right for intake, not product prices
	public int getMinPercentage() {
		return minPercentage;
	}

	// todo - make right for intake, not product prices
	public void setMaxPercentage(int i) {
		maxPercentage = i;
	}

	// todo - make right for intake, not product prices
	public int getMaxPercentage() {
		return maxPercentage;
	}
}
