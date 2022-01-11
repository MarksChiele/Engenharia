package bridge;


public class Pessoas implements Transporte {
    @Override
    public void transportar() {
        System.out.println("veiculo Transportando Pessoas");
    }

    @Override
    public void descricaoTransporte() {
        System.out.println("veiculo que Transporta Pessoas");
    }
}
