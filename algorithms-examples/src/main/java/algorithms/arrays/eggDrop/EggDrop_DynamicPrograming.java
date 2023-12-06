package algorithms.arrays.eggDrop;

// A Dynamic Programming based Java Program for the Egg Dropping Puzzle
//Time Complexity: O(n_eggs * k_floors^2)
//Auxiliary Space: O(n_eggs * k_floors)
class EggDrop_DynamicPrograming {

    /* Function to get minimum number of trials needed in worst
    case with n eggs and k floors */
    static int eggDrop(int n_eggs, int k_floors)
    {
		/* A 2D table where entry eggFloor[i][j] will represent minimum
			number of trials needed for i eggs and j floors. */
        int eggFloor[][] = new int[n_eggs + 1][k_floors + 1];
        int resultForFloorIndex;
        int egg_count, floor_id, tmp_floor_id;

        // We need one trial for one floor and 0 trials for 0 floors
        for (egg_count = 1; egg_count <= n_eggs; egg_count++) {
            eggFloor[egg_count][1] = 1;
            eggFloor[egg_count][0] = 0;
        }

        // We always need j trials for one egg and j floors.
        for (floor_id = 1; floor_id <= k_floors; floor_id++) {
            eggFloor[1][floor_id] = floor_id;
        }


        // Fill rest of the entries in table using optimal substructure property
        for (egg_count = 2; egg_count <= n_eggs; egg_count++) {

          //Iterating all floors
            for (floor_id = 2; floor_id <= k_floors; floor_id++) {
               //First - init to max
                eggFloor[egg_count][floor_id] = Integer.MAX_VALUE;

                //check for all floors till current floor
                for (tmp_floor_id = 1; tmp_floor_id <= floor_id; tmp_floor_id++) {
                    //in case egg broken - we have left with minus 1 egg - checking lower floor
                    int min_trails_lower_flower_minus_egg = eggFloor[egg_count - 1][tmp_floor_id - 1];

                    //in case egg was NOT  broken - we have left with all eggs - checking upper floor
                    //The floors we want to test aren't important;
                    //in fact, the number of remaining floors is what matters.
                    //For example, testing the floors between 1 and 20 (both 1 and 20 included)
                    //would require the same number of drops to test the floors between 21 and 40
                    //(after knowing that we can drop from floor 20 and the egg will not be broken)
                    //, or between 81 and 100. In all three situations, we tested 20 floors

                    //the range [tmp_floor_id -> floor_id]
                    //is like [(tmp_floor_id - tmp_floor_id) -> (floor_id - tmp_floor_id)]
                    // meaning the range [ 0 -> (floor_id - tmp_floor_id)]
                    int min_trails_upper_flower =  eggFloor[egg_count][floor_id - tmp_floor_id];

                    //Adding '1'  - for this trial
                    resultForFloorIndex = 1 + Math.max(min_trails_lower_flower_minus_egg, min_trails_upper_flower);

                    // droping from this floor got minimum trials
                    if (resultForFloorIndex < eggFloor[egg_count][floor_id])
                        //updating the matrix cell (for num of eggs and drops with result)
                        eggFloor[egg_count][floor_id] = resultForFloorIndex;
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[n_eggs][k_floors];
    }

    /* Driver program to test */
    public static void main(String args[])  {
        int n_eggs = 2, k_floors = 100;
        int miNumOfTrials = eggDrop(n_eggs, k_floors);
        System.out.println("Minimum number of trials in worst case with "
                + n_eggs+ " eggs and " + k_floors + " floors is " + miNumOfTrials);
    }
}
