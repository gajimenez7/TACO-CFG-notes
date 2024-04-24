package threads;

public class TestObj{
    int i;
    int x;
    String str1;
    String str2;

    TestObj(){

    }
    TestObj(int i, int x, String str1, String str2){
        this.i = i;
        this.x = x;
        this.str1 = str1;
        this.str2 = str2;
    }

    public int getNum(){
        return this.i;
    }
    public int getInt(){
        return this.x;
    }

    public String getStr1(){
        return this.str1;
    }

    public String getStr2(){
        return this.str2;
    }
}