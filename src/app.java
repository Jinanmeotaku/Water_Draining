
public class app { 
    public static void main(String[] args) throws Exception { 
     soil soil = new soil("C:/Users/jalma/OneDrive/Desktop/Spring 2025/almaliky_jinan_project1/sample3.txt"); 
     if (soil.doesDrain()) { 
      System.out.println("Allows water to drain"); 
     } else { 
      System.out.println("Doesn't allow water to drain"); 
     } 
    } 
   }