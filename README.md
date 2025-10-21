# TP : De Monolithe à Microservice avec Spring Boot

## 1. Introduction

### Contexte
Ce TP fait suite au précédent exercice sur Hibernate. Nous allons prendre les concepts de base (entités, persistance) et les faire évoluer vers une architecture microservice moderne, robuste et scalable en utilisant le framework Spring Boot.

L'objectif est de transformer notre application de gestion de parc de machines en un service de persistance autonome, exposant ses fonctionnalités via une API REST. Cela permet à d'autres services (applications web, mobiles, autres microservices) de consommer les données de manière sécurisée et standardisée.

### Architecture Cible
Nous allons mettre en place l'architecture suivante :

- **Couche de Contrôleurs (Controllers)** : Des contrôleurs REST qui exposent les points d'entrée (endpoints) de notre API pour les opérations CRUD (Créer, Lire, Mettre à jour, Supprimer).
- **Couche de Service (Services)** : Contient la logique métier (validation, calculs, etc.). Elle est transactionnelle pour garantir l'intégrité des données.
- **Couche d'Accès aux Données (Repositories)** : Gérée par Spring Data JPA, cette couche simplifie à l'extrême les interactions avec la base de données.
- **Couche de Domaine (Entities)** : Nos objets Java (POJOs) qui représentent les tables de la base de données.

Voici un schéma simplifié de l'architecture :

```
+-----------------+      +-----------------+      +-----------------+
|  Client REST    |----->|   Controllers   |----->|     Services    |
| (Postman, App)  |      |  (API Endpoints)|      | (Logique Métier)| 
+-----------------+      +-----------------+      +-----------------+
                                                        |
                                                        v
+-----------------+      +-----------------+      +-----------------+
|   Base de données |<-----|   Repositories  |<-----|     Entités     |
|   (PostgreSQL)  |      | (Spring Data JPA)|      |      (JPA)      |
+-----------------+      +-----------------+      +-----------------+

## 2. Structure Finale du Projet

```
lab154/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ma/
│   │   │       └── projet/
│   │   │           ├── Lab154Application.java
│   │   │           ├── controllers/
│   │   │           │   ├── MachineController.java
│   │   │           │   ├── MaintenanceController.java
│   │   │           │   ├── SalleController.java
│   │   │           │   └── TechnicienController.java
│   │   │           ├── dao/
│   │   │           │   ├── MachineRepository.java
│   │   │           │   ├── MaintenanceRepository.java
│   │   │           │   ├── SalleRepository.java
│   │   │           │   └── TechnicienRepository.java
│   │   │           ├── entities/
│   │   │           │   ├── Machine.java
│   │   │           │   ├── Maintenance.java
│   │   │           │   ├── Salle.java
│   │   │           │   └── Technicien.java
│   │   │           └── services/
│   │   │               ├── MachineService.java
│   │   │               ├── MaintenanceService.java
│   │   │               ├── SalleService.java
│   │   │               └── TechnicienService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── ma/
│               └── projet/
│                   └── SalleControllerTest.java
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

## 3. Déploiement avec Docker

1.  **Construire l'application** : Assurez-vous que Docker est en cours d'exécution, puis à la racine du projet, lancez la commande Maven pour packager votre application en un fichier JAR.

    ```bash
    mvn clean package
    ```

2.  **Lancer les conteneurs** : Utilisez Docker Compose pour construire l'image de votre application et lancer les conteneurs de l'application et de la base de données.

    ```bash
    docker-compose up --build
    ```

Votre microservice sera alors accessible à l'adresse `http://localhost:8080`.
```
