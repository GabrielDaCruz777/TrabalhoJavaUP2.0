public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro(" FERARRI ", " F40 ", 1987, " ALC3U7 ");

        System.out.println("\n Informações iniciais do carro: ");
        carro1.exibirInformacoes();

        carro1.acelerar(50);
        System.out.println("\n Após acelerar 50 km/h: ");
        carro1.exibirInformacoes();

        carro1.acelerar(30);
        System.out.println("\n Após acelerar mais 30 km/h: ");
        carro1.exibirInformacoes();

        carro1.frear(40);
        System.out.println("\n Após frear 40 km/h: ");
        carro1.exibirInformacoes();

        carro1.frear(100);
        System.out.println("\n Após tentar frear 100 km/h: ");
        carro1.exibirInformacoes();
    }
}