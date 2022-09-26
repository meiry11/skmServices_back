package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.ProduitGros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitGrosRepo extends JpaRepository<ProduitGros,Integer> {
}
