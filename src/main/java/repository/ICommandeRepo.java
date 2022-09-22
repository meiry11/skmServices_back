package repository;
import entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommandeRepo extends JpaRepository<Commande,Integer> {
}
