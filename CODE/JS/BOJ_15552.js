let fs = require('fs');
let line = fs.readFileSync('dev/stdin').toString().split('\n');

let T = Number(line[0]);    // 테스트 케이스 개수

let answer='';
for(let i=1;i<=T;i++) {
    let A = Number(line[i].split(' ')[0]);
    let B = Number(line[i].split(' ')[1]);
    answer += A+B+'\n';
}

console.log(answer);
