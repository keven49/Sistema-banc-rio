/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemabancario;

/**
 *
 * @author keven
 */
import java.util.Scanner;

// Classe principal do sistema bancário
public class SistemaBancario {
    // Método principal
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            // Criando um objeto para realizar as operações bancárias
            OperacoesBancarias banco = new OperacoesBancarias();
            
            String nome, sobrenome, cpf;
            double valor;
            
            // Inicia a interação com boas-vindas
            System.out.println("Bem-vindo ao Sistema Bancario!");
            
            // Solicitando e lendo os dados pessoais do cliente
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine();
            System.out.print("Digite seu sobrenome: ");
            sobrenome = scanner.nextLine();
            System.out.print("Digite seu CPF: ");
            cpf = scanner.nextLine();
            
            // Criando um objeto DadosPessoais com os dados informados pelo usuário
            DadosPessoais cliente = new DadosPessoais(nome, sobrenome, cpf);
            
            // Declara escolha
            int escolha;
            do {
                
                // Exibindo o menu de opções
                exibirMenu();
                escolha = Integer.parseInt(scanner.nextLine());
                
                // Executando a ação correspondente à escolha do usuário
                switch (escolha) {
                    
                    // Consultar saldo
                    case 1 -> { System.out.println("Saldo atual: R$ " + banco.consultarSaldo(cliente)); }
                    
                    // Realizar depósito
                    case 2 -> { 
                        System.out.print("Digite o valor do deposito: ");         
                        valor = Double.parseDouble(scanner.nextLine());
                        banco.realizarDeposito(cliente, valor);
                    }
                    
                    // Realizar saque    
                    case 3 -> { 
                        System.out.print("Digite o valor do saque: ");
                        valor = Double.parseDouble(scanner.nextLine());
                        banco.realizarSaque(cliente, valor);
                    }
                    
                    // Encerrar o programa    
                    case 4 -> {System.out.println("Saindo..."); }
                    
                    // Opção inválida
                    default -> {System.out.println("Opção invalida! Tente novamente."); }
                }

            // Repetir até que o usuário escolha sair
           } while (escolha != 4);
            
            // Fechando o Scanner
            scanner.close();
        }
    }

    // Método para exibir o menu de opções
    public static void exibirMenu() {
        System.out.println("\n_______ MENU: _______");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Realizar deposito");
        System.out.println("3 - Realizar saque");
        System.out.println("4 - Sair");
        System.out.println("_____________________");
        System.out.print("Escolha uma opcao: ");
    }
}

// Classe para armazenar os dados pessoais do cliente
class DadosPessoais {
    private final String nome;
    private final String sobrenome;
    private final String cpf;

    // Construtor para inicializar os dados pessoais
    public DadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    // Métodos para obter os dados pessoais
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }
}

// Classe para realizar as operações bancárias
class OperacoesBancarias {
    private double saldo;

    // Método para consultar o saldo
    public double consultarSaldo(DadosPessoais cliente) {
        return saldo;
    }

    // Método para realizar depósito
    public void realizarDeposito(DadosPessoais cliente, double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Deposito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor invalido.");
        }
    }
    
    // Método para realizar saque
    public void realizarSaque(DadosPessoais cliente, double valor) {
        if (saldo >= valor & valor > 0) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente para realizar o saque ou valor invalido.");
        }
    }
}


                
