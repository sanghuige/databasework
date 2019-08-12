package utils;

public class StringUtils {
    //判空
    public  static  boolean isNotNull(String str){
        return str!=null && !"".equals(str);
    }
    //字符创转Integer
    public static Integer change(String str,Integer defvault){
        if(isNotNull(str)){
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defvault;
    }
}
