<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span>Request Booking Car</h4>
    <!-- Hoverable Table rows -->
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0"></h5>        
        </div>
        <div class="table-responsive text-nowrap">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Booking Date</th>
                        <th>Return Date</th>
                        <th>Booking Name</th>
                        <th>Car Name</th>
                        <th>Total Price</th>
                        <th>Driver</th>                     
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBookingCar}" var="itemBookingCar">
                        <c:if test="${itemBookingCar.status == 1}">
                            <tr>
                                <td>${itemBookingCar.rentalDate}</td>
                                <td>${itemBookingCar.returnDate}</td>
                                <td>${itemBookingCar.rentalName}</td>                          
                                <td><a href="${pageContext.request.contextPath}/admin/employee/manage-car/view-car/${itemBookingCar.carID.carID}">${itemBookingCar.carID.carName}</a> </td>
                                <td>${itemBookingCar.price}</td>
                                <td>
                                    <c:if test="${itemBookingCar.driver}">
                                        Yes
                                    </c:if>
                                    <c:if test="${!itemBookingCar.driver}">
                                        No
                                    </c:if>
                                </td>                              
                                <td>
                                    <div class="dropdown">
                                        <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                            <i class="bx bx-dots-vertical-rounded"></i>
                                        </button>
                                        <div class="dropdown-menu">                                    
                                            <a class="dropdown-item bookingcar__button__confirmBooking" href="#"  data-id="${itemBookingCar.bookingCarID}"
                                               ><i class="bx bx-edit-alt me-2"></i>Confirm</a>                                                                  
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-bookingcar/view-bookingcar/${itemBookingCar.bookingCarID}"
                                               ><i class="bx bx- me-2"></i> View</a>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                        </c:if>

                    </c:forEach>
                </tbody>
            </table>        
        </div>
    </div>


    <script src="<c:url value="/resources/admin/jscustom/js-controller-bookingcar.js"/>"></script>