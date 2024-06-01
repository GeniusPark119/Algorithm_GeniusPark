const main = () => {
  //   const array = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
  const array = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'example.txt')
    .toString()
    .trim()
    .split('\n');

  const result = [];
  const stack = [];

  const N = array.shift();

  for (let i = 0; i < N; i++) {
    switch (array[i]) {
      case 'pop':
        result.push(stack.pop() || -1);
        break;
      case 'size':
        result.push(stack.length);
        break;
      case 'empty':
        result.push(stack.length === 0 ? 1 : 0);
        break;
      case 'top':
        result.push(stack[stack.length - 1] || -1);
        break;
      default:
        stack.push(array[i].split(' ')[1]);
    }
  }
  console.log(result.join('\n'));
};

main();
