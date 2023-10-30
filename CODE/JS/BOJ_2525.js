let fs = require('fs');
let line = fs.readFileSync('dev/stdin').toString().split('\n');

let H = parseInt(line[0].split(' ')[0]);
let M = parseInt(line[0].split(' ')[1]);
let time = parseInt(line[1]);

M+=time;
if(M>=60) {
    H+=parseInt(M/60);
    M%=60;
    
    if(H>=24) H-=24;
}

console.log(H+' '+M);
