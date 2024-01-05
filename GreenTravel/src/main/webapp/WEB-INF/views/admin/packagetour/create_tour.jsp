<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Package Tour/</span> Create Tour</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="tour" >
                        <form:hidden path="visitDate"/>
                        <form:hidden path="schedule"/>

                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Tour Name (<sup style="color:red">*</sup>)</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Destination (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="sllDestination" path="destinationID">
                                <option label="--Select destination--" disabled="true" selected="true"/>
                                <form:options cssClass="form-control" items="${listDestination}" itemLabel="name" itemValue="destinationID" />                         
                            </form:select>   
                            <form:errors path="destinationID" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Restaurant (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="sllRestaurant" path="restaurantID">
                                <option label="--Select restaurant--" value="0" disabled="true" selected="true"/>
                            </form:select>    
                            <form:errors path="restaurantID" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Hotel (<sup style="color:red">*</sup>)</label>
                            <form:select cssClass="form-control" id="sllHotel" path="hotelID">
                                <option label="--Select hotel--" value="0" disabled="true" selected="true"/>
                            </form:select>    
                            <form:errors path="hotelID" cssClass="errform" />
                        </div> 
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Local Travel In Tour (<sup style="color:red">*</sup>)</label>
                            <div id="lcbLocalTravel">
                                <span>--Select local travel--</span>
                            </div>                                                    
                            <form:errors path="listLocalTravelinTour" cssClass="errform" />
                        </div> 

                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Visit Date (<sup style="color:red">*</sup>)</label>
                            <input type="date" name="visitDate" value="${tour.visitDate}" class="form-control" disabled="true"/>
                            <form:errors path="visitDate" cssClass="errform" />
                        </div>                        
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Schedule (<sup style="color:red">*</sup>)</label>
                            <form:input path="schedule" cssClass="form-control" id="basic-default-username" disabled="true" />
                            <form:errors path="schedule" cssClass="errform" />
                        </div>                     
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Description (<sup style="color:red">*</sup>)</label>
                            <form:textarea path="description" cssClass="form-control" id="basic-default-lastname" rows="5" ></form:textarea>
                            <form:errors path="description" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Note</label>
                            <form:textarea path="note" cssClass="form-control" id="basic-default-lastname" rows="5" ></form:textarea>
                            <form:errors path="note" cssClass="errform" />
                        </div>                                       
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-packagetour/home-packagetour" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
     

        <script src="<c:url value="/resources/admin/jscustom/js-controller-packagetour.js"/>"></script>
