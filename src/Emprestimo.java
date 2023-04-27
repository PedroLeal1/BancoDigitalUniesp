import java.util.Scanner;

public class Emprestimo {
    private double divida;
    private double juros;

    public Emprestimo(double divida, double juros) {
        this.divida = divida;
        this.juros = juros;
    }
    public Emprestimo(){

    }

    public void setDivida(double divida) {
        this.divida = divida;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getDivida() {
        return divida;
    }

    public void pegarEmprestimo(double valor) {
        this.divida += valor + (valor * 0.10);
        System.out.printf("Empréstimo de R$%.2f realizado com sucesso.\n", valor);
        this.verificarDivida();
    }

    public void pagarEmprestimo(double valor) {
        if (valor >= this.divida) {
            valor = this.divida;
        }
        this.divida -= valor;
        System.out.printf("Pagamento de R$%.2f realizado com sucesso.\n", valor);
        this.verificarDivida();
    }

    public void verificarDivida() {
        if (this.divida > 0) {
            System.out.printf("Valor da dívida: R$%.2f. Juros de %.2f%%.\n", this.divida, this.juros);
        } else {
            System.out.println("Não há dívida.");
        }
    }


}