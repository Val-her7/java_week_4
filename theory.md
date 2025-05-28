# 🧩 IoC et DI en Java : Guide avec exemples

## 🔁 1. Qu'est-ce que l'IoC (Inversion of Control) ?

L’Inversion of Control est un principe selon lequel **le contrôle de la création et de la gestion des objets est inversé** : ce n’est plus vous (le développeur) qui gérez la création des dépendances, mais un **conteneur externe**.

---

## 🧪 2. Qu’est-ce que la DI (Dependency Injection) ?

La **Dependency Injection (DI)** est une manière d’implémenter l’IoC. On fournit ("injecte") à un objet ses dépendances **depuis l’extérieur**, au lieu de les créer lui-même.

### Types d'injection :
- 🧱 Par **constructeur** (@Autowire pas obligé)
- 🧰 Par **setter** (@Autowire obligé)
- 🧩 Par **field** (@Autowire obligé)

---

## ❌ Exemple SANS DI (couplage fort)

```java
class Moteur {
    public void demarrer() {
        System.out.println("Moteur démarre !");
    }
}

class Voiture {
    private Moteur moteur = new Moteur(); // Couplage fort

    public void demarrer() {
        moteur.demarrer();
    }
}
```
➡ Ici, Voiture crée elle-même le Moteur. C’est difficile à tester ou à remplacer.

## ✅ Exemple AVEC DI (couplage faible - constructeur)

```java
class Moteur {
    public void demarrer() {
        System.out.println("Moteur démarre !");
    }
}

class Voiture {
    private Moteur moteur;

    // Injection via le constructeur
    public Voiture(Moteur moteur) {
        this.moteur = moteur;
    }

    public void demarrer() {
        moteur.demarrer();
    }
}

public class Main {
    public static void main(String[] args) {
        Moteur moteur = new Moteur();
        Voiture voiture = new Voiture(moteur); // Injection ici
        voiture.demarrer();
    }
}
```
➡ Plus facile à tester, à remplacer, ou à faire évoluer !

## ⚙️ Exemple avec Spring boot(IoC Container)

```java
@Component
class Moteur {
    public void demarrer() {
        System.out.println("Moteur Spring !");
    }
}

@Component
class Voiture {
    private final Moteur moteur;

    @Autowired
    public Voiture(Moteur moteur) {
        this.moteur = moteur;
    }

    public void demarrer() {
        moteur.demarrer();
    }
}

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        Voiture voiture = context.getBean(Voiture.class);
        voiture.demarrer();
    }
}
```
➡ Spring se charge de créer et injecter automatiquement les objets.

## 🧩 Fonctionnement des Beans Spring

### 🔁 Par défaut : Singleton

Spring crée **un seul objet (bean) par type**, partagé dans tout le conteneur.

```java
@Component
public class Engine {
    public Engine() {
        System.out.println("Engine instance: " + this);
    }
}
```
Même si plusieurs objets dépendent de Engine, ils recevront la même instance.

### 🔁 Prototype: nouvelle instance à chaque demande

```java
@Component
@Scope("prototype")
public class Engine { }
```

## Choix entre plusieurs options

Par exemple, on créé une interface computer et des classes laptop et desktop qui implémentent cette interface. Cela permet de faire du loose coupling en utilisant computer à la place de hard code laptop ou desktop. Le problème est comment spring doit choisir le bon?

### Solution avec @Primary
```java
@Component
@Primary
// en cas de confusion, cette classe sera préférée
```

### Solution avec @Qualifier
```java
@Autowired
@Qualifier("laptop")
Computer computer;
// à utiliser avec un field injection en spécifiant le nom de l'instance de la classe (Bean name) (= nom de la classe sans majuscules)
```

## 🌱 Spring Framework: XML config vs Annotations

### 📦 1. Configuration XML

#### ✅ Avantages
- Séparation claire entre configuration et logique métier.
- Vue centralisée des beans.
- Adaptée aux classes tierces (non modifiables).

#### ⚙️ Exemple
```xml
<bean id="myService" class="com.example.MyService">
    <property name="repository" ref="myRepo"/>
</bean>

<bean id="myRepo" class="com.example.MyRepository"/>
```
#### 🔍 Utilisation
```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
MyService service = context.getBean("myService");
```

### 🧩 2. Configuration par Annotations

#### ✅ Avantages
- Moins de code, plus lisible.

- Compatible avec Spring Boot.

- Détection automatique des composants.

#### ⚙️ Exemple
```java
@Component
public class MyRepository {}

@Service
public class MyService {
    @Autowired
    private MyRepository repository;
}
```
#### 🔍 Utilisation
```java
@Configuration
@ComponentScan("com.example")
public class AppConfig {}

ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
MyService service = context.getBean(MyService.class);
```
