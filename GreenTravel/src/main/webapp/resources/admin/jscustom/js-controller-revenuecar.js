/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let chartCar = {
    init: function () {
        let dt = new Date();
        console.log(dt.getFullYear());
        chartCar.registerEvent();
        chartCar.loadCharRevenueCarModel(dt.getMonth() + 1);
        chartCar.loadCharRevenueCarType(dt.getMonth() + 1);
        chartCar.loadCharRevenueCarNonAirConditionInYear(dt.getFullYear());
        chartCar.loadCharRevenueCarAirConditionInYear(dt.getFullYear());
        chartCar.loadCharRevenueCarInYear(dt.getFullYear());

    },
    registerEvent: function () {
        let dt = new Date();
        let temp = dt.getMonth() + 1;

        let sllMonthCarModel = document.getElementById('sllMonthCarType');
        for (let i, j = 0; i = sllMonthCarModel.options[j]; j++) {
            if (i.value == temp) {
                sllMonthCarModel.selectedIndex = j;
                break;
            }
        }
        let sllMonthCarType = document.getElementById('sllMonthCarType');
        for (let i, j = 0; i = sllMonthCarType.options[j]; j++) {
            if (i.value == temp) {
                sllMonthCarType.selectedIndex = j;
                break;
            }
        }


        $('#sllMonthCarModel').on('change', function () {
            let month = $(this).val();
            chartCar.loadCharRevenueCarModel(month);
        });
        $('#sllMonthCarType').on('change', function () {
            let month = $(this).val();
            chartCar.loadCharRevenueCarType(month);

        });
        $('#sllCarNonAirConditionYear').val(dt.getFullYear());
        $('#sllCarNonAirConditionYear').on('change', function () {
            let year = $(this).val();
            console.log('--' + year);
            chartCar.loadCharRevenueCarNonAirConditionInYear(year);
        });
        $('#sllCarAirConditionYear').val(dt.getFullYear());
        $('#sllCarAirConditionYear').on('change', function () {
            let year = $(this).val();
            console.log('--' + year);
            chartCar.loadCharRevenueCarAirConditionInYear(year);
        });
        $('#sllCarYear').val(dt.getFullYear());
        $('#sllCarYear').on('change', function () {
            let year = $(this).val();
            console.log('--' + year);
            chartCar.loadCharRevenueCarInYear(year);
        });
    },
    loadCharRevenueCarModel: function (m) {
      //  $('canvas#ChartRevenueCarModel').remove();
     //   $('#divChartRevenueCarModel').html('<canvas id="ChartRevenueCarModel" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-carmodel",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                    var lstLable = [];
                    var lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueCarModel");
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
                                text: "Report revenue booking car by car model in month"
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
    loadCharRevenueCarType: function (m) {
       // $('canvas#ChartRevenueCarType').remove();
      //  $('#divChartRevenueCarType').html('<canvas id="ChartRevenueCarType" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-cartype",
                data: {month: m},
                dataType: 'json',
                success: function (ldata) {
                    let lstLable = [];
                    let lstDataSource = [];

                    $.each(ldata, function (index, item) {
                        lstLable.push(item.label);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueCarType");
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
                                text: "Report revenue booking car by car type in month"
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
    loadCharRevenueCarNonAirConditionInYear: function (year) {
     //  $('canvas#ChartRevenueCarNonAirConditionYear').remove();
    //    $('#divChartRevenueCarNonAirConditionYear').html('<canvas id="ChartRevenueCarNonAirConditionYear" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-car-non-air-condition-year",
                data: {year: year},
                dataType: 'json',
                success: function (ldata) {
                   
                    let lstLable = [];
                    let lstDataSource = [];
                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueCarNonAirConditionYear");
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
                                text: "Report revenue booking car by non air-conditioned in year"
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
    loadCharRevenueCarAirConditionInYear: function (year) {
       // $('canvas#ChartRevenueCarAirConditionYear').remove();
       // $('#divChartRevenueCarAirConditionYear').html('<canvas id="ChartRevenueCarAirConditionYear" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-car-air-condition-year",
                data: {year: year},
                dataType: 'json',
                success: function (ldata) {
                   
                    let lstLable = [];
                    let lstDataSource = [];
                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueCarAirConditionYear");
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
                                text: "Report revenue booking car by air-conditioned in year"
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
    loadCharRevenueCarInYear: function (year) {
      //  $('canvas#ChartRevenueCarYear').remove();
      //  $('#divChartRevenueCarYear').html('<canvas id="ChartRevenueCarYear" style="height:300px;"> </canvas>');
        $(document).ready(function () {
            $.ajax({
                type: 'GET',
                url: "revenue-car-year",
                data: {year: year},
                dataType: 'json',
                success: function (ldata) {
                  
                    let lstLable = [];
                    let lstDataSource = [];
                    $.each(ldata, function (index, item) {
                        lstLable.push(item.month);
                        lstDataSource.push(item.revenue);
                    });
                    let ctx = document.getElementById("ChartRevenueCarYear");
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
                                text: "Report revenue booking car in year"
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
    }

};
chartCar.init();

