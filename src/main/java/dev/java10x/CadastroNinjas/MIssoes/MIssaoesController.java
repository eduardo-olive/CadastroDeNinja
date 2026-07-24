package dev.java10x.CadastroNinjas.MIssoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MIssaoesController {

    @GetMapping("/test-missoes")
    public String missoes(){
        return "Rota principal de missões";
    }

    @PostMapping("/missao")
    public String criarMissao(){
        return "Cria uma missão";
    }

    @GetMapping("/missao")
    public String mostrarMissoes(){
        return "Mostra todas as missões";
    }

    @GetMapping("/missao/:id")
    public String mostarMissao(){
        return "Mostra missão por ID";
    }

    @PutMapping("/missao/:id")
    public String atualizarMissao(){
        return "Atualiza uma missão";
    }

    @DeleteMapping("/missao/:id")
    public String excluirMissao(){
        return "Exclui uma missão por ID";
    }
}
