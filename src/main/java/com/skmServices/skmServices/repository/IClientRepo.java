package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClientRepo extends JpaRepository<Client,Integer> {
    public Optional<Client> findByUsername(String email);
}
