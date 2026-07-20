package dev.java10x.CadastroNinjas.MIssoes;

import dev.java10x.CadastroNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_missoes")
@Data // Anotation responsavel por criar os Getrs e os Seters, caso queira fazer na "munheca" só omitir a anotation
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String dificuldade;

    // @OneToMany uma missão pode ter vários ninjas.
    @OneToMany(mappedBy = "missoes")
    private NinjaModel ninja;

}
