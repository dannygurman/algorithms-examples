package algorithms.strings;

//Find the n’th term in Look-and-say (Or Count and Say) Sequence.
// The look-and-say sequence is the sequence of below integers:
// 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, …

/*H ow is above sequence generated?
        n’th term in generated by reading (n-1)’th term.
        The first term is "1"
        Second term is "11", generated by reading first term as "One 1"
        (There is one 1 in previous term)
        Third term is "21", generated by reading second term as "Two 1"
        Fourth term is "1211", generated by reading third term as "One 2 One 1"
        and so on
        How to find n’th term?
        Example:
        Input: n = 3
        Output: 21
        Input: n = 5
        Output: 111221*/

//Driver code

//Basic idea is using a string buffer to store last generated string and process it char by char.
// /Check if the current char is the same as the next char-
// if yes, increment the counter,
// else increment the counter and output the counter and the current char to the result string buffer,
// and reset the counter.

//Time complexity: O(m*n) m is the string length.

public class CountAndSay {

    public static void main(String[] args) {
        int N = 6;
        System.out.println(countAndSay(N));
    }

    // Returns n'th term in
    // look-and-say sequence
    static String countAndSay(int n) {
        // Base cases n ==1
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;

        for (int i = 1; i < n; i++) {
            //last current became previous string
            prev = curr;
            //init current
            curr = new StringBuilder();

            //init count 1 - counting 1 time of first char
            count = 1;
            //starting from first char
            say = prev.charAt(0);

            for (int j = 1, len = prev.length(); j < len; j++) {
                //new char found - adding count and the say
                char foundChar = prev.charAt(j);
                if ( foundChar != say) {
                    curr.append(count);
                    curr.append(say);
                    //init cound to 1
                    count = 1;
                    //updating say
                    say = foundChar;
                } else {
                    //same char as before - just increasing counter
                    count++;
                }
            }
            //end  jth iteration - adding current count and say to SB.
            curr.append(count);
            curr.append(say);

            System.out.println("On iteration " + n + " end output is:" + curr.toString());
        }
        return curr.toString();
    }

}