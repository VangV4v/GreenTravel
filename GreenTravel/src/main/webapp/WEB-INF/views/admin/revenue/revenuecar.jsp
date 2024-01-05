<%-- 
    Author     : kyqua
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-xxl flex-grow-1 container-p-y">
    <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Home /</span> Revenue Car</h4>


    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Car Model In Month </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthCarModel">
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
        <div id="divChartRevenueCarModel" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueCarModel" style="height:300px;"> </canvas>
        </div>        
    </div>
    <hr class="my-5"/>

    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Car Type In Month </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllMonthCarType" >
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
        <div id="divChartRevenueCarType" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueCarType" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Car Non Air Condition In Year </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllCarNonAirConditionYear" >
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                </select>
            </small>
        </div>
        <div id="divChartRevenueCarNonAirConditionYear" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueCarNonAirConditionYear" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Car Air Condition In Year </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllCarAirConditionYear" >
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                </select>
            </small>
        </div>
        <div id="divChartRevenueCarAirConditionYear" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueCarAirConditionYear" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
    <div class="card">
        <div style="padding-bottom: 0px" class="card-header d-flex justify-content-between align-items-center">
            <h5 class="mb-0">Revenue Car In Year </h5>
            <small class="text-muted float-end">
                <select class="form-select" id="sllCarYear" >
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>
                </select>
            </small>
        </div>
        <div id="divChartRevenueCarYear" style="font-family: Corbel; font-size: small ;text-align:center " class="row">
            <canvas id="ChartRevenueCarYear" style="height:300px;"> </canvas>
        </div>  
    </div>
    <hr class="my-5"/>
</div>
       

  <script src="<c:url value="/resources/admin/jscustom/js-controller-revenuecar.js"/>"></script>