package org.example;

import java.util.Scanner;

import static org.example.Emprestimos.*;
import static org.example.Equipamentos.*;
import static org.example.Funcionarios.*;


public class App {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Menu Principal:");
            System.out.println("1. Menu Funcionários");
            System.out.println("2. Menu Equipamentos");
            System.out.println("3. Menu Emprestimo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> menuFuncionarios();
                case 2 -> menuEquipamentos();
                case 3 -> menuEmprestimo();
                case 0 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }
    
    private static void menuFuncionarios() {
        boolean running = true;
        while (running) {
            System.out.println("Menu Funcionários:");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Exibir Funcionário");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarFuncionarios();
                case 2 -> exibirFuncionarios();
                case 3 -> atualizarFuncionarios();
                case 4 -> excluirFuncionarios();
                case 0 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuEquipamentos() {
        boolean running = true;
        while (running) {
            System.out.println("Menu Equipamentos:");
            System.out.println("1. Cadastrar Equipamentos");
            System.out.println("2. Exibir Equipamentos");
            System.out.println("3. Atualizar Equipamentos");
            System.out.println("4. Excluir Equipamentos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarEquipamentos();
                case 2 -> exibirEquipamentos();
                case 3 -> atualizarEquipamentos();
                case 4 -> excluirEquipamentos();
                case 0 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void menuEmprestimo() {
        boolean running = true;
        while (running) {
            System.out.println("Menu Empréstimos:");
            System.out.println("1. Cadastrar Empréstimo");
            System.out.println("2. Exibir Empréstimo");
            System.out.println("3. Atualizar Empréstimo");
            System.out.println("4. Excluir Empréstimo");
            System.out.println("5. Devolução de Equipamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarEmprestimos();
                case 2 -> exibirEmprestimos();
                case 3 -> atualizarEmprestimos();
                case 4 -> excluirEmprestimos();
                case 5 -> concluirEmprestimos();
                case 0 -> running = false;
                default -> System.out.println("Opção inválida.");
            }
        }
    }






}
