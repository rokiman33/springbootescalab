package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.WareHouse;
import cl.escalab.project.adminstock.admintstock.repositories.WareHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;

    public WareHouse saveOrUpdate(WareHouse wareHouse) {

        return wareHouseRepository.save(wareHouse);
    }

    public Iterable<WareHouse> findAll() {
        return wareHouseRepository.findAll();
    }

    public WareHouse findById(Long id) {
        return wareHouseRepository.getById(id);
    }

    public void delete(Long id) {
        WareHouse wareHouse = findById(id);
        wareHouseRepository.delete(wareHouse);
    }
}
