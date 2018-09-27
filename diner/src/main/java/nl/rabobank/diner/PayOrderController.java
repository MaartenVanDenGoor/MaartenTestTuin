package nl.rabobank.diner;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import nl.rabobank.diner.dao.CustomerOrderRepository;
import nl.rabobank.diner.model.CustomerOrder;

@RestController
public class PayOrderController {
	@Autowired 
	private CustomerOrderRepository customerOrderRepository;
	@RequestMapping("/payorder")	
    public ResponseEntity<CustomerOrder>  payorder(@RequestBody  int orderNo) {
    	Optional<CustomerOrder> opt = customerOrderRepository.findById(orderNo);
    	CustomerOrder co = null;
    	// If the order is present and not paid then update paidInFull to true
    	if (opt.isPresent() &&
    	     !opt.get().isPaidInFull() ) {
    		co = opt.get();
    		co.setPaidInFull(true);
    		customerOrderRepository.save(co);
    		return new ResponseEntity<CustomerOrder>(co, HttpStatus.OK);
    	} else {
    		// return error
    		return new ResponseEntity<CustomerOrder>(co, HttpStatus.NOT_FOUND);
    	}

    }
}
