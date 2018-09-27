package nl.rabobank.sbbar;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import nl.rabobank.diner.model.OrderItem;

@RestController
@RequestMapping("/getdrinks")
public class GetDrinksController {

	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<List<OrderItem>>  placeorder(@RequestBody List<OrderItem> orderItems) {
		return new ResponseEntity<List<OrderItem>>(orderItems, HttpStatus.OK);
    }

}
