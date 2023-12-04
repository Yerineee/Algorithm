let fs = require("fs");
let input = fs.readFileSync("example.txt").toString().split(" ").map(Number);

let answer = 0;

// (여학생 수) >= 2*(남학생 수)이면 (여학생 수)에서 인턴쉽 참여할 사람 빼기
// (여학생 수) < 2*(남학생 수)이면 (남학생 수)에서 인턴쉽 참여할 사람 빼기
while (input[2]--) {
  if (input[0] >= input[1] * 2) {
    input[0]--;
  } else {
    input[1]--;
  }
}

answer = Math.min(parseInt(input[0] / 2), input[1]);
if (answer <= 0) {
  console.log(0);
} else {
  console.log(answer);
}
