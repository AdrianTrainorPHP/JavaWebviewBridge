
$(document).ready(function () {
    var bridge = new BridgeConnection();

    var ChartHandler = function () {
        var self = this;

        function triggerExitApp() {
            $(document).on('click', '#exit-app', function (e) {
                e.preventDefault();
                Bridge.exit();
            });
        }

        function loadChartOne() {
            var chartOneData = Bridge.getChartOneData();
            chartOneData = $.parseJSON(chartOneData);
            new Chart(document.getElementById('bar-one').getContext('2d'), chartOneData);
        }

        function loadChartTwo() {
            var chartTwoData = Bridge.getChartTwoData();
            chartTwoData = $.parseJSON(chartTwoData);
            new Chart(document.getElementById('bar-two').getContext('2d'), chartTwoData);
        }

        function loadChartThree() {
            var chartThreeData = Bridge.getChartThreeData();
            chartThreeData = $.parseJSON(chartThreeData);
            new Chart(document.getElementById('pie-one'), chartThreeData);
        }

        function loadLineOne() {
            var chartFourData = Bridge.getChartFourData();
            chartFourData = $.parseJSON(chartFourData);
            new Chart(document.getElementById('line-one'), chartFourData);
        }

        self.postInit = function () {
            triggerExitApp();
            loadChartOne();
            loadChartTwo();
            loadChartThree();
            loadLineOne();
        };
    };

    var chart = new ChartHandler();

    bridge.addPostInitHandler(chart, 'postInit');
    bridge.init();
});