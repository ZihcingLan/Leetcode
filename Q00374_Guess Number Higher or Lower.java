/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
 

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
*/

/*
時間複雜度: O(n) ->最差所有值都要找一遍，最好找O(logN)遍(二分法)
空間複雜度: O(1) -> 常數空間
*/

//ver1

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
        int left = 0;
        int right = n;
        int mid = 0;
        boolean isResult = false;
        int result = 0;
        while(!isResult){
            mid = left + (right - left) / 2; //避免溢位
            result = guess(mid);
            if (result == -1){
                right = mid - 1;
            } else if (result == 1){
                left = mid + 1;
            } else {
                isResult = true;
            }
        }
        return mid;
    }
}

//ver2:更加簡潔版本
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while(left <= right){
            int mid = left + (right - left) / 2; //避免溢位
            int result = guess(mid);
            if (result == 0){
                return mid;
            } else if (result == -1){
                right = mid - 1;
            } else if (result == 1){
                left = mid + 1;
            } 
        }
        return -1;
    }
}