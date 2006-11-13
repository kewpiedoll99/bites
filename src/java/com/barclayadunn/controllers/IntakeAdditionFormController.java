package com.barclayadunn.controllers;

import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.barclayadunn.product.PriceIncrease;
import com.barclayadunn.food.IntakeManager;
import com.barclayadunn.food.Intake;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class IntakeAdditionFormController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private IntakeManager prodMan;

	// todo - make right for intake, not product prices
    public ModelAndView onSubmit(Object command) throws ServletException {

        int increase = ((PriceIncrease) command).getPercentage();
	    Intake intake = new Intake();
        logger.info("Increasing prices by " + increase + "%.");

        prodMan.increasePrice(increase);

        String now = (new java.util.Date()).toString();
        logger.info("returning from PriceIncreaseForm view to " + getSuccessView());

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

	// todo - make right for intake, not product prices
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {

        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);

        return priceIncrease;
    }

    public void setIntakeManager(IntakeManager pm) {
        prodMan = pm;
    }

    public IntakeManager getIntakeManager() {
        return prodMan;
    }
}
