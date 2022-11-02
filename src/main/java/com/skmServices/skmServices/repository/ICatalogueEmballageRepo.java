package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Catalogueemballage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueEmballageRepo extends JpaRepository<Catalogueemballage, Integer> {
}
