package lt.techin.backend.service;
 
import lt.techin.backend.model.Advert;
import lt.techin.backend.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
 
@Service
public class AdvertService {
    @Autowired
    private AdvertRepository advertRepository;
 
    public List<Advert> getAllAdverts() {
        return advertRepository.findAll();
    }
 
    public Advert getAdvertById(Long id) {
        return advertRepository.findById(id).orElse(null);
    }
 
    public Advert addAdvert(Advert advert) {
return advertRepository.save(advert);
    }
 
    public void removeAdvertById(Long id) {
        advertRepository.deleteById(id);
    }
 
    public List<Advert> getAdvertsByCategoryId(Long categoryId) {
        return advertRepository.findByCategoryId(categoryId);
    }
}