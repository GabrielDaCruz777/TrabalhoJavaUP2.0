import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Livro {
    String titulo, autor;
    int ano;

    Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String toString() {
        return "📖 " + titulo + " - " + autor + " (" + ano + ")";
    }
}

public class Biblioteca {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Bem-vindo à Biblioteca!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1️ Adicionar Livro");
            System.out.println("2️ Listar Livros");
            System.out.println("3️ Sair");
            System.out.print("> ");

            int opcao;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(" Opção inválida! ");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1 -> adicionarLivro(livros, scanner);
                case 2 -> listarLivros(livros);
                case 3 -> {
                    System.out.println(" Até mais!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Escolha uma opção válida!");
            }
        }
    }

    private static void adicionarLivro(List<Livro> livros, Scanner scanner) {
        System.out.print(" Título: ");
        String titulo = scanner.nextLine();
        System.out.print(" Autor: ");
        String autor = scanner.nextLine();

        int ano;
        while (true) {
            System.out.print(" Ano de publicação: ");
            if (scanner.hasNextInt()) {
                ano = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println(" Digite um ano válido!");
                scanner.nextLine();
            }
        }

        livros.add(new Livro(titulo, autor, ano));
        System.out.println(" Livro adicionado com sucesso!");
    }

    private static void listarLivros(List<Livro> livros) {
        if (livros.isEmpty()) {
            System.out.println(" Nenhum livro cadastrado ainda.");
        } else {
            System.out.println("\n Lista de Livros:");
            livros.forEach(System.out::println);
        }
    }
}
