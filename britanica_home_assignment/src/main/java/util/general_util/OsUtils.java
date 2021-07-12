package util.general_util;



import java.util.Formatter;

public final class OsUtils
{
   private static String OS = null;
   public static String getOsName() {
      String os = System.getProperty("os.name");
      if(OS == null) { OS = System.getProperty("os.name"); }
      return OS;
   }
   public static boolean isWindows(){
      return getOsName().startsWith("Windows");
   }

   public static boolean isLinux() {
      return getOsName().startsWith("Linux");
   }

   /**
    * Created by asih on 12/28/2017.
    */

}