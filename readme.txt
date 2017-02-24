in POM.xml :
<configuration>
<systemPropertyVariables> <browser>${browser}</browser> </systemPropertyVariables>
<!-- <suiteXmlFiles>
<suiteXmlFile>src/test/resources/${testNG}.xml</suiteXmlFile>
</suiteXmlFiles> -->
</configuration>

mvn clean test -Dbrowser=chrome -DtestNG="testNG"

SQL:
admin | password

