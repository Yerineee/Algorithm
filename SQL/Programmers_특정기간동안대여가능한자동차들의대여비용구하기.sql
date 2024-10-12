-- 1. 자동차 종류가 '세단' 또는 'SUV' 인 자동차 중
-- 2. 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능하고
-- 3. 30일간의 대여 금액이 50만원 이상 200만원 미만인 자동차에 대해서
-- 자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트를 출력

SELECT CAR.CAR_ID,
    CAR.CAR_TYPE,
    ROUND(CAR.DAILY_FEE*30*(1-DISCOUNT.DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR AS CAR
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY AS RENTAL ON CAR.CAR_ID = RENTAL.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS DISCOUNT ON CAR.CAR_TYPE = DISCOUNT.CAR_TYPE

WHERE RENTAL.START_DATE<='2022-11-30' AND RENTAL.END_DATE>='2022-11-01' -- 2022년 11월에 대여 가능
AND CAR.CAR_TYPE IN ('세단', 'SUV') -- '세단' 또는 'SUV'인 자동차
AND DISCOUNT.DURATION_TYPE='30일 이상' -- 30일간의 대여 기간

GROUP BY CAR.CAR_ID
HAVING FEE >= 500000 AND FEE<2000000 -- 대여 금액이 50만원 이상 200만원 미만
ORDER BY FEE DESC, CAR.CAR_TYPE, CAR.CAR_ID DESC;
