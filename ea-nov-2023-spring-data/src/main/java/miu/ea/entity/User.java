package miu.ea.entity;

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
@Table(name="users",
            uniqueConstraints = {
                    @UniqueConstraint(
                            name = "email_unique",
                            columnNames = "email"
                    )
            }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    // default fetch type for one to many is LAZY
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
    private List<Review> reviewList;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Address billingAddress;

}
