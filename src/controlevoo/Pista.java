package controlevoo;

public class Pista implements Comando {
	private IAtc atcMediator;
	public Pista(IAtc atcMediator){
		this.atcMediator = atcMediator;
	}
	
	@Override
	public void pouso() {
		System.out.println("A pista est� dispon�vel para pouso");
		atcMediator.setDisponibilidade(true);
		
	}

}
