# BTC Play App

This is a starter application that shows how Play works and can be effectively used to implement functionality.  Please see the documentation at <https://www.playframework.com/documentation/latest/Home> for more details.

## Running

Run this using [sbt](http://www.scala-sbt.org/). Go to the root of the project directory and execute via terminal:

```bash
sbt run
```

And then go to <http://localhost:9000> to see the running web application.


## Controllers

- `HomeController.scala`:

  Landing controller for root /

- `GetCustomDatesController.scala`:

  Controller for getting custom dates and visualizing the custom dates

- `MovingAverageController.scala`:

  Controller for calculating the moving average for custom dates and visualizing the moving averages

- `ForecastController.scala`:

  Controller for calculating the forecasted price for the custom forecast Date and recommending a trading decision based on the chosen trading strategy
  
## Models

- `BTCData.scala`:

  Logic for fetching and transforming the BTC data from the Coinbase API

- `forecast.scala`:

  Logic for forecasting the price and making a trading decision based on it


## Views

- `getCustomDates.scala.html`:

  Prompt for custom dates input via Play Form. Checks input against logic

- `getForecastDate.scala.html`:

  Prompt for custom to forecast date and trading strategy inputs via Play Form. Checks input against logic
  
- `visualize.scala.html`:

  Visualize given list of Dates against given list of Prices. Lists constructed via Scala logic and passed to Javascript as JSON objects
  
- `visualizeTradingDecision.scala.html`:

  Visualize Forecasted Price, Trading strategy & Trading decision
  
- `welcome.scala.html`:

  Show welcome text, an aside list of implemented functionality and visualize the entire BTC data for 1 year
