package checknugyenamak46;

public class Main {
    public static  boolean checknguyenam(String string){
        if(string.length()!=1){
            throw new  IllegalArgumentException("Sai du lieu dau vao");
        }
        return "aeiouAEIOU".contains(string);
    }
}
