package me.dio.academia.digital.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Não será necessário implementar Getters e Setters, Equals e Hashcode
@NoArgsConstructor //Cria um construtor vazio (exigido pelo hibernate)
@AllArgsConstructor //Cria um construtor com todos os parâmetros
@Entity
@Table(name = "tb_matriculas") //Cria uma tabela no banco de dados
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) //Uma matrícula para um aluno
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
