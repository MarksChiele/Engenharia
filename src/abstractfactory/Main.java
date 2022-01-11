package abstractfactory;

public class Main {

	public static void main(String[] args) {
		AbstractFactory offRoadFactory = FactoryProducer.getFactory("OffRoad");
		
		Veiculos carro1 = offRoadFactory.getVeiculo("X");
		carro1.method();
		
		Veiculos carro2 = offRoadFactory.getVeiculo("Y");
		carro2.method();
		
		AbstractFactory streetFactory = FactoryProducer.getFactory("Street");
		
		Veiculos carro3 = streetFactory.getVeiculo("X");
		carro3.method();
		
		Veiculos carro4 = streetFactory.getVeiculo("Y");
		carro4.method();
	}
}
