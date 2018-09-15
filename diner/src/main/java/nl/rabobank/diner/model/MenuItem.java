package nl.rabobank.diner.model;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
public class MenuItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(name = "supplier")
    @Enumerated(EnumType.STRING)
    private Supplier supplier;
	private String   name;
    public MenuItem(String   name,Supplier supplier) {
    	this.name     = name;
    	this.supplier = supplier;
    }
}
