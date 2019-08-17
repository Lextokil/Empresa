package br.com.Api_Empresa.Model;

public class Programador extends Funcionario {

	private long idProgramador;
	private String lgProgramador;
	
	
	public long getId_programador() {
		return idProgramador;
	}
	public void setId_programador(long idProgramador) {
		this.idProgramador = idProgramador;
	}
	public String getLg_programador() {
		return lgProgramador;
	}
	public void setLg_programador(String lgProgramador) {
		this.lgProgramador = lgProgramador;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (idProgramador ^ (idProgramador >>> 32));
		result = prime * result + ((lgProgramador == null) ? 0 : lgProgramador.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programador other = (Programador) obj;
		if (idProgramador != other.idProgramador)
			return false;
		if (lgProgramador == null) {
			if (other.lgProgramador != null)
				return false;
		} else if (!lgProgramador.equals(other.lgProgramador))
			return false;
		return true;
	}
	
	











}
