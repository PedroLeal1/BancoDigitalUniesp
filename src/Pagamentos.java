import java.util.Scanner;

public class Pagamentos {
    private double pagamentoCartao;
    private double pagamentoBoleto;
    private double pagamentoEmprestimo;
    private double contador;
    private double valorEmprestimo;
    private double contadorEmprestimo;

    public double getPagamentoEmprestimo() {
        return pagamentoEmprestimo;
    }

    public void setPagamentoEmprestimo(double pagamentoEmprestimo) {
        this.pagamentoEmprestimo = pagamentoEmprestimo;
    }

    public Pagamentos(double pagamentoCartao,double pagamentoEmprestimo) {
        this.pagamentoCartao = pagamentoCartao;
        this.pagamentoEmprestimo = pagamentoEmprestimo;

    }

    public double getContador() {
        return contador;
    }

    public void setContador(double contador) {
        this.contador = contador;
    }

    public void efetuarPagamento() {
        System.out.println("1 - Efetuar pagamento de Cartão de Crédito");
        System.out.println("2 - Efetuar pagamento de Boleto");
        System.out.println("3 - Efetuar pagamento de Empréstimo");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        if (numero == 1) {
            CartaoCredito cartao = new CartaoCredito();
            System.out.println("Fatura atual: " + pagamentoCartao);
            System.out.println("Qual o valor que deseja pagar (Cartão de Crédito)");
            double valor = scanner.nextDouble();
            cartao.realizarCompra(valor);
            pagamentoCartao -= valor;
            cartao.pagarFatura(valor);
            contador += valor;
            System.out.println("Valor pago: " + valor + " Fatura atual: " + pagamentoCartao);
            cartao.consultaFatura();
        } else if (numero == 2) {
            System.out.println("Digite quanto custa o boleto:");
            double valorBoleto = scanner.nextDouble();
            System.out.println("Digite o valor do pagamento: ");
            double pagamentoBoleto = scanner.nextDouble();
            while (pagamentoBoleto != valorBoleto) {
                System.out.println("Valor do pagamento deve ser igual ao valor integral do boleto. Digite novamente:");
                pagamentoBoleto = scanner.nextDouble();
            }
            System.out.println("Pagamento efetuado com sucesso. Valor pago: " + pagamentoBoleto);
        } else if (numero == 3) {
            System.out.println("Digite quanto custa o Emprestimo:");
            double valorEmprestimo = scanner.nextDouble();
            System.out.println("Digite o valor do pagamento: ");
            double pagamentoEmprestimo = scanner.nextDouble();
            while (pagamentoEmprestimo != valorEmprestimo) {
                System.out.println("Valor do pagamento deve ser igual ao valor integral do Emprestimo. Digite novamente:");
                pagamentoEmprestimo = scanner.nextDouble();
            }
            System.out.println("Pagamento efetuado com sucesso. Valor pago: " + pagamentoEmprestimo);
        } else {
            System.out.println("Opção inválida. Tente novamente.");
        }
    }
}