# The last checkpoint ! 


## Préparatifs


- Cloner ce dépôt github 
- Créer une branche au format **nom_prenom_ville**
- Créer un dossier **back** et y démarrer un nouveau projet Spring Boot 
- Créer un dossier **front** et y démarrer un nouveau projet Angular


## Questionnaire 


Tu dois répondre aux questions suivantes, note tes réponses dans un fichier **answers.txt** et commite-le au sein de ta branche. 


#### (Q1) Une application Spring Boot s'exécute... ?  


- A ) Sur un serveur 
- B ) Dans le navigateur 
- C ) Les deux à la fois 
- D ) La réponse D 


#### (Q2) A contrario, une application Angular est une application ... ?


- A ) Client
- B ) Serveur
- C ) Jambon 
- D ) Pâté 


#### (Q3) Spring boot et Angular sont des... ?


- A ) ORM
- B ) Frameworks
- C ) Bibliothèques
- D ) Modules


#### (Q4) À quoi sert un Framework (plusieurs réponses possibles)... ? 


- A ) À donner un cadre de travail
- B ) À se compliquer la vie
- C ) À être plus productif
- D ) À faciliter la maintenance du code


#### (Q5) L'annotation @Entity sert à définir... ? 


- A ) Un controller
- B ) Un repository
- C ) Une entité
- D ) Une vue


#### (Q6) L'annotation @OneToMany sert à (plusieurs réponses possibles)... ? 


- A ) Créer une relation entre deux entités 
- B ) Faire une jointure 
- C ) Afficher ses données au format JSON
- D ) Sécuriser une partie de son application


#### (Q7) Quel acronyme ci-dessous ne représente PAS une attaque ? 


- A ) CSRF
- B ) XSS
- C ) SQL Injection
- D ) XSLT


#### (Q8) En quoi consiste une attaque de type CSRF ? 


- A ) À piéger l'internaute en lui faisant exécuter une requête à son insu, avec ses propres droits.
- B ) À injecter du javascript dans une image
- C ) À voler les cookies de l'utilisateur
- D ) À écouter la carte réseau


#### (Q9) À quoi sert traditionnellement une API KEY (plusieurs réponses possibles) ? 


- A ) À ne pas renvoyer systématiquement le couple email/mot de passe
- B ) À crypter les informations en BDD
- C ) À vérifier l'intégrité des données insérées en BDD
- D ) À s'identifier rapidement


#### (Q10) Qui sont les meilleurs, évidemment c'est... (plusieurs réponses possibles) ? 


- A ) Les verts
- B ) L'équipe pédagogique 
- C ) Les joueurs du PSG
- D ) Les métalleux


## Création d'une mini application de gestion de playlist.


Le but est de créer une application permettant de gérer une liste de chansons. Tu devras gérer l'ensemble des opérations suivantes : 


- Ajout d'une chanson à la playlist
- Modification d'une chanson au sein de la playlist
- Effacer une chanson de la playlist
- Afficher toutes les chansons de la playlist


Tu l'auras deviné, tu devras donc créer une **API** permettant de gérer ces opérations côté **back-end**. Cette API, tu l'utiliseras par le biais d'une application écrite en **Angular**, côté **front-end** donc. 


Une chanson devra posséder les propriétés suivantes: 


- id :**number** - l'identifiant de la chanson en BDD
- name :**string** - le nom de la chanson
- artist :**string** - le nom de l'artiste 
- album :**string** - le nom de l'album associé à la chanson
- img :**string** - l'url d'une image représentant la chanson


## Critères de validation 


- Tu dois commiter le projet **front** dans le dossier éponyme
- Tu dois commiter le projet **back** dans le dossier éponyme
- Les deux projets doivent être accompagnés d'un fichier **readme.txt** contenant les instructions nécessaires à leur mise en place/compilation
- Une fois démarrés, les deux projets, front et back, fonctionnent parfaitement ensemble. 


## BONUS !
Les points suivants peuvent être ajoutés en fonction du temps qu'il te reste : 


- L'upload de fichiers 
- La sécurisation de tes endpoints (token + apikey + gestion utilisateurs)
- L'authentification (gestion utilisateurs + rôles)




## Nota Bene 
N'oublie pas que ce checkpoint est avant tout un moyen pour t'auto-évaluer, si tu n'arrives pas à tout refaire, c'est tout à fait normal.
