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
                    My Booking Car				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/customer/my-booking-car"> My Booking Car</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->	

<!-- Start destinations Area -->
<section class="destinations-area section-gap">
    <div class="container mt-6 mb-7">
        <div class="row justify-content-center">
            <div class="col-lg-12 col-xl-7">
                <div class="card">
                    <div class="card-body p-5">
                        <h2>
                            Hey ${bookingcar.customerID.firstname} ${bookingcar.customerID.lastname},
                        </h2>
                        <p class="fs-sm">
                            This is the receipt for a payment of <strong>$${bookingcar.price}$</strong> you made to Spacial Themes.
                        </p>

                        <div class="border-top border-gray-200 pt-4 mt-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Payment No.</div>
                                    <strong>#${bookingcar.bookingCarID}</strong>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Date</div>
                                    <strong>${bookingcar.rentalDate} to ${bookingcar.returnDate}</strong>
                                </div>
                            </div>
                        </div>

                        <div class="border-top border-gray-200 mt-4 py-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Customer</div>
                                    <strong>
                                        ${bookingcar.rentalName}
                                    </strong>
                                    <p class="fs-sm">
                                        ${bookingcar.rentalAddress}
                                        <br/>
                                        ${bookingcar.rentalPhone}
                                        <br>
                                        <a href="#!" class="text-purple">${bookingcar.rentalEmail}
                                        </a>
                                    </p>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Payment To</div>
                                    <strong>
                                        Green Travel co.,ltd
                                    </strong>
                                    <p class="fs-sm">
                                        10th Hoa Binh Street, Ninh Kieu District, Can Tho City
                                        <br>
                                        <a href="#!" class="text-purple">greentravel.info@gmail.com
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <table class="table border-bottom border-gray-200 mt-3">
                            <thead>
                                <tr>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Description</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Image</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Amount</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="px-0">Name :${bookingcar.carID.carName},Model :${bookingcar.carID.carModelID.name}</td>
                                    <td class="px-0"><img src="${bookingcar.carID.carImagesList.get(0).image}" width="100px" class="img-thumbnail" /></td>
                                    <td class="text-end px-0">$${bookingcar.carID.priceInDay}</td>
                                </tr>
                            </tbody>
                        </table>
                        <c:if test="${bookingcar.driver}">
                            <table class="table border-bottom border-gray-200 mt-3">
                                <thead>
                                    <tr>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Driver Name</th>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Address</th>
                                        <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Image</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="px-0">${bookingcar.driverInBookingCarsList.get(0).driverID.driverName}</td>
                                        <td class="px-0">${bookingcar.driverInBookingCarsList.get(0).driverID.address}</td>
                                        <td class="text-end px-0"><img src="${bookingcar.driverInBookingCarsList.get(0).driverID.avatar}" width="100px" alt="alt"/></td>
                                    </tr>
                                </tbody>
                            </table>
                        </c:if>
                        <div class="mt-5">
                            <div class="d-flex justify-content-end">
                                <p class="text-muted me-3">Subtotal:</p>
                                <span>$${bookingcar.price}</span>
                            </div>
                            <div class="d-flex justify-content-end">
                                <p class="text-muted me-3">Discount:</p>
                                <span>-$0.00</span>
                            </div>
                            <div class="d-flex justify-content-end mt-3">
                                <h5 class="me-3">Total:</h5>
                                <h5 class="text-success">$${bookingcar.price} USD</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- End destinations Area -->