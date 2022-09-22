package repository;
import entity.Catalogueemballage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatalogueEmballageRepo extends JpaRepository<Catalogueemballage, Integer> {
}
