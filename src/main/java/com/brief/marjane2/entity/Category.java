package  com.brief.marjane2.entity;


import com.brief.marjane2.enums.category;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table (name = "Category")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idC")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;

    @Enumerated(EnumType.STRING)
    private category titre;

    @Column(name = "Description")
    @NonNull
    private String description;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    @NonNull
    private List<Promotion> promotion;

    @OneToMany(mappedBy = "category")
    private List<Product> product;




}
