#!/bin/bash

echo "#################################################"
echo "#        Création de l'application jar          #"
echo "#                     &                         #"
echo "#          Génération de la javadoc             #"
echo "#################################################"

rm -rf bin/
mkdir bin/
javac -Xlint:unchecked -encoding UTF-8 -sourcepath src/ -d bin/ src/BatailleNavale/View/MainView.java
cp -R bin/BatailleNavale .

jar cvfm BatailleNavale.jar META-INF/MANIFEST.MF BatailleNavale/ src/ images/
rm -R BatailleNavale/
chmod 777 BatailleNavale.jar

if [ "$1" = "-javadoc" ];
then
	cd src/
	javadoc -encoding ISO-8859-1 -private BatailleNavale.Controller BatailleNavale.View BatailleNavale.Model BatailleNavale.Model.Flotte 		BatailleNavale.Model.Joueur -d ../doc/

	wc BatailleNavale/View/*.java BatailleNavale/Controller/*.java BatailleNavale/Model/*.java BatailleNavale/Model/Flotte/*.java BatailleNavale/Model/Joueur/*.java
	wc BatailleNavale/View/*.java BatailleNavale/Controller/*.java BatailleNavale/Model/*.java BatailleNavale/Model/Flotte/*.java BatailleNavale/Model/Joueur/*.java | wc -l

	cd ..
fi

java -jar BatailleNavale.jar

echo "##############################################"
echo "#            Fin de l'opération              #"
echo "##############################################"

