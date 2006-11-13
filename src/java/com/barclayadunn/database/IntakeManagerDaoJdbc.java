package com.barclayadunn.database;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.core.SqlParameter;
import javax.sql.DataSource;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Date;
import com.barclayadunn.food.Intake;

public class IntakeManagerDaoJdbc implements IntakeManagerDao {

    protected final Log logger = LogFactory.getLog(getClass());
    private DataSource ds;

    public List getIntakeList() {
        logger.info("Getting intake!");
        IntakeManagerDaoJdbc.IntakeQuery iq = new IntakeManagerDaoJdbc.IntakeQuery(ds);
        return iq.execute();
    }

	public int addIntake(Intake intake) {
		// use IntakeAddition to add the new intake to the user's data
		// return number of rows affected. 0 means nothing added.
		IntakeAddition intakeAddition = new IntakeAddition(ds);
		intakeAddition.init();
		Object[] oa = new Object[5];
		oa[0] = new Integer(intake.getUserId());
		oa[1] = new Date(intake.getDateOfMeal().getTime());
		oa[2] = new Integer(intake.getMealId());
		oa[3] = new Integer(intake.getFoodId());
		oa[4] = new Double(intake.getQuantity());
		int count = intakeAddition.update(oa);
		logger.info("Rows affected: " + count);
		return count;
	}

    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }


    class IntakeQuery extends MappingSqlQuery {
        IntakeQuery(DataSource ds) {
            super(ds, "SELECT id, user_id, date_of_meal, meal_id, food_id, quantity " +
		            "from intake order by user_id, date_of_meal desc, meal_id asc");
            compile();
        }

        protected Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Intake(rs.getInt("id"), rs.getInt("user_id"),
		            rs.getDate("date_of_meal"), rs.getInt("meal_id"), rs.getInt("food_id"),
		            rs.getInt("quantity"));
        }
    }


	class IntakeAddition extends SqlUpdate {
		IntakeAddition(DataSource ds) {
			super(ds, "INSERT INTO intake (user_id, date_of_meal, meal_id, food_id, " +
					"quantity) VALUES (?, ?, ?, ?, ?)");
		}

		void init() {
			this.declareParameter(new SqlParameter("userId", Types.INTEGER));
			this.declareParameter(new SqlParameter("dateOfMeal", Types.DATE));
			this.declareParameter(new SqlParameter("mealId", Types.INTEGER));
			this.declareParameter(new SqlParameter("foodId", Types.INTEGER));
			this.declareParameter(new SqlParameter("quantity", Types.INTEGER));
			this.declareParameter(new SqlParameter("id", Types.INTEGER));
			compile();
		}
	}
}
