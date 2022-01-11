package controlevoo;

public class Voo implements Comando {
	private IAtc atcMediator;
	public Voo (IAtc atcMediator){
		this.atcMediator = atcMediator;
	}
	
	@Override
	public void pouso() {
		if(atcMediator.estaDisponivel()) {
			System.out.println("Pouso realizado com sucesso!");
			atcMediator.setDisponibilidade(false); //a pista está ocupada
		}
		else {	
			System.out.println("Aguarde pista disponível");
		}	
		
	}
	public void  prontoParaPousar() {
		System.out.println("Pouso iniciado");
		
	}
	public void estacionado() {
		System.out.println("Voo estacionado.");
		atcMediator.setDisponibilidade(true);//a pista está disponível
	}
}
