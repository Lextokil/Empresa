package br.com.Api_Empresa.Model;

public class Programador extends Funcionario {

	private long id;
	private String lgProgramador;
	
	public long getIdProgramador() {
		return id;
	}
	public void setIdProgramador(long idProgramador) {
		this.id = idProgramador;
	}
	public String getLgProgramador() {
		return lgProgramador;
	}
	public void setLgProgramador(String lgProgramador) {
		this.lgProgramador = lgProgramador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programador other = (Programador) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
