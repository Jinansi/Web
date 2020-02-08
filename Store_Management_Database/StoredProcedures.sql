
delimiter %%
Create PROCEDURE viewExpiredProducts()
BEGIN 
	select * from products where  productExpiryDate <= CURDATE();
end

Delimiter %%
Call viewExpiredProducts();

Delimiter **
Create procedure getSalesbyMode()
begin
    select paymentmode , SUM(totalPrice) from payment where paymentmode = 'Credit';
    select paymentmode , SUM(totalPrice) from payment where paymentmode = 'Debit';
    select paymentmode , SUM(totalPrice) from payment where paymentmode = 'Cash';
    select paymentmode , SUM(totalPrice) from payment where paymentmode = 'EBT';
end **
DELIMITER ;
Call getSalesbyMode;

Delimiter **
Create procedure getMaxSaleMonth()
begin
    select monthname(paymentDate) ,Year(paymentDate), count(paymentDate) as NoOfTimes from payment Group By paymentDate order by NoOfTimes DESC LIMIT 1;
end **
DELIMITER ;

Call getMaxSaleMonth;

Delimiter **
Create procedure getEmpSales(IN Id int) 
begin
	select EmpFname, EmpLname,staffmember.EmpId, Sum(payment.totalPrice) AS EmpSales from staffmember INNER JOIN  payment
   ON staffmember.EmpId = Payment.Empid AND staffmember.EmpId = Id group by EmpFname,EmpLname;
end **
DELIMITER ;
call getEmpSales(4);

delimiter %%
Create PROCEDURE viewProductsExpiryDate()
BEGIN 
	select productId,productName,productExpiryDate from products where  productExpiryDate >= CURDATE() ORDER BY productExpiryDate;
end

Delimiter %%

call viewProductsExpiryDate;

Delimiter **
Create procedure getProducts(IN departmentName varchar(20)) 
begin
    select productName,productId from products Join department ON departmentId = deptId
    where department.deptname = departmentName;
end **

call getProducts('Frozen foods');
 



