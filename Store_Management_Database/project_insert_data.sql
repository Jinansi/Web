use storemanagement;

insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (1, 'Leontyne', 'Shimoni', '83-349-6846', '6 Killdeer Trail', 'Waxwing', 'Fort Wayne', 'Indiana', '2015-07-28', '2017-07-17',200);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (2, 'Mata', 'Oakden', '00-601-7177', '4049 Menomonie Crossing', 'Gerald', 'Vancouver', 'Washington', '2017/03/17', null,400);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (3, 'Marcellus', 'Becerro', '63-677-7333', '58 Fair Oaks Road', 'Springview', 'Shawnee Mission', 'Kansas', '2016/8/27', '2017/10/7',500);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (4, 'Thorpe', 'Hartright', '91-378-5829', '621 Green Circle', 'Melody', 'San Diego', 'California', '2016/12/01', null,300);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (5, 'Roze', 'Beaze', '63-607-4316', '66 Merchant Drive', 'Kings', 'Oklahoma City', 'Oklahoma', '2017/11/02', '2017/6/30',200);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (6, 'Kalila', 'Jermey', '40-838-5631', '55 Dexter Point', 'Spohn', 'Houston', 'Texas', '2017/02/22', null,100);
insert into StaffMember (Empid, EmpFname, EmpLname, EmpcontactNo, EmpAddress1, EmpStreet, EmpCity, EmpState, Empjoiningdate, Empleavingdate,EmpSalary) values (7, 'Marina', 'Meeron', '99-312-1436', '77 Dennis Place', 'Del Sol', 'Chattanooga', 'Tennessee', '2016/08/27', null,400);

select * from staffmember;

insert into EmpShift (EmployeeId, starttime, endtime) values (1, '2017-10-22 03:23:24', '2017-10-22 09:00:56');
insert into EmpShift (EmployeeId, starttime, endtime) values (2, '2016-06-24 06:17:11', '2016-06-24 23:23:46');
insert into EmpShift (EmployeeId, starttime, endtime) values (3, '2017-10-31 18:34:24', '2017-10-31 19:09:56');
insert into EmpShift (EmployeeId, starttime, endtime) values (4, '2017-03-10 09:28:06', '2017-03-17 17:55:06');
insert into EmpShift (EmployeeId, starttime, endtime) values (5, '2017-01-15 10:27:10', '2017-01-15 15:29:06');
insert into EmpShift (EmployeeId, starttime, endtime) values (6, '2017-03-07 14:49:47', '2017-03-07 16:16:34');
insert into EmpShift (EmployeeId, starttime, endtime) values (7, '2017-06-21 13:37:07', '2017-06-21 17:08:55');
insert into EmpShift (EmployeeId, starttime, endtime) values (1, '2017-12-08 09:02:04', '2017-12-08 12:15:28');
insert into EmpShift (EmployeeId, starttime, endtime) values (2, '2017-06-05 12:40:20', '2017-06-05 19:28:14');
insert into EmpShift (EmployeeId, starttime, endtime) values (3, '2017-02-06 06:38:11', '2017-02-06 12:26:29');
insert into EmpShift (EmployeeId, starttime, endtime) values (4, '2017-07-23 13:47:10', '2017-07-23 15:42:06');
insert into EmpShift (EmployeeId, starttime, endtime) values (5, '2016-12-20 03:24:43', '2016-12-20 05:14:29');
insert into EmpShift (EmployeeId, starttime, endtime) values (6, '2017-05-11 01:53:01', '2017-05-11 16:10:17');
insert into EmpShift (EmployeeId, starttime, endtime) values (7, '2017-01-04 02:52:47', '2017-01-04 13:06:01');
insert into EmpShift (EmployeeId, starttime, endtime) values (1, '2017-12-06 15:59:52', '2017-12-06 18:12:51');

select * from empshift;

