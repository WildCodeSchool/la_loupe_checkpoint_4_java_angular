================================== PlayList Back ==================================

- avant de tester vous devez remplir le fichier src/main/resources/application.properties avec le nom de la basse de donnée, votre login et mot de passe
- allez dans un terminal dans le répertoire back/playlist/ et taper mvn spring-boot:run

================================== Deployement =====================================

- Éditez le fichier pom.xml (Spring) et ajouté ceux qui suis :
                                        

<build>
        <plugins>
                <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                        <configuration>
                        <executable>true</executable>
                        </configuration>
                </plugin>
        </plugins>
</build>


- Tapez la commande mvn clean install
- copier les fichiers du répertoire target sur votre serveur dans le répertoire back
