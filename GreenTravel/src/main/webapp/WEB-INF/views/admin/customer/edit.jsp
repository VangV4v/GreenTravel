<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Customer/</span> Update Customer</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">               
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="cus" >
                        <form:hidden path="customerID"/>
                        <form:hidden path="status"/>
                        <form:hidden path="avatar"/>
                        <form:hidden path="address"/>
                        <form:hidden path="password"/>
                        <form:hidden path="roleTemp"/>
                        <form:hidden path="confirmNewPassword" value="none"/>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">User Name</label>
                            <form:input path="username" cssClass="form-control" id="basic-default-username" readonly="true"  />
                            <form:errors path="username" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Password</label>
                            <form:password path="newPassword" cssClass="form-control"  id="basic-default-password"   />
                            <input type="hidden" name="oldPassword" value="${cus.password}" />
                            <form:errors path="newPassword" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-firstname">First Name</label>
                            <form:input path="firstname" cssClass="form-control" id="basic-default-firstname" placeholder="John Doe"  />
                            <form:errors path="firstname" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Last Name</label>
                            <form:input path="lastname" cssClass="form-control" id="basic-default-lastname" placeholder="John Doe"  />
                            <form:errors path="lastname" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-dateOfBirth">Date of Birth</label>
                            <form:input path="dateOfBirth" cssClass="form-control" id="basic-default-dateOfBirth" value="${cus.dateOfBirth}" type="date"   />
                            <form:errors path="dateOfBirth" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-email">Email</label>
                            <div class="input-group input-group-merge">
                                <input type="hidden" name="oldEmail" value="${cus.email}"/>
                                <form:input path="email" cssClass="form-control" id="basic-default-email" aria-label="john.doe"
                                            aria-describedby="basic-default-email2"  />
                                <span class="input-group-text" id="basic-default-email2">@example.com</span>
                            </div>
                            <div class="form-text">You can use letters, numbers & periods</div>
                            <form:errors path="email" id="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-phone">Phone No</label>
                            <form:input path="phone" cssClass="form-control" id="basic-default-phone" type="number"   />
                            <form:errors path="phone" id="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-customer/home-customer" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>