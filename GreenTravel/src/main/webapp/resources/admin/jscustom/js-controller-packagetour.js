/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


let packageTour = {
    init: function () {
        let dt = new Date();
        let y = dt.getYear() + 1900;
        let m = dt.getMonth() + 1;
        packageTour.registerEvent();
        packageTour.deletePackageTour();
        packageTour.initSelectedYear(y);
        packageTour.loadCharStatisticQuantityBookedTourTypeInMonth(m);
        packageTour.loadCharStatisticQuantityBookedFromProvinceInMonth(m);
        packageTour.loadCharStatisticQuantityBookedAreaInMonth(m);
        packageTour.loadCharStatisticQuantityTourInYear(y);
        packageTour.loadCharStatisticQuantityAvailableSlotInYear(y);
       packageTour.loadCharStatisticQuantityBookingInYear(y);
        packageTour.loadCharStatisticQuantityCancelInYear(y);

    },

    registerEvent: function () {

        let destinationid;

        $('#sllDestination').on('change', function () {
            destinationid = $(this).val();
            $('#sllRestaurant').html('');
            $('#sllHotel').html('<option value="0">--Select hotel--</option>');
            $('#lcbLocalTravel').html('<span>--Select local travel--</span>');

            packageTour.loadRestaurant(destinationid);

        });

        $('#sllRestaurant').on('change', function () {
            packageTour.loadHotel(destinationid);
        });

        $('#sllHotel').on('change', function () {
            packageTour.loadLocalTravel(destinationid);
        });

        let dt = new Date();
        let temp = dt.getYear() + 1900;
        let tempmonth = dt.getMonth() + 1;

        let sllMonthTourType = document.getElementById('sllMonthTourType');
        for (let i, j = 0; i = sllMonthTourType.options[j]; j++) {
            if (i.value == tempmonth) {
                sllMonthTourType.selectedIndex = j;
                break;
            }
        }

        let sllMonthFromProvince = document.getElementById('sllMonthFromProvince');
        for (let i, j = 0; i = sllMonthFromProvince.options[j]; j++) {
            if (i.value == tempmonth) {
                sllMonthFromProvince.selectedIndex = j;
                break;
            }
        }

        let sllMonthArea = document.getElementById('sllMonthArea');
        for (let i, j = 0; i = sllMonthArea.options[j]; j++) {
            if (i.value == tempmonth) {
                sllMonthArea.selectedIndex = j;
                break;
            }
        }

        let sllYearTour = document.getElementById('sllYearTour');
        for (let i, j = 0; i = sllYearTour.options[j]; j++) {
            if (i.value == temp) {
                sllYearTour.selectedIndex = j;
                break;
            }
        }

        let sllYearSlot = document.getElementById('sllYearSlot');
        for (let i, j = 0; i = sllYearSlot.options[j]; j++) {
            if (i.value == temp) {
                sllYearSlot.selectedIndex = j;
                break;
            }
        }

        let sllYearBooking = document.getElementById('sllYearBooking');
        for (let i, j = 0; i = sllYearBooking.options[j]; j++) {
            if (i.value == temp) {
                sllYearBooking.selectedIndex = j;
                break;
            }
        }

        let sllYearCancel = document.getElementById('sllYearCancel');
        for (let i, j = 0; i = sllYearCancel.options[j]; j++) {
            if (i.value == temp) {
                sllYearCancel.selectedIndex = j;
                break;
            }
        }
        $('#sllMonthTourType').on('change', function () {
            let month = $(this).val();
            packageTour.loadCharStatisticQuantityBookedTourTypeInMonth(month);
        });

        $('#sllMonthFromProvince').on('change', function () {
            let month = $(this).val();
            packageTour.loadCharStatisticQuantityBookedFromProvinceInMonth(month);
        });

        $('#sllMonthArea').on('change', function () {
            let month = $(this).val();
            packageTour.loadCharStatisticQuantityBookedAreaInMonth(month);
        });

        $('#sllYearTour').on('change', function () {
            let year = $(this).val();
            packageTour.loadCharStatisticQuantityTourInYear(year);
        });

        $('#sllYearSlot').on('change', function () {
            let year = $(this).val();
            packageTour.loadCharStatisticQuantityAvailableSlotInYear(year);
        });

        $('#sllYearBooking').on('change', function () {
            let year = $(this).val();
            packageTour.loadCharStatisticQuantityBookingInYear(year);
        });

        $('#sllYearCancel').on('change', function () {
            let year = $(this).val();
            packageTour.loadCharStatisticQuantityCancelInYear(year);
        });
    },
    loadRestaurant: function (id) {
        $.ajax({
            type: 'GET',
            url: '/GreenTravel/admin/employee/manage-packagetour/load-restaurant',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                let html = '';
                html += '<option value="0">--Select restaurant--</option>';
                $.each(data, function (i, item) {
                    html += '<option value="' + item.restaurantID + '">' + item.name + ' - ' + item.rateStar + ' Star </option>'
                });

                $('#sllRestaurant').html(html);
            }
        });
    },
    loadHotel: function (id) {
        $.ajax({
            type: 'GET',
            url: '/GreenTravel/admin/employee/manage-packagetour/load-hotel',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                let html = '';
                html += '<option value="0">--Select hotel--</option>';
                $.each(data, function (i, item) {
                    html += '<option value="' + item.hotelID + '">' + item.name + ' - ' + item.rateStar + ' Star </option>'
                });

                $('#sllHotel').html(html);
            }
        });
    },
    loadLocalTravel: function (id) {
        $.ajax({
            type: 'GET',
            url: '/GreenTravel/admin/employee/manage-packagetour/load-localtravel',
            data: {id: id},
            dataType: 'json',
            success: function (data) {
                let html = '';
                $.each(data, function (i, item) {

                    html += '<div class="form-check mt-3"><input class="form-check-input" name="listLocalTravelinTour" type="checkbox" value="' + item.localTravelID
                            + '" /><label class="form-check-label" >' + item.name + '</label></div>'
                });


                $('#lcbLocalTravel').html(html);
            }
        });
    },
    deletePackageTour: function () {
        $('.packageTour__button__deletePackageTour').each(function () {
            $(this).on("click", function () {
                //e.preventDefault();
                let id = $(this).data('id');
                let tr = $(this).closest('tr');
               
                Swal.fire({
                    title: 'Are you sure?',
                    text: 'Do you want to delete Package Tour?',
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, Detele it!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        $.ajax({
                            type: 'POST',
                            url: 'delete-packagetour',
                            data: {id: id},
                            success: function () {
                                Swal.fire(
                                        'Changed!',
                                        'Your file has been changed.',
                                        'success'
                                        );
                                tr.remove();
                            }
                        });
                    }
                });
            });
        });
    },
    initSelectedYear: function (y) {
        $('#sllYearTour').html('<option selected value="' + y + '">' + y + '</option><option value="' + (y - 1) + '">' + (y - 1) + '</option>');
        $('#sllYearSlot').html('<option selected value="' + y + '">' + y + '</option><option value="' + (y - 1) + '">' + (y - 1) + '</option>');
        $('#sllYearBooking').html('<option selected value="' + y + '">' + y + '</option><option value="' + (y - 1) + '">' + (y - 1) + '</option>');
        $('#sllYearCancel').html('<option selected value="' + y + '">' + y + '</option><option value="' + (y - 1) + '">' + (y - 1) + '</option>');
    },
    loadCharStatisticQuantityTourInYear: function (y) {
       // $('canvas#ChartStatisticQuantityTour').remove();
      //  $('#divChartStatisticQuantityTour').html('<canvas id="ChartStatisticQuantityTour" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantitytour",
                data: {year: y},
                dataType: 'json',
                success: function (ldata) {
                   
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityTour");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Tour",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity tour in year"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Tour'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityAvailableSlotInYear: function (y) {
     //   $('canvas#ChartStatisticQuantitySlot').remove();
      //  $('#divChartStatisticQuantitySlot').html('<canvas id="ChartStatisticQuantitySlot" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantityslot",
                data: {year: y},
                dataType: 'json',
                success: function (ldata) {
                  
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantitySlot");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Available Slot",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity available slot in year"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Available Slot'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityBookingInYear: function (y) {
       // $('canvas#ChartStatisticQuantityBooking').remove();
       // $('#divChartStatisticQuantityBooking').html('<canvas id="ChartStatisticQuantityBooking" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantitybooking",
                data: {year: y},
                dataType: 'json',
                success: function (ldata) {
                   
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityBooking");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Booking Slot",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity booking slot in year"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Booking Slot'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityCancelInYear: function (y) {
      //  $('canvas#ChartStatisticQuantityCancel').remove();
      //  $('#divChartStatisticQuantityCancel').html('<canvas id="ChartStatisticQuantityCancel" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantitycancel",
                data: {year: y},
                dataType: 'json',
                success: function (ldata) {
                   
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityCancel");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Cancel tour",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity cancel tour in year"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Cancel tour'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityBookedTourTypeInMonth: function (m) {
     //  $('canvas#ChartStatisticQuantityTourType').remove();
     //   $('#divChartStatisticQuantityTourType').html('<canvas id="ChartStatisticQuantityTourType" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantitytourtype",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                  
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityTourType");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Booking Slot",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity booking by tour type in month"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Booking slot'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityBookedFromProvinceInMonth: function (m) {
     //   $('canvas#ChartStatisticQuantityFromProvince').remove();
     //   $('#divChartStatisticQuantityFromProvince').html('<canvas id="ChartStatisticQuantityFromProvince" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantityfromprovince",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                   
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityFromProvince");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Booking Slot",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity booking by province in month"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Booking slot'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
    loadCharStatisticQuantityBookedAreaInMonth: function (m) {
       // $('canvas#ChartStatisticQuantityArea').remove();
       // $('#divChartStatisticQuantityArea').html('<canvas id="ChartStatisticQuantityArea" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "statistic-quantityarea",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                   
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.quantity);
                    });
                    let ctx = document.getElementById("ChartStatisticQuantityArea");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Booking Slot",
                                    backgroundColor: "#4e73df",
                                    hoverBackgroundColor: "#2e59d9",
                                    borderColor: "#4e73df",
                                    data: lstDataSource

                                }]
                        },
                        options: {
                            maintainAspectRatio: false,
                            title: {
                                display: true,
                                text: "Report statistic quantity booking by area in month"
                            },
                            layout: {
                                padding: {
                                    left: 10,
                                    right: 25,
                                    top: 25,
                                    bottom: 0
                                }
                            },
                            scales: {
                                xAxes: [{
                                        time: {
                                            unit: 'Booking slot'
                                        },
                                        gridLines: {
                                            display: false,
                                            drawBorder: false
                                        },

                                    }],
                            },
                        }
                    });
                }
            });

        });
    },
}
packageTour.init();
