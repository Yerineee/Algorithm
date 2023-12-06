const fs = require("fs");
const input = fs.readFileSync("dev/stdin").toString().split(" ").map(Number);

const M = input[1];
const N = input[0];
let answer = 0;

if (N === 1) answer = 1;
else if (N === 2) answer = Math.min(parseInt((M + 1) / 2), 4);
else if (N >= 3) {
  if (M < 7) answer = Math.min(M, 4);
  else answer = M - 2;
}

console.log(answer);
