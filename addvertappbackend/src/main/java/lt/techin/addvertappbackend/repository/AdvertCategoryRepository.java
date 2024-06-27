package lt.techin.addvertappbackend.repository;

import lt.techin.addvertappbackend.model.AdvertCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertCategoryRepository extends JpaRepository<AdvertCategory, Long>{
    List<AdvertCategory> findByTitle(String title);
}
