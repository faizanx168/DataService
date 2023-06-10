package edu.citytech.gui.service.marginalTax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Date;

public class _MarginalTaxRateMain extends Application {
    public static Stage globalStage;
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/A-MarginalTaxView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Marginal Tax Rate for year 2022, by Muhammad Faizan Abbasi" + new Date());
        stage.setScene(scene);
        stage.show();
        stage.setResizable(true);
        globalStage = stage;
    }
}
