<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Role</h4>
    <!-- Hoverable Table rows -->
    <div class="card">
        <div class="table-responsive text-nowrap">
            <table class="table table-hover" id="table1">
                <thead>
                    <tr>
                        <th>Role Name</th>
                        <th>Role Description</th>
                       
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listRole}" var="itemRole">
                        <tr>
                            <td>${itemRole.roleName}</td>
                            <td>${itemRole.roleDescription}</td>
                           
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
