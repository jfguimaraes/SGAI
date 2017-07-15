package SGAI;

public class Moradia extends Habitacao{

	//variaveis de classe
	
		
		/**
	     * regista o numero de Frentes.
	     */
		 
		private Integer numFrentes;  //por defeito sera zero
		
		
		/**
	      * O valor da comissao em percentagem.
	      */
	     private static float fltComissao = 0.03f;
	     
		/**
	     * O valor de classe para contablizar o numero de instancias da classe Imovel.
	     */
	    private static Integer contaMoradia=0;
	    
	    
	    private static Integer duracaoVisita = 90;
	    
	    /**
	     * vari�vel da classe para permitir personalizar o prefixo do ID do Imovel.
	     */
	    public static String prefixo="MD";
	    
		
	  //Construtores da classe
	    
	    /**
	     * Inicializa as variaveis da classe Apartamentos com valores por omissao( a super classe (Imovel) tb e inicializada com valores por defeito)
	     */
	    public Moradia()
	   {
		   	//invocacao do constructor vazio da superclasse
	    	super();
		   	this.setNumFrentes(0);
	   	}
	    
	    /**
	     * Inicializa as variaveis da criacao da classe Apartamento e a super(Imovel).
	     *
	     * @param IDImovel identificador do imovel
	     * @param idAgente o identificador do Agente
	     * @param morada  da localizacao do Imovel
	     * @param Ei o definicao do estado do Imovel relativamente ao mercado
	     * @param Preco do Imovel
	     * @param Distancia distancia entre o Imovel e a agencia (minutos)
	     * @param numQuartos define o numero de quartos da moradia
	     * @param Numfrentes define o numero de frentes da moradia
	     */
	    public Moradia(Integer idImovel, Agente agente, String morada, String Ei, float Preco,  float Distancia,  Integer numQuartos,Integer numFrentes){

	    		//invocacao do constructor vazio com parametros de entrada
	    		super(idImovel,agente, morada, Ei, Preco,Distancia,numQuartos);
	    		this.setNumFrentes(numFrentes);
	    }

	    /**
	     * Devolve a comissao do imovel
	     *
	     * @return fltComissao referente a comissao do imovel
	     */
		public static float getComissao() {
			return fltComissao;
		}
		
		/**
	     * Modifica a comissao do imovel
	     *
	     * @param fltComissao a nova comissao do imovel
	     */
		public static void setComissao(float fltComissao) {
			Moradia.fltComissao = fltComissao;
		}
		 
		public static String getPrefixo(){
			return new String(prefixo);
		}
		
		public static void setPrefixo(String Prefixo){
			prefixo=Prefixo;
		}
		 

		/**
	     * Devolve todos os dados do Imovel/Moradia.
	     *
	     * @return ID do Imovel
	     * @return ID do Agente resposanvel
	     * @return Morada do Imovel
	     * @return Estado do Imovel relativamente a sua situacao no mercado
	     * @return Preco do imovel em euros
	     * @return Comisao da venda em %
	     * @return Distancia entre o imovel e a agenca.
	     * @return numero de Quartos que o Imovel possui
	     * @return numero de Frentes que o Imovel possui
	     */	
		public String toString(){
			return String.format("%s \nNumero de Frentes: %d", super.toString(),this.getNumFrentes()); 
		}
		/**
	     * Devolve o numero de Frentes que a moradia tem.
	     *
	     * @return numFrentes numero de Frentes que  Imovel possui
	     */
		
		public Integer getNumFrentes() {
			return numFrentes;
		}

		/**
	     * Modifica o numero de Frentes da moradia.
	     *
	     * @param numFrentes o valor de numero Frentes da moradia
	     */
		
		public void setNumFrentes(Integer numFrentes) {
			this.numFrentes = numFrentes;
		}

		
		public static Integer getContaMoradia() {
			return contaMoradia;
		}

		public static void setContaMoradia(Integer contaMoradia) {
			Moradia.contaMoradia = contaMoradia;
		}

		public static Integer getDuracaoVisita() {
			return duracaoVisita;
		}

		public static void setDuracaoVisita(Integer duracaoVisita) {
			Moradia.duracaoVisita = duracaoVisita;
		}
}
