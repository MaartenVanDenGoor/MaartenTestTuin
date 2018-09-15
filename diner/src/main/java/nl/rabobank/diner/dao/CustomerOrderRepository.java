package nl.rabobank.diner.dao;

import org.springframework.data.repository.CrudRepository;

import nl.rabobank.diner.model.CustomerOrder;

	// This will be AUTO IMPLEMENTED by Spring into a Bean called menuItemRepository
	// CRUD refers Create, Read, Update, Delete

public interface CustomerOrderRepository extends CrudRepository<CustomerOrder, Integer> {

}