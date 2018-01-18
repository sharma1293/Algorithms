package DynamicProgramming;
//Solution to Hacker Rank problem, where we count the number of change required for particular value
//Hacker Rank Problem:->  https://www.hackerrank.com/challenges/coin-change/problem

public class NumCoinChange {

	public long calcNumSol(int n, int c[]){
		int m = c.length;
		long[][] d = new long[n+1][m+1];
		
		//Initializing the array
		//When the value is zero ie change required for 0 cents
		
		for(int j= 0; j<=m; j++){
			d[0][j] = 1;
		}
		//Build a 2d array for calculating the number of cents required for particular given value. 
		for(int i=1; i<=n ; i++){
			for(int j=1; j<=m; j++ ){

				int curDen = c[j-1];

				if(curDen>i)
				{ 
					d[i][j] = d[i][j-1]; 
				}
				else
					d[i][j] = d[i][j-1]+d[i-curDen][j];
			}
		}
		return d[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NumCoinChange cc = new NumCoinChange();
		//Enter the n value
		int total = 245;
		//Enter the coin denominations
		int coins[] = {16,30,9,17,40,13,42,5,25,49,7,23,1,44,4,11,33,12,27,2,38,24,28,32,14,50};
		System.out.println(cc.calcNumSol(total, coins));
	}
}