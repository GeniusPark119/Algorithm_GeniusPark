const main = () => {
  const input = require('fs')
    .readFileSync(process.platform === 'linux' ? 'dev/stdin' : 'example.txt')
    .toString()
    .trim()
    .split('\n');

  const deque = [];
  const result = [];

  const N = input.shift();

  for (let i = 0; i < N; i++) {
    switch (input[i]) {
      case 'pop_front':
        result.push(deque.shift() || -1);
        break;
      case 'pop_back':
        result.push(deque.pop() || -1);
        break;
      case 'size':
        result.push(deque.length);
        break;
      case 'empty':
        result.push(deque.length === 0 ? 1 : 0);
        break;
      case 'front':
        result.push(deque[0] || -1);
        break;
      case 'back':
        result.push(deque[deque.length - 1] || -1);
        break;
      default: // 여기서부터는 배열로 들어오니 case를 쓰지 않음
        const detail = input[i].split(' ');
        if (detail[0] === 'push_front') deque.unshift(detail[1]); // 맨 앞에 추가하는 건 unshift(요소)
        else deque.push(detail[1]);
    }
  }
  console.log(result.join('\n'));
};

main();
