/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Car implements CarbonFootprint{
    
    private double averageKmPerYear;
    private double averageKmPerLitre;
    private final double kgCO2PerLitre = 3.1;
    
    
    public Car( double distance, double consumption ){
        averageKmPerYear = distance;
        averageKmPerLitre = consumption;
    }
    
    public void setAverageKmPerYear( double distance ){
        averageKmPerYear = distance;
    }
    public void setAverageKmPerLitre( double consumption ){
        averageKmPerLitre = consumption;
    }
    
    public double getAverageKmPerYear(){
        return averageKmPerYear;
    }
    public double getAverageKmPerLitre(){
        return averageKmPerLitre;
    }
    
    @Override
    public String toString(){
        return String.format( "%s: %.2f %s \n%s: %.2f %s \n",
            "You drive your car per year ", getAverageKmPerYear()," Km",
            "Your annualy consumption is ", getAverageKmPerLitre(), " Km/l" );
    }
    
    @Override
    public double getCarbonFootprint(){
        return (( getAverageKmPerYear() * getAverageKmPerLitre() ) * kgCO2PerLitre );
    }
}
