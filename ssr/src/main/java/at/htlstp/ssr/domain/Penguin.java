package at.htlstp.ssr.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Penguin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Positive
    private int weightInKg;

    @ManyToOne
    private Species species;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Penguin penguin = (Penguin) o;
        return id != null && Objects.equals(id, penguin.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
