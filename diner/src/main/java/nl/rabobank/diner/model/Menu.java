package nl.rabobank.diner.model;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Menu {
	private List<MenuItem> menuItems = new ArrayList<>();

	{
	}
	public void add(MenuItem menuItem) {
		menuItems.add(menuItem);
	}
}
