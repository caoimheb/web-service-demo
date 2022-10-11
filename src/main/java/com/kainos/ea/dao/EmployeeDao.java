package com.kainos.ea.dao;

import com.kainos.ea.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

    public Employee selectEmployee(int employeeId, Connection c) throws SQLException {

        String selectEmployeeQuery = "SELECT EmployeeID, EmployeeName FROM Employee WHERE EmployeeID = ?";

        PreparedStatement preparedStmt = c.prepareStatement(selectEmployeeQuery);
        preparedStmt.setInt(1, employeeId);

        preparedStmt.execute();
        ResultSet rs = preparedStmt.getResultSet();

        Employee dbEmp = null;

        while (rs.next()) {
            dbEmp = new Employee(
                    (short) rs.getInt("EmployeeID"),
                    10000,
                    rs.getString("EmployeeName")
            );
        }
        return dbEmp;
    }
}
