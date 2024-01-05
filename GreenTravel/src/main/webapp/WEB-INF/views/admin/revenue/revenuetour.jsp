<%-- 
    Author     : kyqua
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Revenue Tour</h4>


    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Tour Type In Month </h5>
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
        <div id="divChartRevenueTourType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueTourType" style="height:300px;"> </canvas>
        </div>        
    </div>
    <hr class="my-5"/>

    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Tour Area In Month </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthTourArea" >
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
        <div id="divChartRevenueTourArea" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueTourArea" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>

    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Province In Month </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthProvince" >
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
        <div id="divChartRevenueProvince" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueProvince" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Tour In Year </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllTourInYear" >
                    <option value="2022">2022</option>  
                    <option value="2023">2023</option>  
                </select>
            </small>
        </div>
        <div id="divChartRevenueTourInYear" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueTourInYear" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
</div>
     

        <script src="<c:url value="/resources/admin/jscustom/js-controller-revenuetour.js"/>"></script>
