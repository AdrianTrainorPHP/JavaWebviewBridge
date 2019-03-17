package sample.charts;

import sample.charts.chart.Dataset;

import java.util.ArrayList;

public class LineChart extends Chart
{
    private String type = "line";
    private ArrayList<String> labels;
    private ArrayList<Dataset> datasets;

    public LineChart(
            ArrayList<String> labels,
            ArrayList<Dataset> datasets
    )
    {
        this.labels = labels;
        this.datasets = datasets;
    }

    private String dssToString()
    {
        ArrayList<String> dss = new ArrayList<>();
        for (Dataset ds : this.datasets) {
            dss.add(ds.toJson());
        }
        return "[" + String.join(",", dss) + "]";
    }

    public String toJson()
    {
        ArrayList<String> dataJoinable = new ArrayList<>();
        dataJoinable.add("\"labels\":[\"" + String.join("\",\"", this.labels) + "\"]");
        dataJoinable.add("\"datasets\":" + this.dssToString());

        ArrayList<String> joinable = new ArrayList<>();
        joinable.add("\"type\":\"" + this.type.toString() + "\"");
        joinable.add("\"data\":{" + String.join(",", dataJoinable) + "}");
        joinable.add("\"options\":{\"legend\":{\"display\":false}}");
        return "{" + String.join(",", joinable) + "}";
    }
}
