set projectLocation=C:\Bharath\Prasanthi\MyWork\PrasanthiWorkSpace\PracticeProject
 
cd %projectLocation%
 
set classpath=%projectLocation%\bin;%projectLocation%\jars\*
 
java org.testng.TestNG %projectLocation%\testng.xml
 
pause