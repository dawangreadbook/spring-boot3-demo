
request command

  curl -X POST -H "Content-Type: application/json" -d '{"isNightSurcharge":true, "distanceInMile":30}' http://127.0.0.1:8080/taxifare/calculate/

log

  2024-03-23T14:03:41.518+09:00  INFO 99578 --- [nio-8080-exec-9] org.example.RequestCachingFilter         : REQUEST DATA: {"isNightSurcharge":true, "distanceInMile":30}
  2024-03-23T14:03:41.521+09:00  INFO 99578 --- [nio-8080-exec-9] org.example.TaxiFareController           : calculateTaxiFare() - START
  2024-03-23T14:03:41.521+09:00  INFO 99578 --- [nio-8080-exec-9] org.example.TaxiFareController           : calculateTaxiFare() - Total Fare : 400
  2024-03-23T14:03:41.522+09:00  INFO 99578 --- [nio-8080-exec-9] org.example.TaxiFareController           : calculateTaxiFare() - END

