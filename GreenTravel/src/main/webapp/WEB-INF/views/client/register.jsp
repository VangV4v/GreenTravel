<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start banner Area -->
<section class="relative about-banner">	
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Registration			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/register"> Registration</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->				  
<!-- Start contact-page Area -->
<section class="contact-page-area section-gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form:form action="" method="post" modelAttribute="cus">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="username">User name:</label>
                                <form:input path="username" cssClass="form-control" id="username"/>
                                <form:errors path="username" cssClass="errform" />
                            </div>
                            <div class="col-lg-6">
                                <label for="phone">Phone number:</label>
                                <form:input path="phone" cssClass="form-control" id="phone"/>
                                <form:errors path="phone" cssClass="errform" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="password">Password:</label>
                                <form:password path="password" cssClass="form-control" value="${cus.password}" id="password"/>
                                <form:errors path="password" cssClass="errform" />
                            </div>
                            <div class="col-lg-6">
                                <label for="confirmNewPassword">Confirm Password:</label>
                                <form:password path="confirmNewPassword" cssClass="form-control" value="${cus.confirmNewPassword}" id="confirmNewPassword"/>
                                <form:errors path="confirmNewPassword" cssClass="errform" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="email">Email address:</label>
                                <form:input path="email" cssClass="form-control" id="email"/>
                                <form:errors path="email" cssClass="errform" />
                            </div>
                            <div class="col-lg-6">
                                <label for="date">Date of birth:</label>
                                <form:input path="dateOfBirth" cssClass="form-control" id="date" type="date" required="required"/>
                                <form:errors path="dateOfBirth" cssClass="errform" />
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="row">
                            <div class="col-lg-6">
                                <label for="firstname">First name:</label>
                                <form:input path="firstname" cssClass="form-control" id="firstname"/>
                                <form:errors path="firstname" cssClass="errform" />
                            </div>
                            <div class="col-lg-6">
                                <label for="lastname">Last name:</label>
                                <form:input path="lastname" cssClass="form-control" id="lastname"/>
                                <form:errors path="lastname" cssClass="errform" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <img src="${pageContext.request.contextPath}/captcha" />
                        <input type="text" name="captcha" required="required" />
                        <c:if test="${errCaptcha != null}">
                            <h5>${errCaptcha}</h5>
                        </c:if>
                    </div>
                    <button type="submit" class="genric-btn primary">Register</button>
                </form:form>
            </div>
        </div>
    </div>	
</section>
<!-- End contact-page Area -->