//Usually you will require both swing and awt packages
// even if you are working with just swings.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class gui {
    public static void main(String args[]) {

        //Creating the Frame
        JFrame frame = new JFrame("KWIC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JButton compute = new JButton("Compute");
        JButton reset = new JButton("Reset");

        JTextArea ta = new JTextArea();

        panel.add(label);
        panel.add(compute);
        panel.add(reset);

        compute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.out.println(ta.getText());
            }
         });

         reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ta.setText("");
            }
         });

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, ta);


        frame.setVisible(true);
    }

}