import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Game extends JFrame implements ActionListener {
    JButton one, two, three, four, five, six, seven, eight, nine;
    JLabel choices, result;
    Container c;
    String currentPlayer;
    Game(){

        c = getContentPane();
        c.setLayout(null);
        one = new JButton(Integer.toString(1));

        two = new JButton(Integer.toString(2));
        three = new JButton(Integer.toString(3));
        four = new JButton(Integer.toString(4));
        five = new JButton(Integer.toString(5));
        six = new JButton(Integer.toString(6));
        seven = new JButton(Integer.toString(7));
        eight = new JButton(Integer.toString(8));
        nine = new JButton(Integer.toString(9));

        int buttonWidth = 70;
        int buttonHeight = 60;
        int buttonSpacing = 10;

        one.setBounds(50, 50, buttonWidth, buttonHeight);
        two.setBounds(50 + buttonWidth + buttonSpacing, 50, buttonWidth, buttonHeight);
        three.setBounds(50 + 2 * (buttonWidth + buttonSpacing), 50, buttonWidth, buttonHeight);
        four.setBounds(50, 50 + buttonHeight + buttonSpacing, buttonWidth, buttonHeight);
        five.setBounds(50 + buttonWidth + buttonSpacing, 50 + buttonHeight + buttonSpacing, buttonWidth, buttonHeight);
        six.setBounds(50 + 2 * (buttonWidth + buttonSpacing), 50 + buttonHeight + buttonSpacing, buttonWidth, buttonHeight);
        seven.setBounds(50, 50 + 2 * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight);
        eight.setBounds(50 + buttonWidth + buttonSpacing, 50 + 2 * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight);
        nine.setBounds(50 + 2 * (buttonWidth + buttonSpacing), 50 + 2 * (buttonHeight + buttonSpacing), buttonWidth, buttonHeight);


        one.setBackground(new Color(9, 227, 119)); // Set button background color
        one.setForeground(Color.white); // Set button text color
        two.setBackground(new Color(9, 227, 119));
        two.setForeground(Color.white);
        three.setBackground(new Color(9, 227, 119));
        three.setForeground(Color.white);
        four.setBackground(new Color(9, 227, 119));
        four.setForeground(Color.white);
        five.setBackground(new Color(9, 227, 119));
        five.setForeground(Color.white);
        six.setBackground(new Color(9, 227, 119));
        six.setForeground(Color.white);
        seven.setBackground(new Color(9, 227, 119));
        seven.setForeground(Color.white);
        eight.setBackground(new Color(9, 227, 119));
        eight.setForeground(Color.white);
        nine.setBackground(new Color(9, 227, 119));
        nine.setForeground(Color.white);


        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        c.add(one);
        c.add(two);
        c.add(three);
        c.add(four);
        c.add(five);
        c.add(six);
        c.add(seven);
        c.add(eight);
        c.add(nine);

        choices = new JLabel("Current Player: X");
        choices.setBounds(50, 270, 200, 30);
        choices.setForeground(new Color(231, 76, 60)); // Set label1 text color to red
        choices.setFont(new Font("Arial", Font.BOLD, 20)); // Set label1 font family, size, and styl
        c.add(choices);

        result = new JLabel("Winner: ");
        result.setBounds(50, 310, 150, 30);
        result.setForeground(new Color(52, 152, 219)); // Set label2 text color to blue
        result.setFont(new Font("Arial", Font.BOLD, 18));
        c.add(result);

        currentPlayer = "X";

    }
    public void actionPerformed(ActionEvent e){
        JButton buttonClicked = (JButton)e.getSource();
        buttonClicked.setEnabled(false);
        buttonClicked.setText(currentPlayer);

        if(checkWinCondition()){
            result.setText("Winner: "+currentPlayer);
            DisableAllbutton();

        } else if (checkDrawCondition()) {
            result.setText("Draw");
            DisableAllbutton();
        }
        else{
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
            choices.setText("Current Player: " + currentPlayer);

        }

    }
    public boolean checkWinCondition(){
        String[][] board = {
                {one.getText(), two.getText(), three.getText()},
                {four.getText(), five.getText(), six.getText()},
                {seven.getText(), eight.getText(), nine.getText()}
        };

        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].isEmpty()) {
                return true;
            }
        }

        //check columns
        for(int i = 0; i<3; i++){
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]) && !board[0][i].isEmpty() ){
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].isEmpty())
                || (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].isEmpty())) {
            return true;
        }
        return false;
    }
    private boolean checkDrawCondition() {
        boolean allButtonsClicked = !one.isEnabled() && !two.isEnabled() && !three.isEnabled()
                && !four.isEnabled() && !five.isEnabled() && !six.isEnabled()
                && !seven.isEnabled() && !eight.isEnabled() && !nine.isEnabled();

        boolean noWinner = result.getText().equals("Winner: ");

        return allButtonsClicked && noWinner;
    }
    public void DisableAllbutton(){
        one.setEnabled(false);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);

    }
}

public class Main {
    public static void main(String[] args) {

        Game obj1 = new Game();
        obj1.setBounds(500, 100, 350, 400);
        obj1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj1.setTitle("tic-tac-toe");
        obj1.setResizable(false);
        obj1.setVisible(true);
    }
}