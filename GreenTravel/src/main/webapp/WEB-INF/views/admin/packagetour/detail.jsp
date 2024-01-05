<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Package Tour /</span> View Package Tour</h4>
    <div class="row">
        <div class="col-md-12">

            <div class="card mb-4">
                <h5 class="card-header">Package Tour Details</h5>
                <!-- Account -->
                <div class="card-body">
                    <div class="d-flex align-items-start align-items-sm-center gap-4">
                        <img
                            src="<c:url value="${packageTour.image}"/>"
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
                                <label class="form-label">Package Name</label>
                                <input
                                    class="form-control"
                                    type="text"                                  
                                    value="${packageTour.name}"
                                    readonly="readonly"
                                    autofocus
                                    />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">From Province</label>
                                <input class="form-control" type="text" value="${packageTour.fromProvinceID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">To Province</label>
                                <input class="form-control" type="text" value="${packageTour.toProvinceID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Area</label>
                                <input class="form-control" type="text" value="${packageTour.areaID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Tour Type</label>
                                <input class="form-control" type="text" value="${packageTour.tourTypeID.name}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Date Start</label>
                                <input class="form-control" type="text" value="${packageTour.dateStart}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Date End</label>
                                <input class="form-control" type="text" value="${packageTour.dateEnd}" readonly="readonly" />
                            </div>                                                  
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Capacity</label>
                                <input class="form-control" type="text" value="${packageTour.capacity}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Price per Person</label>
                                <input class="form-control" type="text" value="${packageTour.price}" readonly="readonly" />
                            </div>
                            <div class="mb-3 col-md-6">
                                <label class="form-label">Description</label>
                                <textarea class="form-control" rows="5" value="${packageTour.description}" readonly="readonly" > ${packageTour.description}</textarea>
                            </div>

                        </div>
                        <!-- /Account -->
                </div>
            </div>
            <c:forEach items="${packageTour.toursList}" var="itemTour">
                <div class="card mb-4">
                    <h5 class="card-header"><strong>${itemTour.schedule}</strong> / ${itemTour.visitDate}
                        <div style="float: right">
                            <a href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/edit-tour/${itemTour.tourID}" class="btn btn-primary" style="float: right">Update Tour</a>   
                        </div>
                    </h5>

                    <div class="card-body">
                        <form id="formAccountSettings" method="POST" onsubmit="return false">
                            <div class="row">
                                <div class="mb-3 col-md-6">
                                    <label class="form-label">Tour Name</label>
                                    <input
                                        class="form-control"
                                        type="text"                                  
                                        value="${itemTour.name}"
                                        readonly="readonly"
                                        autofocus
                                        />
                                </div>
                                <div class="mb-3 col-md-6">
                                    <label class="form-label">Destination</label>
                                    <input class="form-control" type="text" value="${itemTour.destinationID.name}" readonly="readonly" />
                                </div>                                                                                                                                                                            
                                <div class="mb-3 col-md-6">
                                    <label class="form-label">Description</label>
                                    <textarea class="form-control" rows="5" value="${itemTour.description}" readonly="readonly" > ${itemTour.description}</textarea>
                                </div>
                                <div class="mb-3 col-md-6">
                                    <label class="form-label">Note</label>
                                    <textarea class="form-control" rows="5" value="${itemTour.note}" readonly="readonly" > ${itemTour.note}</textarea>
                                </div>
                            </div>
                            <!-- /Account -->
                    </div>
                    <hr class="my-0" />
                    <!-- Tour -->
                    <div class="card-body">
                        <h6 class="card-header">Local Travel</h6>
                        <c:forEach items="${itemTour.localTravelInToursList}" var="itemLT">
                            <div style="margin-bottom: 20px" class="d-flex align-items-start align-items-sm-center gap-4">                       
                                <img
                                    src="<c:url value="${itemLT.localTravelID.image}"/>"
                                    alt="user-avatar"
                                    class="d-block rounded"
                                    height="100"
                                    width="100"
                                    id="uploadedAvatar"
                                    />
                                <div class="button-wrapper">
                                    <p><strong> ${itemLT.localTravelID.name}</strong></p>                                                                                           
                                    <p>${itemLT.localTravelID.description}</p>                            
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <hr class="my-0" />
                    <div class="card-body">
                        <h6 class="card-header">Restaurant</h6>
                        <div class="d-flex align-items-start align-items-sm-center gap-4">
                            <img
                                src="<c:url value="${itemTour.restaurantID.image}"/>"
                                alt="user-avatar"
                                class="d-block rounded"
                                height="100"
                                width="100"
                                id="uploadedAvatar"
                                />
                            <div class="button-wrapper">
                                <p><strong>${itemTour.restaurantID.name}</strong> 
                                    <c:forEach begin="1" end="${itemTour.restaurantID.rateStar}" step="1" var="star">                                          
                                        <i class="fa fa-solid fa-star" style="color: #ffa500;"></i>
                                    </c:forEach>    
                                  </p>                                                                                        
                                <p>${itemTour.restaurantID.description}</p>
                                <p class="text-muted mb-0"><a href="${itemTour.restaurantID.url}">Go to link<a/></p>
                            </div>
                        </div>
                    </div>
                    <hr class="my-0" />
                    <div class="card-body">
                        <h6 class="card-header">Hotel</h6>
                        <div class="d-flex align-items-start align-items-sm-center gap-4">
                            <img
                                src="<c:url value="${itemTour.hotelID.image}"/>"
                                alt="user-avatar"
                                class="d-block rounded"
                                height="100"
                                width="100"
                                id="uploadedAvatar"
                                />
                            <div class="button-wrapper">
                                <p><strong>${itemTour.hotelID.name}</strong> 
                                    <c:forEach begin="1" end="${itemTour.hotelID.rateStar}" step="1" var="star">
                                         <i class="fa fa-solid fa-star" style="color: #ffa500;"></i>                             
                                    </c:forEach>    
                                </p>                                                                                           
                                <p>${itemTour.hotelID.description}</p>
                                <p class="text-muted mb-0"><a href="${itemTour.hotelID.url}">Go to link</a> </p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <a href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/home-packagetour" class="btn btn-primary">Back</a>
        </div>
    </div>
