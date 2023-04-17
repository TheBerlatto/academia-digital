package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Não será necessário implementar Getters e Setters, Equals e Hashcode
@NoArgsConstructor //Cria um construtor vazio (exigido pelo hibernate)
@AllArgsConstructor //Cria um construtor com todos os parâmetros
@Entity //Cria a tabela no BD (exige um @Id)
@Table(name = "tb_avaliacoes") //Cria uma tabela no banco de dados
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) //Muitas avaliações para um único aluno, efeito cascata (alterações também serão sentidas em Aluno)
  @JoinColumn(name = "aluno_id") //Cria coluna de FK na tabela de Avaliações Físicas
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //Renomeia coluna no BD
  private double peso;

  @Column(name = "altura_atual") //Renomeia coluna no BD
  private double altura;

}
