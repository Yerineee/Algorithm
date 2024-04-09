import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_10825 {
	
	static class Student { // Student 구조체를 정의합니다
		String name;
		int kor;
		int eng;
		int math;
		
		public Student(String name,int kor,int eng,int math) {
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	}
	
    public static ArrayList<String> solution(int N, String [] name, int [] kor, int [] eng, int [] math){
    	ArrayList <String> answer = new ArrayList<>();
    	ArrayList <Student> list = new ArrayList<>(); // Student들을 담을 ArrayList를 생성합니다
   
		//필요한 코드를 작성합니다.
		for(int i=0;i<N;i++) {
			list.add(new Student(name[i],kor[i],eng[i],math[i]));
		}
			
		Collections.sort(list,new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if(o1.kor==o2.kor) {
					if(o1.eng==o2.eng) {
						if(o1.math==o2.math) {
							return o1.name.compareTo(o2.name);
						}
						return o2.math-o1.math;
					}
					return o1.eng-o2.eng;
				}
				return o2.kor-o1.kor;
			}
		});
			
		for(Student s:list) {
			answer.add(s.name);
		}			
			
    	return answer;
    }	
}
