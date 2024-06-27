package lt.techin.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 
@Entity
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
 
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private AdvertCategory category;
 
    // Getters and setters
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
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public AdvertCategory getCategory() {
        return category;
    }
 
    public void setCategory(AdvertCategory category) {
        this.category = category;
    }
}