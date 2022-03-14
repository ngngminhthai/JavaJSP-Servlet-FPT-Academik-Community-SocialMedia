// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var views = [0, 0, 0, 0, 0, 0, 0];
function setView(mo, tu, we, th, fr, sa, su) {
    views[0] = parseInt(mo);
    views[1] = parseInt(tu);
    views[2] = parseInt(we);
    views[3] = parseInt(th);
    views[4] = parseInt(fr);
    views[5] = parseInt(sa);
    views[6] = parseInt(su);

// Area Chart Example
    var ctx = document.getElementById("myAreaChart");
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ["mo", "tu", "we", "th", "fr", "sa", "su"],
            datasets: [{
                    label: "Lượt truy cập",
                    lineTension: 0.3,
                    backgroundColor: "rgba(2,117,216,0.2)",
                    borderColor: "rgba(2,117,216,1)",
                    pointRadius: 5,
                    pointBackgroundColor: "rgba(2,117,216,1)",
                    pointBorderColor: "rgba(255,255,255,0.8)",
                    pointHoverRadius: 5,
                    pointHoverBackgroundColor: "rgba(2,117,216,1)",
                    pointHitRadius: 50,
                    pointBorderWidth: 2,
                    data: views,
                }],
        },
        options: {
            scales: {
                xAxes: [{
                        time: {
                            unit: 'date'
                        },
                        gridLines: {
                            display: false
                        },
                        ticks: {
                            maxTicksLimit: 12
                        }
                    }],
                yAxes: [{
                        ticks: {
                            min: 0,
      
                            maxTicksLimit: 5
                        },
                        gridLines: {
                            color: "rgba(0, 0, 0, .125)",
                        }
                    }],
            },
            legend: {
                display: false
            }
        }
    });



}

