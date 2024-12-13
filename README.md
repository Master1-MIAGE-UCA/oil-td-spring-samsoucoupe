# Projet "Dice" - Gestion de lancés de dés avec Spring Boot

## Description

Le projet "Dice" est une application web développée avec Spring Boot, permettant de simuler des lancés de dés et de gérer l'historique des résultats dans une base de données H2. Cette application repose sur les principes fondamentaux de Spring Boot, tels que l'injection de dépendances, les services RESTful, les entités JPA et les repositories.

## Objectifs du projet

- Créer une application Spring Boot permettant de simuler des lancés de dés.
- Stocker l'historique des lancés dans une base de données H2.
- Implémenter des endpoints REST pour interagir avec l'application.
- Utiliser des bonnes pratiques de développement, telles que l'injection de dépendances et l'utilisation d'annotations Spring.

## Fonctionnalités

- **Simuler un lancé de dé** : Possibilité de lancer un dé ou plusieurs dés et obtenir les résultats.
- **Historique des lancés** : Tous les résultats des lancés de dés sont enregistrés dans la base de données avec des informations telles que le nombre de dés lancés, les résultats, et la date du lancé.
- **Endpoints REST** :
  - **`GET /rollDice`** : Lance un seul dé et retourne le résultat.
  - **`GET /rollDices/{X}`** : Lance X dés (X étant un paramètre dynamique) et retourne les résultats.
  - **`GET /diceLogs`** : Affiche l'historique des lancés de dés (résultats stockés dans la base de données).

## Technologies utilisées

- **Spring Boot** : Framework principal pour le développement de l'application.
- **H2 Database** : Base de données en mémoire pour stocker l'historique des lancés de dés.
- **Swagger (bonus)** : Documentation des API REST avec Swagger pour faciliter l'interaction avec l'application.
- **Lombok (bonus)** : Simplification du code grâce à la bibliothèque Lombok, pour générer automatiquement les getters, setters, constructeurs, etc.

## Configuration

1. Clonez ce repository sur votre machine locale :
   ```bash
   git@github.com:Master1-MIAGE-UCA/oil-td-spring-samsoucoupe.git
   ```

2. Accédez au dossier du projet :
   ```bash
   cd dice
   ```

3. Exécutez l'application Spring Boot avec Maven ou Gradle :
   ```bash
   ./mvnw spring-boot:run
   ```

4. L'application sera accessible à l'adresse suivante :
   ```bash
   http://localhost:8081
   ```

5. Vous pouvez accéder à la documentation de l'API à l'adresse :
   ```bash
   http://localhost:8081/swagger-ui.html
   ```

## Structure du projet

- **`src/main/java/com/example/dice/`** :
  - `DiceService.java` : Service responsable de la logique métier pour le lancé des dés et de l'enregistrement des résultats.
  - `Dice.java` : Composant représentant un dé. Il gère le processus de lancement d'un dé et le calcul du résultat.
  - `DiceRollLog.java` : Entité JPA représentant un historique de lancé de dés, stockée dans la base de données.
  - `DiceRepository.java` : Repository permettant de gérer les interactions avec la base de données pour l'entité `DiceRollLog`.
  - `DiceController.java` : Contrôleur REST exposant les endpoints pour lancer des dés et afficher l'historique.
  
- **`src/main/resources/application.properties`** : Configuration de l'application, y compris le port d'écoute (8081) et la configuration de la base de données H2.

## Exemple d'utilisation des API

- **Lancer un seul dé** :
  ```bash
  GET http://localhost:8081/rollDice
  ```
  Réponse :
  ```json
  [4]
  ```

- **Lancer plusieurs dés** :
  ```bash
  GET http://localhost:8081/rollDices/5
  ```
  Réponse :
  ```json
  [3, 1, 5, 6, 2]
  ```

- **Obtenir l'historique des lancés de dés** :
  ```bash
  GET http://localhost:8081/diceLogs
  ```
  Réponse :
  ```json
  [
    {
      "id": 1,
      "diceCount": 3,
      "results": "[2, 5, 6]",
      "timestamp": "2024-12-13T10:15:00"
    },
    {
      "id": 2,
      "diceCount": 1,
      "results": "[4]",
      "timestamp": "2024-12-13T10:16:00"
    }
  ]
  ```

## Fonctionnalités bonus

- **Swagger** : Documentation de l'API avec Swagger, accessible à l'URL `http://localhost:8081/swagger-ui.html`.
- **Lombok** : Utilisation de Lombok pour éviter les boilerplate code (getters, setters, etc.).

## Structure de la base de données

La base de données H2 est utilisée pour stocker l'historique des lancés de dés. Elle contient une seule table `dice_roll_log` avec les colonnes suivantes :
- `id` : Identifiant unique du lancé de dé.
- `dice_count` : Nombre de dés lancés.
- `results` : Liste des résultats des lancés de dés sous forme de chaîne JSON.
- `timestamp` : Date et heure du lancé.

## Tests

Des tests unitaires et d'intégration peuvent être ajoutés pour valider le bon fonctionnement des services et des endpoints. Mais pas besoin pour le moment

---

*Merci d'avoir consulté ce projet !*

#### Samy ben dhiab
