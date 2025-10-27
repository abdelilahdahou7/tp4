# TP Hibernate/MySQL

Ce projet est une implémentation d'un TP utilisant Hibernate pour la persistance des données avec une base de données MySQL.
Il gère deux entités principales : `Salle` et `Machine`, avec une relation One-to-Many entre elles.

## Structure du projet

- `pom.xml`: Fichier de configuration Maven avec les dépendances Hibernate, MySQL Connector et JUnit 5.
- `src/main/java/org/example/entities`: Contient les classes d'entité `Entity`, `Salle` et `Machine`.
- `src/main/java/org/example/dao`: Contient l'interface générique `IDao` et ses implémentations `SalleDao` et `MachineDao`.
- `src/main/java/org/example/services`: Contient les services `SalleService` et `MachineService` pour la logique métier.
- `src/main/java/org/example/util/HibernateUtil.java`: Classe utilitaire pour la gestion de la SessionFactory Hibernate.
- `src/main/resources/hibernate.cfg.xml`: Fichier de configuration Hibernate pour la connexion à la base de données MySQL.
- `src/main/java/org/example/Main.java`: Classe principale pour démontrer les fonctionnalités CRUD et les requêtes spécifiques.
- `src/test/java/org/example`: Contient les tests unitaires pour `SalleService` et `MachineService`.

## Prérequis

- Java Development Kit (JDK) 8 ou supérieur
- Apache Maven
- Serveur MySQL en cours d'exécution

## Configuration de la base de données

Le fichier `src/main/resources/hibernate.cfg.xml` est configuré pour se connecter à une base de données MySQL nommée `hibernate_db` sur `localhost:3306` avec l'utilisateur `root` et un mot de passe vide. La base de données sera créée automatiquement si elle n'existe pas (`createDatabaseIfNotExist=true`).

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_db?createDatabaseIfNotExist=true</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password"></property>
```

Assurez-vous que ces informations correspondent à votre configuration MySQL.

## Compilation et exécution

Pour compiler le projet :

```bash
mvn clean install
```

Pour exécuter la classe principale de démonstration :

```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Pour exécuter les tests unitaires :

```bash
mvn test

<img width="1580" height="716" alt="image" src="https://github.com/user-attachments/assets/ec03a1c9-3161-479a-bb68-18aa940b7880" />

```
