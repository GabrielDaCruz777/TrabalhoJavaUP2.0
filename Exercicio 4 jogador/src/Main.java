public class Main {
    public static void main(String[] args) {
        jogador jogador1 = new jogador(" Alceu ");

        System.out.println("\n Informações iniciais do jogador: ");
        jogador1.exibirInformacoes();

        jogador1.aumentarPontuacao(500);
        System.out.println("\n Após ganhar 500 pontos: ");
        jogador1.exibirInformacoes();

        jogador1.aumentarPontuacao(600);
        System.out.println("\n Após ganhar mais 600 pontos: ");
        jogador1.exibirInformacoes();

        jogador1.diminuirPontuacao(200);
        System.out.println("\n Após perder 200 pontos: ");
        jogador1.exibirInformacoes();
    }
}