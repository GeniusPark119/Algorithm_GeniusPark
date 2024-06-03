class PriorityQueue {
  // 자바스크립트에서는 우선순위큐 라이브러리가 따로 없으니 직접 만들어야한다.
  constructor() {
    // 맨 처음 생성자로 heap을 만든다.
    this.heap = [];
  }

  swap(a, b) {
    // swap 기능도 직접 해준다.
    const { heap } = this;

    const tmp = heap[a];
    heap[a] = heap[b];
    heap[b] = tmp;
  }

  push(node) {
    const { heap } = this; // 계속 this.heap하기 불편하니 heap으로 쓸 수 있게 한다.

    heap.push(node);

    let index = heap.length - 1; // 방금 들어온 값의 idx
    let parent = Math.floor((index - 1) / 2); // 비교할 parent (이건 그냥 외움)

    while (index > 0 && heap[index] < heap[parent]) {
      // idx가 0보다 크고 앞에 있는 값 parent가 더 작으면 앞으로 슝슝 데려간다.
      this.swap(index, parent); // 둘을 바꾸고
      index = parent; // 인덱스를 parent idx로 바꿔줌
      parent = Math.floor((index - 1) / 2); // 다시 parent를 idx 앞으로 슝슝
    }
  }

  pop() {
    const { heap } = this;

    if (heap.length <= 1) {
      // 맨처음 중요한건 일단 요소가 1개 이하면 pop 하면 된다.
      return heap.pop();
    }

    const output = heap[0]; // heap의 맨처음을 output으로하고 맨 뒤의 요소를 맨앞으로 가져온다.
    heap[0] = heap.pop();

    let index = 0;

    while (index * 2 + 1 < heap.length) {
      // 왼쪽 index가 length를 넘지 않는지 확인
      let left = index * 2 + 1;
      let right = index * 2 + 2;
      let next = index; // next가 index가 된다.

      if (heap[left] < heap[next]) {
        // left가 next 보다 작으면 next가 left가 된다.
        next = left;
      }

      if (right < heap.length && heap[right] < heap[next]) {
        // right가 next 보다 작으면 next가 right가 된다.
        // 이때 right이 범위 밖으로 가는지 먼저확인
        next = right;
      }

      if (index === next) {
        //  next가 바뀌지 않았다면 더이상 swap할 필요가 없다.
        break;
      }

      this.swap(index, next); // index와 next를 바꿔주고 index에 next를 넣어준다.
      index = next;
    }

    return output;
  }
}

const main = () => {
  const input = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : 'example.txt')
    .toString()
    .trim()
    .split('\n');

  // ...이란 처음 한개를 N 이라 하고 나머지를 모두 cards에 담는다는 의미이다.
  const [N, ...cards] = input.map((x) => Number(x));

  const queue = new PriorityQueue();

  // 자스 배열에서 쓰이는 forEach 문이다. 배열.forEach(x => {}) 형식
  cards.forEach((card) => {
    queue.push(card);
  });

  //   console.log(queue);

  let ans = 0;

  while (queue.heap.length > 1) {
    // 여기서 queue.length 가 아님 주의 ! queue는   PriorityQueue { heap: [ 10, 20, 40 ] } 의 객체 형식이기 때문에 queue.heap 의 길이를 재야한다.
    const sum = queue.pop() + queue.pop();
    ans += sum;
    // 더한 값을 다시 queue에 넣고 그 값까지 포함해서 가장 작은 수를 pop 해야한다.
    queue.push(sum);
  }

  console.log(ans);
};

main();
