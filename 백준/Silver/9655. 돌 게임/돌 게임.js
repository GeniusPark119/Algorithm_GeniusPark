const main = () => {
  const N = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'example.txt')
    .toString()
    .trim();

  console.log(N % 2 === 1 ? 'SK' : 'CY'); // 돌이 홀수개면 SK 짝수개면 CY
};
main();
