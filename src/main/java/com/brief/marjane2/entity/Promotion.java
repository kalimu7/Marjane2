package  com.brief.marjane2.entity;


import com.brief.marjane2.entity.Category;
import com.marjane.enums.status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdPr;

    @Column(name = "DateDebut")
    private LocalDateTime DateDebut;

    @Column(name = "DateFin")
    private LocalDateTime DateFin;

    @Enumerated(EnumType.STRING)
    private status status;

    @OneToOne
    @JoinColumn(name = "category",referencedColumnName = "IdC")
    private Category category;
}
