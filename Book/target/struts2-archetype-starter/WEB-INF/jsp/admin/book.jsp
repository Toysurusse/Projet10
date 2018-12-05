<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Gestion livres</title>
    <s:head/>
</head>
<body>
<br>
<div class="row">
    <div class="col-1"></div>
    <div class="container-fluid border-info rounded col-3">
        <div class="text-lg-center">
            Ajouter un livre :
        </div>
        <s:form theme="simple" action="createBook">
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
                <s:textfield cssClass="form-control" placeholder="Nombre d'exemplaires" name="book.dispo" label="pseudo"
                             requiredLabel="true"/>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-12 d-flex justify-content-center">
                    <s:submit method="createBook" value="créer livre" cssClass="btn btn-primary center-block"/>
                </div>
            </div>
            <br>
        </s:form>
        <div class="starter-template"><s:actionerror/></div>
    </div>
    <div class="col-1"></div>
    <div class="border border-info rounded col-6">
        <br>
        <s:iterator var="Book" value="bookList">
            <div class="row">
                <div class="col-1"></div>
                <div class="row col-10 container rounded">
                    <div class="col-10">
                        <h1>
                            <s:property value="id"/> : <s:property value="bookName"/>
                        </h1>
                        <p>
                            Autheur : <s:property value="author"/>
                            Editeur : <s:property value="editeurs"/>
                            Nombre de pages : <s:property value="nbPage"/>
                            disponnibilité : <s:property value="dispo"/>
                        </p>
                    </div>
                    <div class="col-1">
                        <s:a action="bookUpdateInit">
                            <img src="<%=request.getContextPath()%>/picture/Prolonger.png" height="30" width="30"/>
                            <s:param name="idBook"><s:property value="id"/></s:param>
                        </s:a> <br>
                    </div>
                    <div class="col-1">
                        <s:a action="bookDelete">
                            <img src="<%=request.getContextPath()%>/picture/Delete.png" height="30" width="30"/>
                            <s:param name="idBook"><s:property value="id"/></s:param>
                        </s:a>
                    </div>
                </div>
                <div class="col-1"></div>
            </div>
            <br>
        </s:iterator>

    </div>
    <div class="col-1"></div>
    <br>
</div>
</body>
</html>
	