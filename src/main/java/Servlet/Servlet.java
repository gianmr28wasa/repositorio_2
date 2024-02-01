package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import Clases.Producto;
import Clases.Marca;
import Clases.ModeloProducto;


public class Servlet extends HttpServlet {
	private ModeloProducto modeloProducto;
	private static final long serialVersionUID = 1L;
    public Servlet() throws ServletException {
        super();
        try {
        	modeloProducto=new ModeloProducto();
        }catch(Exception e) {
        	throw new ServletException(e);
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Comando=request.getParameter("instruccion");
		if(Comando==null) Comando="listar";
		switch(Comando) {
		case "listar":
			try {
				obtenerProducto(request,response);}catch(Exception e) {e.printStackTrace();}
			break;
		case "insertarBBDD":
			try {agregarProducto(request, response);}catch(Exception e) {e.printStackTrace();}
			break;
		case "cargar":
			try {cargarProducto (request,response);}catch(Exception e) {e.printStackTrace();}break;
		case "actualizarBBDD":
			try {actualizarProducto (request,response);}catch(Exception e) {
				e.printStackTrace();
			}break;
		case "eliminar":try {eliminarProducto(request,response);
			}catch(Exception e) {
				e.printStackTrace();}break;
		default:try {
			obtenerProducto(request,response);}catch(Exception e) {
				e.printStackTrace();}
			}
	}
	
	private void obtenerProducto (HttpServletRequest request, HttpServletResponse response)throws Exception{
		List<Producto> Productos;
		try {
			Productos=modeloProducto.getProductos();
			request.setAttribute("ListadoProductos", Productos);
			RequestDispatcher miDispatcher=request.getRequestDispatcher("/Principal.jsp");
			miDispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void agregarProducto (HttpServletRequest request, HttpServletResponse response)throws Exception{
		int cod_pro=Integer.parseInt(request.getParameter("cod_pro"));
		String nom_pro=request.getParameter("nom_pro");
		int pre_pro=Integer.parseInt(request.getParameter("pre_pro"));
		int cod_mar=modeloProducto.getUnaMarca(request.getParameter("cod_mar"));
		int cod_cat=modeloProducto.getUnaCategoria(request.getParameter("cod_cat"));	
			Producto nuevo=new Producto(cod_pro,pre_pro,cod_mar,cod_cat,nom_pro);
			try {modeloProducto.agregarProducto(nuevo);
			}catch(Exception e) {
				e.printStackTrace();
			}
			obtenerProducto(request,response);	
		}
	private void actualizarProducto (HttpServletRequest request, HttpServletResponse response)throws Exception{
		int cod_pro=Integer.parseInt(request.getParameter("cod_pro"));
		String nom_pro=request.getParameter("nom_pro");
		int pre_pro=Integer.parseInt(request.getParameter("pre_pro"));
		int cod_mar=modeloProducto.getUnaMarca(request.getParameter("cod_mar"));
		int cod_cat=modeloProducto.getUnaCategoria(request.getParameter("cod_cat"));
		Producto actualizado=new Producto(cod_pro,pre_pro,cod_mar,cod_cat,nom_pro);
		System.out.print(cod_pro+" "+nom_pro+" "+pre_pro+" "+cod_mar+" "+cod_cat);
		modeloProducto.actualizarProducto(actualizado);	
		obtenerProducto(request,response);	
	}

	private void cargarProducto (HttpServletRequest request, HttpServletResponse response)throws Exception{
		int cod_pro=Integer.parseInt(request.getParameter("cod_pro"));
		Producto elProducto = modeloProducto.getUnProducto(cod_pro);	
		request.setAttribute("Producto", elProducto);	
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Update.jsp");
		dispatcher.forward(request, response);
	}
	
	private void eliminarProducto (HttpServletRequest request, HttpServletResponse response)throws Exception{
		int cod_pro=Integer.parseInt(request.getParameter("cod_pro"));
		modeloProducto.eliminarProducto(cod_pro);
		obtenerProducto(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	public void prueba() {
		
	}
}
