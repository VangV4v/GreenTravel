/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let chartTour = {
    init: function () {
        let dt = new Date();
        chartTour.registerEvent();
        chartTour.loadCharRevenueTourType(dt.getMonth() + 1);
        chartTour.loadCharRevenueTourArea(dt.getMonth() + 1);
        chartTour.loadCharRevenueProvince(dt.getMonth() + 1);
        chartTour.loadCharRevenueTourInYear(dt.getFullYear());

    },
    registerEvent: function () {
        let dt = new Date();
        let temp = dt.getMonth() + 1;

        let sllMonthTourType = document.getElementById('sllMonthTourType');
        for (let i, j = 0; i = sllMonthTourType.options[j]; j++) {
            if (i.value == temp) {
                sllMonthTourType.selectedIndex = j;
                break;
            }
        }
        let sllMonthTourArea = document.getElementById('sllMonthTourArea');
        for (let i, j = 0; i = sllMonthTourArea.options[j]; j++) {
            if (i.value == temp) {
                sllMonthTourArea.selectedIndex = j;
                break;
            }
        }



        $('#sllMonthTourType').on('change', function () {
            let month = $(this).val();
            chartTour.loadCharRevenueTourType(month);
        });
        $('#sllMonthTourArea').on('change', function () {
            let month = $(this).val();
            chartTour.loadCharRevenueTourArea(month);

        });
        $('#sllMonthProvince').val(temp);
        $('#sllMonthProvince').on('change', function () {
            let month = $(this).val();
            chartTour.loadCharRevenueProvince(month);

        });
        $('#sllTourInYear').val(dt.getFullYear());
        $('#sllTourInYear').on('change', function () {
            let year = $(this).val();
            chartTour.loadCharRevenueTourInYear(year);

        });
    },
    loadCharRevenueTourType: function (m) {
       // $('canvas#ChartRevenueTourType').remove();
      //  $('#divChartRevenueTourType').html('<canvas id="ChartRevenueTourType" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-tourtype",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                    
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueTourType");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Dollar",
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
                                text: "Report revenue booking tour by tour type in month"
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
                                            unit: 'dollar'
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
    loadCharRevenueTourArea: function (m) {
      //  $('canvas#ChartRevenueTourArea').remove();
      //  $('#divChartRevenueTourArea').html('<canvas id="ChartRevenueTourArea" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-tourarea",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                    
                    let lstLable = [];
                    let lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueTourArea");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Dollar",
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
                                text: "Report revenue booking tour by area in month"
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
                                            unit: 'dollar'
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
    loadCharRevenueProvince: function (m) {
      //  $('canvas#ChartRevenueProvince').remove();
       // $('#divChartRevenueProvince').html('<canvas id="ChartRevenueProvince" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-province",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                   
                    let lstLable = [];
                    let lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueProvince");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Dollar",
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
                                text: "Report revenue booking tour from province in month"
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
                                            unit: 'dollar'
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
    loadCharRevenueTourInYear: function (year) {
       // $('canvas#ChartRevenueTourInYear').remove();
      //  $('#divChartRevenueTourInYear').html('<canvas id="ChartRevenueTourInYear" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-tour-year",
                data: {year: year},
                dataType: 'json',
                success: function (ldata) {
                    
                    let lstLable = [];
                    let lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueTourInYear");
                    new Chart(ctx, {
                        type: "bar",
                        data: {
                            labels: lstLable,
                            datasets: [{
                                    label: "Dollar",
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
                                text: "Report revenue booking tour in year"
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
                                            unit: 'Dollar'
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
    }

}
chartTour.init();
