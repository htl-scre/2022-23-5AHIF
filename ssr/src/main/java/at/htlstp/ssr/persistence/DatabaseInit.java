package at.htlstp.ssr.persistence;

import at.htlstp.ssr.domain.Penguin;
import at.htlstp.ssr.domain.Species;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public record DatabaseInit(SpeciesRepository speciesRepository, PenguinRepository penguinRepository) implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var species = List.of(
                new Species("Gentoo"),
                new Species("Emperor"),
                new Species("Adelie")
        );
        species = speciesRepository.saveAll(species);
        var penguins = List.of(
                new Penguin(null, "Fred", 123, species.get(2)),
                new Penguin(null, "Edward", 123, species.get(0)),
                new Penguin(null, "Charles", 123, species.get(1)),
                new Penguin(null, "Kowalski", 123, species.get(1)),
                new Penguin(null, "Skipper", 123, species.get(0)),
                new Penguin(null, "Recon", 123, species.get(2))
        );
        penguinRepository.saveAll(penguins);
    }
}
