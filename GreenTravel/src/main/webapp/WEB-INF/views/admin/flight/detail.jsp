<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Flight /</span> View Flight</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Flight Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <form id="formAccountSettings" method="POST" onsubmit="return false">
                        <div class="row">
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Airline</label>
                                <input
                                    class="form-control"
                                    type="text"                                  
                                    value="${flight.airlineID.name}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">From Province</label>
                                <input class="form-control" type="text" value="${flight.fromProvince.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">To Province</label>
                                <input class="form-control" type="text" value="${flight.toProvince.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Airplane Code</label>
                                <input class="form-control" type="text" value="${flight.airplaneCode}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Flight Code</label>
                                <input class="form-control" type="text" value="${flight.flightCode}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Business Price</label>
                                <input class="form-control" type="text" value="${flight.businessPrice}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Economy Price</label>
                                <input class="form-control" type="text" value="${flight.economyPrice}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Departure Date</label>
                                <input class="form-control" type="text" value="${flight.departureDate}" readonly="readonly" />
                            </div>
                           
                            <div class="mb3 col-md-6">
                                <a href="${pageContext.request.contextPath}/admin/employee/manage-flight/home-flight" class="btn btn-primary">Back</a>
                            </div>
                        </div>
                        <!-- /Account -->
                </div>

            </div>
        </div>
    </div>
