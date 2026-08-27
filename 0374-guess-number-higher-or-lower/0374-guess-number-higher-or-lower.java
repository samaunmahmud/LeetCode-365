/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        
        while (low <= high) {
            // Avoid overflow for large values of n
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                // Picked number is lower, search left half
                high = mid - 1;
            } else {
                // Picked number is higher, search right half
                low = mid + 1;
            }
        }
        
        return -1;
    }
}