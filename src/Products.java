import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Products {
    private static Map<String, Integer> costsMap = new HashMap<>();
    private static String filename = "products.csv";

    public static Map<String, Integer> getCosts(Map<String, Integer> countOrders) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            String nameOfProduct;
            String priceString;
            int indexBeginProductID = 0;
            int indexEndProductID;
            int indexBeginNameOfProduct;
            int indexEndNameOfProduct;
            int indexBeginPrice;
            int price = 0;

            while ((line = reader.readLine()) != null) {
                if(line.length()<30)
                    continue;
                indexEndProductID = line.indexOf(',');
                String productID = line.substring(indexBeginProductID, indexEndProductID);

                //System.out.println(productID);
                indexBeginNameOfProduct = indexEndProductID+1;
                indexEndNameOfProduct = line.lastIndexOf(',');
                nameOfProduct = line.substring(indexBeginNameOfProduct, indexEndNameOfProduct);
                //System.out.println(nameOfProduct);
                indexBeginPrice=indexEndNameOfProduct+1;
                priceString = line.substring(indexBeginPrice);
                //System.out.println(priceString);
                price = Integer.parseInt(priceString);
                //System.out.println(price);
                for(Map.Entry<String, Integer> entry:countOrders.entrySet()){
                    if(productID.equals(entry.getKey())){
                        if(costsMap.get(nameOfProduct)==null){
                            costsMap.put(nameOfProduct, countOrders.get(entry.getKey())*price);
                        }
                        else{
                            costsMap.put(nameOfProduct, costsMap.get(nameOfProduct)+countOrders.get(entry.getKey())*price);
                        }
                    }
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //System.out.println(countOrders);
        return costsMap;
    }
}
