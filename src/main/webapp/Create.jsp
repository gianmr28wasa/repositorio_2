<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Clases.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-4">
<form class="row g-3"  name="form" method="get" action="Servlet">
<input type="hidden" name="instruccion" value="insertarBBDD">
  <div class="col-4">
    <label class="form-label">Codigo Producto</label>
    <input type="text" class="form-control" id="cod_pro" name="cod_pro">
  </div>
  <div class="col-4">
    <label class="form-label">Nombre Producto</label>
    <input type="text" class="form-control"  id="nom_pro" name="nom_pro">
  </div>
    <div class="col-4">
    <label class="form-label">Precio Producto</label>
    <input type="text" class="form-control"  id="pre_pro" name="pre_pro">
  </div>
  <div class="col-md-4">
    <label class="form-label">Marca Producto</label>
    <select class="form-select"  id="cod_mar" name="cod_mar">
      <%  List<Marca> LasMarcas = new ModeloProducto().getMarca(); %>
      <% for (Marca tempMar:LasMarcas){%>
      <option><%= tempMar.getNom_mar() %></option>
      <%}%>
    </select>
  </div>
   <div class="col-md-4">
    <label class="form-label">Categoria Producto</label>
    <select class="form-select"  id="cod_cat" name="cod_cat">
      <%  List<Categoria> LasCategorias = new ModeloProducto().getCategoria(); %>
      <% for (Categoria tempCat:LasCategorias){%>
      <option><%= tempCat.getNom_cat() %></option>
       <%}%>
    </select>
  </div>
  <div class="col-12">
    <button type="submit" name="envio" id="envio" class="btn btn-primary">Crear</button>
    <button class="btn btn-primary" type="reset" name="borrar" id="borrar">Restablecer</button>
  </div>
</form>
</div>
<div class="container mt-4">
<form action="Servlet" method="get">
	<button type="submit" class="btn btn-danger">Regresar</button>
</form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>