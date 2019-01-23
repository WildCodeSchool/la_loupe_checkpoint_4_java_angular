# Dixheures

Sérieux ? Je dois écrire une doc ? Mais c'est ch... !

## Execution

### Pré-requis

- MySQL
- Apache Tomcat
- Maven

### Installation

1) Téléchargez le projet ou entrez dans le terminal :
```Shell
git clone https://github.com/WildCodeSchool/la_loupe_checkpoint_4_java_angular.git
cd la_loupe_checkpoint_4_java_angular/Definitly_Now_Spotify/back
git checkout Post_Aymeric_LaLoupe_2018
```
2) Créez un utilisateur et une base de donnée pour l'application :
```Shell
mysql -u root -p
```

```SQL
CREATE DATABASE dixheures;
CREATE USER "il-est-lor"@"localhost" IDENTIFIED BY "L_0r_d3_Se_rev3!lLeR_!";
GRANT ALL ON dixheures.* TO 'il-est-lor'@'localhost'; 
```
## Lancement

Lancez le serveur et la compilation depuis le dossier téléchargé avec la commande :
```Shell
cd la_loupe_checkpoint_4_java_angular/Definitly_Now_Spotify/back
mvn spring-boot:run
```
