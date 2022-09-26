package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFactureRepo extends JpaRepository<Facture,Integer> {
}
