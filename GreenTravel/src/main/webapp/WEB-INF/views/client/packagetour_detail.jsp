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
                    Package Tour Detail			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/packagetour/page/1">Package Tour </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/packagetour_detail/${packageTour.packageTourID}"> Package Tour Detail</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->

<!-- Start top-category-widget Area -->
<section class="top-category-widget-area pt-90 pb-90 ">
    <div class="container">
        <div class="row">		
            <div class="col-lg-4">
                <div class="single-cat-widget">
                    <div class="content relative">
                        <div class="overlay overlay-bg"></div>
                        <a href="#" target="_blank">
                            <div class="thumb">
                                <img class="content-image img-fluid d-block mx-auto" src="<c:url value="/resources/client/img/blog/cat-widget1.jpg"/>" alt="">
                            </div>
                            <div class="content-details">
                                <h4 class="content-title mx-auto text-uppercase">Activity</h4>
                                <span></span>								        
                                <p>Enjoy your meaningful activity together</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-cat-widget">
                    <div class="content relative">
                        <div class="overlay overlay-bg"></div>
                        <a href="#" target="_blank">
                            <div class="thumb">
                                <img class="content-image img-fluid d-block mx-auto" src="<c:url value="/resources/client/img/blog/cat-widget2.jpg"/>" alt="">
                            </div>
                            <div class="content-details">
                                <h4 class="content-title mx-auto text-uppercase">Respect</h4>
                                <span></span>								        
                                <p>With criteria "Customers are our parents"</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-cat-widget">
                    <div class="content relative">
                        <div class="overlay overlay-bg"></div>
                        <a href="#" target="_blank">
                            <div class="thumb">
                                <img class="content-image img-fluid d-block mx-auto" src="<c:url value="/resources/client/img/blog/cat-widget3.jpg"/>" alt="">
                            </div>
                            <div class="content-details">
                                <h4 class="content-title mx-auto text-uppercase">Food</h4>
                                <span></span>
                                <p>Once taste and never forget</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>												
        </div>
    </div>	
</section>
<!-- End top-category-widget Area -->

<!-- Start post-content Area -->
<section class="post-content-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 posts-list">
                <div class="single-post row">
                    <div class="col-lg-3  col-md-3 meta-details">                      
                        <div class="user-details row">
                            <p class="comments col-lg-12 col-md-12 col-6"><a href="#">${packageTour.fromProvinceID.name}</a> <span class="lnr lnr-map-marker"></span></p>						
                            <p class="user-name col-lg-12 col-md-12 col-6"><a href="#">${packageTour.fromProvinceID.airportName}</a> <span class="lnr lnr-apartment"></span></p>                
                            <p class="view col-lg-12 col-md-12 col-6"><a href="#">${packageTour.dateStart}</a> <span class="lnr lnr-clock"></span></p>
                        </div>
                    </div>
                    <div class="col-lg-9 col-md-9 ">                          
                        <h3>Departure Day</h3>
                        <p class="excert">
                            You gather at ${packageTour.fromProvinceID.airportName} (Domestic station), the tour guide will assist you with procedures for flight to ${packageTour.toProvinceID.name}.
                            ${itemTour.description}
                        </p>                                                   
                    </div>
                </div>
                <c:forEach items="${packageTour.toursList}" var="itemTour">
                    <div class="single-post row">
                        <div class="col-lg-3  col-md-3 meta-details">                      
                            <div class="user-details row">
                                <p class="comments col-lg-12 col-md-12 col-6"><a href="#">${itemTour.destinationID.name}</a> <span class="lnr lnr-map-marker"></span></p>						
                                <p class="user-name col-lg-12 col-md-12 col-6"><a href="#">${itemTour.restaurantID.name}</a> <span class="lnr lnr-dinner"></span></p>
                                <p class="user-name col-lg-12 col-md-12 col-6"><a href="#">${itemTour.hotelID.name}</a> <span class="lnr lnr-apartment"></span></p>
                                <p class="date col-lg-12 col-md-12 col-6"><a href="#">${itemTour.schedule}</a> <span class="lnr lnr-calendar-full"></span></p>
                                <p class="view col-lg-12 col-md-12 col-6"><a href="#">${itemTour.visitDate}</a> <span class="lnr lnr-clock"></span></p>
                            </div>
                        </div>
                        <div class="col-lg-9 col-md-9 ">                          
                            <h3>${itemTour.name}</h3>
                            <p class="excert">
                                ${itemTour.description}
                            </p> 
                            <p class="excert">
                                Note: ${itemTour.note}
                            </p> 
                            <h3>Local Travel</h3>
                            <c:forEach items="${itemTour.localTravelInToursList}" var="itemLT">
                                <div class="feature-img">
                                    <img style="padding-top: 10px;padding-bottom: 10px" class="img-fluid" src="<c:url value="${itemLT.localTravelID.image}"/>" alt="">
                                </div>
                                <h5>${itemLT.localTravelID.name}</h5>
                                <p class="excert">
                                    ${itemLT.localTravelID.description}
                                </p>                            
                            </c:forEach>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-lg-4 sidebar-widgets">
                <div class="widget-wrap">
                    <div style="padding-top: 10px" class="single-sidebar-widget search-widget">
                        <img height="240" width="290" src="<c:url value="${packageTour.image}"/>" alt="">
                    </div>
                    <div class="single-sidebar-widget user-info-widget">
                        <h4>${packageTour.name}</h4>
                        <p>
                            ${packageTour.tourTypeID.name}<br/><!-- comment -->
                            Price per Adult: ${packageTour.price} <br/>
                            Price per Children: ${packageTour.price*0.8}
                        </p>

                        <p>
                            ${packageTour.description}
                        </p>
                    </div>
                    <div class="single-sidebar-widget popular-post-widget">
                        <h4 class="popular-title">Trip</h4>
                        <div class="popular-post-list">
                            <div class="single-post-list d-flex flex-row align-items-center">
                                <div >
                                    <img width="150px" height="80px"  src="<c:url value="/resources/client/img/departure.jpg"/>" alt="">
                                </div> 
                                <div class="details">
                                    <a href="#"><h6>${packageTour.fromProvinceID.name} </h6></a>
                                    <p>${packageTour.fromProvinceID.airportName}</p>
                                </div>
                            </div>
                            <div class="single-post-list d-flex flex-row align-items-center">
                                <div>
                                    <img width="150px" height="80px"  src="<c:url value="/resources/client/img/arrivals.jpg"/>" alt="">
                                </div>
                                <div class="details">
                                    <a href="#"><h6>${packageTour.toProvinceID.name}</h6></a>
                                    <p>${packageTour.toProvinceID.airportName}</p>
                                </div>
                            </div>                         															
                        </div>
                    </div>                   
                    <div class="single-sidebar-widget post-category-widget">
                        <h4 class="category-title">Time</h4>
                        <ul class="cat-list">
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>Start</p>
                                    <p>${packageTour.dateStart}</p>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="d-flex justify-content-between">
                                    <p>End</p>
                                    <p>${packageTour.dateEnd}</p>
                                </a>
                            </li>                                                                                                                                                             														
                        </ul>
                    </div>
                    <div class="single-sidebar-widget newsletter-widget">                                             
                        <a href="${pageContext.request.contextPath}/customer/bookingtour/${packageTour.packageTourID}" class="primary-btn">Book Tour</a>								
                    </div>
                </div>
            </div>
        </div>
    </div>	
</section>
<!-- End post-content Area -->