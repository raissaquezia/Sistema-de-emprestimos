package org.example;

import java.util.LinkedList;
import java.util.Scanner;

public class Funcionarios {
    static LinkedList<Funcionarios> funcionariosList = new LinkedList<>();
    private int codigo;
    private String nome;
    private String funcao;
    private String dataAdmissao;

    public Funcionarios(int codigo, String nome, String funcao, String dataAdmissao) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcao = funcao;
        this.dataAdmissao = dataAdmissao;
    }

    public static LinkedList<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public static void setFuncionariosList(LinkedList<Funcionarios> funcionariosList) {
        Funcionarios.funcionariosList = funcionariosList;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public static void addFuncionario(Funcionarios funcionario){
        funcionariosList.add(funcionario);
    }

    public static void cadastrarFuncionarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Função: ");
        String funcao = scanner.nextLine();
        System.out.println("Data de Admissão: ");
        String dataAdmissao = scanner.nextLine();

        Funcionarios funcionario = new Funcionarios(codigo, nome, funcao, dataAdmissao);
        addFuncionario(funcionario);
        System.out.println("Funcionário foi cadastrado com sucesso.");
    }

    public static void exibirFuncionarios() {
        int i = 0;
        if (funcionariosList.isEmpty()) {
            System.out.println("Nenhum funcionário foi cadastrado.");
        } else {
            for (Funcionarios funcionario : funcionariosList) {
                System.out.print(i + 1 + "- ");
                System.out.print("Código: " + funcionario.getCodigo());
                System.out.print(" - Nome: " + funcionario.getNome());
                System.out.print(" - Função: " + funcionario.getFuncao());
                System.out.print(" - Data de Admissão: " + funcionario.getDataAdmissao());
                System.out.println();
                i++;
            }
        }
    }

    public static void atualizarFuncionarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirFuncionarios();
        System.out.println();
        System.out.println("Digite o código do funcionário para atualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Funcionarios funcionario : funcionariosList) {
            if (funcionario.getCodigo() == codigo) {
                System.out.println("Novo Nome: ");
                funcionario.setNome(scanner.nextLine());
                System.out.println("Nova Função: ");
                funcionario.setFuncao(scanner.nextLine());
                System.out.println("Nova Data de Admissão: ");
                funcionario.setDataAdmissao(scanner.nextLine());
                System.out.println("Funcionário atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Funcionário não foi encontrado.");
    }

    public static void excluirFuncionarios() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirFuncionarios();
        System.out.println();
        System.out.println("Digite o código do funcionário para excluir: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Funcionarios funcionarioToRemove = null;
        for (Funcionarios funcionario : funcionariosList) {
            if (funcionario.getCodigo() == codigo) {
                funcionarioToRemove = funcionario;
                break;
            }
        }
        if (funcionarioToRemove != null) {
            funcionariosList.remove(funcionarioToRemove);
            System.out.println("Funcionário foi excluído com sucesso.");
        } else {
            System.out.println("Funcionário não foi encontrado.");
        }
    }
}
