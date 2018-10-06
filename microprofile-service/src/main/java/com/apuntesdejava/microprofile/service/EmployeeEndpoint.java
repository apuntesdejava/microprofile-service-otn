package com.apuntesdejava.microprofile.service;

import com.apuntesdejava.microprofile.entity.Employee;
import com.apuntesdejava.microprofile.repository.EmployeeRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author Diego Silva <diego.silva@apuntesdejava.com>
 */
@ApplicationScoped
@Produces(APPLICATION_JSON)
@Path("employees")
public class EmployeeEndpoint {

    @Inject
    private EmployeeRepository employeeRepository;

    @GET
    public Response findAll(
            @QueryParam("start") @DefaultValue("0") int start,
            @QueryParam("limit") @DefaultValue("0") int limit
    ) {
        List<Employee> employees
                = (start >= 0 && limit > 0) //si se envían parámetros
                        ? employeeRepository.findRange(start, limit) //... tomar un rango
                        : employeeRepository.findAll(); //... sino tomar todos
        return Response.ok(employees).build();
    }
}
