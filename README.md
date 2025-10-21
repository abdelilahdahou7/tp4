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
