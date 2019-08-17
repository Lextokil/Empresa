package br.com.Api_Empresa.Model;

public class Gerente extends Funcionario{
	
	private String pw_gerente;

	
	public String getPw_gerente() {
		return pw_gerente;
	}
	public void setPw_gerente(String pw_gerente) {
		this.pw_gerente = pw_gerente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pw_gerente == null) ? 0 : pw_gerente.hashCode());
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
		Gerente other = (Gerente) obj;
		if (pw_gerente == null) {
			if (other.pw_gerente != null)
				return false;
		} else if (!pw_gerente.equals(other.pw_gerente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gerente [pw_gerente=" + pw_gerente + "]";
	}
	
	
}