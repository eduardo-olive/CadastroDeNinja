package dev.java10x.CadastroNinjas.MIssoes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MIssaoController {

    @GetMapping("/missoes")
    public String missoes(){
        return "Rota principal de missões";
    }
}
