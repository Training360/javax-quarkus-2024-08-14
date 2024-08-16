package training;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EmployeeService {

    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<EmployeeDto> listEmployees() {
        return employeesRepository.findAll()
                .stream()
                .map(entity -> new EmployeeDto(entity.getId(), entity.getName()))
                .toList();
    }

@Transactional
    public EmployeeDto createEmployee(EmployeeDto employee) {
        var entity = new Employee();
        entity.setName(employee.name());

        employeesRepository.persist(entity);

        return new EmployeeDto(entity.getId(), entity.getName());
    }
}
