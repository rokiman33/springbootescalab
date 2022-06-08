package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.Sell;
import cl.escalab.project.adminstock.admintstock.services.SellService;
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
@RequestMapping("/api/sell")
@CrossOrigin
public class SellController {

    @Autowired
    SellService sellService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Sell projectSell, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Sell newPT = sellService.saveOrUpdate(projectSell);

        return new ResponseEntity<Sell>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Sell> getAllSells() {
        return sellService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sell> getSellById(@PathVariable Long id) {
        Sell sell = sellService.findById(id);
        return new ResponseEntity<Sell>(sell, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSell(@PathVariable Long id) {
        sellService.delete(id);
        return new ResponseEntity<String>("sell was deleted", HttpStatus.OK);
    }
}
