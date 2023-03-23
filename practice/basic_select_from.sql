-- basic SELECT (for column)and FROM (for table)syntax

SELECT
	FirstName,
	LastName,
	Email AS 'Email Address'
FROM
	Customer
ORDER BY
	FirstName ASC,
	LastName DESC
LIMIT 10