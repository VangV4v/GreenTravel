<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Update New Password</h4>
    <c:if test="${param.success=='true'}">                                                      
        <div id="alertSuccess" style="position: absolute; top: 12px; right: 16px;" class="bs-toast toast fade show bg-success toast-placement-ex" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <i class="bx bx-bell me-2"></i>
                <div class="me-auto fw-semibold">Notification</div>
                <small>just second ago...</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                This is success process and please close browser 
            </div>
        </div>
    </c:if>
    <div class="row">
        <!-- Merged -->
        <div class="col-md-12">
            <form:form action="" method="post" modelAttribute="emp">
                <form:hidden path="employeeID"/>
                <form:hidden path="status"/>
                <form:hidden path="avatar"/>
                <form:hidden path="address"/>
                <form:hidden path="password"/>
                <form:hidden path="roleTemp"/>
                <form:hidden path="firstname"/>
                <form:hidden path="lastname"/>
                <form:hidden path="username"/>
                <form:hidden path="email"/>
                <form:hidden path="phone"/>
                <form:hidden path="dateOfBirth"/>
                <div class="card mb-4">
                    <h5 class="card-header">Update Password</h5>
                    <div class="card-body demo-vertical-spacing demo-only-element">
                        <div class="form-password-toggle">
                            <label class="form-label" for="basic-default-password32">Old Password</label>
                            <div class="input-group input-group-merge">
                                <form:password path="confirmOldPassword" cssClass="form-control" id="basic-default-password32" value="${emp.confirmOldPassword}" 
                                               aria-describedby="basic-default-password" />
                                <span class="input-group-text cursor-pointer" id="basic-default-password"><i class="bx bx-hide"></i></span>
                            </div>
                            <form:errors path="confirmOldPassword" cssClass="errform" />
                        </div>
                        <div class="form-password-toggle">
                            <label class="form-label" for="basic-default-password32newpass">New Password</label>
                            <div class="input-group input-group-merge">
                                <form:password path="newPassword" cssClass="form-control" id="basic-default-password32" value="${emp.newPassword}"
                                               aria-describedby="basic-default-password" />
                                <span class="input-group-text cursor-pointer" id="basic-default-password"><i class="bx bx-hide"></i></span>

                            </div>
                            <form:errors path="newPassword" cssClass="errform" />
                        </div>
                        <div class="form-password-toggle">
                            <label class="form-label" for="basic-default-passwordconfirm">Confirm New Password</label>
                            <div class="input-group input-group-merge">
                                <form:password path="confirmNewPassword" cssClass="form-control" id="basic-default-password32" value="${emp.confirmNewPassword}"
                                               aria-describedby="basic-default-password" />
                                <span class="input-group-text cursor-pointer" id="basic-default-password"
                                      ><i class="bx bx-hide"></i></span>

                            </div>
                            <form:errors path="confirmNewPassword" cssClass="errform" />
                        </div>
                        <div>
                            <button class="btn btn-primary" type="submit">Update</button>
                            <button type="button" onclick="history.go(-1)" class="btn btn-primary">Back</button>
                        </div>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>