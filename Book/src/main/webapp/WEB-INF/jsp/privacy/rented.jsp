<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Etat des prêts</title>

    <s:head/>
</head>
<body>

<s:if test="listrented.empty">
    <div class="text-lg-center">
        Vous n'avez jamais loué de livre
    </div>
</s:if>
<s:else>
    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 border border-info rounded">
            <div class="col-12 text-center">
                Liste des livres loués rentdus :
            </div>
            <br>
            <s:iterator var="BookAndRent" value="listrented">
                <s:if test="#BookAndRent.returnbook==true">
                    <div class="row">
                        <div class="col-1"></div>
                        <div class="container col-10 rounded">
                            <div class="row">
                                <div class="col-3 ">
                                    Livre : <s:property value="bookName"/> <br>
                                    Ecrit par : <s:property value="author"/> <br>
                                </div>
                                <div class="col-6">
                                    <p>
                                        Date de location : <s:date name="#BookAndRent.createat"
                                                                   format="dd/MM/yyyy"/><br>
                                        Date de retour : <s:date name="%{#BookAndRent.endat}" format="dd/MM/yyyy"/><br>
                                        Prolonger : <s:property value="reload"/>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-1"></div>
                    </div>
                    <br>
                </s:if>
            </s:iterator>
        </div>
        <div class="col-1"></div>
    </div>

    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 border border-info rounded">
            <div class="col-12 text-center">
                Liste des livres loués à rendre :
            </div>

            <s:iterator var="BookAndRent" value="listrented">
                <s:if test="#BookAndRent.returnbook==false">
                    <br>
                    <div class="row">
                        <div class="col-sm-1"></div>
                        <div class="container col-10 rounded">
                            <div class="row">
                                <div class="col-sm-3">
                                    Livre : <s:property value="bookName"/> <br>
                                    Ecrit par : <s:property value="author"/> <br>
                                </div>
                                <div class="col-sm-5">
                                    <p>
                                        Date de location : <s:date name="#BookAndRent.createat"
                                                                   format="dd/MM/yyyy"/><br>
                                        Date de retour : <s:date name="#BookAndRent.endat" format="dd/MM/yyyy"/><br>
                                        <s:if test="%{#BookAndRent.endat.before(today)}">
                                    </p>
                                    <div class="text-danger font-weight-bold">
                                        Livre en retard
                                    </div>
                                    <p>
                                        </s:if>

                                    </p>
                                </div>
                                <div class="col-2">
                                    <s:if test="%{reload}">
                                        <div class="text-danger font-weight-bold">
                                            Déjà Prolongé
                                        </div>
                                    </s:if>
                                    <s:else>
                                        <s:a action="reloadbookInit">
                                            <img src="../../../picture/Prolonger.png" height="30" width="30"/>
                                            <s:param name="idBook"><s:property value="rentid"/></s:param>
                                        </s:a> <br>
                                    </s:else>
                                </div>
                                <div class="col-1">
                                    <s:a action="returnbook">
                                        <img src="../../../picture/Delete.png" height="30" width="30"/>
                                        <s:param name="idBook"><s:property value="rentid"/></s:param>
                                    </s:a> <br>
                                </div>
                            </div>
                        </div>
                        <div class="col-1"></div>
                    </div>
                </s:if>
            </s:iterator>
            <br>
        </div>
        <div class="col-1"></div>
    </div>
    <br>
</s:else>

</body>
</html>