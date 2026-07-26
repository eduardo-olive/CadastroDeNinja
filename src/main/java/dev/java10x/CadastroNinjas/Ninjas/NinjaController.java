package dev.java10x.CadastroNinjas.Ninjas;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/ninja")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criando com suesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    @GetMapping("/ninja")
    public ResponseEntity<List<NinjaDTO>> mostrarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/ninja/{id}")
    public ResponseEntity<?> mostarNinja(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaPorID(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja com ID: " + id + " não encontrado.");
    }

    @PutMapping("/ninja/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){

        NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninja);

        if(ninjaAtualizado != null){
            return ResponseEntity.ok(ninjaAtualizado);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja com ID: " + id + " não foi encotrado.");
    }

    @DeleteMapping("/ninja/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {

        if (ninjaService.listarNinjaPorID(id) != null) {
            ninjaService.excluirNinjaPorId(id);

            return ResponseEntity
                    .ok("Ninja com ID: " + id + " deletado com sucesso.");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja com ID: " + id + " não encontrado.");

    }

}
