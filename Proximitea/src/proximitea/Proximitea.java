/*
ProximiTea Management System
Program created by: Mark Nolledo, Airah Samontina
For: Ms. Yvanna Nocon

Copyright 2015-2016 Mark Nolledo
Program is hard coded using NetBeans then re-compiled for console use
using Windows 10 Command Prompt. No part of this program may be reproduced or 
implemented without permission. 
*/

package proximitea;

import java.io.*;
import java.util.*;

public class Proximitea {
    
    // USER INPUT
    Scanner ScanUserInput = new Scanner(System.in);
    BufferedReader UserInput = new BufferedReader(new InputStreamReader(System.in));
    
    // VARIABLES - ADMINISTRATOR SIDE
    public static int adminCount = 3;
    public static String tempAdminUsername = null;
    public static String tempAdminPassword = null;
    public static String tempAdminConfirmPass = null;
    public static String[]adminUsername = new String[5];
    public static String[]adminPassword = new String[5];
    
    // VARIABLES - END-USER SIDE
    public static int userNumber = 5;
    public static String tempEndUserUsername = null;
    public static String tempEndUserPassword = null;
    public static String tempEndUserConfirmPass = null;
    public static String[]userUsername = new String[10];
    public static String[]userPassword = new String[10];
    public static String[]userStatus = new String[10];
    public static int[]userPurchases = new int[10];
    public static int[]userBalance = new int[10];
    public static Boolean[]userAllowed = new Boolean[10];
    public static int topUpValue = 0;
    
    // VARIABLES - USER SESSION & BUSINESS DATE
    public static Boolean bdStarted = false;
    public static Boolean usStarted = false;
    public static String activeUsername = null;
    public static int activeIDNumber;
    public static int itemNumber = 0;
    public static int itemQuantity = 0;
    public static int addonNumber = 0;
    public static int addonQuantity = 0;
    
    // VARIABLES - ADMIN SESSION
    public static Boolean adminSessionStarted = false;
    public static String activeAdminUser = null;
    public static String activeAdminPassword = null;
    
    // VARIABLES - OTHERS
    public int counter_x = 0;
    public int counter_y = 0;
    public String functionType;
    public static String restart = null;
    public static int itemCount = 5;
    public static int addOnCount = 5;
    public static int[]menuPrices = new int[10]; // ITEM PRICES IN MENU
    public static int[]addonPrices = new int[10]; // ADDON PRICES IN MENU
    public static String[]itemNames = new String[10]; // ITEM NAMES IN STOCK
    public static String[]addonNames = new String[10]; // ADDON NAMES IN STOCK
    public static int[]itemStockCount = new int[10]; // NUMBER OF ITEMS IN STOCK
    public static int[]addonStockCount = new int[10]; // NUMBER OF ADDONS IN STOCK
    public static String tempItemName = null;
    public static int tempItemPrice = 0;
    public static int tempItemStockCount = 0;
    public static String tempAddonName = null;
    public static int tempAddonPrice = 0;
    public static int tempAddonStockCount = 0;
    
    public static int totalDaySales = 0;
    public static int totalTransCount = 0;
    
    /*
    SYSTEM FUNCTIONS
    */
    // GENERAL PURPOSES
    public void clearScreen() {
        for (int clear = 0; clear < 50; clear++) {
            System.out.println("\r\n");
        }
    }
    
    public void resetRestart() {
        if (restart != null) {
            clearScreen();
        }
        restart = null;
    }
    
    // END-USER INTERFACE (FRONT END)
    public void startSession() {
        System.out.println("-------------------------------------------------");
        System.out.println("| Welcome to ProximiTea's Self-Ordering System! |");
        System.out.println("-------------------------------------------------\n");
        if (bdStarted.equals(true) && usStarted.equals(true)) {
            System.out.println("Currently logged in as: " + activeUsername);
        }
        
        else {
            System.out.println("Please note that not all functions are available until you log in.");   
        }
        
        System.out.println("---------- Available Functions ----------");
            if (bdStarted.equals(true) && usStarted.equals(false)) {
                System.out.print("[ 1 ] Log In \n[ 2 ] Register");
            }
            
            if (bdStarted.equals(true) && usStarted.equals(true)) {
                System.out.print("\n[ 3 ] Order \n[ 4 ] Balance Inquiry \n[ 5 ] Log Out");
            }
            
            if (bdStarted.equals(true) && usStarted.equals(false) && adminSessionStarted.equals(true)) {
                System.out.print("\n[ 6 ] Administrative Tools");
            }
        System.out.println("\n\n");
        System.out.print("Please enter a function number: ");
        functionType = ScanUserInput.next();
        
        switch (functionType) {
            case "1":
                clearScreen();
                startUserLogin();
                break;
            case "2":
                generateUser();
                break;
            case "3":
                showMenu();
                break;
            case "4":
                clearScreen();
                accountStatement();
                break;
            case "5":
                activeUsername = null;
                usStarted = false;
                resetRestart();
                clearScreen();
                startSession();
                break;
            case "6":
                clearScreen();
                verifyAdmin();
                break;
            default:
                System.out.println("Invalid function number. Request will be discarded.");
                System.out.println("---------------------------------------------------");
                System.out.print("Press any key to reload screen. ");
                restart = ScanUserInput.next();
                resetRestart();
                startSession();
                ScanUserInput.close();
        }
        
    }
    
