# GovApps Suite
GovApps is a platform that provides users the opportunity to find mobile apps in public and private sources regionally and by priorities

## Requirements
 - Maven 2.x
 - Liferay 6.1.1-ga2
 - JDK 1.7
 
Note: Portlets will not build without parent GovApps suite.

## Build
mvn clean package

## Installation/Deployment
Copy all files from the specific modules at <portlet>/target/*.war to the
liferay deploy folder <liferay-root>/deploy

## License
See LICENSE in the specific portlet folders.