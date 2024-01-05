<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!-- start banner Area -->
<section class="banner-area relative">
    <div class="overlay overlay-bg"></div>				
    <div class="container">
        <div class="row fullscreen align-items-center justify-content-between">
            <div class="col-lg-6 col-md-6 banner-left">
                <h6 class="text-white">Away from monotonous life</h6>
                <h1 class="text-white">Magical Travel</h1>
                <p class="text-white">
                    If you are looking at blank cassettes on the web, you may be very confused at the difference in price. You may see some for as low as $.17 each.
                </p>
                <a href="#" class="primary-btn text-uppercase">Get Started</a>
            </div>
            <div class="col-lg-4 col-md-6 banner-right">


            </div>
        </div>
    </div>					
</section>
<section class="recent-blog-area" style="padding-top: 20px">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-60 col-lg-9">
                <div class="title text-center">
                    <h1 class="mb-10">New Packages</h1>
                    <p>With the exception of Nietzsche, no other madman has contributed so much to human sanity as has.</p>
                </div>
            </div>
        </div>							
        <div class="row">
            <c:forEach items="${listPackageNew}" begin="0" end="2" step="1" var="itemPackageNew">
                <div class="col-md-4">
                    <div class="item">
                        <div >
                            <img height="250px"  width="360" src="<c:url value="${itemPackageNew.image}"/>" alt="">
                        </div>
                        <div class="details">
                            <div class="row ">

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/packagetour/detail/${itemPackageNew.packageTourID}">View Detail</a>

                                </div>

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/customer/bookingtour/${itemPackageNew.packageTourID}">Book Tour</a>

                                </div>

                            </div>
                            <a href="#"><h4 class="title">${itemPackageNew.name}&nbsp;<strong style="color: #f8b600">$${itemPackageNew.price}</strong> </h4></a>
                            <p>
                                ${fn:substring(itemPackageNew.description, 0, 45)}...
                            </p>
                            <h6 class="date">From &nbsp; <strong>${itemPackageNew.dateStart}</strong> </h6>
                            <h6 class="date">To &nbsp; <strong>${itemPackageNew.dateEnd}</strong> </h6>
                            <h6 class="date">Available Slot &nbsp; <strong>${itemPackageNew.capacity}</strong> </h6>
                        </div>	
                    </div>   
                </div>
            </c:forEach>                            												
        </div>
    </div>	
</section>
<section class="recent-blog-area" style="padding-top: 20px">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-60 col-lg-9">
                <div class="title text-center">
                    <h1 class="mb-10">New Cars</h1>
                    <p>With the exception of Nietzsche, no other madman has contributed so much to human sanity as has.</p>
                </div>
            </div>
        </div>							
        <div class="row">
            <c:forEach items="${listCarNew}" begin="0" end="2" step="1" var="itemCarNew">
                <div class="col-md-4">
                    <div class="item">
                        <div >
                            <img height="250px" width="360" src="<c:url value="${itemCarNew.image}"/>" alt="">
                        </div>
                        <div class="details">
                            <div class="row ">
                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/customer/booking-car/${itemCarNew.carID}">Book Car</a>
                                </div>
                            </div>
                            <a href="#"><h4 class="title">${itemCarNew.carName}&nbsp;<strong style="color: #f8b600">$${itemCarNew.priceInDay}</strong> </h4></a>                         
                            <h6 class="date"><strong>${itemCarNew.carName}</strong> </h6>
                            <h6 class="date"><strong>${itemCarNew.carTypeID.carTypeName}</strong> </h6>
                            <h6 class="date"><strong>${itemCarNew.carModelID.name}</strong> </h6>
                        </div>	
                    </div>   
                </div>
            </c:forEach>                            												
        </div>
    </div>	
</section>
<section class="recent-blog-area" style="padding-top: 20px">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-60 col-lg-9">
                <div class="title text-center">
                    <h1 class="mb-10">Hot Packages</h1>
                    <p>With the exception of Nietzsche, no other madman has contributed so much to human sanity as has.</p>
                </div>
            </div>
        </div>							
        <div class="row">
            <c:forEach items="${listPackageHot}" begin="0" end="2" step="1" var="itemPackageHot">
                <div class="col-md-4">
                    <div class="item">
                        <div >
                            <img height="250px"  width="360" src="<c:url value="${itemPackageHot.image}"/>" alt="">
                        </div>
                        <div class="details">
                            <div class="row ">

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/packagetour/detail/${itemPackageHot.packageTourID}">View Detail</a>

                                </div>

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/customer/bookingtour/${itemPackageHot.packageTourID}">Book Tour</a>

                                </div>

                            </div>
                            <a href="#"><h4 class="title">${itemPackageHot.name}&nbsp;<strong style="color: #f8b600">$${itemPackageHot.price}</strong> </h4></a>
                            <p>
                                ${fn:substring(itemPackageHot.description, 0, 45)}...
                            </p>
                            <h6 class="date">From &nbsp; <strong>${itemPackageHot.dateStart}</strong> </h6>
                            <h6 class="date">To &nbsp; <strong>${itemPackageHot.dateEnd}</strong> </h6>
                            <h6 class="date">Available Slot &nbsp; <strong>${itemPackageHot.capacity}</strong> </h6>
                        </div>	
                    </div>   
                </div>
            </c:forEach>                            												
        </div>
    </div>	
</section>
<section class="recent-blog-area" style="padding-top: 20px;padding-bottom: 50px">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-60 col-lg-9">
                <div class="title text-center">
                    <h1 class="mb-10">Almost Packages Tour</h1>
                    <p>With the exception of Nietzsche, no other madman has contributed so much to human sanity as has.</p>
                </div>
            </div>
        </div>							
        <div class="row">
            <c:forEach items="${listPackageLimitDate}" begin="0" end="2" step="1" var="itemPackageLimitDate">
                <div class="col-md-4">
                    <div class="item">
                        <div >
                            <img height="250px"  width="360" src="<c:url value="${itemPackageLimitDate.image}"/>" alt="">
                        </div>
                        <div class="details">
                            <div class="row ">

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/packagetour/detail/${itemPackageLimitDate.packageTourID}">View Detail</a>

                                </div>

                                <div style="padding: 10px">
                                    <a class="primary-btn" href="${pageContext.request.contextPath}/customer/bookingtour/${itemPackageLimitDate.packageTourID}">Book Tour</a>

                                </div>

                            </div>
                            <a href="#"><h4 class="title">${itemPackageLimitDate.name}&nbsp;<strong style="color: #f8b600">$${itemPackageLimitDate.price}</strong> </h4></a>
                            <p>
                                ${fn:substring(itemPackageLimitDate.description, 0, 45)}...
                            </p>
                            <h6 class="date">From &nbsp; <strong>${itemPackageLimitDate.dateStart}</strong> </h6>
                            <h6 class="date">To &nbsp; <strong>${itemPackageLimitDate.dateEnd}</strong> </h6>
                            <h6 class="date">Available Slot &nbsp; <strong>${itemPackageLimitDate.capacity}</strong> </h6>
                        </div>	
                    </div>   
                </div>
            </c:forEach>                            												
        </div>
    </div>	
</section>
<!-- End recent-blog Area -->	


<!-- Start blog Area -->

<!-- End recent-blog Area -->	
<!-- Start popular-destination Area -->

<!-- End popular-destination Area -->

<!-- Start home-about Area -->

<!-- End home-about Area -->
