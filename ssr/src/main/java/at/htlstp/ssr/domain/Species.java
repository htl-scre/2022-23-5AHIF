package at.htlstp.ssr.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Species {

    @Id
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Species species = (Species) o;
        return name != null && Objects.equals(name, species.name);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
