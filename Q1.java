/*
   Written by: Gerald Wogan
   Date:       15 Dec 2017
   Desc:       Current Assessment Practical 
*/

/* 
   
*/

import java.util.*;

public class Q1
{
   public static void main(String[] args)
   {
      //
      Scanner kb = new Scanner(System.in);
      
      double balance=0, withdrawal, deposit, loan;
      double overdraft=0; //initialized because it gets used in balance case
      int withdrawalCount=0, depositCount=0, choice, payback; 
      final double FIXED_INTEREST = .05;//every loan will have the exact same fixed interest rate
      
      //Display Menu (Only happens once)
      System.out.println("******Menu****** " ); 
      System.out.println("1. View Balance" );
      System.out.println("2. Make a Deposit " );
      System.out.println("3. Make a Withdrawal " );
      System.out.println("4. View number of transactions made" );
      System.out.println("5. Apply for an overdraft" );
      System.out.println("6. See how much a loan would cost you" );
      System.out.println("7. Exit" );   
      
      do
      {
         //This string will repeat every loop to prompt the user for another choice
         System.out.print("\nChoose an option: ");
         choice = kb.nextInt();
         
         switch(choice)
         {  
            case 1://Balance
               System.out.println("Your balance is: "+balance);
               System.out.println("Today you may withdraw up to "+(balance+overdraft));//shows overdraft allowance
               break;
            case 2://Deposit
               System.out.print("How much would you like to deposit? ");
               deposit = kb.nextDouble();
               if(deposit < 0)
                  System.out.println("ERROR - Must be a positive amount");
               else
               {
                  balance += deposit;
                  depositCount++;
               }
               break;
            case 3://Withdrawal 
               System.out.print("How much would you like to withdraw? ");
               withdrawal = kb.nextInt();
               if(withdrawal > (balance+overdraft))
                  System.out.println("Insufficient Funds - Today you may withdraw up to "+(balance+overdraft));
               else
               {
                  balance -= withdrawal;
                  withdrawalCount++;
               }
               break;
            case 4://Transactions Count  - adding a conditional operator for plurals
               System.out.println("You have made "+depositCount+(depositCount==1?" deposit":" deposits")+" and "+(withdrawalCount==1?" withdrawal":" withdrawals")+" withdrawal on your account");
               break;
            case 5://Overdraft
               System.out.print("How much of an overdraft would you like [Max = 1000]? ");//I like the sqaure brackets more than the curved brackets
               overdraft = kb.nextDouble();
               if(overdraft > 1000)
                  System.out.println("Sorry, the max overdraft is 1000");//error message if too much overdraft is requested
               else 
               {
                  System.out.println("An overdraft of "+overdraft+" has been applied to your account");
               }
               break;
            case 6://Loan
               System.out.print("Enter loan amount: ");
               loan = kb.nextDouble();
               System.out.print("Enter months to pay it back: ");
               payback = kb.nextInt();
               double interest = loan * FIXED_INTEREST;
               System.out.println("Total Interest: "+interest);
               displayLoanMenu(loan, payback, interest);
               break;
            case 7://Exit 
               System.out.print("You have chosen Exit. Have a nice day!");
               break;
            default://For incorrect values (<1 || >7)
               System.out.print("***ERROR - Incorrect choice - Please try again***");
               break;                     
         }//end switch
      }while(choice != 7);
   }//end main 
   //Display loan repayment
   public static void displayLoanMenu(double loanBalance, int monthsToPayback, double interest)
   {
      int monthsCounter = 1;
      
      double monthlyInterest = interest / monthsToPayback;//calculate the monthly interest -  for easier calculating the monthly payment
      double monthlyPayment = monthlyInterest + loanBalance/monthsToPayback;
      System.out.println("Loan Repayment Schedule:");
      System.out.println("Month \t  Payment \t Balance on Loan");
      
      //display table while calculating new loan amount each month
      for(int count = 1; count <= monthsToPayback; count++)
      {
         System.out.print((monthsCounter++)+"\t\t\t\t");//increment after variable means it will increment after it has been printed
         System.out.print(monthlyPayment+"\t\t\t\t");
         loanBalance = loanBalance - monthlyPayment;
         if(loanBalance <= 0 )
            System.out.print("Paid Off!");
         else
            System.out.print(-(loanBalance));
         System.out.println();
      }//end for
   
   }//end method
}//end class
