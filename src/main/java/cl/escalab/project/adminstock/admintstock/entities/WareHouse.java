package cl.escalab.project.adminstock.admintstock.entities;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String status;
    String details;

    public WareHouse() {
        // TODO Auto-generated constructor stub
    }

    public WareHouse(String name, String status, String details) {
        super();
        this.name = name;
        this.status = status;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
