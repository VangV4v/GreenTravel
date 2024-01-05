<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Customer</h4>
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
            <small class="text-muted float-end"><a class="btn btn-primary" href="${pageContext.request.contextPath}/admin/employee/manage-customer/create-customer">Create</a></small>
        </div>
        <div class="table-responsive text-nowrap">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>User Name</th>
                        <th>Email</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Date of birth</th>
                        <th>Phone</th>
                        <th>Avatar</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listCus}" var="itemCus">
                        <tr>
                            <td>${itemCus.username}</td>
                            <td>${itemCus.email}</td>
                            <td>${itemCus.firstname}</td>
                            <td>${itemCus.lastname}</td>
                            <td>${itemCus.dateOfBirth}</td>
                            <td>${itemCus.phone}</td>
                            <td><img src="${itemCus.avatar}" class="img-thumbnail" height="75px" width="100px" style="border-radius: 10%"  alt="${itemCus.avatar}"/></td>
                            <td>
                                <div class="dropdown">
                                    <button type="button" class="btn p-0 dropdown-toggle hide-arrow" data-bs-toggle="dropdown">
                                        <i class="bx bx-dots-vertical-rounded"></i>
                                    </button>
                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-customer/view-customer/${itemCus.customerID}"
                                           ><i class="bx bx-info-circle me-2"></i> View</a>
                                        <a class="dropdown-item" href="${pageContext.request.contextPath}/admin/employee/manage-customer/edit-customer/${itemCus.customerID}"
                                           ><i class="bx bx-edit-alt me-2"></i> Edit</a>
                                        <a class="dropdown-item customer__button__deleteCustomer" href="#"  data-id="${itemCus.customerID}"><i class="bx bx-trash me-2"></i> Delete</a>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
          
        </div>
    </div>
             

        <script src="<c:url value="/resources/admin/jscustom/js-controller-customer.js"/>"></script>
