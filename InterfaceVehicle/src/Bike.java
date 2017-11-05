/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
public class Bike implements CarbonFootprint{
    
    private double KmPerYear;
    private final double caloriesPerKm = 80.5;
    
    
    public Bike( double distance ){
        KmPerYear = distance;
    }
    
    public double getKmPerYear(){
        return KmPerYear;
    }
    
    public void setKmPerYear( double distance ){
        KmPerYear = distance;
    }
    
    @Override
    public String toString(){
        return String.format("%s %.2f %s %s\n","You rode your bike", getKmPerYear(),"Km","this year" );
    }
    
    @Override
    public double getCarbonFootprint(){
        return KmPerYear * caloriesPerKm;
    }
}
