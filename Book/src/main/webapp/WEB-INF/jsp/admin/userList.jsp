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

<h1 class="text-center">Liste des Utilisateurs :</h1>

<s:iterator var="User" value="userList">
    <div class="row">
        <div class="col-1"></div>
        <section class="py-1 col-10">
            <s:if test="#User.delete==false">
                <div class="container bg-secondary rounded">
                    <div class="row">
                        <div class="col-10">
                            <p>
                                User ID : <s:property value="userid"/><br>
                                Pseudo : <s:property value="pseudo"/><br>
                                Genre : <s:property value="gender"/><br>
                                Mail : <s:property value="mail"/><br>
                                Rôle : <s:property value="role"/>
                            </p>
                        </div>
                        <div class="col-1">
                            <s:a action="userUpInit">
                                <img src="../../../picture/Prolonger.png" height="30" width="30"/>
                                <s:param name="id"><s:property value="userid"/></s:param>
                            </s:a> <br>
                        </div>
                        <div class="col-1">
                            <s:a action="userDelete">
                                <img src="../../../picture/Delete.png" height="30" width="30"/>
                                <s:param name="id"><s:property value="userid"/></s:param>
                            </s:a> <br>
                        </div>
                    </div>
                </div>
            </s:if>
            <s:else>
                <div class="raw container bg-primary rounded">
                    <div class="row">
                        <div class="col-10">
                            <p>
                                User ID : <s:property value="userid"/><br>
                                Pseudo : <s:property value="pseudo"/><br>
                                Genre : <s:property value="gender"/><br>
                                Mail : <s:property value="mail"/><br>
                                Rôle : <s:property value="role"/>
                            </p>
                        </div>
                        <div class="col-1">
                            <s:a action="userUpInit">
                                <img src="../../../picture/Prolonger.png" height="30" width="30"/>
                                <s:param name="id"><s:property value="userid"/></s:param>
                            </s:a> <br>
                        </div>
                        <div class="col-1">
                            <s:a action="userActive">
                                <img src="../../../picture/ajouter.png" height="30" width="30"/>
                                <s:param name="id"><s:property value="userid"/></s:param>
                            </s:a> <br>
                        </div>
                    </div>
                </div>
            </s:else>
        </section>
        <div class="col-1"></div>
    </div>
</s:iterator>
</body>
</html>
	