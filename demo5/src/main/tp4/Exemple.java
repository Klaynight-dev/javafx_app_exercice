package tp4;

import javafx.beans.property.SimpleIntegerProperty;

public class Exemple {
    public static void main(String[] args) {
        SimpleIntegerProperty p1=new SimpleIntegerProperty(100);
        SimpleIntegerProperty p2=new SimpleIntegerProperty();
        p2.bind(p1);
        System.out.println(p2.get());
        p1.setValue(200);
        System.out.println(p2.get());
    }
}