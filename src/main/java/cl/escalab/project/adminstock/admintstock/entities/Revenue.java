package cl.escalab.project.adminstock.admintstock.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "revenue")
public class Revenue implements Serializable {

    private static final long serialVersionUID = 5934032785346540901L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String income_paymentDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    Client customer_id;

    String income_paymentType;
    String income_paymentAccount;
    String income_amount;
    String income_details;

    public Revenue() {
        // TODO Auto-generated constructor stub
    }

    public Revenue(String income_paymentDate, Client customer_id, String income_paymentType,
                   String income_paymentAccount, String income_amount, String income_details) {
        super();
        this.income_paymentDate = income_paymentDate;
        this.customer_id = customer_id;
        this.income_paymentType = income_paymentType;
        this.income_paymentAccount = income_paymentAccount;
        this.income_amount = income_amount;
        this.income_details = income_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncome_paymentDate() {
        return income_paymentDate;
    }

    public void setIncome_paymentDate(String income_paymentDate) {
        this.income_paymentDate = income_paymentDate;
    }

    public Client getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Client customer_id) {
        this.customer_id = customer_id;
    }

    public String getIncome_paymentType() {
        return income_paymentType;
    }

    public void setIncome_paymentType(String income_paymentType) {
        this.income_paymentType = income_paymentType;
    }

    public String getIncome_paymentAccount() {
        return income_paymentAccount;
    }

    public void setIncome_paymentAccount(String income_paymentAccount) {
        this.income_paymentAccount = income_paymentAccount;
    }

    public String getIncome_amount() {
        return income_amount;
    }

    public void setIncome_amount(String income_amount) {
        this.income_amount = income_amount;
    }

    public String getIncome_details() {
        return income_details;
    }

    public void setIncome_details(String income_details) {
        this.income_details = income_details;
    }


}
