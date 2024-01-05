/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let confirmBooking =
        {
            init: function () {
                confirmBooking.confirmBooking();
            },
            confirmBooking: function () {
                $('.bookingcar__button__confirmBooking').each(function () {
                    $(this).on('click', function () {
                        let id = $(this).data("id");
                        Swal.fire({
                            title: 'Do you want to save the changes?',
                            showDenyButton: true,
                            showCancelButton: true,
                            confirmButtonText: 'Approve',
                            denyButtonText: `Deny`,
                        }).then((result) => {
                            /* Read more about isConfirmed, isDenied below */
                            if (result.isConfirmed) {
                                $.ajax({
                                    type: 'POST',
                                    url: 'approve-car',
                                    data: {bookingID: id},
                                    success: function () {
                                        location.href = "home-booking-car";
                                    }
                                });
                                // Swal.fire('Saved!', '', 'success')
                            } else if (result.isDenied) {
                                $.ajax({
                                    type: 'POST',
                                    url: 'deny-car',
                                    data: {bookingID: id},
                                    success: function () {
                                        location.href = "home-booking-car";
                                    }
                                });
                                //Swal.fire('Changes are not saved', '', 'info')
                            }
                        });
                    });
                });

            }
        };
confirmBooking.init();
