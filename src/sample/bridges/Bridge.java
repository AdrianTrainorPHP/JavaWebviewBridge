package sample.bridges;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import netscape.javascript.JSObject;

public class Bridge
{
    public void addBridgeToWebEngine(WebEngine webengine)
    {
        Bridge self = this;
        webengine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    @Override
                    public void changed(
                            ObservableValue ov,
                            Worker.State oldState,
                            Worker.State newState
                    ) {

                        if (newState == Worker.State.SUCCEEDED) {

                            /*
                             * IMPORTANT: When the WebEngine has loaded - inject the "Bridge" into the window (accessible in JavaScript as "Bridge" variable
                             */
                            JSObject win = (JSObject) webengine.executeScript("window");
                            win.setMember("Bridge", self);
                        }

                    }
                });
    }

    public void log(String message)
    {
        System.out.println(message);
    }

    public void exit()
    {
        this.log("Bridge.exit called");
        Platform.exit();
    }
}