    public void startUserLogin() {
        System.out.println("-------------------------------------------------");
        System.out.println("| Welcome to ProximiTea's Self-Ordering System! |");
        System.out.println("-------------------------------------------------\n");
        System.out.println("Please log in using your account details. Don't have an account yet? Register now!\n");
        System.out.print("Username: ");
        tempEndUserUsername = ScanUserInput.next();
        System.out.print("Password: ");
        tempEndUserPassword = ScanUserInput.next();
        
        // VERIFY INPUT
        for (counter_x = 0; counter_x <= userNumber-1; counter_x++) {
            if (tempEndUserUsername.equals(userUsername[counter_x])) {
                if (userPassword[counter_x].equals(tempEndUserPassword)) {
                    if (userAllowed[counter_x].equals(true)) {
                        usStarted = true;
                        activeUsername = userUsername[counter_x];
                        activeIDNumber = counter_x;
                        clearScreen();
                        startSession();
                        ScanUserInput.close();
                        break;
                    }
                    
                    else {
                        System.out.println("The account you are trying to access is banned.");
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Press any key to reload interface.");
                        restart = ScanUserInput.next();
                        resetRestart();
                        startUserLogin();
                        ScanUserInput.close();
                    }
                }
                
                else {
                    System.out.println("Incorrect password.");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.print("Press any key to reload interface.");
                    restart = ScanUserInput.next();
                    resetRestart();
                    startUserLogin();
                    ScanUserInput.close();
                }
            }
            
            else {
                continue;
            }
        }
        
        // CHECKS IF THE FOR-LOOP IS ALREADY FINISHED.
        if (counter_x > adminCount-1) {
            System.out.println("Username not found. Login attempt is invalid and will be discarded.");
            System.out.print("Press any key to retry logging in. ");
            restart = ScanUserInput.next();
            resetRestart();
            startUserLogin();
            ScanUserInput.close();
        }
    }
    
    // USER SIDE (FRONT END)
    public void generateUser() {
        clearScreen();
        counter_x = userNumber;
        System.out.println("--------------------------------------------------");
        System.out.println("USER REGISTRATION");
        System.out.println("--------------------------------------------------");
        System.out.println("Create a new account using this really simple form.\n");
        System.out.print("Enter desired username: ");
        tempEndUserUsername = ScanUserInput.next();
        System.out.print("Enter desired password: ");
        tempEndUserPassword = ScanUserInput.next();
        System.out.print("Confirm password: ");
        tempEndUserConfirmPass = ScanUserInput.next();
        
        // VERIFY USER
        while (counter_y <= userNumber-1) {
            if (tempEndUserUsername.equals(userUsername[counter_y])) {
                System.out.println("Username is already taken.");
                break;
            }
            
            else {
                if (tempEndUserPassword.equals(tempEndUserConfirmPass)) {
                    userUsername[counter_x] = tempEndUserUsername;
                    userPassword[counter_x] = tempEndUserPassword;
                    userStatus[counter_x] = "ACTIVE";
                    userPurchases[counter_x] = 0;
                    userBalance[counter_x] = 0;
                    userAllowed[counter_x] = true;
                    userNumber += 1;
                    System.out.println("\n\nRegistration is successful! Try logging in with your shiny new account!\n\n");
                    startSession();
                    break;
                }
            }
            
            counter_y++;
        }
    }
    
