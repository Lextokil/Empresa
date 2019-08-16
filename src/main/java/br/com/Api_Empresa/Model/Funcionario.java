package br.com.Api_Empresa.Model;

public class Funcionario {
	
	private long id_funcionario;
	private String nm_funcionario;
	private double sl_funcionario;
	
	public long getId_funcionario() {
		return id_funcionario;
	}
	public void setId_funcionario(long id_funcionario) {
		this.id_funcionario = id_funcionario;
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
		result = prime * result + (int) (id_funcionario ^ (id_funcionario >>> 32));
		result = prime * result + ((nm_funcionario == null) ? 0 : nm_funcionario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(sl_funcionario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (id_funcionario != other.id_funcionario)
			return false;
		if (nm_funcionario == null) {
			if (other.nm_funcionario != null)
				return false;
		} else if (!nm_funcionario.equals(other.nm_funcionario))
			return false;
		if (Double.doubleToLongBits(sl_funcionario) != Double.doubleToLongBits(other.sl_funcionario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Funcionario [id_funcionario=" + id_funcionario + ", nm_funcionario=" + nm_funcionario
				+ ", sl_funcionario=" + sl_funcionario + "]";
	}

	
	
}
