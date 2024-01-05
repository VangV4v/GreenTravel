<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
    #searchCar{
        width: 50%;
        display: flex;
    }
    #filterCar
    {
        width: 50%;
        display: flex;
    }
    #searchCar
    {
        padding-left: 10%;
    }

    #filterCar .search-input1{
        width: 50%;
        height: 40px;
        margin: 0 1%;
    }
    #searchCar .search-input2{
        width: 40%;
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
                    Cars				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/car/page/1"> Cars</a></p>
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
                    <h1 class="mb-10">Available Cars</h1>
                </div>
            </div>
        </div>	
        <div style="display: flex;" >
            <form:form action="${pageContext.request.contextPath}/filter-car" method="post" modelAttribute="filterCar"> 
                <form:select cssClass="search-input1" id="basic-default-username" path="carModelID">

                    <form:options cssClass="form-control" items="${listCarModel}" itemLabel="name" itemValue="carModelID" />
                </form:select>
                <form:select cssClass="search-input1" id="basic-default-username" path="carTypeID">

                    <form:options cssClass="form-control" items="${listCarType}" itemLabel="carTypeName" itemValue="carTypeID" />
                </form:select>
                <button class="search-input1 genric-btn primary" type="submit" >Filter</button>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/search-car" style="width: 50%" method="post" modelAttribute="searchCar"> 
                <form:input cssClass="search-input2" placeholder="Car name to search..." path="carName" />
                <button class="search-input2 genric-btn primary" type="submit" >Search</button>
            </form:form>
        </div>     
        <div class="row">
            <c:forEach items="${listCar}" var="item">
                <div class="col-lg-4">
                    <div class="single-destinations">
                        <div class="thumb">
                            <img height="200px" src="${item.image}" alt="">
                        </div>
                        <div class="details">
                            <h4 class="d-flex justify-content-between">
                                <span>${item.carName}</span>                              	
                                <div class="star">${item.yearIssure}
                                </div>	
                            </h4>
                            <p>

                            </p>
                            <ul class="package-list">
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Feature</span>
                                    <span>${item.fearure}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Gearbox</span>
                                    <span>${item.gearbox}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Type Car</span>
                                    <span>${item.carTypeID.carTypeName}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Model / Seat</span>
                                    <span>${item.carModelID.name} / ${item.seat}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Air Condition</span>
                                    <span>
                                        <c:if test="${item.isHasAirConditioned == true}">
                                            Yes
                                        </c:if>
                                        <c:if test="${item.isHasAirConditioned != true}">
                                            No
                                        </c:if>
                                    </span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Price per Day</span>
                                    <a href="#" class="price-btn">$${item.priceInDay}</a>
                                </li>

                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Price per day</span>
                                    <a href="${pageContext.request.contextPath}/customer/booking-car/${item.carID}" class="price-btn">Book Car</a>
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
                            <a class="" href="${pageContext.request.contextPath}/car/page/1" title="First"><i class="fa fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/car/page/${pageIndex-1}" title="Previous"><i class="fa fa-angle-left"></i></a>
                        </li>
                    </c:if>

                </c:if>
                <c:forEach begin="${startPage}" end="${endPage}" step="1" var="currentPage">
                    <li 
                        <c:if test="${currentPage==pageIndex}">
                            class="active"
                        </c:if>
                        >
                        <a href="${pageContext.request.contextPath}/car/page/${currentPage}" title="Page ${currentPage}">${currentPage}</a>
                    </li>
                </c:forEach>
                <c:if test="${pageIndex < totalPage}">
                    <li>
                        <a href="${pageContext.request.contextPath}/car/page/${pageIndex+1}" title="Next"><i class="fa fa-angle-right"></i></a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/car/page/${totalPage}" title="Last"><i class="fa fa-angle-double-right"></i></a>
                    </li>
                </c:if>
            </ul>
        </c:if>
    </div>	
</section>
<!-- End destinations Area -->