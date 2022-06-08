package cl.escalab.project.adminstock.admintstock.repositories;

import cl.escalab.project.adminstock.admintstock.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
