import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//import java.swing.*;
import java.util.Random;


public class Tictactoe implements ActionListener{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_pannel = new JPanel();
    JPanel button_pannel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    Tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50, 50 , 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);


        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac_Toe");
        textfield.setOpaque(true);

        title_pannel.setLayout(new BorderLayout());
        title_pannel.setBounds(0,0,800,100);

        button_pannel.setLayout(new GridLayout(3,3));
        button_pannel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_pannel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_pannel.add(textfield);
        frame.add(title_pannel,BorderLayout.NORTH);
        frame.add(button_pannel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    for (int i=0;i<9;i++){
        if(e.getSource()==buttons[i]) {
            if (player1_turn) {
                if (buttons[i].getText() == "") {
                    buttons[i].setForeground(new Color(255, 0, 0));
                    buttons[i].setText("X");
                    player1_turn = false;
                    textfield.setText("0 turn");
                    check();
                }
            } else {
                if (buttons[i].getText() == "") {
                    buttons[i].setForeground(new Color(0, 0, 255));
                    buttons[i].setText("0");
                    player1_turn = true;
                    textfield.setText("X turn");
                    check();
                }
            }
        }
    }

    }
    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        }
        else {
            player1_turn=false;
            textfield.setText("O turn");
        }


    }
    public void check(){
        //x win conditions
       if((buttons[0].getText()=="X")&&
               (buttons[1].getText()=="X")&&
               (buttons[2].getText()=="X")
       ){
           xWins(0,1,2);
       }
        //x win conditions
        if((buttons[3].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[5].getText()=="X")
        ){
            xWins(3,4,5);
        }
        //x win conditions
        if((buttons[6].getText()=="X")&&
                (buttons[7].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(6,7,8);
        }
        //x win conditions
        if((buttons[0].getText()=="X")&&
                (buttons[3].getText()=="X")&&
                (buttons[6].getText()=="X")
        ){
            xWins(0,3,6);
        }
        //x win conditions
        if((buttons[1].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[7].getText()=="X")
        ){
            xWins(1,4,7);
        }
        //x win conditions
        if((buttons[2].getText()=="X")&&
                (buttons[5].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(2,5,8);
        }
        //x win conditions
        if((buttons[0].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[8].getText()=="X")
        ){
            xWins(0,4,8);
        }
        //x win conditions
        if((buttons[2].getText()=="X")&&
                (buttons[4].getText()=="X")&&
                (buttons[6].getText()=="X")
        ){
            xWins(2,4,6);
        }
        //O win conditions
        if((buttons[0].getText()=="0")&&
                (buttons[1].getText()=="0")&&
                (buttons[2].getText()=="0")
        ){
            oWins(0,1,2);
        }

        if((buttons[3].getText()=="0")&&
                (buttons[4].getText()=="0")&&
                (buttons[5].getText()=="0")
        ){
            oWins(3,4,5);
        }

        if((buttons[6].getText()=="0")&&
                (buttons[7].getText()=="0")&&
                (buttons[8].getText()=="0")
        ){
            oWins(6,7,8);
        }

        if((buttons[0].getText()=="0")&&
                (buttons[3].getText()=="0")&&
                (buttons[6].getText()=="0")
        ){
            oWins(0,3,6);
        }

        if((buttons[1].getText()=="0")&&
                (buttons[4].getText()=="0")&&
                (buttons[7].getText()=="0")
        ){
            oWins(1,4,7);
        }

        if((buttons[2].getText()=="0")&&
                (buttons[5].getText()=="0")&&
                (buttons[8].getText()=="0")
        ){
            oWins(2,5,8);
        }

        if((buttons[0].getText()=="0")&&
                (buttons[4].getText()=="0")&&
                (buttons[8].getText()=="0")
        ){
            oWins(0,4,8);
        }

        if((buttons[2].getText()=="0")&&
                (buttons[4].getText()=="0")&&
                (buttons[6].getText()=="0")
        ){
            oWins(2,4,6);
        }
    }
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        textfield.setText("X wiin");
    }
    public void oWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);

        }
        textfield.setText("O wiin");
    }
}
