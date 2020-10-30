import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;
  JPanel topPanel;
  JPanel buttonPanel;

  JButton[] numberButtons;
  JButton addButton;
  JButton subtractButton;
  JButton multButton;
  JButton divButton;
  JButton equalsButton;
  JButton decimalButton;

  JTextField display;

  Font biggerFont;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //initialize the main panel with a border layout
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());

    // initialize the button panel with grid layout
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(4, 4));

    //initialize the top panel with defualt layout (flow)
    topPanel = new JPanel();

    //initialize bigger Font
    biggerFont = new Font("arial", font.PLAIN, 24);

    //create the display
    display = new JTextField("0");
    //set a preferred size
    display.setPreferredSize(new Dimension(800, 100));
    //add to top
    topPanel.add(display);
    //creates bigger font for display
    display.setFont(biggerFont);

    //creating the number buttons
    numberButtons = new JButton[10];
    for(int i = 0; i < numberButtons.length; i++){
      numberButtons[i] = new JButton("" + i);
      //set the action command
      numberButtons[i].setActionCommand("" + i);
      //add action ActionListener
      numberButtons[i].addActionListener(this);
    }

    //create the operation buttons
    equalsButton = new JButton("=");
    equalsButton.addActionListener(this);
    equalsButton.setActionCommand("equal");

    addButton = new JButton("+");
    addButton.addActionListener(this);
    addButton.setActionCommand("add");

    subtractButton = new JButton("-");
    subtractButton.addActionListener(this);
    subtractButton.setActionCommand("subtract");

    multButton = new JButton("*");
    multButton.addActionListener(this);
    multButton.setActionCommand("multiply");

    divButton = new JButton("/");
    divButton.addActionListener(this);
    divButton.setActionCommand("divide");

    decimalButton = new JButton(".");
    decimalButton.addActionListener(this);
    decimalButton.setActionCommand("decimal");

    //add the buttons to the grid
    buttonPanel.add(numberButtons[7]);
    buttonPanel.add(numberButtons[8]);
    buttonPanel.add(numberButtons[9]);
    buttonPanel.add(divButton);

    buttonPanel.add(numberButtons[4]);
    buttonPanel.add(numberButtons[5]);
    buttonPanel.add(numberButtons[6]);
    buttonPanel.add(multButton);

    buttonPanel.add(numberButtons[1]);
    buttonPanel.add(numberButtons[2]);
    buttonPanel.add(numberButtons[3]);
    buttonPanel.add(subtractButton);

    buttonPanel.add(numberButtons[0]);
    buttonPanel.add(decimalButton);
    buttonPanel.add(addButton);
    buttonPanel.add(equalsButton);

    //assemble the panels
    mainPanel.add(topPanel, BorderLayout.PAGE_START);
    mainPanel.add(buttonPanel, BorderLayout.CENTER);

    //add the main panel to the frame
    frame.add(mainPanel);
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
