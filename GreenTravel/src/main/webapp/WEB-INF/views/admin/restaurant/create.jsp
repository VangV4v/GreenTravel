<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Restaurant/</span> Create Restaurant</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">

                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="restaurant" enctype="multipart/form-data" >
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Restaurant Name</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Restaurant Url</label>
                            <form:input path="url" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="url" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Rate Star</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="rateStar">
                                <c:forEach items="${mapRateStar.entrySet()}" var="map">
                                    <form:option cssClass="form-control" label="${map.getValue()}" value="${map.getKey()}"></form:option>
                                </c:forEach>                            
                            </form:select>
                            <form:errors path="rateStar" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Destination</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="destinationID">
                                <form:options cssClass="form-control" items="${listDestination}" itemLabel="name" itemValue="destinationID" />
                            </form:select>
                            <form:errors path="destinationID" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Description</label>
                            <form:textarea path="description" cssClass="form-control" id="basic-default-lastname" rows="5" ></form:textarea>
                            <form:errors path="description" cssClass="errform" />
                        </div>  
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Restaurant Image</label>
                            <input
                                type="file" 
                                id="formFile"
                                class="form-control"
                                name="thumbnailImage"
                                accept="image/png, image/jpeg, image/jpg"
                                />    
                            <form:errors path="thumbnailImage" cssClass="errform" />
                        </div>                   
                        <button type="submit" class="btn btn-primary">Create</button>
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-restaurant/home-restaurant" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>