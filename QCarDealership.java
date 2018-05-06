/*
   Written by: Gerald Wogan
   Date: 26 Oct 2017
   Desc: Test question
   Group: Maeve Carr
*/
/*

   GET employeeType
   GET salary
   
   DECLARE monthly payment
   
   IF empType == mechanic
   
      CALC no bonus
      
      IF yearsServ >=2
         CALC monPay + 750
         
   ELSE IF sales staff
   
      GET years of service
      GET cars sold
      GET vans sold
   
      //CALC bonus
      
      IF yearsServ >=2
         CALC monPay + 750
      ELSE 
         OUTPUT no loyalty bonus
            
      IF carsSold = 1 
         CALC 5% bonus of salary
      ELSE IF carsSold >=2 && <=4
         CALC 7% bonus of salary
      ELSE If carsSold >=5
         CALC 10% bonus of salary
      ELSE 
         no bonus
      
      IF vansSold >=0 && <=5
         CALC bonus of 1000
      ELSE IF vansSold >5
         CALC bonus of 1200
      
   ELSE
      PRINT invalid employee type
      
      if( )
         {
         }
         else
         {
         }

         
*/

import java.util.Scanner;

public class QCarDealership
{
   public static void main(String[] args)
   {      
      Scanner keyboardIn = new Scanner(System.in);
       
      //declare variables
      char empType;
      double salary, monPay, carBon=1, vanBon=1, bonus;
      int carsSold, vansSold, loyal, yearsServ;
      
       
      //prompt for user input 
      System.out.print("Please enter your employee type(S for sales, M for mechanic): ");
      empType = keyboardIn.next().charAt(0);
      System.out.print("Please enter your annual salary: ");
      salary= keyboardIn.nextDouble();
      System.out.println("");
     
      //If check for sales employee or mechanic employee and years of service no bonus check 
      if( (empType == 'm' || empType == 'M') )
      {   
         //mechanic output     
         System.out.println("Monthly Pay Details:");
         System.out.println("Annual Salary: "+salary);
         System.out.println("Monthly Salary: "+(salary/12));
      }
      else if( empType == 's' || empType == 'S' )
      {  
         //further info needed for sales staff
         System.out.print("How many years have you worked here? ");
         yearsServ = keyboardIn.nextInt();
         System.out.print("How many cars did you sell this month? ");
         carsSold = keyboardIn.nextInt();
         System.out.print("How many vans did you sell this month? ");
         vansSold = keyboardIn.nextInt();
         System.out.println("");
         
         //no bonus for less than 2 years  loyalty
         if( yearsServ < 2 )
         {
            bonus = 0;
         }
         else if (yearsServ > 5)
            {
               bonus = 750;
            
               // car sales bonus
               if(carsSold == 1 )
               {  
                  carBon = salary*.05;
                  bonus = bonus + carBon;
               }
               else if(carsSold >=2 && carsSold <= 4)
               {
                  carBon = salary*.07;
                  bonus = bonus + carBon;
               }
               else if(carsSold >=5)
               {
                  carBon = salary*.1;
                  bonus = bonus + carBon;
               }


               if(vansSold > 5 )
               {  
                  vanBon = 1200;
                  bonus = bonus + vanBon;
               }
               else if(vansSold >=2 && vansSold <= 4)
               {
                  vanBon = 100;
                  bonus = bonus + vanBon;
               }

            }
            
         
                  
         //output for monthly pay
         System.out.println("Monthly Pay details:");
         System.out.println("Annual Salary: "+salary);
         System.out.println("Monthly Salary:  "+(salary/12));
         System.out.println("Car sales bonus: "+carBon);
         System.out.println("Van sales bonus: "+vanBon);
         System.out.println("Long service bonus: "+(yearsServ));
         System.out.println("Total bonus: " +(yearsServ + carBon + vanBon));
         System.out.println("Total payment for this month: " +(salary +(yearsServ + carBon + vanBon)));
         System.out.println("This month you sold " +carsSold+ (carsSold>1?" cars":" car")+ " and " +vansSold+ (vansSold>1?" vans":" van"));
         
        
     }   
   }//end main
}//end class
