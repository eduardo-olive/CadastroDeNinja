package dev.java10x.CadastroNinjas.Ninjas;

import dev.java10x.CadastroNinjas.MIssoes.MissaoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Criar todos os Gaters e Seters em tempo de execução.
@NoArgsConstructor // Cria construtor sem parametros
@AllArgsConstructor // Cria um construtor com todos os parametros
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private String imgUrl;
    private int idade;
    private MissaoesModel missoes;
    private String rank;

}
