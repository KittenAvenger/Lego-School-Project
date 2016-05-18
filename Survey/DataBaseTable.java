package Survey;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;


/** code used from stack over flow by googling how to create a data base table */

/**@author Dennis Nielsen, Anastasia Koni both made small changes to make it work for our intended use in the project */

public class DataBaseTable extends JPanel {
    private boolean DEBUG = false;
        // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // use specific driver for your database
    static final String DB_URL = "jdbc:mysql://localhost/lego";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    static JFrame frame;
    static Vector<Vector<String>> data = new Vector<Vector<String>>();

    public DataBaseTable(String text, String text2) {
        super(new GridLayout(1,0));
        
        
        
        
        
        Vector<String> columnNames = new Vector<String>();
        columnNames.add("Name");
        columnNames.add("Age");
        columnNames.add("Price(kr)");
        
        //text=Basic.mjau[0];
        //text2=Basic.mjau[1];

      String query =
                "select name, age, price from batman where price between "+text+" and "+text2+" union select name, age, price from starwars where price between "+text+" and "+text2+" union select name, age, price from marvel where price between "+text+" and "+text2+" union select name, age, price from lordoftherings where price between "+text+" and "+text2+" union select name, age, price from videogames where price between "+text+" and "+text2+" order by price desc;";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

                Vector<String> vstring = new Vector<String>();


                 vstring.add(rs.getString("name"));
                vstring.add(rs.getString("age"));
                vstring.add(rs.getString("price"));
                 vstring.add("\n\n\n\n\n\n\n");

                data.add(vstring);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                }
            }
        }

      //  final JTable table = new JTable(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public DataBaseTable(String text, String text2, String text3) {
        super(new GridLayout(1,0));


        Vector<String> columnNames = new Vector<String>();
         columnNames.add("Name");
        columnNames.add("Age");
        columnNames.add("Pieces");
        
        //text=Basic.mjau[0];
        //text2=Basic.mjau[1];

      String query =
                "select name, age, pieces from batman where pieces between "+text+" and "+text2+" union select name, age, pieces from starwars where pieces between "+text+" and "+text2+" union select name, age, pieces from marvel where pieces between "+text+" and "+text2+" union select name, age, pieces from lordoftherings where pieces between "+text+" and "+text2+" order by pieces desc ;";


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

                Vector<String> vstring = new Vector<String>();


                 vstring.add(rs.getString("name"));
                vstring.add(rs.getString("age"));
                vstring.add(rs.getString("pieces"));
                 vstring.add("\n\n\n\n\n\n\n");

                data.add(vstring);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                }
            }
        }

      //  final JTable table = new JTable(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    public DataBaseTable(String query1) {
        super(new GridLayout(1,0));
        

        Vector<String> columnNames = new Vector<String>();
         columnNames.add("Name");
        columnNames.add("Age");
        columnNames.add("Price (kr)");
        columnNames.add("Pieces");
        
        
        

       String query =query1;
                
      


        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {

                Vector<String> vstring = new Vector<String>();


                 vstring.add(rs.getString("name"));
                vstring.add(rs.getString("age"));
                vstring.add(rs.getString("price"));
                vstring.add(rs.getString("pieces"));
                
                 vstring.add("\n\n\n\n\n\n\n");

                data.add(vstring);
                
            }
        
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                	ex.printStackTrace();
                }
            }
        }

      //  final JTable table = new JTable(data, columnNames);
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        final JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    
    public static void createAndShowGUI(String text) {
        //Create and set up the window.
    	
         frame = new JFrame("Database Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        DataBaseTable newContentPane = new DataBaseTable(text);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void createAndShowGUI2(String input,String min, String max) {
        //Create and set up the window.
        JFrame frame = new JFrame("Database Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        DataBaseTable newContentPane = new DataBaseTable(input, min, max);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void createAndShowGUI3(String text,String text2, String text3) {
        //Create and set up the window.
        JFrame frame = new JFrame("Database Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        DataBaseTable newContentPane = new DataBaseTable(text,text2,text3);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    
   

   public static void Yummie() {
        //Schedule a job for the event-dispatching thread:
       //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               //createAndShowGUI();
            }
       });
    }
}

