package sample.charts.chart;

import java.util.ArrayList;

public class Dataset {

    private ArrayList<Integer> dps;
    private String lbl;
    private String bc;
    private Boolean fl;

    public Dataset(
        ArrayList<Integer> datapoints,
        String label,
        String borderColor,
        Boolean fill
    )
    {
        this.dps = datapoints;
        this.lbl = label;
        this.bc = borderColor;
        this.fl = fill;
    }

    public Dataset(
        ArrayList<Integer> datapoints,
        String label,
        String borderColor
    )
    {
        this.dps = datapoints;
        this.lbl = label;
        this.bc = borderColor;
        this.fl = false;
    }

    public Dataset(
        ArrayList<Integer> datapoints,
        String label
    )
    {
        this.dps = datapoints;
        this.lbl = label;
        this.bc = "";
        this.fl = false;
    }

    public Dataset(
        ArrayList<Integer> datapoints
    )
    {
        this.dps = datapoints;
        this.lbl = "";
        this.bc = "";
        this.fl = false;
    }

    public String toJson()
    {
        ArrayList<String> joinable = new ArrayList<>();
        joinable.add("\"data\":" + this.dps.toString());
        if (this.lbl.length() > 0) joinable.add("\"label\":\"" + this.lbl + "\"");
        if (this.bc.length() > 0) joinable.add("\"borderColor\":\"" + this.bc + "\"");
        if (this.fl) joinable.add("\"fill\":true");
        else joinable.add("\"fill\":false");
        return "{" + String.join(",", joinable) + "}";
    }
}