    public void showMenu() {
        clearScreen();
        
        System.out.println(" Welcome to the ProximiTea Self-Ordering System");
        System.out.println("-------------------------------------------------");
        System.out.println("Here are the different items we have in offering!\n");
        counter_x = 0;
        while (counter_x <= itemCount - 1) {
            System.out.println("--------------------------------------------------------------");
            System.out.println((counter_x + 1) + "     " + itemNames[counter_x] + "     P" + menuPrices[counter_x] );
            System.out.println("--------------------------------------------------------------");
            counter_x++;
        }
        
        System.out.println("\n");
        System.out.println("[ 1 ] Place Order \n[ 2 ] Back to End-User Interface\n");
        System.out.print("Select a task: ");
        functionType = ScanUserInput.next();
        switch (functionType) {
            case "1":
                System.out.print("\nEnter item number of desired item: ");
                itemNumber = ScanUserInput.nextInt();
                System.out.print("\nEnter quantity: ");
                itemQuantity = ScanUserInput.nextInt();
                
                System.out.println("\nTry our add-ons!");
                System.out.println("----------------");
                counter_x = 0;
                while (counter_x <= addOnCount - 1) {
                    System.out.println((counter_x + 1) + "     " + addonNames[counter_x] + "      P" + addonPrices[counter_x]);
                    counter_x++;
                }
                System.out.print("\nEnter item of desired add-on (enter 0 if you don't want to add): ");
                addonNumber = ScanUserInput.nextInt();
                if (addonNumber == 0) {
                    addonQuantity = 0;
                }
                
                else {
                    System.out.print("\nEnter quantity: ");
                    addonQuantity = ScanUserInput.nextInt();
                }
                
                System.out.println("\n\nJust a few more checks before you head out ...");
                System.out.println("--------------------------------------------------");
                System.out.println("ORDER SUMMARY");
                System.out.println("--------------------------------------------------");
                if (addonQuantity != 0) {
                    System.out.println(addonQuantity + "   " + addonNames[addonNumber-1] + "    P" + (addonPrices[addonNumber-1] * addonQuantity));
                }
                
                else {
                    System.out.println(itemQuantity + "   " + itemNames[itemNumber-1] + "    P" + (menuPrices[itemNumber-1] * itemQuantity));
                }
                
                System.out.println("\n\n");
                System.out.println("--------------------------------------------------");
                System.out.println("CHECKOUT DETAILS");
                System.out.println("--------------------------------------------------");
                if (addonQuantity != 0) {
                    System.out.println("Subtotal: " + ((menuPrices[itemNumber-1] * itemQuantity) + (addonPrices[addonNumber-1] * addonQuantity)));
                }
                
                else {
                    System.out.println("Subtotal: " + (menuPrices[itemNumber-1] * itemQuantity));
                }
                
                System.out.println("Available purchase credits: " + userBalance[activeIDNumber]);
                
                if (addonQuantity != 0) {
                    System.out.println("Remaining credits after checkout: " + (userBalance[activeIDNumber] - ((menuPrices[itemNumber-1] * itemQuantity) + (addonPrices[addonNumber-1] * addonQuantity))));
                }
                
                else {
                    System.out.println("Remaining credits after checkout: " + (userBalance[activeIDNumber] - (menuPrices[itemNumber-1] * itemQuantity )));
                }
                
                int total = 0;
                if (addonQuantity != 0) {
                    total = ((userBalance[activeIDNumber] - ((menuPrices[itemNumber-1] * itemQuantity) + (addonPrices[addonNumber-1] * addonQuantity))));
                }
                
                else {
                    total = (userBalance[activeIDNumber] - ((menuPrices[itemNumber-1] * itemQuantity)));
                }
                
                if (total > 0) {
                    System.out.print("\n\nProceed with checkout? [ Y/N ] ");
                    functionType = ScanUserInput.next();
                    switch (functionType) {
                        case "Y":
                        case "y":
                            userBalance[activeIDNumber] -= (menuPrices[itemNumber-1] * itemQuantity);
                            userPurchases[activeIDNumber] += itemQuantity;
                            totalDaySales += (menuPrices[itemNumber-1] * itemQuantity);
                            totalTransCount += 1;
                            
                            System.out.println("\n\n");
                            System.out.println("----------------------------------------------------");
                            System.out.println("TRANSACTION IS SUCCESSFUL!");
                            System.out.println("----------------------------------------------------");
                            System.out.println("You bought " + itemQuantity + " " + itemNames[itemNumber-1] + ". Enjoy and drop by again soon!\n\n");
                            startSession();
                            break;
                            
                        case "N":
                        case "n":
                            System.out.println("\nTransaction cancelled.\n\n");
                            startSession();
                            break;
                            
                        default:
                            System.out.println("Invalid input. Request is discarded.");
                            System.out.println("---------------------------------------------------------------------------");
                            System.out.print("Press any key to reload interface");
                            restart = ScanUserInput.next();
                            resetRestart();
                            startSession();
                            ScanUserInput.close();
                    }
                }
                
                else {
                    System.out.println("\n\nYou have insufficient purchase credits. Request a top-up from an admin first!");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.print("Press any key to reload interface.");
                    restart = ScanUserInput.next();
                    resetRestart();
                    clearScreen();
                    startSession();
                    ScanUserInput.close();
                }
                
                break;
                
            case "2":
                clearScreen();
                startSession();
                break;
                
            default:
                System.out.println("Incorrect function input. Input will be discarded.");
                System.out.println("---------------------------------------------------------------------------");
                System.out.print("Press any key to reload interface.");
                restart = ScanUserInput.next();
                resetRestart();
                startSession();
                ScanUserInput.close();
                
        }
    }
    
    public void accountStatement() {
        System.out.println("\n\n");
        System.out.println("-------------------------------------------------");
        System.out.println("ACCOUNT STATEMENT FOR " + activeUsername);
        System.out.println("-------------------------------------------------");
        System.out.println("Current balance: " + userBalance[activeIDNumber]);
        System.out.println("\n\nType any key to go back. ");
        restart = ScanUserInput.next();
        resetRestart();
        startSession();
        ScanUserInput.close();
    }
    
