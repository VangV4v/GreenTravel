<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Area/</span> Create Area</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="area">
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Area Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Province (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="provinceID">
                                <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                            </form:select>
                            <form:errors path="provinceID" cssClass="errform" />
                        </div>                
                                        
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-area/home-area" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>