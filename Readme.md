# Build a SOAP Architecture

Ce projet permet la mise en place d'un service SOAP et simule un outil de gestion de location de livre qui serait accessible à des utilisateurs

## Architecture

Une base de données PostgreSQL.
Un web service SOAP permettant : 
L’identification des usagers via un identifiant et un mot de passe,
De remonter les disponibilités des ouvrages, de gérer les prêts (nouveau prêt, prolongation, retour de prêt, état des prêts en cours / prolongés / non rendus à temps...)

Une application web, basée sur le Framework Apache Struts 2, servant d’interface pour les utilisateurs. Elle ne doit pas se connecter à la base de données, tout passe par le webservice.

Un batch qui envoie un mail de relance aux usagers n’ayant pas rendu les ouvrages dont la période de prêt est terminée. Il ne doit pas se connecter à la base de données, tout passe par le web service.

## Structure du projet

Cette application se compose de trois programmes.
 
Le premier est un Web Service SOAP développé à l’aide du Framework Spring. Cet outil gère toutes les interfaces avec la base de données PostgreSQL. L’accès à ce programme est assuré par un fichier WSDL et des Endpoint associés.

Le second programme est développé à partir du Framework Struts 2. Il développe une interface web permettant de se connecter aux fonctionnalités du web service SOAP. Il permet ainsi d’accéder au système de location de livre et de réserver des livres.

Le troisième programme est un batch utilisant le Framework Spring Batch permettant d’accéder aux livres non rendus dans les temps afin d’envoyer un mail et de relancer utilisateurs n’ayant pas rendu leurs livres dans les temps.

Cette application pourrait être accessible à d’autres application se connectant au Webservice. Ainsi, des applications mobiles pourraient par exemple se connecter à cet outil.

### Installation

A step

## Deploiement

Pour initialiser cette application, vous devez installer successivement les trois applications de ce projet.

La base de données est créée grâce à l'application docker-compose. Les fichiers de création de la BDD sont contenus dans le dossier spring-boot-soap. La commande docker-compose up permet d'initier la base de donnée.

La première application à installer est le web service. Pour se faire déployez votre serveur tomcat et installez le fichier WAR (Spring-boot-SOAP.war). Si vous le souhaitez, vous pouvez modifier l'application et la repackager via le fichier pom.xml. Les fichiers de configuration sont le fichier pom.xml, le fichier wsdl et le fichier application.properties de spring.

Une fois le Web Service déployé, vous pouvez packager le client struts en installant le fichier Book.war sur le serveur de votre choix. Le client est également packagé sous forme de WAR. Les fichiers de configuration sont le fichier pom.xml, le fichier wsdl et le fichier application.properties de spring.

Concernant les batchs, il sont accessibles sous forme de deux fichiers jar et peuvent être lancé via la commande : java -jar BatchEmail-0.1.0.jar.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Contributeurs

Maximilien LeBoiteux alias ToyTheRusse : https://github.com/Toysurusse

Ce projet est libre de droit et disponible gratuitement : https://github.com/Toysurusse/Projet-10.git

## License

This project is open source

