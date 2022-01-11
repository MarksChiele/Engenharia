package bridge;



public class Onibus extends Veiculo {

    public Onibus(String marca, Transporte transporte) {
        super(marca, transporte);
    }

    @Override
    public void realizarAtividade() {
        System.out.print(" onibus " + marca + ": ");
        this.transporte.transportar();
    }
}