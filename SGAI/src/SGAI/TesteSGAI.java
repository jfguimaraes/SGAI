package SGAI;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class TesteSGAI {
	public static ArrayList <Imovel> imoveis = new ArrayList<>();
	public static ArrayList <Agente> agentes = new ArrayList<>();
	public static ArrayList <Visita> visitas = new ArrayList<>();
	public static ArrayList <Object> elems = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
				
		Agente aux;
		Moradia mor=new Moradia();
		Apartamento apa;
		Imovel im;
		Visita vis;
		EspacoComercial ec;
		int opcao;
		do {
			opcao = menu();
			switch (opcao) {
			case 1:
				if (!verificaAgentes(agentes)){
					mor=(Moradia)criarMoradia(agentes);
					imoveis.add(mor);
					System.out.println("Moradia registada com sucesso com o ID:" + mor.getIdImovel());
				}
					primaEnter(); 
				break;
			case 2:
				apa=criarApartamento(agentes);
				imoveis.add(apa);
				System.out.println("Apartamento registado com sucesso com o ID:" + apa.getIdImovel());
				primaEnter(); 
				break;
			case 3:
				ec=criarEspacoComercial(agentes);
				imoveis.add(ec);
				System.out.println("Espaco Comercial registado com sucesso com o ID:" + ec.getIdImovel());
				primaEnter(); 
				break;
			case 4:
				aux=criarAgente();
				agentes.add(aux);
				System.out.println("Agente criado com sucesso com o ID:" + aux.getIdAgente());
				primaEnter();
				break;
			case 5:
				if (!imoveis.isEmpty()) {
					Collections.sort(imoveis);
					listarImoveis(imoveis);
				}else 
					System.out.println("Não existem imoveis!");
				primaEnter();
				break;
			case 6:
				if (!agentes.isEmpty())
					listarAgentes(agentes);
				else
					System.out.println("Não existem agentes!");
				primaEnter();
				break;
			case 7:
				if (!imoveis.isEmpty())
					listarImoveisAgentes(agentes,imoveis, "Todos");
				else
					System.out.println("Não existem imoveis!");
				primaEnter();
				break;
				
			case 8:
//				if (!verificaImoveis(imoveis)) {
//					vis=agendarVisita(imoveis,agentes,visitas);
//					if(vis.getNomeVisitante().length()>0){
//					visitas.add(vis);}
//				}
				primaEnter();
				break;
			case 9: 
				if (!visitas.isEmpty()) {
					listarVisitas(visitas,imoveis);
				}else 
				  System.out.println("Não existem visitas!");
				primaEnter();
				break;
			case 10:
				if (!verificaImoveis(imoveis))
					venderImovel(imoveis);
				primaEnter();
				break;
			case 11:
				if (!verificaImoveis(imoveis))
					listarImoveisAgentes(agentes,imoveis,"Vendidos");
				primaEnter();
				break;
			case 12:
				if (!verificaImoveis(imoveis))
					calculaComissaoAgente(imoveis, agentes);
				primaEnter();
				break;
				
			case 13:
				try {
					lerFicheiroXML("SGAI.xml");
					System.out.println("Ficheiro de XML lido com sucesso!");
					//listarElementos(elems);
				} catch (IOException exc){
					System.out.println("Ficheiro XML inexistente!");
				} catch (ParserConfigurationException | SAXException exc) {
					System.out.println("Erro no Processamento do Ficheiro XML!");
				}
				primaEnter();
				break;
			case 14:
				try {
					gravarFicheiroObjectos(agentes, imoveis);
					System.out.println("Ficheiro de objetos criado com sucesso!");
				} catch (IOException exc) {
					System.out.println(exc.getMessage());
					System.out.println("Erro na criação do ficheiro de objetos!");
				}
				primaEnter();
				break;
			case 0:
				break;
			default:
				System.out.println("Operação inválida!");
				primaEnter();
			}
		} while (opcao != 0);
		
	}
	
	private static int menu() {
		System.out.println("\n---MENU---");
		System.out.println("1 - Criar Moradia");
		System.out.println("2 - Criar Apartamento");
		System.out.println("3 - Criar Espaço Comercial");
		System.out.println("4 - Criar Vendedor");
		System.out.println("5 - Listar todos os imóveis por ordem crescente de preços");
		System.out.println("6 - Listar todos os agentes");
		System.out.println("7 - Listar todos os imoveis de um dado agente");
		System.out.println("8 - Agendar uma visita");
		System.out.println("9 - Listar visitas por agente");
		System.out.println("10 - Vender um imovel");
		System.out.println("11 - Listar imoveis vendidos por agente");
		System.out.println("12 - Listar comissões de cada agente");
		System.out.println("13 - Ler Ficheiro");
		System.out.println("14 - Gravar Ficheiro");
		System.out.println("0 - Terminar");
		System.out.print("Escolha uma opção: ");
		int op = in.nextInt();
		in.nextLine();
		return op;
	}



