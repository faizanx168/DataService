package edu.citytech.gui.service.sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PieChartExperiments extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("My First JavaFX App");

        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Desktop", 213);
        PieChart.Data slice2 = new PieChart.Data("Phone"  , 67);
        PieChart.Data slice3 = new PieChart.Data("Tablet" , 36);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);
        pieChart.getData().add(slice3);

        VBox vbox = new VBox(pieChart );

        pieChart.setPrefWidth(700);
        pieChart.setPrefHeight(700);

        Scene scene = new Scene(vbox, 750, 750);

        primaryStage.setScene(scene);
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);




        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}