import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.next();
        repeatLimitedString(s,3);
    }
    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] chs =s.toCharArray();
        int [] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[chs[i]-'a']++;
        }
        int count=0;
        int t=25;
        String ans="";
        for(int i=25;i>=0;i--){
            count=0;
            int n=arr[i];
            for(int j=0;j<n;){
                if(count==repeatLimit){
//                    int t=i-1;
                    if(t>=i)t=i-1;
                    while(t>=0&&t!=i){
                        if(arr[t]>0){
                            arr[t]--;
                            ans+=(char)(t+'a');
                            break;
                        }else t--;
                    }
                }else if(count<repeatLimit){
                    ans+=(char)('a'+i);
                    arr[i]--;
                    count++;
                    j++;
                }else {
                    break;
                }
            }
        }

        return ans;
    }
}