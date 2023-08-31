# quotes

## Description

This Java application will  grab quotes from an API s and randomly selects and adds a quote to our quotes.json.

- getQuoteFromApi
This method establishes an HTTP connection to the quote API and fetches a random quote.

- readResponseFromApi
This method reads the response from the API connection and parses the JSON data to extract a random quote. 
If the API request fails, it attempts to fetch a quote from the local JSON file as a fallback.

- addQuoteToFile
This method adds a new quote to the JSON file. It takes the author, body, favorites count,
and tags of the quote as input and appends the new quote to the existing list of quotes in the JSON file.

- readQuotesFromFile
This method reads quotes from the JSON file. It returns an array of Quote objects parsed from the JSON content. 
If the file is not found or there is an error while reading, an empty array is returned.

- loadQuotesFromFile
This method loads quotes from the JSON file. It reads the JSON content and returns a list of Quote objects. 
If the file is not found or there is an error while reading, a runtime exception is thrown.

- Error Handling
The app includes error handling for cases where fetching from the API fails or reading from the JSON file encounters an issue.
If fetching from the API fails, the app attempts to retrieve a quote from the local JSON file as a fallback. 
If both the API and the file reading fail, the app throws a runtime exception.


## how to install the dependency

- This project requires the Gson library for JSON parsing. You can download the library and add it to the gradle.build dependency using this
implementation 'com.google.code.gson:gson:2.10.1'.
- Run the Application: Compile and run the App.java file to generate and display a random quote.
