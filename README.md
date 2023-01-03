# WeatherForecastApp

"Uses the openweathermap 5 day/3 hour forecast API. Updates information for each city through the API every 3 minutes and stores it in the database. If it is not necessary to update, it directly accesses the database.

## Architecture

The architecture was based on the example provided in the statement. There is only one entity that stores objects or lists of JSON. Converters are used for each type of object/class in order to store in the database. The information collected from the JSON for the database is only the essential (city name, minimum/maximum temperature, description...) that is displayed in the UI.

## Functionality

The application allows you to search for cities and get the weather information for each of them over a period of 5 days.

## Limitations

Ideally, it would have access to the openweathermap 16 day/daily forecast (paid) API because the temperature data is related to the day. The JSON is more compact and does not overload the database. Thus, in the database, there are all records every 3 hours of each day and only one of these is displayed in the UI, not properly reflecting the data for the entire day."
