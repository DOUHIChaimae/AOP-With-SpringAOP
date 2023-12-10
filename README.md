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
On va créer une clsse MetierImpl qui implémente l'interface IMetier :<br>
```java
@Service
public class MetierImpl implements IMetier {
    @Override
    public void process() {
        System.out.println("Business process...");
    }

    @Override
    public double compute() {
        double data = Math.random();
        System.out.println("Business computing and returning");
        return data;
    }
}
```
### Exécution de l'application
```java
@ComponentScan(value = {"ma.enset.services", "ma.enset.aspects"})
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Application.class);

        IMetier metier = applicationContext.getBean(IMetier.class);
        System.out.println(metier.getClass().getName());
        metier.process();
        System.out.println("data = " + metier.compute());
    }
}
```

![img_2.png](img_2.png)

### Création d'un LogAspect
```java

@Component
@Aspect
@EnableAspectJAutoProxy
public class LogAspect {
    @Before("execution(public void process())")
    public void log() {
        System.out.println("From LogAspect: Log before process() ...");
    }
}
```
Dans cet aspect on ajoute les annotations suivantes :<br>
- @Component : pour que Spring puisse détecter cet aspect et le gérer comme un bean Spring.
- @Aspect : pour indiquer à Spring que c'est un aspect.
- @EnableAspectJAutoProxy : pour activer l'auto-proxying basé sur les annotations.


### Exécution de l'application

![img_3.png](img_3.png)

On constate que le nom de la classe de l'objet métier a changé, c'est parce que Spring a créé un proxy pour l'objet métier et a ajouté le code de l'aspect à ce proxy.

