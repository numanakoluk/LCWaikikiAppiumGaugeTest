<div align="center">
 LCWaikikiMobileTestProject
</div>

# **Selenium WEB** //Intelij //MVN//JUNIT//GAUGE // APPIUM 
# AllSteps LCWaikiki WithLogin Scenario 
**Tags:android and IOS**

1. [+] **Uygulamanin acildigi kontrol edilir.**

2. [+] **Siteye login olunur.**

3. [+] **Arama kutucuğuna “Parfüm” kelimesi girilir.**

4. [+] **Listeden Erkek Seçilir.**

5. [+] **Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.**

6. [+] **Seçilen ürün sepete eklenir.**

7. [+] **“Sepete dolaylı yoldan gidilir.**

8. [+] **Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.**

9. [+] **Ürünler sepetten silinerir ve favorilere eklener sepetin boş olduğu kontrol edilir.**


# DEMO
https://user-images.githubusercontent.com/89300182/200200810-22f77578-b6d7-46d6-8469-35fbf86069f6.mp4



# TODO

1. [-] **Scenerio Edit**



# POMXML
 
 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>gauge-test</artifactId>
    <version>1.0-SNAPSHOT</version>
    <properties>
        <junit.version>4.13.2</junit.version>
        <gauge.version>0.9.1</gauge.version>
        <log4j.version>1.2.17</log4j.version>
        <appium.version>7.3.0</appium.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>com.thoughtworks.gauge</groupId>
            <artifactId>gauge-java</artifactId>
            <version>${gauge.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>${log4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>${appium.version}</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.5</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.5</version>
        </dependency>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.7.0</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>com.thoughtworks.gauge.maven</groupId>
                <artifactId>gauge-maven-plugin</artifactId>
                <version>1.4.3</version>
                <executions>
                    <execution>
                        <phase>test</phase>
                        <configuration>
                            <specsDir>specs</specsDir>
                        </configuration>
                        <goals>
                            <goal>execute</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

</project>



 ```






