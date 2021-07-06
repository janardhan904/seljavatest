1. Create a Maven Project (mvn-archtype-quickstart) in Intellij
2. - Make sure you have installed and enabled the `Cucumber for Java` plugin from the 
     JetBrains plugin repository. Look in the 
     `File -> Settings -> Plugins -> **Cucumber for JAVA** -> Install ->Restart`
2. Configure Git
3. Add dependencies 


    <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-jvm</artifactId>
      <version>6.9.1</version>
      <type>pom</type>
    </dependency>

     <!-- https://mvnrepository.com/artifact/junit/junit -->
     <dependency>
         <groupId>junit</groupId>
         <artifactId>junit</artifactId>
         <version>4.12</version>
         <scope>test</scope>
     </dependency>

    <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-java</artifactId>
      <version>6.9.1</version>
    </dependency>


    <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-junit</artifactId>
      <version>6.9.1</version>
      <scope>test</scope>
    </dependency>


    <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-jvm-deps -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>cucumber-jvm-deps</artifactId>
      <version>1.0.6</version>
      <scope>provided</scope>
    </dependency>

    <!-- https://mvnrepository.com/artifact/io.cucumber/gherkin -->
    <dependency>
      <groupId>io.cucumber</groupId>
      <artifactId>gherkin</artifactId>
      <version>5.1.0</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/net.masterthought/cucumber-reporting -->
    <dependency>
      <groupId>net.masterthought</groupId>
      <artifactId>cucumber-reporting</artifactId>
      <version>4.11.2</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
      <groupId>org.seleniumhq.selenium</groupId>
      <artifactId>selenium-java</artifactId>
      <version>3.141.59</version>
    </dependency>


If dependencies not found, right click on pom.xml and Reload the project

Project Structure :
1. Src/main/java -> pages, utils, base, configs
2. Src/test/java -> test files
3. Src/test/resources ->feature files