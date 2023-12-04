function solution(s) {
    var answer = '';
    
    const list = s.toLowerCase().split("");
    let isNextSpace = true;
    
    for(let str of list) {
        answer += isNextSpace ? str.toUpperCase() : str;
        isNextSpace = str===" " ? true : false;
    }
    
    return answer;
}
