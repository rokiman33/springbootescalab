package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.Income;
import cl.escalab.project.adminstock.admintstock.services.IncomeService;
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
@RequestMapping("/api/income")
@CrossOrigin
public class IncomeController {
    @Autowired
    IncomeService incomeService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Income projectIncome, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Income newPT = incomeService.saveOrUpdate(projectIncome);

        return new ResponseEntity<Income>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Income> getAllIncomes() {
        return incomeService.findAll();
    }

    @GetMapping("/size")
    public long getIncomeSize() {
        return incomeService.size();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Income income = incomeService.findById(id);
        return new ResponseEntity<Income>(income, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteIncome(@PathVariable Long id) {
        incomeService.delete(id);
        return new ResponseEntity<String>("income was deleted", HttpStatus.OK);
    }
}
