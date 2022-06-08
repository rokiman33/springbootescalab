package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.Buy;
import cl.escalab.project.adminstock.admintstock.services.BuyService;
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
@RequestMapping("/api/buy")
@CrossOrigin
public class BuyController {

    @Autowired
    BuyService buyService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Buy projectBuy, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Buy newPT = buyService.saveOrUpdate(projectBuy);

        return new ResponseEntity<Buy>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Buy> getAllBuys() {
        return buyService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Buy> getBuyById(@PathVariable Long id) {
        Buy buy = buyService.findById(id);
        return new ResponseEntity<Buy>(buy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBuy(@PathVariable Long id) {
        buyService.delete(id);
        return new ResponseEntity<String>("buy was deleted", HttpStatus.OK);
    }

}
