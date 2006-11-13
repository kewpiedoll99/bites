package com.barclayadunn.food;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class IntakeAddition {

	protected final Log logger = LogFactory.getLog(getClass());
	private Intake intake;

	public Intake getIntake() {
		return intake;
	}

	public void setIntake(Intake intake) {
		this.intake = intake;
		logger.info("Intake set to " + intake);
	}
}
