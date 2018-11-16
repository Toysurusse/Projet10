<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>MAJ livres</title>
	<s:head />
</head>
<body>

<div>
	<div class="starter-template col-sm-4"></div>
	<div class="container-fluid col-sm-4">
		<s:form theme="simple" action="bookUpdate">
			<div class="row">
				<label for="book.id" class="starter-template col-sm-12"> ID du livre :</label>
				<s:textfield cssClass="form-control" placeholder="Titre" name="book.id" label="ID"
							 requiredLabel="true" readonly="true"/>
			</div>
			<div class="row">
				<label for="book.bookName" class="starter-template col-sm-12"> Titre :</label>
				<s:textfield cssClass="form-control" placeholder="Titre" name="book.bookName" label="pseudo"
							 requiredLabel="true"/>
			</div>
			<div class="row">
				<label for="book.author" class="starter-template col-sm-12"> Auteur :</label>
				<s:textfield cssClass="form-control" placeholder="Author" name="book.author" label="password"
							requiredLabel="true"/>
			</div>
			<div class="row">
				<label for="book.editeurs" class="starter-template col-sm-12"> Editeurs :</label>
				<s:textfield cssClass="form-control" placeholder="Editeurs" name="book.editeurs" label="pseudo"
							 requiredLabel="true"/>
			</div>
			<div class="row">
				<label for="book.nbPage" class="starter-template col-sm-12"> Nombre de pages :</label>
				<s:textfield cssClass="form-control" placeholder="Nombre de page" name="book.nbPage" label="pseudo"
							 requiredLabel="true"/>
			</div>
			<div class="row">
				<label for="book.dispo" class="starter-template col-sm-12"> Nombre d'exemplaires :</label>
				<s:textfield cssClass="form-control" placeholder="Nombre d'exemplaires" name="book.dispo" label="dispo"
							 requiredLabel="true"/>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<s:submit method="bookUpdate" value="créer livre" cssClass="btn btn-primary center-block"/>
				</div>
			</div>
		</s:form>
		<div class="starter-template"><s:actionerror/></div>
	</div>
	<div class="starter-template"></div>
</div>
</body>
</html>
	