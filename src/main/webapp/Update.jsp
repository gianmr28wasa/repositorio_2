<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,Clases.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
<form class="row g-3"  name="form" method="get" action="Servlet">
<input type="hidden" name="instruccion" value="actualizarBBDD">
<input type="hidden" name="cod_pro" value="${Producto.cod_pro}">
  <div class="col-4">
  <% Producto producto = (Producto) request.getAttribute("Producto"); %>
    <label class="form-label">Codigo Producto</label>
    <input type="text" class="form-control" id="cod_pro" name="cod_pro" value="${Producto.cod_pro}" disabled>
  </div>
  <div class="col-4">
    <label class="form-label">Nombre Producto</label>
    <input type="text" class="form-control"  id="nom_pro" name="nom_pro" value="${Producto.nom_pro}">
  </div>
    <div class="col-4">
    <label class="form-label">Precio Producto</label>
    <input type="text" class="form-control"  id="pre_pro" name="pre_pro" value="${Producto.pre_pro}">
  </div>
  <div class="col-md-4">
    <label class="form-label">Marca Producto</label>
    <%  List<Marca> LasMarcas = new ModeloProducto().getMarca(); %>
    <select class="form-select"  id="cod_mar" name="cod_mar">
      <% for (Marca tempMar:LasMarcas){%>
            <option <% if (producto.getCod_mar() == tempMar.getCod_mar()) { %>selected<% } %>>
    		<%= tempMar.getNom_mar() %>
</option>
      <%}%>
    </select>
  </div>
   <div class="col-md-4">
    <label class="form-label">Categoria Producto</label>
     <%  List<Categoria> LasCategorias = new ModeloProducto().getCategoria(); %>
    <select class="form-select"  id="cod_cat" name="cod_cat">
      <% for (Categoria tempCat:LasCategorias){%>
                <option <% if (producto.getCod_cat() == tempCat.getCod_cat()) { %>selected<% } %>>
    		<%= tempCat.getNom_cat() %>
       <%}%>
    </select>
  </div>
  <div class="col-12">
    <button type="submit" name="envio" id="envio" class="btn btn-primary">Actualizar</button>
    <button class="btn btn-primary" type="reset" name="borrar" id="borrar">Restablecer</button>
  </div>
</form>
<div class="container mt-4">
<form action="Servlet" method="get">
	<button type="submit" class="btn btn-danger">Regresar</button>
</form>
</div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>