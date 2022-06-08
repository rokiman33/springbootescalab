package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.WareHouse;
import cl.escalab.project.adminstock.admintstock.services.WareHouseService;
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
@RequestMapping("/api/warehouse")
@CrossOrigin
public class WareHouseController {

    @Autowired
    WareHouseService wareHouseService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody WareHouse projectWareHouse, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        WareHouse newPT = wareHouseService.saveOrUpdate(projectWareHouse);

        return new ResponseEntity<WareHouse>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<WareHouse> getAllWareHouses() {
        return wareHouseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<WareHouse> getWareHouseById(@PathVariable Long id) {
        WareHouse wareHouse = wareHouseService.findById(id);
        return new ResponseEntity<WareHouse>(wareHouse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteWareHouse(@PathVariable Long id) {
        wareHouseService.delete(id);
        return new ResponseEntity<String>("wareHouse was deleted", HttpStatus.OK);
    }
}
