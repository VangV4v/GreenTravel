<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Destination/</span> Update Destination</h4>
    <!-- Basic Layout -->
    <div class="row">
        <div class="col-xl">
            <div class="card mb-4">               
                <div class="card-body">
                    <form:form action="" method="post" modelAttribute="destination" enctype="multipart/form-data" >
                        <form:hidden path="destinationID"/>
                        <form:hidden path="image"/>
                          <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Destination Name</label>
                            <form:input path="name" cssClass="form-control" id="basic-default-username"  />
                            <form:errors path="name" cssClass="errform" />
                        </div>
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-username">Area</label>
                            <form:select cssClass="form-control" id="basic-default-username" path="areaID">
                                <form:options cssClass="form-control" items="${listArea}" itemLabel="name" itemValue="areaID" />
                            </form:select>
                            <form:errors path="areaID" cssClass="errform" />
                        </div>                      
                        <div class="mb-3">
                            <label class="form-label" for="basic-default-lastname">Destination Image</label>
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
                        <a href="${pageContext.request.contextPath}/admin/employee/manage-destination/home-destination" class="btn btn-primary">Back</a>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>