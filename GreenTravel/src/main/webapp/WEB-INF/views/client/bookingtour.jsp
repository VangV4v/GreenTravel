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
                    Booking Tour			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/bookingtour"> Booking Tour</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->
<!-- Start booking tour-page Area -->
<section class="contact-page-area section-gap">
    <div class="container">
        <div class="row">
            <div class=" col-lg-8 d-flex flex-column">
                <form:form cssClass="form-area contact-form" method="post" modelAttribute="bookingTour">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">                      
                                <label class="form-label">Booking Name:(<sup style="color:red">*</sup>)</label>
                                <form:input  path="bookingName" cssClass="form-control" />   
                                <form:errors path="bookingName" cssClass="errform" />
                            </div>
                            <div class="form-group">                      
                                <label class="form-label">Booking Email:(<sup style="color:red">*</sup>)</label>
                                <form:input  path="bookingEmail" cssClass="form-control" />  
                                <form:errors path="bookingEmail" cssClass="errform" />

                            </div>
                            <div class="form-group">                      
                                <label class="form-label">Booking Phone:(<sup style="color:red">*</sup>)</label>
                                <form:input  path="bookingPhone" cssClass="form-control" /> 
                                <form:errors path="bookingPhone" cssClass="errform" />

                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">                      
                                <label class="form-label">Adult Quantity:</label>
                                <form:input type="number" min="0" id="qttAdult" path="quantityAdult" cssClass="form-control" />     
                                <form:errors path="quantityAdult" cssClass="errform" />

                            </div>
                            <div class="form-group">                      
                                <label class="form-label">Children Quantity:(under 8 years old with 80% price of adult)</label>
                                <form:input type="number" min="0" id="qttChildren" path="quantityChildren" cssClass="form-control" />   
                                <form:errors path="quantityChildren" cssClass="errform" />

                            </div>
                            <div class="form-group">                      
                                <label class="form-label">Note:</label>
                                <form:textarea rows="2" path="note" cssClass="form-control" ></form:textarea>    
                                <form:errors path="note" cssClass="errform" />

                            </div>
                        </div>
                        <div class="col-lg-12">
                            <button style="float: left" type="submit" class=" genric-btn primary">BOOKING NOW</button>
                            <button style="float: left; margin-left: 10px" type="button" onclick="history.go(-1)" class=" genric-btn primary">BACK</button>
                            <div id="totalPrice" data-price="${packageTour.price}" style="float: right"><h3>$0.0</h3></div>
                        </div>
                    </div>                 
                </form:form>
            </div>
            <div class="col-lg-4 d-flex flex-column address-wrap">
                <div class="single-contact-address d-flex flex-row">
                    <div style="padding-bottom: 20px;" class="contact-details">
                        <img height="300" width="400" src="<c:url value="${packageTour.image}"/>" >
                    </div>
                </div>	
                <div class="single-contact-address d-flex flex-row"> 
                    <div class="icon">
                        <span class="lnr lnr-home"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Tour Name: ${packageTour.name}</h5>                        
                        <p>Tour Type: ${packageTour.tourTypeID.name}</p>
                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">  
                    <div class="icon">
                        <span class="lnr lnr-map-marker"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Area Travel:</h5>  
                        <p>${packageTour.areaID.name}</p>

                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">  
                    <div class="icon">
                        <span class="lnr lnr-pointer-right"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Price per Adult:</h5>  
                        <p>${packageTour.price}</p>

                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">    
                    <div class="icon">   
                        <span>
                            <i class="fa-solid fa-alarm-clock" style="color: #f8b600;"></i>
                            <span class="lnr lnr-clock"></span>
                        </span>
                    </div>
                    <div class="contact-details">
                        <h5>Date Start:</h5>         
                        <p>${packageTour.dateStart}</p>
                    </div>
                </div>
                <div class="single-contact-address d-flex flex-row">  
                    <div class="icon">
                        <span class="lnr lnr-checkmark-circle"></span>
                    </div>
                    <div class="contact-details">
                        <h5>Date End:</h5>         
                        <p>${packageTour.dateEnd}</p>
                    </div>
                </div>
                </di>
            </div>        
        </div>	
</section>
<!-- End booking tour-page Area -->