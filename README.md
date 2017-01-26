<p align="center">
  <img src="docs/logo/JDUtils.png" alt="JDUtils">
</p>

# JDUtils
Java utility classes

## MimeTypesUtils

#### static String `getFileContentType`(String fileName)

*Get content type from file extension.*

## EmptyUtils

```java
public static boolean isEmpty(final CharSequence cs) 
```
*Checks if a CharSequence is empty ("") or null.*
```java
public static boolean isEmpty(final Object[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final long[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final int[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final short[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final char[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final byte[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final double[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final float[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final boolean[] array) 
```
*Checks if array is empty or null.*
```java
public static boolean isEmpty(final Collection collection) 
```
*Checks if a Collection is empty or null.*
```java
public static boolean isEmpty(final Map map)
```
*Checks if a Map is empty or null.*

## StringSplitter

#### static List<String> `splitAndModify`(String str, String delimiter, StringModifier modifier)

#### static List<String> `splitAndModifyRE`(String str, String regEx, StringModifier modifier)
