<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span>Booking Car</h4>
    <!-- Hoverable Table rows -->
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0"></h5>         
        </div>
        <div class="table-responsive text-nowrap">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Booking Date</th>
                        <th>Return Date</th>
                        <th>Booking Name</th>                                          
                        <th>Price</th>
                        <th>Car Name</th>
                        <th>Image Car</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listBookingCar}" var="item">
                        <tr>
                            <td>${item.rentalDate}</td>
                            <td>${item.returnDate}</td>
                            <td>${item.rentalName}</td>                                             
                            <td>${item.price}</td>
                            <td><a href="${pageContext.request.contextPath}/admin/employee/manage-car/view-car/${item.carID.carID}">${item.carID.carName}</a> </td>
                            <td><img src="${item.carID.image}" width="100px" height="75px" style="border-radius: 10%" alt="alt"/></td>
                            <td>
                                <c:if test="${item.status == 1}">
                                    <span class="badge bg-label-warning me-1">Pending</span>   
                                </c:if>
                                <c:if test="${item.status == 2}">
                                    <span class="badge bg-label-primary me-1">Approved</span>   
                                </c:if>
                                <c:if test="${item.status == -1}">
                                    <span class="badge bg-label-danger me-1">Cancel</span>   
                                </c:if>
                            </td>
                            <td>
                                 <div class="dropdown">
                                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu">                                      
                                       
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-bookingcar/view-bookingcar/${item.bookingCarID}"
                                           ><i class="bx bx- me-2"></i> View</a>
                                    </div>
                                </div>
                               
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
           
        </div>
    </div>
         

        <script src="<c:url value="/resources/admin/jscustom/js-controller-bookingcar.js"/>"></script>
