SELECT p.PRODUCT_ID, p.PRODUCT_NAME, p.PRICE * s.amounts TOTAL_SALES
FROM FOOD_PRODUCT p JOIN (
                            SELECT PRODUCT_ID, sum(AMOUNT) amounts
                            FROM FOOD_ORDER
                            WHERE YEAR(PRODUCE_DATE) = '2022'
                            AND MONTH(PRODUCE_DATE) = '5'
                            GROUP BY PRODUCT_ID
                         ) s
ON p.PRODUCT_ID = s.PRODUCT_ID
ORDER BY TOTAL_SALES DESC, p.PRODUCT_ID