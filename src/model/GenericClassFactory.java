package model;

import model.interfaces.Generable;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class GenericClassFactory {
    private static GenericClassFactory singleInstance = null;
    private GenericClassFactory() {}

    public GenericClassFactory getInstance() {
        if (singleInstance == null) {
            singleInstance = new GenericClassFactory();
        }
        return singleInstance;
    }

    public static Generable generateClass(String className, JSONObject constructorData) {
        Generable output = null;
        switch (className) {
            case "User":
                output = new User();
                break;
            case "Sample":
                output = new Sample();
                break;
            case "Customer":
                output = new Customer();
                break;
        }
        if (output != null) {
            output.setJSData(constructorData);
        }
        return output;
    }
}
