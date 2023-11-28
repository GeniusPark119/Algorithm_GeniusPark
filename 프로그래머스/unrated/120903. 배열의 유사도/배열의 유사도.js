function solution(s1, s2) {
    var answer = 0;
    // for(let i=0;i<s1.length;i++){
    //     for(let j=0;j<s2.length;j++){
    //         if(s1[i]==s2[j]) answer++;
    //     }
    // }
    
    const ans_arr = s1.filter((x)=>s2.includes(x));
    answer = ans_arr.length;
    return answer;
}