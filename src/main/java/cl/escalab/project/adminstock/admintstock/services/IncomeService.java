package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Income;
import cl.escalab.project.adminstock.admintstock.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeService {

    @Autowired
    IncomeRepository incomeRepository;

    public Income saveOrUpdate(Income income) {

        return incomeRepository.save(income);
    }

    public Iterable<Income> findAll() {
        return incomeRepository.findAll();
    }

    public Income findById(Long id) {
        return incomeRepository.getById(id);
    }

    public void delete(Long id) {
        Income income = findById(id);
        incomeRepository.delete(income);
    }

    public long size() {
        // TODO Auto-generated method stub
        return incomeRepository.count();
    }
}
