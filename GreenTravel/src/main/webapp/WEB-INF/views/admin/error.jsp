<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl container-p-y">
    <div class="misc-wrapper">
        <h2 class="mb-2 mx-2">Page Not Found :(</h2>
        <p class="mb-4 mx-2">Oops! 😖 The requested URL was not found on this server.</p>
        <a href="${pageContext.request.contextPath}/admin/home" class="btn btn-primary">Back to home</a>
        <div class="mt-3">
            <img
                src="<c:url value="/resources/admin/img/illustrations/page-misc-error-light.png"/>"
                alt="page-misc-error-light"
                width="500"
                class="img-fluid"
                data-app-dark-img="illustrations/page-misc-error-dark.png"
                data-app-light-img="illustrations/page-misc-error-light.png"
                />
        </div>
    </div>
</div>