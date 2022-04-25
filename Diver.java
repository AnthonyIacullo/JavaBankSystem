/*
    PHASE TWO!!!
*/

package in.aiacullo.bankprojectp2;

import java.util.List;
import java.util.Scanner ;

public class Diver {
    
    public static void main(String[] Args)
    {   
        // array of accounts to test driver & class
        AcctCollection accts = new AcctCollection() ;
        
        // 5 student(1) accts: 3 checking accounts (C) and 2 saving accounts (S)
        accts.addAccount1("Iacullo","Anthony","M","5/9/1997","C","1", 45.01) ;
        accts.addAccount2("Marker","Hannah","F","8/30/2002","C","1") ;
        accts.addAccount1("Healy","Sean","M","2/13/1999","C","1", 1575.88) ;
        accts.addAccount1("Smith","William","F","12/20/1990","S","1", 2000.99) ;
        accts.addAccount2("Moors","Shawn","M","10/23/2000","S","1") ;
        
        // 5 staff(2) accts: 3 checking accounts (C) and 2 saving accounts (S)
        accts.addAccount1("Rocha","Larry","M","2/16/1968","C","2",20.75) ;
        accts.addAccount2("Johnson","Sammy","F","4/16/1960","C","2") ;
        accts.addAccount1("Woods","Nicole","F","9/4/1988","C","2",7500.50) ;
        accts.addAccount2("Matthew","Kirsten","F","8/27/2000","S","2") ;
        accts.addAccount1("White","Ryan","M","7/28/1978","S","2",15050.75) ;
        
        // 5 faculty (3) accounts: 3 checking accounts and 2 saving accounts
        accts.addAccount1("Prasad","Rajesh","M","12/15/1983","C","3",7999) ;
        accts.addAccount1("Traynor","Carrol","F","1/3/1975","C","3",3000) ;
        accts.addAccount2("Glenn","Sarah","F","9/30/1960","C","3") ;
        accts.addAccount1("Mike","Mathias","M","11/13/1964","S","3",12000) ;
        accts.addAccount1("Brown","Carmen","F","6/20/1955","S","3",500) ;
        
        Scanner in = new Scanner(System.in);
        int user ; // user input for menu
        
        do 
        {
            menu() ;
            
            user = in.nextInt();
            System.out.println() ;
            
            switch (user) 
            {
                case 1: // display accounts
                    caseOne(accts) ;
                    break ;
                case 2: // total number of accounts with submenu
                    caseTwo(accts) ;
                    break ;
                case 3: // open account with initial deposit
                    caseThree(accts) ;
                    break ;
                case 4: // open account with no initial deposit
                    caseFour(accts) ;
                    break ;
                case 5: // add interest
                    caseFive(accts) ;
                    break ;
                case 6: // student accts under $100
                    caseSix(accts) ;
                    break ;
                case 7: // emplyee accts (faculty + staff) over $5000
                    caseSeven(accts) ;
                    break ;
                case 8: // linear search by last name
                    caseEight(accts) ;
                    break ;
                case 9 : // bubble sort savings account by account number
                    accts.openedAccts()[0].doBubbleSort() ;
                    caseNine(accts) ;
                    break ;
                case 10: // count of students and count of employee accounts
                    caseTen(accts) ;
                    break ;
                case 11: // display accounts with balance < $50 and fine $5 
                    caseEleven(accts) ;
                    break ;
                case 12: /*display the sorted list of all accounts by last name
                using selection sort and display the time it took to sort*/
                    accts.openedAccts()[0].doselectSort() ;
                    caseTwelve(accts) ;
                    break ;
                case 13: /*display the sorted list of all accounts by first 
                name using insertion sort and display time it took to sort*/
                    accts.openedAccts()[0].doinsertSort() ;
                    caseThirteen(accts) ;
                    break ;
                case 14: /* Binary search an account by first name, display 
                complete information about the account and print the time taken 
                to do the binary search. There is a submenu for that particular 
                account */
                    caseFourteen(accts) ;
                    break ;
                case 15: // Quit
                    System.exit(0) ;
                    break ;
                default:
                    System.out.println("Invalid Input.") ;
                    System.out.println() ;
                    break ;
            }
        } while (user != 15) ; 
    }
    
