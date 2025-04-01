public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato1 = new Contato(" Alceu ", " (41) 912345-1234 ", " alceu@gmail.com ");
        Contato contato2 = new Contato(" Gabriel ", " (41) 912348-5678 ", " gabriel@gmail.com ");
        Contato contato3 = new Contato(" Cristiano Ronaldo ", " (77) 974232-5431 ", " cr7@gmail.com ");

        agenda.adicionarContato(contato1);
        agenda.adicionarContato(contato2);
        agenda.adicionarContato(contato3);

        System.out.println("\n Listando todos os contatos: ");
        agenda.listarContatos();

        System.out.println("\n Buscando contato 'Cristiano Ronaldo': ");
        Contato contatoEncontrado = agenda.buscarContato(" Cristiano Ronaldo ");
        if (contatoEncontrado != null) {
            contatoEncontrado.exibirInformacoes();
        }

        System.out.println("\n Removendo contato 'Cristiano Ronaldo':");
        agenda.removerContato(" Cristiano Ronaldo ");

        System.out.println("\n Listando contatos após a remoção:");
        agenda.listarContatos();

        System.out.println("\n Quantidade de contatos na agenda: " + agenda.getQuantidadeContatos());
    }
}