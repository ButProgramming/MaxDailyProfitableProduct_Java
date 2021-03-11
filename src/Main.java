import java.util.*;

public class Main {
    private static int max = 0;
    private static String maxName;

    static void mostProfitable(Map<String, Integer> costsMap){
        for(Map.Entry<String, Integer> entry: costsMap.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
            }
        }
        for(Map.Entry<String, Integer> entry: costsMap.entrySet()){
            if(max==entry.getValue()){
                System.out.println("Name of product: "+entry.getKey()+", total profit: "+entry.getValue());
            }
        }
    }

    public static void main(String[] args) {

        List<String> l = Orders.getOrdersIDs("2021-01-21");
        //System.out.println(l);
        Map<String,Integer> m = Order_Items.getCountMap(l);
        //System.out.println(m);
        Map<String, Integer> m2 = Products.getCosts(m);
        //System.out.println(m2);
        Main.mostProfitable(m2);
    }
}
