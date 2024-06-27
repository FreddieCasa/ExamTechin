package lt.techin.backend.service;

import lt.techin.backend.model.AdvertCategory;
import lt.techin.backend.repository.AdvertCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdvertCategoryService {
    @Autowired 
    private AdvertCategoryRepository advertCategoryRepository;
    
    public List<AdvertCategory> getAllCategories() {
        return advertCategoryRepository.findAll();
    }

    public AdvertCategory getAdvertCategoryById(Long id) {
        return advertCategoryRepository.findById(id).orElse(null);
    }

    public AdvertCategory addAdvertCategory(AdvertCategory category) {
        return advertCategoryRepository.save(category);
    }

    public void removeAdvertCategoryById(Long id) {
        advertCategoryRepository.deleteById(id);
    }

}
