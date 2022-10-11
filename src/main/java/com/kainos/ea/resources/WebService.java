package com.kainos.ea.resources;

import com.kainos.ea.dao.EmployeeDao;
import com.kainos.ea.db.DatabaseConnector;
import com.kainos.ea.model.Employee;
import com.kainos.ea.service.EmployeeService;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;

@Path("/api")
@Api("Engineering Academy Dropwizard API")
public class WebService {

    public static DatabaseConnector databaseConnector;

    public WebService() {
        databaseConnector = new DatabaseConnector();
    }

    @GET
    @Path("/employee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@PathParam("id") int employeeId) throws SQLException {

        EmployeeDao dao = new EmployeeDao();
        Connection conn = databaseConnector.getConnection();

        Employee employee = dao.selectEmployee(employeeId, conn);

        return Response
                .status(Response.Status.OK)
                .entity(employee)
                .build();
    }

    @POST
    @Path("/print")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMsg(Message message) {

        // Add employee to DB

        return Response
                .status(Response.Status.CREATED)
                .build();
    }
}
