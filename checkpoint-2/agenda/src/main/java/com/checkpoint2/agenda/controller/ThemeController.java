package com.checkpoint2.agenda.controller;

import com.checkpoint2.agenda.entity.Theme;
import com.checkpoint2.agenda.repository.ThemeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class ThemeController {
    @Autowired
    private ThemeRepository repository;

    // DISPLAY ONE THEME
    @GetMapping("/theme")
    public String getTheme(Model model,
                           @RequestParam(required = false) Long id) {

        Theme theme = new Theme();

        if (id != null) {
            Optional<Theme> optionalTheme = repository.findById(id);
            if (optionalTheme.isPresent()) {
                theme = optionalTheme.get();
            }
        }
        model.addAttribute("theme", theme);
        return "theme";
    }

    // DISPLAY ALL EVENTS
    @GetMapping("/themes")
    public String getAll(Model model) {
        model.addAttribute("themes", repository.findAll());
        return "themes";
    }

    // CREATE / UPDATE EVENT
    @PostMapping("/theme")
    public String editTheme(@ModelAttribute Theme theme) {
        repository.save(theme);
        return "redirect:/themes";
    }

    // DELETE EVENT
    @GetMapping("/theme/delete")
    public String deleteTheme(@RequestParam Long id) {

        repository.deleteById(id);

        return "redirect:/themes";
    }
}
