/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danie
 */
import java.util.ArrayList;

public class CarbonFootprintTest{
    public static void main( String[] args ){
        
        ArrayList<CarbonFootprint> categories = new ArrayList<CarbonFootprint>();
        
        categories.add(new Bike(400));
        categories.add(new Building(220));
        categories.add(new Car(9800, 12));
        
        System.out.println("Data of each consumption:\n ");
        
        for( CarbonFootprint currentObject : categories ){
            System.out.printf("%s%s: %.2f\n\n",
                currentObject.toString(),
                "Carbon footprint is ", currentObject.getCarbonFootprint());
        }  
    }
}
