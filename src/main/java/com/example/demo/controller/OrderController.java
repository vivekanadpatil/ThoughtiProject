package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.OrderDto;
import com.example.demo.helper.ResponseStructure;
import com.example.demo.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService service;

	@PostMapping("/orders")
	public ResponseStructure<List<OrderDto>> orders(@RequestBody List<OrderDto> list)
	{
		return service.insertOrder(list);
	}
	
	@GetMapping("/orders/{order_id}")
	public ResponseStructure<OrderDto> orders(@PathVariable int order_id)
	{
		return service.fetchOrder(order_id);
	}
	
	@GetMapping("/orders")
	public ResponseStructure<List<OrderDto>> orders()
	{
		return service.fetchAllOrder();
	}
	
	
	
}
