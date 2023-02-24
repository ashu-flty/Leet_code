class Solution {
    public class Pair implements Comparable<Pair>{
        int primes;
        int pointers;
        int value;
        
        Pair(int primes, int pointers, int value){
        	this.primes = primes;
        	this.pointers = pointers;
        	this.value = value;
        }
        
        public int compareTo(Pair o) {
        	return this.value - o.value;
        }
    }
    
    public int nthSuperUglyNumber(int n, int[] primes) {
          int[] dp = new int[n];
          dp[0] = 1;

          PriorityQueue<Pair> pq = new PriorityQueue<>();
          for(int i = 0; i < primes.length; i++)
              pq.add(new Pair(primes[i], 0, primes[i] * dp[0]));

          for(int i = 1; i < dp.length; i++) {
              Pair rem = pq.remove();
              dp[i] = rem.value;
              pq.add(new Pair(rem.primes, rem.pointers + 1, rem.primes * dp[rem.pointers]));
              while(pq.peek().value == rem.value) {
                  Pair nrem = pq.remove();
                  pq.add(new Pair(nrem.primes, nrem.pointers + 1, nrem.primes * dp[nrem.pointers]));
              }
          }
          return dp[n-1];
    }
}