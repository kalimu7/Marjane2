package  com.brief.marjane2.entity;

import jakarta.persistence.*;
import lombok.*;
import com.brief.marjane2.enums.roles;

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

    @Column(name = "email", unique = true)
    private String email;

    @Column (name = "Password")
    private String Password;

    @Enumerated(EnumType.STRING)
    private roles roles;
}
