<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>New account</title>
    <s:head/>
</head>
<body>
<div>
    <div class="starter-template col-sm-4"></div>
    <div class="container-fluid col-sm-4">
        <s:form theme="simple" action="createAccount">
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
                <s:textfield cssClass="form-control" placeholder="Mail" name="user.mail" label="pseudo"
                             requiredLabel="true"/>
            </div>
            <div class="row">
                <label for="user.gender" class="starter-template col-sm-12"> Genre :</label>
                <s:select label="Sexe"
                          headerKey="%{user.sex}" headerValue="%{user.sex}"
                          list="{'Homme', 'Femme'}"
                          name="user.gender"
                          value="0" requiredLabel="true" cssClass="form-control"/>
            </div>
            <br>
            <div class="col-12 d-flex justify-content-center">
                <s:submit method="createAccount" value="Créer" cssClass="btn btn-primary center-block"/>
            </div>
        </s:form>
        <div class="starter-template"><s:actionerror/></div>
    </div>
    <div class="starter-template col-sm-4"></div>
</div>
</body>
</html>
