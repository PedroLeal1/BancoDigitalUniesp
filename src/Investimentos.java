import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Investimentos {
    private String tipoInvestimento;
    private double valorAplicado;
    private double taxaJuros;
    private int prazoVencimento;
    private List<Double> historicoInvestimentos;

    public Investimentos(String tipoInvestimento, double valorAplicado, double taxaJuros, int prazoVencimento) {
        this.tipoInvestimento = tipoInvestimento;
        this.valorAplicado = valorAplicado;
        this.taxaJuros = taxaJuros;
        this.prazoVencimento = prazoVencimento;
        this.historicoInvestimentos = new ArrayList<>();
    }

    public void consultarRentabilidade() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tempo de investimento em meses:");
        int tempoInvestimento = scanner.nextInt();
        double rendimento = valorAplicado * Math.pow(1 + (taxaJuros / 100), tempoInvestimento / 12.0) - valorAplicado;
        System.out.printf("O rendimento estimado é de R$ %.2f\n", rendimento);
    }

    public boolean realizarInvestimento(double valorInvestimento, int duracaoEmMeses) {
        double valorTotalInvestido = 0;
        for (int i = 0; i < duracaoEmMeses; i++) {
            valorAplicado += valorInvestimento;
            double rendimento = valorAplicado * (taxaJuros / 100);
            valorAplicado += rendimento;
            valorTotalInvestido += valorInvestimento;
        }
        System.out.printf("Foram investidos R$ %.2f em %d meses, totalizando R$ %.2f com rendimentos.\n",
                valorTotalInvestido, duracaoEmMeses, valorAplicado - valorTotalInvestido);
        historicoInvestimentos.add(valorTotalInvestido);
        return false;
    }

    public boolean resgatarInvestimento() {
        System.out.printf("Valor resgatado: R$ %.2f\n", valorAplicado);
        historicoInvestimentos.add(-valorAplicado);
        valorAplicado = 0;
        return false;
    }

    public void exibirHistoricoInvestimentos() {
        System.out.println("Histórico de investimentos:");
        System.out.println("--------------------------");
        for (double valor : historicoInvestimentos) {
            if (valor > 0) {
                System.out.printf("Investimento de R$ %.2f realizado.\n", valor);
            } else {
                System.out.printf("Resgate de R$ %.2f realizado.\n", -valor);
            }
        }
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Investimentos investimentos = new Investimentos("Poupança", 1000.0, 6.0, 12);
        investimentos.consultarRentabilidade();

        ContaInvestimento contaInvestimento = new ContaInvestimento(2000.0);
        contaInvestimento.rendimentoInvestimento();
    }
}

class ContaInvestimento {
    private double saldo;

    public ContaInvestimento(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void rendimentoInvestimento() {
        double rendimento = saldo * 0.10;
        saldo += rendimento;
        System.out.printf("Rendimento de R$ %.2f aplicado. Saldo atual: R$ %.2f\n", rendimento, saldo);
    }
}