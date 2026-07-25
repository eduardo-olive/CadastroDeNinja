package dev.java10x.CadastroNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    // Listar todos os meu ninjas por ID
    public NinjaModel listarNinjaPorID(long AId){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(AId);
        return ninjaModel.orElse(null);
    }
}
