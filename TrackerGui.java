//package Tracker;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static createAccount1.users;
import Tracker.GroupPanel;

public class TrackerGui extends JFrame {

    private JTextField txtUsersRecentStatistics;
    private JTextField txtUserWillBe;
    private JTextField txtStatisticsOfFriend;
    private JTextField txtStatisticsOfFriend_1;
    private JTextField txtStatisticsOfFriend_2;
    private Map<String, JButton> buttonMap = new HashMap<String, JButton>();

    static String startDate = "";
    static String EndDate = "";

    static boolean upDate = false;

    static private User currentUser;

    ArrayList<String> fr = new ArrayList<String>();
    ArrayList<String> ch = new ArrayList<String>();

    static boolean updatedItem = false;

    JComboBox friendList = new JComboBox();

    JComboBox choice = new JComboBox();

    String choiceSelected = "";
    String friendSelected = "";

    ActionListener cbActionListener1 = new ActionListener() {//add actionlistner to listen for change
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) choice.getSelectedItem();//get the selected item
            System.out.println("choice :" + s);
            switch (s) {//check for a match
                case "Choose":
                    break;
                case "Accept":
                    choiceSelected = s;
                    break;
                case "Decline":
                    choiceSelected = s;
                    break;
                default:
                    break;
            }
        }
    };

    ActionListener cbActionListener2 = new ActionListener() {//add actionlistner to listen for change
        @Override
        public void actionPerformed(ActionEvent e) {

            String s = (String) friendList.getSelectedItem();//get the selected item
            System.out.println("friend:" + s);
            switch (s) {//check for a match
                case "Friends":
                    break;
                default:
                    friendSelected = s;
                    break;
            }
        }
    };

    public void setUser(User user) {
        currentUser = user;
    }

    public User getUser() {
        return currentUser;
    }

    static ArrayList<User> users = new ArrayList<User>();

    private String[] buttonLabels = {
        "Show me Averages of my data"
    };

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TrackerGui window = new TrackerGui(currentUser);

                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static String averageHeartRate(String startDate, String endDate) {
        return "Not yet implemented";
    }

    static String caloriesBurned(String startDate, String endDate) {
        return "Not yet implemented";
    }

    static String altitudeLost(String startDate, String endDate) {
        return "Not yet implemented";
    }

    static String altitudeGained(String startDate, String endDate) {
        return "Not yet implemented";
    }

   

    
    
    
    
    
     public void getStorage() throws FileNotFoundException, IOException {

       
         String cwd = System.getProperty("user.dir");
         System.out.println("path"  +cwd);
         
         
         File fin= new File(cwd+"\\src\\Tracker\\Users.txt");
       
       FileInputStream fis = new FileInputStream(fin);
     
 
	//Construct BufferedReader from InputStreamReader
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
	while ((line = br.readLine()) != null) {
		System.out.println("line" + line);
                
                String[] values = line.split(",");
                
                
                CreateAccount.users.add(new User(values[0],values[1]));
                
                
	}
 
	br.close();

    }
    
    
     
    
    
    
    public void addActionListeners(String button) {

        // add more action listeners here 
        if (button.equals("Show me Averages of my data")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    TrackerGui.upDate = true;
                    getDateRange getDates = new getDateRange();
                    getDates.setVisible(true);

                }
            });
        }

        // add more action listeners here 
        if (button.equals("Friend's List")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("Edit Profile")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }
        if (button.equals("UpdateStats")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Hello from button");
                }
            });
        }

        if (button.equals("Update")) {
            buttonMap.get(button).addActionListener(new ActionListener() {
                @Override

                public void actionPerformed(ActionEvent e) {

                    String s = (String) friendList.getSelectedItem();
                    String c = (String) choice.getSelectedItem();

                    switch (c) {//check for a match
                        case "Choose":
                            break;
                        case "Accept":
                            fr.add(s);

                            updatedItem = true;
                            break;
                        case "Decline":
                            fr.remove(s);
                            updatedItem = true;

                            break;
                        default:
                            break;
                    }

                }
            });

        }

        //etc.
    }

    public void enableComponents(Container container, boolean enable) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            component.setEnabled(enable);
            if (component instanceof Container) {
                enableComponents((Container) component, enable);
            }
        }
    }

    /**
     * Create the application.
     */
    public TrackerGui(User currentUser) throws IOException {

        super("my frame");

        String cwd = System.getProperty("user.dir");
        System.out.println("Current working directory : " + cwd);

        try {
            getStorage();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrackerGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        

        fr.add("Friends");
        fr.add("David");
        ch.add("Choose");
        ch.add("Accept");
        ch.add("Decline");
        
        

        friendList.setModel(new DefaultComboBoxModel(fr.toArray()));
        choice.setModel(new DefaultComboBoxModel(ch.toArray()));

        choice.addActionListener(cbActionListener1);
        friendList.addActionListener(cbActionListener2);
        friendList.setSize(200, 200);
        choice.setSize(200, 200);

        this.currentUser = currentUser;
        this.setBounds(200, 200, 1182, 779);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new GridLayout(2, 0));

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            this.getContentPane().add(button);

            buttonMap.put(button.getText(), button);

            addActionListeners(button.getText());

        }

        if (loginPage.loginSucess) {
            TrackerGui.users.add(currentUser);
        }

        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new GridLayout(1, 0));
        JScrollPane scrollPane = new JScrollPane(groupPanel);

        
        System.out.println("Create Account size "  +CreateAccount.users.size() );
        for (int i = 0; i < CreateAccount.users.size(); i++) {

            System.out.println("i "  +i);
            String currentName = CreateAccount.users.get(0).getUser();
            User user = CreateAccount.users.get(i);

            for (int j = 0; j < user.runs.size(); j++) {

                GroupPanel p = new GroupPanel(user.runs.get(j));
                groupPanel.add(p);
                if (!currentName.equals(user.getUser())) {
                    enableComponents(p, false);
                }
            }

        }

        this.add(scrollPane);

    }

}
