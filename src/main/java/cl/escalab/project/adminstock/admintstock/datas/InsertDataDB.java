package cl.escalab.project.adminstock.admintstock.datas;

import cl.escalab.project.adminstock.admintstock.entities.*;
import cl.escalab.project.adminstock.admintstock.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertDataDB {

    @Autowired
    SupplierRepository repositorySupplierRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    SellRepository sellRepository;
    @Autowired
    RevenueRepository revenueRepository;
    @Autowired
    BuyRepository buyRepository;
    @Autowired
    ConfigurationRepository configurationRepository;
    @Autowired
    WareHouseRepository wareHouseRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public InsertDataDB() {
        // TODO Auto-generated constructor stub
    }

    public void populate() {
        Supplier supplier = new Supplier("SPDigital", "55555555", "contacto@spdigital.cl", "SPDIGITAL", "Santiago, Chile",
                "Active", "N/A");
        Client client = new Client("Richard Diaz", "987979970", "Santiago", "rdo@gmail.com", "Active", "N/A");
        Category category = new Category("SmartPhone", "Active", "void");
        Product product = new Product("IPhone 12 Pro", category, supplier, "unit", "10", "392500", "789000", "123JNU8H7", "19",
                "warehouse", "N/A", "iphoneH78HHO");
        Expense expense = new Expense("12/09/2022", supplier, "Efectivo", "1000675786", "86965", "N/A");
        Sell sell = new Sell(client, "12/09/2022", "Active", "123JNU8H7");
        Revenue revenue = new Revenue("23/08/2022", client, "type", "1000675786", "789000", "N/A");
        Buy buy = new Buy(supplier, product, "23/10/2020", "#O989", "pending");
        Configuration configuration = new Configuration("AdmStock", "contact@spdigital.cl", "Santiago, Chile", "Spanish", "CLP");
        Employee employee = new Employee("Francisca Arregui", "fcaArregui10@gmail.com", "7656760909", "Santiago, Chile", "active");
        WareHouse wareHouse = new WareHouse("WareHouse 005", "Active", "void");
        repositorySupplierRepository.save(supplier);
        clientRepository.save(client);
        categoryRepository.save(category);
        productRepository.save(product);
        expenseRepository.save(expense);
        sellRepository.save(sell);
        revenueRepository.save(revenue);
        buyRepository.save(buy);
        configurationRepository.save(configuration);
        employeeRepository.save(employee);
        wareHouseRepository.save(wareHouse);
    }
}
