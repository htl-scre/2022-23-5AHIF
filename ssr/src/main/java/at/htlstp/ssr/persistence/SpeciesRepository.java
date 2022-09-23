package at.htlstp.ssr.persistence;

import at.htlstp.ssr.domain.Species;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeciesRepository extends JpaRepository<Species, String> {

}
