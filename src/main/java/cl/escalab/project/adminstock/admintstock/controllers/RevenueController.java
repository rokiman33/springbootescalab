package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.Revenue;
import cl.escalab.project.adminstock.admintstock.services.RevenueService;
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
@RequestMapping("/api/revenue")
@CrossOrigin
public class RevenueController {
    @Autowired
    RevenueService revenueService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Revenue projectRevenue, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Revenue newPT = revenueService.saveOrUpdate(projectRevenue);

        return new ResponseEntity<Revenue>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Revenue> getAllRevenues() {
        return revenueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Revenue> getRevenueById(@PathVariable Long id) {
        Revenue revenue = revenueService.findById(id);
        return new ResponseEntity<Revenue>(revenue, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRevenue(@PathVariable Long id) {
        revenueService.delete(id);
        return new ResponseEntity<String>("revenue was deleted", HttpStatus.OK);
    }
}
