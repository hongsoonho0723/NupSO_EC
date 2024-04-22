<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>NoopSO Admin Chart</title>
        <link href="${path}/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="${path}/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function() {
            // Area Chart Example
            var ctxArea = document.getElementById("myAreaChart").getContext('2d');
            var myAreaChart;
            var ctxPie = document.getElementById("myPieChart");
            var myPieChart;
            var ctxBar = document.getElementById("myBarChart").getContext('2d');;
            var myBarChart;
            
            var today = new Date();

            // 초기에 빈 차트를 그립니다.
            drawEmptyAreaChart();
            drawEmptyBarChart();
            drawEmptyPieChart();
            
            // AJAX를 사용하여 데이터를 가져옵니다.
            $.ajax({
                url: "${path}/ajax", // 서버에서 데이터를 가져오는 URL
                type: "post",
                dataType: "json",
                data: { key: "furniture", methodName: "selectChartAll" },
                success: function(result) {
                    // 성공적으로 데이터를 가져왔을 때, 차트를 업데이트합니다.
                    console.log(result)
                    updateAreaChart(result.furnitureList);
                    updatePieChart(result.maleCount,result.femaleCount);
                    updateBarChart(result.reviewCountList);
                },
                error: function(err) {
                    // 에러가 발생했을 때의 처리
                    console.error("Error:", err);
                }
            });

            // 빈 차트를 그리는 함수
            function drawEmptyAreaChart() {
                myAreaChart = new Chart(ctxArea, {
                    type: 'line',
                    data: {
                        labels: [],
                        datasets: [{
                            label: "가구 판매량",
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
            
            function drawEmptyBarChart() {
            	myBarChart = new Chart(ctxBar, {
                    type: 'bar',
                    data: {
                        labels: [],
                        datasets: [{
                            label: "리뷰 달린 제품",
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
             
            
            function drawEmptyPieChart() {
            	myPieChart = new Chart(ctxPie, {
            		type: 'pie',
            		  data: {
            		    labels: ["남자","여자"],
            		    datasets: [{
            		      data: [0,0],
            		      backgroundColor: ['#007bff', '#dc3545'],
            		    }],
            		  },
                });
            }

            // 데이터를 받아 차트를 업데이트하는 함수
            function updateAreaChart(data) {
                var labels = [""];
                var dataSet = [0];

                // 데이터를 처리하여 labels와 dataSet을 채웁니다.
                data.forEach(function(item) { labels.push(item.furnitureName); dataSet.push(item.saleCount); });

                // 차트의 데이터를 업데이트하고 차트를 다시 그립니다.
                myAreaChart.data.labels = labels;
                myAreaChart.data.datasets[0].data = dataSet;
                myAreaChart.update();
            }//area 업데이트 end
            
            function updateBarChart(data) {
                var labels = [];
                var dataSet = [];

                // 데이터를 처리하여 labels와 dataSet을 채웁니다.
                data.forEach(function(item) { labels.push(item.furniture.furnitureName); dataSet.push(item.count); });

                // 차트의 데이터를 업데이트하고 차트를 다시 그립니다.
                myBarChart.data.labels = labels;
                myBarChart.data.datasets[0].data = dataSet;
                myBarChart.update();
            }//bar 업데이트 end
            
            function updatePieChart(maleDate,femaleDate) {
                myPieChart.data.datasets[0].data[0] = maleDate;
                myPieChart.data.datasets[0].data[1] = femaleDate;
                myPieChart.update();
            }//pie 업데이트 end
           
            $(".card-footer").text("Update 날짜 "+today.toLocaleString());
            
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
                        <h1 class="mt-4">Charts</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="${path}/admin/adminCharts.jsp">새로고침</a></li>
                            <li class="breadcrumb-item active">Charts</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-chart-area me-1"></i>
                                제품별 판매량
                            </div>
                            <div class="card-body"><canvas id="myAreaChart" width="100%" height="30"></canvas></div>
                            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                        </div>
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-bar me-1"></i>
                                     제품별 리뷰 개수 
                                    </div>
                                    <div class="card-body"><canvas id="myBarChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="card mb-4">
                                    <div class="card-header">
                                        <i class="fas fa-chart-pie me-1"></i>
                                        현재 회원 성별 분포도
                                    </div>
                                    <div class="card-body"><canvas id="myPieChart" width="100%" height="50"></canvas></div>
                                    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
                                </div>
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
    </body>
</html>
    