package cl.escalab.project.adminstock.admintstock.services;

import cl.escalab.project.adminstock.admintstock.entities.Expense;
import cl.escalab.project.adminstock.admintstock.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Expense saveOrUpdate(Expense expense) {

        return expenseRepository.save(expense);
    }

    public Iterable<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Expense findById(Long id) {
        return expenseRepository.getById(id);
    }

    public void delete(Long id) {
        Expense expense = findById(id);
        expenseRepository.delete(expense);
    }

    public long size() {
        // TODO Auto-generated method stub
        return expenseRepository.count();
    }

}
