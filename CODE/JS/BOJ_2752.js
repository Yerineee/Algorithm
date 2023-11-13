const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().split(' ').map(Number);

input = input.sort((a,b) => a-b);

let answer = '';
for(let num of input) {
    answer += num+' ';
}

console.log(answer);
