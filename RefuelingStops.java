import java.util.ArrayList;
import java.util.Collections;

//Link : https://leetcode.com/problems/minimum-number-of-refueling-stops/
/**
 * RefuelingStops
 */
public class RefuelingStops {
    public static void main(String[] args) {
        InnerRefuelingStops irs = new InnerRefuelingStops();
        int[][] stations = {
                { 10, 60 },
                { 20, 30 },
                { 30, 30 },
                { 60, 40 },
        };
        System.out.println(irs.minRefuelStops(100, 10, stations));
    }
}

/**
 * InnerRefuelingStops
 */
class InnerRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        if (startFuel < stations[0][0]) {
            System.out.println("StartFuel" + startFuel + " Next Stations Distance "+ stations[0][0]);
            return -1;
        }
        // we will find the stop with the max fuel if it is reachable by our car.
        // first check the first station if it is reachable
        ArrayList<Integer> fuels = new ArrayList<Integer>();
        int row = 0, ans = 0;

        while (startFuel >= stations[row][0]) {
            fuels.add(stations[row][1]);
            System.out.println(fuels);
            row++;
        }
        Collections.sort(fuels, Collections.reverseOrder());
        int highestFuel = fuels.get(0);
        System.out.println("Highest Fuel + "+ highestFuel);

        System.out.println(target + " -= " + stations[row-1][0]);
        target -= stations[row-1][0];
        

        if(highestFuel >= target){
            return row;
        }

        System.out.println(startFuel + " -= " + stations[row-1][1] + " + " + stations[row-1][0]);
        startFuel -= stations[row-1][1] + stations[row-1][0];
        startFuel *= -1;
        int[][] newStations = new int[stations.length][2];
        
        for (int i = row, index = 0; i < stations.length; i++, index++) {
            for (int j = 0, rowIndex = 0; j < 2; j++, rowIndex++) {
                newStations[index][rowIndex] = stations[i][j];
            }
        }

        ans += minRefuelStops(target, startFuel, stations); 
    
        return ans;
    }
}