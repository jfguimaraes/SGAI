package SGAI;

public class Habitacao extends Imovel {
	private static float fltComissao = 0.03f; 
	private int numQuartos = 0;
	
	
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
	
	public Habitacao() {
		super();
		setNumQuartos(0);
	}
	
	 public Habitacao(Integer idImovel, Agente agente, String morada, String Ei, float Preco,  float Distancia,  Integer numQuartos){

 		//invocacao do constructor vazio com parametros de entrada
 		super(idImovel,agente, morada, Ei, Preco,  Distancia);
 		this.setNumQuartos(numQuartos);	
	 }
 		
	 public String toString () {
			return String.format ("%sNumero de quartos: %d%n", super.toString(), this.numQuartos);
		}

		@Override
		public float calculaComissao() {
			// TODO Auto-generated method stub
			return getPreco() * fltComissao;
		}

	
 }


