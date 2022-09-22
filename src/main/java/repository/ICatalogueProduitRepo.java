package repository;
import entity.Catalogueproduit;
import entity.IdCatalogueproduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueProduitRepo extends JpaRepository<Catalogueproduit, IdCatalogueproduit> {
}
