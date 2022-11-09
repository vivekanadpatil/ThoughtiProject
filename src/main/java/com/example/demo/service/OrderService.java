package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.dto.OrderDto;
import com.example.demo.helper.ResponseStructure;

@Service
public class OrderService {

	@Autowired
	OrderDao dao;

	public ResponseStructure<List<OrderDto>> insertOrder(List<OrderDto> list) {
		for (OrderDto dto : list) {
			dto.setOrderStatus("NEW");
			dao.insert(dto);
		}

		ResponseStructure<List<OrderDto>> structure = new ResponseStructure<>();
		structure.setMessage("Saved Successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(list);

		return structure;

	}

	public ResponseStructure<OrderDto> fetchOrder(int order_id) {
		Optional<OrderDto> order = dao.getOrder(order_id);
		OrderDto dto = order.get();
		ResponseStructure<OrderDto> res = new ResponseStructure<>();
		res.setMessage("Found");
		res.setStatusCode(HttpStatus.FOUND.value());
		res.setData(dto);

		return res;
	}

	public ResponseStructure<List<OrderDto>> fetchAllOrder() {

		List<OrderDto> list = dao.fetchAll();

		ResponseStructure<List<OrderDto>> structure = new ResponseStructure<>();
		structure.setMessage("Found");
		structure.setStatusCode(HttpStatus.FOUND.value());
		structure.setData(list);
		return structure;
	}

}
