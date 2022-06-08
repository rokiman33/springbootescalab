package cl.escalab.project.adminstock.admintstock.controllers;


import cl.escalab.project.adminstock.admintstock.entities.Employee;
import cl.escalab.project.adminstock.admintstock.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Employee projectEmployee, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Employee newPT = employeeService.saveOrUpdate(projectEmployee);

        return new ResponseEntity<Employee>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/size")
    public long getEmployeeSize() {
        return employeeService.count();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return new ResponseEntity<String>("employee was deleted", HttpStatus.OK);
    }
}
