
Create Database StoreManagement;

use StoreManagement;

show tables;

/* Create table staff member and EmployeeShift*/

show tables;
Create table Staffmember( 
EmpId int PRIMARY KEY auto_increment,
EmpFname varchar(40) NOT NULL,
EmpLname varchar(40) NOT NULL,
EmpContactNo int,
EmpAddress1 varchar(40) NOT NULL,
EmpStreet varchar(30),
EmpCity varchar(40) NOT NULL,
EmpState varchar(40) NOT NULL,
EmpJoiningDate DATE NOT NULL,
EmpLeavingDate date);


Create table EmpShift(EmployeeId int NOT NULL, starttime datetime NOT NULL, endtime datetime NOT NULL, 
foreign key(EmployeeId) references staffmember (EmpId)); 

Alter table EmpShift add constraint PK_Id primary key (EmployeeId,starttime,endtime);

create table Department (deptId int primary key auto_increment, deptName varchar(30) not null);

create table supplier (supplierId int primary key auto_increment, supplierName varchar(30),
SupplierContactNo int,
SupplierAddress1 varchar(40) NOT NULL,
SupplierStreet varchar(30),
SupplierCity varchar(40) NOT NULL,
SupplierState varchar(40) NOT NULL);

Alter table customer Add  customerZipcode varchar(11);
Alter table Supplier Modify Column SupplierContactNo char(35);

alter table staffmember Add column EmpSalary double NOT NULL;

alter table staffmember modify EmpContactNo varchar(22);

create table customer (CustomerId int Primary Key auto_increment,
custFname varchar(30) NOT NULL,
custLname varchar(30) NOT NULL,
custAddress varchar(40),
custStreet varchar(40),
custCity varchar(20),
custPaymentMode varchar(30) NOT NULL);

/* customer payment constraint */

describe customer;
insert into customer values (2,'Jinansi','Thakkar','Landmark Square','Peterborough St','Boston','new');

Alter table customer drop column custPaymentMode;
select * from customer;
ALTER TABLE Orders ENGINE=InnoDB;

create table Orders ( orderId int Primary key AUTO_INCREMENT, orderDate date NOT NULL, customerId int NOT NULL);
Alter table Orders Add constraint fk_orders foreign key (customerId)  References  customer(CustomerId);
create table OrderItem (orderItemId int primary key,productName varchar(30) NOT NULL, productQuantity int NOT NULL,orderid int); 

describe orderitem;


Alter table orderitem Add Constraint fk_order_product foreign key (orderId) references Orders(orderID);
Alter table orderitem add column orderId int NOT NULL;

create table products(productId int primary key auto_increment,
productName varchar(20) NOT NULL,
productBrand varchar(20),
productCode varchar(15) NOT NULL,
productPicture varchar(150),
productDescription varchar(200),
departmentId int not null,
foreign key(departmentId) references  Department(deptId));

alter table products add column productExpiryDate date;
create table StockKeepingUnit (
skuId int primary key,
skuQuantity int NOT NULL);

desc stockkeepingunit;
create table stockAdded(
skuId int NOT NULL, stockAdded datetime NOT NULL , supplierID int NOT NULL);

alter table stockAdded Add column QuantityAdded int NOT NULL;

alter table stockkeepingunit add column skuproductId  int NOT NULL;
Alter table stockkeepingunit Add Constraint fk_product_id foreign key (skuproductId) references Products(productId);
Alter table stockAdded Add Constraint fk_add_supplier_id foreign key (supplierID) references Supplier(supplierID);

describe  stockAdded;
alter table stockAdded drop column stockadded ;
alter table stockAdded add column stockAddedDate datetime;

create table SuppliersDept(
supplierId int NOT NULL,departmentId int NOT NULL,
 Foreign key (supplierId) references Supplier (supplierId), 
 foreign key (departmentId)  references department(deptId));
 
describe payment;
drop table payment;
create table payment(
paymentId int primary key,
CustId int NOT NULL,
OrderId int not null,
paymentmode ENUM ('Credit','Debit','EBT','Cash'),
paymentDate datetime,
totalPrice double NOT NULL,
EmpId int NOT NULL,
Foreign key (CustId) references Customer(customerId),
foreign key (OrderId) references Orders(orderId),
foreign key (EmpId) references staffmember(EmpId));

Alter table payment
Add Constraint CHK_pay CHECK (paymentmode = 'Debit' OR paymentmode = 'Credit' OR paymentmode = 'EBT' OR paymentmode ='Cash');


