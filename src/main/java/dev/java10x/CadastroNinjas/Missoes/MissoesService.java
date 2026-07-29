package dev.java10x.CadastroNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {

    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper)
    {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public MissoesDTO criarMissao(MissoesDTO missaoDTO)
    {
        MissoesModel missao = missoesMapper.map(missaoDTO);
        return missoesMapper.map(missoesRepository.save(missao));
    }

    public List<MissoesDTO> listarMisssoes()
    {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::map)
                .collect(Collectors.toList());
    }

    public MissoesDTO listarMIssaoPorId(Long id){
        Optional<MissoesModel> missao = missoesRepository.findById(id);
        return missao.map(missoesMapper::map).orElse(null);
    }

    public void excluirMissao(Long id) {
        missoesRepository.deleteById(id);
    }

    public MissoesDTO atualizarMissao(Long id, MissoesDTO missao){
        Optional<MissoesModel> missaoExiste = missoesRepository.findById(id);
        if(missaoExiste.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.map(missao);
            missaoAtualizada.setId(id);
            MissoesModel missaoGravada = missoesRepository.save(missaoAtualizada);
            return missoesMapper.map(missaoGravada);
        }
        return null;

    }
}
