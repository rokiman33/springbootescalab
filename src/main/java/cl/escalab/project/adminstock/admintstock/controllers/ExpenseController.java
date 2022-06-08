package cl.escalab.project.adminstock.admintstock.controllers;


import cl.escalab.project.adminstock.admintstock.entities.Expense;
import cl.escalab.project.adminstock.admintstock.services.ExpenseService;
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
@RequestMapping("/api/expense")
@CrossOrigin
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Expense projectExpense, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Expense newPT = expenseService.saveOrUpdate(projectExpense);

        return new ResponseEntity<Expense>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Expense> getAllExpenses() {
        return expenseService.findAll();
    }

    @GetMapping("/size")
    public long getExpenseSize() {
        return expenseService.size();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Expense expense = expenseService.findById(id);
        return new ResponseEntity<Expense>(expense, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.delete(id);
        return new ResponseEntity<String>("expense was deleted", HttpStatus.OK);
    }


}
