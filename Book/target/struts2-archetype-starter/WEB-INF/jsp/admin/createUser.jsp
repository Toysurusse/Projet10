<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>MAJ compte User</title>
    <s:head />
</head>
<body>
<div>
    <div class="starter-template col-sm-4"></div>
    <div class="container-fluid col-sm-4">
        <s:form theme="simple" action="userCreate">
            <div class="row">
                <label for="user.pseudo" class="starter-template col-sm-12"> Pseudo :</label>
                <s:textfield cssClass="form-control" placeholder="Login" name="user.pseudo" label="pseudo"
                             requiredLabel="true"/>
            </div>
            <div class="row">
                <label for="user.password" class="starter-template col-sm-12"> Mot de passe :</label>
                <s:password cssClass="form-control" placeholder="Password" name="user.password" label="password"
                            requiredLabel="true"/>
            </div>
            <div class="row">
                <label for="user.mail" class="starter-template col-sm-12"> Pseudo :</label>
                <s:textfield cssClass="form-control" placeholder="Mail" name="user.mail" label="mail"
                             requiredLabel="true"/>
            </div>
            <div class="row">
                <label for="user.gender" class="starter-template col-sm-12"> Genre :</label>
            <s:select label="Sexe"
                      headerKey="%{user.gender}" headerValue="%{user.gender}"
                      list="{'Homme', 'Femme'}"
                      name="user.gender"
                      value="0" requiredLabel="true" cssClass="form-control"/>
            </div>
            <div class="row">
                <label for="user.role" class="starter-template col-sm-12"> Role :</label>
                <s:textfield cssClass="form-control" placeholder="Role" name="user.role" label="role"
                             requiredLabel="true"/>
            </div>
            <br>
            <div class="row">
                <div class="col-12 d-flex justify-content-center">
            <s:submit method="userCreate" value="Valider" cssClass="btn btn-primary center-block"/>
                </div>
            </div>
            <br>
        </s:form>
        <div class="starter-template"><s:actionerror/></div>
    </div>
    <div class="starter-template col-sm-4"></div>
</div>
</body>
</html>
