/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Building implements CarbonFootprint{
    
    private double averageMonthlyKwh;
    private final int months = 12;

    
    public Building( double monthlyConsumption ){
        averageMonthlyKwh = monthlyConsumption;
    }
    
    public void setAverageMonthlyKwh( double monthlyConsumption ){
        averageMonthlyKwh = monthlyConsumption;
    }
    
    public double getAverageMonthlyKwh(){
        return averageMonthlyKwh;
    }
    
    @Override 
    public String toString(){
        return String.format("%s: %.2f %s \n%s: %.2f %s \n", 
        "Your monthly energy consumption is", getAverageMonthlyKwh(),"Kwh",
        "Your annual energy consumptions is",getAverageMonthlyKwh() * months,"Kwh" );
    }
    
    @Override
    public double getCarbonFootprint(){
        return getAverageMonthlyKwh() * months;
    }
}