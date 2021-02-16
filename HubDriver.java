/**
 * Driver class that will Show the Functionality of the fan by creating list of fans
 * and returning it
 * 
 * @author Daniel Whent edited by Ameen Elshaalia
 * @version 5 Feb 2021 - Updated 12 Feb 2021
 */
public class HubDriver {

    // static String fanSelection;
    // static int[] settings;
    private static GUI gui;
	public static Hub testHub;

    /**
     * Main function that will add and show the working of the Hub and Fan classes
     * 
     * @param args
     */
    public static void main(String[] args) {
        testHub = new Hub(); 
        gui = new GUI();
    }

}
