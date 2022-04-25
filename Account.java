/*
    PHASE TWO!!!
*/

package in.aiacullo.bankprojectp2;

import java.util.ArrayList;
import java.util.Random ;
import java.util.List;
import java.text.NumberFormat ;

public class Account {
    private final double RATE = 0.01 ; // intrest rate of 1%
    private String lastname, firstname, birthDate, accountNum, securityNum, 
        accountType, member, sexMF ;
    private double balance ;
    private static List<String> usedSSNnums = new ArrayList<>() ; /* list of 
        SSNs that have been used to prevent duplicates */
    private static List<String> usedAcctNums = new ArrayList<>() ; /* list of
        account numbers that have been used to prevent duplicates */
    private static List<Integer> temp = new ArrayList<>() ;
    private static List<String> lnames = new ArrayList<>() ;
    private static List<String> fnames = new ArrayList<>() ;
    private static int totalSavingAcc = 0, totalCheckingAcc = 0, 
        totalStudAcc = 0, totalEmployAcc = 0 ; // sum for diff acct types open
    private static String compResult ;

    // constructor when account opened WITH initial balance or depopsit
    public Account (String last, String first, String sex, String DOB, 
        String acctType, String person, double initial)
    {
        this.lastname = last ; lnames.add(lastname) ;
        this.firstname = first ; fnames.add(firstname) ;
        this.sexMF = sex ;
        this.birthDate = DOB ;
        this.securityNum = generateSSN() ;
        this.accountNum = generateAcctNum() ;
        this.accountType = acctType ; accountTracker(accountType) ;
        this.member = person ; memberTracker(member) ;
        this.balance = initial ;
    }
    
    // constructor when account opened WITHOUT initial balance or deposit
    public Account (String last, String first, String sex, String DOB, 
        String acctType, String person)
    {
        this.lastname = last ; lnames.add(lastname) ;
        this.firstname = first ; fnames.add(firstname) ;
        this.sexMF = sex ;
        this.birthDate = DOB ;
        this.securityNum = generateSSN() ;
        this.accountNum = generateAcctNum() ;
        this.accountType = acctType ; accountTracker(accountType) ;
        this.member = person ; memberTracker(member) ;
        this.balance = 0.00 ;
    }
    
    // random 9 digit SSN 
    private String generateSSN()
    {
        String nineDigits ; // generated SSN number
        String newestSSN ; // most recent SSN number
        
        // random 9 digit number created
        Random generator = new Random() ;
        int num1, num2, num3, num4, num5, num6, num7, num8, num9 ;
        num1 = generator.nextInt(10) ;
        num2 = generator.nextInt(10) ;
        num3 = generator.nextInt(10) ;
        num4 = generator.nextInt(10) ;
        num5 = generator.nextInt(10) ;
        num6 = generator.nextInt(10) ;
        num7 = generator.nextInt(10) ;
        num8 = generator.nextInt(10) ;
        num9 = generator.nextInt(10) ;
        
        // created 9 digit number stored in variable below 
        nineDigits = num1 + "" + num2 + "" + num3 + "" + num4 + "" + num5 + 
            "" + num6 + "" + num7 + "" + num8 + "" + num9 ;
        
        // check for duplicate SSN numbers
        if (usedSSNnums.contains(nineDigits) == false)
        {
            usedSSNnums.add(nineDigits) ;
        }
        while (usedSSNnums.contains(nineDigits) == true)
        {
            num1 = generator.nextInt(10) ;
            num2 = generator.nextInt(10) ;
            num3 = generator.nextInt(10) ;
            num4 = generator.nextInt(10) ;
            num5 = generator.nextInt(10) ;
            num6 = generator.nextInt(10) ;
            num7 = generator.nextInt(10) ;
            num8 = generator.nextInt(10) ;
            num9 = generator.nextInt(10) ;
                
            // created 9 digit number stored in variable below 
            nineDigits = num1 + "" + num2 + "" + num3 + "" + num4 + "" + 
                num5 + "" + num6 + "" + num7 + "" + num8 + "" + num9 ;
        }
        
        // newest SSN number retreived and given to newest account
        newestSSN = usedSSNnums.get(usedSSNnums.size()-1) ;
        
        return (newestSSN) ;
    }
    
