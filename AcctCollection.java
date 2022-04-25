package in.aiacullo.bankprojectp2;

public class AcctCollection {
    
    private Account[] collection ;
    private int count ;
    
    public AcctCollection()
    {
        collection = new Account[15] ;
        count = 0 ;
    }
    
    // add account WITH initial deposit to collection 
    public void addAccount1(String last, String first, String sex, String DOB, 
        String acctType, String person, double initial)
    {
        if (count == collection.length)
            increaseSize() ;
        
        collection[count] = new Account(last, first, sex, DOB, acctType, person,
            initial) ;
        
        count++ ;
    }
    
    // add account with NO initial deposit to collection 
    public void addAccount2(String last, String first, String sex, String DOB, 
        String acctType, String person)
    {
        if (count == collection.length)
            increaseSize() ;
        
        collection[count] = new Account(last, first, sex, DOB, acctType,person);
        
        count++ ;
    }
    
    // increase collection
    private void increaseSize()
    {
        Account[] temp = new Account[collection.length * 2] ;
        
        for (int acct = 0 ; acct < collection.length ; acct++)
            temp[acct] = collection[acct] ;
        
        collection = temp ;
    }
    
    public Account[] openedAccts()
    {
        return collection ;
    }
    
    public int counter()
    {  
        return count ;
    }
    
    public void deleteAcct(int index)
    {
        for (int i = index ; i < collection.length - 1 ; i++)
        {
            collection[i] = collection[i + 1] ;
        }
        count-- ;
    }
    
}
