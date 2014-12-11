#TextAnalyzer
This web application peforms very simplistic (actually useless) analysis of input text.  Specifically, the input text is run through a series of analyzers and returns a List of Analysis results.  In theory, the analyzers could be much more sophisticated/useful, but for now they are extremely simple.  This application uses DropWizard and requires Java 8 (due to streaming/lamda expressions)

The current Analysers are:
* IdentityAnalyzer: Returns the input text unchanged.
* SummaryAnalyzer: Counts characters and words from input text.
* MoneyWordAnalyzer: Identifies words in which the characters (case-insensitive) add up to 100, given A=1,B=2,...Z=26 (some sample dollar words include: pumpkin, chimpanzee, telephone)

Additional notes can be found [here](docs/notes.md)

##Pre-reqs:
* Java 8
* Maven 3.x
* (optional) Browser plugin to post to web services (e.g. poster).  This app supports GET, so you don't actually need this...

##To Build the software:
mvn 

##To Run the server:
./startServer.sh

## Application links:
When the server is running:
* click [here](http://localhost:8080/app/index.html) for a simple html form post.
* click [here](http://localhost:8080/text-analyzer) for the default TextAnalyzer link (JSON) or [here](http://localhost:8080/text-analyzer/html) for HTML.

## Admin Links:
When the server is running, click [here](http://localhost:8081) for the Admin link

##Sample JSON Output (http://localhost:8080/text-analyzer)
[{"analyzerName":"IdentityAnalyzer","analysisMap":{"ORIGINAL_TEXT":"posting some text to get primary dollar words"}},{"analyzerName":"SummaryAnalyzer","analysisMap":{"TOTAL_WORDS":"8","TOTAL_CHARACTERS":"38"}},{"analyzerName":"MoneyWordAnalyzer","analysisMap":{"TOTAL_COST":"529","DOLLAR_WORDS":"[posting, primary]"}}]

## Sample HTML Output (http://localhost:8080/text-analyzer/html)
        <h1>TextAnalyzer Output (mustache):</h1>
        <h2>
            <ul> IdentityAnalyzer :  {ORIGINAL_TEXT=posting some text to get primary dollar words}</ul>
            <ul> SummaryAnalyzer :  {TOTAL_WORDS=8, TOTAL_CHARACTERS=38}</ul>
            <ul> MoneyWordAnalyzer :  {TOTAL_COST=529, DOLLAR_WORDS=[posting, primary]}</ul>
         </h2>    

