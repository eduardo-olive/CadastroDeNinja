package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/wellcome")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota.";
    }

    // Adcionar ninja (CREATE)
    @PostMapping("/nija")
    public String criarNinja() {
        return "Ninja criado.";
    }

    // Mostar todos os ninjas (READ)
    @GetMapping("/ninja")
    public String mostrarNinjas(){
        return "Mostra todos os ninjas cadastrados.";
    }

    // Mostar ninja por ID (READ)
    @GetMapping("/ninja/:id")
    public String mostarNinja(){
        return "Mostra ninja por ID.";
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/nija/:id")
    public String atualizarNinja(){
        return "Ninja atualizado";
    }


    // Deletar ninja (DELETE)

}
