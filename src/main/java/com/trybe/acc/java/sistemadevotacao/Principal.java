package com.trybe.acc.java.sistemadevotacao;

import java.util.Scanner;

public class Principal {

  private static void cadastroCandidato(Scanner scanner,
      GerenciamentoVotacao gerenciamentoVotacao) {
    short userInput;
    do {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      userInput = scanner.nextShort();
      switch (userInput) {
        case 1:
          System.out.println("Entre com o nome da pessoa candidata:");
          String nomeCandidato = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidato = scanner.nextInt();
          gerenciamentoVotacao.cadastrarPessoaCandidata(nomeCandidato, numeroCandidato);
          break;
        case 2:
          break;
        default:
          throw new Error("Entre com uma opção valida!");
      }
    } while (userInput == 1);
  }

  private static void cadastroEleitor(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    short userInput;
    do {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.println("Entre com o número correspondente à opção desejada:");
      userInput = scanner.nextShort();
      switch (userInput) {
        case 1:
          System.out.println("Entre com o nome da pessoa eleitora:");
          String nomeEleitor = scanner.next();
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitor = scanner.next();
          gerenciamentoVotacao.cadastrarPessoaEleitora(nomeEleitor, cpfEleitor);
          break;
        case 2:
          break;
        default:
          throw new Error("Entre com uma opção valida!");
      }
    } while (userInput == 1);
  }

  private static void realizarVotacao(Scanner scanner, GerenciamentoVotacao gerenciamentoVotacao) {
    short userInput;
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      userInput = scanner.nextShort();
      switch (userInput) {
        case 1:
          System.out.println("Entre com o cpf da pessoa eleitora:");
          String cpfEleitor = scanner.next();
          System.out.println("Entre com o número da pessoa candidata:");
          int numeroCandidato = scanner.nextInt();
          gerenciamentoVotacao.votar(cpfEleitor, numeroCandidato);
          break;
        case 2:
          gerenciamentoVotacao.mostrarResultado();
          break;
        case 3:
          gerenciamentoVotacao.mostrarResultado();
          break;
        default:
          throw new Error("Entre com uma opção valida!");
      }
    } while (userInput == 1 || userInput == 2);
  }

  /**
   * Inicia o processo de votacao.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();

    Principal.cadastroCandidato(scanner, gerenciamentoVotacao);
    Principal.cadastroEleitor(scanner, gerenciamentoVotacao);
    Principal.realizarVotacao(scanner, gerenciamentoVotacao);

    scanner.close();
  }
}
