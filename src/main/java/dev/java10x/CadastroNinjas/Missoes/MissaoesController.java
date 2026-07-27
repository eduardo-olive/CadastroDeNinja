package dev.java10x.CadastroNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MissaoesController {

    private MissoesService missoesService;

    public MissaoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    @GetMapping("/test-missoes")
    public ResponseEntity<String> missoes(){
        return ResponseEntity.ok("Rota de teste das missões");
    }

    @PostMapping("/missao")
    public ResponseEntity<MissoesModel> criarMissao(@RequestBody MissoesModel missao)
    {
        MissoesModel missaoCriada =  missoesService.criarMissao(missao);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(missaoCriada);
    }

    @GetMapping("/missao")
    public ResponseEntity<List<MissoesModel>> mostrarMissoes()
    {
        return ResponseEntity.ok(missoesService.listarMisssoes());
    }

    @GetMapping("/missao/{id}")
    public ResponseEntity<?> mostarMissao(@PathVariable Long id)
    {
        MissoesModel missao = missoesService.listarMIssaoPorId(id);
        if (missao != null){
            return ResponseEntity.ok(missao);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Missão com ID: " + id + " não encontrada.");
    }

    @PutMapping("/missao/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoModel)
    {
        if (missoesService.listarMIssaoPorId(id) != null){
            MissoesModel missao = missaoModel;
            missao.setId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(missoesService.atualizarMissao(id, missaoModel));
        }
        return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Missão com ID: " + id + " não encontada.");
    }

    @DeleteMapping("/missao/{id}")
    public ResponseEntity<String> excluirMissao(@PathVariable Long id)
    {
        if (missoesService.listarMIssaoPorId(id) != null){
            missoesService.excluirMissao(id);
            return ResponseEntity.ok("Missão excluida com sucesso.");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Missão com ID: " + id + " não encontrada");
    }
}
