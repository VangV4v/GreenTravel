<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Flight/</span> Update Flight</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">               
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="flight" >
                        <form:hidden path="flightID" />
                        <form:hidden path="status" />
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Airline(<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="airlineID">
                                <form:options cssClass="form-control" items="${listAirline}" itemLabel="name" itemValue="airlineID" />
                            </form:select>
                            <form:errors path="airlineID" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">From Province(<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="fromProvinceID">
                                <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                            </form:select>
                            <form:errors path="fromProvinceID" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">To Province(<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="toProvinceID">
                                <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                            </form:select>
                            <form:errors path="toProvinceID" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">AirPlane Code(<sup style="color:red">*</sup>)</label>
                            <form:input path="airplaneCode" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="airplaneCode" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Flight Code(<sup style="color:red">*</sup>)</label>
                            <form:input path="flightCode" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="flightCode" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Business Price(<sup style="color:red">*</sup>)</label>
                            <form:input type="number" path="businessPrice" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="businessPrice" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Economy Price(<sup style="color:red">*</sup>)</label>
                            <form:input type="number" path="economyPrice" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="economyPrice" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Departure Date(<sup style="color:red">*</sup>)</label>
                            <form:input type="date" path="departureDate" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="departureDate" cssClass="errform" />
                        </div>
                       
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-flight/home-flight" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>