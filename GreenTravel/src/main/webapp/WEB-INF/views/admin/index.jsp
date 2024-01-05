<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <div class="row">
        <div class="col-lg-8 mb-4 order-0">
            <div class="card">
                <div class="d-flex align-items-end row">
                    <div class="col-sm-7">
                        <div class="card-body">
                            <h5 class="card-title text-primary">Congratulations ${sessionScope['authen'].username}! 🎉</h5>
                            <p class="mb-4">
                                You have done <span class="fw-bold">100%</span> more sales today. Check your new badge in
                                your request booking.
                            </p>                         
                        </div>
                    </div>
                    <div class="col-sm-5 text-center text-sm-left">
                        <div class="card-body pb-0 px-0 px-md-4">
                            <img
                                src="<c:url value="/resources/admin/img/illustrations/man-with-laptop-light.png"/>"
                                height="140"
                                alt="View Badge User"
                                data-app-dark-img="illustrations/man-with-laptop-dark.png"
                                data-app-light-img="illustrations/man-with-laptop-light.png"
                                />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-4 col-md-4 order-1">
            <div class="row">
                <div class="col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img src="https://img.freepik.com/premium-vector/customer-service-icon-vector-full-customer-care-service-hand-with-persons-vector-illustration_399089-2810.jpg?w=2000" alt="Credit Card" class="rounded" />
                                </div>
                            </div>
                            <span class="fw-semibold d-block mb-1">Customers</span>
                            <h3 class="card-title text-nowrap mb-2">${totalCus}</h3>
                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in total</small>
                        </div>
                    </div>
                </div>
                <div class="col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img src="<c:url value="/resources/admin/img/icons/unicons/cc-primary.png"/>" alt="Credit Card" class="rounded" />
                                </div>
                            </div>
                            <span class="fw-semibold d-block mb-1">Transactions</span>
                            <h3 class="card-title mb-2">${totalTran}</h3>
                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in total</small>

                        </div>
                    </div>
                </div>   

            </div>
        </div>    
        <div class="col-12 col-lg-8 order-2 order-md-3 order-lg-2 mb-4">

            <div class="row row-bordered g-0">
                <div class="col-md-6">
                    <div class="row">
                        <div class="col-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="card-title d-flex align-items-start justify-content-between">
                                        <div class="avatar flex-shrink-0">
                                            <img src="<c:url value="/resources/admin/img/icons/unicons/cc-primary.png"/>" alt="Credit Card" class="rounded" />
                                        </div>
                                    </div>
                                    <span class="fw-semibold d-block mb-1">Booking Car</span>
                                    <h3 class="card-title text-nowrap mb-2">${countBookingCar}</h3>
                                    <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in day</small>
                                </div>
                            </div>
                        </div>
                        <div class="col-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="card-title d-flex align-items-start justify-content-between">
                                        <div class="avatar flex-shrink-0">
                                            <img src="<c:url value="/resources/admin/img/icons/unicons/cc-primary.png"/>" alt="Credit Card" class="rounded" />
                                        </div>
                                    </div>
                                    <span class="fw-semibold d-block mb-1">Booking Tour</span>
                                    <h3 class="card-title mb-2">${countBookingTour}</h3>
                                    <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in day</small>

                                </div>
                            </div>
                        </div>   

                    </div>
                </div>
                <div class="col-md-6">

                    <div class="row">
                        <div class="col-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="card-title d-flex align-items-start justify-content-between">
                                        <div class="avatar flex-shrink-0">
                                            <img src="<c:url value="/resources/admin/img/icons/unicons/cc-primary.png"/>" alt="Credit Card" class="rounded" />
                                        </div>
                                    </div>
                                    <span class="fw-semibold d-block mb-1">Tour</span>
                                    <h3 class="card-title text-nowrap mb-2">${countBookingTourByDate}</h3>
                                    <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>on schedule</small>
                                </div>
                            </div>
                        </div>
                        <div class="col-6 mb-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="card-title d-flex align-items-start justify-content-between">
                                        <div class="avatar flex-shrink-0">
                                            <img src="<c:url value="/resources/admin/img/icons/unicons/cc-primary.png"/>" alt="Credit Card" class="rounded" />
                                        </div>
                                    </div>
                                    <span class="fw-semibold d-block mb-1">Car</span>
                                    <h3 class="card-title mb-2">${countBookingCarByDate}</h3>
                                    <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>on schedule</small>

                                </div>
                            </div>
                        </div>   

                    </div>

                </div>
            </div>

        </div>
        <div class="col-12 col-md-8 col-lg-4 order-3 order-md-2">

            <div class="row">
                <div class="col-lg-6 col-md-12 col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img
                                        src="<c:url value="/resources/admin/img/icons/unicons/wallet-info.png"/>"
                                        alt="Credit Card"
                                        class="rounded"
                                        />
                                </div>
                            </div>
                            <span>Revenue Car</span>
                            <h3 class="card-title text-nowrap mb-1">$${saleBkc}</h3>
                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in day</small>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-12 col-6 mb-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-title d-flex align-items-start justify-content-between">
                                <div class="avatar flex-shrink-0">
                                    <img
                                        src="<c:url value="/resources/admin/img/icons/unicons/wallet-info.png"/>"
                                        alt="Credit Card"
                                        class="rounded"
                                        />
                                </div>
                            </div>
                            <span>Revenue Tour</span>
                            <h3 class="card-title text-nowrap mb-1">$${saleBkt}</h3>
                            <small class="text-success fw-semibold"><i class="bx bx-up-arrow-alt"></i>in day</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>                   
</div>

<div class="container-xxl flex-grow-1 container-p-y">
    <!-- Basic Bootstrap Table -->
    <div class="card">
        <h5 class="card-header">Top New Booking Car</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Car Name</th>
                        <th>Car Image</th>
                        <th>Rental Date</th>
                        <th>Return Date</th>
                        <th>Booking Name</th>
                    </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                    <c:forEach items="${listBkc}" var="itemBkc" begin="0" step="1" end="4">
                        <tr>
                            <td><strong>${itemBkc.customerID.username}</strong></td>

                            <td>${itemBkc.carID.carName}</td>
                            <td>
                                <img  src="<c:url value="${itemBkc.carID.image}"/>" alt="" height="35px" width="50px" style="border-radius: 10%" >
                            </td>
                            <td>${itemBkc.rentalDate}</td>
                            <td>${itemBkc.returnDate}</td>
                            <td>${itemBkc.rentalName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>  
</div>
<div class="container-xxl flex-grow-1 container-p-y">
    <!-- Basic Bootstrap Table -->
    <div class="card">
        <h5 class="card-header">Top New Booking Tour</h5>
        <div class="table-responsive text-nowrap">
            <table class="table">
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Booking Date</th>
                        <th>Package Image</th>
                        <th>Package Name</th>
                        <th>Date Start</th>
                        <th>Booking Name</th>

                    </tr>
                </thead>
                <tbody class="table-border-bottom-0">
                    <c:forEach items="${listBkt}" var="itemBkt" begin="0" step="1" end="4">
                        <tr>
                            <td> <strong>${itemBkt.customerID.username}</strong></td>
                            <td>${itemBkt.bookDate}</td>
                            <td>${itemBkt.packageTourID.name}</td>
                            <td>
                                <img  src="<c:url value="${itemBkt.packageTourID.image}"/>" alt="" height="35px" width="50px" style="border-radius: 10%" >
                            </td>
                            <td>${itemBkt.packageTourID.dateStart}</td>
                            <td>${itemBkt.bookingName}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>