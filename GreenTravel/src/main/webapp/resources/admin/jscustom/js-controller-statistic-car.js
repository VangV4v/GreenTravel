/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let car =
        {
            init: function () {
                let dt = new Date();
                let m = dt.getMonth() + 1;    
                car.register();
                car.setMonth(m);
                car.statisticQuantityByAirCondition(m);
                car.statisticQuantityByUnAirCondition(m);
                car.statisticQuantityByCarType(m);
                car.statisticQuantityByCarModel(m);
                car.register();
            },
            setMonth: function (m) {
                $('#sllMonthAirCondition').val(m);
                $('#sllMonthUnAirCondition').val(m);
                $('#sllMonthTypeCar').val(m);
                $('#sllMonthModelCar').val(m);
            },
            register: function () {

                $('#sllMonthAirCondition').on('change', function () {
                    car.statisticQuantityByAirCondition($(this).val());
                });
                $('#sllMonthUnAirCondition').on('change', function () {
                    car.statisticQuantityByUnAirCondition($(this).val());
                });
                $('#sllMonthTypeCar').on('change', function () {
                    car.statisticQuantityByCarType($(this).val());
                });
                $('#sllMonthModelCar').on('change', function () {
                    car.statisticQuantityByCarModel($(this).val());
                });
            }
            ,       
            statisticQuantityByAirCondition: function (m) {
                $.ajax({
                    type: 'GET',
                    url: "/GreenTravel/admin/employee/manage-car/statistic-car-air-conditon",
                    data: {month: m},
                    dataType: 'json',
                    success: function (data) {
                        var lstLable = [];
                        var lstDataSource = [];
                        $.each(data, function (index, item) {
                            lstLable.push(item.label);
                            lstDataSource.push(item.quantity);
                        });
                        let ctx = document.getElementById("chartStatisticAirCondition");
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
                                    text: "Report statistic quantity booking by air-conditioned car in month"
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
                                            }
                                        }]
                                }
                            }
                        });
                    }
                });
            },
            statisticQuantityByUnAirCondition: function (m) {
                $.ajax({
                    type: 'GET',
                    url: "/GreenTravel/admin/employee/manage-car/statistic-car-un-air-conditon",
                    data: {month: m},
                    dataType: 'json',
                    success: function (data) {
                        var lstLable = [];
                        var lstDataSource = [];
                        $.each(data, function (index, item) {
                            lstLable.push(item.label);
                            lstDataSource.push(item.quantity);
                        });
                        let ctx = document.getElementById("chartStatisticUnAirCondition");
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
                                    text: "Report statistic quantity booking by non air-conditioned car in month"
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
                                            }
                                        }]
                                }
                            }
                        });
                    }
                });
            },
            statisticQuantityByCarType: function (m) {
                console.log(m);
                $.ajax({
                    type: 'GET',
                    url: "/GreenTravel/admin/employee/manage-car/statistic-car-type",
                    data: {month: m},
                    dataType: 'json',
                    success: function (data) {
                        console.log(data);
                        var lstLable = [];
                        var lstDataSource = [];
                        $.each(data, function (index, item) {
                            console.log("==" + item.label);
                            lstLable.push(item.label);
                            lstDataSource.push(item.quantity);
                        });
                        let ctx = document.getElementById("chartStatisticTypeCar");
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
                                    text: "Report statistic quantity booking by car type in month"
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
                                            }
                                        }]
                                }
                            }
                        });
                    }
                });
            },
            statisticQuantityByCarModel: function (m) {
                console.log(m);
                $.ajax({
                    type: 'GET',
                    url: "/GreenTravel/admin/employee/manage-car/statistic-car-model",
                    data: {month: m},
                    dataType: 'json',
                    success: function (data) {
                        console.log(data);
                        var lstLable = [];
                        var lstDataSource = [];
                        $.each(data, function (index, item) {
                            console.log("==" + item.label);
                            lstLable.push(item.label);
                            lstDataSource.push(item.quantity);
                        });
                        let ctx = document.getElementById("chartStatisticModelCar");
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
                                    text: "Report statistic quantity booking by car model in month"
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
                                            }
                                        }]
                                }
                            }
                        });
                    }
                });
            }
        };
car.init();
