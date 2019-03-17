package sample.charts;

import java.util.ArrayList;

public class Chart {

    protected String typeToString(String type)
    {
        return "\"type\":\"" + type.toString() + "\"";
    }

    protected String joinToJson(String title, ArrayList<String> joinable)
    {
        return "\"" + title + "\":{" + String.join(",", joinable) + "}";
    }
}
