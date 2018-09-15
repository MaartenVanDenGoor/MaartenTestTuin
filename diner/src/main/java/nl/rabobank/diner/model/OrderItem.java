package nl.rabobank.diner.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Data;
@Entity
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;	
    private Integer orderId;
    private Integer menuId;
    private Integer aantal;
    public void setOrderId(Integer orderId) {
    	this.orderId = orderId;
    }
    public OrderItem (Integer orderId, Integer menuId, Integer aantal ) {
    	this.orderId = orderId;
    	this.menuId  = menuId;
    	this.aantal  = aantal;
    }
}
