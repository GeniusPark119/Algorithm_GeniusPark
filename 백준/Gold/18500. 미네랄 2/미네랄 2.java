import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;


public class Main {

    static int r,c;
    static char[][] board;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 세로
        c = Integer.parseInt(st.nextToken()); // 가로

        board = new char[r][c]; // r과 c를 알았으니 board를 완성시킨다.

        for(int i=0;i<r;i++){ // board 채운다.
            String str = br.readLine();
            for(int j=0;j<c;j++){
                board[i][j] = str.charAt(j);
            }
        }


        int k = Integer.parseInt(br.readLine()); // 명령어 개수
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<k;i++){ // 명령어를 차례대로 수행
            int removePoint = Integer.parseInt(st.nextToken());
            removeX(removePoint,i);
            visited = new boolean[r][c];
            clusterDown();
        }
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    } // main 끝

    static void removeX(int row,int cnt){ // x 지우기
        row = r-row; // 이렇게 빼면 idx 상에서
        // i 가 0부터 시작해서 짝수가 왼쪽공격
        if(cnt%2==0) { // 짝수일때 왼쪽 공격
            for (int i = 0; i < c; i++) {
                if (board[row][i] == 'x') {
                    board[row][i] = '.';
                    break; // 하나 제거했으면 이제 끝
                }
            }
        }else{// 홀수일때 오른쪽 공격
            for(int i=c-1;i>=0;i--){
                if(board[row][i]=='x'){
                    board[row][i] = '.';
                    break;// 하나 제거했으면 이제 끝
                }
            }
        }
    }// x 지우기 끝

    static void clusterDown(){
        Queue<Node> queue = new LinkedList<>();

        for(int j=0 ;j<c;j++){ // 땅과 직접적으로 붙어있는 미네랄 bfs 탐색
            if(board[r-1][j]=='x' && !visited[r-1][j]){
                queue.add(new Node(r-1,j));
                visited[r-1][j] = true;
            }
        } // bfs 탐색 끝

        while(!queue.isEmpty()){ // bfs : 땅에 연결되어있는 미네랄 덩어리(클러스터) 모두 색출
            Node node = queue.poll();

            for(int i=0 ;i<4;i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(isRange(nx,ny) && board[nx][ny]=='x'&& !visited[nx][ny]){
                    queue.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }// bfs 끝



        // 공중에 있는 미네랄 node 저장할 list
        List<Node> list = new ArrayList<>();

        // 공중에 떠있는 클러스터 있는지 찾기
        // 공중에 만약 클러스터가 있으면 1개
        for(int i=0;i<r;i++){ // 공중 찾기
            for(int j=0;j<c;j++){
                if(board[i][j]=='x'&& !visited[i][j]){
                    list.add(new Node(i,j));
                    board[i][j] = '.';
                    visited[i][j] = true;
                    // 공중에 떠있는 미네랄을 list에 넣고 .으로 바꿔주기
                }
            }
        } // 공중 찾기 끝

        // 자 이제 공중 클러스터가 있다면 list에 무언가 있겠지
        if(!list.isEmpty()){
            // 내려가려면 list에 있는 미네랄들이 한칸씩 밑으로 갈수있어야함
            boolean isStop = false; // 갈 수 없다면 stop

            while(!isStop){ // stop이 아닌동안에 모두 내려갈 수 있는지 확인하며 내려가기

                for(int i=0;i<list.size();i++){
                    int nx = list.get(i).x+1;
                    if(nx>=r || board[nx][list.get(i).y]=='x'){ // 만약 더이상 밑으로 갈수없다면
                        isStop = true; // 내려갈수없다 결론내리고 break
                        break;
                    }
                }// 모두 내려갈 수 있는지 확인 끝

                if(!isStop) { // 위에서 확인끝났고 stop이 아니라면 내려간다.

                    for(Node node : list){
                        node.x++;
                        // 다 내려간다.
                    }
                }
            } // 다 내려감

            // 최대로 내린 미네랄 다시 동굴에 입력
            for(int i=0;i<list.size();i++){
                board[list.get(i).x][list.get(i).y] = 'x';
            }
        }
    }

    static boolean isRange(int x,int y){
        if(x<0||x>=r||y<0||y>=c){
            return false;
        }
        return true;
    }

    static class Node{ // Node class
        int x;
        int y;

        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }// Node class 끝



}

