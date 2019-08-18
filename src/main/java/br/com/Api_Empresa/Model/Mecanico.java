package br.com.Api_Empresa.Model;

public class Mecanico extends Funcionario {

	private String st_mecanico;

	
	public String getSt_mecanico() {
		return st_mecanico;
	}
	public void setSt_mecanico(String st_mecanico) {
		this.st_mecanico = st_mecanico;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((st_mecanico == null) ? 0 : st_mecanico.hashCode());
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
		Mecanico other = (Mecanico) obj;
		if (st_mecanico == null) {
			if (other.st_mecanico != null)
				return false;
		} else if (!st_mecanico.equals(other.st_mecanico))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Mecanico [st_mecanico=" + st_mecanico + "]";
	}
	
}