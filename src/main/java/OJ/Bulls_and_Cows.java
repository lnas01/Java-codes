package OJ;

/**
 * Created by Tongzhenguo on 2017/5/18.
 You are playing the following Bulls and Cows game with your friend:
   You write down a number and ask your friend to guess what the number is.
   Each time your friend makes a guess,
   you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows").
   Your friend will use successive guesses and hints to eventually derive the secret number.
 Bulls and Cows game游戏规则：
  猜数字游戏，每次猜测后，出题者都会给一个提示：
  其中存在数字并且猜对位置的叫做bulls,存在数字但是猜错位置的数字叫做cows,每次会提示bulls和cows的个数
  使用A代表bulls，B代表cows，设计算法输出这个提示
 For example:

 Secret number:  "1807"
 Friend's guess: "7810"
 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

 Please note that both secret number and friend's guess may contain duplicate digits, for example:

 Secret number:  "1123"
 Friend's guess: "0111"
 In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 *
 */
public class Bulls_and_Cows {
    /**
     * The idea is to iterate over the numbers in secret and in guess and count all bulls right away.
     * For cows maintain an array that stores count of the number appearances in secret and in guess.
     * Increment cows when either number from secret was already seen in guest or vice versa.
     */
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {//如果在secret和guess都出现过，那么就是有一个数字匹配了,时间问题下来好好理一下
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s] ++;
                numbers[g] --;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        new Bulls_and_Cows().getHint( "1807","7810" );

    }

}
