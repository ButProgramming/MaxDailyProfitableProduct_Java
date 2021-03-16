import java.util.*;

public class Main {
    static void mostProfitable() {
        String dateBase = "2021-01-";
        for(int i=1; i<=31; i++){
            String date = dateBase+i/10+i%10;
            System.out.println("Date: "+date);
            mostProfitable(date);
        }
    }

    static void mostProfitable(String date){
        int max=0;
        List<String> listOrdersIDs = Orders.getOrdersIDs(date);
        Map<String, Integer> countMap = Order_Items.getCountMap(listOrdersIDs);
        Map<String, Integer> costsMap = Products.getCosts(countMap);
        for(Map.Entry<String, Integer> entry: costsMap.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
            }
        }
        for(Map.Entry<String, Integer> entry: costsMap.entrySet()){
            if(max==entry.getValue()){
                System.out.println("Name of most profitable product: "+entry.getKey()+", total profit: "+entry.getValue());
            }
        }


    }

    public static void main(String[] args) {
        //Main.mostProfitable("2021-01-31");
        Main.mostProfitable();
    }
}
