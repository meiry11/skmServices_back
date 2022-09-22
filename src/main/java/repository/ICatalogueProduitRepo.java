package repository;
import entity.Catalogueproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueProduitRepo extends JpaRepository<Catalogueproduit, Integer> {
}
