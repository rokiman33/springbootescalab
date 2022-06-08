package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Buy;
import cl.escalab.project.adminstock.admintstock.repositories.BuyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyService {

    @Autowired
    BuyRepository buyRepository;

    public Buy saveOrUpdate(Buy buy) {

        return buyRepository.save(buy);
    }

    public Iterable<Buy> findAll() {
        return buyRepository.findAll();
    }

    public Buy findById(Long id) {
        return buyRepository.getById(id);
    }

    public void delete(Long id) {
        Buy buy = findById(id);
        buyRepository.delete(buy);
    }
}
