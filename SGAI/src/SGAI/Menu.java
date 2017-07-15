package SGAI;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.Random;

public class Menu {
	//Windows nº de colunas e linhas que vai ter o terminal
	private	static int nColunas=100;
	private	static int nLinhas=25;
	
	private static String comandoLinhaComandos="cmd";
	private static String comandoLinhaComandosOpcao="/c";
	private static String comandoLinhaComandoslimpaEcra="cls";
	private static String os;
	
    public static void main(String... args)
    throws Exception
    {
        // testes com impressoes
		//impressoes();
		
		//Obter o SO da maquina
		os = System.getProperty("os.name").toLowerCase();
		
		//Windows
		
		int nLinhas=25;
		if(os.contains("win")){
			
			//colocar nº colunas/linhas Windows
			try{
			String comandoTamanhoEcra="cmd /Q/c mode " + (nColunas+20) + "," + nLinhas;
		
			Process p = Runtime.getRuntime().exec("cmd /c mode "+ nColunas +"," + nLinhas);
			ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "mode con");
			comandoLinhaComandos="cmd";  // chamar a linha de comandos
			comandoLinhaComandosOpcao="/c";  // /c significa que é para o executar o comando seguinte
			comandoLinhaComandoslimpaEcra="cls"; // cls comando efectivamente executado
			
					}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
		}
		/*//Mac
		if(os.contains("mac")){
			//... Pesquisar
		}
		//Linux
		if(os.contains("linux")){
			//... Pesquisar
		*/
		
		
		//CHAMA menu Principal
		menu();
		System.out.println("Programa encerrado.");
    }
	
	public static void limpaEcra()
	{
		try{
				if(os.contains("win")){
					new ProcessBuilder(comandoLinhaComandos, comandoLinhaComandosOpcao, comandoLinhaComandoslimpaEcra).inheritIO().start().waitFor();
				}
				else
				{
					Runtime.getRuntime().exec("clear");
				}
			}
	catch(Exception e){
		System.out.println("ERRO");
	}
}
	public static void impressoes()
	{
		System.out.printf("%10d\n", 111); //imprime o numero depois de 10 espacos
		System.out.printf("%-10d texto\n", 111); //imprime o numero depois dá 10 espacos à sua direita e depois vem o texto
		
		
		//Exemplo com linha e coluna alinhados
		System.out.println("\nExemplo com linha e coluna alinhados:\n\n");
		System.out.printf("%-10s %-10s %-10s\n", "Coluna1", "Coluna2", "Coluna3");
		System.out.printf("%-10s %-10s %-10s\n", "val1", "val2", "val3");
		 
	}
	
	private static void menu() { // menu principal
		int opcao = 9;

		int margem=10;
		int numVendedores, numVisitasAgendadas, numImoveisVendidos, numTotalImoveis, numMoradias, numApartamentos, numEspacoComerc;
		int idMelhorAgente; //mais imóveis vendidos;
		String nomeMelhorAgente; //mais imoveis vendidos;
		String linha="";
		Scanner scanner = new Scanner (System.in);
		int limiteLinha=60;
		do {
			limpaEcra();
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","SGAI - Sistema Gestao de Agencia Imobiliaria", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			//MENU PRINCIPAL
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                 =========================","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                   |     1 - Agentes        | ","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     2 - Imoveis        |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     3 - Visitas        |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     4 - Listagens      |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     5 - Carregar Fich. |","###"));
			
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     6 - Gravar Fich.   |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     0 - Sair           |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  =========================","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			
			//TODO
			//TROCAR ESTES RANDOM PELOS VALORES da chamada das FUNÇÕES
			numVendedores=geraNumAleatorio();
			numVisitasAgendadas=geraNumAleatorio();
			numImoveisVendidos=geraNumAleatorio();
			numTotalImoveis=geraNumAleatorio();
			numMoradias=geraNumAleatorio(); 
			numApartamentos=geraNumAleatorio(); 
			numEspacoComerc=geraNumAleatorio();
			idMelhorAgente=geraNumAleatorio(); //mais imóveis vendidos;
			nomeMelhorAgente="Nome YYYY";
			
			
			
			System.out.printf("%10s","");
			linha=preencheDireitaAte("   (07)-#Agentes:" + numVendedores,limiteLinha) + "    (08)-#N Imoveis:" + numTotalImoveis +"  ";
			System.out.printf("%s\n",preencheLinhaFastMenu("###",linha, "###"));
			
			System.out.printf("%10s","");
			linha= preencheDireitaAte("   (09)-#Visitas Agendadas:" + numVisitasAgendadas  ,limiteLinha)+ "    (10)-#Moradias:" + numTotalImoveis + "  ";
			System.out.printf("%s\n",preencheLinhaFastMenu("###",linha, "###"));
			
			System.out.printf("%10s","");
			linha= preencheDireitaAte("   (11)-#Imoveis Vendidos:" + numImoveisVendidos  ,limiteLinha)+ "    (12)-#Apartamentos:" + numApartamentos + "  ";
			System.out.printf("%s\n",preencheLinhaFastMenu("###",linha, "###"));
			
			
			/*System.out.println(linha);
			System.out.println(linha.length());
			System.out.printf("%s\n",preencheLinha("###",linha, "###"));*/
			
			System.out.printf("%10s","");
			linha= preencheDireitaAte("   (13)-#Id Melhor Agente:" + idMelhorAgente  ,limiteLinha)+ "    (14)-#Esp. Comerc.:" + numEspacoComerc + "  ";
			System.out.printf("%s\n",preencheLinhaFastMenu("###",linha, "###"));
			
			System.out.printf("%10s","");
			linha= preencheDireitaAte("   (15)-#Melhor Agente:" + nomeMelhorAgente  ,limiteLinha)+ "    #__________:"   ;
			System.out.printf("%s\n",preencheLinhaFastMenu("###",linha, "###"));
			
			
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			
			System.out.printf("%10s","");
			System.out.printf("%s",imprimeOpcao("###","Opcao -> "));
			
			
			opcao= scanner.nextInt();     
			//System.out.print("\n");
			switch (opcao) {
			case 1:
				imprimeMenuAgente();	
				break;
			case 2:
				//fornecedor();
				break;
                       //case3 , 4  , etc...
			case 5:
				//cliente();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}
	
	public static int geraNumAleatorio(){
		Random r = new Random();
		int Low = 10;
		int High = 100;
		int Result = r.nextInt(High-Low) + Low;
		
		return Result;
	}
	
	public static String preencheDireitaAte(String txt, int limite){
		String res;
		int aux;
		
		res=txt;
		
		if (txt.length()<=limite){
			while( (res + " ").length()<=limite)
			{
				res= res + " ";
			}
			
		}
		else{
			res=txt.substring(0,limite);
		}
		
		return res;
	}
	public static void imprimeMenuAgente()
	{
				int opcao_nivel2=9;
				Scanner scanner = new Scanner (System.in);
		do {
			limpaEcra();
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","SGAI - Sistema Gestao de Agencia Imobiliaria", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			//MENU PRINCIPAL
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                 =========================","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     1 - Ficha Agente   |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     2 - Inserir        |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     3 - Listar Agentes |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     4 - Comissoes      |","###"));
			
			
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  |     0 - Sair           |","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","                  =========================","###"));
			
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinha("###","", "###"));
			System.out.printf("%10s","");
			System.out.printf("%s\n",preencheLinhaCom("#"));
			
			System.out.printf("%10s","");
			System.out.printf("%s",imprimeOpcao("###","Opcao -> "));
			
			
			opcao_nivel2= scanner.nextInt();     
			//System.out.print("\n");
			switch (opcao_nivel2) {
			case 1:
					
				break;
			case 2:
				//
				break;
                     
			case 5:
				
				break;
			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao_nivel2 != 0);
	}
	
	public static String preencheLinhaCom(String texto){
		
		StringBuilder  s= new StringBuilder();
		
		while((s.length() + texto.length())<=nColunas)
		{
			s.append(texto);
		}
		
		return s.toString();
	}
	
	public static String preencheLinha(String txtEsquerda, String txtConteudo, String txtDireita)
	{
		StringBuilder  s= new StringBuilder();
		
		s.append(txtEsquerda);
		
		int posicaoMeio= ((int)( (nColunas - txtConteudo.length())/2))-3;
		//System.out.println("tam:" + txtConteudo.length() + " meio:" +  posicaoMeio );
		int i=0;
		while(i<=posicaoMeio)
		{
			s.append(" ");
			i=i+1;
		}
		s.append(txtConteudo);
		
		while((s.length() +  txtDireita.length())<nColunas)
		{
			s.append(" ");
		}
		
		s.append(txtDireita);
		
		return s.toString();
	}
	
	public static String preencheLinhaFastMenu(String txtEsquerda, String txtConteudo, String txtDireita)
	{
		StringBuilder  s= new StringBuilder();
		
		s.append(txtEsquerda);
		s.append(txtConteudo);
		/*int posicaoMeio= ((int)( (nColunas - txtConteudo.length())/2))-3;
		System.out.println("tam:" + txtConteudo.length() + " meio:" +  posicaoMeio );
		int i=0;
		while(i<=posicaoMeio)
		{
			s.append(" ");
			i=i+1;
		}
		s.append(txtConteudo);*/
		
		while((s.length() +  txtDireita.length())<nColunas)
		{
			s.append(" ");
		}
		
		s.append(txtDireita);
		
		return s.toString();
	}
	
	public static String imprimeOpcao(String txtEsquerda, String txtConteudo)
	{
		StringBuilder  s= new StringBuilder();
		
		s.append(txtEsquerda);
		
		int posicaoMeio= ((int)( (nColunas - txtConteudo.length())/2))-3;
		
		int i=0;
		while(i<=posicaoMeio)
		{
			s.append(" ");
			i=i+1;
		}
		s.append(txtConteudo);
		
		
		return s.toString();
	}
}
