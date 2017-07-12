package SGAI;

import java.sql.Date;

public class Visita {

	 private Integer idVisita;
	 private Integer intIdAgente;
	 private Integer IdImovel;
	 private String dataVisita;
	 private String nomeVisitante;
	 private int numTelefoneVisitante;
	 
	 private static Integer contaVisitas=0;
	 
	 public Visita(){
		 
		 this.setIntIdAgente(-1);
		 this.setIdImovel(-1);
		 this.setDataVisita("");
		 this.setNomeVisitante("");
		 this.setNumTelefoneVisitante(-1);
	 }
	 
	 public Visita(Integer idAgente, Integer idImovel, String date, String nomeVisitante, int numTelefoneVisitante) {
		 Visita.setContaVisitas(Visita.getContaVisitas()+1);
		 this.setIdVisita(Visita.getContaVisitas());
		 this.setIntIdAgente(idAgente);
		 this.setIdImovel(idImovel);
		 this.setDataVisita(date);
		 this.setNomeVisitante(nomeVisitante);
		 this.setNumTelefoneVisitante(numTelefoneVisitante);
	 }
	
	
	 public Integer getIntIdAgente() {
		return intIdAgente;
	}
	public void setIntIdAgente(Integer intIdAgente) {
		this.intIdAgente = intIdAgente;
	}
	public Integer getIdImovel() {
		return IdImovel;
	}
	public void setIdImovel(Integer IdImovel) {
		this.IdImovel = IdImovel;
	}
	public String getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(String dataVisita) {
		this.dataVisita = dataVisita;
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
