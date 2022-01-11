package chainsofresponsa;


public interface HandlerInterface {
	//Recebe o próximo objeto
	public HandlerInterface next(HandlerInterface next);
	
	//Trata a requisição
	public String handle(String request);
}
