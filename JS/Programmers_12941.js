function solution(A,B){
    var answer = 0;

    A = A.sort((a,b) => a-b);  // A 배열 오름차순 정렬
    B = B.sort((a,b) => a-b);  // B 배열 오름차순 정렬
    
    for(idx in A) {
        answer += A[idx]*B[B.length-1-idx];
    }

    return answer;
}