    // random 5 digit Account Number
    private String generateAcctNum()
    {
        String fiveDigits ; // generated account number
        String newestAcct ; // most recent account number
        
        // random 5 digit number created
        Random generator = new Random() ;
        int num1, num2, num3, num4, num5 ;
        num1 = generator.nextInt(9) + 1 ;
        num2 = generator.nextInt(10) ;
        num3 = generator.nextInt(10) ;
        num4 = generator.nextInt(10) ;
        num5 = generator.nextInt(10) ;
        
        // created 5 digit number stored in variable below 
        fiveDigits = num1 + "" + num2 + "" + num3 + "" + num4 + "" + num5 ;
        
        // check for duplicate account numbers
        if (usedAcctNums.contains(fiveDigits) == false)
        {
            usedAcctNums.add(fiveDigits) ;
        }
        while (usedAcctNums.contains(fiveDigits) == true)
        {
            num1 = generator.nextInt(10) ;
            num2 = generator.nextInt(10) ;
            num3 = generator.nextInt(10) ;
            num4 = generator.nextInt(10) ;
            num5 = generator.nextInt(10) ;
            
            // created 5 digit number stored in variable below 
            fiveDigits = num1 + "" + num2 + "" + num3 + "" + num4 + "" + num5 ;
        }
        
        // newest account number retreived and given to newest account
        newestAcct = usedAcctNums.get(usedAcctNums.size()-1) ;
        
        return (newestAcct) ;
    }
    
    // account type tracker
    private void accountTracker(String accType)
    {
        if ("S".equals(accType))
        {
            totalSavingAcc = totalSavingAcc + 1 ;
        }
        if ("C".equals(accType))
        {
            totalCheckingAcc = totalCheckingAcc + 1 ;
        }
    }
    
    // student, staff, & faculty tracker
    private void memberTracker(String mem)
    {
        if ("1".equals(mem))
        {
            totalStudAcc = totalStudAcc + 1 ;
        }
        if ("2".equals(mem) || "3".equals(mem))
        {
            totalEmployAcc = totalEmployAcc + 1 ;
        }
    }
    
    // display accounts' info & only show last four of SSN
    public String toString()
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        
        char a = securityNum.charAt(5) ;
        char b = securityNum.charAt(6) ;
        char c = securityNum.charAt(7) ;
        char d = securityNum.charAt(8) ;
        
        String lastFour = a + "" + b + "" + c + "" + d ;

