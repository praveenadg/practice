package test;

public class ThrottleGateway {
    /**
     *  Bill.com
     * Throttling Gateway
     * Description
     * Non-critical requests for a transaction system are routed through a throttling gateway to ensure that the network is not choked by non-essential requests.
     *  
     * The gateway has the following limits:
     * * The number of transactions in any given second cannot exceed 3.
     * * The number of transactions in any given 10 second period cannot exceed 20. A ten-second period includes all requests arriving from any time max(1, T-9) to T (inclusive of both) for any valid time T.
     * * The number of transactions in any given minute cannot exceed 60.   Similar to above, 1 minute is from max(1, T-59) to T.
     *  
     * Any request that exceeds any of the above limits will be dropped by the gateway. Given the times at which different requests arrive sorted ascending, find how many requests will be dropped.
     *  
     * Note: Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.
     *  
     * Example
     * n = 27
     * requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11 ] 
     * * Request 1 - Not Dropped.
     * * Request 1 - Not Dropped.
     * * Request 1 - Not Dropped.
     * * Request 1 - Dropped. At most 3 requests are allowed in one second.
     * * No request will be dropped till 6 as all comes at an allowed rate of 3 requests per second and the 10-second clause is also not violated.
     * * Request 7 - Not Dropped. The total number of requests has reached 20 now.
     * * Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
     * * Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
     * * Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Note that the 1-second limit is also violated here.
     * * Request 11 - Not Dropped. The 10-second window has now become 2 to 11. Hence the total number of requests in this window is 20 now.
     * * Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
     * * Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
     * * Request 11 - Dropped. At most 20 requests are allowed in ten seconds. Also, at most 3 requests are allowed per second.
     * Hence, a total of 7 requests are dropped.
     */


    public static void main(String[] args){
        int a=5;
        int b=7;
        System.out.println(++a+b);
        System.out.println(throttleGateway(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 11, 11, 11, 11 }));
    }
    private static int throttleGateway(int[] requestTime){
        int count=0;
        for(int i=0; i<requestTime.length; i++){
            if(i>=3 && requestTime[i]==requestTime[i-3]){
                count++;
                System.out.println("index="+i);
            } else if(i>=20 && requestTime[i]-requestTime[i-20] <10){
                count++;
                System.out.println("index="+i);
            }else if(i>=60 && requestTime[i]-requestTime[i-60] <60){
                count++;
                System.out.println("index="+i);
            }
        }
        return count;

    }
}
