package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.IdLivraison;
import com.skmServices.skmServices.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivraisonRepo extends JpaRepository<Livraison, IdLivraison> {
}
