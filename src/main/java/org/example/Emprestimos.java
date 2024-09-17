package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.Equipamentos.*;
import static org.example.Funcionarios.exibirFuncionarios;
import static org.example.Funcionarios.funcionariosList;

public class Emprestimos {
    private String codigo;
    private static List<Emprestimos> emprestimosList = new ArrayList<>();
    private String dataSaida;
    private String horaSaida;
    private String dataRetorno;
    private String horaRetorno;
    private Funcionarios funcionario;
    private Equipamentos equipamento;
    private String observacoes;
    private Boolean concluido = false;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static List<Emprestimos> getEmprestimosList() {
        return emprestimosList;
    }

    public static void setEmprestimosList(List<Emprestimos> emprestimosList) {
        Emprestimos.emprestimosList = emprestimosList;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }

    public String getHoraRetorno() {
        return horaRetorno;
    }

    public void setHoraRetorno(String horaRetorno) {
        this.horaRetorno = horaRetorno;
    }

    public Funcionarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionarios funcionario) {
        this.funcionario = funcionario;
    }

    public Equipamentos getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamentos equipamento) {
        this.equipamento = equipamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Boolean isEmprestimoDisponivel(Emprestimos emprestimo){
        return emprestimo.concluido;
    }

    public static void setConcluido(Emprestimos emprestimo){
        emprestimo.concluido = true;
    }

    public static void cadastrarEmprestimos() {
        Scanner scanner = new Scanner(System.in);

        if (funcionariosList.isEmpty()) {
            System.out.println("Não há funcionários cadastrados. Não é possível realizar o empréstimo.");
            return;
        }

        if (getEquipamentosList().isEmpty()) {
            System.out.println("Não há equipamentos cadastrados. Não é possível realizar o empréstimo.");
            return;
        }

        System.out.println("Funcionários Disponíveis: ");
        exibirFuncionarios();
        System.out.println("Escolher Funcionário (código): ");
        int codigoFuncionario = scanner.nextInt();
        scanner.nextLine();

        Funcionarios funcionarioSelecionado = null;
        for (Funcionarios funcionario : funcionariosList) {
            if (funcionario.getCodigo() == codigoFuncionario) {
                funcionarioSelecionado = funcionario;
                break;
            }
        }

        if (funcionarioSelecionado == null) {
            System.out.println("Funcionário não foi encontrado.");
            return;
        }

        System.out.println("Equipamentos Disponíveis: ");
        exibirEquipamentos();
        System.out.println("Escolher Equipamento (código): ");
        int codigoEquipamento = scanner.nextInt();
        scanner.nextLine();

        Equipamentos equipamentoSelecionado = null;
        for (Equipamentos equipamento : getEquipamentosList()) {
            if (equipamento.getCodigo() == codigoEquipamento) {
                equipamentoSelecionado = equipamento;
                break;
            }
        }

        if (equipamentoSelecionado == null) {
            System.out.println("Equipamento não foi encontrado.");
            return;
        }

        if (!isEquipamentoDisponivel(equipamentoSelecionado)) {
            System.out.println("Equipamento indisponível.");
            return;
        }

        Emprestimos emprestimo = new Emprestimos();

        emprestimo.setFuncionario(funcionarioSelecionado);
        emprestimo.setEquipamento(equipamentoSelecionado);

        System.out.println("Digite o código do empréstimo:");
        emprestimo.setCodigo(scanner.nextLine());
        System.out.println("Data de Saída: ");
        emprestimo.setDataSaida(scanner.nextLine());
        System.out.println("Hora de Saída: ");
        emprestimo.setHoraSaida(scanner.nextLine());
        System.out.println("Data de Retorno: ");
        emprestimo.setDataRetorno(scanner.nextLine());
        System.out.println("Hora de Retorno: ");
        emprestimo.setHoraRetorno(scanner.nextLine());
        System.out.println("Observações: ");
        emprestimo.setObservacoes(scanner.nextLine());

        equipamentoSelecionado.setIndisponivel();
        emprestimosList.add(emprestimo);
        System.out.println("Empréstimo registrado com sucesso!");
    }


    public static void exibirEmprestimos() {
        if (emprestimosList.isEmpty()){
            System.out.println("Não há emprestimos disponíveis no sistema");
        }
        else {
            int i = 0;
            for (Emprestimos emprestimo : emprestimosList) {
                System.out.println(i + 1 + "- " + emprestimo);
                i++;
            }
        }
    }

    public static void atualizarEmprestimos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Empréstimos realizados: ");
        exibirEmprestimos();
        System.out.println("Digite o código do empréstimo que deseja atualizar: ");
        String codigo = scanner.nextLine();

        for (Emprestimos emprestimo : emprestimosList){
            if (codigo.equals(emprestimo.getCodigo())){
                System.out.println("Atualizar informações do empréstimo:");
                System.out.println("Nova Data de Saída: ");
                emprestimo.setDataSaida(scanner.nextLine());
                System.out.println("Nova Hora de Saída: ");
                emprestimo.setHoraSaida(scanner.nextLine());
                System.out.println("Nova Data de Retorno: ");
                emprestimo.setDataRetorno(scanner.nextLine());
                System.out.println("Nova Hora de Retorno: ");
                emprestimo.setHoraRetorno(scanner.nextLine());
                System.out.println("Observações adicionais: ");
                emprestimo.setObservacoes(scanner.nextLine());

                System.out.println("Empréstimo atualizado com sucesso!");

                return;
            }
        }
        System.out.println("Empréstimo não encontrado");
    }

    public static void excluirEmprestimos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirEmprestimos();
        System.out.println();
        System.out.println("Digite o código do empréstimo que deseja excluir: ");
        String codigo = scanner.nextLine();

        Emprestimos emprestimosRemovido = null;
        for (Emprestimos emprestimo : emprestimosList) {
            if (codigo.equals(emprestimo.getCodigo())) {
                emprestimosRemovido = emprestimo;
                break;
            }
        }

        if (emprestimosRemovido != null) {
            emprestimosList.remove(emprestimosRemovido);
            System.out.println("Empréstimo excluído com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado.");
        }
    }

    public static void concluirEmprestimos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Empréstimos realizados: ");
        exibirEmprestimos();
        System.out.println("Digite o código do empréstimo que deseja concluir: ");
        String codigo = scanner.nextLine();
        scanner.nextLine();

        for (Emprestimos emprestimo : emprestimosList){
            if (codigo.equals(emprestimo.getCodigo())){
                setConcluido(emprestimo);
                emprestimo.getEquipamento().setDisponivel();
                System.out.println("Empréstimo concluído com sucesso!");
                return;
            }
        }

        System.out.println("Empréstimo não encontrado.");
    }


    @Override
    public String toString() {
        return "Emprestimo -" +
                " Código: " + codigo +
                " - Concluido: " + (concluido ? "sim" : "não") +
                " - Equipamento: " + equipamento.getCodigo() +
                " - Funcionario: " + funcionario.getNome() +
                " - Hora de retorno: " + horaRetorno +
                " - Data de retorno: " + dataRetorno +
                " - Hora de saida: " + horaSaida +
                " - Data de saida: " + dataSaida;
    }

}
