<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
    #searchPackageTour{
        width: 40%;
        display: flex;
    }
    #filterPackageTour
    {
        width: 60%;
        display: flex;
    }
    #searchPackageTour
    {
        padding-left: 10%;
    }

    #filterPackageTour .search-input1{
        width: 50%;
        height: 40px;
        margin: 0 1%;
    }

</style>                  
<!-- start banner Area -->
<section class="relative about-banner">	
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Package Tour			
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/packagetour/page/1"> Package Tour</a></p>
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
                    <h1 class="mb-10">Available Tour</h1>
                    <p>We all live in an age that belongs to the young at heart. Life that is becoming extremely fast, day to.</p>
                </div>
            </div>
        </div>	
        <div style="display: flex">
            <form:form action="${pageContext.request.contextPath}/filter-packagetour" method="post" modelAttribute="filterPackageTour">                
                <form:select cssClass="search-input1" id="basic-default-username" path="fromProvinceID">
                    <form:option label="--From Province--" value="0"/>
                    <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                </form:select>
                <form:select cssClass="search-input1" id="basic-default-username" path="toProvinceID">
                    <form:option label="--To Province--" value="0"/>
                    <form:options cssClass="form-control" items="${listProvince}" itemLabel="name" itemValue="provinceID" />
                </form:select>
                <form:input cssClass="search-input1" id="datePicker" type="date" path="date" onchange="setDefaultDate(this.value)" />  
                <button class="search-input1 genric-btn primary" type="submit" >Filter</button>
            </form:form>


            <form:form action="${pageContext.request.contextPath}/search-packagetour"  method="post" modelAttribute="searchPackageTour">               
                <form:input cssClass="search-input2"  path="keyword" placeholder="Tour name to search..."/>
                <button class="search-input2 genric-btn primary" type="submit" >Search</button>
            </form:form>
        </div>

        <div class="row">


            <c:forEach items="${listPackageTour}" var="itemPackageTour">
                <div class="col-lg-4">
                    <div class="single-destinations">
                        <div  class="thumb">
                            <img height="200px" src="<c:url value="${itemPackageTour.image}"/>" alt="${itemPackageTour.name}">
                        </div>
                        <div class="details">
                            <h4>${itemPackageTour.name}</h4>                          
                            <ul class="package-list">
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Date Start</span>
                                    <span>${itemPackageTour.dateStart}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Date End</span>
                                    <span>${itemPackageTour.dateEnd}</span>
                                </li>                               
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>From</span>
                                    <span>${itemPackageTour.fromProvinceID.name}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>To</span>
                                    <span>${itemPackageTour.toProvinceID.name}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Available Slot</span>
                                    <span>${itemPackageTour.capacity}</span>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Price per person</span>
                                    <a href="#" class="price-btn">${itemPackageTour.price} $</a>
                                </li>
                                <li class="d-flex justify-content-between align-items-center">
                                    <span>Book Tour</span>
                                    <a href="${pageContext.request.contextPath}/packagetour/detail/${itemPackageTour.packageTourID}" class="price-btn">View Detail</a>

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
                            <a class="" href="${pageContext.request.contextPath}/packagetour/page/1" title="First"><i class="fa fa-angle-double-left"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/packagetour/page/${pageIndex-1}" title="Previous"><i class="fa fa-angle-left"></i></a>
                        </li>
                    </c:if>

                    <c:forEach begin="${startPage}" end="${endPage}" step="1" var="currentPage">
                        <li 
                            <c:if test="${currentPage==pageIndex}">
                                class="active"
                            </c:if>
                            >
                            <a href="${pageContext.request.contextPath}/packagetour/page/${currentPage}" title="Page ${currentPage}">${currentPage}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${pageIndex < totalPage}">
                        <li>
                            <a href="${pageContext.request.contextPath}/packagetour/page/${pageIndex+1}" title="Next"><i class="fa fa-angle-right"></i></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/packagetour/page/${totalPage}" title="Last"><i class="fa fa-angle-double-right"></i></a>
                        </li>
                    </c:if>
                </ul>
            </c:if>
        </c:if>
    </div>	
</section>
<!-- End destinations Area -->
<script>
    function setDefaultDate(e) {
        if (e === '') {
            var now = new Date();

            var day = ("0" + now.getDate()).slice(-2);
            var month = ("0" + (now.getMonth() + 1)).slice(-2);

            var today = now.getFullYear() + "-" + (month) + "-" + (day);

            $('#datePicker').val(today);
        }
    }
</script>



