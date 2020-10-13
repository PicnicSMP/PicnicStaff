# SpigotPluginTemplate
A template project for starting new spigot plugin projects.

## Getting Started
### Preperation
- Eclipse IDE (For Java) [https://www.eclipse.org/downloads/packages/]
- A JRE ([8](https://www.oracle.com/java/technologies/javase-jre8-downloads.html) or [above](https://jdk.java.net/))

### Setup
* Clone the project, and checkout `main`.
* Import the project into Eclipse.
* Build the project. The first build will take some time because it will download Spigot BuildTools and compile the spigot jar.
* Select Run, And run as `Spigot`.

## Versioning
To Keep it simple we'll be using a flavour of [semver](https://semver.org/); MAJOR.MINOR.PATCH-BUILD where;
- The BUILD will be the serialised date of the jar was built (i.e. 24/09/2020 would be build 24092020).
- PATCH will be set to 0 when MINOR is incremented, and will be incremented when bugs are fixed.
- MINOR will be set to 0 when MAJOR is incremented, and will be incremented when a new feature is added.
- MAJOR will be incremented when a command available in game changes in a non-backward compatible way or a programming api the plugin exposes changes in a non-backward compatible way.
