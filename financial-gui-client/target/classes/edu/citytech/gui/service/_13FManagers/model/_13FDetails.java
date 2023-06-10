package edu.citytech.gui.service._13FManagers.model;

import edu.citytech.financial.utility.NumberUtility;

import java.util.Date;

public class _13FDetails {
    private String id;

    private String stock;

    private String manager;

    private Date reportDate;

    private double value;

    private double valueInBillions;
    private double share;

    public String getId() {
        return id;
    }

    public String getStock() {
        return stock;
    }

    public String getManager() {
        return manager;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public double getValue() {
        return value;
    }
    public String getFDate(){
       return NumberUtility.getFormattedDate(reportDate);
    }
    public double getValueInBillions() {
        return valueInBillions;
    }
    public double getShareInBillions(){return share /1_000_000_000;}
    public String getFValuesInBillions(){
      return   NumberUtility.commaStyle(valueInBillions,2);
    }
    public String getFShareInBillions(){return NumberUtility.commaStyle(this.getShareInBillions(),2);}
    public double getShare() {
        return share;
    }

    @Override
    public String toString() {
        return "_13FDetails{" +
                "id='" + id + '\'' +
                ", stock='" + stock + '\'' +
                ", manager='" + manager + '\'' +
                ", reportDate=" + reportDate +
                ", value=" + value +
                ", valueInBillions=" + valueInBillions +
                ", share=" + share +
                '}';
    }
}
