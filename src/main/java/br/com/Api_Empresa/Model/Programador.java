package br.com.Api_Empresa.Model;

public class Programador extends Funcionario {

	private String lg_programador;

	
	public String getLg_programador() {
		return lg_programador;
	}
	public void setLg_programador(String lg_programador) {
		this.lg_programador = lg_programador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((lg_programador == null) ? 0 : lg_programador.hashCode());
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
		if (lg_programador == null) {
			if (other.lg_programador != null)
				return false;
		} else if (!lg_programador.equals(other.lg_programador))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Programador [lg_programador=" + lg_programador + "]";
	}

}