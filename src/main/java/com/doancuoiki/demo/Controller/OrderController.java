package com.doancuoiki.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.doancuoiki.demo.Entity.Order;
import com.doancuoiki.demo.Repository.OrderRepository;
@RestController
@CrossOrigin(origins="http://localhost:8081")
@RequestMapping("/orders")
public class OrderController {
	private OrderRepository orderRepository;
	public OrderController(OrderRepository orderRepository) {
		this.orderRepository=orderRepository;
	}
	@GetMapping("/all")
	public List<Order> getAllOrder() {
		return this.orderRepository.findAll();
	}
	@GetMapping("/{id}")
	public Order getOrder(@PathVariable("id") String id) {
		Optional<Order> order=this.orderRepository.findById(id);
		return order.get();
	}
	@PostMapping("/create")
	public void createOrder(@RequestBody Order order) {
		Integer length=order.getOrderlist().size();
		Integer total=0;
		for(int i=0;i<length;i++) {
			total += (order.getOrderlist().get(i).getBook().getPrice()*order.getOrderlist().get(i).getQuantity());
		}
		order.setTotal(total);
		//System.out.println("Day la Order: "+   order.getOrderlist().get(0).getBook().getPrice());
		this.orderRepository.insert(order);
	}
	@PostMapping("/delete/{id}")
	public void deleteOrder(@PathVariable("id") String id) {
		this.orderRepository.deleteById(id);
	}
}
