<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Booking Tour /</span> View Booking Tour</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Booking Tour Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="<c:url value="${bookingTour.packageTourID.image}"/>"
                            alt="user-avatar"
                            class="d-block rounded"
                            height="100"
                            width="100"
                            id="uploadedAvatar"
                            />                       
                    </div>
                </div>
                <hr class="my-0" />
                <div class="card-body">
                    <form id="formAccountSettings" method="POST" onsubmit="return false">
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label for="firstName" class="form-label">Package Name</label>
                                <input
                                    class="form-control"
                                    type="text"                                  
                                    value="${bookingTour.packageTourID.name}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Start Date</label>
                                <input class="form-control" type="text" value="${bookingTour.packageTourID.dateStart}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">End Date</label>
                                <input class="form-control" type="text" value="${bookingTour.packageTourID.dateEnd}" readonly="readonly" />
                            </div>
                             <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Area</label>
                                <input class="form-control" type="text" value="${bookingTour.packageTourID.areaID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Tour Type</label>
                                <input class="form-control" type="text" value="${bookingTour.packageTourID.tourTypeID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Price per Person</label>
                                <input class="form-control" type="text" value="${bookingTour.packageTourID.price}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Customer Account</label>
                                <input class="form-control" type="text" value="${bookingTour.customerID.username}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Booking Name</label>
                                <input class="form-control" type="text" value="${bookingTour.bookingName}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Booking Email</label>
                                <input class="form-control" type="text" value="${bookingTour.bookingEmail}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Booking Phone</label>
                                <input class="form-control" type="text" value="${bookingTour.bookingPhone}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Adult Quantity</label>
                                <input class="form-control" type="text" value="${bookingTour.quantityAdult}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Children Quantity</label>
                                <input class="form-control" type="text" value="${bookingTour.quantityChildren}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Note for Tour</label>
                                <textarea rows="3" class="form-control" type="text" readonly="readonly" >${bookingTour.note}</textarea>
                            </div>
                             <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Date of Feedback</label>
                                <input class="form-control" type="text" readonly="readonly" value="${bookingTour.dateOfFeedback}" />
                            </div>
                             <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Feedback</label>
                                <textarea rows="3" class="form-control" readonly="readonly" >${bookingTour.feedBack}</textarea>
                            </div>
                            <div class="mb3 col-md-6">
                                <a href="#" onclick="history.go(-1)" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
