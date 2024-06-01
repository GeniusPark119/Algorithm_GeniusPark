const main = () => {
  const input = require('fs')
    .readFileSync(process.platform === 'linux' ? 'dev/stdin' : 'example.txt')
    .toString()
    .trim()
    .split('\n');

  const queue = []; // 자스에는 queue가 따로 없고 배열로 진행
  const result = [];

  const N = input.shift(); // 맨 앞의 배열을 빼며출력 shift()

  for (let i = 0; i < N; i++) {
    switch (input[i]) {
      case 'pop':
        result.push(queue.shift() || -1); // 맨 앞의 배열을 빼며출력 shift() 이게 만약 undefined 이면 || 를 통해 뒤를 출력할 수 있음
        break;
      case 'size':
        result.push(queue.length);
        break;
      case 'empty':
        result.push(queue.length === 0 ? 1 : 0); // isempty 기능 없음
        break;
      case 'front':
        result.push(queue[0] || -1); // 요소가 undefined면 || 뒤 출력
        break;
      case 'back':
        result.push(queue[queue.length - 1] || -1); // 요소가 undefined면 || 뒤 출력
        break;
      default:
        queue.push(input[i].split(' ')[1]);
    }
  }

  console.log(result.join('\n')); // 배열 출력시 join으로 가능
};

main();
