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
