package at.htlstp.ssr.persistence;

import at.htlstp.ssr.domain.Penguin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PenguinRepository extends JpaRepository<Penguin, Integer> {

    List<Penguin> findAllBySpecies_Name(String species);
}
