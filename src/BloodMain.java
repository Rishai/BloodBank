import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.Icon;

@SuppressWarnings("serial")
public class BloodMain extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField bgroup;
	private JTextField address;
	private JTextField phone;
	private JTextField ref;
	private JTextField willing;
	    JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodMain frame = new BloodMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	   Connection c = null;
	private JTextField blodgroup;
	private JTable searchtable;
	private JTextField na;
	private JTextField bg;
	private JTextField ad;
	private JTextField ph;
	private JTextField re;
	private JTextField wi;
	private JTable updatetable;
	public BloodMain() throws SQLException {
		    /*
		     * CONNECTION PATH WITH DATABASE 
		     */
		 	 c = DriverManager.getConnection("JDBC:sqlite:C:\\Users\\Arif\\Desktop\\Blood\\BloodDatabase\\Blood.sqlite");
		 	 JOptionPane.showMessageDialog(null, "Connected sucessfully");
		 	 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setIcon(new ImageIcon(BloodMain.class.getResource("/Img/NEW.png")));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tabbedPane.setSelectedIndex(0);
				
				
				
				
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mnFile.add(mntmDelete);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JLabel lblBloodDonation = new JLabel("BLOOD DONATION");
		lblBloodDonation.setBackground(Color.WHITE);
		lblBloodDonation.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodDonation.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblBloodDonation.setBounds(32, 46, 973, 76);
		contentPane.add(lblBloodDonation);
		
		 tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setForeground(Color.BLACK);
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 20));
		tabbedPane.setBounds(20, 133, 985, 478);
		contentPane.add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("ADD DONER", new ImageIcon(BloodMain.class.getResource("/Img/ADD.png")), panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		panel.setLayout(null);
		
		JLabel lblDonationPesonInformation = new JLabel("DONATION PESON INFORMATION ");
		lblDonationPesonInformation.setForeground(Color.BLUE);
		lblDonationPesonInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonationPesonInformation.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblDonationPesonInformation.setBounds(28, 0, 783, 63);
		panel.add(lblDonationPesonInformation);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblName.setBounds(57, 66, 222, 43);
		panel.add(lblName);
		
		name = new JTextField();
		name.setBounds(373, 66, 293, 43);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblBloodGroup = new JLabel("BLOOD GROUP");
		lblBloodGroup.setHorizontalAlignment(SwingConstants.CENTER);
		lblBloodGroup.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblBloodGroup.setBounds(57, 120, 222, 43);
		panel.add(lblBloodGroup);
		
		bgroup = new JTextField();
		bgroup.setColumns(10);
		bgroup.setBounds(373, 120, 293, 43);
		panel.add(bgroup);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(373, 174, 293, 43);
		panel.add(address);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(57, 174, 222, 43);
		panel.add(lblAddress);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPhone.setBounds(57, 228, 222, 43);
		panel.add(lblPhone);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(373, 228, 293, 43);
		panel.add(phone);
		
		ref = new JTextField();
		ref.setColumns(10);
		ref.setBounds(373, 282, 293, 43);
		panel.add(ref);
		
		JLabel lblReference = new JLabel("REFERENCE");
		lblReference.setHorizontalAlignment(SwingConstants.CENTER);
		lblReference.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblReference.setBounds(57, 282, 222, 43);
		panel.add(lblReference);
		
		JLabel lblWilling = new JLabel("WILLING");
		lblWilling.setHorizontalAlignment(SwingConstants.CENTER);
		lblWilling.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWilling.setBounds(57, 340, 222, 43);
		panel.add(lblWilling);
		
		willing = new JTextField();
		willing.setColumns(10);
		willing.setBounds(373, 340, 293, 43);
		panel.add(willing);
		
		JButton AddDoner = new JButton("ADD DONER");
		AddDoner.setIcon(new ImageIcon(BloodMain.class.getResource("/Img/add (2).png")));
		AddDoner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								String nam = name.getText();
								String bloodgrp = bgroup.getText();
								String adres = address.getText();
								String phon = phone.getText(); 
								String refrence = ref.getText();
								String wiling = willing.getText();
								
 				
String query="insert into Blooddoner(Name,Bgroup,Address,Phone,Reference,Willing) values('"+nam+"','"+bloodgrp+"','"+adres+"','"+phon+"','"+refrence+"','"+wiling+"')";
				
	try {
		java.sql.Statement st= c.createStatement();
		st.execute(query);
		JOptionPane.showMessageDialog(null, "DONNER ADDED SUCCESSFULLY");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			
				
				
				
			}
		});
		AddDoner.setForeground(Color.RED);
		AddDoner.setBackground(Color.CYAN);
		AddDoner.setFont(new Font("Times New Roman", Font.BOLD, 20));
		AddDoner.setBounds(334, 419, 205, 43);
		panel.add(AddDoner);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("    SEARCH", new ImageIcon(BloodMain.class.getResource("/Img/SEAR.png")), panel_1, null);
		tabbedPane.setBackgroundAt(1, Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("BLOOD GROUP");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label.setBounds(10, 11, 222, 43);
		panel_1.add(label);
		
		blodgroup = new JTextField();
		blodgroup.setColumns(10);
		blodgroup.setBounds(310, 14, 114, 43);
		panel_1.add(blodgroup);
		
		JButton btnSeach = new JButton("SEACH");
		btnSeach.setIcon(new ImageIcon(BloodMain.class.getResource("/Img/SEAR.png")));
		btnSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String bloodgrp = blodgroup.getText();
				
	String query1="select * from Blooddoner where Bgroup='"+bloodgrp.toUpperCase()+"'";
				 
				try {
					java.sql.Statement st1= c.createStatement();
					st1.execute(query1);
					
					ResultSet rs = st1.executeQuery(query1);
					searchtable.setModel(DbUtils.resultSetToTableModel(rs));
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}					
				
				
			 	
				 
				
				
			}
		});
		btnSeach.setBackground(Color.WHITE);
		btnSeach.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSeach.setBounds(550, 11, 184, 59);
		panel_1.add(btnSeach);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 91, 757, 341);
		panel_1.add(scrollPane);
		
		searchtable = new JTable();
		scrollPane.setViewportView(searchtable);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("      UPDATE", new ImageIcon(BloodMain.class.getResource("/Img/up.jpg")), panel_2, null);
		tabbedPane.setBackgroundAt(2, Color.WHITE);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel("NAME");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_1.setBounds(28, 11, 167, 24);
		panel_2.add(label_1);
		
		na = new JTextField();
		na.setEditable(false);
		na.setColumns(10);
		na.setBounds(254, 11, 256, 30);
		panel_2.add(na);
		
		JLabel label_2 = new JLabel("BLOOD GROUP");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_2.setBounds(38, 46, 167, 30);
		panel_2.add(label_2);
		
		bg = new JTextField();
		bg.setColumns(10);
		bg.setBounds(254, 46, 256, 30);
		panel_2.add(bg);
		
		JLabel label_3 = new JLabel("ADDRESS");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_3.setBounds(28, 87, 167, 24);
		panel_2.add(label_3);
		
		ad = new JTextField();
		ad.setColumns(10);
		ad.setBounds(254, 81, 256, 30);
		panel_2.add(ad);
		
		JLabel label_4 = new JLabel("PHONE");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_4.setBounds(38, 130, 167, 24);
		panel_2.add(label_4);
		
		ph = new JTextField();
		ph.setColumns(10);
		ph.setBounds(254, 124, 256, 30);
		panel_2.add(ph);
		
		JLabel label_5 = new JLabel("REFERENCE");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_5.setBounds(28, 171, 167, 24);
		panel_2.add(label_5);
		
		re = new JTextField();
		re.setColumns(10);
		re.setBounds(254, 165, 256, 30);
		panel_2.add(re);
		
		JButton btnUpdate = new JButton("UPDATE DONER");
		btnUpdate.setIcon(new ImageIcon(BloodMain.class.getResource("/Img/UPDATE.png")));
		btnUpdate.addActionListener(new ActionListener() {
			 @SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
			
					String nam1 = name.getText();
					String bloodgrp1 = bgroup.getText();
					String adres1 = address.getText();
					String phon1 = phone.getText(); 
					String refrence1 = re.getText();
					String wiling1 = wi.getText();
					
	
String query5="update Blooddoner set Name='"+nam1+"',Bgroup='"+bloodgrp1+"',Address='"+adres1+"',Phone='"+phon1+"',"
		+ "Reference='"+refrence1+"',Willing ='"+wiling1+"' where Name='"+nam1+"'  ";
	
try {
java.sql.Statement st5= c.createStatement();
st5.execute(query5);
JOptionPane.showMessageDialog(null, "DONNER UPDATED SUCCESSFULLY");
} catch (SQLException e2) {
// TODO Auto-generated catch block
e2.printStackTrace();
 
				
				
				
			}    }
			 });
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(520, 52, 261, 59);
		panel_2.add(btnUpdate);
		
		JLabel label_6 = new JLabel("WILLING");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		label_6.setBounds(520, 14, 110, 30);
		panel_2.add(label_6);
		
		wi = new JTextField();
		wi.setColumns(10);
		wi.setBounds(645, 14, 123, 30);
		panel_2.add(wi);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 206, 752, 256);
		panel_2.add(scrollPane_1);
		
		updatetable = new JTable();
		updatetable.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
		
				int row = updatetable.getSelectedRow();
				String n = updatetable.getModel().getValueAt(row,0).toString();
		String query4="select * from Blooddoner where Name='"+n+"' ";		
				try {
					java.sql.Statement st4=c.createStatement();
					ResultSet rs4 = st4.executeQuery(query4);
					
					
					while(rs4.next()) {
						 
					na.setText(rs4.getString("Name"));
					bg.setText(rs4.getString("Bgroup"));	
					ad.setText(rs4.getString("Address"));	
					ph.setText(rs4.getString("Phone"));
					re.setText(rs4.getString("Reference"));	
					wi.setText(rs4.getString("Willing"));
					
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
			}
		});
		scrollPane_1.setViewportView(updatetable); 
		
		JButton btnShow = new JButton("                SHOW");
		btnShow.setIcon(new ImageIcon(BloodMain.class.getResource("/Img/search.png")));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	
				String query2="select * from Blooddoner ";
							try {
								java.sql.Statement st2= c.createStatement();
								st2.execute(query2);
								
								ResultSet rs2 = st2.executeQuery(query2);
								updatetable.setModel(DbUtils.resultSetToTableModel(rs2));
						
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
				
				
				
				
				
				
			}
		});
		btnShow.setBounds(520, 119, 261, 58);
		panel_2.add(btnShow);
		btnShow.setForeground(Color.RED);
		btnShow.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnShow.setBackground(Color.WHITE);
	}
}
