package com.startfestas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // Mapeia para index.html
    }

    @GetMapping("/galeria")
    public String galeria() {
        return "galeria"; // Mapeia para galeria.html
    }

    @GetMapping("/orcamento")
    public String orcamento() {
        return "orcamento"; // Mapeia para orcamento.html
    }
}
