package  com.brief.marjane2.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table (name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;

    @NonNull
    @Column(name = "Titre")
    private String Titre;

    @NonNull
    @Column(name = "Description")
    private String description;

    @NonNull
    @OneToOne(mappedBy = "category",fetch = FetchType.EAGER)
    private Promotion promotion;

    @OneToMany(mappedBy = "category")
    private List<Product> product;


}
