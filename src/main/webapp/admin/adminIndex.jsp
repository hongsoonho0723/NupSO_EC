<%@page import="dto.OrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>NupSo Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="${path}/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="${path}/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            // Area Chart Example
            var ctxArea = document.getElementById("myAreaChart");
            var myAreaChart;
            var ctxBar = document.getElementById("myBarChart").getContext('2d');;
            var myBarChart;
            
            var today = new Date();

            // 초기에 빈 차트를 그립니다.
            drawEmptyAreaChart();
            drawEmptyBarChart();
            
            // AJAX를 사용하여 데이터를 가져옵니다.
            $.ajax({
                url: "${path}/ajax", // 서버에서 데이터를 가져오는 URL
                type: "post",
                dataType: "json",
                data: { key: "furnitureAjax", methodName: "selectChartAll" },
                success: function(result) {
                    // 성공적으로 데이터를 가져왔을 때, 차트를 업데이트합니다.
                    updateAreaChart(result.qnaCountList);
                    updateBarChart(result.furnitureList);
                },
                error: function(err) {
                    // 에러가 발생했을 때의 처리
                    console.error("Error:", err);
                }
            });

            // 빈 차트를 그리는 함수
            function drawEmptyAreaChart() {
                myAreaChart = new Chart(ctxArea, {
                    type: 'bar',
                    data: {
                        labels: [],
                        datasets: [{
                            label: "QnA",
                            data: [],
                            lineTension: 0.3,
                            backgroundColor: "rgba(2,117,216,0.2)",
                            borderColor: "rgba(2,117,216,1)",
                            pointRadius: 5,
                            pointBackgroundColor: "rgba(2,117,216,1)",
                            pointBorderColor: "rgba(255,255,255,0.8)",
                            pointHoverRadius: 5,
                            pointHoverBackgroundColor: "rgba(2,117,216,1)",
                            pointHitRadius: 50,
                            pointBorderWidth: 2
                        }]
                    },
                    options: {
                    	scales: {
                            y: {
                            	suggestedMin: 0, // y 축의 최소 값
                                ticks: {
                                    stepSize: 1 // y 축 간격을 1로 설정
                                }
                            }
                        },
                        plugins: {
                            legend: {
                                display: false,
                                position: 'right'
                            }
                        }
                    }
                });
            }

            
            function drawEmptyBarChart() {
            	myBarChart = new Chart(ctxBar, {
                    type: 'bar',
                    data: {
                        labels: [],
                        datasets: [{
                            label: "재고",
                            data: [],
                            lineTension: 0.3,
                            backgroundColor: "rgba(2,117,216,0.2)",
                            borderColor: "rgba(2,117,216,1)",
                            pointRadius: 5,
                            pointBackgroundColor: "rgba(2,117,216,1)",
                            pointBorderColor: "rgba(255,255,255,0.8)",
                            pointHoverRadius: 5,
                            pointHoverBackgroundColor: "rgba(2,117,216,1)",
                            pointHitRadius: 50,
                            pointBorderWidth: 2
                        }]
                    },
                    options: {
                        // 그래프의 옵션 설정
                    }
                });
            }
            

            // 데이터를 받아 차트를 업데이트하는 함수
            function updateAreaChart(data) {
                var labels = [""];
                var dataSet = [0];

                // 데이터를 처리하여 labels와 dataSet을 채웁니다.
                data.forEach(function(item) { labels.push(item.furniture.furnitureName); dataSet.push(item.qnaCount); });

                // 차트의 데이터를 업데이트하고 차트를 다시 그립니다.
                myAreaChart.data.labels = labels;
                myAreaChart.data.datasets[0].data = dataSet;
                myAreaChart.update();
            }//area 업데이트 end
            
            function updateBarChart(data) {
                var labels = [""];
                var dataSet = [0];

                // 데이터를 처리하여 labels와 dataSet을 채웁니다.
                data.forEach(function(item) { labels.push(item.furnitureName); dataSet.push(parseInt(item.stock)); });

                // 차트의 데이터를 업데이트하고 차트를 다시 그립니다.
                myBarChart.data.labels = labels;
                myBarChart.data.datasets[0].data = dataSet;
                myBarChart.update();
            }//bar 업데이트 end

            
        });

        </script>
        
    </head>
    <body class="sb-nav-fixed">
      <jsp:include page="../common/admin/header.jsp"></jsp:include>
        <div id="layoutSidenav">
            <jsp:include page="../common/admin/sideNav.jsp"></jsp:include>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Main</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div class="row">
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-primary text-white mb-4">
                                    <div class="card-body">상품 관리</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">관리 페이지</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-warning text-white mb-4">
                                    <div class="card-body">배송 관리</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="#">관리 페이지</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-success text-white mb-4">
                                    <div class="card-body">QnA 관리</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="${path}/front?key=qna&methodName=selectAll">관리 페이지</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xl-3 col-md-6">
                                <div class="card bg-danger text-white mb-4">
                                    <div class="card-body">데이터 분석</div>
                                    <div class="card-footer d-flex align-items-center justify-content-between">
                                        <a class="small text-white stretched-link" href="${path}/admin/adminCharts.jsp">관리 페이지</a>
                                        <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-area me-1"></i>
                                        QnA 현황
                                    </div>
                                    <div class="card-body"><canvas id="myAreaChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                            <div class="col-xl-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                       재고 현황
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="40"></canvas></div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                주문 현황
                            </div>
                            <div class="card-body">
                                <table id="datatablesSimple">
                                    <thead>
                                        <tr>
                                            <th>OrederSeq</th>
                                            <th>FurnitureNumber</th>
                                            <th>FurnitureName</th>
                                            <th>Color</th>
                                            <th>Size</th>
                                            <th>Delivery Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                              		     <c:forEach items="${list}" var="item">
										   <tr>
										     <td class="orderSeq">${item.orderSeq}</td>
										     <td class="furnitureNumber">${item.furniture.furnitureNumber}</td>
										     <td class="furnitureName">${item.furniture.furnitureName}</td>
										     <td class="colorName">${item.orderInfo.colorName}</td>
										     <td class="sizeVal">${item.orderInfo.sizeVal}</td>
										     <td class="deliveryDate">${item.deliveryDate}</td>
										   </tr>
										</c:forEach>                                            
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </main>
				<jsp:include page="../common/admin/footer.jsp"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${path}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${path}/js/datatables-simple-demo.js"></script>
    </body>
</html>
