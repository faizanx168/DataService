package edu.citytech.gui.service.shared;

import edu.citytech.gui.service._13FManagers._13FManagersPieChartMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;


import java.io.IOException;
import java.util.Date;

import static edu.citytech.gui.service.shared.SceneRepository.getScene;

public class MainController{
    @FXML
    void onSceneChange(ActionEvent event) throws IOException {
        MenuItem menuItem = (MenuItem) event.getSource();
        int sceneNo = Integer.parseInt(menuItem.getUserData().toString());
        String title = menuItem.getText();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/" + getScene(sceneNo)));
        Scene scene = new Scene(root);
        _13FManagersPieChartMain.globalStage.setTitle(title+", by Muhammad Faizan Abbasi" + new Date());
        _13FManagersPieChartMain.globalStage.setScene(scene);
        _13FManagersPieChartMain.globalStage.show();
        _13FManagersPieChartMain.globalStage.setResizable(false);
    }
}