    private static void menu()
    {
        System.out.println("1. Display all accounts") ;
        System.out.println("2. Total number of accounts (with submenu)") ;
        System.out.println("3. Open an account with an initial deposit") ;
        System.out.println("4. Open an account with NO initial deposit") ;
        System.out.println("5. Add interest to all accounts") ;
        System.out.println("6. Display all student accounts with balance" +
            " less than $100") ;
        System.out.println("7. Display all employee accounts with balance" +
            " more than $5,000") ;
        System.out.println("8. Linear search an account by last name and" + 
            " display complete information") ;
        System.out.println("9. Display all saving accounts sorted by account" +
            " number using a bubble sort") ;
        System.out.println("10. Display count of students and count of" + 
                " employee accounts") ;
        System.out.println("11. Display any account with a balance less than" +
            " $50 and withdraw a $5 fee from that account") ;
        System.out.println("12. Display the sorted list of all accounts by" +
            " last name using selection sort and display the time it took to" +
            " sort") ;
        System.out.println("13. Display the sorted list of all accounts by" +
            " first name using insertion sort and display the time it took" +
            " to sort") ;
        System.out.println("14. Binary search an account by first name," +
            " display complete information about the account and print the" +
            " time taken\nto do the binary search. There is a submenu for that"+
            " particular account") ;
        System.out.println("15. Exit");
        System.out.println("Enter menu choice: ");     
    }
    
    // display accounts
    private static void caseOne(AcctCollection accts)
    {
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        for (int i = 0 ; i < accts.counter() ; i++) 
        {
            System.out.println(accts.openedAccts()[i]) ;
        }

        System.out.println() ;
    }
    
    // total number of accounts with submenu
    private static void caseTwo(AcctCollection accts)
    {
        Scanner in = new Scanner(System.in);
        int user ; // user input for submenu
        
        do
        {
            //submenu
            System.out.println("1. Total number of accounts") ;
            System.out.println("2. Number of Saving Accounts") ;
            System.out.println("3. Number of Checking Accounts") ;
            System.out.println("4. Back to Main Menu") ;
            System.out.println("Enter menu choice: ") ;
            
            user = in.nextInt();
            System.out.println() ;
        
            switch (user)
            {
                case 1: // total number of accounts
                    System.out.println("Total number of accounts: " + 
                        accts.counter()) ;
                    System.out.println() ;
                    break ;
                case 2: // total number of saving accounts
                    accts.openedAccts()[0].totalSavingAccts() ;
                    break ;
                case 3: // total number of checking accounts
                    accts.openedAccts()[0].totalCheckingAccts() ;
                    break ;
                case 4: // back to main menu
                    break ;
                default:
                    System.out.println("Invalid Input.") ;
                    System.out.println() ;
                    break ;
            } 
        } while (user != 4) ;
    }
    
