package cl.escalab.project.adminstock.admintstock.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = -3942285530464977887L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String category_name;
    String status_id;
    String category_details;

    @OneToMany(cascade = CascadeType.DETACH, orphanRemoval = true)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)

    private Set<Buy> products = new HashSet<Buy>();

    public Category() {
        // TODO Auto-generated constructor stub
    }

    public Category(String category_name, String status_id, String category_details) {
        super();
        this.category_name = category_name;
        this.status_id = status_id;
        this.category_details = category_details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getCategory_details() {
        return category_details;
    }

    public void setCategory_details(String category_details) {
        this.category_details = category_details;
    }

}
