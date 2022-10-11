package com.kainos.ea.service;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.DatabaseConnector;
import com.kainos.ea.model.Employee;

import java.sql.SQLException;

public class EmployeeService {

    public DatabaseConnector databaseConnector;

    public EmployeeService(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public Employee getEmployee(int employeeId) throws SQLException {
        EmployeeDao dao = new EmployeeDao();

        return dao.selectEmployee(employeeId, databaseConnector.getConnection());
    }

}
