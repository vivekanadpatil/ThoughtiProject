package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.OrderDto;

public interface OrderRepository extends JpaRepository<OrderDto, Integer> {

}
