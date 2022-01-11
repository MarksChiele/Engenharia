package chainsofresponsa;


public abstract class AbstractHandler implements HandlerInterface{

	private HandlerInterface next;
	
	
	@Override
	public HandlerInterface next(HandlerInterface handler) {
		this.next = handler;
		return handler;
	}

	//Na implementação clássica deseja-se que o método handle() não possa ser modificado por classes filhas
	@Override
	final public String handle(String request) { 
		String result = this.process(request);
		
		if ((result == null || result.isEmpty()) && this.next!=null) {
			System.out.println("Requisição negada: Passando para o próximo handler...");
			result = this.next.handle(request);
		}
		
		return result;
	}
	
	abstract protected String process(String request);
	
}
