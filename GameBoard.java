import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameBoard extends JPanel {
    //flags
    private boolean flag = false;
    private boolean onePlayer = false;
    private boolean shipsPlaced = false;
    private int[][] bowCoordinates = new int[1][2];
    //gui boards
    final public JButton[][] board;
    final public JButton[][] board2;
    final public JButton[][] attackBoard;
    final public JButton[][] attackBoard2;
    //layout for jpanel
    private BoxLayout layout = new BoxLayout(this, BoxLayout.X_AXIS);
    //jpanels to put gui in
    private JPanel myPan1 = new JPanel(new GridLayout(10, 10));
    private JPanel myPan2 = new JPanel(new GridLayout(10, 10));
    private JPanel oppPan1 = new JPanel(new GridLayout(10, 10));
    private JPanel oppPan2 = new JPanel(new GridLayout(10, 10));
    //images
    private ImageIcon hit = new ImageIcon(getClass().getResource("/fire.png"));
    private ImageIcon water= new ImageIcon(getClass().getResource("/water.png"));
    private ImageIcon missed = new ImageIcon(getClass().getResource("missed.jpg"));
    private ImageIcon battleshipPic = new ImageIcon(getClass().getResource("/battleships.jpg"));
    //carrier pictures
    private ImageIcon carrier1 = new ImageIcon(getClass().getResource("/c1.jpeg"));
    private ImageIcon carrier2 = new ImageIcon(getClass().getResource("/c2.jpeg"));
    private ImageIcon carrier3 = new ImageIcon(getClass().getResource("/c3.jpeg"));
    private ImageIcon carrier4 = new ImageIcon(getClass().getResource("/c4.jpeg"));
    private ImageIcon carrier5 = new ImageIcon(getClass().getResource("/c5.jpeg"));
    private ImageIcon carrierv1 = new ImageIcon(getClass().getResource("/cv1.jpeg"));
    private ImageIcon carrierv2 = new ImageIcon(getClass().getResource("/cv2.jpeg"));
    private ImageIcon carrierv3 = new ImageIcon(getClass().getResource("/cv3.jpeg"));
    private ImageIcon carrierv4 = new ImageIcon(getClass().getResource("/cv4.jpeg"));
    private ImageIcon carrierv5 = new ImageIcon(getClass().getResource("/cv5.jpeg"));
    //sub pictures
    private ImageIcon sub1 = new ImageIcon(getClass().getResource("/sub1.jpeg"));
    private ImageIcon sub2 = new ImageIcon(getClass().getResource("/sub2.jpeg"));
    private ImageIcon sub3 = new ImageIcon(getClass().getResource("/sub3.jpeg"));
    private ImageIcon subv1 = new ImageIcon(getClass().getResource("/subv1.jpeg"));
    private ImageIcon subv2 = new ImageIcon(getClass().getResource("/subv2.jpeg"));
    private ImageIcon subv3 = new ImageIcon(getClass().getResource("/subv3.jpeg"));
    //battleship pictures
    private ImageIcon bs1 = new ImageIcon(getClass().getResource("/bs1.jpeg"));
    private ImageIcon bs2 = new ImageIcon(getClass().getResource("/bs2.jpeg"));
    private ImageIcon bs3 = new ImageIcon(getClass().getResource("/bs3.jpeg"));
    private ImageIcon bs4 = new ImageIcon(getClass().getResource("/bs4.jpeg"));
    private ImageIcon bsv1 = new ImageIcon(getClass().getResource("/bsv1.jpeg"));
    private ImageIcon bsv2 = new ImageIcon(getClass().getResource("/bsv2.jpeg"));
    private ImageIcon bsv3 = new ImageIcon(getClass().getResource("/bsv3.jpeg"));
    private ImageIcon bsv4 = new ImageIcon(getClass().getResource("/bsv4.jpeg"));
    //crusier pictures
    private ImageIcon c1 = new ImageIcon(getClass().getResource("/cruiser1.jpeg"));
    private ImageIcon c2 = new ImageIcon(getClass().getResource("/cruiser2.jpeg"));
    private ImageIcon c3 = new ImageIcon(getClass().getResource("/cruiser3.jpeg"));
    private ImageIcon cv1 = new ImageIcon(getClass().getResource("/cruiserv1.jpeg"));
    private ImageIcon cv2 = new ImageIcon(getClass().getResource("/cruiserv2.jpeg"));
    private ImageIcon cv3 = new ImageIcon(getClass().getResource("/cruiserv3.jpeg"));
    //destroyer pictures
    private ImageIcon d1 = new ImageIcon(getClass().getResource("/destroyer1.jpeg"));
    private ImageIcon d2 = new ImageIcon(getClass().getResource("/destroyer2.jpeg"));
    private ImageIcon dv1 = new ImageIcon(getClass().getResource("/destroyerv1.jpeg"));
    private ImageIcon dv2 = new ImageIcon(getClass().getResource("/destroyerv2.jpeg"));
    //coordinates along side of board
    private JTextArea coord1 = new JTextArea();
    private JTextArea coord2 = new JTextArea();
    //set coordinates along side of board
    public void JTextAreaFontandColor() {
        coord1.setText("\n\n\n\nA\nB\nC\nD\nE\nF\nG\nH\nI\nJ");
        coord1.setEditable(false);
        Font font = new Font("Arial Bold", Font.BOLD, 26);
        coord1.setFont(font);
        coord1.setForeground(Color.BLUE);
        Color c = new Color(0,0,0,1);
        coord1.setBackground(c);
    }
    //set coordinates along side of board
    public void JTextAreaFontandColor2() {
        coord2.setText("\n\n\n\nA\nB\nC\nD\nE\nF\nG\nH\nI\nJ");
        coord2.setEditable(false);
        Font font = new Font("Arial Bold", Font.BOLD, 26);
        coord2.setFont(font);
        coord2.setForeground(Color.BLUE);
        Color c = new Color(0,0,0,1);
        coord2.setBackground(c);
    }

    //middle image
    private JLabel boats = new JLabel(battleshipPic);
    private JLabel boats2 = new JLabel(battleshipPic);
    private int counter = 0;
    private int boatCounter = 0;
    private boolean boatFlag = false;

    //set up original GUI
    public GameBoard() {
        setLayout(layout);
        myPan1.setMaximumSize(new Dimension(275, 300));
        myPan1.setPreferredSize(new Dimension(275, 300));
        myPan2.setMaximumSize(new Dimension(275, 300));
        myPan2.setPreferredSize(new Dimension(275, 300));
        add(coord1);
        JTextAreaFontandColor();
        add(myPan1);
        board = new JButton[10][10]; //make grid of buttons
        board2 = new JButton[10][10]; //make grid of buttons
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                board[j][i] = new JButton();
                board[j][i].setIcon(water);
                board2[j][i] = new JButton();
                board2[j][i].setIcon(water);
                myPan1.add(board[j][i]);
                myPan2.add(board2[j][i]);
            }
        }
        oppPan1.setMaximumSize(new Dimension(275, 300));
        oppPan1.setPreferredSize(new Dimension(275, 300));
        oppPan2.setMaximumSize(new Dimension(275, 300));
        oppPan2.setPreferredSize(new Dimension(275, 300));
        add(boats);
        add(coord2);
        JTextAreaFontandColor2();
        add(oppPan1);
        attackBoard = new JButton[10][10]; //make grid of buttons
        attackBoard2 = new JButton[10][10]; //make grid of buttons
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                attackBoard[j][i] = new JButton();
                attackBoard[j][i].setIcon(water);
                attackBoard2[j][i] = new JButton();
                attackBoard2[j][i].setIcon(water);
                oppPan1.add(attackBoard[j][i]);
                oppPan2.add(attackBoard2[j][i]);
            }
        }
    }

    //switch between boards on GUI
    public void SwitchPlayers(JLabel a, int x, JDialog b, int counter, boolean flag){
        if (x == 2) {
            if (counter == 0) {
                myPan1.setVisible(false); //remove boards
                boats.setVisible(false);
                oppPan1.setVisible(false);
                add(myPan2);   //insert board other player
                add(boats2);
                add(coord2);
                add(oppPan2);
                counter++;
            }
            myPan1.setVisible(false); //remove boards
            boats.setVisible(false);
            oppPan1.setVisible(false);
            if (flag) {
                b.setVisible(true);
            }
            myPan2.setVisible(true);   //insert board other player
            boats2.setVisible(true);
            oppPan2.setVisible(true);
            a.setText("Player " + x + "'s turn!");
        }
        else{
            myPan2.setVisible(false); //remove boards
            boats2.setVisible(false);
            oppPan2.setVisible(false);
            if (flag) {
                b.setVisible(true);
            }
            myPan1.setVisible(true);   //insert board other player
            boats.setVisible(true);
            oppPan1.setVisible(true);
            a.setText("Player " + x + "'s turn!");
        }
    }

    //paint the words onto screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(Color.black);
        g.drawString("Your Board", 80, 80);
        g.drawString("Attacking Board", 585, 80);
        g.setFont(new Font("Arial Bold", Font.BOLD, 26));
        g.setColor(Color.BLUE);
        g.drawString("1", 28, 110);
        g.drawString("2", 57, 110);
        g.drawString("3", 84, 110);
        g.drawString("4", 110, 110);
        g.drawString("5", 136, 110);
        g.drawString("6", 165, 110);
        g.drawString("7", 193, 110);
        g.drawString("8", 219, 110);
        g.drawString("9", 246, 110);
        g.drawString("10", 265, 110);
        g.drawString("1", 560, 110);
        g.drawString("2", 589, 110);
        g.drawString("3", 615, 110);
        g.drawString("4", 641, 110);
        g.drawString("5", 668, 110);
        g.drawString("6", 697, 110);
        g.drawString("7", 723, 110);
        g.drawString("8", 749, 110);
        g.drawString("9", 775, 110);
        g.drawString("10", 796, 110);
    }

    //change to missed icon
    public void changeIcon(JButton a) {
        a.setIcon(missed);
    }

    //place ships manually with error checking WORKS but not 100% (error that doesn't check 
    //against diagnoal will just place it horizontal
    public void placeShips(final char[][] player2, final char[][]player1, final JLabel b) {
        b.setText("Player 1 place your carrier ship bow (Carrier is 5 spots long)");
        for (int j = 0; j < 10; j++) {
            final int row = j;
            for (int i = 0; i < 10; i++) {
                final int column = i;
                board[j][i].addActionListener(new ActionListener() // anonymous inner class
                {
                    public void actionPerformed(ActionEvent event) {
                        if (boatCounter < 2) {
                            placeCarrier(player2, player1, b, row, column, board);
                            boatCounter++;
                        }
                        else if (boatCounter < 4 ) {
                            placeSub(player2, player1, b, row, column, board);
                            boatCounter++;
                        }
                        else if (boatCounter < 6){
                            placeBattleShip(player2,player1,b,row,column,board);
                            boatCounter++;
                        }
                        else if (boatCounter <  8){
                            placeCruiser(player2,player1,b,row,column,board);
                            boatCounter++;
                        }
                        else if (boatCounter < 10){
                            placeDestroyer(player2,player1,b,row,column,board);
                            boatCounter++;
                            if(onePlayer){  //if one player start here
                                b.setText("One players selected! Player 1's turn!");
                                StartGame(player2, player1, b);
                            }
                            else {  //else go to player two and continue
                                if (boatCounter == 10) {
                                    JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                    String message = "Player 2's turn to place boats. Player 1 please look away!";
                                    temp.setMessage(message);
                                    final JDialog dialog = temp.createDialog(null, "Player 2's Boats");
                                    dialog.setLocation(0, 0);
                                    dialog.setSize(835, 600);
                                    dialog.setResizable(false);
                                    flag = true;
                                    SwitchPlayers(b, 2, dialog, counter, flag);
                                }
                            }
                        }
                    }
                });

                board2[j][i].addActionListener(new ActionListener() // anonymous inner class
                {   //player two set boats
                    public void actionPerformed(ActionEvent event) {
                        if (boatCounter < 12) {
                            placeCarrier(player1, player2, b, row, column, board2);
                            boatCounter++;
                        } else if (boatCounter < 14) {
                            placeSub(player1, player2, b, row, column, board2);
                            boatCounter++;
                        } else if (boatCounter < 16) {
                            placeBattleShip(player1, player2, b, row, column, board2);
                            boatCounter++;
                        } else if (boatCounter < 18) {
                            placeCruiser(player1, player2, b, row, column, board2);
                            boatCounter++;
                        } else if (boatCounter < 20) {
                            placeDestroyer(player1, player2, b, row, column, board2);
                            boatCounter++;
                            if (boatCounter == 20) {
                                JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                String message = "Player 1's turn. Player 2 please look away!";
                                temp.setMessage(message);
                                final JDialog dialog = temp.createDialog(null, "Player 1's turn");
                                dialog.setLocation(0, 0);
                                dialog.setSize(835, 600);
                                dialog.setResizable(false);
                                flag = true;
                                SwitchPlayers(b, 1, dialog, counter,flag);
                                shipsPlaced = true;
                                b.setText("Two players selected! Player 1's turn!");
                                StartGame(player2, player1, b);
                            }
                        }
                    }
                });
            }
        }
    }
    //placing destroyer with error checking for overlap
    public void placeDestroyer (final char[][] player2, final char[][] player1, final JLabel b, int row, int column, JButton[][] a) {
        if (!boatFlag) {
            if (player1[row][column] == 'B'){
                b.setText("Ship crosses another ship! Try again.");
                boatCounter--;
            } else {
                player1[row][column] = 'B';
                a[row][column].setIcon(d1);
                bowCoordinates[0][0] = row;
                bowCoordinates[0][1] = column;
                boatFlag = true;
                b.setText("Place aft!");
            }
        } else {
            if (((row - bowCoordinates[0][0] == 1) || (bowCoordinates[0][0] - row == 1)) ||
                    ((bowCoordinates[0][1] - column == 1) || (column - bowCoordinates[0][1] == 1))) {
                if (row - bowCoordinates[0][0] == 1) {
                    if (player1[row][bowCoordinates[0][1]] == 'B' ){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }
                    else {
                        player1[row - 1][bowCoordinates[0][1]] = 'B';
                        player1[row][bowCoordinates[0][1]] = 'B';


                        a[row][bowCoordinates[0][1]].setIcon(dv2);
                        a[row - 1][bowCoordinates[0][1]].setIcon(dv1);


                        boatFlag = false;;
                    }
                } else if (bowCoordinates[0][0] - row == 1) {
                    if (player1[row][bowCoordinates[0][1]] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }else {
                        player1[row][bowCoordinates[0][1]] = 'B';
                        player1[row + 1][bowCoordinates[0][1]] = 'B';

                        //set GUI
                        a[row][bowCoordinates[0][1]].setIcon(dv1);
                        a[row + 1][bowCoordinates[0][1]].setIcon(dv2);

                        boatFlag = false;
                    }
                    /////////////////CHECK FOR SIDE TO SIDE//////////////
                } else if (column - bowCoordinates[0][1] == 1) {
                    if (player1[bowCoordinates[0][0]][column] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column - 1] = 'B';
                        player1[bowCoordinates[0][0]][column] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(d2);
                        a[bowCoordinates[0][0]][column - 1].setIcon(d1);

                        boatFlag = false;
                    }
                }else {
                    if (player1[bowCoordinates[0][0]][column] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column + 1] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(d1);
                        a[bowCoordinates[0][0]][column + 1].setIcon(d2);

                        boatFlag = false;
                        b.setText("BS!");
                    }
                }
            } else {
                b.setText("Destroyer must be 2 space long vertical or horizontal! Try again.");
                boatCounter--;
            }
        }
    }
    //placing cruiser with error checking for overlap
    public void placeCruiser (final char[][] player2, final char[][] player1, final JLabel b, int row, int column, JButton[][] a) {
        if (!boatFlag) {
            if (player1[row][column] == 'B'){
                b.setText("Ship crosses another ship! Try again.");
                boatCounter--;
            } else {
                player1[row][column] = 'B';
                a[row][column].setIcon(c1);
                bowCoordinates[0][0] = row;
                bowCoordinates[0][1] = column;
                boatFlag = true;
                b.setText("Place the aft!");
            }
        } else {
            if (((row - bowCoordinates[0][0] == 2) || (bowCoordinates[0][0] - row == 2)) ||
                    ((bowCoordinates[0][1] - column == 2) || (column - bowCoordinates[0][1] == 2))) {
                if (row - bowCoordinates[0][0] == 2) {
                    if (player1[row][bowCoordinates[0][1]] == 'B' ||
                            player1[row - 1][bowCoordinates[0][1]] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }
                    else {
                        player1[row][bowCoordinates[0][1]] = 'B';
                        player1[row - 1][bowCoordinates[0][1]] = 'B';
                        player1[row - 2][bowCoordinates[0][1]] = 'B';


                        a[row][bowCoordinates[0][1]].setIcon(cv3);
                        a[row - 1][bowCoordinates[0][1]].setIcon(cv2);
                        a[row - 2][bowCoordinates[0][1]].setIcon(cv1);

                        boatFlag = false;
                        b.setText("Place Destroyer bow!");
                    }
                } else if (bowCoordinates[0][0] - row == 2) {
                    if (player1[row + 1][bowCoordinates[0][1]] == 'B' ||
                            player1[row][bowCoordinates[0][1]] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }else {
                        player1[row][bowCoordinates[0][1]] = 'B';
                        player1[row + 1][bowCoordinates[0][1]] = 'B';
                        player1[row + 2][bowCoordinates[0][1]] = 'B';

                        //set GUI
                        a[row][bowCoordinates[0][1]].setIcon(cv1);
                        a[row + 1][bowCoordinates[0][1]].setIcon(cv2);
                        a[row + 2][bowCoordinates[0][1]].setIcon(cv3);

                        boatFlag = false;
                        b.setText("Place Destroyer bow!");
                    }
                    /////////////////CHECK FOR SIDE TO SIDE//////////////
                } else if (column - bowCoordinates[0][1] == 2) {
                    if (player1[bowCoordinates[0][0]][column - 1] == 'B' ||
                            player1[bowCoordinates[0][0]][column] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column - 1] = 'B';
                        player1[bowCoordinates[0][0]][column - 2] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(c3);
                        a[bowCoordinates[0][0]][column - 1].setIcon(c2);
                        a[bowCoordinates[0][0]][column - 2].setIcon(c1);

                        boatFlag = false;
                        b.setText("Place Destroyer bow!");
                    }
                }else {
                    if (player1[bowCoordinates[0][0]][column + 1] == 'B' ||
                            player1[bowCoordinates[0][0]][column] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {

                        player1[bowCoordinates[0][0]][column + 1] = 'B';
                        player1[bowCoordinates[0][0]][column + 2] = 'B';
                        player1[bowCoordinates[0][0]][column ] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(c1);
                        a[bowCoordinates[0][0]][column + 1].setIcon(c2);
                        a[bowCoordinates[0][0]][column + 2].setIcon(c3);

                        boatFlag = false;
                        b.setText("Place Destroyer bow!");
                    }
                }
            } else {
                b.setText("Cruiser must be 3 space long vertical or horizontal! Try again.");
                boatCounter--;
            }
        }
    }
    //placing BattleShip with error checking for overlap
    public void placeBattleShip(final char[][] player2, final char[][] player1, final JLabel b, int row, int column, JButton[][] a){
        if (!boatFlag) {
            if (player1[row][column] == 'B'){
                b.setText("Ship crosses another ship! Try again.");
                boatCounter--;
            } else {
                player1[row][column] = 'B';
                a[row][column].setIcon(bs1);
                bowCoordinates[0][0] = row;
                bowCoordinates[0][1] = column;
                boatFlag = true;
                b.setText("Place aft!");
            }
        } else {
            if (((row - bowCoordinates[0][0] == 3) || (bowCoordinates[0][0] - row == 3)) ||
                    ((bowCoordinates[0][1] - column == 3) || (column - bowCoordinates[0][1] == 3))) {
                if (row - bowCoordinates[0][0] == 3) {
                    if (player1[row][bowCoordinates[0][1]] == 'B' ||
                            player1[row - 1][bowCoordinates[0][1]] == 'B' ||
                            player1[row - 2][bowCoordinates[0][1]] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }
                    else {
                        player1[row ][bowCoordinates[0][1]] = 'B';
                        player1[row - 1][bowCoordinates[0][1]] = 'B';
                        player1[row - 2][bowCoordinates[0][1]] = 'B';
                        player1[row - 3][bowCoordinates[0][1]] = 'B';


                        a[row][bowCoordinates[0][1]].setIcon(bsv4);
                        a[row - 1][bowCoordinates[0][1]].setIcon(bsv3);
                        a[row - 2][bowCoordinates[0][1]].setIcon(bsv2);
                        a[row - 3][bowCoordinates[0][1]].setIcon(bsv1);

                        boatFlag = false;
                        b.setText("Place Cruiser bow!");
                    }
                } else if (bowCoordinates[0][0] - row == 3) {
                    if (player1[row + 1][bowCoordinates[0][1]] == 'B' ||
                            player1[row][bowCoordinates[0][1]] == 'B' ||
                            player1[row+2][bowCoordinates[0][1]] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }else {
                        player1[row][bowCoordinates[0][1]] = 'B';
                        player1[row + 1][bowCoordinates[0][1]] = 'B';
                        player1[row + 2][bowCoordinates[0][1]] = 'B';
                        player1[row + 3][bowCoordinates[0][1]] = 'B';

                        //set GUI
                        a[row][bowCoordinates[0][1]].setIcon(bsv1);
                        a[row + 1][bowCoordinates[0][1]].setIcon(bsv2);
                        a[row + 2][bowCoordinates[0][1]].setIcon(bsv3);
                        a[row + 3][bowCoordinates[0][1]].setIcon(bsv4);

                        boatFlag = false;
                        b.setText("Place Cruiser bow!");
                    }
                    /////////////////CHECK FOR SIDE TO SIDE//////////////
                } else if (column - bowCoordinates[0][1] == 3) {
                    if (player1[bowCoordinates[0][0]][column - 1] == 'B' ||
                            player1[bowCoordinates[0][0]][column] == 'B' ||
                            player1[bowCoordinates[0][0]][column-2] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column - 1] = 'B';
                        player1[bowCoordinates[0][0]][column - 2] = 'B';
                        player1[bowCoordinates[0][0]][column - 3] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(bs4);
                        a[bowCoordinates[0][0]][column - 1].setIcon(bs3);
                        a[bowCoordinates[0][0]][column - 2].setIcon(bs2);
                        a[bowCoordinates[0][0]][column - 3].setIcon(bs1);

                        boatFlag = false;
                        b.setText("Place Cruiser bow!");
                    }
                }else {
                    if (player1[bowCoordinates[0][0]][column + 1] == 'B' ||
                            player1[bowCoordinates[0][0]][column] == 'B' ||
                            player1[bowCoordinates[0][0]][column + 2] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column + 1] = 'B';
                        player1[bowCoordinates[0][0]][column + 2] = 'B';
                        player1[bowCoordinates[0][0]][column + 3] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(bs1);
                        a[bowCoordinates[0][0]][column + 1].setIcon(bs2);
                        a[bowCoordinates[0][0]][column + 2].setIcon(bs3);
                        a[bowCoordinates[0][0]][column + 3].setIcon(bs4);

                        boatFlag = false;
                        b.setText("Place Cruiser bow!");
                    }
                }
            } else {
                b.setText("Battleship must be 4 space long vertical or horizontal! Try again.");
                boatCounter--;
            }
        }
    }
    //placing submarine with error checking for overlap
    public void placeSub (final char[][] player2, final char[][] player1, final JLabel b, int row, int column, JButton[][] a) {
        if (!boatFlag) {
            if (player1[row][column] == 'B'){
                b.setText("Ship crosses another ship! Try again.");
                boatCounter--;
            } else {
                player1[row][column] = 'B';
                a[row][column].setIcon(sub1);
                bowCoordinates[0][0] = row;
                bowCoordinates[0][1] = column;
                boatFlag = true;
                b.setText("Place aft!");
            }
        } else {
            if (((row - bowCoordinates[0][0] == 2) || (bowCoordinates[0][0] - row == 2)) ||
                    ((bowCoordinates[0][1] - column == 2) || (column - bowCoordinates[0][1] == 2))) {
                if (row - bowCoordinates[0][0] == 2) {
                    if (player1[row][bowCoordinates[0][1]] == 'B' ||
                    player1[row - 1][bowCoordinates[0][1]] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }
                    else {
                        player1[row - 2][bowCoordinates[0][1]] = 'B';
                        player1[row - 1][bowCoordinates[0][1]] = 'B';
                        player1[row][bowCoordinates[0][1]] = 'B';


                        a[row][bowCoordinates[0][1]].setIcon(subv3);
                        a[row - 1][bowCoordinates[0][1]].setIcon(subv2);
                        a[row - 2][bowCoordinates[0][1]].setIcon(subv1);

                        boatFlag = false;
                        b.setText("Place Battleship bow!");
                    }
                } else if (bowCoordinates[0][0] - row == 2) {
                    if (player1[row + 1][bowCoordinates[0][1]] == 'B' ||
                    player1[row][bowCoordinates[0][1]] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    }else {

                        player1[row + 2][bowCoordinates[0][1]] = 'B';
                        player1[row + 1][bowCoordinates[0][1]] = 'B';
                        player1[row][bowCoordinates[0][1]] = 'B';

                        //set GUI
                        a[row][bowCoordinates[0][1]].setIcon(subv1);
                        a[row + 1][bowCoordinates[0][1]].setIcon(subv2);
                        a[row + 2][bowCoordinates[0][1]].setIcon(subv3);

                        boatFlag = false;
                        b.setText("Place Battleship bow!");
                    }
                    /////////////////CHECK FOR SIDE TO SIDE//////////////
                } else if (column - bowCoordinates[0][1] == 2) {
                    if (player1[bowCoordinates[0][0]][column - 1] == 'B' ||
                    player1[bowCoordinates[0][0]][column] == 'B'){
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {

                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column - 1] = 'B';
                        player1[bowCoordinates[0][0]][column - 2] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(sub3);
                        a[bowCoordinates[0][0]][column - 1].setIcon(sub2);
                        a[bowCoordinates[0][0]][column - 2].setIcon(sub1);

                        boatFlag = false;
                        b.setText("Place Battleship bow!");
                    }
               }else {
                    if (player1[bowCoordinates[0][0]][column + 1] == 'B' ||
                    player1[bowCoordinates[0][0]][column] == 'B') {
                        b.setText("Ship crosses another ship! Try again.");
                        boatCounter--;
                    } else {
                        player1[bowCoordinates[0][0]][column + 2] = 'B';
                        player1[bowCoordinates[0][0]][column + 1] = 'B';
                        player1[bowCoordinates[0][0]][column] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(sub1);
                        a[bowCoordinates[0][0]][column + 1].setIcon(sub2);
                        a[bowCoordinates[0][0]][column + 2].setIcon(sub3);

                        boatFlag = false;
                        b.setText("Place Battleship bow!");
                    }
                }
            } else {
                b.setText("Sub must be 3 space long vertical or horizontal! Try again.");
                boatCounter--;
            }
        }
    }
    //placing carrier with error checking for overlap
    public void placeCarrier(final char[][] player2, final char[][] player1, final JLabel b, int row, int column, JButton[][] a) {
            if (!boatFlag) {
                player1[row][column] = 'B';
                a[row][column].setIcon(carrier1);
                bowCoordinates[0][0] = row;
                bowCoordinates[0][1] = column;
                boatFlag = true;
                b.setText("Place aft!");
            } else {
                if (((row - bowCoordinates[0][0] == 4) || (bowCoordinates[0][0] - row == 4)) ||
                        ((bowCoordinates[0][1] - column == 4) || (column - bowCoordinates[0][1] == 4))) {
                    if (row - bowCoordinates[0][0] == 4) {

                        player1[row][bowCoordinates[0][1]] = 'B';
                        player1[row - 1][bowCoordinates[0][1]] = 'B';
                        player1[row - 2][bowCoordinates[0][1]] = 'B';
                        player1[row - 3][bowCoordinates[0][1]] = 'B';

                        a[row][bowCoordinates[0][1]].setIcon(carrierv5);
                        a[row - 1][bowCoordinates[0][1]].setIcon(carrierv4);
                        a[row - 2][bowCoordinates[0][1]].setIcon(carrierv3);
                        a[row - 3][bowCoordinates[0][1]].setIcon(carrierv2);
                        a[row - 4][bowCoordinates[0][1]].setIcon(carrierv1);

                        boatFlag = false;
                        b.setText("Place Submarine bow!");
                    } else if (bowCoordinates[0][0] - row == 4) {
                        player1[row + 1][bowCoordinates[0][1]] = 'B';
                        player1[row + 2][bowCoordinates[0][1]] = 'B';
                        player1[row + 3][bowCoordinates[0][1]] = 'B';
                        player1[row + 4][bowCoordinates[0][1]] = 'B';

                        //set GUI
                        a[row][bowCoordinates[0][1]].setIcon(carrierv1);
                        a[row + 1][bowCoordinates[0][1]].setIcon(carrierv2);
                        a[row + 2][bowCoordinates[0][1]].setIcon(carrierv3);
                        a[row + 3][bowCoordinates[0][1]].setIcon(carrierv4);
                        a[row + 4][bowCoordinates[0][1]].setIcon(carrierv5);

                        boatFlag = false;
                        b.setText("Place Submarine bow!");
                        /////////////////CHECK FOR SIDE TO SIDE//////////////
                    } else if (column - bowCoordinates[0][1] == 4) {
                        a[bowCoordinates[0][0]][column].setIcon(carrier5);
                        a[bowCoordinates[0][0]][column - 1].setIcon(carrier4);
                        a[bowCoordinates[0][0]][column - 2].setIcon(carrier3);
                        a[bowCoordinates[0][0]][column - 3].setIcon(carrier2);
                        a[bowCoordinates[0][0]][column - 4].setIcon(carrier1);

                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column - 1] = 'B';
                        player1[bowCoordinates[0][0]][column - 2] = 'B';
                        player1[bowCoordinates[0][0]][column - 3] = 'B';

                        boatFlag = false;
                        b.setText("Place Submarine bow!");
                    }else {
                        player1[bowCoordinates[0][0]][column] = 'B';
                        player1[bowCoordinates[0][0]][column + 1] = 'B';
                        player1[bowCoordinates[0][0]][column + 2] = 'B';
                        player1[bowCoordinates[0][0]][column + 3] = 'B';
                        player1[bowCoordinates[0][0]][column + 4] = 'B';

                        a[bowCoordinates[0][0]][column].setIcon(carrier1);
                        a[bowCoordinates[0][0]][column + 1].setIcon(carrier2);
                        a[bowCoordinates[0][0]][column + 2].setIcon(carrier3);
                        a[bowCoordinates[0][0]][column + 3].setIcon(carrier4);
                        a[bowCoordinates[0][0]][column + 4].setIcon(carrier5);

                        boatFlag = false;
                        b.setText("Place Submarine bow!");
                    }
                } else {
                    b.setText("Carrier must be 5 space long vertical or horizontal! Try again.");
                    boatCounter--;
                }
            }
    }
    //randomly place ships on board
    public void placeRandomShips(final char[][]player1, final JLabel b, final JButton[][] board)
    {//ship one
        b.setText("Randomly place all 5 ships");
        Random rand = new Random();
        int ship1 = rand.nextInt(2);
        int ship2 = rand.nextInt(2);
        int ship3 = rand.nextInt(2);
        int ship4 = rand.nextInt(2);
        int ship5 = rand.nextInt(2);
        if (ship1 == 0){
            int column = rand.nextInt(10);
            int row = rand.nextInt(5) + 2;
            player1[row][column] = 'B';
            player1[row - 1][column] = 'B';
            player1[row - 2][column] = 'B';
            player1[row + 1][column] = 'B';
            player1[row + 2][column] = 'B';
            board[row][column].setIcon(carrierv3);
            board[row + 1][column].setIcon(carrierv4);
            board[row + 2][column].setIcon(carrierv5);
            board[row - 1][column].setIcon(carrierv2);
            board[row - 2][column].setIcon(carrierv1);
        }
        else{
            int column = rand.nextInt(6) + 2;
            int row = rand.nextInt(10);
            player1[row][column] = 'B';
            player1[row][column - 1] = 'B';
            player1[row][column - 2] = 'B';
            player1[row][column + 1] = 'B';
            player1[row][column + 2] = 'B';
            board[row][column].setIcon(carrier3);
            board[row][column-1].setIcon(carrier2);
            board[row][column-2].setIcon(carrier1);
            board[row][column+1].setIcon(carrier4);
            board[row][column+2].setIcon(carrier5);
        }//ship two
        if (ship2 == 0){
            int column = rand.nextInt(10);
            int row = rand.nextInt(8) + 1;
            while (player1[row][column] != ' ' || player1[row - 1][column] != ' ' ||
                    player1[row + 1][column] != ' '){
                column = rand.nextInt(10);
                row = rand.nextInt(8) + 1;
            }
            player1[row][column] = 'B';
            player1[row + 1][column] = 'B';
            player1[row - 1][column] = 'B';
            board[row][column].setIcon(subv2);
            board[row - 1][column].setIcon(subv1);
            board[row + 1][column].setIcon(subv3);

        }
        else{
            int column = rand.nextInt(8) + 1;
            int row = rand.nextInt(10);
            while (player1[row][column] != ' ' || player1[row][column + 1] != ' ' ||
                    player1[row][column - 1] != ' '){
                column = rand.nextInt(8) + 1;
                row = rand.nextInt(10);
            }
            player1[row][column] = 'B';
            player1[row][column + 1] = 'B';
            player1[row][column - 1] = 'B';
            board[row][column].setIcon(sub2);
            board[row][column - 1].setIcon(sub1);
            board[row][column + 1].setIcon(sub3);
        }//ship 3
        if (ship3 == 0){
            int column = rand.nextInt(10);
            int row = rand.nextInt(6) + 2;
            while (player1[row][column] != ' ' || player1[row - 1][column] != ' ' ||
                    player1[row + 1][column] != ' ' || player1[row + 2][column] != ' '){
                column = rand.nextInt(10);
                row = rand.nextInt(5) + 2;
            }
            player1[row][column] = 'B';
            player1[row - 1][column] = 'B';
            player1[row + 1][column] = 'B';
            player1[row + 2][column] = 'B';
            board[row][column].setIcon(bsv2);
            board[row - 1][column].setIcon(bsv1);
            board[row + 1][column].setIcon(bsv3);
            board[row + 2][column].setIcon(bsv4);

        }
        else{
            int column = rand.nextInt(6) + 2;
            int row = rand.nextInt(10);
            while (player1[row][column] != ' ' || player1[row][column + 1] != ' ' ||
                    player1[row][column - 1] != ' ' || player1[row][column + 2] != ' '){
                column = rand.nextInt(6) + 2;
                row = rand.nextInt(10);
            }
            player1[row][column] = 'B';
            player1[row][column + 1] = 'B';
            player1[row][column + 2] = 'B';
            player1[row][column - 1] = 'B';
            board[row][column].setIcon(bs2);
            board[row][column - 1].setIcon(bs1);
            board[row][column + 1].setIcon(bs3);
            board[row][column + 2].setIcon(bs4);
        }//ship 4
        if (ship4 == 0){
            int column = rand.nextInt(10);
            int row = rand.nextInt(8) + 1;
            while (player1[row][column] != ' ' || player1[row - 1][column] != ' ' ||
                    player1[row + 1][column] != ' '){
                column = rand.nextInt(10);
                row = rand.nextInt(8) + 1;
            }
            player1[row][column] = 'B';
            player1[row + 1][column] = 'B';
            player1[row - 1][column] = 'B';
            board[row][column].setIcon(cv2);
            board[row - 1][column].setIcon(cv1);
            board[row + 1][column].setIcon(cv3);
        }
        else{
            int column = rand.nextInt(8) + 1;
            int row = rand.nextInt(10);
            while (player1[row][column] != ' ' || player1[row][column + 1] != ' ' ||
                    player1[row][column - 1] != ' '){
                column = rand.nextInt(8) + 1;
                row = rand.nextInt(10);
            }
            player1[row][column] = 'B';
            player1[row][column + 1] = 'B';
            player1[row][column - 1] = 'B';
            board[row][column].setIcon(c2);
            board[row][column - 1].setIcon(c1);
            board[row][column + 1].setIcon(c3);
        }//ship5
        if (ship5 == 0){
            int column = rand.nextInt(10);
            int row = rand.nextInt(8) + 1;
            while (player1[row][column] != ' ' || player1[row + 1][column] != ' '){
                column = rand.nextInt(10);
                row = rand.nextInt(8) + 1;
            }
            player1[row][column] = 'B';
            player1[row + 1][column] = 'B';
            board[row][column].setIcon(dv1);
            board[row + 1][column].setIcon(dv2);
        }
        else{
            int column = rand.nextInt(8) + 1;
            int row = rand.nextInt(10);
            while (player1[row][column] != ' ' || player1[row][column + 1] != ' '){
                column = rand.nextInt(8) + 1;
                row = rand.nextInt(10);
            }
            player1[row][column] = 'B';
            player1[row][column + 1] = 'B';
            board[row][column].setIcon(d1);
            board[row][column + 1].setIcon(d2);
        }
        shipsPlaced = true;
    }

    //computer logic for guessing randomly at spots
    public void ComputerTurn(final char[][] player1, final JLabel b) {
        Random rand = new Random(System.currentTimeMillis());
        int x = rand.nextInt(10);
        int y = rand.nextInt(10);
        while (player1[x][y] == 'X') {
            x = rand.nextInt(10);
            y = rand.nextInt(10);
        }
        if (player1[x][y] == ' ') {
            changeIcon(attackBoard2[x][y]);
            player1[x][y] = 'X';
            //change my board for player 1
            changeIcon(board[x][y]);
            //set text
            b.setText("Computer shot missed!");
        }

        if (player1[x][y] == 'B') {
            player1[x][y] = 'X';
            attackBoard2[x][y].setIcon(hit);
            board[x][y].setIcon(hit);
            b.setText("Computer shot hit!");
        }
    }
    //check if game is over
    public boolean GameOver(JLabel a, char[][] b) {
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                if (b[i][l] == 'B') {
                    return false;
                }
            }
        }
        a.setText("GameOver!");
        return true;
    }
    //start the game
    public void StartGame(final char[][] player2, final char[][] player1, final JLabel b) {
        if (b.getText() == "One player selected with randomly placed pieces! Player 1's turn!"){
            if (!onePlayer) {
                JDialog filler = new JDialog();
                flag = false;
                SwitchPlayers(b, 2, filler, counter, flag);
                placeRandomShips(player2, b, board2);
                //place everything for one player random
            }
            onePlayer = true;
            JDialog filler = new JDialog();
            flag = false;
            SwitchPlayers(b, 1, filler, counter,false);
            placeRandomShips(player1, b, board);
        }
        else if (b.getText() == "Two players selected! Player 1's turn!"){
            //place ships for both player 1 and 2
            placeShips(player2, player1, b);
        }
        else if (b.getText() == "Two players selected with randomly placed pieces! Player 1's turn!"){
            //random peices for both players
            placeRandomShips(player1, b, board);
            JDialog filler = new JDialog();
            flag = false;
            SwitchPlayers(b, 2, filler, counter, flag);
            placeRandomShips(player2, b, board2);
            flag = true;
            JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
            String message = "Player 1 will start! Player 2, please look away!";
            temp.setMessage(message);
            final JDialog dialog = temp.createDialog(null, "Player 1's turn");
            dialog.setLocation(0, 0);
            dialog.setSize(835, 600);
            dialog.setResizable(false);
            SwitchPlayers(b, 1, dialog, counter,flag);
        }//one player mode
        else if (b.getText() == "One players selected! Player 1's turn!"){
            if (!onePlayer) {
                JDialog filler = new JDialog();
                flag = false;
                SwitchPlayers(b, 2, filler, counter,false);
                placeRandomShips(player2, b, board2);
            }
            onePlayer = true;
            JDialog filler = new JDialog();
            flag = false;
            SwitchPlayers(b, 1, filler, counter,flag);
            placeShips(player2,player1,b);
        }
        else{//if somehow no game is selected but shouldn't happen
            System.out.println("ERROR");
        }
        //start game with player one
        if (shipsPlaced == true) {
            b.setText("Player 1's Turn!");
            for (int j = 0; j < 10; j++) {
                final int row = j;
                for (int i = 0; i < 10; i++) {
                    final int column = i;
                    attackBoard[j][i].addActionListener(new ActionListener() // anonymous inner class
                    {
                        // terminate application when user clicks exitItem
                        public void actionPerformed(ActionEvent event) {
                            if (player2[row][column] == 'X') {
                                b.setText("This spot was already shot at!");
                            }
                            if (player2[row][column] == ' ') {
                                changeIcon(attackBoard[row][column]);
                                player2[row][column] = 'X';

                                //change my board for player 2
                                changeIcon(board2[row][column]);
                                if (onePlayer == false) {
                                    b.setText("Shot missed!");
                                    JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                    String message = "Player 2's turn. Player 1 please look away!";
                                    temp.setMessage(message);
                                    final JDialog dialog = temp.createDialog(null, "Player 2's Turn");
                                    dialog.setLocation(0, 0);
                                    dialog.setSize(835, 600);
                                    dialog.setResizable(false);
                                    //delay for 3 seconds so player can see what happened
                                    Timer timer = new Timer(1000, new ActionListener() {
                                        //override
                                        public void actionPerformed(ActionEvent e) {
                                            flag = true;
                                            SwitchPlayers(b, 2, dialog, counter,flag);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();
                                } else {
                                    ComputerTurn(player1, b);
                                }
                            }
                            if (player2[row][column] == 'B') {
                                player2[row][column] = 'X';
                                attackBoard[row][column].setIcon(hit);
                                board2[row][column].setIcon(hit);
                                b.setText("Shot hit!");
                                if (onePlayer == false) {
                                    JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                    String message = "Player 2's turn. Player 1 please look away!";
                                    temp.setMessage(message);
                                    final JDialog dialog = temp.createDialog(null, "Player 2's Turn");
                                    dialog.setLocation(0, 0);
                                    dialog.setSize(835, 600);
                                    dialog.setResizable(false);
                                    //delay for 3 seconds so player can see what happened
                                    Timer timer = new Timer(1000, new ActionListener() {
                                        //override
                                        public void actionPerformed(ActionEvent e) {
                                            flag = true;
                                            SwitchPlayers(b, 2, dialog, counter,flag);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();
                                } else {
                                    ComputerTurn(player1,b);
                                }
                            }
                            ///////////////////check game over////////////////////
                            if (GameOver(b,player2)) {
                                JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                String message = "Player 1 Wins!";
                                temp.setMessage(message);
                                final JDialog dialog = temp.createDialog(null, "Player 1 is the winner");
                                dialog.setLocation(0, 0);
                                dialog.setSize(835, 600);
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                System.exit(0);
                            }
                            if (GameOver(b,player1)) {
                                JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                if (!onePlayer) {
                                    String message = "Player 2 Wins!";
                                    temp.setMessage(message);
                                } else {
                                    String message = "The Computer wins!";
                                    temp.setMessage(message);
                                }
                                final JDialog dialog = temp.createDialog(null, "Player 2 is the winner");
                                dialog.setLocation(0, 0);
                                dialog.setSize(835, 600);
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                System.exit(0);
                            }

                        }
                        // exit application
                    } // end method actionPerformed
                    ); // end call to addActionListener);
                    attackBoard2[j][i].addActionListener(new ActionListener() // anonymous inner class
                    {
                        // terminate application when user clicks exitItem
                        public void actionPerformed(ActionEvent event) {
                            if (player1[row][column] == 'X') {
                                b.setText("This spot was already tried!");
                            }
                            if (player1[row][column] == ' ') {
                                changeIcon(attackBoard2[row][column]);
                                player1[row][column] = 'X';
                                //change my board for player 1
                                changeIcon(board[row][column]);

                                //set text and switch players
                                b.setText("Shot missed!");
                                if (onePlayer == false) {
                                    JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                    String message = "Player 1's turn. Player 2 please look away!";
                                    temp.setMessage(message);
                                    final JDialog dialog = temp.createDialog(null, "Player 1's Turn");
                                    dialog.setLocation(0, 0);
                                    dialog.setSize(835, 600);
                                    dialog.setResizable(false);
                                    //delay for 1 seconds so player can see what happened
                                    Timer timer = new Timer(1000, new ActionListener() {
                                        //override
                                        public void actionPerformed(ActionEvent e) {
                                            flag = true;
                                            SwitchPlayers(b, 1, dialog, counter, flag);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();
                                } else {
                                    ComputerTurn(player1, b);
                                }
                            }
                            if (player1[row][column] == 'B') {
                                player1[row][column] = 'X';
                                attackBoard2[row][column].setIcon(hit);
                                board[row][column].setIcon(hit);
                                b.setText("Shot hit!");
                                //switch to second player
                                if (onePlayer == false) {
                                    JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                    String message = "Player 1's turn. Player 2 please look away!";
                                    temp.setMessage(message);
                                    final JDialog dialog = temp.createDialog(null, "Player 1's Turn");
                                    dialog.setLocation(0, 0);
                                    dialog.setSize(835, 600);
                                    dialog.setResizable(false);
                                    //delay for 1 seconds so player can see what happened
                                    Timer timer = new Timer(1000, new ActionListener() {
                                        //override
                                        public void actionPerformed(ActionEvent e) {
                                            flag = true;
                                            SwitchPlayers(b, 1, dialog, counter, flag);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();
                                } else {
                                    ComputerTurn(player1, b);
                                }
                            }
                            /////////////////////Gameover///////////////////////
                            if (GameOver(b, player1)) {
                                JOptionPane temp = new JOptionPane(JOptionPane.INFORMATION_MESSAGE);
                                if (!onePlayer) {
                                    String message = "Player 2 Wins!";
                                    temp.setMessage(message);
                                } else {
                                    String message = "The Computer wins!";
                                    temp.setMessage(message);
                                }
                                final JDialog dialog = temp.createDialog(null, "Player 2 is the winner");
                                dialog.setLocation(0, 0);
                                dialog.setSize(835, 600);
                                dialog.setResizable(false);
                                dialog.setVisible(true);
                                System.exit(0);
                            }

                        }
                        // exit application
                    } // end method actionPerformed
                    ); // end call to addActionListener);
                }
            }
        }
    }
}
