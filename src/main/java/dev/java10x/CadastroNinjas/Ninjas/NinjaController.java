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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Mostar todos os ninjas (READ)
    @GetMapping("/ninja")
    public List<NinjaDTO> mostrarNinjas(){
        return ninjaService.listarNinjas();
    }

    // Mostar ninja por ID (READ)
    @GetMapping("/ninja/{id}")
    public NinjaDTO mostarNinja(@PathVariable Long id){
        return ninjaService.listarNinjaPorID(id);
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/ninja/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/ninja/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.excluirNinjaPorId(id);
    }

}
