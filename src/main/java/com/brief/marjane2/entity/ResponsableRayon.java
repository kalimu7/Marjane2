package  com.brief.marjane2.entity;

import com.brief.marjane2.enums.category;
import com.brief.marjane2.observer.Observer;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "ResponsableRayon")
public class ResponsableRayon  implements Observer{



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdRR;

    @Column(name = "email", unique = true)
    private String email;

    @Column (name = "Password")
    private String Password;

    @Enumerated(EnumType.STRING)
    private category category;

    @Column(name = "subscribe")
    private boolean subscribe;


    @Override
    public void update(String message, String email) {
        System.out.println(message  +  " and recieved by " + email);
    }
}
