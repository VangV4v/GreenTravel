<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Statistic Booking Car</h4>     
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Air-Conditioned In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthAirCondition">
                    <option value='1'>January</option>
                    <option value='2'>February</option>
                    <option value='3'>March</option>
                    <option value='4'>April</option>
                    <option value='5'>May</option>
                    <option value='6'>June</option>
                    <option value='7'>July</option>
                    <option value='8'>August</option>
                    <option value='9'>September</option>
                    <option value='10'>October</option>
                    <option value='11'>November</option>
                    <option value='12'>December</option>                 
                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityTourType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="chartStatisticAirCondition" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Non Air-Conditioned In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthUnAirCondition">
                    <option value='1'>January</option>
                    <option value='2'>February</option>
                    <option value='3'>March</option>
                    <option value='4'>April</option>
                    <option value='5'>May</option>
                    <option value='6'>June</option>
                    <option value='7'>July</option>
                    <option value='8'>August</option>
                    <option value='9'>September</option>
                    <option value='10'>October</option>
                    <option value='11'>November</option>
                    <option value='12'>December</option>                 
                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityTourType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="chartStatisticUnAirCondition" style="height:300px;"> </canvas>
        </div> 
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Car Model In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthTypeCar">
                    <option value='1'>January</option>
                    <option value='2'>February</option>
                    <option value='3'>March</option>
                    <option value='4'>April</option>
                    <option value='5'>May</option>
                    <option value='6'>June</option>
                    <option value='7'>July</option>
                    <option value='8'>August</option>
                    <option value='9'>September</option>
                    <option value='10'>October</option>
                    <option value='11'>November</option>
                    <option value='12'>December</option>                 
                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityTourType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="chartStatisticTypeCar" style="height:300px;"> </canvas>
        </div> 
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Car Type In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthModelCar">
                    <option value='1'>January</option>
                    <option value='2'>February</option>
                    <option value='3'>March</option>
                    <option value='4'>April</option>
                    <option value='5'>May</option>
                    <option value='6'>June</option>
                    <option value='7'>July</option>
                    <option value='8'>August</option>
                    <option value='9'>September</option>
                    <option value='10'>October</option>
                    <option value='11'>November</option>
                    <option value='12'>December</option>                 
                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityTourType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="chartStatisticModelCar" style="height:300px;"> </canvas>
        </div> 
    </div>
</div>          
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>   
<script src="<c:url value="/resources/admin/jscustom/js-controller-statistic-car.js"/>"></script>