//FunÃ§Ã£o cria agente
	private static Agente criarAgente() {
		
		System.out.print("Nome: ");
		String nome = in.nextLine();
		Agente.setNumAgente(Agente.getNumAgente()+1);
		return new Agente(nome,Agente.getNumAgente());
   }
	
	//FunÃ§Ã£o cria imovel
	//Apartamento
	private static Apartamento criarApartamento(ArrayList<Agente> agentes) {
		boolean dadosInvalidos = true;
		Integer idAgente = null,numQuartos = null;
		Float preco = null,distancia = null;
		
		String morada = null;
		do{
			System.out.println("Morada: ");
			 morada = in.nextLine();
			try {
					System.out.println("Indique o id do Agente a que pertence este apartamento: ");
					idAgente = in.nextInt();
					while(!verificaAgentePorId(agentes, idAgente)) {
							System.out.println("O id que inseriu Não existe por favor volte a inserir: ");
							idAgente = in.nextInt(); 	
					}
					System.out.println("Preco :");
					 preco = in.nextFloat();
					System.out.println("Distancia :");
					 distancia = in.nextFloat();
					System.out.println("Numero de quartos: ");
					 numQuartos = in.nextInt();
					dadosInvalidos = false;
					Apartamento.setContaApartamentos(Apartamento.getContaApartamentos()+1);
					
			}catch (NumberFormatException e) {
				System.out.println("\nErro: Numero invalido!" + " (" + e.getClass().getSimpleName() + ")");				
			} catch (IllegalArgumentException e) {
				System.out.println("\nErro: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
			}catch(InputMismatchException e) {
				System.out.println("\n Id do Agente invalido");
			}
		}while (dadosInvalidos);
		
		Agente agente = getAgenteByID(idAgente, agentes);
		
		
		return new Apartamento(Apartamento.getContaApartamentos(),agente , morada,EstadoImovel.ACTIVO,preco,distancia,numQuartos);
		
		//verifica o IDAgente
		
    }
			//Moradia
			private static Moradia criarMoradia(ArrayList<Agente> agentes) {
				boolean dadosInvalidos = true;
				Integer idAgenteMor = null,numQuartosMor = null, numFrentesMor = null;
				Float precoMor = null,distanciaMor = null;
				String moradaMor = null;
				//do{
				//	try {
				System.out.println("Morada: ");
				String morada = in.nextLine();
				System.out.println("Indique o id do Agente a que pertence este apartamento: ");
				Integer idAgente = in.nextInt(); 
//				while(!verificaAgentePorId(agentes, idAgente)) {
//					System.out.println("O id que inseriu Não existe por favor insira um no	vo: ");
//					 idAgente = in.nextInt(); 
//				}
				System.out.println("Preco :");
				Float preco = in.nextFloat();
				System.out.println("Distancia :");
				Float distancia = in.nextFloat();
				System.out.println("Numero de quartos: ");
				Integer numQuartos = in.nextInt();
				System.out.println("Numero de frentes: ");
				Integer numFrentes = in.nextInt();
				Moradia.setContaMoradia(Moradia.getContaMoradia()+1);
//				}catch (NumberFormatException e) {
//						System.out.println("\nErro: Numero invalido!" + " (" + e.getClass().getSimpleName() + ")");				
//				} catch (IllegalArgumentException e) {
//						System.out.println("\nErro: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
//				}catch(InputMismatchException e) {
//						System.out.println("\n Id do Agente invalido");
//				}
				//}while (dadosInvalidos);
				//Moradia(Integer idImovel, Integer IdAgente, String morada, String Ei, float Preco,  float Distancia,  Integer numQuartos,Integer numFrentes){
				Agente agente = getAgenteByID(idAgente, agentes);
				
				return new Moradia(Moradia.getContaMoradia(),agente,morada,EstadoImovel.ACTIVO,preco,distancia,numQuartos,numFrentes);
			}
			//EspacoComercial
			private static EspacoComercial criarEspacoComercial(ArrayList<Agente> agentes) {
				boolean dadosInvalidos = true;
				Integer idAgenteEC = null, areaBrutaEC = null;
				Float precoEC = null,distanciaEC = null;
				String moradaEC = null;
				do{
					try {
				System.out.println("Morada: ");
				moradaEC = in.nextLine();
				System.out.println("Indique o id do Agente a que pertence este apartamento: ");
				 idAgenteEC = in.nextInt();
				while(!verificaAgentePorId(agentes, idAgenteEC)) {
					System.out.println("O id que inseriu Não existe por favor insira um novo: ");
					 idAgenteEC = in.nextInt(); 
				}
				System.out.println("Preco :");
				 precoEC = in.nextFloat();
				System.out.println("Distancia :");
				 distanciaEC = in.nextFloat();
				System.out.println("Area Bruta: ");
				 areaBrutaEC = in.nextInt();
					}catch (NumberFormatException e) {
						System.out.println("\nErro: Numero invalido!" + " (" + e.getClass().getSimpleName() + ")");				
				} catch (IllegalArgumentException e) {
						System.out.println("\nErro: " + e.getMessage() + " (" + e.getClass().getSimpleName() + ")");
				}catch(InputMismatchException e) {
						System.out.println("\n Id do Agente invalido");
				}
				}while (dadosInvalidos);
				EspacoComercial.setContaEspacoComercial(EspacoComercial.getContaEspacoComerciail()+1);
				Agente agente = getAgenteByID(idAgenteEC, agentes);
				return new EspacoComercial(EspacoComercial.getContaEspacoComerciail(),agente,moradaEC,EstadoImovel.ACTIVO,precoEC,distanciaEC,areaBrutaEC);
			}
			
//			Listagens
			
			//Agentes
			private static void listarAgentes(ArrayList<Agente> agentes) {
				System.out.println("\n---Listagem de Agentes---");
				for (Agente ag : agentes)
					System.out.println(ag.toString());
			}
			//Imoveis vendidos e todos por agente
			private static void listarImoveisAgentes(ArrayList<Agente> agentes,ArrayList<Imovel> imoveis, String option) {
			    
			    System.out.println("Indique o id do Agente: ");
			    Integer idAgente = in.nextInt();
			    ArrayList<Imovel>auxImoveis = new ArrayList<>(); 
			    for(Imovel imovel: imoveis) {
			    	if(option.equals("Todos")) {
			    		if (imovel.getAgente().getIdAgente() == idAgente) {
			    			auxImoveis.add(imovel);
			    		}
			      } else if (option.equals("Vendidos")) {
			    	if(imovel.getEstado() == EstadoImovel.VENDIDO && imovel.getAgente().getIdAgente() == idAgente) {
			    		auxImoveis.add(imovel);
			    	}
			      } else {
			       System.out.println("O agente que inseriu Não tem nenhum imovel associado");
			       return;
			      }
			     }
			    listarImoveis(auxImoveis);
			    
			   }
			
			private static void listarImoveis(ArrayList<Imovel> imoveis) {
				System.out.println("\n---Listagem de Imoveis---");
				for (Imovel imov : imoveis) {
					if(imov instanceof Apartamento) {
						System.out.println("\n---Listagem de Apartamentos---");
						System.out.println(imov.toString());
					}
					if(imov instanceof Moradia) {
						System.out.println("\n---Listagem de Moradias---");
						System.out.println(imov.toString());
					}
					if(imov instanceof EspacoComercial) {
						System.out.println("\n---Listagem de Espaços Comerciais---");
						System.out.println(imov.toString());
					}
				}
			}
			//f
//			private static Visita agendarVisita(ArrayList<Imovel>imoveis,ArrayList<Agente> agentes,ArrayList<Visita> visitas) {
//				Object im;
//				//Imovel imo;
//				System.out.println("Indique o id do Imovel para a visita: ");
//				Integer idImovel = in.nextInt();
//				Integer idAgente = 0; 
//				Float distancia = 0.0f;
//				Integer duracaoVisita =0;
//						
//				im=DevolveImovelPorId(imoveis,  idImovel);
//				while(!(im instanceof Imovel)){
//					System.out.println("O id do imovel que inseriu Não existe, por favor insira um novo: ");
//					idImovel = in.nextInt(); 
//					im=DevolveImovelPorId(imoveis,  idImovel);
//					
//				}
//				
//				
//				if(im instanceof Imovel)
//				{
//					Imovel imo= (Imovel) im;
//					idAgente=imo.getAgente().getIdAgente();
//					distancia=imo.getDistancia();
//					if(imo.getClass().getName()=="Apartamento")
//					{
//						duracaoVisita=Apartamento.getDuracaoVisita();
//					}
//					else if(imo.getClass().getName()=="Moradia"){
//						duracaoVisita=Moradia.getDuracaoVisita();
//					}
//					else if(imo.getClass().getName()=="EspacoComercial"){
//						duracaoVisita=EspacoComercial.getDuracaoVisita();
//					}
//					
//					if(imo.getEstado()==EstadoImovel.VENDIDO){
//						System.out.println("Ja esta Vendido o Imovel com o ID" + imo.getIdImovel());
//						imo=null;
//					}
//					
//				}
//				
//				//Integer idAgente = im.getIdAgente();
//				
//				System.out.println("Dia: ");
//				int ano = in.nextInt();
//				System.out.println("Mês: ");
//				int mes = in.nextInt();
//				System.out.println("Dia: ");
//				int dia = in.nextInt();
//				System.out.println("Hora: ");
//				int hora = in.nextInt();
//				System.out.println("Minuto: ");
//				int minuto = in.nextInt();
//				Data dataVisita = new Data(ano,mes,dia);
//				Tempo tempoVisita = new Tempo(hora,minuto);
//				//visitas.add(new Visita(1,1,"2017/08/15 12:00:00","filipe",1234));
//				if(!verificaExisteVisitaAgendaNoDia(visitas, idAgente, dataVisita)){
//					System.out.println("Nome Visitante :");
//					String nomeVisitante = in.nextLine();
//					System.out.println("Telefone Visitante: ");
//					Integer numTelef = in.nextInt();
//					System.out.println("Visita agenda!!");
//					Agente agente = getAgenteByID(idAgente, agentes);
//					return new Visita(agente, idImovel, dataVisita,tempoVisita,nomeVisitante, numTelef);
//				}
//				else
//				{
//					if(verificaDisponbildaedeAgendaNoDia(visitas, idAgente, idImovel,dataVisita,tempoVisita,imoveis)==true)
//					{
//						System.out.println("Nome Visitante :");
//						String nomeVisitante = in.nextLine();
//						System.out.println("Telefone Visitante: ");
//						Integer numTelef = in.nextInt();
//						System.out.println("Visita agenda!!");
//						Agente agente = getAgenteByID(idAgente, agentes);
//						return new Visita(agente, idImovel, dataVisita, tempoVisita,nomeVisitante, numTelef);
//					}
//					else
//					{
//						System.out.println("Sobreposicao de Visita, tente noutra data/hora!");
//						return new Visita();
//					}
//					
//				}
//				
//				//return new Visita(idAgente, idImovel, dataVisita, nomeVisitante, numTelef);
//			}
//			
			
			
			private static void listarVisitas(ArrayList<Visita> visitas,ArrayList<Imovel> imoveis) {
				
				 System.out.println("Indique o id do Agente: ");
				    Integer idAgente = in.nextInt();
				   Imovel imov;
				    // ArrayList<Visita>auxVisitas = new ArrayList<>();
				for (Visita vis: visitas) {
						//System.out.println("Agente:" + vis.getIntIdAgente() + "-->" + (vis.getIntIdAgente() == idAgente));
						if ((vis.getAgente().getIdAgente()==idAgente)==true) {
							imov=(Imovel)DevolveImovelPorId(imoveis, vis.getIdImovel());
							System.out.println(imov.toString());
							System.out.println(vis.toString());
						
						}
						
				}
				System.out.println("\n******Fim da listagem*****\n");
			}
			
//			private static Boolean verificaDisponbildaedeAgendaNoDia(ArrayList<Visita>visitas, Integer idAgente,Integer IdImovel, Data dataVisita,Tempo tempovisita,ArrayList<Imovel>imoveis) {
//				boolean flagHoraInicio=true;
//				boolean flagHoraFim=true;
//				Data dataVisitaRecebida;
//				Integer IdImovelV;
//				float tempoVisita=0;
//				float tempoDistancia=0;
//				Imovel imov,imovMarcado;
//
//				boolean flag=true;
//				
//				float tempoVisitaMarcado=0;
//				float tempoDistanciaMarcado=0;
//				
//				//dados do imovel para o qual se pretende agendar visita
//				imov=(Imovel)DevolveImovelPorId(imoveis, IdImovel);
//				//System.out.println("CLASSE" + imov.getClass().getName());
//				if(imov.getClass().getName()=="SGAI.Apartamento")
//				{
//					tempoVisita=Apartamento.getDuracaoVisita();
//				}
//				else if(imov.getClass().getName()=="SGAI.Moradia"){
//					tempoVisita=Moradia.getDuracaoVisita();
//				}
//				else if(imov.getClass().getName()=="SGAI.EspacoComercial"){
//					tempoVisita=EspacoComercial.getDuracaoVisita();
//				}
//				
//				
//				tempoDistancia=imov.getDistancia();
//				
//				for (Visita vis: visitas) 
//				{
//					//basta existir uma marcacao nas visitas agendadas com conflito que impossibilita a marcacao
//					//Melhoramentos: retirar desta pesquisa Imoveis Vendidos
//					if (idAgente == vis.getAgente().getIdAgente()) {
//						dataVisita=vis.getDataVisita();
//						IdImovelV=vis.getIdImovel();
//						
//						//dados do imovel que ja tem visista marcada
//						imovMarcado=(Imovel)DevolveImovelPorId(imoveis, IdImovelV);
//					if(!(imovMarcado.getEstado()== EstadoImovel.VENDIDO))	
//					{
//						System.out.println();
//						if(imovMarcado.getClass().getName().equals("SGAI.Apartamento"))
//						{
//							tempoVisitaMarcado=Apartamento.getDuracaoVisita();
//						}
//						else if(imovMarcado.getClass().getName().equals("SGAI.Moradia")){
//							tempoVisitaMarcado=Moradia.getDuracaoVisita();
//						}
//						else if(imovMarcado.getClass().getName().equals("SGAI.EspacoComercial")){
//							tempoVisitaMarcado=EspacoComercial.getDuracaoVisita();
//						}
//						
//						tempoDistanciaMarcado=imovMarcado.getDistancia();
//						
//						String d= getAno(dataVisita) + "/"+ getMes(dataVisita) + "/" + getDia(dataVisita);
//						String d2= getAno(Dia) + "/"+ getMes(Dia) + "/" + getDia(Dia);
//						DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//					    LocalDate ld = LocalDate.parse(d, DATEFORMATTER);
//					    LocalDate ld2 = LocalDate.parse(d2, DATEFORMATTER);
//				        Period period = Period.between(ld, ld2);
//					    
//				        if(period.getDays()==0)
//					    {	
//					    	LocalTime horaAgenda = LocalTime.of(Integer.parseInt(getHora(dataVisita)),Integer.parseInt(getMinutos(dataVisita)),Integer.parseInt(getSegundos(dataVisita)));
//							LocalTime horaPretendida = LocalTime.of(Integer.parseInt(getHora(Dia)),Integer.parseInt(getMinutos(Dia)),Integer.parseInt(getSegundos(Dia)));
//							
//							
//							LocalTime horafimVisitaSemDesloc=horaAgenda.plusMinutes( Math.round(tempoVisitaMarcado));
//							LocalTime horafimVisitaComDesloc=horafimVisitaSemDesloc.plusMinutes(Math.round(tempoDistanciaMarcado));
//							
//							LocalTime horaInicioVisitaComDesloc=horaAgenda.minusMinutes(Math.round(tempoDistanciaMarcado));
//							
//							LocalTime horaInicioPretendidoComDesloc=horaPretendida.minusMinutes(Math.round(tempoDistancia));
//							LocalTime horaInicioPretendidoSemDesloc=horaPretendida.minusMinutes(0);
//							
//							LocalTime horafimPretendidoSemDesloc=horaPretendida.plusMinutes(Math.round(tempoVisita));
//							
//							
//							if(IdImovelV==IdImovel)
//							{
//							  //a visita é no mesmo local 
//							  //a hora de visita pretendida tem que iniciar depois da  anterior.	
//								
//								Duration duration = Duration.between(horafimVisitaSemDesloc, horaInicioPretendidoSemDesloc);
//								Duration duration2 = Duration.between(horafimPretendidoSemDesloc, horaAgenda);
//								
//								if(duration.getSeconds()>0 )
//								{
//									//?
//								}
//								else
//								{
//										if(duration2.getSeconds()>0 )
//										{
//											//?
//										}
//										else
//										{
//											flag=false;
//										}
//								}
//							}
//								
//			    			else
//							{
//								//o local de visita é noutro local/imovel
//								//AQUI
//								Duration duration3 = Duration.between(horafimVisitaComDesloc, horaInicioPretendidoComDesloc);
//								Duration duration4 = Duration.between(horaInicioPretendidoComDesloc, horaInicioVisitaComDesloc);
//								
//								if(duration3.getSeconds()>0 )
//								{
//									//?
//								}
//								else
//								{
//										if(duration4.getSeconds()>0 )
//										{
//											
//										}
//										else
//										{
//											flag=false;
//										}
//								}
//							 }
//								//ATE AQUI
//																
//					    }//IF se é no mesmo dia!!
//				        
//						}   //Fim if Vendido
//					}//SE é do mesmo agente
//				
//				
//			}
//				return flag;
//		  }
		  
		public static String getHora(String date){
			int pos=date.indexOf(" ");
			return  date.substring(pos+1, date.indexOf(":")).trim();
		}
		
		public static String getMinutos(String date){
			int pos=date.indexOf(":");
			return date.substring(pos+1,date.lastIndexOf(":"));
		}
		
		public static String getSegundos(String date)
		{
		 return date.substring(date.lastIndexOf(":")+1,date.length()).trim();
		}
			
			//h
			private static void venderImovel(ArrayList<Imovel>imoveis) {
				
				System.out.println("Indique o tipo de Imovel que pretende vender: ");
				String tipoImovel = in.nextLine();
				System.out.println("Indique o id do imovel a vender: ");
				Integer idMovel = in.nextInt();
					
					for (Imovel imovel: imoveis) {
	
						switch(tipoImovel) {
						case "Apartamento":
							if(imovel.getClass().equals(Apartamento.class)){
								if(((Apartamento) imovel).getIdImovel() == idMovel) {
									if (((Apartamento)imovel).getEstado() == EstadoImovel.VENDIDO) {
										System.out.println("O apartamento já foi vendido ");
										break;
									} else {
										((Apartamento)imovel).setEstado(EstadoImovel.VENDIDO);
										visitas.remove(imovel.getIdImovel());
										System.out.println("O apartamento vendido com sucesso");
									}
								}
							}
							break;
						case "EspacoComercial":
							if(imovel.getClass().equals(EspacoComercial.class)){
								if(((EspacoComercial) imovel).getIdImovel() == idMovel) {
									if (((EspacoComercial)imovel).getEstado() == EstadoImovel.VENDIDO) {
										System.out.println("O Espaço comercial já foi vendido ");
										break;
									} else {
										((EspacoComercial)imovel).setEstado(EstadoImovel.VENDIDO);
										visitas.remove(imovel.getIdImovel());
										System.out.println("O Espaço comercial vendido com sucesso");
										
									}
								}
							}
							break;
						case "Moradia":
							if(imovel.getClass().equals(Moradia.class)){
								if(((Moradia) imovel).getIdImovel() == idMovel) {
									if (((Moradia)imovel).getEstado() == EstadoImovel.VENDIDO) {
										System.out.println("A moradia já foi vendida ");
										break;
									} else {
										((Moradia)imovel).setEstado(EstadoImovel.VENDIDO);
										visitas.remove(imovel.getIdImovel());
										System.out.println("O Moradia  vendida com sucesso");
									}
								}
							}
						break;
					}
					
				}
			}

			
			private static void calculaComissaoAgente(ArrayList<Imovel>imoveis, ArrayList<Agente> agentes) {
				
				 for (Agente ag: agentes) {
					 float totalAgente = 0.0f; 
					 for (Imovel imov: imoveis) {
						 if (ag.getIdAgente() == imov.getAgente().getIdAgente() && imov.getEstado() == EstadoImovel.VENDIDO) {
							totalAgente = totalAgente + imov.calculaComissao(); 
							
						 }
					 }
					 System.out.println(ag.toString() +" irá receber de comissão "+ totalAgente + "€");
					
					 
				 }
				 primaEnter();
				}
				

		private static void primaEnter() {
			System.out.println("Prima ENTER para continuar...");
			try {
				System.in.read();
			} catch (IOException exc) {
				System.out.println(exc.getMessage());
			}
		}
		
		
		
		private static void lerFicheiroXML(String nomeFicheiro) throws ParserConfigurationException, 
		SAXException, IOException{
			final ArrayList<Object> elems = new ArrayList<>();
	        
			DefaultHandler handler = new DefaultHandler() {
	        	ArrayList<String> dados = new ArrayList<>();

	            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
	            	if(qName.equalsIgnoreCase("Agente") || qName.equalsIgnoreCase("Apartamento") || qName.equalsIgnoreCase("Moradia")|| qName.equalsIgnoreCase("espaco-comercial")){
	            		dados.clear();
	            		String id = attributes.getValue(0);
	            		dados.add(id);
	            	}
	            }
	            
	            public void endElement(String uri, String localName, String qName) throws SAXException {
	                String id = dados.get(0);
	                int idAgente = 0;
	                Agente agente = null;
	                switch(qName){
	                case "agente":
	                	id = id.replaceAll(Agente.getPrefixoXML(), "");
	    				String nome = dados.get(1);
	    				agentes.add(new Agente(nome,Integer.parseInt(id)));
	    				break;
	    			case "apartamento" :
	    				id = id.replaceAll(Apartamento.getPrefixoXML(), "");
	    				String morada = dados.get(1) + dados.get(2);
						Integer quartos = Integer.parseInt(dados.get(3));
	    				float preco = Float.parseFloat(dados.get(4));
						idAgente = Integer.parseInt(dados.get(5).replaceAll(Agente.getPrefixoXML(), ""));
						agente = getAgenteByID(idAgente, agentes);
						float distancia = Float.parseFloat(dados.get(6));
	    				imoveis.add(new Apartamento(Integer.parseInt(id), agente,morada,EstadoImovel.ACTIVO, preco, distancia,quartos));
	    				break;
	    			case "moradia" :
	    				id = id.replaceAll(Moradia.getPrefixo(), "");
	    				String moradaMor = dados.get(1) + dados.get(2);
						int quartosMor = Integer.parseInt(dados.get(3));
						int frentesMor = Integer.parseInt(dados.get(4));
	    				float precoMor = Float.parseFloat(dados.get(5));
	    				idAgente = Integer.parseInt(dados.get(5).replaceAll(Agente.getPrefixoXML(), ""));
						agente = getAgenteByID(idAgente, agentes);
						float distanciaMor = Float.parseFloat(dados.get(7));
						imoveis.add(new Moradia(Integer.parseInt(id), agente,moradaMor,EstadoImovel.ACTIVO, precoMor, distanciaMor,quartosMor,frentesMor));
	    				break;
					case "espaco-comercial":
						id = id.replaceAll(EspacoComercial.getPrefixo(),"");
						String moradaEC = dados.get(1) + dados.get(2);
						Integer areaEC = Integer.parseInt(dados.get(3));
	    				float precoEC = Float.parseFloat(dados.get(4));
	    				idAgente = Integer.parseInt(dados.get(5).replaceAll(Agente.getPrefixoXML(), ""));
						agente = getAgenteByID(idAgente, agentes);
						float distanciaEC = Float.parseFloat(dados.get(6));
	    				imoveis.add(new EspacoComercial(Integer.parseInt(id), agente,moradaEC, EstadoImovel.ACTIVO,precoEC,distanciaEC,areaEC));
	    				break;
	                }
	            }
	            
	            public void characters(char ch[], int start, int length) throws SAXException {
	                String s = (new String(ch, start, length)).trim();
	                if( s.length() > 0 ) {
	                    dados.add(s);
	                }
	            }
	        };
	        
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        saxParser.parse(nomeFicheiro, handler);
		}
		
		private static void gravarFicheiroObjectos(ArrayList<Agente> agentes, ArrayList<Imovel>imoveis) throws IOException {
			for(Agente ag:agentes) {
				elems.add(ag.toString());
			}
			for(Imovel imov:imoveis) {
				elems.add(imov.toString());
			}
			ObjectOutputStream fOut = new ObjectOutputStream(new FileOutputStream("SGAI.dat"));
			fOut.writeObject(elems);
			fOut.close();
		}
		
		private static void lerFicheiroObjetos() throws IOException, ClassNotFoundException {
			ArrayList<Object> elems = new ArrayList<>();
			ObjectInputStream fIn = new ObjectInputStream(new FileInputStream("SGAI.dat"));
			elems = (ArrayList<Object>) fIn.readObject();
			for (Object obj :elems) {
				if(obj.getClass().getName().equals("Agente")) 
					agentes.add((Agente) obj);
				if(obj.getClass().getName().equals("Imoveis")) 
					imoveis.add((Imovel) obj);
			}
			fIn.close();
		}
		
		private static Agente getAgenteByID(int idAgente,ArrayList<Agente>agentes) {
			
			for(Agente agente:agentes) {
				if(idAgente == agente.getIdAgente())
					return agente;
				
			}
			return null;
		}
		
		
		//ValidaÃ§Ãµes
		private  static Boolean verificaAgentes(ArrayList<Agente>agentes) {
			if (agentes.isEmpty()) {
				System.out.println("Não existem agentes, por favor insira um antes de insrir um imovel");
				return true;
			} else {
				return false;
			}
		}
		
		private static Boolean verificaImoveis(ArrayList<Imovel>imoveis) {
			if (imoveis.isEmpty()) {
				System.out.println("Não existem imoveis, por favor insira imovel");
				return true;
			} else {
				return false;
			}
		}
		
		private static Boolean verificaVisitas(ArrayList<Visita>visitas) {
			if (visitas.isEmpty()) {
				System.out.println("Não existem visitas, por favor crie uma visita");
				
				return true;
			} else {
				return false;
			}
		}
		
		private static Boolean verificaAgentePorId(ArrayList<Agente>agentes, Integer idAgente) {
			boolean flag=false;
			for (Agente ag: agentes) 
				if (idAgente == ag.getIdAgente()) {
					flag=true;
					break;
				}
			return flag; 
			
		}
		
		private static Boolean verificaImovelPorId(ArrayList<Imovel>imoveis, Integer idimovel) {
			boolean flag=false;
			for (Imovel im: imoveis) 
				if (idimovel == im.getIdImovel()) {
					flag=true;
					break;
				}
			return flag; 
			
		}
		private static Object DevolveImovelPorId(ArrayList<Imovel>imoveis, Integer idimovel) {
			Object imov=new Object();
			for (Imovel im: imoveis) 
				if (idimovel == im.getIdImovel()) {
					imov=(Imovel)im;
					break;
				}
			return imov; 
			
		}
		/*private static Boolean verificaExisteVisitaAgendaNoDia(ArrayList<Visita>visitas, Integer idAgente, Data dataVisita) {
			boolean flag=false;
			Data dataVisita;
			for (Visita vis: visitas) 
				if (idAgente == vis.getAgente().getIdAgente()) {
					dataVisita=vis.getDataVisita();
					String d= getAno(dataVisita) + "/"+ getMes(dataVisita) + "/" + getDia(dataVisita);
					String d2= getAno(Dia) + "/"+ getMes(Dia) + "/" + getDia(Dia);
					DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				    LocalDate ld = LocalDate.parse(d, DATEFORMATTER);
				    LocalDate ld2 = LocalDate.parse(d2, DATEFORMATTER);
			        Period period = Period.between(ld, ld2);
				    if(period.getDays()==0)
				    {	
				    	System.out.println("já existe Marcacao neste dia " + d2.toString());
				    	flag=true;
				    	break;
				    }
				}
			return flag; 
			
		}*/
		public static String getAno(String date){
			   int pos=date.indexOf("/");
			   return  date.substring(0, pos);
			  }
			  
			  public static String getMes(String date){
			   int pos=date.indexOf("/");
			   return date.substring(pos+1,date.lastIndexOf("/"));
			  }
			  
			  public static String getDia(String date)
			  {
			   return date.substring(date.lastIndexOf("/")+1,date.indexOf(" ")).trim();
			  }
}

