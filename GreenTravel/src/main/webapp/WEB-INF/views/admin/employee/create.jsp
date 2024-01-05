<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Employee/</span> Create Employee</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="emp" >
                        <form:hidden path="employeeID"/>
                        <form:hidden path="status"/>
                        <form:hidden path="avatar"/>
                        <form:hidden path="confirmNewPassword" value="none"/>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">User Name</label>
                            <form:input path="username" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="username" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Password</label>
                            <form:password path="password" cssClass="form-control" id="basic-default-password" value="${emp.password}"   />
                            <form:errors path="password" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-firstname">First Name</label>
                            <form:input path="firstname" cssClass="form-control" id="basic-default-firstname" placeholder="John Doe"  />
                            <form:errors path="firstname" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Last Name</label>
                            <form:input path="lastname" cssClass="form-control" id="basic-default-lastname" placeholder="John Doe"  />
                            <form:errors path="lastname" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-dateOfBirth">Date of Birth</label>
                            <form:input path="dateOfBirth" cssClass="form-control" id="basic-default-dateOfBirth" type="date"   />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-roles">Roles</label>
                            <div class="form-group">
                                <form:radiobutton path="roleTemp" cssClass="form-check-input" id="basic-default-roles" value="1" label="ROLE_ADMIN" />
                                <form:radiobutton path="roleTemp" cssClass="form-check-input" id="basic-default-roles" value="2" label="ROLE_EMPLOYEE" checked="checked" />
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-email">Email</label>
                            <div class="input-group input-group-merge">
                                <form:input path="email" cssClass="form-control" id="basic-default-email" aria-label="john.doe"
                                            aria-describedby="basic-default-email2"  />
                                <span class="input-group-text" id="basic-default-email2">@example.com</span>
                            </div>                      
                            <form:errors path="email" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-phone">Phone No</label>
                            <form:input path="phone" cssClass="form-control" id="basic-default-phone" type="number"   />
                            <form:errors path="phone" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/boss/manage-employee/home-employee" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>