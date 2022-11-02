package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Emballage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmballageRepo extends JpaRepository<Emballage,Integer> {
}
