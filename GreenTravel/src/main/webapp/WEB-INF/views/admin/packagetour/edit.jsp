<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Package Tour/</span> Update Package Tour</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="packageTour" enctype="multipart/form-data" >
                        <form:hidden path="packageTourID"/>
                        <form:hidden path="areaID"/>
                        <form:hidden path="toProvinceID"/>
                        <form:hidden path="status"/>
                        <form:hidden path="dateStart"/>
                        <form:hidden path="dateEnd"/>
                        <form:hidden path="image"/>

                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Package Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Tour Type (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="tourTypeID">
                                <form:options cssClass="form-control" items="${listTourType}" itemLabel="name" itemValue="tourTypeID" />
                            </form:select>    
                            <form:errors path="tourTypeID" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">From Province (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="fromProvinceID">
                                <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                            </form:select>     
                            <form:errors path="fromProvinceID" cssClass="errform" />
                        </div>  
                         <div class="mb-3">
                            <label class="form-label" for="basic-default-username">To Province (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="toProvinceID">
                                <form:options disabled="true" cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                            </form:select>       
                            <form:errors path="toProvinceID" cssClass="errform" />
                        </div>                         
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Start Date (<sup style="color:red">*</sup>)</label>
                            <input type="date" disabled="true" name="dateStart" value="${packageTour.dateStart}" class="form-control" />
                            <form:errors path="dateStart" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">End Date (<sup style="color:red">*</sup>)</label>
                            <input type="date" disabled="true" name="dateEnd" value="${packageTour.dateEnd}" class="form-control"/>
                            <form:errors path="dateEnd" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Package Capacity (<sup style="color:red">*</sup>)</label>
                            <input type="number" name="capacity" value="${packageTour.capacity}" class="form-control"/>
                            <form:errors path="capacity" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Package Price (<sup style="color:red">*</sup>)</label>
                            <input type="number" name="price" value="${packageTour.price}" class="form-control"/>
                            <form:errors path="price" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Description (<sup style="color:red">*</sup>)</label>
                            <form:textarea path="description" cssClass="form-control" id="basic-default-lastname" rows="5" ></form:textarea>
                            <form:errors path="description" cssClass="errform" />
                        </div>  
                       <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Local Travel Image (<sup style="color:red">*</sup>)</label>
                            <input
                                type="file" 
                                id="formFile"
                                class="form-control"
                                name="thumbnailImage"
                                accept="image/png, image/jpeg, image/jpg"
                                />    
                            <form:errors path="thumbnailImage" cssClass="errform" />
                        </div>              
                        <button type="submit" class="btn btn-primary">Update</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/home-packagetour" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
        <script src="<c:url value="/resources/admin/jscustom/js-controller-packagetour.js"/>"></script>
