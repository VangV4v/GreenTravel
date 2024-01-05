<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Hotel /</span> View Hotel</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Restaurant Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="<c:url value="${restaurant.image}"/>"
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
                                <label class="form-label">Restaurant Name</label>
                                <input
                                    class="form-control"
                                    type="text"                                  
                                    value="${restaurant.name}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Url</label>
                                <input class="form-control" type="text" value="${restaurant.url}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Rate Star</label>
                                <input class="form-control" type="text" value="${restaurant.rateStar}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Destination</label>
                                <input class="form-control" type="text" value="${restaurant.destinationID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Description</label>
                                <textarea class="form-control" rows="5" value="${restaurant.description}" readonly="readonly" > ${restaurant.description}</textarea>
                            </div>
                            <div class="mb3 col-md-6">
                                <a href="${pageContext.request.contextPath}/admin/employee/manage-restaurant/home-restaurant" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
