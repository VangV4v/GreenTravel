<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Car/</span> Create Car</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="car" enctype="multipart/form-data" >
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Car Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="carName" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="carName" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-password">Seat (<sup style="color:red">*</sup>)</label>
                            <form:input path="seat" cssClass="form-control" id="basic-default-password"   />
                            <form:errors path="seat" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-model">Car Model (<sup style="color:red">*</sup>)</label>
                            <form:select path="carModelID" id="basic-default-model" cssClass="form-control">
                                <form:options items="${listCarModel}" itemValue="carModelID" itemLabel="name"  />
                            </form:select>
                            <form:errors path="carModelID" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-type">Car Type (<sup style="color:red">*</sup>)</label>
                            <form:select path="carTypeID" id="basic-default-type" cssClass="form-control">
                                <form:options items="${listCarType}" itemValue="carTypeID" itemLabel="carTypeName"  />
                            </form:select>
                            <form:errors path="carTypeID" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-firstname">Gearbox (<sup style="color:red">*</sup>)</label>
                            <form:input path="gearbox" cssClass="form-control" id="basic-default-firstname"   />
                            <form:errors path="gearbox" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Feature (<sup style="color:red">*</sup>)</label>
                            <form:input path="fearure" cssClass="form-control" id="basic-default-lastname"   />
                            <form:errors path="fearure" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-dateOfBirth">Year Issue (<sup style="color:red">*</sup>)</label>
                            <form:input path="yearIssure" cssClass="form-control" id="basic-default-dateOfBirth"   />
                            <form:errors path="yearIssure" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-price">Price In Day (<sup style="color:red">*</sup>)</label>
                            <form:input path="priceInDay" cssClass="form-control" id="basic-default-price"   />
                            <form:errors path="priceInDay" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-phone">Air Conditioned (<sup style="color:red">*</sup>)</label>
                            <div class="form-control">
                                <form:radiobutton path="isHasAirConditioned" label="Yes" value="true" />
                                <form:radiobutton path="isHasAirConditioned" label="No" value="no" />
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-avt">Image (<sup style="color:red">*</sup>)</label>
                            <input type="file" id="upload"  class="account-file-input form-control"  name="image" required="true"
                                   accept="image/png, image/jpeg, image/jpg" />
                            <form:errors path="isHasAirConditioned" cssClass="errform" />
                        </div>
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-car/home-car" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>