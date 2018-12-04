<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Page Pesonnelle</title>
    <s:head/>
</head>
<body>
<br>
<div class="row d-flex">
    <div class="col-1"></div>
    <div class="col-10 text-center border border-info rounded">
            Nombre de livres disponibles : <s:property value="bookToRent.size"/>
    </div>
    <div class="col-1"></div>
</div>
<br>
<div class="row d-flex align-items-start">
    <div class="col-1"></div>
    <div class="col-2 border border-info rounded">
        <br>
        <s:iterator var="Book" value="shoppingList">
            <div class="container col-12 rounded">
                <div class="row">
                    <div class="container col-7 text-center">
                        <s:property value="bookName"/>
                    </div>
                    <div class="container col-2">
                        <s:a action="deleteToShop">
                            <img src="<%=request.getContextPath()%>/picture/Delete.png" height="30" width="30"/>
                            <s:param name="idBook"><s:property value="idBook"/></s:param>
                        </s:a>
                    </div>
                </div>
            </div>
            <br>
        </s:iterator>
        <s:if test="shoppingList.empty">
            <div class="col-12 text-center">
                <p>
                    Panier vide
                </p>
            </div>
        </s:if>
        <s:else>
            <div class="col-12 d-flex justify-content-center">
                <s:a action="rentTotal" cssClass="btn btn-primary center-block">Panier</s:a>
            </div>
            <br>
        </s:else>
    </div>
    <div class="col-1"></div>
    <div class="col-7 border border-info  rounded">
        <br>
        <s:iterator var="Book" value="bookToRent">
            <div class="container rounded">
                <div class="row">
                    <div class="container col-11 text-center">
                        <h1>
                            <s:property value="bookName"/>
                        </h1>
                        <p>
                            Autheur : <s:property value="author"/><br>
                            Editeur : <s:property value="editeurs"/><br>
                            Nombre de pages : <s:property value="nbPage"/><br>
                            disponnibilité : <s:property value="dispo"/><br>
                        </p>
                    </div>
                    <div class="col-1">
                        <s:a action="addToShop">
                            <img src="<%=request.getContextPath()%>/picture/ajouter.png" height="30" width="30"/>
                            <s:param name="idBook"><s:property value="id"/></s:param>
                        </s:a>
                    </div>
                </div>
            </div>
            <br>
        </s:iterator>
    </div>
    <div class="col-1"></div>
</div>
<br>
</body>
</html>
