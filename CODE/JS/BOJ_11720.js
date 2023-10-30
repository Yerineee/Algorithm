let fs = require("fs");
let line = fs.readFileSync("/dev/stdin").toString().split("\n");

let N = Number(line[0]);

/*
// 정답 (1)
let sum = 0;
for (let i = 0; i < N; i++) {
  sum += Number(line[1][i]);
}

console.log(sum);
*/

let string = line[1];
let sum = 0;

for (let x of string) {
  sum += Number(x);
}

console.log(sum);
