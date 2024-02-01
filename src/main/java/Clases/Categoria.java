package Clases;

public class Categoria {
	public Categoria(int cod_cat, String nom_cat) {
		super();
		this.cod_cat = cod_cat;
		this.nom_cat = nom_cat;
	}
	public int getCod_cat() {
		return cod_cat;
	}
	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}
	public String getNom_cat() {
		return nom_cat;
	}
	public void setNom_cat(String nom_cat) {
		this.nom_cat = nom_cat;
	}
	private int cod_cat;
	private String nom_cat;
}
