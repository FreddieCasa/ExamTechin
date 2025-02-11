package lt.techin.backend.repository;
 
import lt.techin.backend.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
 
import java.util.List;
 
public interface AdvertRepository extends JpaRepository<Advert, Long> {
    List<Advert> findByTitle(String title);
}