import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.ItemListener;
        import java.awt.event.KeyEvent;
        import java.util.*;
public class BattleShip extends JFrame {

    public char[][] boardSet = new char[10][10];
    private static boolean player = false;     //see what players turn it is
    private static GameBoard GBJPanel = new GameBoard(); // create ScreenSaverJPanel

    public BattleShip() {
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                boardSet[i][l] = ' ';
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                boardSet[i][l] = ' ';
            }
        }
    }

    public static void main(String[] args) {
        //creates frame
        JFrame frame = new JFrame("BattleShips");
        //create label
        final JLabel text = new JLabel("BattleShips! Start a new game!");
        text.setFont(new Font("Arial",Font.PLAIN,15));
        //frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(GBJPanel);     // add ScreenSaverJPanel to frame
        frame.setSize(835, 600); //set size
        frame.setVisible(true); //show frame
        frame.setResizable(false);
        frame.add(text, BorderLayout.SOUTH);
        //create JMENU
        JMenuBar menuBar = new JMenuBar();
        JMenuItem exit = new JMenuItem("Exit");
        JMenu menu = new JMenu("File");
        JMenu newG = new JMenu("New Game");
        JMenuItem rules = new JMenuItem("Rules");
        JMenuItem oneP = new JMenuItem("One Human Player");
        JMenuItem oneRand = new JMenuItem("One Human Player with Random pieces");
        JMenuItem twoP = new JMenuItem("Two Human Players");
        JMenuItem twoRand = new JMenuItem("Two Human Players with Random pieces");
        newG.add(oneP);
        newG.add(twoP);
        newG.add(oneRand);
        newG.add(twoRand);
        menu.add(rules);
        menu.add(exit);
        menuBar.add(menu);
        menuBar.add(newG);
        frame.setJMenuBar(menuBar);
        //set Mnemonic
        menu.setMnemonic(KeyEvent.VK_F);
        newG.setMnemonic(KeyEvent.VK_N);
        oneP.setMnemonic(KeyEvent.VK_O);
        twoP.setMnemonic(KeyEvent.VK_T);
        rules.setMnemonic(KeyEvent.VK_R);
        exit.setMnemonic(KeyEvent.VK_E);
        rules.addActionListener(
                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    public void actionPerformed(ActionEvent event) {
                        String message = "\n" +
                                "BattleShip:\n\n" +
                                "Battleship (or Battleships) is a game for two players where you try to guess the" +
                                "location of \n five ships your opponent has hidden on a grid. Players take turns" +
                                "calling out a row and column, \n attempting to name a square containing enemy " +
                                "ships. Originally published as Broadsides by Milton \n Bradley in 1931, the game" +
                                "was eventually reprinted as Battleship\n" +
                                "\n" + "Players: 1-2 players \n" + "\n" + "Rules\n\n" +
                                "When one of your ships is hit, that spot will show fire on that ship on your board at" +
                                "the location of the \n hit. Whenever one of your ships has every slot on fire," +
                                "your opponent will see that the ship was sunk.\n Your own board will reflect the " +
                                "same.\n\n How to win: The first player to sink all opposing ships wins.\n";
                        JOptionPane rulesPane = new JOptionPane();
                        rulesPane.setMessage(message);
                        rulesPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = rulesPane.createDialog(null, "Rules");
                        dialog.setVisible(true);

                    }// end method actionPerformed
                }// end anonymous inner class
        ); // end call to addActionListener

        exit.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks exitItem
                    public void actionPerformed(ActionEvent event) {
                        System.exit(0); // exit application
                    } // end method actionPerformed
                } // end anonymous inner class
        ); // end call to addActionListener
        frame.setJMenuBar(menuBar);

        twoP.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks exitItem
                    public void actionPerformed(ActionEvent event) {
                        text.setText("Two players selected! Player 1's turn!");
                        BattleShip playerOne = new BattleShip();
                        BattleShip playerTwo = new BattleShip();
                        boolean gameOver = false;
                        GBJPanel.StartGame(playerTwo.boardSet, playerOne.boardSet, text);
                        //Play(text);

                    } // end method actionPerformed
                } // end anonymous inner class
        ); // end call to addActionListener

        oneP.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks exitItem
                    public void actionPerformed(ActionEvent event) {
                        text.setText("One players selected! Player 1's turn!");
                        BattleShip playerOne = new BattleShip();
                        BattleShip playerTwo = new BattleShip();
                        boolean gameOver = false;
                        GBJPanel.StartGame(playerTwo.boardSet, playerOne.boardSet, text);

                    } // end method actionPerformed
                } // end anonymous inner class
        ); // end call to addActionListener

        twoRand.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    public void actionPerformed(ActionEvent event) {
                        text.setText("Two players selected with randomly placed pieces! Player 1's turn!");
                        BattleShip playerOne = new BattleShip();
                        BattleShip playerTwo = new BattleShip();
                        boolean gameOver = false;
                        System.out.println("Working");
                        GBJPanel.StartGame(playerTwo.boardSet,playerOne.boardSet,text);
                    }
                }
        );

        oneRand.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    public void actionPerformed(ActionEvent event) {
                        text.setText("One player selected with randomly placed pieces! Player 1's turn!");
                        BattleShip playerOne = new BattleShip();
                        BattleShip playerTwo = new BattleShip();
                        boolean gameOver = false;
                        System.out.println("Working");
                        GBJPanel.StartGame(playerTwo.boardSet,playerOne.boardSet,text);
                    }
                }
        );
    }
}
