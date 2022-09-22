package repository;
import entity.IdLivraison;
import entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivraisonRepo extends JpaRepository<Livraison, IdLivraison> {
}
