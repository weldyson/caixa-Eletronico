import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conta conta = new Conta(0); // Inicia a conta com saldo 0

        while (true) {
            System.out.println("\nBem-vindo ao Simulador de Caixa Eletrônico!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depósito");
            System.out.println("3. Saque");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1: // Consulta de Saldo
                    System.out.println("\nSeu saldo atual é: R$" + String.format("%.2f", conta.getSaldo()));
                    break;
                case 2: // Depósito
                    System.out.print("\nInforme o valor do depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3: // Saque
                    System.out.print("\nInforme o valor do saque: R$");
                    double valorSaque = scanner.nextDouble();
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para o saque.");
                    }
                    break;
                case 4: // Sair
                    System.out.println("\nObrigado por usar nosso simulador. Até mais!");
                    return;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
    }

    static class Conta {
        private double saldo;

        public Conta(double saldoInicial) {
            this.saldo = saldoInicial;
        }

        public void depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
            } else {
                System.out.println("O valor do depósito deve ser positivo.");
            }
        }

        public boolean sacar(double valor) {
            if (valor <= saldo) {
                saldo -= valor;
                return true;
            } else {
                return false;
            }
        }

        public double getSaldo() {
            return saldo;
        }
    }
}
