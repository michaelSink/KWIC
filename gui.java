import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class gui implements inputTransfer, Runnable{

   //Variable for holding data entered by user
   static String data = "";

   //Variable for output text areas
   JTextArea outputArea = new JTextArea();
   JTextArea circularArea = new JTextArea();

   //Interfaces to collect output
   finalOutput output;
   circularOutput circularOut;

    gui(DataSink sink, CircularShift shift) {

         output = sink;
         circularOut = shift;

         //Creates frame to  be shown to user
        JFrame frame = new JFrame("KWIC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

         //JScrollPane scroll = new JScrollPane(outputArea);

        //Create labels and buttons to be displayed
        JLabel label = new JLabel("Enter Text");
        JLabel outputLabel = new JLabel("Final Output");
        JLabel circularOutput = new JLabel("Circular Output");
        JButton compute = new JButton("Submit");
        JButton reset = new JButton("Reset");

        //Input text area
        JTextArea ta = new JTextArea();

        JScrollPane textArea = new JScrollPane(ta);
        JScrollPane outputScrollArea = new JScrollPane(outputArea);
        JScrollPane circularScrollArea = new JScrollPane(circularArea);
      
        //Event listeners for submitting
        compute.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               output.resetOutput();
               circularOut.resetCircularShift();
               data = ta.getText().trim();
               data = "";
            }
         });

         //Event listeners for resetting input
         reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ta.setText("");
               output.resetOutput();
               circularOut.resetCircularShift();
            }
         });

         //Add components to frame
         frame.add(compute);
         frame.add(reset);
         frame.add(label);
         frame.add(textArea);
         frame.add(circularOutput);
         frame.add(circularScrollArea);
         frame.add(outputLabel);
         frame.add(outputScrollArea);

         //Set layout and show
         frame.setLayout(new GridLayout(4, 2));
        frame.setVisible(true);

         //Start collecting input from interfaces
        new Thread(this).start();

    }

	@Override
	public String getLine() {
      return data;
	}

	@Override
	public void run() {
      while(true){
         try{
            Thread.sleep(1);
            outputArea.setText(output.getOuput());
            circularArea.setText(circularOut.getCircularShift());

         }catch(Exception e2){}
      }
		
	}

}