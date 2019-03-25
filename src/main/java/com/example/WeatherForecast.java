package com.example;

public class WeatherForecast {         

            public String dateFormatted;
            public int temperatureC;
            public String summary;
            public int temperatureF;

             public WeatherForecast(String dateFormatted, int temperatureC, String  summary,int temperatureF) {
                this.dateFormatted = dateFormatted;
                 this.temperatureC = temperatureC;
                 this.summary = summary;
                 this.temperatureF=temperatureF;
            }          

            public String DateFormatted() {
                return dateFormatted;
            }           

            public int TemperatureC() {
                return temperatureC;
            }          

            public String Summary() {
                return summary;
            }

            public int TemperatureF()
            {
               return 32 + (int)(temperatureC / 0.5556);
            }
        }
