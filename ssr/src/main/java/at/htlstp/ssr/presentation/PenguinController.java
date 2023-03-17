package at.htlstp.ssr.presentation;

import at.htlstp.ssr.domain.Penguin;
import at.htlstp.ssr.persistence.PenguinRepository;
import at.htlstp.ssr.persistence.SpeciesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("penguins")
public record PenguinController(PenguinRepository penguinRepository, SpeciesRepository speciesRepository) {

    @GetMapping
    public String allSpecies(Model model) {
        model.addAttribute("species", speciesRepository.findAll());
        return "all-species";
    }

    @GetMapping("{species}")
    public String fromSpecies(Model model, @PathVariable String species) {
        model.addAttribute("species", species);
        model.addAttribute("penguins", penguinRepository.findAllBySpecies_Name(species));
        return "penguins";
    }

    @GetMapping("all")
    public String all(Model model) {
        model.addAttribute("penguins", penguinRepository.findAll());
        return "allPenguins";
    }

    @GetMapping("new")
    public String getNewPenguinForm(Model model) {
        if (!model.containsAttribute("newPenguin"))
            model.addAttribute("newPenguin", new Penguin());    // besser Klassenname
        model.addAttribute("species", speciesRepository.findAll());
        return "new-penguin";
    }

    @PostMapping("add-penguin")
    public String addPenguin(@Valid @ModelAttribute("newPenguin") Penguin penguin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return getNewPenguinForm(model);

        penguinRepository.save(penguin);
        return "redirect:/penguins/all";    // route, nicht .html-File
    }
}
