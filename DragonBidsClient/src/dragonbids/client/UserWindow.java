package DragonBidsClient.src.dragonbids.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import DragonBidsApi.src.dragonbids.api.*;

import javax.swing.event.ChangeEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.Toolkit;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//import dragonbids.api.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private boolean waitingForServer = true;
	private Registry registry;
	private DragonBidsServer_I stub;
	private JLabel lblOnline;
	private JLabel lblServerTime;
	private SimpleDateFormat time;
	private JPanel pAccount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserWindow frame = new UserWindow();
					frame.setVisible(true);
					// Wait for Server
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/carminevalentino/Dropbox/Software/AuctionServerApp/img/icon.png"));
		setResizable(false);
		setTitle("DragonBids");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			    JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
			    int index = sourceTabbedPane.getSelectedIndex();
			    System.out.println("DEBUG: Active Tab: " + sourceTabbedPane.getTitleAt(index));
			}
		});
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		pAccount = new JPanel();
		pAccount.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		tabbedPane.addTab("Account", null, pAccount, null);
		tabbedPane.setEnabledAt(0, true);
		pAccount.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(253, 86, 229, 26);
		pAccount.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblUsername.setBounds(329, 58, 124, 16);
		pAccount.add(lblUsername);
		
		JLabel lblServerIs = new JLabel("Server is:");
		lblServerIs.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblServerIs.setBounds(309, 167, 71, 16);
		pAccount.add(lblServerIs);
		
		lblOnline = new JLabel("Offline");
		lblOnline.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
		lblOnline.setForeground(Color.RED);
		lblOnline.setBounds(377, 167, 79, 16);
		pAccount.add(lblOnline);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				testConnectionToServer();

			}
		});
		btnLogin.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		btnLogin.setBounds(309, 209, 117, 29);
		pAccount.add(btnLogin);
		
		lblServerTime = new JLabel("New label");
		lblServerTime.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblServerTime.setBounds(351, 154, 145, 15);
		
        Calendar cal = Calendar.getInstance();
		
		pAccount.add(lblServerTime);
		
		//current time
        time = new SimpleDateFormat("HH:mm:ss");
        System.out.println( time.format(cal.getTime()) );
		lblServerTime.setText(time.format(cal.getTime()));
		
		JLabel label = new JLabel("Time:");
		label.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		label.setBounds(309, 153, 71, 16);
		pAccount.add(label);
		
		JPanel pBuyItem = new JPanel();
		pBuyItem.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		tabbedPane.addTab("Buy", null, pBuyItem, null);
		pBuyItem.setLayout(null);
		
		JPanel pCreateAuction = new JPanel();
		pCreateAuction.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		tabbedPane.addTab("Sell", null, pCreateAuction, null);
		pCreateAuction.setLayout(null);
		
		JPanel pBrowseListings = new JPanel();
		pBrowseListings.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		tabbedPane.addTab("Browse", null, pBrowseListings, null);
		pBrowseListings.setLayout(null);
		
		JPanel notificationPanel = new JPanel();
		contentPane.add(notificationPanel, BorderLayout.SOUTH);
		notificationPanel.setLayout(new BorderLayout(0, 0));
		
		JTextArea notificationPanelBox = new JTextArea();
		notificationPanelBox.setEditable(false);
		notificationPanelBox.setColumns(1);
		notificationPanelBox.setRows(6);
		notificationPanel.add(new JScrollPane(notificationPanelBox), BorderLayout.NORTH);
		
		MessageConsole mc = new MessageConsole(notificationPanelBox);
		
		JLabel lblNewLabel = new JLabel("Notifications");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 14));
		notificationPanel.add(lblNewLabel, BorderLayout.SOUTH);
		mc.redirectOut();
		mc.redirectErr(Color.RED, null);
		mc.setMessageLines(100);
		
		// End Construction
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				connectToServer();
			}
		});
		
	}
	
	private void connectToServer()
	{
		while(waitingForServer)
		{
	        try {
	            registry = LocateRegistry.getRegistry(); //Works only on localhosts, meaning we have to run the server from the same machine/subnet
	            stub = (DragonBidsServer_I) registry.lookup("DragonBids"); //This is a Key to Retrieve the Object from the Registry; Registry is a String:Object pair
	            System.out.println("Connected to Server...");
	            lblOnline.setText("Online");
	            lblOnline.setForeground(Color.GREEN);
	            Calendar cal = Calendar.getInstance();
	            lblServerTime.setText(time.format(cal.getTime()));
	            waitingForServer = false;
	        } catch (Exception e1) {
	        }
		}
	}
	
	private void testConnectionToServer() //This can be called before all GUI operations to ensure connection to Registry is OK
	{
		waitingForServer = true;
		boolean firstEvent = false;
		while(waitingForServer)
		{
	        try {
	            registry = LocateRegistry.getRegistry(); //Works only on localhosts, meaning we have to run the server from the same machine/subnet
	            stub = (DragonBidsServer_I) registry.lookup("DragonBids"); //This is a Key to Retrieve the Object from the Registry; Registry is a String:Object pair
	            System.out.println("Connected to Server...");
				Calendar cal = Calendar.getInstance();
				lblServerTime.setText(time.format(cal.getTime()));
	            lblOnline.setText("Online");
	            lblOnline.setForeground(Color.GREEN);
	            waitingForServer = false;
	        } catch (Exception e1) {
	        	if(!firstEvent)
	        	{
	        		System.out.println("No Connection to Server...");
	    			Calendar cal = Calendar.getInstance();
	    			lblServerTime.setText(time.format(cal.getTime()));
		            lblOnline.setText("Offline");
		            lblOnline.setForeground(Color.RED);
	        		firstEvent = true;
	        	}
	        }
		}
	}
	
}
