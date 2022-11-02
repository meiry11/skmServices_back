package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitRepo extends JpaRepository<Produit,Integer> {
}
