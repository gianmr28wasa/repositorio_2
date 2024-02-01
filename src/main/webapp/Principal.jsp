<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,Clases.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<body>
<%List<Producto> losProductos = (List<Producto>)request.getAttribute("ListadoProductos"); %>
<table class="table caption-top">
  <caption>Listado</caption>
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Precio</th>
      <th scope="col">Marca</th>
	  <th scope="col">Categoria</th>
	  <th scope="col"><center>ACCIONES</center></th>
    </tr>
  </thead>
  <tbody>
  	<% for(Producto tempPro:losProductos){ %>
    <tr>
      <th scope="row"><%= tempPro.getCod_pro()%></th>
      <td><%= tempPro.getNom_pro()%></td>
      <td>S/.<%= tempPro.getPre_pro()%></td>
      <td><%= tempPro.getNom_mar2(tempPro.getCod_mar())%></td>
      <td><%= tempPro.getNom_cat2(tempPro.getCod_cat()) %></td>
      <td><a href="Servlet?instruccion=cargar&cod_pro=<%=tempPro.getCod_pro()%>">Actualizar</a></td>
      <td><a href="Servlet?instruccion=eliminar&cod_pro=<%=tempPro.getCod_pro()%>">Eliminar</a></td>
    </tr>
    <%} %>
  </tbody>
</table>
<div class="container">
	<button type="button" class="btn btn-success" value="Create" onclick="window.location.href='Create.jsp'">Crear Producto</button>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</html>