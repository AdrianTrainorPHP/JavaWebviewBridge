package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

    /*
     * IMPORTANT: Reference to the html file which is to be loaded into the 2nd StackPane
     */
    private static final String WEBVIEW_PANEL = "./webview/panel.html";

    @Override
    public void start(Stage stage) throws Exception {
        final WebView sp2webview = new WebView();
        final WebEngine webengine = sp2webview.getEngine();

        /*
         * IMPORTANT: When the WebEngine has loaded - inject the "Bridge" into the window (accessible in JavaScript as "Bridge" variable
         */
        final Bridge bridge = new Bridge();
        bridge.addBridgeToWebEngine(webengine);

        /*
         * IMPORTANT: Load "./webview/panel.html" into WebView.WebEngine
         */
        String url = Main.class.getResource(WEBVIEW_PANEL).toExternalForm();
        webengine.load(url);

        SplitPane sp = new SplitPane();
        final StackPane sp1 = new StackPane();
        final StackPane sp2 = new StackPane();

        /*
         * IMPORTANT: Load WebView into the 2nd StackPane
         */
        sp2.getChildren().add(sp2webview);

        sp.getItems().addAll(sp1, sp2);
        sp.setDividerPositions(0.3f, 0.6f);


        VBox layout = new VBox();
        layout.getChildren().add(sp);

        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
