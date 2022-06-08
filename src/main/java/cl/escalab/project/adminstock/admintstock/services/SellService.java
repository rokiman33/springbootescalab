package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Sell;
import cl.escalab.project.adminstock.admintstock.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellService {
    @Autowired
    SellRepository sellRepository;

    public Sell saveOrUpdate(Sell sell) {

        return sellRepository.save(sell);
    }

    public Iterable<Sell> findAll() {
        return sellRepository.findAll();
    }

    public Sell findById(Long id) {
        return sellRepository.getById(id);
    }

    public void delete(Long id) {
        Sell sell = findById(id);
        sellRepository.delete(sell);
    }
}
