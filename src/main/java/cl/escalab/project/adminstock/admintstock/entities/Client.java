package cl.escalab.project.adminstock.admintstock.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = -874579554809953800L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String customer_name;
    String customer_phone;
    String customer_address;
    String customer_email;
    String status_id;
    String customer_description;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Sell> sells = new HashSet<Sell>();

    @OneToMany(cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Revenue> employees = new HashSet<Revenue>();

    public Client() {
        // TODO Auto-generated constructor stub
    }

    public Client(String customer_name, String customer_phone, String customer_address, String customer_email,
                  String status_id, String customer_description) {
        super();
        this.customer_name = customer_name;
        this.customer_phone = customer_phone;
        this.customer_address = customer_address;
        this.customer_email = customer_email;
        this.status_id = status_id;
        this.customer_description = customer_description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getCustomer_description() {
        return customer_description;
    }

    public void setCustomer_description(String customer_description) {
        this.customer_description = customer_description;
    }


}
