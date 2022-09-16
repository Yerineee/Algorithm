package го;

import java.util.*;
import java.io.*;

public class BOJ_10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Character> stack = new Stack<>();
		String bracket = br.readLine();
		int answer=0;
		
		for(int i=0;i<bracket.length();i++) {
			char temp=bracket.charAt(i);
			
			if(temp=='(') {
				stack.push(temp);
			}
			else {
				if(bracket.charAt(i-1)=='(') {
					stack.pop();
					answer+=stack.size();
				}
				else {
					stack.pop();
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
