const main = () => {
  const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'example.txt')
    .toString()
    .trim()
    .split('\n');

  // 각 input의 원소들을 map 메서드를 통해 ' ' 기준으로 배열화한다. 여기서 그 배열의 원소에 .map((x)=>Number(x)) 해서 타입을 지정할 수 있다.
  const [N, cards, M, targets] = input.map((x) =>
    x.split(' ').map((y) => Number(y))
  );

  const map = new Map(); // 자바스크립트에는 Map 라이브러리가 존재한다.

  for (card of cards) {
    // forEach를 쓰지않고도 이렇게 나타낼 수도 있다. 자바에서는 : 이지만 여기서는 of 임에 주의하자
    map.set(card, map.has(card) ? map.get(card) + 1 : 1);
  }

  const result = [];

  for (target of targets) {
    result.push(map.has(target) ? map.get(target) : 0);
  }

  console.log(result.join(' ')); // 배열을 ' '기준으로 내보내려면 join(' ')
};

main();
