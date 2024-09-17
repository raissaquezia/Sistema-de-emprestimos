package org.example;

import org.example.enums.EstadoConservacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Equipamentos {
    private static List<Equipamentos> equipamentosList = new ArrayList<>();
    private int codigo;
    private String nome;
    private String descricao;
    private String dataCompra;
    private double peso;
    private double largura;
    private double comprimento;
    private EstadoConservacao estadoConservacao;
    private Boolean disponivel = true;
    private ArrayList<String> historicoManutencao;

    public Equipamentos(int codigo, String nome, String descricao, String dataCompra, double peso, double largura, double comprimento, EstadoConservacao estadoConservacao, ArrayList<String> historicoManutencao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCompra = dataCompra;
        this.peso = peso;
        this.largura = largura;
        this.comprimento = comprimento;
        this.estadoConservacao = estadoConservacao;
        this.historicoManutencao = historicoManutencao != null ? historicoManutencao: new ArrayList<>();
    }

    public static List<Equipamentos> getEquipamentosList() {
        return equipamentosList;
    }

    public static void setEquipamentosList(List<Equipamentos> equipamentosList) {
        Equipamentos.equipamentosList = equipamentosList;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    public EstadoConservacao getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(EstadoConservacao estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public ArrayList<String> getHistoricoManutencao() {
        return historicoManutencao;
    }

    public void setHistoricoManutencao(ArrayList<String> historicoManutencao) {
        this.historicoManutencao = historicoManutencao;
    }

    public static Boolean isEquipamentoDisponivel(Equipamentos equipamento){
        if (equipamento.disponivel){
            return true;
        }
        return false;
    }

    public void setDisponivel() {
        this.disponivel = true;
    }

    public void setIndisponivel(){
        this.disponivel = false;
    }

    public void adicionarManutencao(String manutencao) {
        historicoManutencao.add(manutencao);
    }


    public static void exibirEquipamentos() {
        if (equipamentosList.isEmpty()) {
            System.out.println("Nenhum equipamento foi cadastrado.");
        } else {
            for (Equipamentos equipamento : equipamentosList) {
                System.out.print("Código: " + equipamento.getCodigo());
                System.out.print(" - Nome: " + equipamento.getNome());
                System.out.print(" - Descrição: " + equipamento.getDescricao());
                System.out.print(" - Data de Compra: " + equipamento.getDataCompra());
                System.out.print(" - Peso: " + equipamento.getPeso());
                System.out.print(" - Largura: " + equipamento.getLargura());
                System.out.print(" - Comprimento: " + equipamento.getComprimento());
                System.out.print(" - Estado de Conservação: " + equipamento.getEstadoConservacao());
                System.out.print(" - Histórico de Manutenção: " + equipamento.getHistoricoManutencao());
                System.out.println();
            }
        }
    }

    public static void cadastrarEquipamentos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Codigo: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de Compra: ");
        String dataCompra = scanner.nextLine();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Largura: ");
        double largura = scanner.nextDouble();
        System.out.print("Comprimento: ");
        double comprimento = scanner.nextDouble();
        scanner.nextLine();

        EstadoConservacao estadoConservacao = null;
        while (estadoConservacao == null) {
            System.out.print("Estado de Conservação (1 - RUIM, 2 - BOM, 3 - OTIMO): ");
            int estadoEscolhido = scanner.nextInt();
            switch (estadoEscolhido) {
                case 1:
                    estadoConservacao = EstadoConservacao.RUIM;
                    break;
                case 2:
                    estadoConservacao = EstadoConservacao.BOM;
                    break;
                case 3:
                    estadoConservacao = EstadoConservacao.OTIMO;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
        scanner.nextLine();

        System.out.print("Histórico de Manutenção: ");
        String manutencaoInput = scanner.nextLine();
        String[] manutencaoArray = manutencaoInput.split(",");
        ArrayList<String> historicoManutencao = new ArrayList<>();
        for (String manutencao : manutencaoArray) {
            historicoManutencao.add(manutencao.trim());
        }

        Equipamentos equipamento = new Equipamentos(codigo, nome, descricao, dataCompra, peso, largura, comprimento, estadoConservacao, historicoManutencao);
        equipamentosList.add(equipamento);
        System.out.println("Equipamento cadastrado com sucesso!");
    }

    public static void atualizarEquipamentos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirEquipamentos();
        System.out.println();
        System.out.println("Digite o código do equipamento para atualizar: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Equipamentos equipamento : equipamentosList) {
            if (equipamento.getCodigo() == codigo) {
                System.out.println("Novo nome: ");
                equipamento.setNome(scanner.nextLine());
                System.out.println("Nova Descrição: ");
                equipamento.setDescricao(scanner.nextLine());
                System.out.println("Nova Data de Compra: ");
                equipamento.setDataCompra(scanner.nextLine());
                System.out.println("Novo Peso(kg): ");
                equipamento.setPeso(scanner.nextDouble());
                System.out.println("Nova Largura(m): ");
                equipamento.setLargura(scanner.nextDouble());
                System.out.println("Novo Comprimento(m): ");
                equipamento.setComprimento(scanner.nextDouble());
                scanner.nextLine();

                EstadoConservacao novoEstadoConservacao = null;
                while (novoEstadoConservacao == null) {
                    System.out.print("Novo Estado de Conservação (1 - RUIM, 2 - BOM, 3 - OTIMO): ");
                    int estadoEscolhido = scanner.nextInt();
                    switch (estadoEscolhido) {
                        case 1:
                            novoEstadoConservacao = EstadoConservacao.RUIM;
                            break;
                        case 2:
                            novoEstadoConservacao = EstadoConservacao.BOM;
                            break;
                        case 3:
                            novoEstadoConservacao = EstadoConservacao.OTIMO;
                            break;
                        default:
                            System.out.println("Opção inválida. Por favor, tente novamente.");
                    }
                }
                scanner.nextLine();
                equipamento.setEstadoConservacao(novoEstadoConservacao);

                System.out.println("Novo Histórico de Manutenção: ");
                String manutencaoInput = scanner.nextLine();
                String[] manutencaoArray = manutencaoInput.split(",");
                ArrayList<String> historicoManutencao = new ArrayList<>();
                for (String manutencao : manutencaoArray) {
                    historicoManutencao.add(manutencao.trim());
                }
                equipamento.setHistoricoManutencao(historicoManutencao);

                System.out.println("Equipamento atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Equipamento não foi encontrado.");
    }

    public static void excluirEquipamentos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirEquipamentos();
        System.out.println();
        System.out.println("Digite o código do equipamento para excluir: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        Equipamentos equipamentoToRemove = null;
        for (Equipamentos equipamento : equipamentosList) {
            if (equipamento.getCodigo() == codigo) {
                equipamentoToRemove = equipamento;
                break;
            }
        }
        if (equipamentoToRemove != null) {
            equipamentosList.remove(equipamentoToRemove);
            System.out.println("Equipamento foi excluído com sucesso.");
        } else {
            System.out.println("Equipamento não foi encontrado.");
        }
    }

    public static void adicionarManutencaoPorCodigo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        exibirEquipamentos();
        System.out.println();
        System.out.print("Digite o código do equipamento: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for (Equipamentos equipamento : equipamentosList) {
            if (equipamento.getCodigo() == codigo) {

                System.out.print("Digite a descrição da manutenção: ");
                String manutencao = scanner.nextLine();

                equipamento.adicionarManutencao(manutencao);
                System.out.println("Manutenção adicionada ao equipamento com sucesso.");
                return;
            }
        }

        System.out.println("Equipamento não encontrado.");
    }

}
