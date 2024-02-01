package Clases;

public class Producto {
	public int getCod_pro() {
		return cod_pro;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public int getPre_pro() {
		return pre_pro;
	}

	public void setPre_pro(int pre_pro) {
		this.pre_pro = pre_pro;
	}

	public int getCod_mar() {
		return cod_mar;
	}

	public void setCod_mar(int cod_mar) {
		this.cod_mar = cod_mar;
	}

	public int getCod_cat() {
		return cod_cat;
	}

	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}

	public String getNom_pro() {
		return nom_pro;
	}

	public void setNom_pro(String nom_pro) {
		this.nom_pro = nom_pro;
	}

	private int cod_pro, pre_pro, cod_mar, cod_cat;
	private String nom_pro;

	public Producto(int cod_pro, int pre_pro, int cod_mar, int cod_cat, String nom_pro) {
		super();
		this.cod_pro = cod_pro;
		this.pre_pro = pre_pro;
		this.cod_mar = cod_mar;
		this.cod_cat = cod_cat;
		this.nom_pro = nom_pro;
	}

	private ModeloProducto modeloProducto=new ModeloProducto();
	
	public String getNom_mar2(int cod_mar) {
		return modeloProducto.getUnaMarcaNombre(cod_mar);
	}
	public String getNom_cat2(int cod_cat) {
		return modeloProducto.getUnaCategoriaNombre(cod_cat);
	}
}
