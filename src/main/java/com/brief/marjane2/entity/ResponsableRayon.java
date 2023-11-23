package  com.brief.marjane2.entity;

import com.brief.marjane2.enums.category;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "ResponsableRayon")
public class ResponsableRayon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRR;

    @Column(name = "email", unique = true)
    private String email;

    @Column (name = "Password")
    private String Password;

    @Enumerated(EnumType.STRING)
    private category category;


}
