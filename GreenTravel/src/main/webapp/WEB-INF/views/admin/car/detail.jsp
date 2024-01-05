<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Car /</span> View Car</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Car Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="${car.image}"
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
                                <label for="firstName" class="form-label">Car Name</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="firstName"
                                    name="firstName"
                                    value="${car.carName}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Type Name</label>
                                <input class="form-control" type="text" name="lastName" id="lastName" value="${car.carTypeID.carTypeName}"         readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="email" class="form-label">Model Name</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="email"
                                    name="email"
                                    value="${car.carModelID.name}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="organization" class="form-label">Seat</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="organization"
                                    name="organization"
                                    value="${car.seat}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label" for="phoneNumber">Gearbox</label>
                                <div class="input-group input-group-merge">
                                    <input type="text" class="form-control" readonly="readonly" value="${car.gearbox}" />
                                </div>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="address" class="form-label">Feature</label>
                                <input type="text" class="form-control" id="address" name="address"  readonly="readonly" value="${car.fearure}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">YearIssure</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${car.yearIssure}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="zipCode" class="form-label">Price In Day</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="zipCode"
                                    name="zipCode"
                                    value="${car.priceInDay}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="air" class="form-label">AirCondition</label>
                                <c:if test="${car.isHasAirConditioned == true}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="air"
                                        name="air"
                                        value="Avaiable"
                                        readonly="readonly"
                                        />
                                </c:if> 
                                <c:if test="${car.isHasAirConditioned != true}">
                                    <input
                                        type="text"
                                        class="form-control"
                                        id="air"
                                        name="air"
                                        value="Unavaiable"
                                        readonly="readonly"
                                        />
                                </c:if> 

                            </div>
                            <div class="mb3 col-md-6">
                                <a href="${pageContext.request.contextPath}/admin/employee/manage-car/home-car" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
