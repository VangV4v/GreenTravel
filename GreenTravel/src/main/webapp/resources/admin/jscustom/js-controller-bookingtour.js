/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let bookingTour = {
    init: function () {

        bookingTour.confirmBookingTour();
    },

    confirmBookingTour: function () {
        $('.bookingTour__button__confirmBookingTour').each(function () {
            $(this).on("click", function () {
                let bookingTourID = $(this).data('id');
                console.log('vao confirm');
                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you want to approve or deny of Booking Tour?',
                    icon: 'question',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: 'Yes, Approve it!',
                    showDenyButton: true,
                    denyButtonColor: '#d33',
                    denyButtonText: `No, Deny it!`,
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'POST',
                            url: 'confirm-bookingtour',
                            data: {bookingTourID: bookingTourID, confirmStatus: 2},
                            success: function () {
                                //  tr.remove();
                                console.log('success confirm');

                                location.href = 'home-bookingtour';
                                Swal.fire(
                                        'Changed!',
                                        'Your booking has been approved.',
                                        'success'
                                        );

                            }
                        });
                    } else if (result.isDenied) {
                        $.ajax({
                            type: 'POST',
                            url: 'confirm-bookingtour',
                            data: {bookingTourID: bookingTourID, confirmStatus: -1},
                            success: function () {
                                //    tr.remove();
                                location.href = 'home-bookingtour';
                                Swal.fire(
                                        'Changed!',
                                        'Your booking has been denied.',
                                        'success'
                                        );

                            }
                        });
                    }
                });
            });
        });
    }
}
bookingTour.init();

