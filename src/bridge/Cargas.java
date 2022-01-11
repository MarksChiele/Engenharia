package bridge;


public class Cargas implements Transporte {
    @Override
    public void transportar() {
        System.out.println("veiculo Transportando Cargas");
    }

    @Override
    public void descricaoTransporte() {
        System.out.println("veiculo que Transporta Cargas");
    }
}