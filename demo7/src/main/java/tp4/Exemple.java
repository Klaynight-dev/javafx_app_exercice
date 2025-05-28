package tp4;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Exemple {
    public static void main(String[] args) {
        SimpleIntegerProperty rayon=new SimpleIntegerProperty(1);
        SimpleDoubleProperty perimetre= new SimpleDoubleProperty();
        perimetre.bind(rayon.multiply(2*Math.PI));
        System.out.println(perimetre.get());
        rayon.setValue(10);
        System.out.println(perimetre.get());

        SimpleIntegerProperty p1=new SimpleIntegerProperty(5);
        SimpleIntegerProperty p2=new SimpleIntegerProperty(2);
        SimpleDoubleProperty Total= new SimpleDoubleProperty();
        Total.bind(p1.add(p2));
        System.out.println(Total.get());
        p2.setValue(10);
        System.out.println(Total.get());
    }
}


