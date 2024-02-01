package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;

public class ModeloProducto {
	
	public List<Producto> getProductos() throws Exception{
		List<Producto> Producto = new ArrayList<>();	
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		miConexion=MySQLConexion.getConexion();
		String sql="SELECT * FROM Producto_Portillo";
		miStatement=miConexion.createStatement();
		
		miResultSet=miStatement.executeQuery(sql);
		while(miResultSet.next()) {
			int cod_pro=miResultSet.getInt("cod_pro");
			String nom_pro=miResultSet.getString("nom_pro");
			int pre_pro=miResultSet.getInt("pre_pro");
			int cod_mar=miResultSet.getInt("cod_mar");
			int cod_cat=miResultSet.getInt("cod_cat");
			
			Producto temp=new Producto(cod_pro,pre_pro,cod_mar,cod_cat,nom_pro);
			Producto.add(temp);
		}
		return Producto;
	}
	public List<Marca> getMarca() throws Exception{
		List<Marca> Marca = new ArrayList<>();	
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		miConexion=MySQLConexion.getConexion();
		String sql="SELECT * FROM Marca_Portillo";
		miStatement=miConexion.createStatement();
		
		miResultSet=miStatement.executeQuery(sql);
		while(miResultSet.next()) {
			int cod_mar=miResultSet.getInt("cod_mar");
			String nom_mar=miResultSet.getString("nom_mar");
			
			Marca temp=new Marca(cod_mar, nom_mar);
			Marca.add(temp);
		}
		return Marca;
	}
	
	public List<Categoria> getCategoria() throws Exception{
		List<Categoria> Categorias = new ArrayList<>();	
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet miResultSet=null;
		miConexion=MySQLConexion.getConexion();
		String sql="SELECT * FROM Categoria_Portillo";
		miStatement=miConexion.createStatement();
		
		miResultSet=miStatement.executeQuery(sql);
		while(miResultSet.next()) {
			int cod_cat=miResultSet.getInt("cod_cat");
			String nom_cat=miResultSet.getString("nom_cat");
			
			Categoria temp=new Categoria(cod_cat, nom_cat);
			Categorias.add(temp);
		}
		return Categorias;
	}
	
	public void eliminarProducto(int cod) throws Exception {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="DELETE FROM Producto_Portillo WHERE cod_pro=?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setInt(1, cod);
			miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
	
	public void agregarProducto(Producto Nuevo) throws Exception{
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="INSERT INTO Producto_Portillo (cod_pro,nom_pro,pre_pro,cod_mar,cod_cat) VALUES (?,?,?,?,?)";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setInt(1, Nuevo.getCod_pro());
			miStatement.setString(2, Nuevo.getNom_pro());
			miStatement.setInt(3, Nuevo.getPre_pro());
			miStatement.setInt(4, Nuevo.getCod_mar());
			miStatement.setInt(5, Nuevo.getCod_cat());	
			miStatement.execute();
		}catch(Exception e) {}
		finally {
			miStatement.close();
			miConexion.close();
			}
		}
	
	public Producto getUnProducto(int codigo) {
		Producto producto=null;
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultSet=null;
		int cod=codigo;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="SELECT * FROM Producto_Portillo WHERE cod_pro = ?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setInt(1, cod);
			miResultSet=miStatement.executeQuery();
			if(miResultSet.next()) {
				int cod_pro=miResultSet.getInt("cod_pro");
				String nom_pro=miResultSet.getString("nom_pro");
				int pre_pro=miResultSet.getInt("pre_pro");
				int cod_mar=miResultSet.getInt("cod_mar");
				int cod_cat=miResultSet.getInt("cod_cat");
				producto=new Producto(cod_pro,pre_pro,cod_mar,cod_cat,nom_pro);
			}
			else {throw new Exception("No encontramos ningun producto con el codigo = " + codigo);}
		}catch(Exception e) {}
		return producto;
		}
	
	public int getUnaMarca(String nombre) {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultSet=null;
		String nom_mar=nombre;
		int cod_mar=0;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="SELECT cod_mar FROM Marca_Portillo WHERE nom_mar = ?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setString(1, nom_mar);
			miResultSet=miStatement.executeQuery();
	        if (miResultSet.next()) {
	            cod_mar = miResultSet.getInt("cod_mar");

			}
			else {throw new Exception("No encontramos ninguna marca con el nombre = " + nom_mar);}
		}catch(Exception e) { e.printStackTrace();}
		return cod_mar;
		}
	public int getUnaCategoria(String nombre) {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultSet=null;
		String nom_cat=nombre;
		int cod_cat=0;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="SELECT cod_cat FROM Categoria_Portillo WHERE nom_cat = ?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setString(1, nom_cat);
			miResultSet=miStatement.executeQuery();
	        if (miResultSet.next()) {
	            cod_cat = miResultSet.getInt("cod_cat");
			}
			else {throw new Exception("No encontramos ninguna categoria con el nombre = " + nom_cat);}
		}catch(Exception e) { e.printStackTrace();}
		return cod_cat;
		}
	
	public String getUnaCategoriaNombre(int codigo) {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultSet=null;
		int cod_cat=codigo;
		String nom_cat="";
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="SELECT nom_cat FROM Categoria_Portillo WHERE cod_cat = ?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setInt(1, cod_cat);
			miResultSet=miStatement.executeQuery();
	        if (miResultSet.next()) {
	            nom_cat = miResultSet.getString("nom_cat");
			}
			else {throw new Exception("No encontramos ninguna categoria con el codigo = " + cod_cat);}
		}catch(Exception e) { e.printStackTrace();}
		return nom_cat;
		}
	
	public String getUnaMarcaNombre(int codigo) {
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		ResultSet miResultSet=null;
		int cod_mar=codigo;
		String nom_mar="";
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="SELECT nom_mar FROM Marca_Portillo WHERE cod_mar = ?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setInt(1, cod_mar);
			miResultSet=miStatement.executeQuery();
	        if (miResultSet.next()) {
	            nom_mar = miResultSet.getString("nom_mar");
			}
			else {throw new Exception("No encontramos ninguna marca con el codigo = " + cod_mar);}
		}catch(Exception e) { e.printStackTrace();}
		return nom_mar;
		}
	
	public void actualizarProducto (Producto producto) throws Exception{
		Connection miConexion=null;
		PreparedStatement miStatement=null;
		try {
			miConexion=MySQLConexion.getConexion();
			String sql="UPDATE Producto_Portillo SET nom_pro=?, pre_pro=?, cod_mar=?, cod_cat=? WHERE cod_pro=?";
			miStatement=miConexion.prepareStatement(sql);
			miStatement.setString(1, producto.getNom_pro());
			miStatement.setInt(2, producto.getPre_pro());
			miStatement.setInt(3, producto.getCod_mar());
			miStatement.setInt(4, producto.getCod_cat());
			miStatement.setInt(5, producto.getCod_pro());
			miStatement.execute();
		}finally {
			miStatement.close();
			miConexion.close();
		}
	}
	

}
