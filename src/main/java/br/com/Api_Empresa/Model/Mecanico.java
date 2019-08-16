package br.com.Api_Empresa.Model;

public class Mecanico extends Funcionario {

	private long id;
	private String stFuncionario;
	

	public String getStFuncionario() {
		return stFuncionario;
	}

	public void setStFuncionario(String stFuncionario) {
		this.stFuncionario = stFuncionario;
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
		Mecanico other = (Mecanico) obj;
		if (id != other.id)
			return false;
		return true;
	}
		
}
