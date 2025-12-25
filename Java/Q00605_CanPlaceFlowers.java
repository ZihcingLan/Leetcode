/*
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
 */

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        if (flowerbed.length == 1 && flowerbed[0] == 0){
            count = 1;
            if (n <= count){
                return true;
            } else {
                return false;
            }
        }

        if (flowerbed.length > 1){
            if ((flowerbed[0] + flowerbed[1]) == 0){
                flowerbed[0] = 1;
                count++;           
            }
            if ((flowerbed[flowerbed.length - 1] + flowerbed[flowerbed.length - 2]) == 0){
                flowerbed[flowerbed.length - 1] = 1;
                count++;           
            }
        }
        

        for (int i = 1; i < flowerbed.length - 1; i++){
            if ( flowerbed[i] + flowerbed[i-1] == 0 && flowerbed[i] + flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                count++;
            }
        }

        if (n <= count){
            return true;
        } else {
            return false;
        }
    }
}

/*Note:
須注意條件:
1. 自身為0且相鄰的為0，也須被視為可種植且相鄰的為0，也須被視為可種植。
[0,0,1,0,0] -> [0], [4]都符合
2. 序列長度為1
[0], n=1 -> true
因此需先判斷自身是否為0，並把它當作一個可以判斷左右是否為零的標準。

解答:
條件們可以簡化成下述，因為or檢查第一個條件達成後就不會檢查第二個，所以不會有overbound的問題。

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}
*/ 