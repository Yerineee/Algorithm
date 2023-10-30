let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().split("\n");

let T = Number(input[0]);

for (let i = 1; i <= T; i++) {
  let [R, S] = input[i].split(" ");

  let answer = "";
  for (let x of S) {
    answer += x.repeat(Number(R));
  }

  console.log(answer);
}
