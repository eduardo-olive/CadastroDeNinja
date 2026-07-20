package dev.java10x.CadastroNinjas.Ninjas;

import dev.java10x.CadastroNinjas.MIssoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data // Anotation responsavel por criar os Getrs e os Seters, caso queira fazer na "munheca" só omitir a anotation
@NoArgsConstructor // Cria construtor sem argumentos
@AllArgsConstructor // Cria construtor com todos os argumentos da classe
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne um ninja tem uma unica missão
    @ManyToOne()
    @JoinColumn(name = "missoes_id")
    private List<MissaoModel> missoes;
}
