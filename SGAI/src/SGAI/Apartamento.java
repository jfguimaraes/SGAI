package SGAI;

public class Apartamento extends Imovel implements EstadoImovel {

	//variaveis de classe
	
	/**
     * regista o n˙mero de Quartos.
     */
	
	private Integer numQuartos;  //por defeito sera zero
	
	/**
     * O valor da comissao em percentagem.
     */
    private static float fltComissao=0.03f;  
    
	
	/**
     * O valor de classe para contablizar o numero  de instancias da classe Apartamento
     */
    private static Integer contaApartamentos=0;
    
    private static Integer duracaoVisita = 60; 
    
    /**
     * variavel da classe para permitir personalizar o prefixo do ID do Imovel a utilizar no ficheiro XML.
     */
    private static String prefixoXML="AP";
    
	
  //Construtores da classe
    
    /**
     * Inicializa as variaveis da classe Apartamentos com valores por omissao ( a super classe (Imovel) tb È inicializada com valores por defeito)
     */
    public Apartamento()
   {
	   	//invocacao do constructor vazio da superclasse
    	super();
	   	this.setNumQuartos(0);
   	}
    
    /**
     * Inicializa as variaveis da criacao da classe Apartamento e a super(Imovel).
     *
     * @param IDImovel identificador do Imovel
     * @param idAgente o identificador do Agente
     * @param morada  da localizacao do imovel
     * @param Ei o ddefinicao do estado do imovel relativamente ao mercado
     * @param Preco do imovel
     * @param Distancia distancia entre o imovel e a agencia (minutos)
     * 
     */
    public Apartamento(Integer idImovel, Integer IdAgente, String morada, String Ei, float Preco,  float Distancia,  Integer numQuartos){

    		//invocacao do constructor vazio com parametros de entrada
    		super(idImovel,IdAgente, morada, Ei, Preco,  Distancia);
    		this.setNumQuartos(numQuartos);	
    }

    /**
     * Devolve a comissao do imovel
     *
     * @return fltComissao referente a comissao do imovel
     */
	public static float getComissao() {
		return Apartamento.fltComissao;
	}
	
	/**
     * Modifica a comissao do imovel
     *
     * @param fltComissao a nova comissao do imovel
     */
	public static void setComissao(float fltComissao) {
		Apartamento.fltComissao = fltComissao;
	}
	/**
     * Devolve o numero de Quartos que o apartamento tem.
     *
     * @return numQuartos numero d Quartos que  Imovel possui
     */ 
	
	public Integer getNumQuartos() {
		return numQuartos;
	}

	
	/**
     * Modifica o numero de Quartos.
     *
     * @param numQuartos o numero de Quartos que o Apartamento possui
     */
	
	public void setNumQuartos(Integer numQuartos) {
		this.numQuartos = numQuartos;
	}

	 
	public static Integer getContaApartamentos() {
		return contaApartamentos;
	}

	public static void setContaApartamentos(Integer contaApartamentos) {
		Apartamento.contaApartamentos = contaApartamentos;
	}

	/**
     * Devolve todos os dados do imovel/Apartamento.
     *
     * @return ID do imovel
     * @return ID do Agente responsavel
     * @return Morada do imvel
     * @return Estado do imovel relativamente a sua situacao no mercado
     * @return preco do imovel em euros
     * @return comissao de venda em percentagem
     * @return distancia do imovel a agencia em minutos.
     * @return Numero de Quartos que o imovel possui
     */	
	public String toString(){
		return String.format("%s \nNumero de Quartos: %d ", super.toString(),this.getNumQuartos()); 
	}

	public static Integer getDuracaoVisita() {
		return duracaoVisita;
	}

	public static void setDuracaoVisita(Integer duracaoVisita) {
		Apartamento.duracaoVisita = duracaoVisita;
	}

	public  float calculaComissao(){
		   return getPreco() * fltComissao;
	}

	public static String getPrefixoXML() {
		return prefixoXML;
	}

	public static void setPrefixoXML(String prefixoXML) {
		Apartamento.prefixoXML = prefixoXML;
	}
	
}
