package cl.escalab.project.adminstock.admintstock.controllers;

import cl.escalab.project.adminstock.admintstock.entities.Configuration;
import cl.escalab.project.adminstock.admintstock.services.ConfigurationService;
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
@RequestMapping("/api/configuration")
@CrossOrigin
public class ConfigurationController {

    @Autowired
    ConfigurationService configurationService;

    @PostMapping("/create")
    public ResponseEntity<?> addPTToBoard(@Validated @RequestBody Configuration projectConfiguration,
                                          BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            for (FieldError error : result.getFieldErrors()) {
                errorMap.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Configuration newPT = configurationService.saveOrUpdate(projectConfiguration);

        return new ResponseEntity<Configuration>(newPT, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Configuration> getAllConfigurations() {
        return configurationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Configuration> getConfigurationById(@PathVariable Long id) {
        Configuration configuration = configurationService.findById(id);
        return new ResponseEntity<Configuration>(configuration, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteConfiguration(@PathVariable Long id) {
        configurationService.delete(id);
        return new ResponseEntity<String>("configuration was deleted", HttpStatus.OK);
    }
}
