package leetcode;

/**
 * 找到最佳卖股票位置
 * 1.用一个数组表示买卖股票位置
 * 2.数组的value是股票价格
 * 3.前面的为买，后面的为卖，所以只能后面的减前面的为收益
 * 4.求最大收益
 */
public class BestTimeToBuyAndSellStock {
    public static int getProfit(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        int max = 0;
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > min) {
                max = Math.max(max, array[i] - min);
            } else {
                min = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int profit = getProfit(arr);
        System.out.println(profit);
    }

}