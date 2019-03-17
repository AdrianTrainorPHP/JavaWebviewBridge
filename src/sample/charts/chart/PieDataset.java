package sample.charts.chart;

import java.util.ArrayList;

public class PieDataset {

    private ArrayList<Integer> datapoints;
    private String label;
    private ArrayList<String> backgroundColors;

    public PieDataset(
        ArrayList<Integer> datapoints,
        String label,
        ArrayList<String> backgroundColors
    )
    {
        this.datapoints = datapoints;
        this.label = label;
        this.backgroundColors = backgroundColors;
    }

    public PieDataset(
        ArrayList<Integer> datapoints,
        String label
    )
    {
        this.datapoints = datapoints;
        this.label = label;
        this.backgroundColors = new ArrayList<>();
    }

    public PieDataset(
        ArrayList<Integer> datapoints
    )
    {
        this.datapoints = datapoints;
        this.label = "";
        this.backgroundColors = new ArrayList<>();
    }

    public String toJson()
    {
        ArrayList<String> joinable = new ArrayList<>();
        joinable.add("\"data\":" + this.datapoints.toString());
        if (this.label.length() > 0) joinable.add("\"label\":\"" + this.label + "\"");
        if (this.backgroundColors.size() > 0) joinable.add("\"backgroundColor\":[\"" + String.join("\",\"", this.backgroundColors) + "\"]");
        return "{" + String.join(",", joinable) + "}";
    }
}
