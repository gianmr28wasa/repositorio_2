package Clases;

public class Marca {
	public Marca(int cod_mar, String nom_mar) {
		super();
		this.cod_mar = cod_mar;
		this.nom_mar = nom_mar;
	}

	
	public int getCod_mar() {
		return cod_mar;
	}
	public void setCod_mar(int cod_mar) {
		this.cod_mar = cod_mar;
	}
	public String getNom_mar() {
		return nom_mar;
	}
		
	private int cod_mar;
	private String nom_mar;
}