insert into Department (deptId, deptName) values (1, 'Frozen Foods');
insert into Department (deptId, deptName) values (2, 'Drinks');
insert into Department (deptId, deptName) values (3, 'Vegetables');
insert into Department (deptId, deptName) values (4, 'Dairy Products');
insert into Department (deptId, deptName) values (5, 'Snacks');
insert into Department (deptId, deptName) values (6, 'Games');
insert into Department (deptId, deptName) values (7, 'Industrial');
insert into Department (deptId, deptName) values (8, 'Beauty');
insert into Department (deptId, deptName) values (9, 'Health');
insert into Department (deptId, deptName) values (10, 'Clothing');

insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (1, 'CRH PLC', '813-926-4947', '03437 Huxley Trail', '18142 Hansons Crossing', 'Tampa', 'Florida', '33620');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (2, 'Socket Mobile, Inc.', '814-776-1223', '86409 Express Crossing', '18967 Clove Center', 'Erie', 'Pennsylvania', '16550');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (3, 'Female Health Company (The)', '713-303-6075', '7 Village Green Plaza', '44 Summerview Place', 'Houston', 'Texas', '77218');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (4, 'Lancaster Colony Corporation', '309-309-2229', '217 Manley Lane', '852 Rusk Way', 'Peoria', 'Illinois', '61640');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (5, 'Forum Merger Corporation', '304-477-3839', '9150 Luster Parkway', '541 Ridgeway Road', 'Charleston', 'West Virginia', '25313');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (6, 'Lantronix, Inc.', '540-918-3853', '981 Southridge Court', '82232 Artisan Circle', 'Roanoke', 'Virginia', '24034');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (7, 'First Emerging Opportunity', '503-819-2683', '0967 Crescent Oaks Alley', '14547 Brentwood Way', 'Portland', 'Oregon', '97216');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (8, 'Sunoco LP', '317-402-6632', '4299 Clemons Terrace', '9 Pepper Wood Lane', 'Indianapolis', 'Indiana', '46231');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (9, 'Churchill Downs, Incorporated', '801-696-2269', '073 Gerald Terrace', '0 Fairfield Crossing', 'Salt Lake City', 'Utah', '84115');
insert into Supplier (supplierId, supplierName, SupplierContactNo, supplierAddress1, supplierstreet, suppliercity, supplierState, Zipcode) values (10, 'FIT Corporation', '239-715-1720', '96 Golf View Terrace', '80 Golf Course Pass', 'Fort Myers', 'Florida', '33994');

select * from supplier;

select * from customer;
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (1, 'Gilberte', 'Bunworth', '61697 Atwood Road', '79436 Gateway Plaza', 'Drobin', '09-210');
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (2, 'Fredericka', 'McLarty', '6788 Manufacturers Drive', '5 Caliangt Hill', 'Sabugo', '2715-364');
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (3, 'Lenci', 'Scane', '29 Bunting Lane', '3711 Prairie Rose Parkway', 'MÃ­thymna', null);
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (4, 'Gillian', 'Teodoro', '829 Vernon Court', '5 Riverside Parkway', 'BanzÃ£o', '2705-137');
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (5, 'Davidson', 'Flaunier', '58905 Southridge Circle', '3600 Summit Hill', 'TÃ¡nh Linh', null);
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (6, 'Celestina', 'Hulburt', '3780 Hooker Circle', '764 Myrtle Park', 'VukatanÃ«', null);
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (7, 'Judie', 'Mayo', '6953 Troy Drive', '1 Melrose Parkway', 'Nago', '917-0011');
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (8, 'Vallie', 'Penswick', '40078 Esch Street', '03 Old Gate Lane', 'Ore', null);
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (9, 'Valli', 'Langland', '04410 Del Sol Crossing', '5514 Lerdahl Road', 'XÃªgar', null);
insert into Customer (CustomerId, custFName, custLname, custAddress, custstreet, custcity, customerZipcode) values (10, 'Marnia', 'Dallender', '6973 6th Hill', '28 School Road', 'Milano', '20125');


