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

<s:if test="shoppingList.empty">
    <div class="text-lg-center">
        Votre panier est vide
    </div>
</s:if>
<s:else>
    <br>
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10 border border-info rounded">
            <br>
            <s:iterator var="Book" value="shoppingList">
                <div class="row">
                    <div class="col-1"></div>
                    <div class="row col-10 container rounded">
                        <div class="col-11">
                            <s:property value="bookName"/>
                        </div>
                        <div class="col-1">
                            <s:a action="deleteToShop">
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
    </div>

    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <br>
            <s:form theme="simple" action="rentbook">
                <div class="row col-12">
                    <div class="row col-6">
                        <label for="create_at" class="starter-template col-12 text-center">Date de début de prêt
                            :</label>
                        <div class="col-12 d-flex justify-content-center">
                            <s:textfield id="datepicker1" name="create_at" width="276"/>
                        </div>
                    </div>
                    <div class="row col-6">
                        <label for="end_at" class="starter-template col-12 text-center">Date de fin de prêt :</label>
                        <div class="col-12 d-flex justify-content-center">
                            <s:textfield id="datepicker2" name="end_at" width="276"/>
                        </div>
                    </div>
                </div>
                <br>
                <div class="col-12 d-flex justify-content-center">
                    <s:submit method="rentbook" value="enregistrer la location"
                              cssClass="btn btn-primary center-block"/>
                </div>
                <br>
                <s:actionerror/>
            </s:form>
        </div>
        <div class="col-1"> </div>
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