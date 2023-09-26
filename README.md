####Projet de Gestion des Données Clients
Ce projet est une application Java Spring Boot destinée à gérer et analyser des données clients à partir de fichiers CSV, JSON, XML, et texte. L'application permet d'importer ces fichiers, d'identifier leur type, de les lire, d'extraire les informations pertinentes, de stocker les données dans une base de données MySQL, et d'effectuer des calculs statistiques tels que la moyenne des salaires par type de profession.

Fonctionnalités

### Importation de fichiers : L'application offre un endpoint pour importer des fichiers au format CSV, JSON, XML, ou texte.

### Identification du type de fichier : Une logique de détection automatique du type de fichier est mise en place en fonction de l'extension du fichier.

### Lecture de fichiers : Les fichiers sont lus en utilisant les bibliothèques appropriées telles que Apache Commons CSV, Jackson pour JSON, et JAXB pour XML.

### Extraction des données : Les données sont extraites des fichiers et transformées en objets Java.

### Sauvegarde des données : Les données sont stockées dans une base de données MySQL à l'aide de Spring Data JPA.

### Calculs statistiques : L'application peut calculer la moyenne des salaires par type de profession.

Prérequis
Assurez-vous d'avoir installé les outils suivants sur votre système :

Java JDK 11 ou supérieur
Spring Boot
MySQL
Postman (pour les tests)
#### Installation et Configuration

Clonez ce dépôt sur votre machine locale : git clone https://github.com/Ebenaruto/Agitex.git

Créez une base de données MySQL nommée gestion_clients (vous pouvez modifier le nom dans le fichier application.properties).

Configurez les informations de connexion à la base de données dans le fichier application.properties :

properties

spring.datasource.url=jdbc:mysql://localhost:3306/gestion_clients
spring.datasource.username=votre_utilisateur
spring.datasource.password=votre_mot_de_passe

Compilez et exécutez l'application à l'aide de Spring Boot :

./mvnw spring-boot:run
L'application sera accessible à l'adresse http://localhost:8080.

Utilisation
Importez un fichier en utilisant l'endpoint /uploadFile. Vous pouvez utiliser Postman pour tester cette fonctionnalité.

L'application identifiera automatiquement le type de fichier.

Les données seront extraites et stockées dans la base de données.

Vous pouvez effectuer des requêtes pour obtenir des statistiques, par exemple, pour obtenir la moyenne des salaires par type de profession.

Exemples de Requêtes API
Endpoint d'importation de fichiers :

http
POST http://localhost:8080/uploadFile
Assurez-vous d'inclure un fichier dans la requête.

Calcul de la moyenne des salaires par type de profession :

http
GET http://localhost:8080/stats/average-salary-by-profession

Auteur
OUEDRAOGO NAMEBA EBEN EZER MARTIAL
omartial30@gmail.com
https://github.com/Ebenaruto
