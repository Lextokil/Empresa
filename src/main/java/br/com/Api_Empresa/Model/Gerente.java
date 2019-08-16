package br.com.Api_Empresa.Model;

public class Gerente extends Funcionario{
	
	private String pwGerente;

	public String getPwGerente() {
		return pwGerente;
	}

	public void setPwGerente(String pwGerente) {
		this.pwGerente = pwGerente;
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
		Gerente other = (Grt) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
