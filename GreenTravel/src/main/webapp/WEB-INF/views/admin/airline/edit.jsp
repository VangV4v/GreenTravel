<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Airline/</span> Update Airline</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">               
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="airline" >
                        <form:hidden path="airlineID" />
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Airline Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Url(<sup style="color:red">*</sup>)</label>
                            <form:input path="url" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="url" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Company(<sup style="color:red">*</sup>)</label>
                            <form:input path="company" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="company" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-airline/home-airline" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>