#!/bin/bash

echo "#################################################"
echo "#        Création de l'application jar          #"
echo "#                     &                         #"
echo "#          Génération de la javadoc             #"
echo "#################################################"


javac -Xlint:unchecked -encoding UTF-8 -sourcepath src/ -d bin/ src/BatailleNavale/View/MainView.java
cp -R bin/BatailleNavale .

jar cvfm BatailleNavale.jar META-INF/MANIFEST.MF BatailleNavale/ src/
rm -R BatailleNavale/
chmod 777 BatailleNavale.jar

echo "##############################################"
echo "#            Fin de l'opération              #"
echo "##############################################"

