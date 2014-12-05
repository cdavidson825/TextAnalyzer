TextAnalyzer
===

Sample text analyzer using DropWizard.  Nothing really good to see here yet.

To Build
---
mvn

To Run HealthCheck
---
java -jar target/cwd-textanalyzer-1.0-SNAPSHOT.jar check text-analyzer.yml


To Run server
---
target/cwd-textanalyzer-1.0-SNAPSHOT.jar server text-analyzer.yml

[local link] (http://localhost:8080/text-analyzer?text=test)
