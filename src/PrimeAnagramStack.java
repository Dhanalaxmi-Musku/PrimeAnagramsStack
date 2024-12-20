public class PrimeAnagramStack {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    static String sortNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
        return new String(chars);
    }
    
    static boolean areAnagrams(int n1, int n2) {
        return sortNum(n1).equals(sortNum(n2));
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < 1000; i++) {
            if (!isPrime(i)) continue;
            
            for (int j = i + 1; j < 1000; j++) {
                if (isPrime(j) && areAnagrams(i, j)) {
                    stack.push(i);
                    stack.push(j);
                }
            }
        }
        
        System.out.println("Prime Anagrams in Reverse Order:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}