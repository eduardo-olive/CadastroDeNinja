package dev.java10x.CadastroNinjas.MIssoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data // Anotation responsavel por criar os Getrs e os Seters, caso queira fazer na "munheca" só omitir a anotation
@NoArgsConstructor
@AllArgsConstructor
public class MissaoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    // @OneToMany uma missão pode ter vários ninjas.
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}
