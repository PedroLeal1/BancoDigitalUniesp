import java.text.DecimalFormat;

public class ContaPoupanca
{
    private double saldoPoupanca = 0;
    private double rendimento;

    public ContaPoupanca(double saldoPoupanca, double rendimento) {
        this.saldoPoupanca = saldoPoupanca;
        this.rendimento = rendimento;
    }

    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }

    public void setSaldoPoupanca(double saldoPoupanca) {
        this.saldoPoupanca = saldoPoupanca;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(int rendimento) {
        this.rendimento = rendimento;
    }

    public void adicionarValorPoupanca(double valor) {
        this.saldoPoupanca += valor;
    }
    public String mostrarSaldoPoupanca() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return "O saldo da conta Poupanca é r$: " + df.format(this.saldoPoupanca);
    }
    public String redimentoPoupanca(){
        double aux = this.saldoPoupanca * this.rendimento;
        double valor = this.saldoPoupanca + this.saldoPoupanca * this.rendimento;
        setSaldoPoupanca(valor);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        return "Foi adicionado $"+df.format(aux)+" e o valor total ficou: "+df.format(this.saldoPoupanca);

    }

}