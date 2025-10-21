# TP Java Hibernate : Gestion d'un parc de machines avec PostgreSQL

## 1. Introduction

### Contexte
Ce Travail Pratique (TP) vise à construire une application Java pour gérer un parc de machines, où chaque machine est assignée à une salle. L'objectif principal est de maîtriser la persistance des données en utilisant l'ORM Hibernate avec une base de données PostgreSQL.

### Objectifs du TP
- Configurer un projet Java/Maven pour intégrer Hibernate et PostgreSQL.
- Mettre en œuvre une architecture en couches (Services, DAO, Entités).
- Maîtriser les annotations JPA pour le mapping objet-relationnel.
- Gérer les sessions et les transactions Hibernate.
- Écrire des tests unitaires robustes avec JUnit.

### Choix de PostgreSQL
PostgreSQL a été choisi pour ce TP en raison de ses nombreux avantages :
- **Open Source et Gratuit** : C'est un système de gestion de base de données relationnel-objet puissant et entièrement gratuit.
- **Robustesse et Fiabilité** : Réputé pour sa stabilité, sa conformité aux standards SQL et sa gestion avancée des transactions (ACID).
- **Extensibilité** : Supporte une grande variété de types de données (JSON, XML, géospatiales...) et permet de définir des types et des fonctions personnalisés.
- **Fonctionnalités Avancées** : Offre des fonctionnalités avancées comme l'héritage de tables, le partitionnement et un contrôle de la concurrence sophistiqué (MVCC).
C'est un excellent choix pour des applications d'entreprise nécessitant fiabilité et scalabilité.

## 2. Conseils d’exécution

### Prérequis
- Avoir un serveur PostgreSQL installé et accessible.
- Avoir créé une base de données (par exemple, `tp_hibernate`).

### Configuration locale de PostgreSQL
Si vous avez PostgreSQL en local, vous pouvez créer un utilisateur et une base de données avec les commandes suivantes via l'interpréteur `psql` :

```sql
-- Crée un nouvel utilisateur avec un mot de passe
CREATE USER mon_user WITH PASSWORD 'mon_mot_de_passe';

-- Crée une nouvelle base de données
CREATE DATABASE tp_hibernate OWNER mon_user;
```

N'oubliez pas de mettre à jour les propriétés `connection.username` et `connection.password` dans le fichier `hibernate.cfg.xml` avec ces informations.

### Utiliser une base de données Cloud (ElephantSQL)
ElephantSQL est un service qui fournit des bases de données PostgreSQL hébergées.
1.  Créez un compte sur [ElephantSQL](https://www.elephantsql.com/).
2.  Créez une nouvelle instance (le plan gratuit "Tiny Turtle" est suffisant).
3.  Une fois l'instance créée, allez dans la page des détails. Vous y trouverez toutes les informations de connexion (Server, User & Default database, Password, Port).
4.  Composez l'URL JDBC à partir de ces informations. Elle ressemblera à ceci :
    `jdbc:postgresql://<server>:<port>/<user_&_default_database>`
5.  Mettez à jour le fichier `hibernate.cfg.xml` avec cette URL, ainsi que votre nom d'utilisateur et votre mot de passe.

### Lancer l'application et les tests
- **Via un IDE (IntelliJ, Eclipse...)** : Importez le projet en tant que projet Maven. L'IDE téléchargera les dépendances. Vous pourrez ensuite faire un clic droit sur le fichier `Main.java` et choisir "Run" pour exécuter la classe de test principale, ou faire un clic droit sur les classes de test dans `src/test/java` et choisir "Run" pour lancer les tests JUnit.
- **Via la ligne de commande Maven** : Assurez-vous que Maven est installé et configuré. Placez-vous à la racine du projet et exécutez les commandes suivantes :
    - `mvn clean install` : Pour compiler le projet et lancer les tests.
    - `mvn exec:java -Dexec.mainClass="org.example.Main"` : Pour exécuter la classe `Main` après la compilation.