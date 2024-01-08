-- typical subquery
SELECT
	InvoiceDate,
	BillingAddress,
	BillingCity,
	Total
FROM
	Invoice
WHERE Total<
	(SELECT
		avg(Total)
	FROM
		Invoice)
ORDER BY
	Total DESC