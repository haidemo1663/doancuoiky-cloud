package com.doancuoiki.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.doancuoiki.demo.Entity.Customer;
import com.doancuoiki.demo.Repository.CustomerRepository;

@RestController
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping("/customers")
public class CustomerController {
	private CustomerRepository customerRepository;
	public CustomerController( CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	@GetMapping("/all")
	public List<Customer> getAllCustomer(){
		List<Customer> customer=this.customerRepository.findAll();
		return customer;
	}
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") String id) {
		Optional<Customer> customer=this.customerRepository.findById(id);
		if(!customer.isPresent()) {
			return new Customer();
		}
		else return customer.get();
	}
	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer) {
		this.customerRepository.insert(customer);
	}
	@PostMapping("/update/{id}")
	public void updateCustomer(@RequestBody Customer ncustomer, @PathVariable("id") String id) {
		Optional<Customer> customer=this.customerRepository.findById(id);
		customer.get().setName(ncustomer.getName());
		customer.get().setAddress(ncustomer.getAddress());
		customer.get().setPhone(ncustomer.getPhone());
		this.customerRepository.save(customer.get());
	}
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable("id") String id) {
		this.customerRepository.deleteById(id);
	}
}
