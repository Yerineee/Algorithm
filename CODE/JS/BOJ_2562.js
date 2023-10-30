let fs = require("fs");
let line = fs.readFileSync("/dev/stdin").toString().split("\n");

/*
let max = 0;
let maxIdx = -1;
for(let i=0;i<9;i++) {
    let num = Number(line[i]);
    if(num>max) {
        max = num;
        maxIdx = i+1;
    }
}

console.log(max);
console.log(maxIdx);
*/

let arr = line.map((x) => Number(x));
let max = Math.max(...arr);

console.log(max);
console.log(arr.indexOf(max) + 1);
