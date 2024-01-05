<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Car Type/</span> Update Car Type</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="typecar" >
                        <form:hidden path="carTypeID"/>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Type Car Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="carTypeName" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="carTypeName" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Type Car Description (<sup style="color:red">*</sup>)</label>
                            <form:input path="carTypeDescription" cssClass="form-control" id="basic-default-password"    />
                            <form:errors path="carTypeDescription" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-typecar/home-typecar" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>