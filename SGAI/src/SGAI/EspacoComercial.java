package SGAI;

public class EspacoComercial extends Imovel {
	

	//variaveis de classe
	
	/**
     * regista a ·rea Bruta.
     */
	
	private Integer areaBruta;  //por defeito ser· zero
	
	/**
     * O valor da comissao em percentagem.
     */
    private static float fltComissao = 0.05f;
    
	 private static Integer duracaoVisita = 30; 
	/**
     * O valor de classe para contablizar o n∫ de de instancias da classe Espaco Comercial.
     */
    private static Integer contaEspacoComercial=0;
    
    /**
     * variÔøΩvel da classe para permitir personalizar o prefixo do ID do Imovel.
     */
    public static String prefixo="EC";
    
	
  //Construtores da classe
    
    /**
     * Inicializa as variaveis da classe Espaco Comercial com valores por omissao ( a super classe (Imovel) tb e inicializada com valores por defeito)
     */
    public EspacoComercial()
   {
	   	//invocacao do constructor vazio da superclasse
    	super();
	   	this.setAreaBruta(0);
   	}
    
    /**
     * Inicializa as variaveis da criacao da classe Espaco Comercial e a super(Imovel).
     *
     * @param IDImovel identificador do Imovel
     * @param idAgente o identificador do Agente
     * @param morada  da localizacao do Imovel
     * @param Ei o definicao do estado do imovel relativamente ao mercado
     * @param Preco do imovel
      * @param Distancia entre o imovel e a agencia (minutos)
     * 
     */
    public EspacoComercial(Integer idImovel, Agente agente, String morada, String Ei, float Preco,  float Distancia,  Integer AreaBruta){

    		//invocacao do constructor vazio com parametros de entrada
    		
    		super(idImovel,agente, morada, Ei, Preco, Distancia);
    		this.setAreaBruta(AreaBruta);	
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
	public void setComissao(float fltComissao) {
		EspacoComercial.fltComissao = fltComissao;
	}
	
	/**
     * Devolve o  valor referente area  Bruta do imovel
     *
     * @return o valor referente area Bruta do imovel
     */ 
	
	public Integer getAreaBruta() {
		return areaBruta;
	}

	
	/**
     * Modifica a area bruta do imovel
     *
     * @param areaBruta o novo valor da area bruta do imovel
     */
	
	public void setAreaBruta(Integer areaBruta) {
		this.areaBruta = areaBruta;
	}

	
	 public  float calculaComissao(){
		 return this.fltComissao * this.getPreco();
	 }

	 
	public static String getPrefixo(){
		return new String(prefixo);
	}
	
	public static void setPrefixo(String Prefixo){
		prefixo=Prefixo;
	}
	 public static Integer getContaEspacoComerciail() {
		return contaEspacoComercial;
	}

	public static void setContaEspacoComercial(Integer contaEspacoComercial) {
		EspacoComercial.contaEspacoComercial = contaEspacoComercial;
	}

	/**
     * Devolve todos os dados do Imovel/Espaco comercial.
     *
     * @return ID do Imovel
     * @return ID do Agente responsÔøΩvel
     * @return Morada do imovel
     * @return Estado do imovel relativamente a sua situacao no mercado
     * @return Preco do imovel em euros
     * @return Comissao de Venda em percentage,
     * @return Distancia entre o imovel e agencia em minutos
     * @return valor da area bruta do imovel
     */	
	public String toString(){
		return String.format("%s \nArea Bruta: %d", super.toString(),this.getAreaBruta()); 
	}

	public static Integer getDuracaoVisita() {
		return duracaoVisita;
	}

	public static void setDuracaoVisita(Integer duracaoVisita) {
		EspacoComercial.duracaoVisita = duracaoVisita;
	}

}
