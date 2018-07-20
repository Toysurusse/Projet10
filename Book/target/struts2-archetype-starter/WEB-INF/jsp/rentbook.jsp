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

<s:if test="shoppingList.empty">

    Votre panier est vide

</s:if>
<s:else>
<div class="row">
    <div class="container col-2"></div>
    <div class="container col-10">
        <s:iterator var="Book" value="shoppingList">
            <div class="row">
                <div class="container col-10">
                    <p>
                        <s:property value="id" /> : <s:property value="bookName" />
                    </p>
                </div>
                <div class="container col-2">
                    <s:a action="deleteToShop">
                        <img src="../../picture/Delete.JPG" height="10" width="10"/>
                        <s:param name="idBook"><s:property value="id"/></s:param>
                    </s:a>
                </div>
            </div>
        </s:iterator>
    </div>
    <div class="container col-2"></div>
</div>

<div class="row">
    <div class="container col-2"></div>
    <div class="container col-10">
        <s:form theme="simple" action="rentbook">

            <s:textfield id="datepicker1" name="create_at" width="276" />
            <s:textfield id="datepicker2" name="end_at" width="276" />
            <s:submit method="rentbook" value="enregistrer la location" cssClass="btn btn-primary center-block"/>
        </s:form>
    </div>
    <div class="container col-2"></div>
</div>

<script>
    $('#datepicker2').datepicker({
        value: '${today}',
        minDate: '${today}',
        uiLibrary: 'bootstrap4',
        weekStartDay: 1,
        format: 'dd/mm/yyyy'
    });
</script>

<script>
    $('#datepicker1').datepicker({
        value: '${today}',
        minDate: '${today}',
        uiLibrary: 'bootstrap4',
        weekStartDay: 1,
        format: 'dd/mm/yyyy'
    });
</script>
</s:else>

</body>
</html>