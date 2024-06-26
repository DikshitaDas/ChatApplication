import javax.swing.*; // to use JFrame, JPanel etc.
import javax.swing.border.EmptyBorder; // to use EmptyBorder
import java.awt.*; // to use the Color class
import java.awt.event.*; // to use ActionListener
import java.io.*; // to use DataInputStream and DataOutputStream
import java.text.SimpleDateFormat;
import java.util.Calendar; 
import java.net.*;  //to create a server and accept client



public class Server implements ActionListener{
    //extends JFrame cant be written because we are going to use it as static method
    //ActionListener is an interface that provides a single method actionPerformed() that is called when an event occurs.
    // JFrame: Represents a window with decorations (like a title, border, and buttons to close, iconify, and maximize the window).
    
    JTextField text; // globally declared to use outside of the constructor
    JPanel a1;
    static Box vertical = Box.createVerticalBox(); //Box with BoxLayout is a great way to create a vertical or horizontal layout for your components. 
    static JFrame f = new JFrame();
    static DataOutputStream dout;


    Server() { // Server constructor

        f.setLayout(null); // allows to manually set the position and size of each component. 
        
        JPanel p1 = new JPanel(); // The JPanel is a versatile and fundamental component in Swing for grouping and managing other components.
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70); // Using setBounds(int x, int y, int width, int height) on a JPanel (or any component) sets its position and size explicitly, allowing for absolute positioning. 
        p1.setLayout(null); // Set the layout manager of the panel to null
        f.add(p1); // Add the panel to the JFrame

        //for the back button(arrow)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("3.png")); // image is loaded from the classpath using ClassLoader.getSystemResource() 
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT); //creates a new scaled version of the original image
        ImageIcon i3 = new ImageIcon(i2); // creates a new ImageIcon from the scaled image
        JLabel back = new JLabel(i3); // Set the icon to the JLabel
        back.setBounds(5, 20, 25, 25);
        p1.add(back); // Add the JLabel to the panel

        back.addMouseListener(new MouseAdapter() { // MouseAdapter is an abstract class that provides a default implementation for all the methods in the MouseListener interface.
            public void mouseClicked(MouseEvent ae) { // mouseClicked() method is called when the mouse is clicked
                System.exit(0); // closes the application
            }
        });

        //for the profile picture
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("1.png"));  
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT); 
        ImageIcon i6 = new ImageIcon(i5); 
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile); 

        
        //for the video icon
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("video.png"));  
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT); 
        ImageIcon i9 = new ImageIcon(i8); 
        JLabel video = new JLabel(i9);
        video.setBounds(300, 25, 20, 20);
        p1.add(video); 

         
        //for the phone icon
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("phone.png"));  
        Image i11 = i10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT); 
        ImageIcon i12 = new ImageIcon(i11); 
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 25, 20, 20);
        p1.add(phone); 

        //for the 3Dots icon
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("3icon.png"));  
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT); 
        ImageIcon i15 = new ImageIcon(i14); 
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert); 


        //for the name
        JLabel name =  new JLabel("User1");
        name.setBounds(110, 20, 100, 18);
        name.setForeground(Color.WHITE); // Sets the color of the text
        name.setFont(new Font("calibri", Font.BOLD, 18));
        p1.add(name);

        //for the status
        JLabel status =  new JLabel("Active Now");
        status.setBounds(110, 45, 100, 18);
        status.setForeground(Color.WHITE); // Sets the color of the text
        status.setFont(new Font("calibri", Font.BOLD, 14));
        p1.add(status);
        

        //for the chat area
        a1 = new JPanel();
        a1.setBounds(5,75,440,570);
        f.add(a1);

        //for input text field
        text = new JTextField();
        text.setBounds(5, 650, 310, 40);
        text.setFont(new Font("calibri", Font.PLAIN, 16));
        f.add(text);

        //for send button
        JButton send = new JButton("send");
        send.setBounds(320, 650, 120, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("calibri", Font.PLAIN, 18));
        send.addActionListener(this); //OVERRIDE METHOD



        f.add(send);


        f.setSize(450, 700); // Sets the size of the window
        f.setLocation(200, 50); // Sets the location of the window 
        f.setUndecorated(true); // Hides the title bar
        // getContentPane() method returns a Container object which can be used to add, remove, and manage components.
        f.getContentPane().setBackground(Color.WHITE); // Sets the background color of the window

        f.setVisible(true); // Makes the window visible (written in last to display all the changes made above)
    }

    //for displaying messages
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel(); // creates a new JPanel
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout with BoxLayout.Y_AXIS on a JPanel will arrange its components vertically. 

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + out + "</p> </html>");  // html is used to display the text in multiple lines and also with a width   
        output.setFont(new Font("calibri", Font.PLAIN, 16)); // Sets the font of the message text
        output.setBackground(new Color(37, 211, 102)); // Sets the background color of the message text
        output.setOpaque(true); // Sets the background color visible or not
        output.setBorder(new EmptyBorder(15,15,15,50)); // Sets the border / padding of the message text

        
        panel.add(output);

        //to add time to the message
        Calendar cal = Calendar.getInstance(); // gets the current time
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm"); // sets the format of the time

        JLabel time  = new JLabel();
        time.setText(sdf.format(cal.getTime())); // sets the text of the time dynamically
        panel.add(time);

        return panel;
    }


    

    //for showing messages on the textbox
    @Override
        public void actionPerformed(ActionEvent ae) {
        //OVERRIDE METHOD

        try{
            String out = text.getText(); // gets the text from the text field
            // System.out.println(out); // prints the text in the console
  
            JPanel p2 = formatLabel(out);
          

            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout()); // creates a new JPanel with BorderLayout
            right.add(p2, BorderLayout.LINE_END); // adds the text to the right side(where the line ends) of the JPanel
            vertical.add(right); // adds the JPanel to the vertical Box
            vertical.add(Box.createVerticalStrut(15)); // adds a vertical strut to the Box. (height is space between two messages)
            a1.add(vertical, BorderLayout.PAGE_START); // adds the Box to the JPanel

            dout.writeUTF(out); //used to send a string message to the client over the network using the DataOutputStream

            text.setText(""); // clears the text field

            //for reload the window
            f.repaint(); //repaint() method in Swing is used to refresh the component and cause the paintComponent method to be called again.
            f.invalidate(); //invalidate() method in Swing is used to invalidate the component 
            f.validate(); //validate() method in Swing is used to validate the component
        }
            
        catch(Exception e){
            e.printStackTrace();
        }
        }


    //Driver code    
   public static void main(String[] args) {
        new Server();

        try{
            ServerSocket skt =  new ServerSocket(6001); //ServerSocket into your Server class to handle server-side networking operations.

            while(true){
                Socket s = skt.accept(); //accept() method blocks until a connection is made, and it returns a Socket object that can be used to communicate with the client
                DataInputStream din = new DataInputStream(s.getInputStream()); //DataOutputStream for writing to the socket.
                dout = new DataOutputStream(s.getOutputStream());//Server class that sets up the server socket and the necessary input and output streams. 

                while(true){
                    String msg = din.readUTF(); //it is a protocol. readUTF() reads a string that has been encoded using a modified UTF-8 format.
                    JPanel panel = formatLabel(msg); //used to create a new JPanel containing the message read from the client. 

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    vertical.add(left);
                    f.validate();
                }

            }

        }
        catch(Exception e){
            e.printStackTrace();
        }


    }
}
