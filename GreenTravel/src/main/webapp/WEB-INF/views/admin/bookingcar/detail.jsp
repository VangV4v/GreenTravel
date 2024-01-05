<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Booking Car /</span> View Booking Car</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Booking Car Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="${bookingcar.carID.image}"
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
                                <label for="firstName" class="form-label">Booking Name</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="firstName"
                                    name="firstName"
                                    value="${bookingcar.rentalName}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Booking Phone</label>
                                <input class="form-control" type="text" name="lastName" id="lastName" value="${bookingcar.rentalPhone}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="email" class="form-label">Booking E-mail</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="email"
                                    name="email"
                                    value="${bookingcar.rentalEmail}"
                                    readonly="readonly"
                                    placeholder="john.doe@example.com"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="organization" class="form-label">Price</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="organization"
                                    name="organization"
                                    value="${bookingcar.price}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label" for="phoneNumber">Booking Date</label>
                                <div class="input-group input-group-merge">
                                    <input type="text" class="form-control" readonly="readonly" value="${bookingcar.rentalDate}" />
                                </div>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="address" class="form-label">Return End</label>
                                <input type="text" class="form-control" id="address" name="address"  readonly="readonly" value="${bookingcar.returnDate}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Car Name</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${bookingcar.carID.carName}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="zipCode" class="form-label">Status</label>
                                <c:if test="${bookingcar.status == 1}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="zipCode"
                                        name="zipCode"
                                        value="Wait Confirm"
                                        readonly="readonly"
                                        />
                                </c:if>
                                <c:if test="${bookingcar.status == 2}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="zipCode"
                                        name="zipCode"
                                        value="Approve"
                                        readonly="readonly"
                                        />
                                </c:if>
                                <c:if test="${bookingcar.status == -1}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="zipCode"
                                        name="zipCode"
                                        value="Deny"
                                        readonly="readonly"
                                        />
                                </c:if>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="driver" class="form-label">Driver</label>
                                <c:if test="${bookingcar.driver}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="driver"
                                        name="zipCode"
                                        value="Yes"
                                        readonly="readonly"
                                        />
                                </c:if>
                                <c:if test="${!bookingcar.driver}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="driver"
                                        name="zipCode"
                                        value="No"
                                        readonly="readonly"
                                        />
                                </c:if>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Note</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${bookingcar.note}" />
                            </div>
                             <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Feedback</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${bookingcar.feedBack}" />
                            </div>
                             <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">Date of Feedback</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${bookingcar.dateOfFeedBack}" />
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
