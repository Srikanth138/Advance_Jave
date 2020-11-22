package gui_jdbc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI_JDBC extends JFrame implements ActionListener {
		private static final String Query="SELECT SNO,NAME,ADDRS,AVG FROM STUDENT";
	private JLabel lNo,lName,lAddrs,lAvg,lmsg=null;
	private JTextField tNo,tName,tAddrs,tAvg;
	private JButton bFirst,bNext,bPrevious,bLast;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public GUI_JDBC(){
		System.out.println("Zero param constrocter");
		setTitle("Gui_ScrollFrame");
		setLayout(new FlowLayout());  //default Layout is BorderLayout & and display the values.
		setSize(300,300);
//		add comps
		lNo=new JLabel("student number");
		add(lNo);
		tNo=new JTextField(10);
		add(tNo);
		
		lName=new JLabel("student Name");
		add(lName);
		tName=new JTextField(10);
		add(tName);
		
		lAddrs=new JLabel("student Addres");
		add(lAddrs);
		tAddrs=new JTextField(10);
		add(tAddrs);
		
		lAvg=new JLabel("student Name");
		add(lAvg);
		tAvg=new JTextField(10);
		add(tAvg);
		
		bFirst=new JButton("First");
		add(bFirst);
//		bFirst.setBounds(150, 150, 95, 30);
		bNext=new JButton("Next");
		add(bNext);
		bPrevious=new JButton("Previous");
		add(bPrevious);
		bLast=new JButton("Last");
		add(bLast);
		
//		add ActionListner to 4 buutons to handle ActionEvent(clicking on Button)
		bFirst.addActionListener(this); //we are linking current class obj(this as Actionlistener to handle Action Event on the button
		bNext.addActionListener(this);
		bPrevious.addActionListener(this);
		bLast.addActionListener(this);
		
		lmsg=new JLabel("");
		add(lmsg);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When close frame window with (x) button the App will be terminated
		jdbcInitialize(); //method call
	
	}
	private void jdbcInitialize(){ //private methods are usefull to seperate logics adn use with in a class
		System.out.println("GUI_JDBC.jdbcInitialize()");
		try{
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott", "tiger");
			ps=con.prepareStatement(Query,ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE); //(Query,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);// other wise raise error
			rs=ps.executeQuery();
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("GUI_JDBC.main(-)");
		new GUI_JDBC(); //Anonymous object
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("GUI_JDBC.actionPerformed(-)");
		boolean flag=false; //var flag=false; java 10  feature  ---  Local variable type inference  (type is decied by compiler) 
		lmsg.setText("");
		if(ae.getSource()==bFirst){
			System.out.println("first button");
			try {
				rs.first();
				flag=true;
			}//try
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}
		
			else if(ae.getSource()==bNext){
				System.out.println("Next button");
				try {
					if(!rs.isLast()) {
				    	rs.next();
					   flag=true;
					}
					else {
						
						lmsg.setText("Do not click on next button, u r already in last record");
						lmsg.setForeground(Color.red);
					}
				}//try
				catch(SQLException se) {
					se.printStackTrace();
				}//catch
				}
		
			else if(ae.getSource()==bPrevious){
					System.out.println("previous button");
					try {
						if(!rs.isFirst()) {
					    	rs.previous();
						 flag=true;
						}
						else {
							lmsg.setText("Do not click on previous button, u r already in first record");
							lmsg.setForeground(Color.red);
						}
					}//try
					catch(SQLException se) {
						se.printStackTrace();
					}//catch
				}
		
				else{
					System.out.println("Last button");
					try {
						rs.last();
						flag=true;
					}//try
					catch(SQLException se) {
						se.printStackTrace();
					}//catch
				}//else
		// set data to text boxes
				if(flag==true) {
					try {
					tNo.setText(rs.getString(1));
					tName.setText(rs.getString(2));
					tAddrs.setText(rs.getString(3));
					tAvg.setText(rs.getString(4));
					}
					catch(SQLException se) {
						se.printStackTrace();
					}
					
				}//if
				
	} //actionPerformed(-)
}//class
