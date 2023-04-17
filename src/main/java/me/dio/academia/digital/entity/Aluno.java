package me.dio.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Não será necessário implementar Getters e Setters, Equals e Hashcode
@NoArgsConstructor //Cria um construtor vazio (exigido pelo hibernate)
@AllArgsConstructor //Cria um construtor com todos os parâmetros
@Entity //Cria a tabela no BD (exige um @Id)
@Table(name = "tb_alunos") //Cria uma tabela efetivamente no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //Suprimir exceptions relativas ao Lazy
public class Aluno {

  @Id //Marca como ID
  @GeneratedValue(strategy = GenerationType.IDENTITY) //Geração automática dos IDs
  private Long id;

  private String nome;

  @Column(unique = true) //Impossível repetir!
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) //Um aluno contém várias avaliações físicas
  @JsonIgnore //Suprimir exceptions relativas ao Lazy
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
