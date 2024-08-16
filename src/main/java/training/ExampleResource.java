package training;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/employees")
public class ExampleResource {

    private final EmployeeService employeeService;

    public ExampleResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeDto> findAll() {
        return employeeService.listEmployees();

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeDto create(EmployeeDto employeeDto) {
        Log.infof("Creating employee %s", employeeDto);
        return employeeService.createEmployee(employeeDto);
    }
}
