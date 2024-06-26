#!/bin/bash

# Fonction pour vérifier et créer un répertoire si nécessaire
creer_repertoire() {
    local repertoire="$1"
    if [ ! -d "$repertoire" ]; then
        mkdir "$repertoire"
        echo "Répertoire $repertoire créé."
    else
        echo "Répertoire $repertoire existe déjà."
    fi
}

# Vérifie et crée les répertoires doc et img s'ils n'existent pas
repertoires=("doc" "img")
for repertoire in "${repertoires[@]}"
do
    chemin_repertoire="$(pwd)/$repertoire"
    creer_repertoire "$chemin_repertoire"
done

# Répertoire source et destination pour la compilation Java
repertoire_source="./src"
repertoire_destination="./bin"

# Vérification et création du répertoire de destination
creer_repertoire "$repertoire_destination"

# Compilation des fichiers Java
echo "Compilation des fichiers Java..."
javac -d "$repertoire_destination" "$repertoire_source"/*.java
echo "Compilation terminée."

# Génération de la documentation et déplacement vers le répertoire doc
echo "Génération de la documentation..."
javadoc -d "./doc" "$repertoire_source"/*.java
echo "Documentation générée."

# Recherche de la classe exécutable
classe_executable="$1"
if [ -z "$classe_executable" ]; then
    echo "Aucune classe exécutable donnée en argument."
else
    # Lancement du programme Java
    echo "Lancement du programme Java..."
    java -cp "$repertoire_destination" "$classe_executable"
fi

# Commande de compilation
javac -d out -cp lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar src/main/java/com/cdal/*.java src/test/java/com/cdal/*.java

# Commande d'execution
java -cp out:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar main.java.com.cdal.Executable

# Commande de test 
java --module-path /usr/share/openjfx/lib/ -javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp out:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path out