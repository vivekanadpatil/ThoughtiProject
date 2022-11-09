package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.OrderDto;
import com.example.demo.repository.OrderRepository;

@Component
public class OrderDao {

	@Autowired
	OrderRepository repository;

	public void insert(OrderDto dto) {
		repository.save(dto);
	}

	public Optional<OrderDto> getOrder(int order_id) {
		return repository.findById(order_id);
	}

	public List<OrderDto> fetchAll() {
		return repository.findAll();
	}

}
