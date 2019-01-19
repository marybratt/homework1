import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TriangleTimes extends JFrame {
	private JTextField angleOneTextField;
	private JTextField angleTwoTextField;
	private JTextField angleThreeTextField;
	private JLabel typeLabel; //holds all messages to user
	public String angle; //variable to send to checkAngle to determine if valid number
	private JButton tryAnotherbtn; //check to see if user wishes to try another triangle
	private boolean validNumber = false;// set to false so that will not process the triangle
																// unless we have a valid number
	private static int angleOne; //Integer value of the angleOneTextField once validated
	private static int angleTwo;//Integer value of the angleTwoTextField once validated
	private static int angleThree;//Integer value of the angleThreeTextField once validated
	private static int checkedAngle = 0;//set the default angle
	
	public TriangleTimes() {
		getContentPane().setBackground(Color.PINK);
		setAutoRequestFocus(false);
		setVisible(true);
		setSize(809, 600);
		setTitle("Triangle Times!");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Triangle Times!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(220, 32, 397, 43);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter First Angle");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_1.setBounds(149, 121, 283, 50);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Enter Second Angle");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel_2.setBounds(149, 184, 299, 50);
		getContentPane().add(lblNewLabel_2);

		JLabel lblEnterThirdAngle = new JLabel("Enter Third Angle");
		lblEnterThirdAngle.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblEnterThirdAngle.setBounds(149, 264, 299, 50);
		getContentPane().add(lblEnterThirdAngle);

		angleOneTextField = new JTextField();
		angleOneTextField.setForeground(Color.RED);
		angleOneTextField.setFont(new Font("Times New Roman", Font.BOLD, 35));
		angleOneTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angle = angleOneTextField.getText();//get text value
				typeLabel.setText("");//set message label to null/ clears it out if error msg was sent
				checkAngle(angle);//checks if a valid number for angle
				if (validNumber) {
					angleOne = checkedAngle;//saves the integer value 
					angleTwoTextField.requestFocusInWindow();//puts cursor in next field
				}else {  // clears the fields to reset to blank
					angleOneTextField.setText("");
					angleOneTextField.requestFocusInWindow();
				}
//				System.out.println(angleOneTextField.getText());
			}
		});
		angleOneTextField.setBounds(551, 122, 116, 50);
		getContentPane().add(angleOneTextField);
		angleOneTextField.setColumns(10);

		angleTwoTextField = new JTextField();
		angleTwoTextField.setForeground(Color.BLUE);
		angleTwoTextField.setFont(new Font("Times New Roman", Font.BOLD, 35));
		angleTwoTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angle = angleTwoTextField.getText();//get text value
				validNumber = false;//resets validNumber to default
				typeLabel.setText("");//set message label to null/ clears it out if error msg was sent
				checkAngle(angle);//checks if a valid number for angle
				if (validNumber) {
					angleTwo = checkedAngle;//saves the integer value
					angleThreeTextField.requestFocusInWindow();//puts cursor in next field
				}else {// clears the fields to reset to blank
					angleTwoTextField.setText("");
					angleTwoTextField.requestFocusInWindow();
				}
//							System.out.println(angleTwoTextField.getText());
		}
	});
		angleTwoTextField.setBounds(551, 185, 116, 50);
		getContentPane().add(angleTwoTextField);
		angleTwoTextField.setColumns(10);

		angleThreeTextField = new JTextField();
		angleThreeTextField.setForeground(Color.GREEN);
		angleThreeTextField.setFont(new Font("Times New Roman", Font.BOLD, 35));
		angleThreeTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				angle = angleThreeTextField.getText();//get text value
				validNumber = false;//resets validNumber to default
				typeLabel.setText("");//set message label to null/ clears it out if error msg was sent
				checkAngle(angle);//checks if a valid number for angle
				if (validNumber) {
					angleThree = checkedAngle;//saves the integer value
					checkTotalAngles();// checks if values of angles equal 180
				}else {// clears the fields to reset to blank
					angleThreeTextField.setText("");
					angleThreeTextField.requestFocusInWindow();
				}
