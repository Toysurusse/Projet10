<!DOCTYPE html PUBLIC
"-//W3C//DTD XHTML 1.1 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Panier</title>

    <s:head/>
</head>
<body>

<br>
<div class="row">
    <div class="col-1"></div>
    <div class="col-10 border border-info rounded">
        <br>
        <div class="row">
            <div class="col-1"></div>
            <div class="row col-10 container rounded">
                <div class="col-11">
                    <s:property value="%{listrented.bookName}"/>
                </div>
            </div>
            <div class="col-1"></div>
        </div>
        <br>
    </div>
    <div class="col-1"></div>
</div>

<div class="row">
    <div class="col-1"></div>
    <div class="col-10">
        <br>
        <s:form theme="simple" action="reloadrentbook">
            <div class="row col-12">
                <label for="end_at" class="starter-template col-12 text-center">Nouvelle date de fin de prêt :</label>
                <div class="col-12 d-flex justify-content-center">
                    <s:textfield id="datepicker2" name="end_at" width="276"/>
                </div>
            </div>
            <br>
            <s:hidden name="idBook" value="%{listrented.rentid}"/>
            <div class="col-12 d-flex justify-content-center">
                <s:submit method="reloadrentbook" value="enregistrer la location"
                          cssClass="btn btn-primary center-block"/>
            </div>
            <br>
            <s:actionerror/>
        </s:form>
    </div>
    <div class="col-1"></div>
</div>

<script>
    $('#datepicker2').datepicker({
        value: '${today4W}',
        minDate: '${today}',
        uiLibrary: 'bootstrap4',
        weekStartDay: 1,
        format: 'dd/mm/yyyy'
    });
</script>


</body>
</html>