package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import sample.bridges.ChartBridge;
import sample.charts.BarChart;
import sample.charts.LineChart;
import sample.charts.PieChart;
import sample.charts.chart.BarDataset;
import sample.charts.chart.Dataset;
import sample.charts.chart.PieDataset;

import java.util.ArrayList;

public class Main extends Application {

    /*
     * IMPORTANT: Reference to the html file which is to be loaded into the 2nd StackPane
     */
    private static final String WEBVIEW_PANEL = "./webview/panel.html";

    @Override
    public void start(Stage stage) {
        final WebView sp2webview = new WebView();
        final WebEngine webengine = sp2webview.getEngine();
        final ChartBridge bridge = new ChartBridge(
            this.lineChartOne(),
            this.barChartOne(),
            this.pieChartOne(),
            this.barChartTwo()
        );

        bridge.addBridgeToWebEngine(webengine);

        String url = Main.class.getResource(WEBVIEW_PANEL).toExternalForm();
        webengine.load(url);

        Scene scene = new Scene(sp2webview);

        stage.setScene(scene);
        stage.show();
    }

    private BarChart barChartOne()
    {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Label One");
        labels.add("Label Two");
        labels.add("Label Three");

        ArrayList<ArrayList<String>> backgroundColors = new ArrayList<>();
        ArrayList<String> backgroundColorList = new ArrayList<>();
        backgroundColorList.add("rgba(255, 99, 132, 0.8)");
        backgroundColorList.add("rgba(54, 162, 235, 0.8)");
        backgroundColorList.add("rgba(255, 206, 86, 0.8)");
        backgroundColors.add(backgroundColorList);

        ArrayList<ArrayList<String>> borderColors = new ArrayList<>();
        ArrayList<String> borderColorList = new ArrayList<>();
        borderColorList.add("rgba(255, 99, 132, 1)");
        borderColorList.add("rgba(54, 162, 235, 1)");
        borderColorList.add("rgba(255, 206, 86, 1)");
        borderColors.add(borderColorList);

        ArrayList<ArrayList<Integer>> datapoints = new ArrayList<>();
        ArrayList<Integer> datapointsList = new ArrayList<>();
        datapointsList.add(123);
        datapointsList.add(213);
        datapointsList.add(321);
        datapoints.add(datapointsList);

        BarDataset dataset = new BarDataset(datapoints, labels, backgroundColors, borderColors);
        return new BarChart(labels, dataset);
    }

    private BarChart barChartTwo()
    {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Label One");
        labels.add("Label Two");
        labels.add("Label Three");

        ArrayList<ArrayList<String>> backgroundColors = new ArrayList<>();
        ArrayList<String> backgroundColorList = new ArrayList<>();
        backgroundColorList.add("rgba(255, 99, 132, 0.8)");
        backgroundColorList.add("rgba(54, 162, 235, 0.8)");
        backgroundColorList.add("rgba(255, 206, 86, 0.8)");
        backgroundColors.add(backgroundColorList);
        backgroundColors.add(backgroundColorList);
        backgroundColors.add(backgroundColorList);

        ArrayList<ArrayList<String>> borderColors = new ArrayList<>();
        ArrayList<String> borderColorList = new ArrayList<>();
        borderColorList.add("rgba(255, 99, 132, 1)");
        borderColorList.add("rgba(54, 162, 235, 1)");
        borderColorList.add("rgba(255, 206, 86, 1)");
        borderColors.add(borderColorList);
        borderColors.add(borderColorList);
        borderColors.add(borderColorList);

        ArrayList<ArrayList<Integer>> datapoints = new ArrayList<>();
        ArrayList<Integer> datapointsListOne = new ArrayList<>();
        datapointsListOne.add(123);
        datapointsListOne.add(213);
        datapointsListOne.add(321);
        datapoints.add(datapointsListOne);
        ArrayList<Integer> datapointsListTwo = new ArrayList<>();
        datapointsListTwo.add(298);
        datapointsListTwo.add(462);
        datapointsListTwo.add(634);
        datapoints.add(datapointsListTwo);
        ArrayList<Integer> datapointsListThree = new ArrayList<>();
        datapointsListThree.add(298);
        datapointsListThree.add(462);
        datapointsListThree.add(634);
        datapoints.add(datapointsListThree);

        BarDataset dataset = new BarDataset(datapoints, labels, backgroundColors, borderColors);
        return new BarChart(labels, dataset);
    }

