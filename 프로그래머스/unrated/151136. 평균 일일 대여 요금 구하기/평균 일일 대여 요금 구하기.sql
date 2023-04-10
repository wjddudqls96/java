SELECT ROUND(AVG(DAILY_FEE), 0) as AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
GROUP BY CAR_TYPE
HAVING CAR_TYPE = 'SUV'