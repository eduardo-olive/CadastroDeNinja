package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/wellcome")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota.";
    }

    // Adcionar ninja (CREATE)
    @PostMapping("/ninja")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostar todos os ninjas (READ)
    @GetMapping("/ninja")
    public List<NinjaModel> mostrarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostar ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public NinjaModel mostarNinja(@PathVariable Long id){
        return ninjaService.listarNinjaPorID(id);
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/ninja/{id}")
    public String atualizarNinja(){
        return "Ninja atualizado";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/ninja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.excluirNinjaPorId(id);
    }

}
