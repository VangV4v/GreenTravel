<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- start banner Area -->
<section class="relative about-banner">	
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    Booking Car				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span><a href="${pageContext.request.contextPath}/blog-home">Blog </a> <span class="lnr lnr-arrow-right"></span> <a href="${pageContext.request.contextPath}/blog-detail"> Blog Details Page</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->					  
<!-- Start post-content Area -->
<section class="post-content-area single-post-area">
    <div class="container">
        <div class="row">
            <div class="col-lg-8">
                <form:form action="" method="post" modelAttribute="bookingcar" cssClass="booking__form__submit">
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="name">Your name:(<sup style="color:red">*</sup>)</label>
                                <form:input path="rentalName" cssClass="form-control" id="name" />
                                <form:errors path="rentalName" cssClass="errform" />
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="email">Your Email:(<sup style="color:red">*</sup>)</label>
                                <form:input path="rentalEmail" cssClass="form-control" id="email" />
                                <form:errors path="rentalEmail" cssClass="errform" />
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="rentalAddress">Your Address:(<sup style="color:red">*</sup>)</label>
                                <form:input path="rentalAddress" cssClass="form-control" id="rentalAddress" />
                                <form:errors path="rentalAddress" cssClass="errform" />
                            </div>
                        </div> 
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="phone">Your Phone:(<sup style="color:red">*</sup>)</label>
                                <form:input path="rentalPhone" cssClass="form-control" id="phone" />
                                <form:errors path="rentalPhone" cssClass="errform" />
                            </div>
                        </div> 
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="start">Day Start:(<sup style="color:red">*</sup>)</label>
                                <form:input path="rentalDate" cssClass="form-control startday__input__chooseday day__input__chooseday" id="start" type="date" required="required"  />
                                <form:errors path="rentalDate" cssClass="errform"  />
                            </div>
                        </div> 
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="end">Day End:(<sup style="color:red">*</sup>)</label>
                                <form:input path="returnDate" cssClass="form-control endday__input__chooseday day__input__chooseday" id="end" type="date" required="required" />
                                <form:errors path="returnDate"  cssClass="enddate__err__formerr errform" />
                            </div>
                        </div> 
                    </div>
                    <div class="row">
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="totalPrice">Total Price:(<sup style="color:red">*</sup>)</label>
                                <input type="hidden" value="${car.priceInDay}" class="priceOfCar" />
                                <form:input path="price" readonly="true"  cssClass="form-control totalPriceCar errform"/>
                            </div>
                        </div> 
                        <div class="col-lg-6">
                            <div class="form-group">
                                <label for="totalPrice">Driver:(<sup style="color:red">*</sup>)</label>
                                <div class="form-control">
                                    <form:radiobutton path="driver" value="true" label="Yes"  cssClass="" />
                                    <form:radiobutton path="driver" value="false" label="No"  cssClass="" />
                                    <form:errors path="driver" cssClass="errform"/>
                                </div>
                            </div>
                        </div> 
                    </div>

                    <div class="form-group">
                        <label for="note">Note:</label>
                        <form:textarea path="note" cssClass="form-control" id="note" />
                        <form:errors path="note" cssClass="errform" />
                    </div>
                    <button type="submit"  class="genric-btn primary">Booking Now</button>
                    <button type="button" onclick="history.go(-1)" class="genric-btn primary">Back</button>

                </form:form>
            </div>
            <div class="col-lg-4">
                <div class="form-group">
                    <label for="carname">Car Name</label>
                    <h5 id="carname">${car.carName}</h5>
                </div>
                <div class="form-group">
                    <label for="name">Model Name</label>
                    <h5>${car.carModelID.name}</h5>
                </div>
                <div class="form-group">
                    <label for="name">Type Name</label>
                    <h5>${car.carTypeID.carTypeName}</h5>
                </div>
                 <div class="form-group">
                    <label for="price">Price per Day</label>
                    <h5>${car.priceInDay}</h5>
                </div>
                <div class="form-group">
                    <label for="name">Image</label>
                    <img src="${car.image}" class="img-thumbnail" />
                </div>
               
            </div>
        </div>
    </div>	
</section>
<!-- End post-content Area -->
