<p align="center">
  <img src="docs/logo/JDUtils.png" alt="JDUtils">
</p>

# JDUtils
Java utility classes

## MimeTypesUtils

#### static String `getFileContentType`(String fileName)

*Get content type from file extension.*

## EmptyUtils

#### static boolean `isEmpty`(CharSequence cs) 
*Checks if a CharSequence is empty ("") or null.*

#### static boolean `isEmpty`(Object[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(long[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(int[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(short[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(char[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(byte[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(double[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(float[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(boolean[] array) 
*Checks if array is empty or null.*

#### static boolean `isEmpty`(Collection collection)
*Checks if a Collection is empty or null.*

#### static boolean `isEmpty`(Map map)
*Checks if a Map is empty or null.*

## StringSplitter

#### static List<String> `splitAndModify`(String str, String delimiter, StringModifier modifier)

#### static List<String> `splitAndModifyRE`(String str, String regEx, StringModifier modifier)
