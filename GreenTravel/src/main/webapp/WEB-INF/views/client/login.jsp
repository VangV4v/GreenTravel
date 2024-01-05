<%-- 
    Author     : kyqua
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>





<c:if test="${param.register == 'success'}">
    <script>
        Swal.fire('Register success account ');
    </script>
</c:if>
<!-- start banner Area -->
<section class="relative about-banner">	
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Login			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/login"> Login</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->				  

<!-- Start contact-page Area -->
<section class="contact-page-area section-gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <c:url value="login-process" var="url" />
                <form class="form-area contact-form text-right" action="${url}" method="post">

                    <c:if test="${param.err =='true' }">
                        <h4  style="color: red;float: left; margin-bottom: 10px;">Login Fail ! Please check again</h4>
                        <span style="color: red;float: left">  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</span>

                    </c:if>
                    <div class="form-group">
                        <input name="username" placeholder="Enter your name"  class="common-input mb-20 form-control" required="" type="text">
                        <input name="password" placeholder="Enter your password"   class="common-input mb-20 form-control" required="" type="password">
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <button style="width: 100%" type="submit" class="genric-btn primary">LOGIN</button>

                        </div>
                        <div class="col-md-6">
                            <a class="btn btn-block btn-social btn-google" href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/GreenTravel/login-google&response_type=code
                               &client_id=735839220312-o98d6tlhgsiktiv61i14pn4rq525k53o.apps.googleusercontent.com&approval_prompt=force"><span class="fa fa-google"></span> Sign in with google</a>

                        </div>
                    </div>
                </form>	
            </div>
            <div class="col-lg-6">
                <img height="300" width="500" src="<c:url value="/resources/client/img/login.jpg"/>" alt="">

            </div>
        </div>
    </div>	
</section>
<!-- End contact-page Area -->