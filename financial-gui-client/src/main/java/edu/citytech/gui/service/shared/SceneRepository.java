package edu.citytech.gui.service.shared;

import java.util.HashMap;
import java.util.Map;

public class SceneRepository {
    static Map<Integer,String> map = new HashMap<>();
    static {
        map.put(1,"_13fManagerPieChartView.fxml");
        map.put(2,"A-MarginalTaxView.fxml");
        map.put(3,"B-MarginalTaxView.fxml");
        map.put(4,"C-MarginalTaxView.fxml");
    }
   public static String getScene(int sceneNo){
        return map.get(sceneNo);
    }
}
