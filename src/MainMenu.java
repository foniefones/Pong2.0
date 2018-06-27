import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {


    int screenWidth = 283;
    int screenHeight = 250;

    int buttonWidth = 100;
    int buttonHeight = 40;

    JButton Play, Quit;
    JCheckBox twoPlayers, limitFramerate;

    public MainMenu() {
        getContentPane().setLayout(null);

        //calling methods
        addButtons();
        addActions();

        Play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth, buttonHeight);
        Quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth, buttonHeight);
        twoPlayers.setBounds(0, 95, buttonWidth * 3, buttonHeight);
        limitFramerate.setBounds(0, 140, buttonWidth * 3, buttonHeight);

        //Adding buttons
        getContentPane().add(Play);
        getContentPane().add(Quit);
        getContentPane().add(twoPlayers);
        getContentPane().add(limitFramerate);

        //JFrame stuff
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setSize(screenWidth, screenHeight);
        setTitle("Pong Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }
    private void addButtons() {
        Play = new JButton("Play");
        Quit = new JButton("Quit");
        twoPlayers = new JCheckBox("2 Players");
        limitFramerate = new JCheckBox("Limit Frames/Second to Updates/Second?");

    }
    private void addActions() {
        Play.addActionListener(new ActionListener() { //Take Play button, add new ActionListener
            @Override
            public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
                dispose();
                new Game().start();
            }
        });//Play button

        Quit.addActionListener(new ActionListener() { //Take Quit button, add new ActionListener
            @Override
            public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
                System.exit(0); // Shutdown the porogram
            }
        });//Quit button
    }


}
