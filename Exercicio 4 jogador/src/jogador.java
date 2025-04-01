public class jogador {
    private String nome;
    private int pontuacao;
    private int nivel;

    public jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.nivel = 1;
    }

    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
            verificarNivel();
        }
    }

    public void diminuirPontuacao(int pontos) {
        if (pontos > 0 && this.pontuacao >= pontos) {
            this.pontuacao -= pontos;
        }
    }

    private void verificarNivel() {
        int novoNivel = (this.pontuacao / 1000) + 1;
        if (novoNivel > this.nivel) {
            this.nivel = novoNivel;
            System.out.println(" Parabéns! Você subiu para o nível " + this.nivel + "!");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getNivel() {
        return nivel;
    }

    public void exibirInformacoes() {
        System.out.println(" Informações do Jogador ");
        System.out.println(" Nome: " + this.nome);
        System.out.println(" Pontuação: " + this.pontuacao);
        System.out.println(" Nível: " + this.nivel);
    }
}