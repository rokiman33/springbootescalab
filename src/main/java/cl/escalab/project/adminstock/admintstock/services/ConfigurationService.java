package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Configuration;
import cl.escalab.project.adminstock.admintstock.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    public Configuration saveOrUpdate(Configuration configuration) {

        return configurationRepository.save(configuration);
    }

    public Iterable<Configuration> findAll() {
        return configurationRepository.findAll();
    }

    public Configuration findById(Long id) {
        return configurationRepository.getById(id);
    }

    public void delete(Long id) {
        Configuration configuration = findById(id);
        configurationRepository.delete(configuration);
    }
}
