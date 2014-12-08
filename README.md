#TextAnalyzer
Sample text analyzer using DropWizard.  Nothing really good to see here yet.

#To Build
mvn 

#To Run HealthCheck
java -jar target/cwd-textanalyzer-1.0-SNAPSHOT.jar check text-analyzer.yml

#To Run server
java -jar target/cwd-textanalyzer-1.0-SNAPSHOT.jar server text-analyzer.yml

When running server, click [here] (http://localhost:8080/text-analyzer) for the local URL

#JSON Output
[{"analyzerName":"cwd.ta.app.analyzer.SummaryAnalyzer","analysisMap":{"TOTAL_WORDS":"8","ORIGINAL_TEXT":"posting some text to get primary dollar words","TOTAL_CHARACTERS":"45"}},{"analyzerName":"cwd.ta.app.analyzer.MoneyWordAnalyzer","analysisMap":{"DOLLAR_WORDS":"[posting, primary]"}}]