    // ADMIN SIDE (BACK END)
    public void startBusinessDay() {
        resetRestart(); // Similar to generateAdmin(), in case of restarts, reset restart value to null.
        if (adminCount == 0) {
            System.out.println("Start Business Day failed.");
            System.out.println("------------------------------------------------------");
            System.out.println("NO ADMINISTRATORS DETECTED! PLEASE GENERATE ONE FIRST!");
            System.out.println("------------------------------------------------------");
            generateAdmin();
        }
        
        else if (bdStarted.equals(false) && adminCount != 0) {
            System.out.println(adminCount + " administrator/s detected.");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.println("Please login using your administrator account to start business day.");
            System.out.println("To create another administrator, type CREATE in the username field and ADMINISTRATOR in the password field.");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            System.out.print("Username: ");
            tempAdminUsername = ScanUserInput.next();
            System.out.print("Password: ");
            tempAdminPassword = ScanUserInput.next();
            
            // VERIFY USER
            if (tempAdminUsername.equals("CREATE") && tempAdminPassword.equals("ADMINISTRATOR")) {
                clearScreen();
                generateAdmin();
                ScanUserInput.close();
            }
            
            else {
                for (counter_x = 0; counter_x <= adminCount-1; counter_x++) {
                    if (tempAdminUsername.equals(adminUsername[counter_x])) {
                        if (adminPassword[counter_x].equals(tempAdminPassword)) {
                            bdStarted = true;
                            adminSessionStarted = true;
                            activeAdminUser = adminUsername[counter_x];
                            activeAdminPassword = adminPassword[counter_x];
                            System.out.println("\nLogin successful! Business day is successfully started.");
                            System.out.println("Administrator " + activeAdminUser + " is set as the current active administrator.");
                            System.out.println("---------------------------------------------------------------------------------");
                            System.out.print("Press any key to go to the end-user interface. ");
                            restart = ScanUserInput.next();
                            resetRestart();
                            startSession();
                            ScanUserInput.close();
                            break;
                        }
                        
                        else {
                            System.out.println("Incorrect password. Login attempt is invalid and will be discarded.");
                            System.out.println("Press any key to retry Start Business Date. ");
                            restart = ScanUserInput.next();
                            resetRestart();
                            startBusinessDay();
                            ScanUserInput.close();
                            break;
                        }
                    }
                    
                    else {
                        continue;
                    }
                }
                // CHECKS IF THE FOR-LOOP IS ALREADY FINISHED.
                if (counter_x > adminCount-1) {
                    System.out.println("Admin username not found. Login attempt is invalid and will be discarded.");
                    System.out.print("Press any key to retry Start Business Date. ");
                    restart = ScanUserInput.next();
                    resetRestart();
                    startBusinessDay();
                }
            }
            
        }
        
        else {
            startSession();
        }
    }
    
    public void endBusinessDay() {
        clearScreen();
        System.out.println("---------------------------------------------------");
        System.out.println("END BUSINESS DAY CALL SUCCESSFUL");
        System.out.println("---------------------------------------------------\n");
        
        System.out.println("Active Administrator: " + activeAdminUser);
        System.out.println("Total Day Sales: " + totalDaySales);
        System.out.println("Total Transaction Count: " + totalTransCount);
    }
    
    public void generateAdmin() {
        System.out.print("\n");
        System.out.println("Welcome to the ProximiTea Dashboard's Administrator Generator!");
        System.out.println("PLEASE NOTE THAT ACCOUNTS CREATED IN THIS DASHBOARD WILL BE ABLE TO ACCESS ADMINISTRATIVE FUNCTIONS!");
        System.out.println("Secure all account details after registering to avoid unneccessary access.");
        System.out.println("Usernames must be at least 8 characters. Passwords must be at least 12 characters.");
        System.out.println("NO SPACES ALLOWED IN ANY FIELDS.");
        // REGISTRATION
        System.out.print("\nEnter desired username: ");
        tempAdminUsername = ScanUserInput.next();
        System.out.print("Enter desired password: ");
        tempAdminPassword = ScanUserInput.next();
        System.out.print("Confirm password: ");
        tempAdminConfirmPass = ScanUserInput.next();
        
            // CHECK INPUT
            if (tempAdminUsername.length() >= 8) {
               if (tempAdminPassword.length() >= 12) {
                   if (tempAdminConfirmPass.equals(tempAdminPassword)) {
                        adminUsername[adminCount] = tempAdminUsername;
                        adminPassword[adminCount] = tempAdminPassword;
                        adminCount += 1;
                        System.out.println("\nAdministrator account successfully created!");
                        System.out.println("Please login using your admin account to start business day.");
                        clearScreen();
                        startBusinessDay();
                        ScanUserInput.close();
                   }
                   else {
                        System.out.println("Passwords do not match. Registration will be discarded.");
                        System.out.print("Press any key to restart registration. ");
                        restart = ScanUserInput.next();
                        resetRestart();
                        generateAdmin();
                        ScanUserInput.close();
                   }
               }
               else {
                   System.out.println("Password is less than 12 characters in length. Registration will be discarded.");
                   System.out.print("Press any key to restart registration. ");
                   restart = ScanUserInput.next();
                   resetRestart();
                   generateAdmin();
                   ScanUserInput.close();
               }
            }
            else {
                System.out.println("Username is less than 8 characters in length. Registration will be discarded.");
                System.out.print("Press any key to restart registration.");
                restart = ScanUserInput.next();
                resetRestart();
                generateAdmin();
                ScanUserInput.close();
            }
    }
    
