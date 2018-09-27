package nl.rabobank.diner;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import nl.rabobank.diner.dao.CustomerOrderRepository;
import nl.rabobank.diner.dao.OrderItemRepository;
import nl.rabobank.diner.model.CustomerOrder;
import nl.rabobank.diner.model.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/placeorder")
public class PlaceOrderController {
	@Autowired 
	private OrderItemRepository orderItemRepository;
	@Autowired 
	private CustomerOrderRepository customerOrderRepository;	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerOrder>  placeorder(@RequestBody List<OrderItem> orderItems, String customer) {
		
		// Create new Master Record CustomerOrder
		CustomerOrder customerOrder = new CustomerOrder(customer);
		CustomerOrder co = customerOrderRepository.save(customerOrder);
		
		// Add CustomerOrder.Id to each orderItem
		orderItems.forEach(oi -> oi.setOrderId(co.getId()));
	    orderItemRepository.saveAll(orderItems);

	    
	   //   return created CustomerOrder
	    return new ResponseEntity<CustomerOrder>(customerOrder, HttpStatus.OK);
    }
}
