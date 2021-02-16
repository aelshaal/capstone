import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * GUI class that creates a window for user inputs
 * 
 * @author Ameen Elshaalia
 * @version 12 Feb 2021
 */
public class GUI implements ActionListener {

    private JLabel label1, label2, label3, label4, label5, successTxt;
    private JTextField text1, text2, text3, text4;
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JComboBox<Integer> c1;
    private String newText1, newText2, newText3, newText4; 

    public GUI() {

        // creating a frame and a panel
        frame = new JFrame();
        panel = new JPanel();

        // resizing the frame and adding a panel to it
        frame.setPreferredSize(new Dimension(600, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // drop-down list for fan options
        Integer[] list = { 1, 2, 3, 4, 5 };

        // creating labels, text fields and adding them to the panel
        label5 = new JLabel("Fan selected: ");
        label5.setBounds(40, 20, 80, 25);
        c1 = new JComboBox<>(list);
        c1.setBounds(140, 20, 50, 25);
        panel.add(c1);
        panel.add(label5);

        label1 = new JLabel("Minimum Oscillation degree: ");
        text1 = new JTextField();
        text1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (text1.getText().length() >= 3)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        label1.setBounds(40, 60, 200, 25);
        text1.setBounds(210, 60, 50, 25);
        panel.add(label1); 
        panel.add(text1); 
        if(text1.getText().length() < 3){
            newText1 = "";
            newText1 = text1.getText(); 
        }

        label2 = new JLabel("Maximum Oscillation degree: ");
        text2 = new JTextField();
        text2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (text2.getText().length() >= 3)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        label2.setBounds(300, 60, 200, 25);
        text2.setBounds(470, 60, 50, 25);
        panel.add(label2); 
        panel.add(text2);

        label3 = new JLabel("Minimum Rotation degree: ");
        text3 = new JTextField();
        text3.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (text3.getText().length() >= 3)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        label3.setBounds(40, 140, 200, 25);
        text3.setBounds(210, 140, 50, 25);
        panel.add(label3); 
        panel.add(text3);

        label4 = new JLabel("Maximum Rotation degree: ");
        text4 = new JTextField();
        text4.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (text4.getText().length() >= 3)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        label4.setBounds(300, 140, 200, 25);
        text4.setBounds(470, 140, 50, 25);
        panel.add(label4); 
        panel.add(text4);

        //creating a button and adding action to it
        button = new JButton("Submit");
        button.setBounds(235, 200, 100, 25);
        button.addActionListener(new ActionListener() {
            /**
         * The action to be performed when button is hit.
        * A fan is added to the hub, passing the selected fan and its settings
        * as parameters. Also, catching expection for parsing the degrees as 
        * integers instead of string. 
        */
            public void actionPerformed(ActionEvent e) {
                try {
                    if(text1.getText().length() == 2){
                        newText1 = "0";
                        newText1 += text1.getText(); 
                    } else if(text1.getText().length() == 1){
                        newText1 = "00"; 
                        newText1 += text1.getText(); 
                    } else{
                        newText1 = text1.getText(); 
                    }
                }
                catch(NumberFormatException ex){
                }
                try {
                    if(text2.getText().length() == 2){
                        newText2 = "0";
                        newText2 += text2.getText(); 
                    } else if(text2.getText().length() == 1){
                        newText2 = "00"; 
                        newText2 += text1.getText(); 
                    } else{
                        newText2 = text2.getText(); 
                    }
                }
                catch(NumberFormatException ex){
                }
                try {
                    if(text3.getText().length() == 2){
                        newText3 = "0";
                        newText3 += text3.getText(); 
                    } else if(text3.getText().length() == 1){
                        newText3 = "00"; 
                        newText3 += text3.getText(); 
                    } else{
                        newText3 = text3.getText(); 
                    }
                }
                catch(NumberFormatException ex){
                }
                try {
                    if(text4.getText().length() == 2){
                        newText4 = "0";
                        newText4 += text4.getText(); 
                    } else if(text4.getText().length() == 1){
                        newText4 = "00"; 
                        newText4 += text1.getText(); 
                    } else{
                        newText4 = text4.getText(); 
                    }
                }
                catch(NumberFormatException ex){
                }
                String[] settings = getSettings(); 
                String fanSelection = getFanSelection(); 
                boolean success = HubDriver.testHub.addFan(fanSelection, settings);
                System.out.println(HubDriver.testHub); 
                if (success){
                    successTxt.setText("Settings submitted successfully!");
                }else{
                    successTxt.setText("Coulnd't add fan, try again!");
                }
    
            }
        });
        panel.add(button);

        //message to be printed if settings updated successfully
        successTxt = new JLabel("");
        successTxt.setBounds(193, 225, 200, 25);
        panel.add(successTxt); 

        //title of the window 
        frame.setTitle("Fan Settings");
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Private getter method for fan selection
     * @return a string value of the selected fan
     */    
    private String getFanSelection() {
        return String.valueOf(c1.getSelectedIndex()+1);

    }

    /**
     * Private getter method for fan settings
     * @return int array of the settings
     */
    private String[] getSettings() {
        String[] settings = {newText1, newText2, newText3, newText4};
        return settings; 
    }
    
}
