<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
    #filterRestaurant{
        display: flex;
        margin: 0 10%;
    }
    #filterRestaurant .search-input{
        width: 23%;
        height: 40px;
        padding: 0 10px;
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
                    Restaurants				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/restaurant/page/1"> Restaurants</a></p>
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
                    <h1 class="mb-10">Available Restaurants</h1>
                    <p>We all live in an age that belongs to the young at heart. Life that is becoming extremely fast, day to.</p>
                </div>
            </div>
        </div>	
        <form:form action="${pageContext.request.contextPath}/filter-restaurant" method="post" modelAttribute="filterRestaurant"> 
            <form:select cssClass="search-input" id="basic-default-username" path="destinationID">
                <form:option label="--Destination--" value="0"/>
                <form:options cssClass="form-control" items="${listDestination}" itemLabel="name" itemValue="destinationID" />
            </form:select>
            <form:select cssClass="search-input" id="basic-default-username" path="rateStar">
                <c:forEach items="${mapRateStar.entrySet()}" var="map">
                    <form:option cssClass="option" label="${map.getValue()}" value="${map.getKey()}"></form:option>
                </c:forEach>                            
            </form:select>
            <form:input cssClass="search-input" path="keyword" placeholder="Restaurant to search..." />
            <button class="search-input genric-btn primary" type="submit" >Search...</button>
        </form:form>
        <div class="row">
            <c:forEach items="${listRestaurant}" var="itemRestaurant" >

                <div class="col-lg-4">
                    <div class="single-destinations">
                        <div class="thumb">
                            <img height="200px" src="<c:url value="${itemRestaurant.image}"/>" alt="${itemRestaurant.name}">
                        </div>
                        <div class="details">
                            <h4 class="d-flex justify-content-between">
                                <span>${itemRestaurant.name}</span>                              	
                                <div class="star">
                                    <c:forEach begin="1" end="${itemRestaurant.rateStar}" step="1">
                                        <span class="fa fa-star checked"></span>
                                    </c:forEach>			
                                </div>	
                            </h4>
                            <p>
                                <c:if test="${itemRestaurant.url !=''}">
                                    <a target="_blank" href="${itemRestaurant.url}">Go to Page</a>  
                                </c:if>

                            </p>
                            <ul class="package-list">
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Destination</span>
                                    <span>
                                        ${itemRestaurant.destinationID.name}
                                    </span>
                                </li>                                                            

                                <li class="d-flex justify-content-between align-items-center">

                                    <span>

                                        ${fn:substring(itemRestaurant.description, 0, 25)}...
                                        <a href="#" type="button" data-toggle="modal" data-target="#exampleModal">
                                            view more
                                        </a></span>
                                </li>												

                            </ul>
                        </div>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Description</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    ${itemRestaurant.description}
                                </div>                              
                            </div>
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
                            <a class="" href="${pageContext.request.contextPath}/restaurant/page/1" title="First"><i class="fa fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/restaurant/page/${pageIndex-1}" title="Previous"><i class="fa fa-angle-left"></i></a>
                        </li>
                    </c:if>


                    <c:forEach begin="${startPage}" end="${endPage}" step="1" var="currentPage">
                        <li 
                            <c:if test="${currentPage==pageIndex}">
                                class="active"
                            </c:if>
                            >
                            <a href="${pageContext.request.contextPath}/restaurant/page/${currentPage}" title="Page ${currentPage}">${currentPage}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageIndex < totalPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/restaurant/page/${pageIndex+1}" title="Next"><i class="fa fa-angle-right"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/restaurant/page/${totalPage}" title="Last"><i class="fa fa-angle-double-right"></i></a>
                        </li>
                    </c:if>
                </ul>
            </c:if>
        </c:if>

    </div>	
</section>
<!-- Button trigger modal -->

<script>
    $('#myModal').on('shown.bs.modal', function () {
        $('#myInput').trigger('focus')
    });
</script>
<!-- End destinations Area -->