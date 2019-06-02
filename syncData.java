
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class syncData {
	static ArrayList<String[]> data=new ArrayList<String[]>();
    public static void main(String[] args) {

        String csvFile = "E:/New folder (2)/2005/input format.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] dataLine = line.split(cvsSplitBy);
                syncData.data.add(dataLine);
                

                System.out.println(dataLine);

            }
            System.out.println(data.get(0)[1]);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
