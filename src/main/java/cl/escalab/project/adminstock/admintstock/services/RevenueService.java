package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Revenue;
import cl.escalab.project.adminstock.admintstock.repositories.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RevenueService {

    @Autowired
    RevenueRepository revenueRepository;

    public Revenue saveOrUpdate(Revenue revenue) {

        return revenueRepository.save(revenue);
    }

    public Iterable<Revenue> findAll() {
        return revenueRepository.findAll();
    }

    public Revenue findById(Long id) {
        return revenueRepository.getById(id);
    }

    public void delete(Long id) {
        Revenue revenue = findById(id);
        revenueRepository.delete(revenue);
    }
}
