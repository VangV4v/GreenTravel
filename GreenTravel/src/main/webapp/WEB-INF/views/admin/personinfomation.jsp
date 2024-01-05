<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span>My Account</h4>
    <c:if test="${param.success=='true'}">                                                      
        <div id="alertSuccess" style="position: absolute; top: 12px; right: 16px;" class="bs-toast toast fade show bg-success toast-placement-ex" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <i class="bx bx-bell me-2"></i>
                <div class="me-auto fw-semibold">Notification</div>
                <small>just second ago...</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                This is success process...
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-md-12">           
            <div class="card mb-4">
                <h5 class="card-header">Profile Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <form:form action="${pageContext.request.contextPath}/admin/upload-image-employee" method="post" modelAttribute="image" enctype="multipart/form-data">
                        <form:hidden path="employeeID"/>
                        <div class="d-flex align-items-start align-items-sm-center gap-4">
                            <img
                                src="<c:url value="${image.path}"/>"
                                alt="user-avatar"
                                class="d-block rounded"
                                height="100"
                                width="100"
                                id="uploadedAvatar"
                                />
                            <div class="button-wrapper">
                                <label for="upload" class="btn btn-primary me-2 mb-4" tabindex="0">
                                    <span class="d-none d-sm-block">Choose new photo</span>
                                    <i class="bx bx-upload d-block d-sm-none"></i>
                                    <input
                                        type="file"
                                        id="upload"
                                        class="account-file-input"
                                        name="image"
                                        accept="image/png, image/jpeg, image/jpg"
                                        />
                                </label>

                                <button type="submit" class="btn btn-outline-primary account-image-reset mb-4">
                                    <i class="bx bx-reset d-block d-sm-none"></i>
                                    <span class="d-none d-sm-block">Upload</span>
                                </button>
                                <p class="text-muted mb-0">Allowed JPG, JPG or PNG. Max size of 5mb</p>
                            </div>
                        </div>
                    </form:form>
                </div>
                <hr class="my-0" />
                <div class="card-body">
                    <form:form id="formAccountSettings" method="POST" modelAttribute="profile" action="${pageContext.request.contextPath}/admin/change-my-profile" >
                        <form:hidden path="employeeID"/>
                        <form:hidden path="status"/>
                        <form:hidden path="avatar"/>
                        <form:hidden path="password"/>
                        <form:hidden path="roleTemp"/>
                        <form:hidden path="confirmNewPassword" value="none"/>
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="firstName" class="form-label">First Name</label>
                                <form:input path="firstname" cssClass="form-control" id="basic-default-username"  />
                                <form:errors path="firstname" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Last Name</label>
                                <form:input path="lastname" cssClass="form-control" id="basic-default-username"  />
                                <form:errors path="lastname" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="email" class="form-label">E-mail</label>
                                <form:input path="email" cssClass="form-control" id="basic-default-username"  />
                                <form:errors path="email" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label" for="phoneNumber">Phone Number</label>
                                <form:input path="phone" cssClass="form-control" id="basic-default-username"  />
                                <form:errors path="phone" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="address" class="form-label">User Name</label>
                                <form:input path="username" cssClass="form-control" id="basic-default-username" readonly="true"  />
                                <form:errors path="username" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Date</label>
                                <form:input path="dateOfBirth" cssClass="form-control" id="basic-default-username" type="date" />
                                <form:errors path="dateOfBirth" cssClass="errform" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Address</label>
                                <form:input path="address" cssClass="form-control" id="basic-default-username"  />
                                <form:errors path="address" cssClass="errform" />
                            </div>
                        </div>
                        <div class="mt-2">
                            <button type="submit" class="btn btn-primary me-2">Save changes</button>
                            <button type="button" onclick="history.go(-1)" class="btn btn-primary">Back</button>
                        </div>
                    </form:form>
                </div>
                <!-- /Account -->
            </div>
        </div>
    </div>
</div>
