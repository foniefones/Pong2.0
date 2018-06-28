import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {


    int screenWidth =800;
    int screenHeight = 500;

    int buttonWidth = 100;
    int buttonHeight = 40;

    JButton Play, Quit;
    JCheckBox twoPlayers;

    public MainMenu() {
        getContentPane().setLayout(null);
        Game.musicplayer.play("audio/menumelody.wav");

        //calling methods
        addButtons();
        addActions();

        Play.setBounds((screenWidth - buttonWidth) / 2, 150,buttonWidth, buttonHeight); //Position Play button
        Quit.setBounds((screenWidth - buttonWidth) / 2, 200, buttonWidth, buttonHeight); // Position Quit button
        twoPlayers.setBounds((screenWidth - buttonWidth) / 2, 255, buttonWidth * 3, buttonHeight); //Position the twPlayers checkbox

        //Adding buttons
        getContentPane().add(Play);
        getContentPane().add(Quit);
        getContentPane().add(twoPlayers);

        //JFrame stuff
        pack();
        setVisible(true);
        setSize(screenWidth, screenHeight);
        setTitle("ACADEMY PONG CHAMP DELUXE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

    }
    private void addButtons() {
        Play = new JButton("Play");
        Quit = new JButton("Quit");
        twoPlayers = new JCheckBox("2 Players");

    }
    private void addActions() {
        Play.addActionListener(new ActionListener() { //Take Play button, add new ActionListener
            @Override
            public void actionPerformed(ActionEvent e) { // Turn the action performed into a variable for usage
                dispose();

                Game game = new Game();

                if(twoPlayers.isSelected()) {
                    game.ai.isTwoPlayers = true;
                } else{
                    game.ai.isTwoPlayers = false;
                }
                game.start();
                Game.musicplayer.stop("audio/menumelody.wav");
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
