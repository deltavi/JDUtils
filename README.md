<p align="center">
  <img src="docs/logo/JDUtils.png" alt="JDUtils">
</p>

# JDUtils
Java utility classes


Table of contents
=================
* [RegexUtils](#regexutils)

## RegexUtils

### Extract all email address from text
```java
String text = "Lorem ipsum dolor sit amet," +
        " consectetur adipiscing elit," +
        " sed do eiusmod tempor info@test.com@ incididunt" +
        " ut labore et dolore magna aliqua." +
        " Ut enim ad minim veniam," +
        " quis nostrud exercitation ullamco test@test.org" +
        " laboris nisi ut aliquip ex ea commodo consequat." +
        " Duis aute irure dolor in reprehenderit in voluptate" +
        " velit test56@testtest.it esse cillum dolore" +
        " eu fugiat nulla pariatur." +
        " Excepteur sint occaecat cupidatat non proident," +
        " sunt in culpa qui officia deserunt" +
        " test_123-12b@test.co.uk mollit anim id est laborum.";

List<String> emails = RegexUtils.create()
        .email()
        .findAll(text);
```
*Results:*
```
info@test.com
test@test.org
test56@testtest.it
test_123-12b@test.co.uk
```

### Find all fruit in dollars

```java
String text = "Apples £0.94, Bananas $0.68, Oranges €1.50," +
              " Pineapple $0.69, Mango $0.75";

Map<String, String> fruitInDollars = RegexUtils.create()
        .group("key")
            .letters()
        .endGroup()
        .space()
        .group("value")
            .constant("$")
            .number()
        .endGroup()
        .findMap(text);
```

*Results:*
```
Bananas -> $0.68
Mango -> $0.75
Pineapple -> $0.69
```