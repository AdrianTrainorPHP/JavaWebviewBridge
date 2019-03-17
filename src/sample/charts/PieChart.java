package sample.charts;

import sample.charts.chart.PieDataset;
import java.util.ArrayList;

public class PieChart extends Chart
{
    private String type = "pie";
    private ArrayList<String> labels;
    private PieDataset dataset;

    public PieChart(
        ArrayList<String> labels,
        PieDataset dataset
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
