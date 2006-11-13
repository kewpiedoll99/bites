package com.barclayadunn.database;

import com.barclayadunn.food.Intake;
import java.util.List;

public interface IntakeManagerDao {

    public List getIntakeList();

	public int addIntake(Intake intake);
}
