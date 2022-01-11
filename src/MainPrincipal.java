import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import abstractfactory.AbstractFactory;
import abstractfactory.FactoryProducer;
import abstractfactory.Veiculos;
import bridge.Caminhao;
import bridge.Cargas;
import bridge.Onibus;
import bridge.Pessoas;
import bridge.Veiculo;
import chainsofresponsa.LogErrorHandler;
import chainsofresponsa.LogInfoHandler;
import chainsofresponsa.LogWarningHandler;
import composite.Caixa;
import composite.Item;
import composite.Produto;
import controlevoo.Atc;
import controlevoo.IAtc;
import controlevoo.Pista;
import controlevoo.Voo;
import facade.ComputadorFACADE;
import flyweight.Player;
import flyweight.PlayerFactory;
import memento.History;
import memento.Originator;
import proxy.Universidade;
import proxy.UniversidadeProxy;
import state.State;
import state.TVContext;
import state.TVStartState;
import state.TVStopState;


public class MainPrincipal {

	private static final String String = null;

	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
		 
		 int aux=1;
	        
	        
         while(aux!=0){
          System.out.println("Digite 1 para Abstract factory\n"
                  + "Digite 2 Bridge\n"
                  + "Digite 3 Builder\n"
                  + "Digite 4 Chains of Responsa\n"
                  + "Digite 5 Composite\n"
                  + "Digite 6 Controlevoo\n"
                  + "Digite 7 Facade\n"
                  + "Digite 8 Flyweight\n"
                  + "Digite 9 Memento\n"
                  + "Digite 10 Prototype\n"
                  + "Digite 11 Proxy\n"
                  + "Digite 12 State\n");
                  aux=s.nextInt();

                  if(aux==1){
                	  
                	  System.out.println("é um padrão de projeto criacional que permite que você produza famílias de objetos relacionados sem ter que especificar suas classes concretas\n."
                	  		+ "Neste projeto foram criadas interfaces independentes para cada tipo de veiculo porem a uma classe master Veiculo que possui uma Abstract factory para inicializar os tipos de veiculos\n"
                	  		+ "existentes no projeto. As classes offroadFactory e StreetFactory sao variantes da familia de veiculos e herdam a classe AbstractFactory porem cada uma delas so pode criar um objeto especifico.\n");
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
                  
                  if(aux==2){
                	  System.out.println("Este design pattern consiste em abstrair objetos a fim de separar e organizar os atributos. Mantendo a abstracao dos veiculos( onibus  e caminhao) na classe veiculo\n"
                	  		+ "conseguimos separar os tipos das funcoes de cada um. As funcoes estao separadas nas classes cargas e transporte que possuem a interface Transporte.\n");
                      Veiculo caminhao = (Veiculo) new Caminhao("Scania", new Cargas());
                      caminhao.realizarAtividade();


                      Veiculo onibus = (Veiculo) new Onibus("Mercedes", new Pessoas());
                      onibus.realizarAtividade();

                    
                
                  
                  }
                	  
                  if(aux==3){
                	  System.out.println(" um padrão de projeto estrutural que permite que você divida uma classe grande ou um conjunto de classes intimamente ligadas em duas hierarquias separadas—abstração e implementação—que podem ser desenvolvidas independentemente umas das outras./n"
                	  		+ " ");
                	  
                	  
                	  
                	  
                  }  
                	  
                  
                if(aux==4){
                	 System.out.println("Para este projeto foram criados Handlers individuais para cada comportamento do software. Um handler para log de erro, outro para log de aviso e outro para infos.\n"
                	 		+ "Esta e a premissa base deste design pattern que consiste em subdividir funcoes do programa em handlers interligados que podem ou nao serem executados .\n"
                	 		+ " ");
                	LogInfoHandler logInfoHandler = new LogInfoHandler();
            		LogWarningHandler logWarningHandler = new LogWarningHandler();
            		LogErrorHandler logErrorHandler = new LogErrorHandler();
            		
            		logInfoHandler.next(logWarningHandler);
            		logWarningHandler.next(logErrorHandler);
            		
            		
            		String response = logInfoHandler.handle("error");
            		System.out.println(response);    	  
                }      	  
                  
                 if(aux==5){
                	 System.out.println("Este padrao de projeto tem como objetivo principal permite que você componha objetos em estruturas de árvores e então trabalhe com essas estruturas como se elas fossem objetos individuais\n."
                	 		+ "Neste exemplo de projeto possuimos dois objetos, caixa e item. O item pertence a uma caixa e cada item tem seu valor. Ja uma caixa possui varios itens\n "
                	 		+ "que juntos somam um valor. Entao neste exemplo possuimos a classe Interface ITEM que é comum aos dois objetos distintos porem que se relacionam. Esta classe define o metodo de soma dos itens\n"
                	 		+ "seja ele da caixa corrugada ou somente de cada item indevidual.");
                	 
                	 
                	 
                	 Caixa caixaMaster = new Caixa(new ArrayList<Item>()); 
             		
             		caixaMaster.addItem(new Produto("Clean Code: A Handbook of Agile Software Craftsmanship", 202.71));
             		
             		Caixa caixaSmartphones = new Caixa(new ArrayList<Item>());
             		caixaSmartphones.addItem(new Produto("Samsung Galaxy S21 Ultra 5G", 6191.10));
             		caixaSmartphones.addItem(new Produto("Samsung Galaxy S20 FE", 2189));
             		caixaSmartphones.addItem(new Produto("iPhone 13", 7599));
             		caixaSmartphones.addItem(new Produto("iPhone 13 mini", 6599));
             		caixaMaster.addItem(caixaSmartphones);
             		
             		Caixa caixaNotebooks = new Caixa(new ArrayList<Item>());
             		caixaNotebooks.addItem(new Produto("Acer Nitro AN515-44-R5YZ", 5499));
             		caixaNotebooks.addItem(new Produto("Dell G15", 5301));
             		caixaMaster.addItem(caixaNotebooks);
             		
             		Caixa caixaFerramentas = new Caixa(new ArrayList<Item>());
             		caixaFerramentas.addItem(new Produto("Martelo de Unha 25mm", 37.30));
             		caixaFerramentas.addItem(new Produto("Trena 5m", 17.10));
             		caixaFerramentas.addItem(new Produto("Alicate 7", 25));
             		caixaFerramentas.addItem(new Produto("Chave de Fenda Ponta Cruzada 1/8x6 Polegadas", 5.90));
             		caixaMaster.addItem(caixaFerramentas);
             		
             		System.out.println("VALOR TOTAL = " + caixaMaster.calcularPrecoFinal());             	  
                 
                 
                 }               	  
                	    
                 if(aux==6){
                	 System.out.println("é um padrão de projeto comportamental que permite que você reduza as dependências caóticas entre objetos. O padrão restringe comunicações diretas entre objetos e os força a /n"
                	 		+ "colaborar apenas através do objeto mediador. Neste exemplo de aeroporto a classe atc é mediadora das demais classes./n"
                	 		+ "As demais classes se comunicam atraves da passada pela classe mediadora que contem atributos para se criar e configurar os estados dos demais objetos/n");
                	 IAtc atcMediator = new Atc();
             		
             		Pista pista = new Pista(atcMediator);
             		
             		Voo voo1 = new Voo(atcMediator);
             	

             		
             		atcMediator.registrarVoo(voo1);
             		atcMediator.registrarPista(pista);
             		
             		voo1.prontoParaPousar();
             	
             		
             		voo1.estacionado();
             		
             		
                 }      	      	  
           
                 if(aux==7){
                	 
                	 System.out.println("Seu objetivo geral é simplificar codigo e otimizar o software. Neste exemplo temos a criaçao de 4 itens onde todos sao instanciados na classe/n"
                	 		+ "ComputadorFacade. Esta classe é responsavel por unir as funcionalidades das demais classes em uma so a fim de simplificar e otimizar codigo./n"
                	 		+ "O Facade é um design pattern comumente utilizado em muitos projetos de software./n");
                	 ComputadorFACADE facade = new ComputadorFACADE();
                     facade.Executar();
                 }      	  
                      
                  
                 if(aux==8){
                	 String[] playerType = {"Terrorist", "CounterTerrorist"};
                	 String[] weapons = {"AK-47", "AWP", "Knife", "Desert Eagle"};
                	
                	 
                	 String getRandomPlayerType() {
                	        Random random = new Random();
                	        int randInt = random.nextInt(playertype.lenght);
                	        return playerType[randInt];
                	        
                 }      
                	 public static String getRandomWeapon() {
                	        Random random = new Random();
                	        int randInt = random.nextInt(weapons.length);
                	        return weapons[randInt];
                	    }
                	 
                
         
                 
                 
                	 for (int i = 0; i < 4; i++) {
                         Player player = PlayerFactory.getPlayer(getRandomPlayerType());

                         player.assignWeapon(getRandomWeapon());

                         player.mission();
                     }
                 }
                	 
                	 
                  
                 if(aux==9){
                	 System.out.println("Em geral é um padrão de projeto comportamental que permite que você salve e restaure o estado anterior de um objeto sem revelar os detalhes de sua implementação./n"
                	 		+ " Neste exemplo possuimos uma classe History onde esta é responsavel por armazenar o valor antigo do item editado pelo cliente./n"
                	 		+ "A classe originator constroi pontos de restauracao de estado dos itens, enquanto a classe memento é o retrado da originadora porem imutavel./n"
                	 		+ "");
                	 
                	 Originator originador = new Originator();
              	    History armazenador = new History();
              	    
              	    
              	    originador.setState("State #1");
              	    
              	    
              	    originador.setState("State #2");
              	    armazenador.saveState(originador.generateMemento());
              	    
              	    
              	    originador.setState("State #3");
              	    armazenador.saveState(originador.generateMemento());
              	    
              	    
              	    originador.setState("State #4");
              	    System.out.println("Current State: " + originador.getState());		
              	    
              	    originador.setStateFromMemento(armazenador.getState(0));
              	    System.out.println("First saved State ----- " + originador.getState());
              	    
              	    originador.setStateFromMemento(armazenador.getState(1));
              	    System.out.println("Second saved State ----- " + originador.getState());
                 }      	     
                  
                 if(aux==10){
                	 System.out.println("O Prototype é um padrão de projeto criacional que permite copiar objetos existentes sem fazer seu código ficar dependente de suas classes./n"
                	 		+ " Neste exemplo temos a criacao de 1 tipo de pessoa onde outros 2 objetos pessoa clonam os atribuitos de pessoa 1. ");
                 }      	    
                
                 if(aux==11){
                	 Universidade universidade = new UniversidadeProxy("errado");
                     System.out.println("Login Incorreto");
                     System.out.println(universidade.getNomeInstituicao());
                     System.out.println(universidade.getNomeCurso());
                     System.out.println("");
                     System.out.println("----------------------------");
                     System.out.println("");
                     universidade = new UniversidadeProxy("correto");
                     System.out.println("Login valido");
                     System.out.println(universidade.getNomeInstituicao());
                     System.out.println(universidade.getNomeCurso());
                 }      	 
         
                 if(aux==12){
                	 TVContext context = new TVContext();
             		State tvStartState = new TVStartState();
             		State tvStopState = (State) new TVStopState();
             		
             		context.setState(tvStartState);
             		context.doAction();
             		
             		
             		context.setState(tvStopState);
             		context.doAction();
                 }      	  
                  
                 
                 
                 
}
}
}	
       
