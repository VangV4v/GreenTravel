<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Driver /</span> View Driver</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Driver Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="${driver.avatar}"
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
                                <label for="firstName" class="form-label">Driver Name</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="firstName"
                                    name="firstName"
                                    value="${driver.driverName}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Address</label>
                                <input class="form-control" type="text" name="lastName" id="lastName" value="${driver.address}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="email" class="form-label">E-mail</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="email"
                                    name="email"
                                    value="${driver.email}"
                                    readonly="readonly"
                                    placeholder="john.doe@example.com"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="organization" class="form-label">Driver License No</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="organization"
                                    name="organization"
                                    value="${driver.driverLicenseNo}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label" for="phoneNumber">Phone Number</label>
                                <div class="input-group input-group-merge">
                                    <input type="text" class="form-control" readonly="readonly" value="${driver.phone}" />
                                </div>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="address" class="form-label">Class</label>
                                <input type="text" class="form-control" id="address" name="address"  readonly="readonly" value="${driver.class1}" />
                            </div>
                            <div class="mb3 col-md-6">
                                <a href="${pageContext.request.contextPath}/admin/employee/manage-driver/home-driver" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
