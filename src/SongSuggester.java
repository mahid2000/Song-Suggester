import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class SongSuggester{
    public static boolean askYesNo(String question){
        System.out.println(question + "[y/n]");
        String response = scan.nextLine();

        if (response.equals("y")){
            return true;

        } else {
            return false;
        }
    }


     public static String treeString(TreeNode root){
        StringBuffer toLine = new StringBuffer();
        toLine(toLine,root); 
        return toLine.toString();
    }
    

    private static void toLine(StringBuffer toLine, TreeNode n){
        if (n==null) {
            return;
        }
        toLine.append(n.v); 
        toLine.append("(");       
        toLine(toLine,n.left);
        toLine.append(",");
        toLine(toLine,n.right);
        toLine.append(")");
    }
    

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[]args){
        TreeNode root = new TreeNode("Do you like classical song?",
                                new TreeNode("\"Are you a fan of Mozart? \"",
                                    new TreeNode("Eine Kleinen Nachtmusik"),
                                    new TreeNode("\"3 Romances\" by Clara Schumann")
                                ),
                                new TreeNode("\"Take Five\" by Dave Brubeck")
                                        


                            );
        TreeNode song = root;
        System.out.println("Welcome! Let's help you find a song");
        
        boolean gameRun = true;
        while (gameRun){
            if(askYesNo(song.v)){
                song = song.getLeft();
            
            } else {
                song = song.getRight();
            }
            if (song.isLeaf()){
                System.out.println(song.v);
                if (askYesNo("Is this satisfactory?")){
                    if (askYesNo("Do you want to play again?")){
                    song = root;

                } else {
                    gameRun = false;
            
                }
                } else {
                    System.out.println("What would you prefer instead?");
                    String suggestion = scan.nextLine();
                    System.out.println("Tell me a question that distinguishes "+
                                        song.v + " from " + suggestion);
                    String prev_Q = song.v;
                    String new_Q = scan.nextLine();
                    boolean restart = askYesNo("Do you want to play again?");
                    if (restart == true){
                        song.v = new_Q;
                        song.left = new TreeNode(suggestion);
                        song.right = new TreeNode(prev_Q);
                        song = root;
                    }
                    else {
                        if (askYesNo("Would you like to save?") == true); {
                            try {
                                FileWriter file = new FileWriter("suggestions.txt", true);
                                BufferedWriter output = new BufferedWriter(file);  
                                String toLine = treeString(root);
                                output.write(toLine);
                                output.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
    

}       
        
       

