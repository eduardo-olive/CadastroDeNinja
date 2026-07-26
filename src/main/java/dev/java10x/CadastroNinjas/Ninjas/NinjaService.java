package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar todos os meu ninjas por ID
    public NinjaModel listarNinjaPorID(Long AId){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(AId);
        return ninjaModel.orElse(null);
    }

    // Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Excluir um ninja
    public void excluirNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar um ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)){
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        } else {
            return null;
        }
    }
}
