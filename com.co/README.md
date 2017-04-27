## CapitalOne Transaction report.


#### How to build:
should use Maven compile and package command create jar file.

maven clean package


#### How to exceute
Below command should start the HTTP
java -jar CapitalOne.jar


#### How to Connect
Should use default port 8080 to connect.

eg. httpL//localhost:8080/


### Note
- The external API call is store but not the code is not optimize for speed
- use url query (?api=true) to recall API

### CapitalOne API
Three endpoint is available
- getmonthlyaverage -> this endpoint to calculate monthly total average 
- getmonthlyspentIncomeavg -> this endpoint to calculate monthly spent and income average 
- getignorecc -> this endpoint to calculate average ignoring "Credit card" transaction.

#### Response
sample response:


```
{
  "2014-10": "$420761.00",
  "2014-11": "$-140866.00",
  "2014-12": "$-136304.00",
  ...
```