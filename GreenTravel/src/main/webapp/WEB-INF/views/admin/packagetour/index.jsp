<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Package Tour</h4>
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
            <small class="text-muted float-end"><a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/create-packagetour">Create</a></small>
        </div>
        <div class="table-responsive text-nowrap">

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Package Name</th>
                        <th>From Province</th>
                        <th>To Province</th>
                        <th>Area</th>                                    
                        <th>Image</th>
                        <th>Status</th>                      
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listPackageTour}" var="itemPackageTour">
                        <tr>
                            <td>${itemPackageTour.name}</td>
                            <td>${itemPackageTour.fromProvinceID.name}</td>  
                            <td>${itemPackageTour.toProvinceID.name}</td>  
                            <td>${itemPackageTour.areaID.name}</td>                              
                             <td>

                                <img  src="<c:url value="${itemPackageTour.image}"/>" alt="${itemPackageTour.image}" height="75px" width="100px" style="border-radius: 10%" >
                            </td>
                            <td> 
                                <c:if test="${itemPackageTour.status==1}">
                                    <span class="badge bg-label-warning me-1">Pending</span>
                                </c:if>
                                <c:if test="${itemPackageTour.status==2 && itemPackageTour.dateStart > today}">
                                    <span class="badge bg-label-primary me-1">Active</span> 
                                </c:if>
                                <c:if test="${itemPackageTour.status==2 && itemPackageTour.dateEnd < today}">
                                    <span class="badge bg-label-success me-1">Completed</span>
                                </c:if>
                                <c:if test="${itemPackageTour.status==2 && itemPackageTour.dateStart <=today && itemPackageTour.dateEnd >=today}">
                                    <span class="badge bg-label-info me-1">On Schedule</span>
                                </c:if>
                            </td>                         
                            <td>
                                <div class="dropdown">
                                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu">
                                        <c:if test="${itemPackageTour.status==1}">
                                            <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/create-tour/${itemPackageTour.packageTourID}"
                                               ><i class="bx bx-plus-circle me-2"></i>Create Tour</a>
                                        </c:if>                                     
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/view-packagetour/${itemPackageTour.packageTourID}"
                                           ><i class="bx bx-info-circle me-2"></i> View</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/edit-packagetour/${itemPackageTour.packageTourID}"
                                           ><i class="bx bx-edit-alt me-2"></i> Edit</a>
                                        <c:if test="${itemPackageTour.status==2 && itemPackageTour.dateEnd < today || itemPackageTour.status==1 }">
                                            <a class="dropdown-item packageTour__button__deletePackageTour" href="#"  data-id="${itemPackageTour.packageTourID}"
                                               ><i class="bx bx-trash me-2"></i> Delete</a>
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

        <script src="<c:url value="/resources/admin/jscustom/js-controller-packagetour.js"/>"></script>
