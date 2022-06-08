package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Employee;
import cl.escalab.project.adminstock.admintstock.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveOrUpdate(Employee employee) {

        return employeeRepository.save(employee);
    }

    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.getById(id);
    }

    public void delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }

    public long count() {
        return employeeRepository.count();
    }
}
