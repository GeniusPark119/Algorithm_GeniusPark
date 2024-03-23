import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {

    static int r, c;
    static char[][] board;
    static int[] dr = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1}; // 명령어 1~9 r 인덱스 변화
    static int[] dc = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1}; // 명령어 1~9 c 인덱스 변화

    static LinkedList<Node> crazy_arduino; // 미친 아두이노 위치 저장
    static Node arduino; // I 의 노드를 저장하는 아두이노

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // N (2 ≤ N ≤ 100) 지도의 크기
        c = Integer.parseInt(st.nextToken()); // L (1 ≤ L ≤ N) 경사로 바닥의 길이

        board = new char[r][c];
        crazy_arduino = new LinkedList<>(); // R 위치 저장

        for(int i=0;i<r;i++){
            board[i] = br.readLine().toCharArray(); // board에 처음 배열 저장
            for(int j=0;j<c;j++){
                if(board[i][j]=='R')
                    crazy_arduino.add(new Node(i,j)); // 만약 미친 아두이노를 마주쳤으면 저장해준다.
                else if(board[i][j]=='I')
                    arduino = new Node(i,j); // I 아두이노 저장
            }
        }

        String direction = br.readLine(); // 명령어를 구함
        //입력 끝

        int count = 0;// 움직인 횟수

        boolean is_lose = false; // 아두이노와 미친아두이노가 만났는지

        for(int k=0;k<direction.length();k++){
            count++;
            board[arduino.r][arduino.c] = '.';
            arduino.r = arduino.r + dr[direction.charAt(k)-'0']; // 아두이노 이동 r
            arduino.c = arduino.c + dc[direction.charAt(k)-'0']; // 아두이노 이동 c

            if(board[arduino.r][arduino.c]=='R'){ // 미친 아두이노를 만났으니
                is_lose = true; // 게임 끝
                break;
            }
            board[arduino.r][arduino.c] = 'I'; // 이제 다음 칸을 I라고 표시해준다.

            if(!move_crazy_arduino()){
                is_lose = true;
                break;
            }
        }

        if(is_lose){
            System.out.println("kraj "+count);
        }else{
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

    } // main 끝

    public static boolean move_crazy_arduino(){
        int[][] arduino_count  = new int[r][c];
        int crazy_arduino_size = crazy_arduino.size(); // R의 개수

        for(int i=0;i<crazy_arduino_size;i++){
            Node current = crazy_arduino.poll(); // 리스트에 있는 R를 뽑아와서
            board[current.r][current.c] = '.'; // 해당 좌표를 .으로 변경

            int dir = find_close_dir(current); // R이 이동할 방향 메서드로부터 가져오기
            int nr = current.r + dr[dir];
            int nc = current.c + dc[dir];

            if(board[nr][nc]=='I')// 이동한 자리에 I가 있으면 게임종료
                return false;
            arduino_count[nr][nc]++; // 이번 턴에서 나온 R의 좌표를 모은다.
        }

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                // 여기서 만약 3개가 들어있는 경우는 ?? 반영이 된건가
                if(arduino_count[i][j]==1){ // 만약 한개가 들어있으면 바로 반영을 해준다.
                    board[i][j] = 'R';
                    crazy_arduino.add(new Node(i,j)); // 미친 아두이노 리스트에 더해준다.
                }
            }
        }
        return true;
    }

    public static int find_close_dir(Node current) { // R이 최대한 I에게 가깝게 이동하는 방향 구하는 메서드
        int min = Integer.MAX_VALUE;
        int min_dir = -1;

        for (int i = 1; i <= 9; i++) { // 총 9개의 방향이 있다.
            if (i == 5) continue;
            int nr = current.r + dr[i];
            int nc = current.c + dc[i];
            if (nr < 0 || nc < 0 || nr >= r || nc >= c)
                continue;
            int distance = Math.abs(nr-arduino.r) + Math.abs(nc - arduino.c); // 거리를 구하고
            if(min>distance){ // 거리가 이제까지의 거리보다 작으면
                min = distance; // 작은 거리 업로드
                min_dir = i; // 방향 업로드
            }
        }
        return min_dir; // 1~9 까지의 방향
    }

    public static class Node { // Node 클래스
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}