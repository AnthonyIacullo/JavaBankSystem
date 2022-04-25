package in.aiacullo.bankprojectp2;

import java.lang.*;

public class time 
{
        private static long passTime ;
        
        public static void begin()
        {
            // returns the current value of the system timer, in nanoseconds
            System.out.print("Time in nanoseconds: " + System.nanoTime()) ;
    
            long startTime = System.nanoTime();
   
            System.out.println("\nStart Time: " + startTime + " nano secs") ;	
   
            for (int i=0;i<1000;i++)
            {
                for (int j=0;j<1000;j++)
                {
                    // System.out.println("Hello Class");
                }	
            }
            passTime = startTime ;
        }
         
        public static void end()
        {
            long endTime = System.nanoTime();
            System.out.println("End  Time: " + endTime + " nano secs");	
            
            
            long taskTime = endTime - passTime ;
	
            System.out.println("Time taken for the task is " + taskTime +
                " nano secs") ;
            System.out.println() ;
        }	
}
