package edu.citytech.gui.service._13FManagers;

import edu.citytech.gui.service._13FManagers.model._13FManagers;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Date;

public class _13FManagersPieChart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("13F Mangers, by Muhammad Faizan" + new Date());
        PieChart pieChart = new PieChart();
        _13FManagersService.find13FManagers("AAPL",6)
                .forEach(e->{
                    PieChart.Data slice1 = new PieChart.Data(e.getManager(), e.getValueInBillions());
                    pieChart.getData().add(slice1);
                });
        VBox vbox = new VBox(pieChart );
        pieChart.setPrefWidth(700);
        pieChart.setPrefHeight(700);
        Scene scene = new Scene(vbox, 750, 750);
        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(1200);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}