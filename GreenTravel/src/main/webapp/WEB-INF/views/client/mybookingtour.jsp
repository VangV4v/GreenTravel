<%-- 
    Author     : kyqua
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- start banner Area -->
<section class="about-banner relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    My Booking Tour				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/customer/my-booking-tour"> My Booking Tour</a></p>
            </div>	
        </div>
    </div>
</section>
<c:if test="${param.success=='true'}">    
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
    <script>
        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Your booking has been submited',
            showConfirmButton: false,
            timer: 2000
        })
    </script>
</c:if>
<!-- End banner Area -->

<!-- Start Align Area -->
<div class="whole-wrap">
    <div class="container">
        <div style="margin-top: 50px" class="table-responsive">
            <table class="table  table-hover table-striped ">
                <thead>
                    <tr>
                        <th>Booking Date</th>
                        <th>Package Name</th>
                        <th>Booking Name</th>

                        <th>Adult Quantity</th>
                        <th>Children Quantity</th>

                        <th>Total Price</th>                      
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBookingTour}" var="itemBookingTour">
                        <tr>
                            <td>${itemBookingTour.bookDate}</td>
                            <td><a href="${pageContext.request.contextPath}/packagetour/detail/${itemBookingTour.packageTourID.packageTourID}">${itemBookingTour.packageTourID.name}</a></td>
                            <td>${itemBookingTour.bookingName}</td>

                            <td>${itemBookingTour.quantityAdult}

                            </td>
                            <td> ${itemBookingTour.quantityChildren}</td>
                            <td>${itemBookingTour.totalPrice}</td>                        
                            <td>
                                <c:if test="${itemBookingTour.status == 1}">
                                    Waiting Confirm
                                </c:if>
                                <c:if test="${itemBookingTour.status == 2}">
                                    Approved<br/>
                                    <a href="#" type="button" data-toggle="modal" data-target="#exampleModal">
                                        QR Here
                                    </a>
                                </c:if>
                                <c:if test="${itemBookingTour.status == -1}">
                                    Denied  
                                </c:if>
                            </td>
                            <td>
                                <c:set value="${today}" var="today" />
                                <c:if test="${itemBookingTour.status == 1 && itemBookingTour.packageTourID.dateStart.after(today) }">
                                    <button type="button" data-id="${itemBookingTour.bookingTourID}" class="genric-btn primary mybookingtour__button__stopBookingTour">Cancel Booking</button> 
                                </c:if>
                                <c:if test="${itemBookingTour.status == 2 && itemBookingTour.packageTourID.dateEnd.before(today) && itemBookingTour.feedBack==null }">
                                    <button type="button" data-id="${itemBookingTour.bookingTourID}" class="genric-btn primary mybookingtour__button__sendFeedbackBookingTour">Send Feedback</button> 
                                </c:if>
                            </td>
                        </tr>
                        <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">QR here</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <img width="50%" height="50%" style="margin-left: 25%" src="${pageContext.request.contextPath}/customer/qr-my-booking-tour/${itemBookingTour.bookingTourID}" width="100px" alt="alt"/>
                                    <div style="text-align: center">
                                        <a href="${pageContext.request.contextPath}/customer/qr-my-booking-tour/${itemBookingTour.bookingTourID}" download="qr.jpg">Download now </a>
                                    </div>
                                </div>                              
                            </div>
                        </div>
                    </div> 
                </c:forEach>
                </tbody>
            </table>
        </div>     
    </div>
</div>
