package com.hadialaoui.spring.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMetierRepository extends JpaRepository<Customer, Integer> {

}
