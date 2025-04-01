public class Carro {
    private String marca;
    private String modelo;
    private int ano;
    private String placa;
    private double velocidadeAtual;

    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0.0;
    }

    public void acelerar(double incremento) {
        if (incremento > 0) {
            this.velocidadeAtual += incremento;
            System.out.println(" Acelerando! Velocidade atual: " + this.velocidadeAtual + " km/h ");
        }
    }

    public void frear(double decremento) {
        if (decremento > 0) {
            if (this.velocidadeAtual >= decremento) {
                this.velocidadeAtual -= decremento;
                System.out.println(" Freando! Velocidade atual: " + this.velocidadeAtual + " km/h ");
            } else {
                this.velocidadeAtual = 0;
                System.out.println(" Carro parado! ");
            }
        }
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getPlaca() {
        return placa;
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void exibirInformacoes() {
        System.out.println(" Informações do Carro ");
        System.out.println(" Marca: " + this.marca);
        System.out.println(" Modelo: " + this.modelo);
        System.out.println(" Ano: " + this.ano);
        System.out.println(" Placa: " + this.placa);
        System.out.println(" Velocidade Atual: " + this.velocidadeAtual + " km/h ");
    }
}