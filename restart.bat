"C:\Program Files\Apache Software Foundation\Tomcat 8.5\bin\shutdown.bat"  & ^
del "C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps\Kummekordakummetripstrapstrullviisreas-1.0*"  & ^
mvn clean package -f C:\Projektid\Java-Servlet-Programming\Kummekordakummetripstrapstrullviisreas & ^
move "C:\Projektid\Java-Servlet-Programming\Kummekordakummetripstrapstrullviisreas\target\Kummekordakummetripstrapstrullviisreas-1.0.war" "C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps\Kummekordakummetripstrapstrullviisreas-1.0.war"  & ^
cmd /c "C:\Program Files\Apache Software Foundation\Tomcat 8.5\bin\startup.bat"