    // open account with initial deposit
    private static void caseThree(AcctCollection accts)
    {
        // last name
        Scanner scan1 = new Scanner(System.in);
        String last ;
        System.out.println("Enter your last name: ") ;
        last = scan1.nextLine() ;
        System.out.println() ;
        
        // first name
        Scanner scan2 = new Scanner(System.in);
        String first ;
        System.out.println("Enter your first name: ") ;
        first = scan2.nextLine() ;
        System.out.println() ;
        
        // sex
        String sex = "" ;
        while ("M".equals(sex) == false && "F".equals(sex) == false)
        {
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Enter your sex (M or F): ") ;
            sex = scan3.nextLine() ;
            sex = sex.toUpperCase() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        // birth date
        Scanner scan4 = new Scanner(System.in) ;
        int month = 0 ;
        while (month < 1 || month > 12)
        {
            System.out.println("Enter the month you were born in (1-12): ") ;
            month = scan4.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        Scanner scan5 = new Scanner(System.in) ;
        int day = 0 ;
        while (day < 1 || day > 31)
        {
            System.out.println("Enter the day you were born on (1-31): ") ;
            day = scan5.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        Scanner scan6 = new Scanner(System.in) ;
        int year = 0 ;
        while (year < 1900 || year > 2020)
        {
            System.out.println("Enter the year you were born (1900-2020): ") ;
            year = scan6.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        String DofB = month + "/" + day + "/" + year ;
        
        // account type (checkings or savings)
        Scanner scan7 = new Scanner(System.in);
        String accTy = "" ;
        while ("S".equals(accTy) == false && "C".equals(accTy) == false)
        {
            System.out.println("Enter your prefered account type (S or C): ") ;
            System.out.println("S for Saving Account") ;
            System.out.println("C for Checking Account") ;
            accTy = scan7.nextLine() ;
            accTy = accTy.toUpperCase() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        // person 1 = student, 2 = staff, 3 = faculty
        Scanner scan8 = new Scanner(System.in) ;
        String pers = "" ;
        while ("1".equals(pers) == false && "2".equals(pers) == false
            && "3".equals(pers) == false)
        {
            System.out.println("Enter 1 if you're a student.") ;
            System.out.println("Enter 2 if you're a staff member.") ;
            System.out.println("Enter 3 if you're a faculty member.") ;
            System.out.println("Enter 1, 2, or 3: ") ;
            pers = scan8.nextLine() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        Scanner scan9 = new Scanner(System.in) ;
        double init = 0 ;
        while (init < 1 || init > 10000)
        {
            System.out.println("Enter an initial balance ($10,000 max): ") ;
            init = scan9.nextDouble() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        accts.addAccount1(last, first, sex, DofB, accTy, pers, init) ;
        
        System.out.println("Thank you for opening an account!") ;
        System.out.println("Below is your account info.") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        System.out.println(accts.openedAccts()[accts.counter() - 1]) ;
        System.out.println() ;
    }
    
    // open account with no initial deposit
    private static void caseFour(AcctCollection accts)
    {
        // last name
        Scanner scan1 = new Scanner(System.in);
        String last ;
        System.out.println("Enter your last name: ") ;
        last = scan1.nextLine() ;
        System.out.println() ;
        
        // first name
        Scanner scan2 = new Scanner(System.in);
        String first ;
        System.out.println("Enter your first name: ") ;
        first = scan2.nextLine() ;
        System.out.println() ;
        
        // sex
        String sex = "" ;
        while ("M".equals(sex) == false && "F".equals(sex) == false)
        {
            Scanner scan3 = new Scanner(System.in);
            System.out.println("Enter your sex (M or F): ") ;
            sex = scan3.nextLine() ;
            sex = sex.toUpperCase() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        // birth date
        Scanner scan4 = new Scanner(System.in) ;
        int month = 0 ;
        while (month < 1 || month > 12)
        {
            System.out.println("Enter the month you were born in (1-12): ") ;
            month = scan4.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        Scanner scan5 = new Scanner(System.in) ;
        int day = 0 ;
        while (day < 1 || day > 31)
        {
            System.out.println("Enter the day you were born on (1-31): ") ;
            day = scan5.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        Scanner scan6 = new Scanner(System.in) ;
        int year = 0 ;
        while (year < 1900 || year > 2020)
        {
            System.out.println("Enter the year you were born (1900-2020): ") ;
            year = scan6.nextInt() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        String DofB = month + "/" + day + "/" + year ;
        
        // account type (checkings or savings)
        Scanner scan7 = new Scanner(System.in);
        String accTy = "" ;
        while ("S".equals(accTy) == false && "C".equals(accTy) == false)
        {
            System.out.println("Enter your prefered account type (S or C): ") ;
            System.out.println("S for Saving Account") ;
            System.out.println("C for Checking Account") ;
            accTy = scan7.nextLine() ;
            accTy = accTy.toUpperCase();
            System.out.println() ;
        }
        //System.out.println() ;
        
        // person 1 = student, 2 = staff, 3 = faculty
        Scanner scan8 = new Scanner(System.in) ;
        String pers = "" ;
        while ("1".equals(pers) == false && "2".equals(pers) == false
            && "3".equals(pers) == false)
        {
            System.out.println("Enter 1 if you're a student.") ;
            System.out.println("Enter 2 if you're a staff member.") ;
            System.out.println("Enter 3 if you're a faculty member.") ;
            System.out.println("Enter 1, 2, or 3: ") ;
            pers = scan8.nextLine() ;
            System.out.println() ;
        }
        //System.out.println() ;
        
        accts.addAccount2(last, first, sex, DofB, accTy, pers);
        
        System.out.println("Thank you for opening an account!") ;
        System.out.println("Below is you account info.") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        System.out.println(accts.openedAccts()[accts.counter() - 1]) ;
        System.out.println() ;
    }
    
    // add interest
    private static void caseFive(AcctCollection accts)
    {
        System.out.println("Interest added!") ;
        System.out.println() ;
            
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            String num = accts.openedAccts()[i].getAcctNum() ;
            System.out.printf("Account #" + num + ": ") ;
            accts.openedAccts()[i].interestALL() ;
        }
        System.out.println() ;
    }  
    
    // students whose balance is less than $100
    private static void caseSix(AcctCollection accts)
    {
        System.out.println("Student accounts with a blance under $100:") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        for (int i = 0 ; i < accts.counter() ; i++) 
        {
            String type = accts.openedAccts()[i].getAcctType() ;
            double balance = accts.openedAccts()[i].getBalanceOnly() ;
            
            if ("1".equals(type) && (balance < 100.00) )
            {
                System.out.println(accts.openedAccts()[i]) ;
            }
        }
        
        System.out.println() ;
        System.out.println("Mail notice will be sent in 3-5 business days.") ;

        System.out.println() ;
    }
    
    // Employee accounts with a blance over $5,000
    private static void caseSeven(AcctCollection accts)
    {
        System.out.println("Employee accounts with a blance over $5,000:") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        for (int i = 0 ; i < accts.counter() ; i++) 
        {
            String type = accts.openedAccts()[i].getAcctType() ;
            double balance = accts.openedAccts()[i].getBalanceOnly() ;
            
            if (("2".equals(type) || ("3".equals(type))) && 
                (balance > 5000.00) )
            {
                System.out.println(accts.openedAccts()[i]) ;
            }
        }
        
        System.out.println() ;
        System.out.println("Promotional credit card offer will be sent in 3-5"+
            " business days.") ;

        System.out.println() ;
    }
    
    // linear search by last name
    private static void caseEight(AcctCollection accts)
    {
        int p = 0 ;
        boolean truth = false ;
        
        // last name
        Scanner scan1 = new Scanner(System.in);
        String last ;
        System.out.println("Enter your last name: ") ;
        last = scan1.nextLine() ;
        System.out.println() ;

        time.begin() ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            if (true == 
                accts.openedAccts()[i].getLastName().equalsIgnoreCase(last))
            {
                p = i ;
                truth = true ;
                break ;
            }
            if (false == 
                accts.openedAccts()[i].getLastName().equalsIgnoreCase(last))
            {
                truth = false ;
            }
        }
        
        time.end() ;
        
        if (truth == true)
        {
            System.out.println("Account found!") ;
            System.out.println() ;
        
            System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
                "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
               

            System.out.println(accts.openedAccts()[p]) ;
            System.out.println() ;
        }
        
        if (truth == false)
        {
            System.out.println("Account not found!") ;
            System.out.println() ;
        }
        
        Scanner in = new Scanner(System.in);
        int user = 0 ; // user input for submenu
        
        while (true == truth && user != 6)
        {
            do
            {
                //submenu
                System.out.println("1. Check balance") ;
                System.out.println("2. Withdraw money") ;
                System.out.println("3. Deposit money") ;
                System.out.println("4. Add interest") ;
                System.out.println("5. Close (delete) account") ;
                System.out.println("6. Back to main menu") ;
                System.out.println("Enter menu choice: ") ;

                user = in.nextInt();
                System.out.println() ;

                switch (user)
                {
                    case 1: // check balance
                        accts.openedAccts()[p].getBalance() ;
                        break ;
                    case 2: // withdrawl money
                        Scanner with = new Scanner(System.in) ;
                        double withVal ;
                        System.out.println("Enter withdrawl amount: $") ;
                        withVal = with.nextDouble() ;
                        System.out.println() ;
                        accts.openedAccts()[p].withdrawl(withVal) ;
                        break ;
                    case 3: // deposit money
                        Scanner dep = new Scanner(System.in) ;
                        double depVal ;
                        System.out.println("Enter deposit amount: $") ;
                        depVal = dep.nextDouble() ;
                        System.out.println() ;
                        accts.openedAccts()[p].deposit(depVal) ;
                        break ;
                    case 4: // add interest
                        accts.openedAccts()[p].interest() ;
                        break ;
                    case 5: // close (delete) account
                        accts.deleteAcct(p) ;
                        System.out.println("Account deleted!") ;
                        System.out.println() ;
                        
                        String type = accts.openedAccts()[p].getSaveCheck() ;
                        if ("S".equals(type))
                        {
                            accts.openedAccts()[p].subSave() ;
                        }
                        if ("C".equals(type))
                        {
                            accts.openedAccts()[p].subCheck() ;
                        }
                        
                        String mem = accts.openedAccts()[p].getAcctType() ;
                        if ("1".equals(mem))
                        {
                            accts.openedAccts()[p].subStudAcc() ;
                        }
                        if ("2".equals(mem) || "3".equals(mem))
                        {
                            accts.openedAccts()[p].subEmployAcc() ;
                        }
                        
                        user = 6 ;
                        break ;
                    case 6: // back to main menu
                        break ;
                    default:
                        System.out.println("Invalid Input.") ;
                        System.out.println() ;
                        break ;
                } 
            } while (user != 6) ;
        }
    }
    
    // bubble sort savings account by account number
    private static void caseNine(AcctCollection accts)
    {
        System.out.println("Saving accounts sorted by account number using"
            + " a bubble sort algorithm:") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        List<Integer> x = accts.openedAccts()[0].getIT() ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            int test = x.get(i) ;
            for (int j = 0 ; j < accts.counter() ; j++)
            {
                String savAcct = accts.openedAccts()[j].getSaveCheck() ;
                int num = Integer.parseInt(accts.openedAccts()[j].getAcctNum());
                if ("S".equals(savAcct) && (num == test))
                {
                    System.out.println(accts.openedAccts()[j]) ;
                }
            }
        }
        System.out.println() ;
    }
    
    // display count of students and count of employee accounts
    private static void caseTen(AcctCollection accts)
    {
        accts.openedAccts()[0].displayStud_Employ() ;
    }
    
    // display accounts with balance < $50 and fine $5
    private static void caseEleven(AcctCollection accts)
    {
        System.out.println("Accounts with a blance under $50:") ;
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        for (int i = 0 ; i < accts.counter() ; i++) 
        {
            double balance = accts.openedAccts()[i].getBalanceOnly() ;
            
            if (balance < 50.00)
            {
                System.out.println(accts.openedAccts()[i]) ;
            }
        }
        
        System.out.println() ;
        System.out.println("A $5 fine has been withdrawn from these" +
            " accounts:");
        System.out.println() ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            double balance = accts.openedAccts()[i].getBalanceOnly() ;
            
            if (balance < 50.00)
            {
                double withVal = 5 ;
                accts.openedAccts()[i].fee(withVal) ;
            }
        }
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        for (int i = 0 ; i < accts.counter() ; i++) 
        {
            double balance = accts.openedAccts()[i].getBalanceOnly() ;
            
            if (balance < 50.00)
            {
                System.out.println(accts.openedAccts()[i]) ;
            }
        }

        System.out.println() ;
    }

    /* display the sorted list of all accounts by last name using selection 
    sort and display the time it took to sort*/
    private static void caseTwelve(AcctCollection accts) 
    {
        System.out.println("Sorted list of all accounts by last name using" +
            " selection sort:");
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        List<String> x = accts.openedAccts()[0].getN() ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            String test = x.get(i) ;
            for (int j = 0 ; j < accts.counter() ; j++)
            {
                String name = accts.openedAccts()[j].getLastName() ;
                if (test.equals(name))
                {
                    System.out.println(accts.openedAccts()[j]) ;
                }
            }
        }
        System.out.println() ;
    }
    
    /* display the sorted list of all accounts by first name using insertion 
    sort and display the time it took to sort */
    private static void caseThirteen(AcctCollection accts)
    {
        System.out.println("Sorted list of all accounts by first name using" +
            " insertion sort:");
        System.out.println() ;
        
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
        
        List<String> x = accts.openedAccts()[0].getF() ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            String test = x.get(i) ;
            for (int j = 0 ; j < accts.counter() ; j++)
            {
                String name = accts.openedAccts()[j].getFirstName() ;
                if (test.equals(name))
                {
                    System.out.println(accts.openedAccts()[j]) ;
                }
            }
        }
        System.out.println() ;
    }
    
    /* Binary search an account by first name, display complete information 
    about the account and print the time taken to do the binary search. There 
    is a submenu for that particular account */
    private static void caseFourteen(AcctCollection accts)
    {
        // order list of first names (binary search needs ordered list)
        accts.openedAccts()[0].doinsertSort() ;
        
        // first name
        Scanner scan1 = new Scanner(System.in);
        String first ;
        System.out.println("Enter your first name: ") ;
        first = scan1.nextLine() ;
        System.out.println() ;
        accts.openedAccts()[0].doBinarySearch(first) ;
        
        String name = accts.openedAccts()[0].passResult() ;
        
        int p = 0 ;
        boolean truth = false ;
        
        for (int i = 0 ; i < accts.counter() ; i++)
        {
            if (true == 
                accts.openedAccts()[i].getFirstName().equalsIgnoreCase(name))
            {
                p = i ;
                truth = true ;
                break ;
            }
            if (false == 
                accts.openedAccts()[i].getFirstName().equalsIgnoreCase(name))
            {
                truth = false ;
            }
        }
        
        if (truth == true)
        {
            System.out.println("Account found!") ;
            System.out.println() ;
        
            System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
                "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
               

            System.out.println(accts.openedAccts()[p]) ;
            System.out.println() ;
        }
        
        if (truth == false)
        {
            System.out.println("Account not found!") ;
            System.out.println() ;
        }
        
        Scanner in = new Scanner(System.in);
        int user = 0 ; // user input for submenu
        
        while (true == truth && user != 6)
        {
            do
            {
                //submenu
                System.out.println("1. Check balance") ;
                System.out.println("2. Withdraw money") ;
                System.out.println("3. Deposit money") ;
                System.out.println("4. Change account type") ;
                System.out.println("5. Close (delete) account") ;
                System.out.println("6. Back to main menu") ;
                System.out.println("Enter menu choice: ") ;

                user = in.nextInt();
                System.out.println() ;
                
                switch (user)
                {
                    case 1: // check balance
                        accts.openedAccts()[p].getBalance() ;
                        break ;
                    case 2: // withdrawl money
                        Scanner with = new Scanner(System.in) ;
                        double withVal ;
                        System.out.println("Enter withdrawl amount: $") ;
                        withVal = with.nextDouble() ;
                        System.out.println() ;
                        accts.openedAccts()[p].withdrawl(withVal) ;
                        break ;
                    case 3: // deposit money
                        Scanner dep = new Scanner(System.in) ;
                        double depVal ;
                        System.out.println("Enter deposit amount: $") ;
                        depVal = dep.nextDouble() ;
                        System.out.println() ;
                        accts.openedAccts()[p].deposit(depVal) ;
                        break ;
                    case 4: // Change account type (S -> C or C -> S)
                        String type1 = accts.openedAccts()[p].getSaveCheck() ;
                        if ("S".equals(type1))
                        {
                            Scanner scan2 = new Scanner(System.in);
                            String changeS ;
                            System.out.println("Would you like to change your"+
                                " account from savings to checkings? (Y/N):") ;
                            changeS = scan2.nextLine() ;
                            if ("Y".equals(changeS) || "y".equals(changeS))
                            {
                                accts.openedAccts()[p].changeAccount("C") ;
                                accts.openedAccts()[p].subSave() ;
                                accts.openedAccts()[p].addCheck() ;
                                System.out.println() ;
                                System.out.println("Account type changed!") ;
                                System.out.println() ;
                                title() ;
                                System.out.println(accts.openedAccts()[p]) ;
                                System.out.println() ;
                            }
                            else
                            {
                                break ;
                            }
                        }
                        if ("C".equals(type1))
                        {
                            Scanner scan3 = new Scanner(System.in);
                            String changeC ;
                            System.out.println("Would you like to change your"+
                                " account from checkings to savings? (Y/N):") ;
                            changeC = scan3.nextLine() ;
                            if ("Y".equals(changeC) || "y".equals(changeC))
                            {
                                accts.openedAccts()[p].changeAccount("S") ;
                                accts.openedAccts()[p].subCheck() ;
                                accts.openedAccts()[p].addSave() ;
                                System.out.println() ;
                                System.out.println("Account type changed!") ;
                                System.out.println() ;
                                title() ;
                                System.out.println(accts.openedAccts()[p]) ;
                                System.out.println() ;
                            }
                            else
                            {
                                break ;
                            } 
                        }
                        break ;
                    case 5: // close (delete) account
                        accts.deleteAcct(p) ;
                        System.out.println("Account deleted!") ;
                        System.out.println() ;
                        
                        String type2 = accts.openedAccts()[p].getSaveCheck() ;
                        if ("S".equals(type2))
                        {
                            accts.openedAccts()[p].subSave() ;
                        }
                        if ("C".equals(type2))
                        {
                            accts.openedAccts()[p].subCheck() ;
                        }
                        
                        String mem = accts.openedAccts()[p].getAcctType() ;
                        if ("1".equals(mem))
                        {
                            accts.openedAccts()[p].subStudAcc() ;
                        }
                        if ("2".equals(mem) || "3".equals(mem))
                        {
                            accts.openedAccts()[p].subEmployAcc() ;
                        }   
                        user = 6 ;
                        break ;
                    case 6: // back to main menu
                        break ;
                    default:
                        System.out.println("Invalid Input.") ;
                        System.out.println() ;
                        break ;
                } 
            } while (user != 6) ;
        }
    }   
    
    public static void title()
    {
        System.out.println("lastname\t"+"firstname\t"+"sex\t"+"DOB\t\t"+
            "SSN(last 4)\t"+"Acct#\t"+ "Type\t"+ "Member\t"+"Balance") ;
    }
    
}
