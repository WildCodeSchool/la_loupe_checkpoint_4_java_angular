/* Création de la DataBase */
CREATE DATABASE playlistWild;

/* Création d'un nouvel utilisateur */
CREATE USER 'playlistWild'@'localhost' IDENTIFIED BY 'playlistWild28#';

/* Autorisation sur la DataBase pour le nouvel user */
GRANT ALL ON playlistWild.* TO 'playlistWild'@'localhost';

