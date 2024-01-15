import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger K = new BigInteger(st.nextToken());
		BigInteger L = new BigInteger(st.nextToken());
		//인수분해 소수가 L보다 작을 경우 해당 소수를 저장할 변수 선언
		int N = 0;
		
		//L은 BigInteger형이기때문에 int형인 i와 크기 비교를 하기 위해 intValue로 int형으로 변환
		//만약 L이 int 형을 벗어난 값을 입력 받을 수 있다면 컴파일 오류가 나겠지만, 1000000이기에 가능
		for(int i = 2; i < L.intValue(); i++) {
			//K에 i를 나눠서 나머지가 0이 나오면 이라는 조건을 사용
			if((K.remainder(BigInteger.valueOf(i))).compareTo(BigInteger.ZERO) == 0) {
				N = i;
				break;
			}
		}
		//삼항연산자로 S값에 N값의 여부에 따른 값 저장
		String S = (N > 0)? ("BAD " + N) : "GOOD";
		
		System.out.println(S);
	}

}