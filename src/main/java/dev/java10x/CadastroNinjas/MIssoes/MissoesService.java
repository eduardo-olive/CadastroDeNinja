package dev.java10x.CadastroNinjas.MIssoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    public MissoesModel criarMissao(MissoesModel missao){
        return missoesRepository.save(missao);
    }

    public List<MissoesModel> listarMisssoes(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarMIssaoPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.orElse(null);
    }

    public void excluirMissao(Long id) {
        missoesRepository.deleteById(id);
    }
    public MissoesModel atualizarMissao(Long id, MissoesModel missao){
        if(missoesRepository.findById(id) != null) {
            MissoesModel missaoAtualizado = missao;
            missaoAtualizado.setId(id);
            return missoesRepository.save(missaoAtualizado);
        }
        return null;

    }
}
