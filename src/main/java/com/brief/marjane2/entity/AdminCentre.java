package  com.brief.marjane2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AdminCentre")
public class AdminCentre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdAC;

    @Column(name = "email", unique = true)
    private String email;

    @Column (name = "Password")
    private String Password;
}
