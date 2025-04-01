import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println(" Contato adicionado com sucesso! ");
    }

    public boolean removerContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(contato);
                System.out.println(" Contato removido com sucesso! ");
                return true;
            }
        }
        System.out.println(" Contato não encontrado! ");
        return false;
    }

    public Contato buscarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println(" Agenda vazia! ");
            return;
        }

        System.out.println("\n Lista de Contatos ");
        for (Contato contato : contatos) {
            System.out.println();
            contato.exibirInformacoes();
        }
        System.out.println();
    }

    public int getQuantidadeContatos() {
        return contatos.size();
    }
}