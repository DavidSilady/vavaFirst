package model.interfaces;

import javafx.util.Pair;

import javax.lang.model.type.PrimitiveType;
import java.util.ArrayList;
import java.util.Set;

public interface Formable {
    public <T extends Comparable<T>> void setProperties(ArrayList<T> properties);
    public ArrayList<Pair<FormableTypes, String>> getPropertyPairs();
}
