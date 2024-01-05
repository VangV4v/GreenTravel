<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
    #searchFlight,
    #filterFlight{
        width: 50%;
        display: flex;
    }
    #searchFlight{
        padding-left: 20%;
    }
    #filterFlight .search-input1{
        width: 30%;
        height: 40px;
        margin: 0 1%;
    }
    #searchFlight .search-input2{
        width: 50%;
        height: 40px;
        margin: 0 1%;
    }

</style>
<!-- start banner Area -->
<section class="about-banner relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Flights				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/flight/page/1"> Flights</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->	

<!-- Start destinations Area -->
<section class="destinations-area section-gap">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="menu-content pb-40 col-lg-8">
                <div class="title text-center">
                    <h1 class="mb-10">Available Flights</h1>
                    <p>We all live in an age that belongs to the young at heart. Life that is becoming extremely fast, day to.</p>
                </div>
            </div>
        </div>	
        <div style="display: flex;" >
            <form:form action="${pageContext.request.contextPath}/filter-flight" method="post" modelAttribute="filterFlight"> 
                <form:select cssClass="search-input1" id="basic-default-username" path="fromProvinceID">
                    <form:option label="--From Province--" value="0"/>
                    <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                </form:select>
                <form:select cssClass="search-input1" id="basic-default-username" path="toProvinceID">
                    <form:option label="--To Province--" value="0"/>
                    <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                </form:select>
                <button class="search-input1 genric-btn primary" type="submit" >Filter</button>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/search-flight" style="width: 50%" method="post" modelAttribute="searchFlight"> 
                <form:input cssClass="search-input2" type="date" path="departureDate" />
                <button class="search-input2 genric-btn primary" type="submit" >Search</button>
            </form:form>
        </div>
        <div class="row">
            <c:forEach items="${listFlight}" var="itemFlight" >

                <div class="col-lg-4">
                    <div class="single-destinations">
                        <div class="thumb">
                            <img height="200px" src="<c:url value="/resources/client/img/flight-default.jpg"/>" alt="${itemFlight.flightCode}">
                        </div>
                        <div class="details">
                            <h4 class="d-flex justify-content-between">
                                <span>${itemFlight.flightCode}</span>                              	
                                <div class="star">${itemFlight.airlineID.name}
                                </div>	
                            </h4>
                            <h6>
                                ${itemFlight.departureDate}
                            </h6>
                            <ul class="package-list">
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Airplane Code</span>
                                    <span>
                                        ${itemFlight.airplaneCode}
                                    </span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>From Province</span>
                                    <span>
                                        ${itemFlight.fromProvince.name}(${itemFlight.fromProvince.provinceCode})
                                    </span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>To Province</span>
                                    <span>${itemFlight.toProvince.name}(${itemFlight.fromProvince.provinceCode})</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Business Price</span>
                                    <span>${itemFlight.businessPrice}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Economy Price</span>
                                    <span>${itemFlight.economyPrice}</span>
                                </li>


                                <li class="d-flex justify-content-between align-items-center">
                                    <span></span>
                                    <span><a href="#" class="primary-btn" type="button">
                                            Go to Page
                                        </a></span>
                                </li>
                            </ul>
                        </div>
                    </div>                            
                </div>
            </c:forEach>																													
        </div>
        <c:if test="${pagination=='pagination'}">
            <c:if test="${totalPage>1}">
                <ul  class="store-pagination">
                    <c:if test="${pageIndex >1}">
                        <li>
                            <a class="" href="${pageContext.request.contextPath}/flight/page/1" title="First"><i class="fa fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/flight/page/${pageIndex-1}" title="Previous"><i class="fa fa-angle-left"></i></a>
                        </li>
                    </c:if>            
                    <c:forEach begin="${startPage}" end="${endPage}" step="1" var="currentPage">
                        <li 
                            <c:if test="${currentPage==pageIndex}">
                                class="active"
                            </c:if>
                            >
                            <a href="${pageContext.request.contextPath}/flight/page/${currentPage}" title="Page ${currentPage}">${currentPage}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageIndex < totalPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/flight/page/${pageIndex+1}" title="Next"><i class="fa fa-angle-right"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/flight/page/${totalPage}" title="Last"><i class="fa fa-angle-double-right"></i></a>
                        </li>
                    </c:if>
                </ul>
            </c:if>
        </c:if>
    </div>	
</section>


