package repository;
import entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategorieRepo extends JpaRepository<Categorie,Integer> {
}
