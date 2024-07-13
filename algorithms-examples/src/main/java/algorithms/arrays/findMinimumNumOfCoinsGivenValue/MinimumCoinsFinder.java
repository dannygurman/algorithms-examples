package algorithms.arrays.findMinimumNumOfCoinsGivenValue;

public interface MinimumCoinsFinder {

    Integer CHANGE_NOT_POSSIBLE_MARK = -1;

    int findMinimumCoins(int coins[], int value);

}
