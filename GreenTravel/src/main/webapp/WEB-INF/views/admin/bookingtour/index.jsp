<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Booking Tour</h4>
    <c:if test="${param.success=='true'}">                                                      
        <div id="alertSuccess" style="position: absolute; top: 12px; right: 16px;" class="bs-toast toast fade show bg-success toast-placement-ex" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="toast-header">
                <i class="bx bx-bell me-2"></i>
                <div class="me-auto fw-semibold">Notification</div>
                <small>just second ago...</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                This is success process...
            </div>
        </div>
    </c:if>
    <!-- Hoverable Table rows -->
    <div class="card">      
        <div class="table-responsive text-nowrap">

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Package Name</th>
                        <th>Adult</th>             
                        <th>Children</th>   
                        <th>Customer</th>
                        <th>Status</th>                      
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBookingTour}" var="itemBookingTour">
                        <tr>
                            <td><a href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/view-packagetour/${itemBookingTour.packageTourID.packageTourID}">${itemBookingTour.packageTourID.name}</a> </td>
                            <td>${itemBookingTour.quantityAdult}</td>      
                            <td>${itemBookingTour.quantityChildren}</td> 
                            <td>${itemBookingTour.customerID.username}</td>
                            <td>                    
                                <c:if test="${itemBookingTour.status==1}">
                                    <span class="badge bg-label-warning me-1">Pending</span>   
                                </c:if>
                                <c:if test="${itemBookingTour.status==2 && itemBookingTour.packageTourID.dateStart > today}">
                                    <span class="badge bg-label-primary me-1">Approved</span>   
                                </c:if>  
                                <c:if test="${itemBookingTour.status==2 && itemBookingTour.packageTourID.dateEnd <today}">
                                    <span class="badge bg-label-success me-1">Completed</span>
                                </c:if>
                                <c:if test="${itemBookingTour.status==2 && itemBookingTour.packageTourID.dateStart <=today && itemBookingTour.packageTourID.dateEnd >=today}">
                                    <span class="badge bg-label-info me-1">On Schedule</span>
                                </c:if>
                                <c:if test="${itemBookingTour.status==-1}">
                                    <span class="badge bg-label-danger me-1">Cancel</span>   
                                </c:if>
                            </td>                         
                            <td>
                                <div class="dropdown">
                                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu">                                                                         
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-bookingtour/view-bookingtour/${itemBookingTour.bookingTourID}"
                                           ><i class="bx bx-edit-alt me-2"></i> View</a>
                                    </div>

                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
