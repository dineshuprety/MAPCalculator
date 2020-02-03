import java.util.Scanner;
import java.text.DecimalFormat;
 class Assignment1{
    public static void main(String[] args){

        // create Scanner object
        Scanner sc = new Scanner(System.in);

            // To change the decimal into string
            DecimalFormat dotFormat;
            dotFormat = new DecimalFormat("####.#");


System.out.println("Enter the 5-10 person size: ");
int n=sc.nextInt();
// If number of person is grater than 10 it show the error and exit the program
if(n<=4||n>=11){
    System.out.println("\n");
    System.out.println("Error!!! Run Again!!");
    System.out.println("***********Bye********");
    return;

}
// variables
double low = Double.MAX_VALUE; double high = Double.MIN_VALUE; double sum=0;
            // while loop to insert the data of sbp & dbp 
            int i=0;
            while(i<n){ 
            System.out.println("Enter the identifier of a person: ");
            int identifier=sc.nextInt();
            System.out.println("\n");


     System.out.println("Enter the Value of SBP(systolic blood pressure) " +(i+1)+" in mm HG ");
        double sbp=sc.nextInt();
        System.out.println("\n");


         System.out.println("Enter the Value of DBP(diastolic blood pressure)" +(i+1)+" in mm HG ");
         double dbp=sc.nextInt();
         System.out.println("\n");
        // if sbp is < than dbp it exit the program 
         if(sbp<dbp){
            System.out.println("***************************************************************************");
             System.out.print("\n");
             System.out.println("Error !!!!!! Check the sbp or dbp value.");
             System.out.print("\n");
             System.out.println("Bye!!!");
             System.out.println("***************************************************************************");
             return;
        }
         i++;
         // Out put
          // Create an object of class MAPCalculator (This will call the constructor)
        MAPCalculator obj = new MAPCalculator();
        double map = obj.value(sbp,dbp);
        System.out.println("The MAP(mean arterial pressure) is::->>"+ dotFormat.format(map)+"mm HG");
        // Print the value of high, low & normal
        System.out.println(obj.category(map));
        System.out.println("\n");
        System.out.println("***************************************************************************");

// check the high, low & average of total value
    if (i == 0) {
        low = map;
        high=map;
    } else {
        if(map > high) {
            high= map;        
        }
        if(map < low){
            low = map;

        }
            

    }

    sum+= map;
} 
double ave =sum/n;
                // out put
                 System.out.print("\n");
                 System.out.print("\n");
                 
                 System.out.println("****************************Report***************************");
                 System.out.print("\n");

                System.out.println("The High MAP is: "+ dotFormat.format(high)+ "mm HG");
                System.out.println("The Average of total MAP is: "+ dotFormat.format(ave)+ "mm HG");
                System.out.println("The Low MAP is: "+ dotFormat.format(low)+ "mm HG");


}
}// end Assignment1

class MAPCalculator{

    public MAPCalculator(){
        //code not need
    }
     // Create a value constructor of MAPCalculator
    public double value(double sbp, double dbp){
        return (sbp+2*dbp)/3;
    }
    // Create a category constructor of MAPCalculator
    public String category(double map){
        String High="Your MAP is considered High";
       String Low="Your MAP is considered LOW";
       String Normal="Your MAP is considered Normal";
        if (map<=70.0){
        return Low;

    }
            
        else if (map >=70.0&&map <100.0){
            return Normal;
        }
    
        else {
            return High;
        }
    }
}// end of MAPCalculator
