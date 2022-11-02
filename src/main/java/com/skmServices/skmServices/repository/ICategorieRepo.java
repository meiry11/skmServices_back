package com.skmServices.skmServices.repository;
import com.skmServices.skmServices.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieRepo extends JpaRepository<Categorie,Integer> {
}
