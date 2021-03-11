import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order_Items {
    private static String filename = "order_items.csv";
    private static Map<String, Integer> countOrders = new HashMap<>();

    public static Map<String, Integer> getCountMap(List<String> IDs) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String str = new String();
            int indexFromOrderId = 0;
            int indexToOrderID = 0;
            int indexFromProductID = 0;
            int indexToItemID = 0;
            //int i = 0;
            while ((line = reader.readLine()) != null) {
                if(line.length()<30) //skip the first line, it will running only one time
                    continue;
                indexToOrderID = line.indexOf(',');
                indexFromProductID = indexToOrderID;
                indexToItemID = line.lastIndexOf(',');
                String orderID = new String(line.substring(0,indexToOrderID));
                String productID = new String(line.substring(indexFromProductID+1, indexToItemID));

                String countString = new String();
                countString=line.substring(indexToItemID+1);

                int count;
                try {
                    count = Integer.parseInt(countString);
                }catch (NumberFormatException e){
                    count = -1;
                }

                //initialization of map
                for(String i:IDs){
                    if(i.equals(orderID)){
                        if(countOrders.get(productID)==null) {
                            countOrders.put(productID, 0);
                            break;
                        }
                    }
                }

                // filling the map
                for(String i:IDs){
                    if(i.equals(orderID)){
                        countOrders.put(productID, countOrders.get(productID)+count);
                        //System.out.println(orderID+","+productID+","+count);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countOrders;
    }
}



