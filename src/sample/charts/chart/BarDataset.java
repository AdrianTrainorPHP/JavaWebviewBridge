package sample.charts.chart;

import java.util.ArrayList;

public class BarDataset {

    private ArrayList<ArrayList<Integer>> datapoints;
    private ArrayList<String> labels;
    private ArrayList<ArrayList<String>> backgroundColors;
    private ArrayList<ArrayList<String>> borderColors;

    public BarDataset(
        ArrayList<ArrayList<Integer>> datapoints,
        ArrayList<String> labels,
        ArrayList<ArrayList<String>> backgroundColors,
        ArrayList<ArrayList<String>> borderColors
    )
    {
        this.datapoints = datapoints;
        this.labels = labels;
        this.backgroundColors = backgroundColors;
        this.borderColors = borderColors;
    }

    public BarDataset(
        ArrayList<ArrayList<Integer>> datapoints,
        ArrayList<String> labels,
        ArrayList<ArrayList<String>> backgroundColors
    )
    {
        this.datapoints = datapoints;
        this.labels = labels;
        this.backgroundColors = backgroundColors;
        this.borderColors = new ArrayList<>();
    }

    public BarDataset(
        ArrayList<ArrayList<Integer>> datapoints,
        ArrayList<String> labels
    )
    {
        this.datapoints = datapoints;
        this.labels = labels;
        this.backgroundColors = new ArrayList<>();
        this.borderColors = new ArrayList<>();
    }

    public BarDataset(
        ArrayList<ArrayList<Integer>> datapoints
    )
    {
        this.datapoints = datapoints;
        this.labels = new ArrayList<>();
        this.backgroundColors = new ArrayList<>();
        this.borderColors = new ArrayList<>();
    }

    public String toJson()
    {
        ArrayList<String> joinable = new ArrayList<>();
        Integer indexCounter = 0;
        for (ArrayList datapointList: this.datapoints) {
            ArrayList<String> joinableDatapoints = new ArrayList<>();
            joinableDatapoints.add("\"data\":" + datapointList.toString());
            try {
                String label = this.labels.get(indexCounter);
                if (label.length() > 0)
                    joinableDatapoints.add("\"label\":\"" + label + "\"");
            } catch (IndexOutOfBoundsException exception) {
                // do nothing
            }

            try {
                ArrayList<String> backgroundColors = this.backgroundColors.get(indexCounter);
                if (backgroundColors.size() > 0)
                    joinableDatapoints.add("\"backgroundColor\":[\"" + String.join("\",\"", backgroundColors) + "\"]");
            } catch (IndexOutOfBoundsException exception) {
                // do nothing
            }

            try {
                ArrayList<String> borderColors = this.borderColors.get(indexCounter);
                if (borderColors.size() > 0)
                    joinableDatapoints.add("\"borderColor\":[\"" + String.join("\",\"", borderColors) + "\"]");
            } catch (IndexOutOfBoundsException exception) {
                // do nothing
            }
            joinable.add("{" + String.join(",", joinableDatapoints) + "}");
        }
        return String.join(",", joinable);
    }
}
