import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static String filename = "orders.csv";
    private static List<String> IDs = new ArrayList<>();

    public static List<String> getOrdersIDs(String dateAnalysis){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            IDs.contains(100);
            String line;
            int indexFor = 0;
            int indexTo = 0;
            String date;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                indexFor = line.indexOf(',');
                indexTo = line.indexOf('T');
                date = line.substring(indexFor + 1, indexTo);
                if (date.equals(dateAnalysis)) {
                    IDs.add(line.substring(0, indexFor));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return IDs;
    }
}
