import java.util.*;
import java.util.stream.*;

public class Stream{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String,List<Double>> m = new HashMap<>();

        for(int i=0;i<n;i++) {
            String id=sc.next();
            double t=sc.nextDouble();
            if(t>50)
                m.computeIfAbsent(id,k->new ArrayList<>()).add(t);
        }

        m.entrySet().stream()
         .map(e -> new AbstractMap.SimpleEntry<>(
             e.getKey(),
             e.getValue().stream().mapToDouble(x->x).average().getAsDouble()))
         .sorted((a,b)->Double.compare(b.getValue(),a.getValue()))
         .forEach(e->System.out.println(e.getKey()+" "+e.getValue()));
    
   ## Input
        6
    s1 60
    s2 40
    s3 70
    s1 80
    s2 90
    s3 30
  ## Output
  s2 90.0
  s3 70.0
  s1 70.0
