<%-- 
    Author     : kyqua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span>Statistic Booking Tour</h4>  
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Tour Type In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthTourType">
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
            <canvas id="ChartStatisticQuantityTourType" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking From Province In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthFromProvince">
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
        <div id="divChartStatisticQuantityFromProvince" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantityFromProvince" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking By Area In Month</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthArea">
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
        <div id="divChartStatisticQuantityArea" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantityArea" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Tour In Year</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllYearTour">

                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityTour" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantityTour" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Available Slot In Year</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllYearSlot">

                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantitySlot" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantitySlot" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Booking Slot In Year</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllYearBooking">

                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityBooking" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantityBooking" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
<div class="container-xxl flex-grow-1 container-p-y">  
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Statistic Quantity Cancel Tour In Year</h5>   
            <small class="text-muted float-end">
                <select class="form-select" id="sllYearCancel">

                </select>
            </small>
        </div>  
        <div id="divChartStatisticQuantityCancel" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartStatisticQuantityCancel" style="height:300px;"> </canvas>
        </div>   
    </div>
</div>
             

        <script src="<c:url value="/resources/admin/jscustom/js-controller-statistic-packagetour.js"/>"></script>
