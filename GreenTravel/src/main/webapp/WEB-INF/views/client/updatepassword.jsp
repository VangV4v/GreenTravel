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
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/customer/update-password"> Update Password</a></p>
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
                <!-- Merged -->
                <div class="col-md-12">
                    <form:form action="" method="post" modelAttribute="cus">
                        <form:hidden path="customerID"/>
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

                                    </div>
                                    <form:errors path="confirmOldPassword" cssClass="errform" />
                                </div>
                                <div class="form-password-toggle">
                                    <label class="form-label" for="basic-default-password32newpass">New Password</label>
                                    <div class="input-group input-group-merge">
                                        <form:password path="newPassword" cssClass="form-control" id="basic-default-password32" value="${emp.newPassword}"
                                                       aria-describedby="basic-default-password" />


                                    </div>
                                    <form:errors path="newPassword" cssClass="errform" />
                                </div>
                                <div class="form-password-toggle">
                                    <label class="form-label" for="basic-default-passwordconfirm">Confirm New Password</label>
                                    <div class="input-group input-group-merge">
                                        <form:password path="confirmNewPassword" cssClass="form-control" id="basic-default-password32" value="${emp.confirmNewPassword}"
                                                       aria-describedby="basic-default-password" />


                                    </div>
                                    <form:errors path="confirmNewPassword" cssClass="errform" />
                                </div>
                                <div style="margin-top: 10px">
                                    <button class="genric-btn primary" type="submit">Update</button>
                                    <button onclick="history.go(-1)" class="genric-btn primary" type="button">Back</button>

                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>	
</section>
<!-- End contact-page Area -->