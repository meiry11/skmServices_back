package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.IdLignecommande;
import com.skmServices.skmServices.entity.Lignecommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILigneCommandeRepo extends JpaRepository<Lignecommande, IdLignecommande> {
}
