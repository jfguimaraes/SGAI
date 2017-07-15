package SGAI;

import java.sql.Date;

public class Visita {

	 private Integer idVisita;
	 private Agente agente;
	 private Integer IdImovel;
	 private Data dataVisita;
	 private Tempo tempoVisita;
	 private String nomeVisitante;
	 private int numTelefoneVisitante;
	 
	 private static Integer contaVisitas=0;
	 
	 public Visita(){
		 
		 this.setAgente(null);
		 this.setIdImovel(-1);
		 this.setDataVisita(null);
		 this.setTempoVisita(null);
		 this.setNomeVisitante("");
		 this.setNumTelefoneVisitante(-1);
	 }
	 
	 public Visita(Agente agente, Integer idImovel, Data dataVisita, Tempo tempoVisita, String nomeVisitante, int numTelefoneVisitante) {
		 Visita.setContaVisitas(Visita.getContaVisitas()+1);
		 this.setIdVisita(Visita.getContaVisitas());
		 this.setAgente(agente);
		 this.setIdImovel(idImovel);
		 this.setDataVisita(dataVisita);
		 this.setTempoVisita(tempoVisita);
		 this.setNomeVisitante(nomeVisitante);
		 this.setNumTelefoneVisitante(numTelefoneVisitante);
	 }
	
	
	public Agente getAgente() {
		return agente;
	}
	public void setAgente(Agente agenteVisita) {
		this.agente = agenteVisita;
	}
	public Integer getIdImovel() {
		return IdImovel;
	}
	public void setIdImovel(Integer IdImovel) {
		this.IdImovel = IdImovel;
	}
	public Data getDataVisita() {
		return dataVisita;
	}
	public Tempo getTempoVisita() {
		return tempoVisita;
	}
	public void setDataVisita(Data dataVisita) {
		this.dataVisita = dataVisita;
	}
	public void setTempoVisita(Tempo tempoVisita) {
		this.tempoVisita = tempoVisita;
	}
	public String getNomeVisitante() {
		return nomeVisitante;
	}
	public void setNomeVisitante(String nomeVisitante) {
		this.nomeVisitante = nomeVisitante;
	}
	public int getNumTelefoneVisitante() {
		return numTelefoneVisitante;
	}
	public void setNumTelefoneVisitante(int numTelefoneVisitante) {
		this.numTelefoneVisitante = numTelefoneVisitante;
	}
	
	public Integer getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}
	public static Integer getContaVisitas() {
		return contaVisitas;
	}
	public static void setContaVisitas(Integer contaVisitas) {
		Visita.contaVisitas = contaVisitas;
	}
  
	public String toString(){
		return String.format("nData: %s \nNome: %s \nTelefone %d ",this.getDataVisita(), this.getNomeVisitante(), this.getNumTelefoneVisitante());
	}
	
	
}
