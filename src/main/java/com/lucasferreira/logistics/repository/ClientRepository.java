package com.lucasferreira.logistics.repository;

import com.lucasferreira.logistics.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
