<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Se Connecter</title>
	<s:head />
</head>
<body>
<div>
	<div class="starter-template col-sm-4"></div>
	<div class="container-fluid col-sm-4">
		<s:form theme="simple" action="connectTry">
			<div class="row">
				<label for="pseudo" class="starter-template col-sm-12"> Pseudo :</label>
				<s:textfield cssClass="form-control" placeholder="Login" name="pseudo" label="pseudo"
							 requiredLabel="true"/>
			</div>
			<div class="row">
				<label for="password" class="starter-template col-sm-12"> Mot de passe :</label>
				<s:password cssClass="form-control" placeholder="Password" name="password" label="password"
							requiredLabel="true"/>
			</div>
			</br>
			<div class="row">
				<div class="col-sm-6">
					<s:submit method="input" value="Se Connecter" cssClass="btn btn-primary center-block"/>
				</div>
				<div class="col-sm-6">
					<s:a action="loadaccount" cssClass="btn btn-primary center-block">Créer un compte ?</s:a>
				</div>
			</div>

		</s:form>
		<div class="starter-template"><s:actionerror/></div>
	</div>
	<div class="starter-template col-sm-4"></div>
</div>
</body>
</html>
