<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Accueil</title>
	<s:head />
</head>
<body>
<s:iterator var="Book" value="bookList">
	<section class="py-5">
		<div class="container">
			<h1>
				<s:property value="id" /> : <s:property value="bookName" />
			</h1>
			<p>
				Autheur : <s:property value="author" />
				Editeur : <s:property value="editeurs" />
				Nombre de pages : <s:property value="nbPage" />
				disponnibilité : <s:property value="dispo" />
			</p>
		</div>
	</section>
</s:iterator>
</body>
</html>
	