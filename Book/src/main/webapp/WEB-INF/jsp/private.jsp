<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Page Pesonnelle</title>
    <s:head />
</head>
<body>

<s:iterator var="Book" value="bookList">
    <div class="row">
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
        <div>
            <s:a action="addToShop">
                <img src="../picture/Delete.JPG" height="10" width="10"/>
                <s:param name="idBook"><s:property value="id"/></s:param>
            </s:a>
        </div>
    </div>
</s:iterator>

</body>
</html>
