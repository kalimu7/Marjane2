package  com.brief.marjane2.entity;


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
@Table (name = "Product")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idP")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdP;

    @Column(name = "Titre")
    @NonNull
    private String Titre;

    @Column(name = "Prix")
    @NonNull
    private float Prix;

    @Column(name = "Image")
    @NonNull
    private String Image;

    @Column(name = "Description")
    @NonNull
    private String Description;

    @Column(name = "quantite")
    @NonNull
    private Integer quantite;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "IdCategory",referencedColumnName = "idC")
    private Category category;

    @OneToMany(mappedBy = "product")
    List<Purchases> purchases;

}