    private PieChart pieChartOne()
    {
        ArrayList<String> labels = new ArrayList<>();
        labels.add("Label One");
        labels.add("Label Two");
        labels.add("Label Three");

        ArrayList<String> backgroundColors = new ArrayList<>();
        backgroundColors.add("rgba(255, 99, 132, 0.8)");
        backgroundColors.add("rgba(54, 162, 235, 0.8)");
        backgroundColors.add("rgba(255, 206, 86, 0.8)");

        ArrayList<Integer> datapoints = new ArrayList<>();
        datapoints.add(123);
        datapoints.add(213);
        datapoints.add(321);

        PieDataset dataset = new PieDataset(datapoints, "Label name", backgroundColors);
        return new PieChart(labels, dataset);
    }

    private LineChart lineChartOne()
    {
        ArrayList<String> labels = new ArrayList<>();
        ArrayList<Dataset> datasets = new ArrayList<>();
        labels.add("1500");
        labels.add("1600");
        labels.add("1700");
        labels.add("1800");
        labels.add("1850");
        labels.add("1900");
        labels.add("1950");
        labels.add("1999");
        labels.add("2050");

        ArrayList<Integer> dataPointsOne = new ArrayList<>();
        dataPointsOne.add(86); dataPointsOne.add(114); dataPointsOne.add(106);
        dataPointsOne.add(106); dataPointsOne.add(107); dataPointsOne.add(111);
        dataPointsOne.add(133); dataPointsOne.add(221); dataPointsOne.add(783);
        dataPointsOne.add(2478);
        datasets.add(new Dataset(dataPointsOne, "Africa", "#3e95cd"));

        ArrayList<Integer> dataPointsTwo = new ArrayList<>();
        dataPointsTwo.add(282); dataPointsTwo.add(350); dataPointsTwo.add(411);
        dataPointsTwo.add(502); dataPointsTwo.add(635); dataPointsTwo.add(809);
        dataPointsTwo.add(947); dataPointsTwo.add(1402); dataPointsTwo.add(3700);
        dataPointsTwo.add(5267);
        datasets.add(new Dataset(dataPointsTwo, "Asia", "#8e5ea2"));

        ArrayList<Integer> dataPointsThree = new ArrayList<>();
        dataPointsThree.add(168); dataPointsThree.add(170); dataPointsThree.add(178);
        dataPointsThree.add(190); dataPointsThree.add(203); dataPointsThree.add(276);
        dataPointsThree.add(408); dataPointsThree.add(547); dataPointsThree.add(675);
        dataPointsThree.add(734);
        datasets.add(new Dataset(dataPointsThree, "Europe", "#3cba9f"));

        ArrayList<Integer> dataPointsFour = new ArrayList<>();
        dataPointsFour.add(40); dataPointsFour.add(20); dataPointsFour.add(10);
        dataPointsFour.add(16); dataPointsFour.add(24); dataPointsFour.add(38);
        dataPointsFour.add(74); dataPointsFour.add(167); dataPointsFour.add(508);
        dataPointsFour.add(784);
        datasets.add(new Dataset(dataPointsFour, "Latin America", "#e8c3b9"));

        ArrayList<Integer> dataPointsFive = new ArrayList<>();
        dataPointsFive.add(6); dataPointsFive.add(3); dataPointsFive.add(2);
        dataPointsFive.add(2); dataPointsFive.add(7); dataPointsFive.add(26);
        dataPointsFive.add(82); dataPointsFive.add(172); dataPointsFive.add(312);
        dataPointsFive.add(433);
        datasets.add(new Dataset(dataPointsFive, "North America", "#c45850"));

        return new LineChart(labels, datasets);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
