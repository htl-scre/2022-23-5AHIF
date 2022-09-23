package at.htlstp.ssr.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public record DemoController() {

    @GetMapping("demo")
    public String getGreeting(Model model,
                              @RequestParam(required = false, defaultValue = "World") String name) {
        model.addAttribute("name", name);
        return "greetings";
    }
}
