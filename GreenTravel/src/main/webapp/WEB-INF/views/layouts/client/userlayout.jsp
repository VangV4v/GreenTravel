<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="zxx" class="no-js">
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="colorlib">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Travel</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet"> 
        <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
        <!--
        CSS
        ============================================= -->
        <link rel="stylesheet" href="<c:url value="/resources/client/css/linearicons.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/client/css/font-awesome.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/client/css/bootstrap.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/client/css/magnific-popup.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/client/css/jquery-ui.css"/>">				
        <link rel="stylesheet" href="<c:url value="/resources/client/css/nice-select.css"/>">							
        <link rel="stylesheet" href="<c:url value="/resources/client/css/animate.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/client/css/owl.carousel.css"/>">				
        <link rel="stylesheet" href="<c:url value="/resources/client/css/main.css"/>">
        <link rel="stylesheet" href="<c:url value="/resources/admin/css/errorform.css"/>" />
        <link rel="stylesheet" href="<c:url value="/resources/client/css/bootstrap/bootstrap-social.css"/>" />  
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    </head>
    <body>	
        <header id="header">
            <div class="header-top">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-lg-6 col-sm-6 col-6 header-top-left">
                           			
                        </div>
                        <div class="col-lg-6 col-sm-6 col-6 header-top-right">
                            <div class="header-social">                               
                                <a href="${pageContext.request.contextPath}/register">Registration</a>                               
                            </div>
                        </div>
                    </div>			  					
                </div>
            </div>
            <div class="container main-menu">
                <div class="row align-items-center justify-content-between d-flex">
                    <div id="logo">
                        <a href="${pageContext.request.contextPath}/home"><img src="<c:url value="/resources/client/img/logo2.png"/>" alt="" title="" /></a><span style="color: white;font-size: 1.125rem;font-weight: inherit">greentravel</span> 
                    </div>
                    <nav id="nav-menu-container">
                        <ul class="nav-menu">
                            <li><a href="${pageContext.request.contextPath}/home">Home</a></li>                    
                            <li class="menu-has-children"><a href="">Packages</a>
                                <ul>
                                    <li><a href="${pageContext.request.contextPath}/packagetour/page/1">Package Tours</a></li>
                                    <li><a href="${pageContext.request.contextPath}/destination/page/1">Destinations</a></li>
                                    <li><a href="${pageContext.request.contextPath}/localtravel/page/1">Local Travels</a></li>
                                </ul>
                            </li>	
                            <li><a href="${pageContext.request.contextPath}/hotel/page/1">Hotels</a></li>
                            <li><a href="${pageContext.request.contextPath}/restaurant/page/1">Restaurants</a></li>
                            <li><a href="${pageContext.request.contextPath}/flight/page/1">Flights</a></li>
                            <li><a href="${pageContext.request.contextPath}/car/page/1">Cars</a></li>
                            <li><a href="${pageContext.request.contextPath}/insurance">Insurance</a></li>                          	                          					          					          		          
                                <sec:authorize access="!isAuthenticated()">
                                <li>
                                    <a href="${pageContext.request.contextPath}/login">Login</a>
                                </li>
                            </sec:authorize>
                            <sec:authorize access="isAuthenticated()">
                                <li class="menu-has-children"><a href="#">${sessionScope['authen'].username}</a>
                                    <ul>                                     
                                        <li class="menu-has-children"><a href="">Account </a>
                                            <ul>
                                                <li> <a href="${pageContext.request.contextPath}/customer/my-profile">Profile</a></li>
                                                <li> <a href="${pageContext.request.contextPath}/customer/update-password">Update Password</a></li>
                                            </ul>
                                        </li>
                                        <li class="menu-has-children"><a href="">Booking </a>
                                            <ul>
                                                <li> <a href="${pageContext.request.contextPath}/customer/my-booking-car">Booking Car</a></li>
                                                <li> <a href="${pageContext.request.contextPath}/customer/my-booking-tour">Booking Tour</a></li>
                                            </ul>
                                        </li>
                                        <li> <a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                                    </ul>
                                </li>                             
                            </sec:authorize>
                        </ul>
                    </nav><!-- #nav-menu-container -->					      		  
                </div>
            </div>
        </header>
        <!-- #header -->
        <section>
            <tiles:insertAttribute name="body"></tiles:insertAttribute>
            </section>
            <!-- start footer Area -->		
            <footer class="footer-area section-gap">
                <div class="container">

                    <div class="row">
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>About Agency</h6>
                                <p>
                                    The world has become so fast paced that people don’t want to stand by reading a page of information, they would much rather look at a presentation and understand the message. It has come to a point 
                                </p>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>Navigation Links</h6>
                                <div class="row">
                                    <div class="col">
                                        <ul>
                                            <li><a href="#">Home</a></li>
                                            <li><a href="#">Feature</a></li>
                                            <li><a href="#">Services</a></li>
                                            <li><a href="#">Portfolio</a></li>
                                        </ul>
                                    </div>
                                    <div class="col">
                                        <ul>
                                            <li><a href="#">Team</a></li>
                                            <li><a href="#">Pricing</a></li>
                                            <li><a href="#">Blog</a></li>
                                            <li><a href="#">Contact</a></li>
                                        </ul>
                                    </div>										
                                </div>							
                            </div>
                        </div>							
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget">
                                <h6>Newsletter</h6>
                                <p>
                                    For business professionals caught between high OEM price and mediocre print and graphic output.									
                                </p>								
                                <div id="mc_embed_signup">
                                    <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01" method="get" class="subscription relative">
                                        <div class="input-group d-flex flex-row">
                                            <input name="EMAIL" placeholder="Email Address" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email Address '" required="" type="email">
                                            <button class="btn bb-btn"><span class="lnr lnr-location"></span></button>		
                                        </div>									
                                        <div class="mt-10 info"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3  col-md-6 col-sm-6">
                            <div class="single-footer-widget mail-chimp">
                                <h6 class="mb-20">InstaFeed</h6>
                                <ul class="instafeed d-flex flex-wrap">
                                    <li><img src="<c:url value="/resources/client/img/i1.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i2.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i3.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i4.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i5.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i6.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i7.jpg"/>" alt=""></li>
                                <li><img src="<c:url value="/resources/client/img/i8.jpg"/>" alt=""></li>
                            </ul>
                        </div>
                    </div>						
                </div>

                <div class="row footer-bottom d-flex justify-content-between align-items-center">
                    <p class="col-lg-8 col-sm-12 footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="#" target="_blank">GreenTravel</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    <div class="col-lg-4 col-sm-12 footer-social">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-dribbble"></i></a>
                        <a href="#"><i class="fa fa-behance"></i></a>
                    </div>
                </div>
            </div>
        </footer>
        <!-- End footer Area -->	

        <script src="<c:url value="/resources/client/js/popper.min.js"/>"></script>	
        <script src="<c:url value="/resources/client/js/vendor/bootstrap.min.js"/>"></script>			
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOdIF3Y9382fqJYt5I_sswSrEw5eihAA"></script>	
        <script src="<c:url value="/resources/client/js/jquery-ui.js"/>"></script>					
        <script src="<c:url value="/resources/client/js/easing.min.js"/>"></script>			
        <script src="<c:url value="/resources/client/js/hoverIntent.js"/>"></script>
        <script src="<c:url value="/resources/client/js/superfish.min.js"/>"></script>	
        <script src="<c:url value="/resources/client/js/jquery.ajaxchimp.min.js"/>"></script>
        <script src="<c:url value="/resources/client/js/jquery.magnific-popup.min.js"/>"></script>						
        <script src="<c:url value="/resources/client/js/jquery.nice-select.min.js"/>"></script>					
        <script src="<c:url value="/resources/client/js/owl.carousel.min.js"/>"></script>							
        <script src="<c:url value="/resources/client/js/mail-script.js"/>"></script>	
        <script src="<c:url value="/resources/client/js/main.js"/>"></script>	
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
        <script src="<c:url value="/resources/client/js/js-booking.js"/>"></script>	
        <!--dataTable-->
        <script src="<c:url value="/resources/admin/vendor/datatables/jquery.dataTables.min.js"/>"></script>
        <script src="<c:url value="/resources/admin/vendor/datatables/datatableconfig.js"/>"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/dataTables.buttons.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/2.3.6/js/buttons.print.min.js"></script>
    </body>
</html>