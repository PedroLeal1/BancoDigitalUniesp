import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        ContaCorrente conta1 = new ContaCorrente("Pedro", 8000, 123, 10000);
        SimpleDateFormat formato = new SimpleDateFormat("MM/yy");
        Date dataValidade = formato.parse("01/25");
        CartaoCredito cartao = new CartaoCredito(10000, 5000, dataValidade);
        Investimentos investimentos = new Investimentos("BITCOIN", 1000, 3, 052023);
        Emprestimo emprestimo = new Emprestimo(0, 10);
        Pagamentos pagamentos = new Pagamentos((cartao.getLimiteCredito() - cartao.getSaldoDisponivel()),100+ emprestimo.getDivida());




        boolean isValid;
        do {
            isValid = false;
            System.out.println(" 1- CONTA CORRENTE  ");
            System.out.println(" 2- cartao de credito  ");
            System.out.println(" 3 - INVESTIMENTOS");
            System.out.println(" 4 - EMPRÉSTIMO");
            System.out.println(" 5 - Realizar Pagamentos");
            System.out.println("0 - Sair");
            int opcao1;
            opcao1 = scanner.nextInt();

            if (opcao1 == 1) {
                Boolean isValidCorrente;
                do {
                    isValidCorrente = false;
                    System.out.println(" - CONTA CORRENTE  ");
                    System.out.println("Escolha uma opção: ");
                    System.out.println("1--Transferência   ");
                    System.out.println("2 - Depósito       ");
                    System.out.println("3 - Saque          ");
                    System.out.println("4 - Consultar saldo");
                    System.out.println("0 -  Voltar ao Menu do Banco");
                    int opcao;
                    opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.println("Digite o número da conta de destino:");
                            int numeroConta = scanner.nextInt();
                            System.out.println("Digite o valor da transferência:");
                            double valor = scanner.nextDouble();
                            System.out.println(conta1.transferencia(numeroConta, valor));
                            System.out.println(conta1.toString());
                            break;
                        case 2:
                            System.out.println("Digite o valor do depósito:");
                            valor = scanner.nextDouble();
                            conta1.deposito(valor);
                            System.out.println("Depósito realizado com sucesso");
                            System.out.println(conta1.toString());
                            break;
                        case 3:
                            System.out.println("Digite o valor do saque:");
                            valor = scanner.nextDouble();
                            System.out.println(conta1.saque(valor));
                            System.out.println(conta1.toString());
                            break;
                        case 4:
                            conta1.consultaSaldo();
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            isValidCorrente = true;
                            break;

                        default:
                            System.out.println("Opção inválida");
                    }

                } while (isValidCorrente == false);
            } else if (opcao1 == 2) {

                boolean isValidCredito = false;
                while (!isValidCredito) {
                    System.out.println("\n--- Menu ---");
                    System.out.println("1. Consultar fatura");
                    System.out.println("2. Realizar pagamento da fatura do Cartão");
                    System.out.println("3. Bloquear cartão");
                    System.out.println("4. Desbloquear cartão");
                    System.out.println("5. Aumentar limite de crédito");
                    System.out.println("6. Reduzir limite de crédito");
                    System.out.println("7. Realizar compra");
                    System.out.println("0. Voltar ao Menu do Banco");

                    System.out.print("Escolha uma opção: ");
                    int opcaoCredito;
                    opcaoCredito = scanner.nextInt();

                    switch (opcaoCredito) {
                        case 1:
                            System.out.println(cartao.consultaFatura());
                            break;
                        case 2:
                            System.out.print("Digite o valor do pagamento: ");
                            double valorPagamento = scanner.nextDouble();
                            System.out.println(cartao.pagarFatura(valorPagamento));
                            break;
                        case 3:
                            System.out.println(cartao.bloquear());
                            break;
                        case 4:
                            System.out.println(cartao.desbloquear());
                            break;
                        case 5:
                            System.out.print("Digite o valor do aumento de limite: ");
                            double valorAumento = scanner.nextDouble();
                            System.out.println(cartao.aumentarLimite(valorAumento));
                            break;
                        case 6:
                            System.out.print("Digite o valor da redução de limite: ");
                            double valorReducao = scanner.nextDouble();
                            System.out.println(cartao.reduzirLimite(valorReducao));
                            break;
                        case 7:
                            System.out.print("Digite o valor da compra: ");
                            double valorCompra = scanner.nextDouble();
                            System.out.println(cartao.realizarCompra(valorCompra));
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            isValidCredito = true;
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                }
            } //LEMBRAR DE VERIFICAR CLASSE INVESTIMENTO
            else if (opcao1 == 3) {
                boolean isValidInvestimento;
                do {
                    isValidInvestimento = false;
                    System.out.println(" - INVESTIMENTOS  ");
                    System.out.println("Escolha uma opção: ");
                    System.out.println("1 - Realizar Investimento");
                    System.out.println("2 - Resgatar investimento");
                    System.out.println("3 - Consultar rendimento");
                    System.out.println("0 - Voltar ao Menu do Banco");
                    int opcaoInv;
                    opcaoInv = scanner.nextInt();

                    switch (opcaoInv) {
                        case 1:
                            System.out.println("Digite o valor da compra:");
                            double valor = scanner.nextDouble();
                            System.out.println("Digite o qtd de meses:");
                            int meses = scanner.nextInt();
                            System.out.println(investimentos.realizarInvestimento(valor,meses));
                            //investimentos.toString();
                            break;
                        case 2:
                            investimentos.resgatarInvestimento();
                            //System.out.println(investimentos.toString());
                            break;
                        case 3:
                            investimentos.consultarRentabilidade();
                            break;
                        case 0:
                            System.out.println("Voltando ao Menu do Banco...");
                            isValidInvestimento = true;
                            break;
                        default:
                            System.out.println("Opção inválida. Digite novamente.");
                            isValidInvestimento = true;
                            break;
                    }
                } while (!isValidInvestimento);
            }else if (opcao1 == 4) {
                boolean sair = false;
                while (!sair) {
                    System.out.println("\n--- EMPRÉSTIMO ---");
                    System.out.println("1 - Pegar empréstimo");
                    System.out.println("2 - Pagar empréstimo");
                    System.out.println("3 - Verificar dívida");
                    System.out.println("0 - Sair");

                    System.out.print("Escolha uma opção: ");
                    int opcao = scanner.nextInt();

                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o valor do empréstimo: R$");
                            double valorEmprestimo = scanner.nextDouble();
                            emprestimo.pegarEmprestimo(valorEmprestimo);
                            break;
                        case 2:
                            System.out.print("Digite o valor do pagamento: R$");
                            double valorPagamento = scanner.nextDouble();
                            emprestimo.pagarEmprestimo(valorPagamento);
                            break;
                        case 3:
                            emprestimo.verificarDivida();
                            break;
                        case 0:
                            sair = true;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }

            }
            else if (opcao1 == 5) {
                boolean isValidPagamento = false;
                while(!isValidPagamento) {


                    //double aux = emprestimo.getDivida();
                    pagamentos.efetuarPagamento();
                    System.out.println("Deseja Pagar mais alguma coisa? 1-Sim/2-Não");
                    int aux1 = scanner.nextInt();
                    if(aux1 ==2){
                        isValidPagamento = true;
                    }
                }

            }
            else if (opcao1 == 0) {
                isValid = true;
            }

        } while (isValid == false);


        scanner.close();
    }
}