//				System.out.println(angleThreeTextField.getText());
			}
		});
		angleThreeTextField.setBounds(551, 265, 116, 50);
		getContentPane().add(angleThreeTextField);
		angleThreeTextField.setColumns(10);

		//this button will remain unavailable until there is a valid triangle 
		// found and will then be enabled to clear the frame and start again
		tryAnotherbtn = new JButton("Try another?");
		tryAnotherbtn.setFont(new Font("Times New Roman", Font.BOLD, 35));
		tryAnotherbtn.setEnabled(false);
		tryAnotherbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tryAgain();//resets fields to start again
				tryAnotherbtn.setEnabled(false);//set unavailable until another triangle found
			}
		});
		tryAnotherbtn.setBounds(294, 435, 244, 71);
		getContentPane().add(tryAnotherbtn);

		typeLabel = new JLabel("");
		typeLabel.setForeground(Color.MAGENTA);
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		typeLabel.setBounds(27, 327, 730, 50);
		getContentPane().add(typeLabel);
		
		getContentPane().repaint();
		
		angleOneTextField.requestFocusInWindow();
	}
	// if button is clicked will reset all fields to defaults and cursor in the first field
	protected void tryAgain() {
		angleOneTextField.setText("");
		angleTwoTextField.setText("");
		angleThreeTextField.setText("");
		typeLabel.setText("");//clears the message field of all messages
		typeLabel.repaint();
		angleOneTextField.requestFocusInWindow();
		
	}

	// checks to determine if the total of all angles entered equals 180 then process 
	protected void checkTotalAngles() {
		int totalAngles = angleOne + angleTwo + angleThree;// gets some of all angles entered
//		System.out.println(angleOne + " " + angleTwo + " " + angleThree + " = " + totalAngles);
		if (totalAngles == 180) {
			determineType();//if equal to 180 will determine the type of triangle
		} else { //if not equal to 180 will reset all fields and tell user to try again
			validNumber = false;
			angleOneTextField.setText("");
			angleTwoTextField.setText("");
			angleThreeTextField.setText("");
			typeLabel.setText("Angles not equal to 180 degrees. Please try again!");
			typeLabel.repaint();
			angleOneTextField.requestFocusInWindow();//puts cursor on the first field to start again
		}
	}

	//Determine type of triangle
	protected void determineType() {
		//if all angles are equal (60) it is equilateral triangle
		if (angleOne == 60 && angleTwo == 60 && angleThree == 60) {
			typeLabel.setText("You have a Equilateral triangle!");
		// if all angles are different it is a scalene triangle
		} else if (angleOne != angleTwo && angleTwo != angleThree) {
			typeLabel.setText("You have a Scalene triangle!");
		// if any two angles are equal is is an isosceles triangle
		} else if (angleOne == angleTwo || angleTwo == angleThree || angleOne == angleThree ) {
			typeLabel.setText("You have a Isosceles triangle!");
		} else {
			typeLabel.setText("I don't know what kind of triangle you have!");
		}
		//since all angles equal and type is found the try another button is enabled
		// so can re-enter to try another set of numbers
		tryAnotherbtn.setEnabled(true); 
	}
	// Check to see if the user input is an integer and if so to see that is is between 0 and 180
	// if either of these conditions are not met then will output message and set validNumber 
	// to false. if it is a valid number will set validNumber to true. 
	protected void checkAngle(String angle) {
		checkedAngle = 0;
		try {
			// check the angle to see if integer
			checkedAngle = Integer.parseInt(angle);
			if (checkedAngle > 0 && checkedAngle < 180) {
				validNumber = true;
			}
			else {
				typeLabel.setText("Enter an angle  between 1 and 180");
				validNumber = false;
				typeLabel.repaint();
			}
		}
			catch(Exception e) {
				typeLabel.setText("Enter an angle  between 1 and 180");
				validNumber = false;
				typeLabel.repaint();
			}
		//	return validNumber;
	}

	public static void main(String[] args) {
		new TriangleTimes();// call the constructor to create frame
	}
}
