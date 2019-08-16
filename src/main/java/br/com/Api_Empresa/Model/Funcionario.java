package br.com.Api_Empresa.Model;

public class Funcionario {
	
	private long idFuncionario;
	private String nmFuncionario;
	private double tpFuncionario;
	
	
	
	
	
	

	
	public long getId_funcionario() {
		return idFuncionario;
	}

	public void setId_funcionario(long id_funcionario) {
		this.idFuncionario = id_funcionario;
	}

	public String getNm_funcionario() {
		return nmFuncionario;
	}

	public void setNm_funcionario(String nm_funcionario) {
		this.nmFuncionario = nm_funcionario;
	}

	public double getSl_funcionario() {
		return tpFuncionario;
	}

	public void setSl_funcionario(double sl_funcionario) {
		this.tpFuncionario = sl_funcionario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFuncionario ^ (idFuncionario >>> 32));
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
		Funcionario other = (Funcionario) obj;
		if (idFuncionario != other.idFuncionario)
			return false;
		return true;
	}
	
}
