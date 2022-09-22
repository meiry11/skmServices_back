package repository;
import entity.ProduitGros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduitGrosRepo extends JpaRepository<ProduitGros,Integer> {
}
