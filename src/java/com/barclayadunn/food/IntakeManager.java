package com.barclayadunn.food;

import com.barclayadunn.database.IntakeManagerDao;
import java.io.Serializable;
import java.util.List;
import java.util.ListIterator;

public class IntakeManager implements Serializable {

	private IntakeManagerDao imd;
	private List intake;

	public void setIntakeManagerDao(IntakeManagerDao pmd) {
	    this.imd = pmd;
	}

	public List getIntake() {
		intake = imd.getIntakeList();
		return intake;
	}

	public void addIntake() {
	    ListIterator li = intake.listIterator();
	    while (li.hasNext()) {
	        Intake i = (Intake) li.next();
		    imd.addIntake(i);
	    }
	}
}
