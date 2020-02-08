
select * from stockKeepingUnit where skuId = 1;

create trigger tr_update_data AFTER Insert ON payment FOR EACH ROW 
update  stockKeepingUnit  JOIN  orderitem ON orderitem.productId = stockKeepingUnit.skuProductId 
JOIN payment ON payment.orderId = orderitem.orderId
set skuQuantity = skuQuantity - orderitem.productQuantity; 


create trigger tr_update_sku after Insert ON stockAdded FOR each row
Update  stockKeepingUnit Join stockAdded ON stockAdded.skuid = stockKeepingUnit.skuId 
set stockKeepingUnit.skuQuantity = stockKeepingUnit.skuQuantity + QuantityAdded ;


create View All_customer_data AS 
select concat(custFname, ' ' , custLname) As Customername , custAddress,Orders.orderId , orderDate, paymentId 
from
customer INNER join  Orders  ON customer.customerId = orders.customerId Inner Join payment ON 
payment.CustId = customer.CustomerId Group by Customername;

select * from All_customer_data;

create View All_product_data AS 
select productname, count(orderitem.productId) AS totalProductOrdered , skuQuantity, skuid from products LEFT JOIN 
stockkeepingunit on stockkeepingunit.skuproductId = products.productId JOIN orderitem ON 
orderitem.productId = products.productId group by productName order by totalProductOrdered DESC;

select * from All_product_data;
