package lt.techin.backend.service;
 
import lt.techin.backend.model.Advert;
import lt.techin.backend.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
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
 
    // public List<Advert> getAdvertsByCategoryId(Long categoryId) {
    //     return advertRepository.findByCategoryId(categoryId);
    // }

    public void updateAdvertById(Long id, Advert newAdvertData) {
        Optional<Advert> oldAdvertData = advertRepository.findById(id);
        Advert updatedAdvertData = oldAdvertData.get();
        updatedAdvertData.setTitle(newAdvertData.getTitle());

        updatedAdvertData.setDescription(newAdvertData.getDescription());
  
        advertRepository.save(updatedAdvertData);
      }
}