    public void verifyAdmin() {
        System.out.println("Welcome to ProximiTea Dashboard's Back End Manager!");
        System.out.println("---------------------------------------------------");
        System.out.println("To verify your identity, please enter again your admin credentials.");
        System.out.println("Double admin sessions are strictly prohibited. Only the current administrator may access the Back End Manager.\n");
        System.out.print("Username: ");
        tempAdminUsername = ScanUserInput.next();
        System.out.print("Password: ");
        tempAdminPassword = ScanUserInput.next();
        
        // VERIFY INPUT
        if (activeAdminUser.equals(tempAdminUsername)) {
            if (activeAdminPassword.equals(tempAdminPassword)) {
                clearScreen();
                backEndStart();
                ScanUserInput.close();
            }
            
            else {
                System.out.println("Incorrect password. Login attempt is invalid and will be discarded.");
                System.out.println("-------------------------------------------------------------------");
                System.out.print("Press any key to reload screen.");
                restart = ScanUserInput.next();
                resetRestart();
                verifyAdmin();
                ScanUserInput.close();
            }
        }
        
        else {
            System.out.println("Incorrect username. Login attempt is invalid and will be discarded.");
            System.out.println("-------------------------------------------------------------------");
            System.out.print("Press any key to reload screen.");
            restart = ScanUserInput.next();
            resetRestart();
            verifyAdmin();
            ScanUserInput.close();
        }
    }
    
