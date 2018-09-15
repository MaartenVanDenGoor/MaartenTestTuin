package nl.rabobank.diner.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;
@Entity
@Data
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;	
    private String  name;
    private boolean paidInFull = false;
    
    public CustomerOrder(String name) {
    	this.name = name;
    }
    public Integer getId() {
    	return id;
    }
}
