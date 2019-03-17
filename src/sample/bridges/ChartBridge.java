package sample.bridges;

import sample.charts.BarChart;
import sample.charts.LineChart;
import sample.charts.PieChart;

public class ChartBridge extends Bridge
{
    private LineChart lineChartOne;
    private BarChart barChartOne;
    private BarChart barChartTwo;
    private PieChart pieChartOne;

    public ChartBridge(
        LineChart lineChartOne,
        BarChart barChartOne,
        PieChart pieChartOne,
        BarChart barChartTwo
    )
    {
        this.lineChartOne = lineChartOne;
        this.barChartOne = barChartOne;
        this.barChartTwo = barChartTwo;
        this.pieChartOne = pieChartOne;
    }

    public String getChartOneData()
    {
        return this.barChartOne.toJson();
    }

    public String getChartTwoData()
    {
        return this.barChartTwo.toJson();
    }

    public String getChartThreeData()
    {
        return this.pieChartOne.toJson();
    }

    public String getChartFourData()
    {
        return this.lineChartOne.toJson();
    }
}
