/**
 * Class for object Fan where fields location and settings are held for a Fan
 * 
 * @author Daniel Whent edited by Ameen Elshaalia
 * @version 5 Feb 2021 - Updated 14 Feb 2021
 */
public class Fan{

    private String location;
    private String[] settings;
    final String[] UNDEFSET = (String[]) null;
    final String UNDEFADR = null;

    /**
     * Constructor that specifies address and settings.
     * 
     * @param address   Network address of the fan.
     * @param array     Array containing settings.
     */
    public Fan(String address, String[] array) {
        this.setAddr(address);
        this.setSettings(array);
    }
    
    /**
     * Constructor that specifies address.
     * 
     * @param address   Network address of the fan.
     */
    public Fan(String address) {
        this.setAddr(address);
        this.setSettings(UNDEFSET);
    }

    /**
     * Constructor that specifies nothing.
     */
    public Fan() {
        this.setAddr(UNDEFADR);
        this.setSettings(UNDEFSET);
    }

    /**
     * Setter that updates the field location
     * 
     * @param address   Network address of the fan.
     */
    public void setAddr(String address) {
        this.location = address;
    }

    /**
     * Setter that updates field settings
     * 
     * @param array     Array containing settings.
     */
    public void setSettings(String[] array) {
        this.settings = array;
    }

    /**
     * @return  Address of the fan
     */
    public String getaddr() {
        return this.location;
    }

    /**
     * @return  Settigns of the Fan
     */
    public String[] getSettings() {
        return this.settings;
    }

    /**
     * @return  String representation of the Fan class
     */
    public String toString() {
        String result = "";
        // address is undefined if this.location is null
        if (this.location == null) {
            result = result + "@: " + "undefined";
        } else {
            result = result + "@: " + this.location;
        }
        result = result + ", with: ";
        // Settings is No settings if this.settings is null
        if (this.settings == null) {
            result = result + "No settings.";
        } else {
            for (int i = 0; i < this.settings.length; i++) {
                result = result + this.settings[i];
            }
        }
        return result;
    }
}