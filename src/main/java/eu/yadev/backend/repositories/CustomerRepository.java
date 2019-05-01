package eu.yadev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.yadev.backend.data.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
