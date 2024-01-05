/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let booking =
        {
            init: function () {
                booking.registerEvent();
                booking.toltalPriceByDay();
                booking.bookingCar();
                booking.stopBookingCar();
                booking.stopBookingTour();
                booking.sendFeedbackBookingTour();
                booking.sendFeedbackBookingCar();
            },
            registerEvent: function () {
                $('#qttChildren').on('change', function () {
                    let price = $('#totalPrice').data('price');
                    let qttAdult = $('#qttAdult').val();
                    let qttChildren = $(this).val();
                    $('#totalPrice').html('<h3>$' + ((price * qttAdult) + (price * qttChildren * 0.8)) + '</h3>');
                });
                $('#qttAdult').on('change', function () {
                    let price = $('#totalPrice').data('price');
                    let qttAdult = $(this).val();
                    let qttChildren = $('#qttChildren').val();
                    $('#totalPrice').html('<h3>$' + ((price * qttAdult) + (price * qttChildren * 0.8)) + '</h3>');
                });
            },
            toltalPriceByDay: function () {
                $('.day__input__chooseday').on('change', function () {
                    let startDay = $('.startday__input__chooseday').val();
                    let endDay = $('.endday__input__chooseday').val();
                    let priceOfCar = $('.priceOfCar').val();
                    if (startDay !== '' && endDay !== '') {
                        let ms1 = new Date(startDay).getTime();
                        let ms2 = new Date(endDay).getTime();
                        let day = Math.ceil((ms2 - ms1) / (24 * 60 * 60 * 1000));
                        console.log(startDay + ' ' + endDay + ' ' + priceOfCar + ' ' + day);
                        $('.totalPriceCar').val(day * priceOfCar);
                    }
                });
            }, bookingCar: function () {

            }, stopBookingCar: function () {
                $('.mybookingcar__button__stopBookingCar').each(function () {
                    $(this).on("click", function () {
                        let id = $(this).data("id");
                        let td_status = $(this).closest('td').prev();
                        let td_button = $(this).closest('td');
                        Swal.fire({
                            title: 'Are you sure?',
                            text: "You won't be able to revert this!",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'Yes, cancel it!'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                $.ajax({
                                    type: 'POST',
                                    url: "stop-booking-car",
                                    data: {bookingCarID: id},
                                    success: function () {
                                        td_status.text("Denied");
                                        td_button.html('');
                                        Swal.fire(
                                                'Canceled!',
                                                'Your booking has been canceled.',
                                                'success'
                                                );
                                    }
                                });

                            }
                        });
                    });
                });
            },
            stopBookingTour: function () {
                $('.mybookingtour__button__stopBookingTour').each(function () {
                    $(this).on("click", function () {
                        let id = $(this).data("id");
                        let td_status = $(this).closest('td').prev();
                        let td_button = $(this).closest('td');
                        Swal.fire({
                            title: 'Are you sure?',
                            text: "You won't be able to revert this!",
                            icon: 'warning',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d6',
                            cancelButtonColor: '#d33',
                            confirmButtonText: 'Yes, cancel it!'
                        }).then((result) => {
                            if (result.isConfirmed) {
                                $.ajax({
                                    type: 'POST',
                                    url: "stop-booking-tour",
                                    data: {bookingTourID: id},
                                    success: function () {
                                        td_status.text("Denied");
                                        td_button.html('');
                                        Swal.fire(
                                                'Canceled!',
                                                'Your booking has been cancel.',
                                                'success'
                                                );

                                    }
                                });

                            }
                        });
                    });
                });
            },
            sendFeedbackBookingTour: function () {
                $('.mybookingtour__button__sendFeedbackBookingTour').each(function () {
                    $(this).on("click", function () {
                        let id = $(this).data("id");
                        let td_button = $(this).closest('td');

                        Swal.fire({
                            title: 'Send Feedback for Package Tour',
                            input: 'textarea',
                            inputAttributes: {
                                autocapitalize: 'off',
                                maxlength: 255,
                                minlength: 0
                            },
                            validationMessage: "error...",
                            inputPlaceholder: 'Enter your feedback...',
                            showCancelButton: true,
                            confirmButtonText: 'Send Feedback',

                        }).then((result) => {
                            if (result.isConfirmed) {
                                console.log(result.value);
                                $.ajax({
                                    type: 'POST',
                                    url: "send-feedback-booking-tour",
                                    data: {bookingTourID: id, feedback: result.value},
                                    success: function () {
                                        td_button.html('');
                                        Swal.fire(
                                                'Success!',
                                                'Your feedback has been sent!',
                                                'success'
                                                );

                                    }
                                });
                            }
                        });
                    });
                });
            },
            sendFeedbackBookingCar: function () {
                $('.mybookingcar__button__sendFeedbackBookingCar').each(function () {
                    $(this).on("click", function () {
                        let id = $(this).data("id");
                        let td_button = $(this).closest('td');

                        Swal.fire({
                            title: 'Send Feedback for Car Service',
                            input: 'textarea',
                            inputAttributes: {
                                autocapitalize: 'off',
                                maxlength: 255,
                                minlength: 0
                            },
                            validationMessage: "error...",
                            inputPlaceholder: 'Enter your feedback...',
                            showCancelButton: true,
                            confirmButtonText: 'Send Feedback',

                        }).then((result) => {
                            if (result.isConfirmed) {
                                console.log(result.value);
                                $.ajax({
                                    type: 'POST',
                                    url: "send-feedback-booking-car",
                                    data: {bookingCarID: id, feedback: result.value},
                                    success: function () {
                                        td_button.html('');
                                        Swal.fire(
                                                'Success!',
                                                'Your feedback has been sent!',
                                                'success'
                                                );

                                    }
                                });
                            }
                        });
                    });
                });
            }
        };
booking.init();




