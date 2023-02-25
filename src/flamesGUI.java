import javax.swing.*;
import java.awt.*;

public class flamesGUI extends  JFrame{
    private JPanel panel;
    private JButton clicked;
    private JTextField nameTwo;
    private JTextField nameOne;
    private JTextArea revealArea;

    public flamesGUI(){
        //Frame
        setTitle("FLAMES");
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(flamesGUI.class.getResource("logo.png")));
        revealArea.setVisible(false);


        //Button
        clicked.addActionListener(e -> {
            flamesLogic logic = new flamesLogic();
            String nOne = nameOne.getText();
            String nTwo =  nameTwo.getText();
            if(nOne.isEmpty()||nTwo.isEmpty()){
                JOptionPane.showMessageDialog(null,"AN INPUT IS EMPTY", "INPUT ERROR",JOptionPane.INFORMATION_MESSAGE);
            }else{
                logic.printOut(nOne,nTwo);//calls flameslogic and method printOut
                revealArea.setVisible(true);
                revealArea.setText(logic.conditionFlames(nOne,nTwo));
                String condition = revealArea.getText();
                revealArea.setForeground(Color.WHITE);
                switch (condition){
                    case "NOT COMPATIBLE" -> {
                        revealArea.setBackground(Color.BLACK);
                    }case "FRIENDS" -> {
                        Color cya = new Color(149, 227, 255);
                        revealArea.setBackground(cya);
                    }case "LOVERS" -> {
                        revealArea.setBackground(Color.RED);
                    }case "ADMIRER" -> {
                        revealArea.setBackground(Color.PINK);
                    }case "MARRIAGE" -> {
                        revealArea.setForeground(Color.BLACK);
                        revealArea.setBackground(Color.WHITE);
                    }case "ENEMY" -> {
                        revealArea.setBackground(Color.DARK_GRAY);
                    }case "SOULMATE" -> {
                        revealArea.setForeground(Color.BLACK);
                        revealArea.setBackground(Color.white);
                    }
                }
            }

        });
    }


    public static void main(String[] args) {
        new flamesGUI();//runs GUI
    }
}
