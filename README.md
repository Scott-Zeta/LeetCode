# MySQL_Crash_Course

https://www.linkedin.com/learning-login/share?forceAccount=false&redirect=https%3A%2F%2Fwww.linkedin.com%2Flearning%2Fsql-essential-training-20685933%3Ftrk%3Dshare_ent_url%26shareId%3DRrIjT2c6TA2IzOG9BOXL6w%253D%253D

## SELECT
for column

## From
for table

## AS
for customize the column name

## ORDER BY
order by, can be ```ASC``` and ```DESC```

## LIMIT
LIMIT + x
limit the result with x lines
head()

## WHERE
fillter with operator
```
WHERE
 total = 1.98
```
from 1.98 to 5
```
WHERE
 total BETWEEN 1.98 AND 5
```
Excatly 1.98 or 3.6?
```
WHERE
 total IN(1.98, 3.6)
```

## LIKE
not exact match result
(case insensitive)
Billing city start with B
```
WHERE
 BillingCity LIKE 'B%'
```

## DATE
only care about the date but not include the time
```
DATE(timeColumn) = '2023-03-26'
```

## AND, OR
logic operator

time after this day, and total less than 3
```
WHERE
DATE(timeColumn) > '2023-03-26' AND total < 3.00
```

## CASE THEN ELSE
if else statement
``` 
SELECT 
    FirstName, 
    LastName, 
    Company, 
    Country, 
    CASE 
        WHEN Country = 'USA' THEN 'Local' 
        ELSE 'Global' 
    END AS Region 
FROM 
    Customer 
ORDER BY 
    Region 
```