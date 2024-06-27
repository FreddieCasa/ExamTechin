package lt.techin.backend.controller;
 
import lt.techin.backend.model.Advert;
import lt.techin.backend.service.AdvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController
@RequestMapping("/adverts")
@CrossOrigin(origins = "http://localhost:5173")
public class AdvertController {
    @Autowired
    private AdvertService advertService;
 
    @GetMapping
    public List<Advert> getAllAdverts() {
        return advertService.getAllAdverts();
    }
 
    @GetMapping("/{id}")
    public Advert getAdvertById(@PathVariable Long id) {
        return advertService.getAdvertById(id);
    }
 
    @PostMapping
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertService.addAdvert(advert);
    }
 
    @DeleteMapping("/remove/{id}")
    public void removeAdvertById(@PathVariable Long id) {
        advertService.removeAdvertById(id);
    }
 
    @GetMapping("/category/{categoryId}")
    public List<Advert> getAdvertsByCategoryId(@PathVariable Long categoryId) {
        return advertService.getAdvertsByCategoryId(categoryId);
    }
}