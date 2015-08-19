# GovApps Portlet
This portlet is part of the GovApps Suite to build a directory of apps
in the spririt of the former www.govapps.de

## Requirements
 * Maven 2.x
 * Liferay 6.1.1-ga2
 * JDK 1.7
 
Note: Portlets will not build without parent GovApps suite.

## Build
mvn clean package

## Installation/Deployment
Copy target/*.war to the liferay deploy folder <liferay-root>/deploy

## License
See LICENSE