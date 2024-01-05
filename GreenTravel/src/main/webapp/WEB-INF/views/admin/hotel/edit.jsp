<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Hotel/</span> Update Hotel</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">               
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="hotel" enctype="multipart/form-data">
                        <form:hidden path="hotelID"/>
                        <form:hidden path="image"/>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Hotel Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Hotel Url</label>
                            <form:input path="url" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="url" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Rate Star (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="rateStar">
                                <c:forEach items="${mapRateStar.entrySet()}" var="map">
                                    <form:option cssClass="form-control" label="${map.getValue()}" value="${map.getKey()}"></form:option>
                                </c:forEach>                            
                            </form:select>
                            <form:errors path="rateStar" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Destination (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="destinationID">
                                <form:options cssClass="form-control" items="${listDestination}" itemLabel="name" itemValue="destinationID" />
                            </form:select>
                            <form:errors path="destinationID" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Description (<sup style="color:red">*</sup>)</label>
                            <form:textarea path="description" cssClass="form-control" id="basic-default-lastname" rows="5" ></form:textarea>
                            <form:errors path="description" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Address (<sup style="color:red">*</sup>)</label>
                            <form:input path="address" cssClass="form-control" id="basic-default-lastname" />
                            <form:errors path="address" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Free Packing Car (<sup style="color:red">*</sup>)</label>
                            <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="freePacking" cssClass="form-check-input" value="true" label="Yes" name="freePacking" />
                            </div>   
                            <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="freePacking" cssClass="form-check-input" value="false" label="No" name="freePacking" />
                            </div>
                            <form:errors path="freePacking" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Pool (<sup style="color:red">*</sup>)</label>
                           <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="isHasPool" cssClass="form-check-input" value="true" label="Yes" name="isHasPool" />
                            </div>   
                            <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="isHasPool" cssClass="form-check-input" value="false" label="No" name="isHasPool" />
                            </div>
                            <form:errors path="isHasPool" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Mini bar (<sup style="color:red">*</sup>)</label>
                           <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="isHasMiniBar" cssClass="form-check-input" value="true" label="Yes" name="isHasMiniBar" />
                            </div>   
                            <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="isHasMiniBar" cssClass="form-check-input" value="false" label="No" name="isHasMiniBar" />
                            </div>
                            <form:errors path="isHasMiniBar" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Restaurant On Site (<sup style="color:red">*</sup>)</label>
                             <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="restaurantOnSite" cssClass="form-check-input" value="true" label="Yes" name="restaurantOnSite" />
                            </div>   
                            <div class="form-check form-check-inline mt-3">
                                <form:radiobutton path="restaurantOnSite" cssClass="form-check-input" value="false" label="No" name="restaurantOnSite" />
                            </div>
                            <form:errors path="restaurantOnSite" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Hotel Default Image (<sup style="color:red">*</sup>)</label>
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
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-hotel/home-hotel" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>