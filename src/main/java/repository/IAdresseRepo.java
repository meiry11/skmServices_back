package repository;

import entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdresseRepo extends JpaRepository<Adresse,Integer> {
}
