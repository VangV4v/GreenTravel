<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Car</h4>
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
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0"></h5>
            <small class="text-muted float-end"><a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/employee/manage-car/create-car">Create</a></small>
        </div>
        <div class="table-responsive text-nowrap">
            <table class="table table-hover table2excel" id="table1 tableToExcel" data-tableName="Test Table 1">
                <thead>
                    <tr>
                        <th>Car Name</th>                     
                        <th>Car Type</th>
                        <th>Car Model</th>                      
                        <th>Year Issue</th>
                        <th>Air Condition</th>
                        <th>Price In Day</th>
                        <th>Image</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCar}" var="itemCar">
                        <tr>
                            <td>${itemCar.carName}</td>                        
                            <td>${itemCar.carTypeID.carTypeName}</td>
                            <td>${itemCar.carModelID.name}</td>                          
                            <td>${itemCar.yearIssure}</td>
                            <td>${itemCar.isHasAirConditioned}</td>
                            <td>${itemCar.priceInDay}</td>
                             <td>

                                <img  src="<c:url value="${itemCar.image}"/>" alt="${itemCar.image}" height="75px" width="100px" style="border-radius: 10%" >
                            </td>
                            <td>
                                <c:if test="${itemCar.status == true}">
                                    <span class="badge bg-label-primary me-1">Available</span>   
                                </c:if>
                                <c:if test="${itemCar.status == false}">
                                    <span class="badge bg-label-info me-1">On Schedule</span>   
                                </c:if>
                            </td>

                            <td>
                                <div class="dropdown">
                                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-car/view-car/${itemCar.carID}"
                                           ><i class="bx bx-info-circle me-2"></i> View</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-car/edit-car/${itemCar.carID}"
                                           ><i class="bx bx-edit-alt me-2"></i> Edit</a>
                                        <c:if test="${itemCar.status == true}">
                                            <a class="dropdown-item car__button__deleteCar" href="#"  data-id="${itemCar.carID}"><i class="bx bx-trash me-2"></i> Delete</a>
                                        </c:if>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>

              
  <script src="<c:url value="/resources/admin/jscustom/js-controller-car.js"/>"></script>
  
