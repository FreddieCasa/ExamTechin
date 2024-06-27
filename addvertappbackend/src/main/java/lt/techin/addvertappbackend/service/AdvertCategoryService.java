package lt.techin.addvertappbackend.service;

import lt.techin.addvertappbackend.model.AdvertCategory;
import lt.techin.addvertappbackend.repository.AdvertCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