    // BACK-END PROCESSES
    public void backEndStart() {
        System.out.println("\n\n-------------------------------------");
        System.out.println("ProximiTea Dashboard Back End Manager");
        System.out.println("-------------------------------------\n\n");
        System.out.println("Back End Access granted to: " + activeAdminUser + "\n\nAccess Level is Administrator. \nUser has Enforce-At-Will Status. \nUser has Order-At-Will Status. \nUser has Full Immunity Status from other users except admins.\n\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.print("You may now access the management tools below.\n\n");
        System.out.println("[ 1 ] View Users \n[ 2 ] View Stocks \n[ 3 ] End Business Date \n[ 4 ] Back to End-User Interface\n");
        System.out.print("Select a management tool: ");
        functionType = null; // RESET THE FUNCTION TYPE VARIABLE TO NULL FIRST.
        functionType = ScanUserInput.next();
        
        switch (functionType) {
            case "1":
                clearScreen();
                viewUsers();
                ScanUserInput.close();
                break;
            case "2":
                viewItems();
                break;
            case "3":
                endBusinessDay();
                break;
            case "4":
                clearScreen();
                startSession();
                ScanUserInput.close();
                break;
            default:
                System.out.println("Invalid tool number. Input is invalid and will be discarded.");
                System.out.println("------------------------------------------------------------");
                System.out.println("Press any key to reload screen.");
                restart = ScanUserInput.next();
                resetRestart();
                backEndStart();
                ScanUserInput.close();
                
        }
    }
    
    public void viewUsers() {
        System.out.println("There are currently " + userNumber + " user/s in the pseudo-database.");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("USER NUMBER \t\t USERNAME \t\t PASSWORD \t\t ACCOUNT STATUS \t TRANSACTION COUNT \t BALANCE");
        counter_x = 0;
        while (counter_x <= userNumber-1) {
            System.out.println((counter_x + 1) + " \t\t\t " + userUsername[counter_x] + " \t\t " + userPassword[counter_x] + " \t\t " + userStatus[counter_x] + " \t\t " + userPurchases[counter_x] + " \t\t\t " + userBalance[counter_x]);
            counter_x++;
        }
        
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.println("[ 1 ] Manage Users \n[ 2 ] Top Up a User \n[ 3 ] Back to Dashboard Home\n\n");
        System.out.print("Please select an action: ");
        functionType = ScanUserInput.next();
        switch (functionType) {
            case "1":
                manageUsers();
                break;
            case "2":
                topUpUsers();
                break;
            case "3":
                clearScreen();
                backEndStart();
                break;
            default:
                System.out.println("Invalid function number. Input will be disregarded.");
                System.out.println("---------------------------------------------------");
                System.out.print("Press any key to reload screen.");
                restart = ScanUserInput.next();
                resetRestart();
                viewUsers();
                ScanUserInput.close();
        }
    }
    
    public void manageUsers() {
        System.out.println("\n\n-----------------------------");
        System.out.println("User Management Control Panel");
        System.out.println("-----------------------------");
        System.out.println("[ 1 ] Ban User \n[ 2 ] Unban User \n[ 3 ] Back to Dashboard\n");
        System.out.print("Select a user management tool: ");
        functionType = ScanUserInput.next();
        switch (functionType) {
            case "1":
                System.out.println("\nThis tool will allow you to prevent a user from accessing their account. \nPlease exercise caution to prevent erronous banning. \nConsult the user table for user parameters.");
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Please enter the user number you would like to ban: ");
                counter_y = ScanUserInput.nextInt();
                
                System.out.println("\nYou are attempting to ban the following user: ");
                System.out.println(userUsername[counter_y-1]);
                System.out.println("----------------------------------------------");
                System.out.print("Proceed? [ Y/N ] ");
                functionType = ScanUserInput.next();
                switch (functionType) {
                    case "Y":
                    case "y":
                        userStatus[counter_y-1] = "BANNED";
                        userAllowed[counter_y-1] = false;
                        System.out.println("\nUser " + userUsername[counter_y-1] + " is now banned. \n\n");
                        viewUsers();
                        break;
                        
                    case "N":
                    case "n":
                        System.out.println("\nOperation cancelled. \n\n");
                        viewUsers();
                        break;
                        
                    default:
                        System.out.println("\n\nInvalid answer. Input will be disregarded.");
                        System.out.println("-------------------------------------------------------------------------------------------------");
                        System.out.print("Press any key to reload screen. Do note that you will have to enter again the last option you used.");
                        restart = ScanUserInput.next();
                        resetRestart();
                        viewUsers();
                        ScanUserInput.close();
                }
                break;
                
            case "2":
                System.out.println("\nThis tool will allow you to unban a user. Unbanned users will be able to access their accounts.");
                System.out.println("--------------------------------------------------------------------------------------------------");
                System.out.print("Enter the user number of the banned user: ");
                counter_y = ScanUserInput.nextInt();
                if (userAllowed[counter_y-1].equals(false)) {
                    System.out.println("You are attempting to unban the following user: ");
                    System.out.println(userUsername[counter_y-1]);
                    System.out.print("\nProceed? [ Y/N ] ");
                    functionType = ScanUserInput.next();
                    switch (functionType) {
                        case "Y":
                        case "y":
                            userStatus[counter_y-1] = "ACTIVE";
                            userAllowed[counter_y-1] = true;
                            System.out.println("\nUser " + userUsername[counter_y-1] + " is now unbanned.\n\n");
                            viewUsers();
                            break;
                           
                        case "N":
                        case "n":
                            System.out.println("\nOperation cancelled. \n\n");
                            viewUsers();
                            break;
                            
                        default:
                            System.out.println("\n\nInvalid answer. Input will be disregarded.");
                            System.out.println("-------------------------------------------------------------------------------------------------");
                            System.out.print("Press any key to reload screen. Do note that you will have to enter again the last option you used.");
                            restart = ScanUserInput.next();
                            resetRestart();
                            viewUsers();
                            ScanUserInput.close();
                    }
                }
                
                else {
                    System.out.println("You are attempting to unban the following user: " + userUsername[counter_y-1]);
                    System.out.println("\nThe user is not banned. There is no need to unban this user.\n\n");
                    viewUsers();
                }
                break;
                
            case "3":
                clearScreen();
                viewUsers();
                break;
                
            default:
                System.out.println("Invalid function number. Input will be disregarded.");
                System.out.println("---------------------------------------------------");
                System.out.print("Press any key to reload screen.");
                restart = ScanUserInput.next();
                resetRestart();
                viewUsers();
                manageUsers();
                ScanUserInput.close();
        }
    }
    
    public void topUpUsers() {
        System.out.println("\n\n-------------------------");
        System.out.println("User Top-up Control Panel");
        System.out.println("-------------------------");
        System.out.println("This control panel will allow you to add purchase credits to user. \nThe maximum credits that could be held by a single user is 9999.\n\n");
        System.out.print("Enter the user you want to top-up: ");
        counter_y = ScanUserInput.nextInt();
        System.out.println("USER \t\t BALANCE");
        System.out.println(userUsername[counter_y-1] + " \t " + userBalance[counter_y-1]);
        System.out.println("\n\nYou are attempting to top up this user.\n");
        System.out.print("Enter amount (minimum of 100): ");
        topUpValue = ScanUserInput.nextInt();
        if (topUpValue >= 100) {
            System.out.print("Loading " + topUpValue + " credits to user " + userUsername[counter_y-1] +". Proceed? [ Y/N ] ");
            functionType = ScanUserInput.next();
            if (userBalance[counter_y-1] < 9999) {
                switch (functionType) {
                    case "Y":
                    case "y":
                        userBalance[counter_y-1] += topUpValue;
                        System.out.println("\nCredits have been successfully loaded.");
                        System.out.println("USER \t\t NEW BALANCE");
                        System.out.println(userUsername[counter_y-1] + " \t " + userBalance[counter_y-1]);
                        System.out.println("\n\n");
                        viewUsers();
                        break;
                    
                    case "N":
                    case "n":
                        System.out.println("\nOperation cancelled.\n\n");
                        viewUsers();
                        break;
                    
                    default:
                        System.out.println("Invalid answer. Input will be disregarded.");
                        System.out.println("---------------------------------------------------");
                        System.out.print("Press any key to reload User Management Control Panel. You may have to enter again the option you last used.");
                        restart = ScanUserInput.next();
                        resetRestart();
                        viewUsers();
                        ScanUserInput.close();
                }
            }
            
            else {
                System.out.println("\nUser balance is 9999. Cannot load any more credits. Operation is cancelled. \n\n");
                viewUsers();
            }
        }
        
        else {
            System.out.println("Top-up value is less than 100. Please enter an amount that is at least 100.");
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Press any key to reload Dashboard.");
            restart = ScanUserInput.next();
            resetRestart();
            viewUsers();
            ScanUserInput.close();
        }
    }
    
    public void viewItems() {
        System.out.println("\n\n----------------------------------");
        System.out.println("Resources Management Control Panel");
        System.out.println("----------------------------------");
        System.out.println("This control panel will enable you to manage your stocks.\n");
        if (itemCount == 0 && addOnCount == 0) {
            System.out.println("There are currently no items in stock.");
        }
        
        else {
            System.out.println("There are currently " + itemCount + " items and " + addOnCount + " addons in stock.");
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println("MENU ITEMS");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("ITEM NUMBER  |  ITEM NAME  |  ITEM PRICE  |  IN STOCK");
            counter_x = 0;
            while (counter_x <= itemCount-1) {
                System.out.println((counter_x + 1) + "  |  " + itemNames[counter_x] + "  |  " + menuPrices[counter_x] + "  |  " + itemStockCount[counter_x]);
                counter_x++;
            }
            System.out.println("-----------------------------------------------------------------------------------");
            
            System.out.println("\n-----------------------------------------------------------------------------------");
            System.out.println("ADDON ITEMS");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("ITEM NUMBER  |  ITEM NAME  |  ITEM PRICE  |  IN STOCK");
            counter_x = 0;
            while (counter_x <= addOnCount-1) {
                System.out.println((counter_x + 1) + "  |  " + addonNames[counter_x] + "  |  " + addonPrices[counter_x] + "  |  " + addonStockCount[counter_x]);
                counter_x++;
            }
            System.out.println("-----------------------------------------------------------------------------------");
            
            editItems();
        }
    }
    
    public void editItems() {
        System.out.println("\n");
        System.out.println("[ 1 ] Add Items \n[ 2 ] Remove Items \n[ 3 ] Price Control \n[ 4 ] Back to Dashboard\n");
        System.out.print("Select a tool: ");
        functionType = ScanUserInput.next();
        switch (functionType) {
            case "1":
                System.out.println("\n[ 1 ] Main Item \n[ 2 ] Addon Item \n[ 3 ] Cancel\n");
                System.out.print("Select an item you want to add: ");
                functionType = ScanUserInput.next();
                switch (functionType) {
                    case "1":
                        counter_y = itemCount;
                        System.out.print("\nEnter item name: ");
                        tempItemName = ScanUserInput.next();
                        
                        System.out.print("\nEnter item price: ");
                        tempItemPrice = ScanUserInput.nextInt();
                        
                        System.out.print("\nEnter stock count: ");
                        tempItemStockCount = ScanUserInput.nextInt();
                        
                        System.out.println("\nYou are about to add " + tempItemStockCount + " " + tempItemName + " priced at " + tempItemPrice + " each.");
                        System.out.print("Proceed? [ Y/N ] ");
                        functionType = ScanUserInput.next();
                        switch (functionType) {
                            case "Y":
                            case "y":
                                itemNames[counter_y] = tempItemName;
                                menuPrices[counter_y] = tempItemPrice;
                                itemStockCount[counter_y] = tempItemStockCount;
                                itemCount += 1;
                                System.out.println("\nItem has been successfully added.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            case "N":
                            case "n":
                                System.out.println("\nOperation cancelled.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            default:
                                System.out.println("Invalid function. Input will be discarded.");
                                System.out.println("---------------------------------------------------------------------------------");
                                System.out.print("Press any key to reload Dashboard. You may have to enter the option you used again.");
                                restart = ScanUserInput.next();
                                resetRestart();
                                viewItems();
                                ScanUserInput.close();
                                
                        }
                        break;
                        
                    case "2":
                        counter_y = addOnCount;
                        System.out.print("\nEnter item name: ");
                        tempAddonName = ScanUserInput.next();
                        
                        System.out.print("\nEnter item price: ");
                        tempAddonPrice = ScanUserInput.nextInt();
                        
                        System.out.print("\nEnter stock count: ");
                        tempAddonStockCount = ScanUserInput.nextInt();
                        
                        System.out.println("\nYou are about to add " + tempAddonStockCount + " " + tempAddonName + " priced at " + tempAddonPrice + " each.");
                        System.out.print("Proceed? [ Y/N ] ");
                        functionType = ScanUserInput.next();
                        switch (functionType) {
                            case "Y":
                            case "y":
                                addonNames[counter_y] = tempAddonName;
                                addonPrices[counter_y] = tempAddonPrice;
                                addonStockCount[counter_y] = tempAddonStockCount;
                                addOnCount += 1;
                                System.out.println("\nItem has been successfully added.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            case "N":
                            case "n":
                                System.out.println("\nOperation cancelled.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            default:
                                System.out.println("Invalid function. Input will be discarded.");
                                System.out.println("---------------------------------------------------------------------------------");
                                System.out.print("Press any key to reload Dashboard. You may have to enter the option you used again.");
                                restart = ScanUserInput.next();
                                resetRestart();
                                viewItems();
                                ScanUserInput.close();
                                
                        }
                        break;
                        
                    case "3":
                        System.out.println("Operation cancelled.\n\n");
                        viewItems();
                        ScanUserInput.close();
                        break;
                        
                    default:
                        System.out.println("Invalid function selected. Input will be discarded.");
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Press any key to reload Dashboard.");
                        restart = ScanUserInput.next();
                        resetRestart();
                        viewItems();
                        ScanUserInput.close();
                }
                break;
                
            case "2":
                System.out.println("\nThis will remove items from your inventory.");
                System.out.println("---------------------------------------------------");
                System.out.println("[ 1 ] Main Item \n[ 2 ] Addon Item \n[ 3 ] Cancel\n");
                System.out.println("Select the item type you want to remove: ");
                functionType = ScanUserInput.next();
                switch (functionType) {
                    case "1":
                        System.out.print("\nSelect the item number you want to delete: ");
                        counter_y = ScanUserInput.nextInt();
                        System.out.println("You are about to remove all " + itemNames[counter_y-1] + " from the inventory.");
                        System.out.print("Proceed? [ Y/N ] ");
                        functionType = ScanUserInput.next();
                        switch (functionType) {
                            case "Y":
                            case "y":
                                itemNames[counter_y-1] = "ITEM REMOVED";
                                menuPrices[counter_y-1] = 0;
                                itemStockCount[counter_y-1] = 0;
                                System.out.println("\nItem is successfully removed.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            case "N":
                            case "n":
                                System.out.println("\nOperation cancelled.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            default:
                                System.out.println("Invalid function selected. Input will be discarded.");
                                System.out.println("---------------------------------------------------------------------------");
                                System.out.print("Press any key to reload Dashboard.");
                                restart = ScanUserInput.next();
                                resetRestart();
                                viewItems();
                                ScanUserInput.close();
                        }
                        
                        break;
                        
                    case "2":
                        System.out.print("\nSelect the item number you want to delete: ");
                        counter_y = ScanUserInput.nextInt();
                        System.out.println("You are about to remove all " + addonNames[counter_y-1] + " from the inventory.");
                        System.out.print("Proceed? [ Y/N ] ");
                        functionType = ScanUserInput.next();
                        switch (functionType) {
                            case "Y":
                            case "y":
                                addonNames[counter_y-1] = "ITEM REMOVED";
                                addonPrices[counter_y-1] = 0;
                                addonStockCount[counter_y-1] = 0;
                                System.out.println("\nItem is successfully removed.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            case "N":
                            case "n":
                                System.out.println("\nOperation cancelled.\n");
                                viewItems();
                                ScanUserInput.close();
                                break;
                                
                            default:
                                System.out.println("Invalid function selected. Input will be discarded.");
                                System.out.println("---------------------------------------------------------------------------");
                                System.out.print("Press any key to reload Dashboard.");
                                restart = ScanUserInput.next();
                                resetRestart();
                                viewItems();
                                ScanUserInput.close();
                        }
                        break;
                        
                    case "3":
                        System.out.println("\n\nOperation cancelled.\n");
                        viewItems();
                        break;
                        
                    default:
                        System.out.println("Invalid function selected. Input will be discarded.");
                        System.out.println("---------------------------------------------------------------------------");
                        System.out.print("Press any key to reload Dashboard.");
                        restart = ScanUserInput.next();
                        resetRestart();
                        viewItems();
                        ScanUserInput.close();
                }
                break;
                
            case "3":
                break;
                
            case "4":
                clearScreen();
                backEndStart();
                break;
                
            default:
                System.out.println("Invalid function. Input will be discarded.");
                System.out.println("---------------------------------------------------------------------------------");
                System.out.print("Press any key to reload Dashboard. You may have to enter the option you used again.");
                restart = ScanUserInput.next();
                resetRestart();
                viewItems();
                ScanUserInput.close();
        }
    }
    
    public static void main(String[] args) {
        Proximitea callOut = new Proximitea();
        
        // Set Items
        itemNames[0] = "Regular Taro Freeze";
        menuPrices[0] = 50;
        itemStockCount[0] = 20;
        
        itemNames[1] = "Green Milk Tea with Pearls";
        menuPrices[1] = 55;
        itemStockCount[1] = 20;
        
        itemNames[2] = "Strawberry Milk Tea with Lychee Jelly";
        menuPrices[2] = 70;
        itemStockCount[2] = 20;
        
        itemNames[3] = "Longan Black Tea";
        menuPrices[3] = 70;
        itemStockCount[3] = 20;
        
        itemNames[4] = "Lychee Green Tea";
        menuPrices[4] = 70;
        itemStockCount[4] = 20;
        
        // Set Addons
        addonNames[0] = "Taro";
        addonPrices[0] = 5;
        addonStockCount[0] = 20;
        
        addonNames[1] = "Tapioca Pearls";
        addonPrices[1] = 7;
        addonStockCount[1] = 20;
        
        addonNames[2] = "Lychee Jelly";
        addonPrices[2] = 7;
        addonStockCount[2] = 20;
        
        addonNames[3] = "Grass Jelly";
        addonPrices[3] = 5;
        addonStockCount[3] = 20;
        
        addonNames[4] = "Yellow Jelly";
        addonPrices[4] = 5;
        addonStockCount[4] = 20;
        
        // Begin Program
        callOut.startBusinessDay();
    }
    
}
