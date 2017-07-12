package SGAI;

/**
 * Esta classe permite a construcao do objecto Agente. 
 * Representa/Caracteriza o agente imobiliario 
 *
 * @author Andre, Salome e Filipe
 */
public class Agente {

	//variaveis de instancia
	
	 /**
     * O nome do Agente.
     */
	private String strNome;
	
	 /**
     * O ID do Agente.
     */
	private Integer intIdAgente;
	
	 /**
     * O nome por omissao do Agente.
     */
	private static final String NOME_POR_OMISSAO = "sem nome";
	
	 /**
     * O ID por omisao do Agente.
     */
	public static final Integer ID_POR_OMISSAO = 0;
	
	/**
     * variavel de class que regista o ultimo id/numero de agente criado ou o maior existent/carregado
     */
	private static Integer numAgente=0;
	
	/**
     * variavel de class que contem os digitos que servirao de prefixo para registar o ficheiro XML ou outro..
     */
	private static String prefixoXML="AG";
	
	//Constructores da Classe
	/**
     * Inicializa o nome e ID do Agente com valores por omissao.
     */
	public  Agente()
		{
			this.setNome(Agente.NOME_POR_OMISSAO);
			this.setIdAgente(Agente.ID_POR_OMISSAO);
		}
		
	
	/**
     * Inicializa o nome e ID do Agente com valores recebidos nos parametros de entrada
     *
     * @param strNome o nome do Agente
     * @param intIdAgente o ID do Agente
     */
	public Agente(String strNome, Integer intIdAgente){
			this.setNome(strNome);
			this.setIdAgente(intIdAgente);
		}

	/**
     * Devolve o nome do Agente.
     *
     * @return nome do Agente
     */
	public String getNome() {
		return strNome;
	}
	/**
     * Modifica o nome do Agente com o nome recebido.
     *
     * @param strNome o nome do Agente
     */
	public void setNome(String strNome) {
		this.strNome = strNome;
	}
	
	/**
     * Devolve o ID do Agente.
     *
     * @return ID do Agente
     */
	public Integer getIdAgente() {
		return intIdAgente;
	}
	
	/**
     * Modifica o ID do Agente com o ID recebido.
     *
     * @param intIdAgente o ID do Agente
     */
	public void setIdAgente(Integer intIdAgente) {
		this.intIdAgente = intIdAgente;
	}
	
	
	/**
     * Devolve o nome e ID do Agente.
     *
     * @return nome do Agente
     * @return ID do Agente
     */	
	public String toString()
	{
		return String.format("Id Agente: %d Nome do Agente: %s", this.getIdAgente(), this.getNome());
	}


	public static Integer getNumAgente() {
		return numAgente;
	}


	public static void setNumAgente(Integer numAgente) {
		Agente.numAgente = numAgente;
	}


	public static String getPrefixoXML() {
		return prefixoXML;
	}


	public static void setPrefixoXML(String prefixoXML) {
		Agente.prefixoXML = prefixoXML;
	}
	
}