        return (lastname + "\t\t" + firstname + "\t\t" + sexMF + "\t" + 
            birthDate + "\t" + lastFour + "\t\t" + accountNum + "\t" + 
            accountType+ "\t" + member + "\t" + fmt1.format(balance)) ;
    }
    
    // deposit
    public double deposit(double amount)
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        
        if (amount > 0)
        {
            balance = balance + amount ;
            System.out.println("Deposit successful!") ;
            System.out.println(fmt1.format(amount) + " has been added.") ;
            System.out.println("Your current balance is now " + 
            fmt1.format(balance) );
            System.out.println() ;
        }
        
        if (amount <= 0)
        {
            System.out.println("Deposit unsuccessful...") ;
            System.out.println("Your current balance is still " + 
            fmt1.format(balance)) ;
            System.out.println() ;
        }
        
        return balance ;
    }
    
    // withdrawl
    public double withdrawl(double amount)
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        
        if (amount > 0 && amount > balance)
        {
            System.out.println("Withdrawl unsuccessful!") ;
            System.out.println("Sorry insufficient funds. The balance is "
                + fmt1.format(balance)) ;
            System.out.println() ;
        }
        
        if (amount > 0 && amount < balance)
        {
            balance = balance - amount ;
            System.out.println("Withdrawl successful!") ;
            System.out.println("The balance is now " + fmt1.format(balance)) ;
            System.out.println() ;
        }
        
        if (amount == balance)
        {
            balance = balance - amount ;
            System.out.println("Withdrawl successful!") ;
            System.out.println("The balance is now " + fmt1.format(balance)) ;
            System.out.println("Can not make another withdrawl.") ;
            System.out.println() ;
        }
        
        return balance ;
    }
    
    // interest
    public double interest()
    {
        double prevBal = balance ; // balance before interest added
        
        double totalInterest = balance * RATE ; // interest amount
        
        balance = balance + totalInterest ; // balance with interest
        
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        
        if (prevBal == 0)
        {
            System.out.println("No interest added...") ;
            System.out.println("Previous balance: " + fmt1.format(prevBal) ) ;
            System.out.println() ;
        }
        
        else
        {
            System.out.println("Interest added!") ;
            System.out.println("Total interest added: " + 
                fmt1.format(totalInterest)) ;
            System.out.println("Previous balance: " + fmt1.format(prevBal)) ;
            System.out.println("New balance: " + fmt1.format(balance)) ;
            System.out.println() ;
        }
        
        return balance ;
    }
    
    // interest for all
    public double interestALL()
    {
        double prevBal = balance ; // balance before interest added
        
        double totalInterest = balance * RATE ; // interest amount
        
        balance = balance + totalInterest ; // balance with interest
        
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        
        if (prevBal == 0)
        {
            System.out.printf("No interest added...") ;
            System.out.printf(" Previous balance: " + fmt1.format(prevBal) ) ;
            System.out.println() ;
        }
        
        else
        {
            System.out.printf("Total interest added: " + 
                fmt1.format(totalInterest)) ;
            System.out.printf(". Previous balance: " + fmt1.format(prevBal)) ;
            System.out.printf(". New balance: " + fmt1.format(balance)) ;
            System.out.println() ;
        }
        
        return balance ;
    }
    
    public void totalSavingAccts()
    {
        System.out.println("Total saving accounts (S): " + totalSavingAcc) ;
        System.out.println() ;
    }
    
    public void totalCheckingAccts()
    {
        System.out.println("Total checking accounts (C): " + totalCheckingAcc) ;
        System.out.println() ;
    }
    
    public String getAcctNum()
    {
        return accountNum ;
    }
    
    public String getAcctType()
    {
        return member ;
    }
    
    public String getSaveCheck()
    {
        return accountType ;
    }
    
    public List<Integer> getIT()
    {
        return temp ;
    }
    
    public List<String> getN()
    {
        return lnames ;
    }
    
    public double getBalance()
    {
        NumberFormat fmt1 = NumberFormat.getCurrencyInstance() ;
        System.out.println("Balance: " + fmt1.format(balance)) ;
        System.out.println() ;
        return balance ;
    }
    
    public double getBalanceOnly()
    {
        return balance ;
    }
    
    public String getLastName()
    {
        return lastname ;
    }
    
    public String getFirstName()
    {
        return firstname ;
    }
    
    public static void bubbleSort(List<String> usedAcctNums)
    {
        for (int i = 0 ; i < usedAcctNums.size() ; i++)
        {
            String aNum = usedAcctNums.get(i) ;
            int num = Integer.parseInt(aNum) ;
            temp.add(num) ;
        }
        
        int position, scan ;
        
        for (position = temp.size() - 1 ; position >= 0 ; position--)
        {
            for (scan = 0 ; scan <= position - 1 ; scan++)
            {
                if (temp.get(scan).compareTo(temp.get(scan + 1)) > 0)
                {
                    swap(temp, scan, scan + 1) ;
                }
            }
        }
    }
    
    private static <temp extends Comparable<temp>> 
        void swap(List<Integer> t, int i1, int i2)
    {
        Integer tem = t.get(i1) ;
        t.set(i1, t.get(i2)) ;
        t.set(i2, tem) ;
    }
        
    public void doBubbleSort()
    {
        bubbleSort(usedAcctNums) ; 
    }
    
    public void subSave()
    {
        totalSavingAcc = totalSavingAcc - 1 ;
    }
    
    public void subCheck()
    {
        totalCheckingAcc = totalCheckingAcc - 1 ;
    }
    
    public void addSave()
    {
        totalSavingAcc = totalSavingAcc + 1 ;
    }
    
    public void addCheck()
    {
        totalCheckingAcc = totalCheckingAcc + 1 ;
    }
    
    public int countStud_Employ()
    {
        int sum = totalStudAcc + totalEmployAcc ;
        return sum ;
    }
    
    public void subStudAcc()
    {
        totalStudAcc = totalStudAcc - 1 ;
    }
    
    public void subEmployAcc()
    {
        totalEmployAcc = totalEmployAcc - 1 ;
    }
    
    public void displayStud_Employ()
    {
        System.out.println("Total student accounts: " + totalStudAcc) ;
        System.out.println("Total employee accounts: " + totalEmployAcc) ;
        System.out.println() ;
    }
    
    public double fee(double five)
    { 
        if (five > 0 && five > balance)
        {
            balance = balance - five ;
        }
        
        if (five > 0 && five < balance)
        {
            balance = balance - five ;
        }
        
        if (five == balance)
        {
            balance = balance - five ;
        }
        
        return balance ;
    }
    
    public static void selectionSort(List<String> lnames)
    {
        time.begin() ;
        
        for (int i = 0 ; i < lnames.size() - 1 ; i++)
        {
            for (int j = i + 1 ; j < lnames.size() ; j++)
            {
                if (lnames.get(i).compareTo(lnames.get(j)) > 0)
                {
                    String tem = lnames.get(i) ;
                    lnames.set(i, lnames.get(j)) ;
                    lnames.set(j, tem) ;
                }
            }
        }
        
        time.end() ;
    }
    
    public void doselectSort()
    {
        selectionSort(lnames) ; 
    }
    
    public static void insertionSort(List<String> fnames)
    {
        time.begin() ;
        
        String[] temp = new String[fnames.size()] ;
        for (int i = 0 ; i < fnames.size() ; i++)
        {
            temp[i] = fnames.get(i) ;
        }
        
        for (int i = 1 ; i < temp.length ; i++)
        {
            String key = temp[i] ;
            int j = i - 1 ;
            
            while (j >= 0 && key.compareTo(temp[j]) < 0)
            {
                temp[j + 1] = temp[j] ;
                j-- ;
            }
            
            temp[j + 1] = key ;
        }
        
        for (int i = 0 ; i < temp.length ; i++)
        {
            fnames.set(i, temp[i]) ;
        }
        
        time.end() ;
    }
    
    public void doinsertSort()
    {
        insertionSort(fnames) ;
    }
    
    public List<String> getF()
    {
        return fnames ;
    }
    
    public static Comparable binarySearch(List<String> fnames, String n)
    {
        time.begin() ;
        
        Comparable result = null ;
        int first = 0 , last = fnames.size() - 1, mid ;
        
        while (result == null && first <= last)
        {
            mid = (first + last) / 2 ;
            if (fnames.get(mid).compareToIgnoreCase(n) == 0)
            {
                result = fnames.get(mid) ;
                compResult = fnames.get(mid) ;
            }
            else
            {
                if (fnames.get(mid).compareToIgnoreCase(n) > 0)
                {
                    last = mid - 1 ;
                }
                else
                {
                    first = mid + 1 ;
                }
            }
        }
        
        time.end() ;
        
        return result ;
    }
    
    public void doBinarySearch(String name)
    {
        String copy = name ;
        binarySearch(fnames, copy) ;
    }
    
    public String passResult()
    {
        return compResult ;
    }
    
    public String changeAccount(String a)
    {
        accountType = a ;
        return accountType ;
    }
    
}
