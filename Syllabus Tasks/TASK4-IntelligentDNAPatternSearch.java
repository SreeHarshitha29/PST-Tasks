import java.util.Scanner;
public class DNA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine(), p=sc.nextLine();

        for(int i=0;i<=s.length()-p.length();i++)
            if(s.substring(i,i+p.length()).equals(p))
                System.out.println(i+" ");
            
    }
}

##Input
  AABAACAADAABAABA
  AABA
##Output
  0 
  9 
  12 
