package  com.brief.marjane2.entity;


import com.brief.marjane2.entity.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.brief.marjane2.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Promotion")
//@JsonIgnoreProperties({"category"})

public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private int IdPr;

    @Column(name = "dateDebut")
    @NonNull
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    @NonNull
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    @NonNull
    private status status ;

    @ManyToOne
    @JoinColumn(name = "category",referencedColumnName = "IdC")
    @NonNull
    private Category category;


}
