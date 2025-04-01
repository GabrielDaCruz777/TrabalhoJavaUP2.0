import java.util.ArrayList;
import java.util.Scanner;

class Pizza {
    String nome;
    double valor;
    ArrayList<String> ingredientes;

    Pizza(String nome, double valor, ArrayList<String> ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    void mostrarInfo() {
        System.out.println(" Pizza: " + nome);
        System.out.println(" Preço: R$ " + valor);
        System.out.println(" Ingredientes: " + String.join(", ", ingredientes));
    }
}

class Pedido {
    static int contador = 0;
    int numero;
    Pizza pizza;
    String tamanho;
    String endereco;
    boolean cancelado;

    Pedido(Pizza pizza, String tamanho, String endereco) {
        this.numero = ++contador;
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.endereco = endereco;
        this.cancelado = false;
    }

    double calcularTotal() {
        double preco = pizza.valor;
        if (tamanho.equals(" Grande ")) return preco * 1.5;
        if (tamanho.equals(" Média ")) return preco * 1.2;
        return preco;
    }

    void mostrarInfo() {
        System.out.println("\n Pedido #" + numero);
        System.out.println(" Status: " + (cancelado ? " Cancelado " : " Ativo "));
        pizza.mostrarInfo();
        System.out.println(" Tamanho: " + tamanho);
        System.out.println( "Endereço: " + endereco);
        System.out.println(" Total: R$ " + calcularTotal());
    }
}

public class GerenciadorPizzaria {
    static ArrayList<Pizza> menu = new ArrayList<>();
    static ArrayList<Pedido> pedidos = new ArrayList<>();
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> ingredientes = new ArrayList<>();
        ingredientes.add(" Molho de Tomate ");
        ingredientes.add(" Mussarela ");
        menu.add(new Pizza(" Margherita ", 35.0, ingredientes));

        ingredientes = new ArrayList<>();
        ingredientes.add(" Molho de Tomate ");
        ingredientes.add(" Mussarela ");
        ingredientes.add(" Calabresa ");
        ingredientes.add(" Cebola ");
        menu.add(new Pizza(" Calabresa ", 40.0, ingredientes));

        ingredientes = new ArrayList<>();
        ingredientes.add(" Molho de Tomate" );
        ingredientes.add(" Mussarela ");
        ingredientes.add(" Presunto ");
        ingredientes.add(" Cebola ");
        ingredientes.add(" Tomate ");
        ingredientes.add(" Azeitonas ");
        menu.add(new Pizza(" Portuguesa ", 45.0, ingredientes));

        while (true) {
            System.out.println("\n Pizzaria dos Engenheiros ");
            System.out.println("1. Fazer Pedido ");
            System.out.println("2. Ver Pedidos");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Sair");
            System.out.print(" Escolha: ");

            int opcao = Integer.parseInt(teclado.nextLine());

            switch (opcao) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    verPedidos();
                    break;
                case 3:
                    cancelarPedido();
                    break;
                case 4:
                    System.out.println(" Até logo! ");
                    return;
                default:
                    System.out.println(" Opção inválida! ");
            }
        }
    }

    static void fazerPedido() {
        System.out.println("\n Pizzaria dos Engenheiros ");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).nome + " - R$ " + menu.get(i).valor);
        }

        System.out.print(" Escolha a pizza (1-" + menu.size() + "): ");
        int escolha = Integer.parseInt(teclado.nextLine()) - 1;
        Pizza pizza = menu.get(escolha);

        System.out.println("\n Tamanhos:");
        System.out.println("1. Pequena");
        System.out.println("2. Média");
        System.out.println("3. Grande");
        System.out.print(" Escolha o tamanho: ");
        String tamanho = teclado.nextLine();
        switch (tamanho) {
            case "1": tamanho = "Pequena"; break;
            case "2": tamanho = "Média"; break;
            case "3": tamanho = "Grande"; break;
            default: tamanho = "Pequena";
        }

        System.out.print(" Endereço de entrega: ");
        String endereco = teclado.nextLine();
        Pedido pedido = new Pedido(pizza, tamanho, endereco);
        pedidos.add(pedido);
        System.out.println("\n Pedido realizado!");
        pedido.mostrarInfo();
    }

    static void verPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println(" Nenhum pedido! ");
            return;
        }

        double total = 0;
        int ativos = 0;

        for (Pedido p : pedidos) {
            p.mostrarInfo();
            if (!p.cancelado) {
                total += p.calcularTotal();
                ativos++;
            }
        }

        System.out.println("\n Total de pedidos: " + pedidos.size());
        System.out.println(" Pedidos ativos: " + ativos);
        System.out.println(" Valor total: R$ " + total);
    }

    static void cancelarPedido() {
        if (pedidos.isEmpty()) {
            System.out.println(" Nenhum pedido! ");
            return;
        }

        System.out.print(" Número do pedido para cancelar: ");
        int numero = Integer.parseInt(teclado.nextLine());

        for (Pedido p : pedidos) {
            if (p.numero == numero) {
                p.cancelado = true;
                System.out.println(" Pedido cancelado! ");
                return;
            }
        }
        System.out.println(" Pedido não encontrado! ");
    }
}
