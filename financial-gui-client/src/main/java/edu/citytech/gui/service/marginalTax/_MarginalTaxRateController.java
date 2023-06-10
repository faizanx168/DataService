package edu.citytech.gui.service.marginalTax;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static edu.citytech.gui.service.marginalTax._MarginalTaxRateMain.globalStage;

public class _MarginalTaxRateController {

    @FXML
    private VBox apTaxBrackets;

    @FXML
    private AnchorPane apTaxSummary;

    @FXML
    private AnchorPane apTaxYear;

    @FXML
    private AnchorPane booboo;

    @FXML
    private Label lblURL;

    @FXML
    private Text lblresult1;
    @FXML
    private RadioButton rbHeadOfHouseHold;
    @FXML
    private RadioButton rbMarried;
    @FXML
    private RadioButton rbMarriedFilingJointly;
    @FXML
    private RadioButton rbSingle;
    @FXML
    private TextField tfSalary;
    @FXML
    private ToggleGroup tgDisplayGroup;
    @FXML
    private ToggleGroup tgDisplayGroupYear;
    @FXML
    private BarChart<?, ?> barChart;
    @FXML
    private Text txtFinal;
    @FXML
    void onCalculate(ActionEvent event) {
        var salary = Double.parseDouble(tfSalary.getText());
        var selected = tgDisplayGroup.getSelectedToggle().getUserData().toString();
        var year = Integer.parseInt(tgDisplayGroupYear.getSelectedToggle().getUserData().toString());
        var data =  _MarginalTaxRateService.findTaxDetails(selected, salary, year);
        String lbl1Txt = "Under the current plan, if a single taxpayer earned $150,000 in taxable income, they would owe the following income taxes for 2022 (due in April 2023), as shown below:";
        var lbl1 = lbl1Txt.replace("$150,000",salary+"")
                .replace("2022", year+"");
        lblresult1.setText(lbl1);
        apTaxBrackets.getChildren().clear();
        String lblFinal = "If you add up these amounts, the entire tax liability for this individual would be 29,835.50, or an effective tax rate of 19.9% = ($29,835.50/$150,000).";
        var txt  = lblFinal.replace("29,835.50", data.getTaxPaid()+"")
                .replace("19.9", Math.ceil(data.getEffectiveTaxRate() *100)+"")
                .replace("$29,835.50", data.getTaxPaid()+"")
                .replace("$150,000",salary+"");
        txtFinal.setText(txt);
        var taxRules = data.getTaxRules();
        barChart.getData().clear();
        taxRules.forEach(taxRule -> {
            double range = taxRule.getRange2() - taxRule.getRange1();
            double taxRate = Math.ceil(taxRule.getTaxRate()*100);
            var rule = "Bracket "+taxRule.getRule() +": ("+ taxRule.getRange2() +" - "+taxRule.getRange1()+") x "+taxRate +"% = $" + range+"";
            Label lbl = new Label();
            lbl.setText(rule);
            apTaxBrackets.getChildren().add(lbl);
            XYChart.Series dataSeries1 = new XYChart.Series();
            dataSeries1.setName(taxRate+"");
            dataSeries1.getData().add(new XYChart.Data("Amount", taxRate));
            barChart.getData().add(dataSeries1);
        });
    }
}
