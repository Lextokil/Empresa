package br.com.Api_Empresa.Model;

public class Mecanico extends Funcionario {

	private long id_mecanico;
	private String st_mecanico;
	
	
	
	public long getId_mecanico() {
		return id_mecanico;
	}
	public void setId_mecanico(long id_mecanico) {
		this.id_mecanico = id_mecanico;
	}
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
		result = prime * result + (int) (id_mecanico ^ (id_mecanico >>> 32));
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
		if (id_mecanico != other.id_mecanico)
			return false;
		if (st_mecanico == null) {
			if (other.st_mecanico != null)
				return false;
		} else if (!st_mecanico.equals(other.st_mecanico))
			return false;
		return true;
	}
	
}
