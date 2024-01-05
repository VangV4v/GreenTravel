<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Car Model/</span> Create Car Model</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="carmodel" >
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Car Model (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Company Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="companyName" cssClass="form-control" id="basic-default-password"    />
                            <form:errors path="companyName" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Url (<sup style="color:red">*</sup>)</label>
                            <form:input path="url" cssClass="form-control" id="basic-default-password"    />
                            <form:errors path="url" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Country (<sup style="color:red">*</sup>)</label>
                            <form:input path="country" cssClass="form-control" id="basic-default-password"    />
                            <form:errors path="country" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-carmodel/home-carmodel" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>