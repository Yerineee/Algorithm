let fs = require('fs');
let line = fs.readFileSync('dev/stdin').toString().split('\n');

let N = Number(line[0]);
let arr = line[1].split(' ').map(Number);

arr = arr.sort((a, b) => a - b);


console.log(`${arr[0]} ${arr[N-1]}`);
