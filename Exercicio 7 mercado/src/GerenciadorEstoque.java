import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidadeEstoque;

    public Produto(String nome, String codigo, double preco, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }
    public void setQuantidadeEstoque(int quantidade) {
        if (quantidade >= 0) {
            this.quantidadeEstoque = quantidade;
        }
    }

    public double getValorTotalEstoque() {
        return preco * quantidadeEstoque;
    }

    public void exibirInformacoes() {
        System.out.println(" Nome: " + nome);
        System.out.println(" Código: " + codigo);
        System.out.println(" Preço: R$ " + String.format("%.2f", preco));
        System.out.println(" Quantidade em Estoque: " + quantidadeEstoque);
        System.out.println(" Valor Total em Estoque: R$ " + String.format("%.2f", getValorTotalEstoque()));
    }
}

public class GerenciadorEstoque {
    private static List<Produto> estoque = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        for (Produto p : estoque) {
            if (p.getCodigo().equals(produto.getCodigo())) {
                System.out.println(" Erro: Já existe um produto com este código! ");
                return;
            }
        }
        estoque.add(produto);
        System.out.println(" Produto adicionado com sucesso! ");
    }

    public static boolean removerProduto(String codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                estoque.remove(produto);
                System.out.println(" Produto removido com sucesso! ");
                return true;
            }
        }
        System.out.println(" Produto não encontrado! ");
        return false;
    }

    public static void atualizarQuantidade(String codigo, int novaQuantidade) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setQuantidadeEstoque(novaQuantidade);
                System.out.println(" Quantidade atualizada com sucesso! ");
                return;
            }
        }
        System.out.println(" Produto não encontrado! ");
    }

    public static void atualizarPreco(String codigo, double novoPreco) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                produto.setPreco(novoPreco);
                System.out.println(" Preço atualizado com sucesso! ");
                return;
            }
        }
        System.out.println(" Produto não encontrado! ");
    }

    public static void gerarRelatorio() {
        if (estoque.isEmpty()) {
            System.out.println(" Estoque vazio! ");
            return;
        }

        System.out.println("\n Relatório de Estoque ");
        double valorTotalEstoque = 0;

        for (Produto produto : estoque) {
            System.out.println("\n");
            produto.exibirInformacoes();
            valorTotalEstoque += produto.getValorTotalEstoque();
        }

        System.out.println("\n Valor Total do Estoque: R$ " + String.format("%.2f", valorTotalEstoque));
        System.out.println();
    }

    public static void main(String[] args) {
        Produto produto1 = new Produto(" Red Bull ", " RB001 ", 7.90, 50);
        Produto produto2 = new Produto(" Doritos ", " DO001 ", 8.50, 30);
        Produto produto3 = new Produto(" Coca-Cola ", " CC001 ", 10.90, 40);

        adicionarProduto(produto1);
        adicionarProduto(produto2);
        adicionarProduto(produto3);

        System.out.println("\n Relatório Inicial: ");
        gerarRelatorio();
        System.out.println("\n Atualizando quantidade do Red Bull: ");
        atualizarQuantidade(" RB001 ", 45);

        System.out.println("\n Atualizando preço do Doritos: ");
        atualizarPreco(" DO001 ", 9.50);

        System.out.println("\n Relatório após atualizações: ");
        gerarRelatorio();

        System.out.println("\n Removendo a Coca-Cola: ");
        removerProduto(" CC001 ");

        System.out.println("\n Relatório Final: ");
        gerarRelatorio();
    }
}