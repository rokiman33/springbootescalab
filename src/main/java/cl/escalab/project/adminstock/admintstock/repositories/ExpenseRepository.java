package cl.escalab.project.adminstock.admintstock.repositories;

import cl.escalab.project.adminstock.admintstock.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
