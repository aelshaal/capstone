import java.util.ArrayList;
/**
 * Will create an array of Fan objects each with their own address and settings 
 * Will add elements when asked to add new fans.
 * 
 * @author Daniel Whent edited by Ameen Elshaalia
 * @version 5 Feb 2021 - Updated 14 Feb 2021
 */
public class Hub {

    final int initialCap = 1;
    private ArrayList<Fan> hubList = new ArrayList<Fan>();
        
    /**
     * Will add a new fan to the hubList and will return true if adds succesfully
     * 
     * @param address   The address of the specific fan.
     * @param array     The list containing the settings for the fan
     * @return          True if it added the new fan succesfully
     */
    public boolean addFan(String address, String[] array) {
        
        boolean complete;
        
        Fan tempFan = new Fan(address, array);
        complete = hubList.add(tempFan);
        
        return complete;
    }

    /**
     * Will add a new fan to the hubList and will return true if adds succesfully
     * 
     * @param address   The address of the specific fan.
     * @return          True if it added the new fan succesfully.
     */
    public boolean addFan(String address) {
        
        boolean complete;
        
        Fan tempFan = new Fan(address);
        complete = hubList.add(tempFan);
        
        return complete;
    }

    /**
     * Will add a new fan to the hubList and will return true if adds succesfully
     * 
     * @return          True if it added the new fan succesfully.
     */
    public boolean addFan() {
        
        boolean complete;
        
        Fan tempFan = new Fan();
        complete = hubList.add(tempFan);
        
        return complete;
    }

    /**
     * Returns the size of the hubList array
     * @return
     */
    public int getSize() {
        return hubList.size();
    }

    /**
     * Returns the Fan object stored at index
     * 
     * @param index Fan object specified
     * @return      Fan object returned
     */
    public Fan getFan(int index) {
        return hubList.get(index);
    }

    /**
     * Builds the string to be output by the toString() method
     * 
     * @return      String representation of Hub type object
     */
    public String toString() {
        String result = "";
        for (int i = 0; i < hubList.size(); i++) {
            int fanNum = i+1; 
            result = result + "Fan No: " + fanNum + ", " ;
            result = result + hubList.get(i);
            result = result + "\n";
        }
        return result;
    }
}

