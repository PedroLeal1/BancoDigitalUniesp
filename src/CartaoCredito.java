import java.util.ArrayList;
import java.util.Date;

public class CartaoCredito {
    private double limiteCredito;
    private double saldoDisponivel;
    private Date dataVencimento;
    private ArrayList<String> historicoCompras;
    private boolean bloqueado;

    public CartaoCredito(double limiteCredito, double saldoDisponivel, Date dataVencimento) {
        this.limiteCredito = limiteCredito;
        this.saldoDisponivel = saldoDisponivel;
        this.dataVencimento = dataVencimento;
        this.historicoCompras = new ArrayList<>();
        this.bloqueado = false;
    }

    public CartaoCredito() {

    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public ArrayList<String> getHistoricoCompras() {
        return historicoCompras;
    }

    public void setHistoricoCompras(ArrayList<String> historicoCompras) {
        this.historicoCompras = historicoCompras;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String consultaFatura() {
        double fatura = limiteCredito - saldoDisponivel;
        return "Fatura atual: R$" + fatura;
    }

    public String bloquear() {
        if (bloqueado) {
            return "Cartão já está bloqueado";
        }

        bloqueado = true;
        return "Cartão bloqueado com sucesso";
    }

    public String desbloquear() {
        if (!bloqueado) {
            return "Cartão já está desbloqueado";
        }

        bloqueado = false;
        return "Cartão desbloqueado com sucesso";
    }

    public String aumentarLimite(double valor) {
        if (valor <= 0) {
            return "Valor inválido";
        }

        limiteCredito += valor;
        return "Limite aumentado para R$" + limiteCredito;
    }

    public String reduzirLimite(double valor) {
        if (valor <= 0 || valor >= limiteCredito) {
            return "Valor inválido";
        }

        limiteCredito -= valor;
        return "Limite reduzido para R$" + limiteCredito;
    }


    public String realizarCompra(double valor) {
        if (valor <= 0) {
            return "Valor inválido";
        }
        if (valor > saldoDisponivel) {
            return "Saldo insuficiente";
        }

        if (bloqueado) {
            return "Cartão bloqueado. Não é possível realizar compras";
        }

        saldoDisponivel -= valor;
        historicoCompras.add("Compra de R$" + valor);
        return "Compra de R$" + valor + " realizada com sucesso";
    }
    public String pagarFatura(double valor) {
        double fatura = limiteCredito - saldoDisponivel;
        if (valor <= 0) {
            return "Valor inválido";
        } else if (valor > fatura) {
            return "Valor maior que a fatura atual";
        } else {
            saldoDisponivel += valor;
            return "Pagamento de R$" + valor + " realizado com sucesso";
        }
    }

}