select * from products;
delete from products;
describe products;
insert into products values (1, 'Cheese', '664113625-6', 'http://dummyimage.com/230x146.png/5fa2dd/ffffff', 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', 1,'2016-01-12','2019-01-12');
insert into products values (2, 'Muffin', '498758058-6', 'http://dummyimage.com/234x159.bmp/5fa2dd/ffffff', 'Maecenas tristique, est et tempus semper.', 2,'2016-01-12','2019-01-12');
insert into products  values (3, 'Pastry Tea', '797100420-6', 'http://dummyimage.com/180x142.png/dddddd/000000', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci.', 3,'2016-01-12','2017-10-12');
insert into products values (4, 'Mushroom Fresh', '333266112-4', 'http://dummyimage.com/209x107.jpg/ff4444/ffffff', 'Duis aliquam convallis nunc. Proin at turpis a pede posuere nonummy. Integer non velit.', 4,'2016-01-12','2017-12-12');
insert into products values (5, 'Wine Valley', '468303267-8', 'http://dummyimage.com/112x145.bmp/dddddd/000000', 'Vestibulum ac est lacinia nisi vene.', 5,'2017-01-12','2020-01-12');
insert into products  values (6, 'Soup Campbells', '108421064-9', 'http://dummyimage.com/135x188.jpg/ff4444/ffffff', 'Integer ac leo.Nulla suscipit ligula in lacus.', 6,'2016-01-12','2018-01-12');
insert into products  values (7, 'Contreau', '628712225-0', 'http://dummyimage.com/122x151.jpg/cc0000/ffffff', 'Nullam sit amet turpis elementum ligula vehicula pellentesque volutpat dui.', 7,'2016-01-12','2016-09-12');
insert into products  values (8, 'Asparagus -Green', '329004721-0', 'http://dummyimage.com/215x240.bmp/5fa2dd/ffffff', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Ut at dolor quis odio consequat varius.', 8,'2016-01-12','2021-01-12');
insert into products values (9, 'Tray - Foam', '627514520-X', 'http://dummyimage.com/131x142.bmp/dddddd/000000', 'Praesent blandit. Nam nulla. Integer pede justo, lacinia eget,sem.', 9,'2016-01-12','2019-03-12');
insert into products  values (10, 'Wine - Redchard', '662573405-5', 'http://dummyimage.com/174x152.png/cc0000/ffffff', 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', 10,'2016-01-12','2019-01-12');
insert into products  values (11, 'Chocolate Marble Tea', '168204293-6', 'http://dummyimage.com/229x233.jpg/ff4444/ffffff', 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla..', 1,'2016-01-12','2017-08-10');
insert into products  values (12, 'Ice Cream Bar', '929262769-4', 'http://dummyimage.com/136x136.png/cc0000/ffffff', 'Phasellus sit amet erat. Nulla tempus.', 2,'2016-01-12','2019-01-12');
insert into products values (13, 'Shredded Cheese', '833622688-5', 'http://dummyimage.com/213x250.bmp/5fa2dd/ffffff', 'Integer . In est risus, auctor sed, tristique in, tempus sit amet, sem.', 3,'2016-01-12','2021-01-12');
insert into products  values (14, 'Tea Leaves - Oolong', '245692973-X', 'http://dummyimage.com/137x234.png/dddddd/000000', 'Duis bibendum. Morbi non quam nec dui', 4,'2017-02-12','2019-01-12');
insert into products  values (15, 'Soup - Broccoli', '164312817-5', 'http://dummyimage.com/225x112.bmp/dddddd/000000', 'In quis justo. Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet.', 5,'2017-01-12','2022-01-12');
insert into products  values (16, 'Beef - Rib Roast', '202821857-6', 'http://dummyimage.com/108x234.png/dddddd/000000', 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', 6,'2016-01-12','2016-12-12');
insert into products  values (17, 'Bread - Corn', '010782707-7', 'http://dummyimage.com/227x188.bmp/5fa2dd/ffffff', 'Praesent blandit. Nam nulla.In est risus, auctor sed, tristique in, tempus sit amet, sem.', 7,'2016-01-12','2018-06-12');
insert into products  values (18, 'Bacardi Limon', '269220727-0', 'http://dummyimage.com/202x112.bmp/ff4444/ffffff', 'Aenean lectus.Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Vivamus in felis eu sapien cursus vestibulum.', 8,'2016-01-12','2017-12-30');
insert into products values (19, 'Limes', '484177076-3', 'http://dummyimage.com/154x223.bmp/5fa2dd/ffffff', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.', 9,'2016-01-12','2018-01-01');
insert into products  values (20, 'Cookie Dough', '167345359-7', 'http://dummyimage.com/164x142.jpg/5fa2dd/ffffff', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio,quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', 10,'2016-01-12','2018-03-12');

insert into suppliersdept values (1,1);
insert into suppliersdept values (1,2);
insert into suppliersdept values (2,3);
insert into suppliersdept values (2,4);
insert into suppliersdept values (3,1);
insert into suppliersdept values (4,4);
insert into suppliersdept values (4,5);
insert into suppliersdept values (5,1);
insert into suppliersdept values (6,6);
insert into suppliersdept values (7,7);
insert into suppliersdept values (7,8);
insert into suppliersdept values (8,7);
insert into suppliersdept values (9,8);
insert into suppliersdept values (10,9);
insert into suppliersdept values (10,10);

desc orders;
insert into orders values (1,'2017-10-01',1);
insert into orders values (2,'2017-10-01',1);
insert into orders values (3,'2017-01-11',2);
insert into orders values (4,'2017-05-21',3);
insert into orders values (5,'2017-10-11',4);
insert into orders values (6,'2017-11-09',3);
insert into orders values (7,'2017-11-04',6);
insert into orders values (8,'2017-04-08',7);

desc orderitem;
select * from orders;
select * from orderitem;
insert into orderitem values (1,2,1,1);
insert into orderitem values (2,1,1,1);
insert into orderitem values (3,3,2,2);
insert into orderitem values (4,5,2,3);
insert into orderitem values (5,3,3,4);
insert into orderitem values (6,8,3,5);
insert into orderitem values (7,1,4,6);
insert into orderitem values (8,2,4,7);
insert into orderitem values (9,2,4,8);

select * from stockkeepingunit;
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (1, 10, 1);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (2, 20, 2);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (3, 30, 3);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (4, 40, 4);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (5, 50, 5);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (6, 23, 6);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (7, 70, 7);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (8, 20, 8);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (9, 10, 9);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (10, 15, 10);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (11, 12, 11);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (12, 15, 12);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (13, 5, 13);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (14, 20, 14);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (15, 20, 15);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (16, 1, 16);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (17, 6, 17);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (18, 18, 18);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (19, 19, 19);
insert into StockKeepingUnit (skuId, skuQuantity, skuProductId) values (20, 20, 20);

select * from stockkeepingunit;
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (1, 1, 10, '2017-02-12 05:56:49');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (2, 2, 20, '2017-04-11 05:20:34');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (3, 3, 30, '2017-02-17 11:44:35');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (4, 4, 40, '2017-10-12 16:14:23');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (5, 5, 50, '2017-08-26 09:21:08');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (6, 6, 13, '2017-07-13 21:23:53');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (7, 7, 15, '2017-02-02 15:57:38');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (8, 8, 12, '2017-08-23 08:39:46');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (9, 9, 9, '2017-08-02 20:10:43');
insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (10, 10, 10, '2017-03-12 18:33:28');

insert into stockAdded (skuId, supplierId, QuantityAdded, stockAddedDate) values (10, 10, 10, curdate());

select * from payment;
delete from payment; 
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (1, 1, 1, 'Credit', 8, 1,'2017-10-01');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (2, 1, 2, 'Debit', 69, 2,'2017-10-01');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (3, 2, 3, 'Cash', 15, 3,'2017-01-11');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (4, 3, 4, 'Cash', 83, 4,'2017-05-21');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (5, 4, 5, 'Debit', 75, 5,'2017-10-11');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (6, 3, 6, 'EBT', 45, 6,'2017-11-09');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (7, 3, 4, 'Debit', 45, 6,'2017-11-09');
insert into payment (paymentId, CustId, OrderId, paymentmode, totalPrice, EmpId,paymentDate) values (8, 3, 4, 'Debit', 45, 6,'2017-11-09');
