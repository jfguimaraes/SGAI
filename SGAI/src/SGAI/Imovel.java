package SGAI;


/**
 * Esta classe permite a construcao do Objecto Imovel. 
 * Representa/Caracteriza as caracterÌsticas/propriedades em comum a todos os tipos de imovel
 *
 * @author Andre Salome e Filipe
 */
public abstract class Imovel implements  Comparable<Imovel>{

	 //variaveis de insancia
	
	/**
     * O Identificador do Imovel.
     */
	 private Integer stridImovel;
	 /**
	 * A morada do imovel
	 */
	 private String strMorada;
	 /**
	 * O Identificador do Agente responsavel.
	 */
     private Agente agente;
     /**
     * Valor com o valor da distancia do imovel e a agencia em minutos
     */
     private Float  fltDistancia;
     /**
     * Valor que identifica o estado do imovel  relativamente ao mercado imobiliario
     */
     private String strEstado;
     /**
      * O preco do imovel
      */
     private float fltPreco;
     
     
     
     /**
      * O valor de classe para contablizar o numero de instancias da classe imovel
      */
     private static Integer contaImoveis=0;
     
     
     
     
     //definicao de valores por defeito
     
     public static final Integer IDImovel = 0; //
     public static final String MORADA = "ND"; //ND = NAO DISPONIVEL
     public static final float DISTANCIA = 0;
     public static final float PRECO = 0;
     
     
     
     
      
     //Construtores da classe
    
     /**
      * Inicializa as variaveis da classe Imovel com valores por omisao.
      */
     public Imovel()
    {
    	this.setIdImovel(Imovel.IDImovel);
    	this.setAgente(agente);
    	this.setMorada(Imovel.MORADA);
    	this.setEstado(EstadoImovel.ANGARIACAO);
    	this.setPreco(Imovel.PRECO);
    	this.setDistancia(Imovel.DISTANCIA);
    	
    	//this.setContaImoveis(this.getContaImoveis()+1);
    }
     
     /**
      * Inicializa as variaveis da criacao da classe Imovel.
      *
      * @param IDImovel identificador do imovel
      * @param idAgente o identificador do Agente
      * @param morada  da localizacao do imovel
      * @param Ei o definicao do estado do imovel  relativamente ao mercado
      * @param Preco do imovel
      * @param Comissao a da venda do imovel
      * @param Distancia entre o imovel e a agencia (minutos)
      * 
      */
     public Imovel(Integer idImovel, Agente agente, String morada, String Ei, float Preco, float Distancia){

    	this.setIdImovel(idImovel);
     	this.setAgente(agente);
     	this.setMorada(morada);
     	this.setEstado(Ei.toString());
     	this.setPreco(Preco);
      	this.setDistancia(Distancia);
     }
     
     /**
      * Devolve o Identificador do Imovel
      *
      * @return stridImovel do Imovel
      */ 
	public Integer getIdImovel() {
		return stridImovel;
	}
	
	 /**
     * Modifica o ID do Imovel.
     *
     * @param stridImovel o novo ID do Imovel
     */
	public void setIdImovel(Integer stridImovel) {
		this.stridImovel = stridImovel;
	}
	
	/**
     * Devolve a morada do Imovel
     *
     * @return strMorada do Imovel
     */
	public String getMorada() {
		return strMorada;
	}
	
	 /**
     * Modifica a morada do Imovel.
     *
     * @param strMorada a nova morada do Imovel
     */
	public void setMorada(String strMorada) {
		this.strMorada = strMorada;
	}
	
	/**
     * Devolve o ID do agente responsavel
     *
     * @return intIdAgente do Agente responsavel
     */
	public Agente getAgente() {
		return agente;
	}
	
	 /**
     * Modifica o ID do Agente responsavel do Imovel.
     *
     * @param intIdAgente o novo ID do Agente
     */
	public void setAgente(Agente agente) {
		this.agente = agente;
	}
	
	
	/**
     * Devolve a entre a agencia e o imovel.
     *
     * @return fltDistancia relativa a distancia entre o imovel e a agencia.
     */
	
	public Float getDistancia() {
		return fltDistancia;
	}
	
	 /**
     * Modifica a distancia do Imovel e a agencia
     *
     * @param fltDistancia a nova Distancia
     */
	public void setDistancia(Float fltDistancia) {
		this.fltDistancia = fltDistancia;
	}
	
	/**
     * Devolve o estado do imovel relativamente a sua posicao no mercado
     *
     * @return intEstado do imovel relativamente a sua posicao no mercado
     */
	public String getEstado() {
		return strEstado;
	}
	
	/**
     * Modifica o estado do Imovel relativamente a sua posicao no mercado
     *
     * @param strEstado o novo estado do imovel
     */
	public void setEstado(String strEstado) {
		this.strEstado = strEstado;
	}
	
	/**
     * Devolve o Preco do imovel
     *
     * @return fltPreco referente ao preco do imovel
     */
	public float getPreco() {
		return fltPreco;
	}
	
	/**
     * Modifica opreco do imovel
     *
     * @param fltPreco o novo preco do imovel
     */
	public void setPreco(float fltPreco) {
		this.fltPreco = fltPreco;
	}
	
	
	
	
	/**
     * Devolve o numero de instancias criadas da classe Imovel;
     *
     * @return contaImoveis referente ao numero de instancias criadas da classe Imovel;
     */
	public static Integer getContaImoveis() {
		return contaImoveis;
	}
	
	/**
     * Modifica o valor de instancias do imovel
     *
     * @param contaImoveis o novo valor de instancia do imovel
     */
	public static void setContaImoveis(Integer contaImoveis) {
		Imovel.contaImoveis = contaImoveis;
	}
     
	
	/**
     * Devolve todos os dados do imovel
     *
     * @return ID do imovel
     * @return ID do Agente responsavel
     * @return Morada do imovel
     * @return Estado do imovel relativamente a sua situacao no mercado
     * @return Preco do imovel em euros
      * @return Distancia do imovel A agencia em minutos
     */	
	
     public String toString() {
    	 return String.format("IdImovel: %d \nMorada do Imovel: %s \nID Agente %s \nEstado: %s \nPreco: %.1f € \nDistancia: %.1f Minutos",this.getIdImovel(),this.getMorada(),this.agente.toString(),this.getEstado(),this.getPreco(),this.getDistancia());
     }
     
     
     /**
      * funcao que implementa o calculo da comissao da venda de um imove
      * Esta funcao eventualmente poderia ser implementada na classe imovel dado que a taxa da comisao È transversal a todo o tipo de imovel, no entanto,
      * a pensar no futuro, consideramos que a funcao podera a vir a ser diferente para cada tipo de imovel.
      * @param nenhum
      */
     public abstract float calculaComissao();
     
     public int compareTo(Imovel outroImovel){  
     	float estePreco = this.getPreco();
     	float outroPreco = outroImovel.getPreco();
     	if(estePreco==outroPreco)
     	return 0;  
     	else if(estePreco>outroPreco)  
     	return 1;  
     	else  
     	return -1;  
     	}  
     

 
   }
