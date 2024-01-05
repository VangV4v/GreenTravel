<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Customer /</span> View Customer</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Customer Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="${cus.avatar}"
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
                                <label for="firstName" class="form-label">First Name</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="firstName"
                                    name="firstName"
                                    value="${cus.firstname}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="lastName" class="form-label">Last Name</label>
                                <input class="form-control" type="text" name="lastName" id="lastName" value="${cus.lastname}"         readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="email" class="form-label">E-mail</label>
                                <input
                                    class="form-control"
                                    type="text"
                                    id="email"
                                    name="email"
                                    value="${cus.email}"
                                    readonly="readonly"
                                    placeholder="john.doe@example.com"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="organization" class="form-label">ROLE</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="organization"
                                    name="organization"
                                    value="${cus.roleTemp}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label" for="phoneNumber">Phone Number</label>
                                <div class="input-group input-group-merge">
                                    <input type="text" class="form-control" readonly="readonly" value="${cus.phone}" />
                                </div>
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="address" class="form-label">Date of Birth</label>
                                <input type="text" class="form-control" id="address" name="address"  readonly="readonly" value="${cus.dateOfBirth}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="state" class="form-label">UserName</label>
                                <input class="form-control" type="text" id="state" name="state" readonly="readonly" value="${cus.username}" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label for="zipCode" class="form-label">Address</label>
                                <input
                                    type="text"
                                    class="form-control"
                                    id="zipCode"
                                    name="zipCode"
                                    value="${cus.address}"
                                    readonly="readonly"
                                    />
                            </div>
                            <div class="mb3 col-md-6">
                                <a href="${pageContext.request.contextPath}/admin/employee/manage-customer/home-customer" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
