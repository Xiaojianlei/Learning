package 字符串操作.KMP;

public class KMP {
    public int kmp_matcher(String s, String p){
        int n=s.length(),m=p.length();
        if(m==0) return 0;
        int prefix[] =prefix(p);
        for (int i = 0,len=0; i < n; i++) {
            while (len>0 && p.charAt(len)!=s.charAt(i)) len=prefix[len-1];
            if(p.charAt(len)==s.charAt(i)) len++;
            if(len==m) return i-m+1;
        }
        return -1;
    }

    public int[] prefix(String p){
        int m=p.length();
        int[] prefix=new int[m];
        prefix[0]=0;
        for (int i = 1,len=0; i < m; i++) {
            while (len>0 && p.charAt(len)!=p.charAt(i)) len=prefix[len-1];
            if(p.charAt(len)==p.charAt(i)) len++;
            prefix[i]=len;
        }
        return  prefix;
    }

    public static void main(String[] args) {
        System.out.println(new KMP().kmp_matcher("bbbabba","bbb"));
    }
}
