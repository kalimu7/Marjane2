package  com.brief.marjane2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdC;

    @Column(name = "Titre")
    private String Titre;

    @Column(name = "Description")
    private String Image;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER)
    private List<Product> product;


    @OneToOne(mappedBy = "category",fetch = FetchType.EAGER)
    private Promotion promotion;



}
