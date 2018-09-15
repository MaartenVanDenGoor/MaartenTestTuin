package nl.rabobank.diner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.rabobank.diner.dao.CustomerOrderRepository;
import nl.rabobank.diner.dao.MenuItemRepository;
import nl.rabobank.diner.dao.OrderItemRepository;
import nl.rabobank.diner.model.CustomerOrder;
import nl.rabobank.diner.model.MenuItem;
import nl.rabobank.diner.model.Supplier;

@RestController
public class TestController {
	@Autowired 
	private MenuItemRepository menuItemRepository;
	@Autowired 
	private OrderItemRepository orderItemRepository;
	@Autowired 
	private CustomerOrderRepository customerOrderRepository;		
    @RequestMapping("/test")
    public void test() {
        List<MenuItem> list = new ArrayList<>();
        list.add(new MenuItem("Cola",Supplier.BAR));
        list.add(new MenuItem("Fanta",Supplier.BAR));
        list.add(new MenuItem("Friet",Supplier.KITCHEN));
        list.add(new MenuItem("Falafel",Supplier.KITCHEN));
        Iterable<MenuItem> list1 = menuItemRepository.saveAll(list);
        //
		CustomerOrder customerOrder = new CustomerOrder("Jan");
		CustomerOrder co = customerOrderRepository.save(customerOrder);
		//
		
		
    }
}
