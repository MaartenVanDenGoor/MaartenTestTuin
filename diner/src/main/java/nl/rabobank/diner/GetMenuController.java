package nl.rabobank.diner;
import org.springframework.web.bind.annotation.*;

import nl.rabobank.diner.dao.MenuItemRepository;
import nl.rabobank.diner.model.Menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
@RestController
public class GetMenuController {
	@Autowired 
	private MenuItemRepository menuItemRepository;
    @RequestMapping("/getmenu")
    public Menu getMenu() {
        Menu menu = new Menu();
    	menuItemRepository.findAll().forEach(menu::add);  
        return menu;	
    }
}
