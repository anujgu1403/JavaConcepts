package testexecption;

interface Age 
{ 
    int x = 21; 
    void getAge(int x); 
} 
public class AnonymousDemo 
{ 
    public static void main(String[] args) { 
  
        // Myclass is hidden inner class of Age interface 
        // whose name is not written but an object to it  
        // is created. 
        Age oj1 = (int x)->System.out.print("Age is "+x); 
        oj1.getAge(21);
 
    } 
}