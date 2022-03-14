# Wine-breakdown

## What is it?

Wine breakdown - API

there are four endpoints:

- /api/breakdown/year/{lotCode} - breakdown of TOTAL percentage by year
- /api/breakdown/variety/{lotCode} - breakdown of TOTAL percentage by variety
- /api/breakdown/region/{lotCode} - breakdown of TOTAL percentage by region
- /api/breakdown/year-variety/{lotCode} - breakdown of TOTAL percentage by year + variety combination

Available LotCode are:

- 11YVCHAR001
- 11YVCHAR002
- 15MPPN002-VK


## How to run it?

1. Download the breakdown folder into local.

2. Unzip the folder.

3. Access to breakdown folder using command line.

4. Run the application using below command
```
    java -jar /build/libs/breakdown-0.0.1-SNAPSHOT.jar
```  
5. After the server is running, go to browser

```
- Get a breakdown of the TOTAL percentage by year based on different lotCode 
http://localhost:8080/api/breakdown/year/{lotCode}

- Get a breakdown of the TOTAL percentage by variety based on different lotCode
http://localhost:8080/api/breakdown/variety/{lotCode}

- Get a breakdown of the TOTAL percentage by region based on different lotCode
http://localhost:8080/api/breakdown/region/{lotCode}

- Get a breakdown of the TOTAL percentage by year and variety based on different lotCode
http://localhost:8080/api/breakdown/year-variety/{lotCode}

```
If an invalid lotCode is provided, an error message will be shown in the browser.

