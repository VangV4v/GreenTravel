<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:if test="${param.success=='true'}">    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
    <script>
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Update succesfuly',
            showConfirmButton: false,
            timer: 2000
        })
    </script>
</c:if>
<!-- start banner Area -->
<section class="relative about-banner">	
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Update Personal Infomation			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/login"> Update Personal Infomation</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->

<!-- Start contact-page Area -->
<section class="contact-page-area section-gap">
    <div class="container">
        <div class="container-xxl flex-grow-1 container-p-y">
            <div class="row">
                <div class="col-md-12">
                    <div class="card mb-4">
                        <!-- Account -->
                        <div class="card-body">
                            <form:form action="${pageContext.request.contextPath}/customer/upload-avatar" method="post" modelAttribute="image" enctype="multipart/form-data">
                                <form:hidden path="customerID"/>
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
                                        <label for="upload" class="genric-btn primary me-2 mb-4" tabindex="0">                                        

                                            <input
                                                type="file"
                                                id="upload"
                                                class="account-file-input"
                                                name="image"
                                                accept="image/png, image/jpeg"
                                                />
                                        </label>
                                        <button type="submit" class="genric-btn primary account-image-reset mb-4">

                                            Upload
                                        </button>
                                        <p class="text-muted mb-0">Allowed JPG, JPEG or PNG. Max size of 5MB</p>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                        <hr class="my-0" />
                        <div class="card-body">
                            <form:form id="formAccountSettings" method="POST" modelAttribute="cus" action="${pageContext.request.contextPath}/customer/change-my-profile" >
                                <form:hidden path="customerID"/>
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
                                        <form:input path="email" cssClass="form-control" id="basic-default-username"   />
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
                                    <button type="submit" class="genric-btn primary">Save changes</button>
                                    <button type="button" onclick="history.go(-1)" class="genric-btn primary">Back</button>
                                </div>
                            </form:form>
                        </div>
                        <!-- /Account -->
                    </div>
                </div>
            </div>
        </div>
    </div>	
</section>
<!-- End contact-page Area -->