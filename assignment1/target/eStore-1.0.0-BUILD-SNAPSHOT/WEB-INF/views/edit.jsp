<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container-wrapper">
    <div class="container">
        <h1>Edit Product</h1>
        <p class="lead">Fill the below information to add a product:</p>

        <c:set var="actionUrl"
               value="${pageContext.request.contextPath}/productInventory/${product.id != 0 ?
               'updateProduct' : 'addProduct'}" />

        <sf:form  action="${actionUrl}"  method="post" modelAttribute="product">

            <c:if test="${product.id != 0}">
                <sf:hidden path="id"/>
            </c:if>

            <!--name-->
            <div class="form-group">
                <label for="name">Name</label>
                <sf:input path="name" id="name" class="form-control" />
                <sf:errors path="name" cssStyle="color:#ff0000;"/>
            </div>
            <!--category-->
            <div class="form-group">
                <label for="name">Category</label>
                <div class="form-check">
                    <label class="form-check-label">
                        <sf:radiobutton path="category" id="computer" value="computer" class="form-check-input"/> 컴퓨터
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <sf:radiobutton path="category" id="appliance" value="appliance" class="form-check-input"/> 가전
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <sf:radiobutton path="category" id="goods" value="goods" class="form-check-input"/> 잡화
                    </label>
                </div>
                <sf:errors path="category" cssStyle="color:#ff0000;"/>
            </div>
            <!--description-->
            <div class="form-group">
                <label for="name">Description</label>
                <sf:input path="description" id="description" class="form-control" />
                <sf:errors path="description" cssStyle="color:#ff0000;"/>
            </div>
            <!--price-->
            <div class="form-group">
                <label for="name">Price</label>
                <sf:input path="price" id="price" class="form-control" />
                <sf:errors path="price" cssStyle="color:#ff0000;"/>
            </div>
            <!--unitInStock-->
            <div class="form-group">
                <label for="name">Unit In Stock</label>
                <sf:input path="unitInStock" id="unitInStock" class="form-control" />
                <sf:errors path="unitInStock" cssStyle="color:#ff0000;"/>
            </div>
            <!--manufacturer-->
            <div class="form-group">
                <label for="manufacturer">Manufacturer</label>
                <sf:input path="manufacturer" id="manufacturer" class="form-control" />
                <sf:errors path="manufacturer" cssStyle="color:#ff0000;"/>
            </div>

            <input type="submit" value="submit" class="btn btn-primary">
            <a href="<c:url value="/productInventory" />"	class="btn btn-default">Cancel</a>
        </sf:form>
        <br/>
    </div>
</div>