// the main class that runs the full program usign the path to the sample 

public class app { 
    public static void main(String[] args) throws Exception { 
        // replace the path with the path to your sample file here 
     soil soil = new soil("path_to_your_file.txt"); 
     if (soil.doesDrain()) { 
      System.out.println("Allows water to drain"); 
     } else { 
      System.out.println("Doesn't allow water to drain"); 
     } 
    } 
   }