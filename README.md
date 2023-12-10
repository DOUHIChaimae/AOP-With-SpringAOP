## Programmation Orientée Aspect (AOP) avec Spring AOP

### 1. Introduction
La Programmation Orientée Aspect (AOP) complète la Programmation Orientée Objet (OOP) en fournissant une autre manière de penser à la structure d'un programme. L'unité clé de modularité en OOP est la classe, tandis qu'en AOP, l'unité de modularité est l'aspect. Les aspects permettent la modularisation des préoccupations (telles que la gestion des transactions) qui traversent plusieurs types et objets. (Ces préoccupations sont souvent appelées préoccupations transversales dans la littérature sur l'AOP.)<br>

***Spring AOP*** utilise soit des proxies dynamiques JDK, soit CGLIB pour créer le proxy d'un objet cible donné. Pour utiliser les proxies JDK, nous avons besoin d'au moins une interface, tandis qu'avec CGLIB, nous avons besoin d'une seule classe non final.<br>

Dans cette activité nous allons travailler sur l'applicattion suivante :<br>
![img_1.png](img_1.png)

### Ajout des dépendances nécessaires
Pour utiliser Spring AOP, nous devons ajouter les dépendances suivantes à notre fichier pom.xml :<br>
```xml

<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-core</artifactId>
        <version>5.2.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.2.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-beans</artifactId>
        <version>5.2.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aop</artifactId>
        <version>5.2.5.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-aspects</artifactId>
        <version>5.2.5.RELEASE</version>
    </dependency>
</dependencies>
```


