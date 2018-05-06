//Gerald Wogan
//Printf examples

import java.util.*;
public class printf
{
   public static void main(String[] args)
   {
      int i = 99;
      double d = 99.99;
      char c = '#';
      String  s = "School";
      
      System.out.printf("int %d float %07.3f char %c String %s" ,i,d,c,s);
   }//end main
   
   public static int displayGenerator();
   {
   
      int num = Math.random(10);
      System.out.print(num);
   
   }
}//end class