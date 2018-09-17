<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Accueil</title>
    <s:head/>
</head>
<body>

<h1 class="text-center">Liste des livres disponibles :</h1>

<s:iterator var="Book" value="bookList">
    <div class="row">
        <div class="col-1"></div>
        <section class="py-1 col-10">
            <div class="container rounded text-lg-center">
                <h1>
                    <s:property value="bookName"/>
                </h1>
                <p>
                    Autheur : <s:property value="author"/><br>
                    Editeur : <s:property value="editeurs"/><br>
                    Nombre de pages : <s:property value="nbPage"/><br>
                    disponibilité : <s:if test="%{Book.dispo}">Non</s:if>
                    <s:else>Oui</s:else>
                </p>
            </div>
        </section>
        <div class="col-1"></div>
    </div>
</s:iterator>
</body>
</html>
	