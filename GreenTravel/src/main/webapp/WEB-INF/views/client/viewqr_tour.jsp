<%-- 
    Author     : kyqua
--%>

<section class="about-banner relative">
    <div class="overlay overlay-bg"></div>
    <div class="container">				
        <div class="row d-flex align-items-center justify-content-center">
            <div class="about-content col-lg-12">
                <h1 class="text-white">
                    My Booking Tour				
                </h1>	
                <p class="text-white link-nav"><a href="${pageContext.request.contextPath}/home">Home </a>  <span class="lnr lnr-arrow-right"></span>  <a href="${pageContext.request.contextPath}/customer/my-booking-tour"> My Booking Tour</a></p>
            </div>	
        </div>
    </div>
</section>
<!-- End banner Area -->	

<!-- Start destinations Area -->
<section class="destinations-area section-gap">
    <div class="container mt-6 mb-7">
        <div class="row justify-content-center">
            <div class="col-lg-12 col-xl-7">
                <div class="card">
                    <div class="card-body p-5">
                        <h2>
                            Hey ${bookingTour.customerID.firstname} ${bookingTour.customerID.lastname},
                        </h2>
                        <p class="fs-sm">
                            This is the receipt for a payment of <strong>$${bookingTour.totalPrice}</strong> you made to Spacial Themes.
                        </p>

                        <div class="border-top border-gray-200 pt-4 mt-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Payment No.</div>
                                    <strong>#${bookingTour.bookingTourID}</strong>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Date</div>
                                    <strong>${bookingTour.bookDate}</strong>
                                </div>
                            </div>
                        </div>

                        <div class="border-top border-gray-200 mt-4 py-4">
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="text-muted mb-2">Customer</div>
                                    <strong>
                                        ${bookingTour.bookingName}
                                    </strong>
                                    <p class="fs-sm">
                                        ${bookingTour.bookingPhone}
                                        <br>
                                        <a href="#!" class="text-purple">${bookingTour.bookingEmail}
                                        </a>
                                    </p>
                                </div>
                                <div class="col-md-6 text-md-end">
                                    <div class="text-muted mb-2">Payment To</div>
                                    <strong>
                                        Green Travel co.,ltd
                                    </strong>
                                    <p class="fs-sm">
                                        10th Hoa Binh Street, Ninh Kieu District, Can Tho City
                                        <br>
                                        <a href="#!" class="text-purple">greentravel.info@gmail.com
                                        </a>
                                    </p>
                                </div>
                            </div>
                        </div>

                        <table class="table border-bottom border-gray-200 mt-3">
                            <thead>
                                <tr>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Package Tour</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Schedule</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Trip</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Adult Quantity</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm px-0">Children Quantity</th>
                                    <th scope="col" class="fs-sm text-dark text-uppercase-bold-sm text-end px-0">Price per Person</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="px-0">${bookingTour.packageTourID.name}</td>
                                    <td class="px-0">${bookingTour.packageTourID.dateStart} <strong>to</strong> ${bookingTour.packageTourID.dateEnd}</td>
                                    <td class="text-end px-0"> ${bookingTour.packageTourID.fromProvinceID.name} <strong>to</strong> ${bookingTour.packageTourID.toProvinceID.name}</td>
                                    <td class="px-0">${bookingTour.quantityAdult}</td>
                                    <td class="px-0">${bookingTour.quantityChildren}</td>
                                    <td class="px-0">$${bookingTour.packageTourID.price}</td>

                                </tr>
                            </tbody>
                        </table>                     
                        <div class="mt-5">
                            <div class="d-flex justify-content-end">
                                <p class="text-muted me-3">Subtotal:</p>
                                <span>$${bookingTour.totalPrice}</span>
                            </div>
                            <div class="d-flex justify-content-end">
                                <p class="text-muted me-3">Discount:</p>
                                <span>-$0.00</span>
                            </div>
                            <div class="d-flex justify-content-end mt-3">
                                <h5 class="me-3">Total:</h5>
                                <h5 class="text-success">${bookingTour.totalPrice} USD</h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>