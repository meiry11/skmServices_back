package repository;
import entity.IdLignecommande;
import entity.Lignecommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILigneCommandeRepo extends JpaRepository<Lignecommande, IdLignecommande> {
}
