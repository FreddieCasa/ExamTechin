package lt.techin.addvertappbackend.controller;

import lt.techin.addvertappbackend.model.AdvertCategory;
import lt.techin.addvertappbackend.service.AdvertCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class AdvertCategoryController {
    @Autowired
    private AdvertCategoryService advertCategoryService;

    @GetMapping
    public List<AdvertCategory> getAllCategories() {
        return advertCategoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public AdvertCategory getAdvertCategoryById(@PathVariable Long id) {
        return advertCategoryService.getAdvertCategoryById(id);
    }

    @PostMapping
    public AdvertCategory addAdvertCategory(@RequestBody AdvertCategory category) {
        return advertCategoryService.addAdvertCategory(category);
    }

    @DeleteMapping("/remove/{id}")
    public void  removeAdvertCategoryById(@PathVariable Long id) {
        advertCategoryService.removeAdvertCategoryById(id);
    }

}