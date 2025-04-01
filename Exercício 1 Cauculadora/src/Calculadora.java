import java.util.Scanner;

public class Calculadora {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Olá! Bem-vindo ");
        System.out.println("Escolha uma operação: +, -, * ou /");

        String operacao;
        while (true) {
            System.out.print("> ");
            operacao = scanner.nextLine().trim();
            if (operacao.matches("[+\\-*/]")) break;
            System.out.println(" Tente novamente.");
        }

        double num1 = lerNumero("Digite o primeiro número: ", scanner);
        double num2 = lerNumero("Digite o segundo número: ", scanner);

        if (operacao.equals("/") && num2 == 0) {
            System.out.println("Não da para dividir por zero.");
            scanner.close();
            return;
        }
        double resultado = switch (operacao) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> 0;
        };
        System.out.println("Resultado: " + num1 + " " + operacao + " " + num2 + " = " + resultado);
        System.out.println("Obrigado :)");

        scanner.close();
    }

    private static double lerNumero(String mensagem, Scanner scanner) {
        while (true) {
            System.out.print(mensagem);
            if (scanner.hasNextDouble()) return scanner.nextDouble();
            System.out.println("Entrada inválida! ");
            scanner.next();
        }
    }
}
