package sample.charts;

import sample.charts.chart.BarDataset;

import java.util.ArrayList;

public class BarChart extends Chart
{
    private String type = "bar";
    private ArrayList<String> labels;
    private BarDataset dataset;

    public BarChart(
            ArrayList<String> labels,
            BarDataset dataset
    )
    {
        this.labels = labels;
        this.dataset = dataset;
    }

    public String toJson()
    {
        ArrayList<String> dataJoinable = new ArrayList<>();
        dataJoinable.add("\"labels\":[\"" + String.join("\",\"", this.labels) + "\"]");
        dataJoinable.add("\"datasets\":[" + this.dataset.toJson() + "]");

        ArrayList<String> joinable = new ArrayList<>();
        joinable.add(this.typeToString(this.type));
        joinable.add(this.joinToJson("data", dataJoinable));
        joinable.add("\"options\":{\"legend\":{\"display\":false}}");
        return "{" + String.join(",", joinable) + "}";
    }
}
