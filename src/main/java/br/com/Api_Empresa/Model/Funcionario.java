package br.com.Api_Empresa.Model;

public class Funcionario {
	
	private long id;
	private String nm_funcionario;
	private double sl_funcionario;
	
	
	
	
	
	

	
	public long getId_funcionario() {
		return id;
	}

	public void setId_funcionario(long id_funcionario) {
		this.id = id_funcionario;
	}

	public String getNm_funcionario() {
		return nm_funcionario;
	}

	public void setNm_funcionario(String nm_funcionario) {
		this.nm_funcionario = nm_funcionario;
	}

	public double getSl_funcionario() {
		return sl_funcionario;
	}

	public void setSl_funcionario(double sl_funcionario) {
		this.sl_funcionario = sl_funcionario;
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
		Funcionario other = (Funcionario) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
