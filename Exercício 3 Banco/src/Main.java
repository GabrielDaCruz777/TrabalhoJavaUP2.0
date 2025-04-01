import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Conta {
    String nome;
    double saldo;

    Conta(String nome, double depositoInicial) {
        this.nome = nome;
        this.saldo = depositoInicial;
    }

    void depositar(double valor) {
        saldo += valor;
    }

    boolean sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Conta> contas = new HashMap<>();

        while (true) {
            System.out.println("\n1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Sair");
            System.out.print("> ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Depósito inicial: ");
                double deposito = scanner.nextDouble();
                contas.put(nome, new Conta(nome, deposito));
            } else if (opcao == 2) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                if (contas.containsKey(nome)) {
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    contas.get(nome).depositar(valor);
                }
            } else if (opcao == 3) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                if (contas.containsKey(nome)) {
                    System.out.print("Valor: ");
                    double valor = scanner.nextDouble();
                    if (!contas.get(nome).sacar(valor)) {
                        System.out.println("Saldo insuficiente.");
                    }
                }
            } else if (opcao == 4) {
                break;
            }
        }
        scanner.close();
    }
}
