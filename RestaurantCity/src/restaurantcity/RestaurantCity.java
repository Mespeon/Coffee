package restaurantcity;

// @author  Mark Nolledo
import java.util.*;
import java.io.*;

// For SQLite
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RestaurantCity {
    
    // Variables
    Scanner userEntry = new Scanner(System.in);
    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
    
    public String username;
    public String password;
    public int loginAttempt = 0;
    public String doWhat;
    public String customerName = null;
    public int queueNumber = 0;
    //public String[][]customer = new String[99][2];  // 99 rows, 2 cols
    //public int a = 0, b = 0, c = 0; // customer[queueNum][name], queueCount
    
    public String item;
    public String orderQty;
    
    /* Item 2D arrays, fixed size
    IN PLACE JUST IN CASE A PROGRAM REVISION WILL BE MADE.
    public String[][]mains = new String[12][2];
    public String[][]snacks = new String[10][2];
    public String[][]drinks = new String[11][2];
    */
    
    public String[][]order = new String[99][4];
    public int x = 0, y = 0;    // for order array
    public int orderNumber = 0;
    
    // For database management and I/O operations
    Connection connect = null;  // connection
    File databaseFile = new File("C:/Users/Mark Nolledo/Documents/rcsrc/resource.db");  // db file
    public int rowsInserted = 1;    // row count during insertion
    
    // BEGIN CHECK SEQUENCE
    public void initializeSystem() {
        folderCheck();
        
        // Initialize values here as well.
    }
    
    // Checks resource folder
    public void folderCheck() {
        // Resource folder creation
        try {
            System.out.println("Checking resource directory...");
            File resourceDir = new File("C:/Users/Mark Nolledo/Documents/rcsrc");
            if (resourceDir.exists()) {
                System.out.println("Resource folder exists. No new folder created.");
            }
            else {
                resourceDir.mkdirs();
                System.out.println("Directory location: " + resourceDir.getPath());
                System.out.println("Successfully created directory.");
            }
            System.out.println("Directory check successful.\n");
            connectDb(); // call next method in sequence
        }
        catch (Exception e) {
            System.out.println("An error occured while creating the directory.\n\n" + e + "\n\nSystem will now exit.");
            System.exit(0);
        }
    }
    
    // Test connect to db; call create db file if none found, else return pass
    public void connectDb() {
        // Check database file if existing
        try {
            System.out.println("Checking SQLite database and connection...");
            if (databaseFile.exists()) {
                System.out.println("Database file already exists. No new database created.");
                String rcDb = "jdbc:sqlite:C:/Users/Mark Nolledo/Documents/rcsrc/resource.db";   // db location
                connect = DriverManager.getConnection(rcDb); // create connection
                System.out.println("Connection to SQLite has been established.");
                System.out.println("\nInitial checks complete. Begin operations...");
                System.out.println("----------------------------------------------\n\n\n");
                login();
            }
            else {
                System.out.println("No database file found. A new one will be created.");
                createDb();
            }
        }
        catch (SQLException e) {
            System.out.println("TESTING: An error has occurred while connecting to database.\n\n" + e.getMessage() + "\n\nSystem will now exit.");
            System.exit(0);
        }
        finally {
            try {
                if (connect!=null) {
                    connect.close();
                }
            }
            catch (SQLException e) {
                System.out.println("An error has occurred while closing connection.\n\n" + e.getMessage() + "\n\nSystem will now exit.");
                System.exit(0);
            }
        }
    }
    
    // Persist connect to db; this will be used for all subsequent database connections after initialization
    public Connection persistConnect() {
        String rcDb = "jdbc:sqlite:C:/Users/Mark Nolledo/Documents/rcsrc/resource.db";
        try {
            connect = DriverManager.getConnection(rcDb);
        }
        catch(SQLException e) {
            System.out.println("PERSISTENT: An error has occurred while connecting to database.\n\n" + e.getMessage());
        }
        return connect;
    }
    
    // These methods will only be called if a database file is not found.
    // Create db file; only called if no database file exists
    public void createDb() {
        // Create database file
        try {
            String newDb = "jdbc:sqlite:C:/Users/Mark Nolledo/Documents/rcsrc/resource.db";
            connect = DriverManager.getConnection(newDb);   // create connection
            System.out.print("Database file created.\nBegin tables creation...");
            createTable();
        }
        catch (SQLException e) {
            System.out.println("An error has occurred while creating the database.\n\n" + e.getMessage() + "\n\nSystem will now exit.");
            System.exit(0);
        }
    }
    
    // Called by createDb if no database file is found
    public void createTable() {
        // Create table for the database file
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users(\n"
                                + "id integer PRIMARY KEY, \n"
                                + "username text NOT NULL, \n"
                                + "password text NOT NULL\n"
                                + ");";
                
        String createItemsTable = "CREATE TABLE IF NOT EXISTS items(\n"
                                + "id integer PRIMARY KEY, \n"
                                + "name text NOT NULL, \n"
                                + "price real NOT NULL, \n"
                                + "category text NOT NULL\n"
                                + ")";
                
        // CREATE TABLE execution
        String newDb = "jdbc:sqlite:C:/Users/Mark Nolledo/Documents/rcsrc/resource.db";
        try (Connection createConn = DriverManager.getConnection(newDb)){
            // Prepare Statements
            Statement queryUsers = createConn.createStatement();
            Statement queryItems = createConn.createStatement();
                    
            // Execute Statements
            queryUsers.execute(createUsersTable); // query execution
            queryItems.execute(createItemsTable);
            System.out.print("Tables created.\nBegin row insertion...\n");
            
            // PASS THESE VALUES TO INSERT ITEMS METHOD
            // Main dishes
            insertItems("Adobong Baboy", 50, "maindish");//rowsInserted++;
            insertItems("Adobong Manok", 50, "maindish"); //rowsInserted++;
            insertItems("Lechon Baboy", 150, "maindish"); //rowsInserted++;
            insertItems("Lechon Manok", 100, "maindish"); //rowsInserted++;
            insertItems("Pritong Isda", 20, "maindish"); //rowsInserted++;
            insertItems("Chopsuey", 35, "maindish"); //rowsInserted++;
            insertItems("Ginisang Ampalaya", 30, "maindish"); //rowsInserted++;
            insertItems("Giniling", 30, "maindish"); //rowsInserted++;
            insertItems("Daing", 35, "maindish"); //rowsInserted++;
            insertItems("Sinigang na Baboy", 50, "maindish"); //rowsInserted++;
            insertItems("Plain rice", 15, "maindish"); //rowsInserted++;
            insertItems("Sinangag", 20, "maindish"); //rowsInserted++;
            
            // Snacks
            insertItems("Pansit Bihon", 35, "snacks"); //rowsInserted++;
            insertItems("Pansit Canton", 35, "snacks"); //rowsInserted++;
            insertItems("Nata de Coco", 30, "snacks"); //rowsInserted++;
            insertItems("Ginataan", 25, "snacks"); //rowsInserted++;
            insertItems("Camotecue", 25, "snacks"); //rowsInserted++;
            insertItems("Turon", 25, "snacks"); //rowsInserted++;
            insertItems("Kalamay", 20, "snacks"); //rowsInserted++;
            insertItems("Bananacue", 25, "snacks"); //rowsInserted++;
            insertItems("Halo-halo", 35, "snacks"); //rowsInserted++;
            insertItems("Spaghetti", 30, "snacks"); //rowsInserted++;
            
            // Drinks
            insertItems("Coke", 30, "drinks"); //rowsInserted++;
            insertItems("Sprite", 30, "drinks"); //rowsInserted++;
            insertItems("Royal", 30, "drinks"); //rowsInserted++;
            insertItems("Sarsi", 30, "drinks"); //rowsInserted++;
            insertItems("Orange Juice", 20, "drinks"); //rowsInserted++;
            insertItems("Mango Juice", 20, "drinks"); //rowsInserted++;
            insertItems("Sago't Gulaman", 15, "drinks"); //rowsInserted++;
            insertItems("Chocolate Shake", 30, "drinks"); //rowsInserted++;
            insertItems("Mango Shake", 30, "drinks"); //rowsInserted++;
            insertItems("Red Iced Tea", 20, "drinks"); //rowsInserted++;
            insertItems("Calamansi Juice", 20, "drinks"); //rowsInserted++;
        }
        catch (SQLException e) {
            System.out.println("An error has occurred while creating tables.\n\n" + e.getMessage() + "\n\nSystem will now exit.");
            System.exit(0);
        }
    }
    
    public void items() {
        
    }
    
    // Called by createTable if database is newly created
    public void insertItems(String name, int price, String category) {
        // INSERT INTO TABLE execution
        // Used to populate the database with given data
        String insertItems = "INSERT INTO items(name, price, category) VALUES(?, ?, ?)";
        
        try (Connection conn = this.persistConnect(); PreparedStatement insertStatement = conn.prepareStatement(insertItems);) {
            // Get values passed by createTable method
            insertStatement.setString(1, name);
            insertStatement.setInt(2, price);
            insertStatement.setString(3, category);
            insertStatement.executeUpdate();    // execute update query
            
            System.out.println("Row " + rowsInserted + "... OK");
        }
        catch (SQLException e) {
            System.out.println("An error has occurred while inserting rows.\n\n" + e.getMessage() + "\n\nSystem will now exit.");
            System.exit(0);
        }
        finally {
            System.out.println("Rows inserted successfully.");
            System.out.println("\nInitial checks complete. Begin operations...");
            System.out.println("----------------------------------------------\n\n\n");
            login();
        }
    }
    
    // OPERATION METHODS
    public void login() {
        System.out.println("-----------\n"
                         + "|         |\n"
                         + "|  Login  |\n"
                         + "|         |\n"
                         + "-----------");
        System.out.print("Username: ");
        username = userEntry.next();
        System.out.print("Password: ");
        password = userEntry.next();
        verifyUser(username, password);
    }
    
    public void verifyUser(String uname, String pass) {
        String sampleUser = "mespeon";
        String samplePassword = "honkaiimpact3";
        
        // increment login attempts
        if (uname.equals(sampleUser)) {
            if (pass.equals(samplePassword)) {
                System.out.println("\nLogged in.\n"
                                 + "----------------------------------------------\n\n");
                showControls();
            }
            else {
                loginAttempt++;
                System.out.println("\nIncorrect password. Please try again.\nLogin attempt: " + loginAttempt + "\nMaximum 3 attempts\n\n");
                if (loginAttempt < 3) {
                    login();
                }
                else {
                    System.out.println("\nMaximum login attempts reached. System will now exit.");
                    System.exit(0);
                }
            }
        }
        else {
            loginAttempt++;
            System.out.println("\nUser does not exist. Please try again.\nLogin attempt: " + loginAttempt + "\nMaximum 3 attempts\n\n");
            if (loginAttempt < 3) {
                login();
            }
            else {
                System.out.println("\nMaximum login attempts reached. System will now exit.");
                System.exit(0);
            }
        }
    }
    
    public void logout() {
        
    }
    
    public void showControls() {
        System.out.println("-------------------\n"
                         + "|                 |\n"
                         + "|  Control Panel  |\n"
                         + "|                 |\n"
                         + "-------------------");
        System.out.println("[ 1 ] Add New Order\n"
                         + "[ 2 ] View Main Dish menu\n"
                         + "[ 3 ] View Snacks menu\n"
                         + "[ 4 ] View Drinks menu\n"
                         + "[ 5 ] Log Out\n");
        /*
        System.out.println("[ 0 ] Bill Out\n"
                         + "[ 1 ] Order\n");
        System.out.print("Do: ");
        doWhat = userEntry.next();
        
        switch(doWhat) {
            case "0":
                break;
            
            case "1":
                break;
        
            default:
                System.out.println("No valid input detected. Please try again.");
                showControls();
        }
        */
        System.out.print("Do: ");
        doWhat = userEntry.next();
        
        switch(doWhat) {
            case "1":
                setOrder();
                break;
                
            case "2":
                showMainDish("view");
                break;
                
            case "3":
                showSnacks("view");
                break;
                
            case "4":
                showDrinks("view");
                break;
                
            case "5":
                System.out.println("\n\n");
                login();
                break;
                
            default:
                System.out.println("No valid command entered. Please try again.");
                showControls();
        }
    }
    
    public void setOrder() {
        System.out.println("----------------------------------------------\n\n"
                         + "Begin order...\n");
        
        // check if increment for customer queue row (a) is positive or negative
        // positive = has queue; negative = no queue
        /*
        if (a - 1 < 0) {
            System.out.print("Who's ordering? ");
            customerName = userEntry.next();
            System.out.println("This order is for: " + customerName);
            // initially at row(a), 0 col(b) 0, queue(c) 0
            // Set queueNumber
            c++;    // add 1 to C prior insertion, since c = 0
            customer[a][b] = c;
            // Set name
            customer[a][b] = customerName;
            //customer[a][b] = c;   a++; // now set at row(a) 0 col(b) 0; increase row after insertion
            System.out.println("This order is for: " + customerName
                              +"Order queue number is: " + a);  // at this point, a is now at 1
        }
        else {
            
        }
        */
        
        if (customerName == null) {
            System.out.print("Who's ordering? ");
            customerName = userEntry.next();
            System.out.println("\nThis order is for: " + customerName); queueNumber++;
            System.out.println("This order is order number: " + queueNumber);
            /*
            customer[a][b] = customerName;  a++; // initially, set at row 0 col 0; increase row after insertion
            System.out.println("This order is for: " + customerName
                              +"Order queue number is: " + a);  // at this point, a is now at 1
                    */
        }
        else {
            System.out.println("This order is for: " + customerName);
        }
        
        System.out.println("\nSelect a task:\n"
                         + "[ 1 ] Order from Main Dish\n"
                         + "[ 2 ] Order from Snacks\n"
                         + "[ 3 ] Order from Drinks\n"
                         + "[ 4 ] Review Order\n"
                         + "[ 5 ] Bill Out\n");
        System.out.print("Do: ");
        doWhat = userEntry.next();
        
        switch (doWhat) {
            case "1":
                showMainDish("order");
                break;
            
            case "2":
                showSnacks("order");
                break;
                
            case "3":
                showDrinks("order");
                break;
                
            case "4":
                reviewOrder();
                break;
                
            case "5":
                billOut();
                break;
                
            default:
                System.out.println("No valid input detected.");
                setOrder();
        }
    }
    
    public void reviewOrder() {
        System.out.println("----------------------------------------------\n\n"
                         + "Reviewing orders...\n");
        int s = 0;
        System.out.println("This order is for: " + customerName + " (Order Number " + queueNumber + ")");
        System.out.println("\nItem Price\tQuantity\tItem Name");
        while (s < x) {
            System.out.println(order[s][0] + "\t\t" + order[s][3] + "\t\t" + order[s][1]);
            s++;
        }
        setOrder();
    }
    
    public void billOut() {
        System.out.println("----------------------------------------------\n\n"
                         + "Processing transaction...\n");
        if (x == 0) {
            System.out.println("There are no ordered items. Please add one before checking out.");
            System.out.println("\n");
            setOrder();
        }
        else {
            // get date
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            System.out.println("---------------------------------------------------\n"
                             + "|                Restaurant City                  |\n"
                             + "|         Owned and Operated by MN Foods          |\n"
                             + "|           "+ date +"          |\n"
                             + "|                                                 |\n"
                             + "|                   SALES INVOICE                 |\n"
                             + "---------------------------------------------------\n");
            System.out.println("Customer Name: " + customerName
                              +"\nOrder Number: " + queueNumber);
            System.out.println("\n---------------------------------------------------\n"
                             + "|                     O R D E R                   |\n"
                             + "---------------------------------------------------");
            int s = 0;
            System.out.println("\nItem Price\tQuantity\tItem Name");
            while (s < x) {
                System.out.println(order[s][0] + "\t\t" + order[s][3] + "\t\t" + order[s][1]);
                s++;
            }
            System.out.println("\n");
            // CALCULATIONS
            int z = 0, totalQty = 0, totalAmt = 0, tenderedCash, change;
            while (z < x) {
                totalQty += Integer.parseInt(order[z][3]);
                totalAmt += (Integer.parseInt(order[z][3]) * Integer.parseInt(order[z][0]));
                z++;
            }
            System.out.println("\n------------------------------\n"
                             + "Total Quantity: " + totalQty + "\n"
                             + "Total Bill Amount: P" + totalAmt + "\n"
                             + "------------------------------\n");
            System.out.print("\nCASH TENDERED: P");
            tenderedCash = userEntry.nextInt();
            change = tenderedCash - totalAmt;
            System.out.println("CHANGE: P" + change);
            System.out.println("-------------------------------------------------\n"
                             + "|                NOTHING FOLLOWS                |\n"
                             + "-------------------------------------------------\n\n\n");
            showControls();
        }
    }
    
    /*
    public void cancelOrder() {
        System.out.println("----------------------------------------------\n\n"
                         + "Cancelling order...\n");
        queueNumber--;  // reduce one from current queue value (1 order start = +1 order count)
        System.out.print("Order for " + customerName + " is cancelled.");
        customerName = null;    // clear value for customer name
        Arrays.fill(order, "-"); // clear all orders
        x = 0;  y = 0;
        System.out.println("\n\n");
        showControls();
    }
    */
    
    public void addMore(String category) {
        String cat = category;
        System.out.println("\nItem added.\n"
                         + "Add another item? [Y/N]");
        System.out.print("Do: ");
        doWhat = userEntry.next();
        switch (doWhat) {
            case "Y":
            case "y":
                System.out.println("\n");
                if (cat.equals("maindish")) {
                    showMainDish("order");
                }
                
                if (cat.equals("snacks")) {
                    showSnacks("order");
                }
                
                if (cat.equals("drinks")) {
                    showDrinks("order");
                }
                break;
                
            case "N":
            case "n":
                setOrder();
                break;
                
            default:
                System.out.println("Invalid command entered. Please try again.\n");
                addMore(cat);
        }
    }
    
    public void showMainDish(String purpose) {
        System.out.println("----------------------------------------------\n\n"
                         + "Showing all main dishes...\n");
        
        // Get all items from database
        String selectMainDishes = "SELECT * FROM items WHERE category = 'maindish'";
        try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectMainDishes)) {
            System.out.println("Item\tPrice\tItem Name");
            // loop through result set
            while(pullSet.next()) {
                System.out.println(pullSet.getInt("id") + "\t" + pullSet.getInt("price") + "\t" + pullSet.getString("name"));
            }
        }
        catch (SQLException e) {
            System.out.println("PULL MAIN DISH: An error has occurred while retrieving main dishes.\n\n" + e.getMessage());
            showControls();
        }
        // ORDER SETTING
        if (purpose.equals("view")) {
            System.out.println("\n");
            showControls();
        }
        else {
            System.out.print("\nSelect item: ");
            item = userEntry.next();
            System.out.print("Quantity: ");
            orderQty = userEntry.next();
            
            // Add the selected item to the order array along with customer name
            String selectThis = "SELECT * FROM items WHERE category = 'maindish' AND id = " + item;
            try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectThis)) {
                //loop through result set
                while(pullSet.next()) {
                    // Set item price [x][0]
                    order[x][y] = pullSet.getString("price");   y++;    // switch array dimension
                
                    // Set item name [x][1]
                    order[x][y] = pullSet.getString("name");    y++;    // switch array dimension
                
                    // Set customer name [x][2]
                    order[x][y] = customerName; y++;    // switch array dimension
                    
                    // Set order quantity [x][3]
                    order[x][y] = orderQty;
                }
                y = 0;  // reset to 0 after adding an order
                x++;    // increment after adding an order (ONCE)
            }
            catch (SQLException e) {
                System.out.println("PULL MAIN DISH: An error has occurred while adding main dish order.\n\n" + e.getMessage());
                showMainDish("order");
            }
            
            addMore("maindish");
            System.out.println("\n\n");
            //showMainDish("order");
        }
    }
    
    public void showSnacks(String purpose) {
        System.out.println("----------------------------------------------\n\n"
                         + "Showing all snacks...\n");
        
        // Get all items from database
        String selectSnacks = "SELECT * FROM items WHERE category = 'snacks'";
        try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectSnacks)) {
            System.out.println("Item\tPrice\tItem Name");
            // loop through result set
            while(pullSet.next()) {
                System.out.println(pullSet.getInt("id") + "\t" + pullSet.getInt("price") + "\t" + pullSet.getString("name"));
            }
        }
        catch (SQLException e) {
            System.out.println("PULL SNACKS: An error has occurred while retrieving snacks.\n\n" + e.getMessage());
            showControls();
        }
        if (purpose.equals("view")) {
            System.out.println("\n");
            showControls();
        }
        else {
            System.out.print("\nSelect item: ");
            item = userEntry.next();
            System.out.print("Quantity: ");
            orderQty = userEntry.next();
            
            // Push selected items to the order array
            String selectThis = "SELECT * FROM items WHERE category = 'snacks' AND id = " + item;
            
            try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectThis)) {
                // Loop through result set
                while (pullSet.next()) {
                    // Push item price
                    order[x][y] = pullSet.getString("price");   y++;
                    
                    // Push item name
                    order[x][y] = pullSet.getString("name");    y++;
                    
                    // Push customer name
                    order[x][y] = customerName; y++;
                    
                    // Set order quantity
                    order[x][y] = orderQty;
                }
                y = 0;  // reset y to 0 after every order
                x++;    // increment x after every order ONCE
            }
            catch (SQLException e) {
                System.out.println("PULL SNACKS: An error has occurred while adding snacks order.\n\n" + e.getMessage());
                showSnacks("order");
            }
            
            addMore("snacks");
            System.out.println("\n\n");
        }
    }
    
    public void showDrinks(String purpose) {
        System.out.println("----------------------------------------------\n\n"
                         + "Showing all drinks...\n");
        
        // Get all items from database
        String selectDrinks = "SELECT * FROM items WHERE category = 'drinks'";
        try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectDrinks)) {
            System.out.println("Item\tPrice\tItem Name");
            // loop through result set
            while(pullSet.next()) {
                System.out.println(pullSet.getInt("id") + "\t" + pullSet.getInt("price") + "\t" + pullSet.getString("name"));
            }
        }
        catch (SQLException e) {
            System.out.println("PULL DRINKS: An error has occurred while retrieving drinks.\n\n" + e.getMessage());
            showControls();
        }
        if (purpose.equals("view")) {
            System.out.println("\n");
            showControls();
        }
        else {
            System.out.print("\nSelect item: ");
            item = userEntry.next();
            System.out.print("Quantity: ");
            orderQty = userEntry.next();
            
            // Add selected item to order array
            String selectThis = "SELECT * FROM items WHERE category = 'drinks' AND id = " + item;
            
            try (Connection conn = this.persistConnect(); Statement pullStatement = conn.createStatement(); ResultSet pullSet = pullStatement.executeQuery(selectThis)){
                // loop through result set
                while (pullSet.next()) {
                    // Set item price
                    order[x][y] = pullSet.getString("price");   y++;
                    
                    // Set item name
                    order[x][y] = pullSet.getString("name");    y++;
                    
                    // Set customer name
                    order[x][y] = customerName; y++;
                    
                    // Set item quantity
                    order[x][y] = orderQty;
                }
                y = 0;
                x++;
            }
            catch (SQLException e) {
                System.out.println("PULL DRINKS: An error has occurred while adding drinks order.\n\n" + e.getMessage());
                showDrinks("order");
            }
            
            addMore("drinks");
            System.out.println("\n\n");
        }
    }
    
    public static void main(String[] args) {
        RestaurantCity callOut = new RestaurantCity();
        // Initialize resources first before starting operations
        System.out.println("*************************************\n"
                         + "* Restaurant City Management System *\n"
                         + "*        Version 1.0 - MN           *\n"
                         + "*************************************\n");
        System.out.println("Starting up...\nThe system has to perform some checks before running.\nPlease wait...\n");
        callOut.initializeSystem();
    }
}
