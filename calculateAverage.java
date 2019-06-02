import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calculateAverage {
	static int dateToInt(String date) {

    	String [] vals = date.split("-");

    	int dif[] = {0, 1, -1, 0, 0, 1, 1, 2, 3, 3, 4, 4};

    	int d = Integer.parseInt(vals[0]);

    	int m = Integer.parseInt(vals[1]);

    	int y = Integer.parseInt(vals[2]);

    	return d+30*(m-1)+dif[m]+365*(y-2018);

    }

    

    static String averagePace(String startDate, String endDate, String filePath) {

    	File file = new File(filePath);

        int date0 = dateToInt(startDate);

    	int date = dateToInt(endDate);

        Scanner s;

        int numTerms = 0;

        int pace= 0;

        int prevDist = 0, prevTime = 0;

        double avg, convFact = 50/3;

        String result;

        try{

            s = new Scanner(file);



            while(s.hasNext()){

            	

                String line= s.next();

                String[] values = line.split(",");

                int curDate = dateToInt(values[3]);

                if(curDate >= date0 && curDate <= date) {

                	if (values[0] == "0" && values[1] == "0" && values[2] == "0" && prevDist != 0 && prevTime != 0) {

                		pace += prevTime/prevDist*convFact;

                		prevDist = Integer.parseInt(values[1]);

                		prevTime = Integer.parseInt(values[0]);

                    	numTerms++;

                	}

                }

            }

            if (numTerms == 0) {

            	numTerms = 1;

            }

            avg = pace/numTerms;

            result = String.valueOf(avg);

            s.close();

            return result;

        }catch (FileNotFoundException e) {

            e.printStackTrace();

            return "";

        }

    	

        

    }



    static String averageDistance(String startDate, String endDate, String filePath) {

    	File file = new File(filePath);

        int date0 = dateToInt(startDate);

    	int date = dateToInt(endDate);

        Scanner s;

        int numTerms = 0;

        int dist= 0;

        int prevDist = 0;

        double avg;

        String result;

        try{

            s = new Scanner(file);



            while(s.hasNext()){

            	

                String line= s.next();

                String[] values = line.split(",");

                int curDate = dateToInt(values[3]);

                if(curDate >= date0 && curDate <= date) {

                	if (values[0] == "0" && values[1] == "0" && values[2] == "0" && prevDist != 0) {

                		dist += prevDist;

                		prevDist = Integer.parseInt(values[1]);

                    	numTerms++;

                	}

                }

            }

            if (numTerms == 0) {

            	numTerms = 1;

            }

            avg = dist/numTerms;

            result = String.valueOf(avg);

            s.close();

            return result;

        }catch (FileNotFoundException e) {

            e.printStackTrace();

            return "";

        }

    	

     

    }

    



    static String avgAltitudeGained(String startDate, String endDate, String filePath) {

    	File file = new File(filePath);

        int date0 = dateToInt(startDate);

    	int date = dateToInt(endDate);

        Scanner s;

        int numTerms = 0;

        double avg;

        String result;

        double maxAlt = 0;

        double altTot = 0;

        double curAlt;

        try{

            s = new Scanner(file);



            while(s.hasNext()){

            	

                String line= s.next();

                String[] values = line.split(",");

                int curDate = dateToInt(values[3]);

                if(curDate >= date0 && curDate <= date) {

                	curAlt = Integer.parseInt(values[2]);

                	if (curAlt > maxAlt){

                		maxAlt = curAlt;

                	}

                	if (values[0] == "0" && values[1] == "0" && values[2] == "0"){

                		altTot += maxAlt;

                		maxAlt = 0;

                		numTerms++;

                	}

                }

            }

            avg = altTot/numTerms;

            

            result = String.valueOf(avg);

            

            s.close();

            return result;

        }catch (FileNotFoundException e) {

            e.printStackTrace();

            return "";

        }

    	

        

    }

    

    static String avgAltitudeLost(String startDate, String endDate, String filePath) {

    	File file = new File(filePath);

        int date0 = dateToInt(startDate);

    	int date = dateToInt(endDate);

        Scanner s;

        int numTerms = 0;

        double avg;

        String result;

        double minAlt = 0;

        double altTot = 0;

        double curAlt;

        try{

            s = new Scanner(file);



            while(s.hasNext()){

            	

                String line= s.next();

                String[] values = line.split(",");

                int curDate = dateToInt(values[3]);

                if(curDate >= date0 && curDate <= date) {

                	curAlt = Integer.parseInt(values[2]);

                	if (curAlt < minAlt){

                		minAlt = curAlt;

                	}

                	if (values[0] == "0" && values[1] == "0" && values[2] == "0"){

                		altTot += minAlt;

                		minAlt = 0;

                		numTerms++;

                	}

                }

            }

            avg = altTot/numTerms;

            

            result = String.valueOf(avg);

            

            s.close();

            return result;

        }catch (FileNotFoundException e) {

            e.printStackTrace();

            return "";

        }

    	

    }


}
