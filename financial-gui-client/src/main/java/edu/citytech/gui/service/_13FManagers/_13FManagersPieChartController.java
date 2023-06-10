package edu.citytech.gui.service._13FManagers;

import edu.citytech.financial.utility.NumberUtility;
import edu.citytech.gui.service._13FManagers.model._13FDetails;
import javafx.beans.property.DoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class _13FManagersPieChartController implements Initializable {

    @FXML
    private Slider slLimit;
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtStockInput;


    @FXML
    private PieChart pieChart;
    @FXML
    private TableView<_13FDetails> tvReport;
    @FXML
    private ToggleGroup tgDisplayGroup;
    @FXML
    private Label lblTitle;

    @FXML
    private TextField txtLimit;
    static  final String title = "For $stock stock total in billions: $amount";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupSlider();
        int limit = Integer.parseInt(this.txtLimit.getText());
        var total =  this.retrieveData("AAPL", limit);
        buildTitle(txtStockInput.getText(),total);
    }

    public void buildTitle(String symbol, double amount){
        String sAmount = NumberUtility.commaStyle(amount, 2);
        String newTitle = title.replace("$stock" , symbol).replace("$amount", sAmount+"");
        lblTitle.setText(newTitle);
    }
    public double retrieveData(String symbol, int limit){
        pieChart.getData().clear();
        var list =  _13FManagersService.find13FManagers(symbol,limit);

        tvReport.getItems().clear();
        ObservableList<_13FDetails> oResult = tvReport.getItems();
        oResult.addAll(list);

        String mode = tgDisplayGroup.getSelectedToggle().getUserData().toString();
                    list.stream().limit(10).forEach(e->{
                        Supplier<String> supplier = mode.equals("id") ? e::getId : e::getManager;
                    PieChart.Data slice1 = new PieChart.Data(supplier.get(), e.getValueInBillions());
                    pieChart.getData().add(slice1);
                });

                    var total = list.stream().mapToDouble(_13FDetails::getValueInBillions).sum();
                    updatePercentage();
                    return total;
    }

    private void updatePercentage() {
        var total = pieChart.getData().stream().mapToDouble(PieChart.Data::getPieValue).sum();
        for(var data: pieChart.getData()){
            String name = data.getName();
            double number = data.getPieValue() / total;
            String percentage = NumberUtility.toPercentage(number,2);
            data.setName("(number)".replace("number", percentage) + " "+name);

        }
    }

    private void setupSlider(){
        slLimit.setValue(10);
        txtLimit.setText("10");
        slLimit.valueProperty().addListener(e->{
            var db = (DoubleProperty)e;
            txtLimit.setText((int)db.getValue().doubleValue()+ "");
            System.out.println("Muhammad Faizan Abbasi"+ db.getValue());
        });
    }

    @FXML
    void onSearch(ActionEvent event) {
        System.out.println("Button was clicked");
        var limit = Integer.parseInt(txtLimit.getText());
        var total=  retrieveData(txtStockInput.getText(), limit);
        buildTitle(txtStockInput.getText(),total);
    }

}
