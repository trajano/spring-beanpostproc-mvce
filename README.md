MVCE for https://stackoverflow.com/questions/66278338/how-do-i-get-spel-expressions-to-work-in-a-beanpostprocessor-that-is-application

```
docker build . -t mvce
docker run --rm mvce
```

Logs show

        Caused by: java.lang.NumberFormatException: For input string: "${spring.kafka.maximumRequestSize:15728640}"
                at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
                at java.base/java.lang.Integer.parseInt(Integer.java:638)
                at java.base/java.lang.Integer.valueOf(Integer.java:983)
                at org.springframework.util.NumberUtils.parseNumber(NumberUtils.java:211)
                at org.springframework.beans.propertyeditors.CustomNumberEditor.setAsText(CustomNumberEditor.java:115)
                at org.springframework.beans.TypeConverterDelegate.doConvertTextValue(TypeConverterDelegate.java:429)
                at org.springframework.beans.TypeConverterDelegate.doConvertValue(TypeConverterDelegate.java:402)
                at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(TypeConverterDelegate.java:155)
                at org.springframework.beans.TypeConverterSupport.convertIfNecessary(TypeConverterSupport.java:73)
                ... 60 more

