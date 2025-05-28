package tp4;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleDoubleProperty;


public class Exemple2 {
    public static void main(String[] args) {
        SimpleDoubleProperty somme = new SimpleDoubleProperty(89);
        SimpleDoubleProperty nb = new SimpleDoubleProperty(8);
        SimpleDoubleProperty moyenne = new SimpleDoubleProperty();
        BooleanBinding casErreur = Bindings.equal(nb, 0);
        moyenne.bind(Bindings.when(casErreur).then(-1.0).otherwise(Bindings.divide(somme, nb)));

        System.out.println(moyenne.get());
        somme.set(100);
        System.out.println(moyenne.get());
        nb.set(0);
        System.out.println(moyenne.get());
    }
}