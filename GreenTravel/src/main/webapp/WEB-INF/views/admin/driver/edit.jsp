<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Driver/</span> Update Driver</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="driver" enctype="multipart/form-data" >
                        <form:hidden path="driverID"/>
                        <form:hidden path="status"/>
                        <form:hidden path="avatar"/>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Driver Name</label>
                            <form:input path="driverName" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="driverName" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Address</label>
                            <form:input path="address" cssClass="form-control" id="basic-default-password"    />
                            <form:errors path="address" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-firstname">Phone</label>
                            <form:input path="phone" cssClass="form-control" id="basic-default-firstname"   />
                            <form:errors path="phone" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-dateOfBirth">Driver License No</label>
                            <form:input path="driverLicenseNo" cssClass="form-control" id="basic-default-dateOfBirth" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-email">Email</label>
                            <div class="input-group input-group-merge">
                                <form:input path="email" cssClass="form-control" id="basic-default-email" aria-label="john.doe"
                                            aria-describedby="basic-default-email2"  />
                                <span class="input-group-text" id="basic-default-email2">@example.com</span>
                            </div>                      
                            <form:errors path="email" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-phone">Phone No</label>
                            <c:forEach items="${listLicense}" var="item">
                                <c:if test="${driver.class1.contains(item)}">
                                    <form:radiobutton path="class1" label="${item}" value="${item}" checked="true" />
                                </c:if>
                                <c:if test="${!driver.class1.contains(item)}">
                                    <form:radiobutton path="class1" label="${item}" value="${item}" />
                                </c:if>
                            </c:forEach>
                            <form:radiobutton path="class1" value="B1" ></form:radiobutton>
                            </div>
                            <div class="mb-3">
                                <label class="form-label" for="basic-default-avt">Image</label>
                                <div class="input-group input-group-merge">
                                    <input type="file" name="img" class="form-control"  id="basic-default-avt" />
                                </div>                      
                            <form:errors path="avatar" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-driver/home-driver" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>