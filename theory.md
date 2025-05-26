# 🧩 IoC et DI en Java : Guide avec exemples

## 🔁 1. Qu'est-ce que l'IoC (Inversion of Control) ?

L’Inversion of Control est un principe selon lequel **le contrôle de la création et de la gestion des objets est inversé** : ce n’est plus vous (le développeur) qui gérez la création des dépendances, mais un **conteneur externe**.

---

## 🧪 2. Qu’est-ce que la DI (Dependency Injection) ?

La **Dependency Injection (DI)** est une manière d’implémenter l’IoC. On fournit ("injecte") à un objet ses dépendances **depuis l’extérieur**, au lieu de les créer lui-même.

### Types d'injection :
- 🧱 Par **constructeur**
- 🧰 Par **setter**
- 🧩 Par **interface** (moins courant)

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