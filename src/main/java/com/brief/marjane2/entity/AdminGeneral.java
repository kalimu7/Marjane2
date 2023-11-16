package  com.brief.marjane2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "AdminGeneral")
public class AdminGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdAG;

    @Column(name = "Email", unique = true)
    private String Email;

    @Column (name = "Password")
    private String Password;
}
