package problems;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * The class must be declared as final so that child classes can’t be created.
 * Data members in the class must be declared private so that direct access is not allowed.
 * Data members in the class must be declared as final so that we can’t change the value of it after object creation.
 * A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
 * Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
 *
 * There should be no setters or in simpler terms, there should be no option to change the value of the instance variable.
 */
public final class ImmutableClass {

    private final String value;
    private final Map<String, String> map = new HashMap<>();

    public ImmutableClass(String value){//final not allowed on constructor
        this.value=value;
    }
//no setters
    public String getValue(){
        return value;
    }
/* test*/
    /**
     *  Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference
     * @return
     */
    public Map<String, String> getMetadata()
    {

        // Creating Map with HashMap reference
        Map<String, String> tempMap = new HashMap<>();

        for (Map.Entry<String, String> entry :
                this.map.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

}
