import java.util.ArrayList;

public class ContaCorrente {

    private String nomeTitular;
    private double saldo;
    private int numeroConta;
    private ArrayList<String> historico;
    private double limiteChequeEspecial;

    public ContaCorrente(String nomeTitular, double saldo, int numeroConta, double limiteChequeEspecial) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.historico = new ArrayList<String>();
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public ArrayList<String> getHistorico() {
        return historico;
    }

    public void setHistorico(ArrayList<String> historico) {
        this.historico = historico;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                ", numeroConta=" + numeroConta +
                ", historico=" + historico +
                ", limiteChequeEspecial=" + limiteChequeEspecial +
                '}';
    }


    public String transferencia(int numeroContaDestino, double valor) {
        if (valor > saldo) {
            return "Saldo insuficiente";
        }
        saldo -= valor;
        historico.add("Transferência para a conta " + numeroContaDestino + ": " + valor);
        return "Transferencia realizada com sucesso";
    }
    public String deposito(double valor) {

        saldo += valor;
        historico.add("Deposito realizado com sucesso " + "no valor de " + valor);
        return "Transferencia realizada com sucesso";
    }
    public String saque(double valor) {
        if (valor > saldo) {
            return "Saldo insuficiente";
        }
        saldo -= valor;
        historico.add("Saque realizado com sucesso " + "no valor de " + valor);
        return "Transferencia realizada com sucesso";
    }
    public void consultaSaldo(){
        System.out.println("o seu saldo é: " + getSaldo());
    }

}