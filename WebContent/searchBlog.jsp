<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.epsi.jeeProject.beans.Blog" %>
<%@ page import="fr.epsi.jeeProject.beans.Utilisateur" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Chercher les blogs d'un utilisateur</h2>
	<form method="POST" action="searchBlog">
		Nom : <input type="text" name="email"/>
		<input type="submit" value="Chercher"/>
	</form>
	<%
		Utilisateur utilisateur = (Utilisateur)request.getAttribute("utilisateur");
		if(utilisateur == null) {
			out.println("Aucun blog trouvé");
		} else {
			out.println("<h2>Blogs trouvés pour " + utilisateur.getNom());
			List<Blog> blogs = (List)request.getAttribute("blogs");
			for(Blog b : blogs) {
				out.println("<h3>" + b.getTitre() + "</h3>");
				out.println("<strong>Description</strong> : " + b.getDescription());
				out.println("<strong>Date creation</strong> : " + b.getDateCreation());
			}
		}
	%>
</body>
</html>