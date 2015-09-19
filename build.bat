javac JavaApplication1.java
javac AZT.java
copy AZT.class resources/AZT.class
cd resources
jar -cfm power.jar Manifest.txt AZT.class ReadEnv.class
jarsigner power.jar -keystore keystore.jks root
cd..
jar -cfm javaap.jar Manifest.txt JavaApplication1.class ReadEnv.class MainForm.class MainForm$1.class MainForm$2.class MainForm$3.class resources/codeofconduct.txt resources/power.jar
jarsigner javaap.jar -keystore keystore.jks root