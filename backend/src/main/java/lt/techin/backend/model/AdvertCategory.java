package lt.techin.backend.model;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class AdvertCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
 
    // @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<Advert> adverts;
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    // public List<Advert> getAdverts() {
    //     return adverts;
    // }
 
    // public void setAdverts(List<Advert> adverts) {
    //     this.adverts = adverts;
    // }
}