let fs = require('fs');
let line = fs.readFileSync('dev/stdin').toString().split('\n');

let input = line[0].split(' ');
let H = parseInt(input[0]);
let M = parseInt(input[1]);
// let [H, M] = line[0].split(' ').map(Number);

if(M<45) {
    H-=1;
    if(H<0) H+=24;
    M+=60;
}
M-=45;

console.log(H+' '+M);
