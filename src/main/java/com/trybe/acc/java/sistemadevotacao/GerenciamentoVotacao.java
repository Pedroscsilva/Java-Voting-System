package com.trybe.acc.java.sistemadevotacao;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GerenciamentoVotacao {
  private ArrayList<PessoaCandidata> pessoasCandidatas = new ArrayList<>();
  private ArrayList<PessoaEleitora> pessoasEleitoras = new ArrayList<>();
  private ArrayList<String> cpfComputado = new ArrayList<>();
  private int totalVotos;
  
  /**
   * Cadastra uma pessoa candidata.
   * @param nome da pessoa candidata.
   * @param numero da pessoa candidata.
   */
  public void cadastrarPessoaCandidata(String nome, int numero) {
    if (!this.pessoasCandidatas.isEmpty()) {
      for (PessoaCandidata candidata : this.pessoasCandidatas) {
        if (candidata.getNumero() == numero) {
          throw new Error("Número pessoa candidata já utilizado!");
        }
      }
    }
    PessoaCandidata candidata = new PessoaCandidata(nome, numero);
    this.pessoasCandidatas.add(candidata);
  }
  
  /**
   * Cadastra uma pessoa eleitora.
   * @param nome da pessoa eleitora.
   * @param cpf da pessoa eleitora.
   */
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    if (!this.pessoasEleitoras.isEmpty()) {
      for (PessoaEleitora eleitora : this.pessoasEleitoras) {
        if (eleitora.getCpf().equals(cpf)) {
          throw new Error("Pessoa eleitora já cadastrada!");
        }
      }
    }
    PessoaEleitora eleitora = new PessoaEleitora(nome, cpf);
    this.pessoasEleitoras.add(eleitora);
  }
  
  /**
   * Computa um voto para uma pessoa candidata.
   */
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (this.cpfComputado.contains(cpfPessoaEleitora)) {
      throw new Error("Pessoa eleitora já votou!");
    }
    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        break;
      }
    }
    this.cpfComputado.add(cpfPessoaEleitora);
    this.totalVotos += 1;
  }
  
  /**
   * Mostra o resultado das eleições.
   */
  public void mostrarResultado() {
    if (this.cpfComputado.isEmpty()) {
      throw new Error("É preciso ter pelo menos um voto para mostrar o resultado.");
    }
    DecimalFormat decimalFormat = new DecimalFormat("0.0'%'");
    int totalVotos = this.cpfComputado.size();
    for (PessoaCandidata candidata : this.pessoasCandidatas) {
      String porcentagem = decimalFormat.format((double) candidata.getVotos() * 100 / totalVotos);
      String mensagem = String.format("Nome: %s - %d votos ( %s )", candidata.getNome(),
          candidata.getVotos(), porcentagem);
      System.out.println(mensagem);
    }
    System.out.println("Total de votos: " + this.totalVotos);
  }
}
