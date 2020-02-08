/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Customer.CustomerAccount;
import business.Enterprise.EDEnterprise;
import business.Enterprise.Enterprise;
import business.Enterprise.SellerEnterprise;
import business.Enterprise.ShippingEnterprise;
import business.Inventory.Department;
import business.Inventory.DepartmentCatalog;
import business.Inventory.MasterProductCatalog;
import business.Inventory.Product;
import business.Inventory.SKU;
import business.Inventory.SKUHolder;
import business.Network.Network;
import business.Organization.CustomerOrganization;
import business.Organization.EmployeeOrganization;
import business.Organization.InventoryManagementOrganization;
import business.Organization.Organization;
import business.Organization.ShippingOrganization;
import business.Person.Address;
import business.Person.ContactDetails;
import business.Person.Person;
import business.Role.AdminRole;
import business.Role.CustomerRole;
import business.Role.SellerRole;
import business.Role.ShippingRole;
import business.Role.SystemAdminRole;
import business.UserAccount.UserAccount;
import business.WorkQueue.ProductOrderWorkRequest;
import business.WorkQueue.ShippingOrderWorkRequest;
import business.order.Order;
import business.order.OrderItem;
import java.util.Date;
import java.util.UUID;
import javax.swing.ImageIcon;

/**
 *
 * @author Gunjan
 */
public class ConfigureSystem {

    public static Ecosystem configure() {
        Ecosystem system = Ecosystem.getInstance();

        Network countryNetwork = new Network();
        countryNetwork.setName("USA");
        system.getNetworkDirectory().getNetworkList().add(countryNetwork);

        Network statenetwork = new Network();
        statenetwork.setName("MA");
        countryNetwork.getNetworkDirectory().getNetworkList().add(statenetwork);

        Network statenetwork1 = new Network();
        statenetwork1.setName("IL");
        countryNetwork.getNetworkDirectory().getNetworkList().add(statenetwork1);

        Network citynetNetwork4 = new Network();
        citynetNetwork4.setName("Chicago");
        statenetwork1.getNetworkDirectory().getNetworkList().add(citynetNetwork4);

        Network citynetNetwork5 = new Network();
        citynetNetwork5.setName("Naperville");
        statenetwork1.getNetworkDirectory().getNetworkList().add(citynetNetwork5);

        Network citynetNetwork = new Network();
        citynetNetwork.setName("Boston");
        statenetwork.getNetworkDirectory().getNetworkList().add(citynetNetwork);

        Network citynetNetwork1 = new Network();
        citynetNetwork1.setName("Cambridge");
        statenetwork.getNetworkDirectory().getNetworkList().add(citynetNetwork1);

        Network citynetNetwork2 = new Network();
        citynetNetwork2.setName("Belmont");
        statenetwork.getNetworkDirectory().getNetworkList().add(citynetNetwork2);

        Network citynetNetwork3 = new Network();
        citynetNetwork3.setName("Watertown");
        statenetwork.getNetworkDirectory().getNetworkList().add(citynetNetwork3);

        //System Admin
        Person person = system.getPersonDirectory().createEmployee("Admin", "Admin", 40);
        ContactDetails contactDetails = new ContactDetails("admin@gmail.com", "8572564435");
        person.setContactDetails(contactDetails);

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", person, new SystemAdminRole());
        system.getUserAccountDirectory().getUserAccountList().add(ua);
        system.getPersonDirectory().getPersonList().add(person);

        //Easy delivery enterprise
        EDEnterprise edenterprise = new EDEnterprise(Enterprise.EnterpriseType.EDENTERPRISE.getValue());
        countryNetwork.getEnterpriseDirectory().getEnterpriseList().add(edenterprise);
        Person edeperson = new Person("edeadmin", "ede", 21);
        UserAccount edeua = new UserAccount();
        edeua.setPerson(edeperson);
        edeua.setPassword("edeadmin");
        edeua.setUsername("edeadmin");
        edeua.setRole(new AdminRole());

        Address edeaddrs = new Address("49 hill road", "Belmont", "02478", "MA", "USA");
        edeua.setAddress(edeaddrs);
        edenterprise.getUserAccountDirectory().getUserAccountList().add(edeua);
        edenterprise.getPersonDirectory().getPersonList().add(edeperson);

        //Customer Organization
        CustomerOrganization custorg = new CustomerOrganization(Organization.Type.CustomerOrganization.getValue());
        edenterprise.getOrganizationDirectory().getOrganizationList().add(custorg);

        //Customer 1
        Person personCustomer = system.getPersonDirectory().createEmployee("customer", "c", 25);
        ContactDetails contactDetailsCustomer = new ContactDetails("gunjan.lalwani390@gmail.com", "8572654435");
        contactDetailsCustomer.setServiceprovider("AT&T");
        personCustomer.setContactDetails(contactDetailsCustomer);
        Address add = new Address("49 Hill Road", "Boston", "1245", "MA", "USA");
        UserAccount custACC = new CustomerAccount();
        custACC.setUsername("customer");
        custACC.setPassword("customer");
        custACC.setPerson(personCustomer);
        custACC.setRole(new CustomerRole());
        custACC.setAddress(add);
        custorg.getPersonDirectory().getPersonList().add(personCustomer);
        custorg.getUserAccountDirectory().getUserAccountList().add(custACC);
        
        //Employee Organization
        EmployeeOrganization emporgi = new EmployeeOrganization(Organization.Type.Employee.getValue());
        edenterprise.getOrganizationDirectory().getOrganizationList().add(emporgi);
        //Employee 1
        Person emporgperson = system.getPersonDirectory().createEmployee("customer", "c", 25);
        ContactDetails emporgcd = new ContactDetails("customer@gmail.com", "8572564435");
        emporgcd.setServiceprovider("AT&T");
        emporgperson.setContactDetails(emporgcd);
        Address emporgaddrs = new Address("49 Hill Road", "Belmont", "02478", "MA", "USA");
        UserAccount emporgua = new CustomerAccount();
        emporgua.setUsername("employee");
        emporgua.setPassword("employee");
        emporgua.setPerson(emporgperson);
        emporgua.setRole(new CustomerRole());
        emporgua.setAddress(emporgaddrs);
        emporgi.getPersonDirectory().getPersonList().add(emporgperson);
        emporgi.getUserAccountDirectory().getUserAccountList().add(emporgua);


        //Customer 2
        Person personCustomer2 = system.getPersonDirectory().createEmployee("customer2", "c2", 25);
        ContactDetails contactDetailsCustomer2 = new ContactDetails("customer2@gmail.com", "8572564435");
        personCustomer2.setContactDetails(contactDetailsCustomer2);
        Address add2 = new Address("sdfg", "Boston", "1245", "MA", "USA");
        UserAccount custACC2 = new CustomerAccount();
        custACC2.setUsername("customer2");
        custACC2.setPassword("customer2");
        custACC2.setPerson(personCustomer2);
        custACC2.setRole(new CustomerRole());
        custACC2.setAddress(add2);
        custorg.getPersonDirectory().getPersonList().add(personCustomer2);
        custorg.getUserAccountDirectory().getUserAccountList().add(custACC2);
        
        //Customer 3
        Person personCustomer3 = system.getPersonDirectory().createEmployee("customer3", "c3", 25);
        ContactDetails contactDetailsCustomer3 = new ContactDetails("customer3@gmail.com", "8572564435");
        personCustomer3.setContactDetails(contactDetailsCustomer3);
        Address add3 = new Address("sdfg", "Boston", "1245", "MA", "USA");
        UserAccount custACC3 = new CustomerAccount();
        custACC3.setUsername("customer3");
        custACC3.setPassword("customer3");
        custACC3.setPerson(personCustomer3);
        custACC3.setRole(new CustomerRole());
        custACC3.setAddress(add3);
        custorg.getPersonDirectory().getPersonList().add(personCustomer3);
        custorg.getUserAccountDirectory().getUserAccountList().add(custACC3);

        
        //Seller enterprise
        SellerEnterprise sellerEnterprise = new SellerEnterprise("ABC Seller Enterprise");
        countryNetwork.getEnterpriseDirectory().getEnterpriseList().add(sellerEnterprise);

        //Seller Admin
        Person sellerperson = new Person("selleradmin", "selleradmin", 21);
        UserAccount sellerua = new UserAccount();
        sellerua.setPerson(sellerperson);
        sellerua.setPassword("selleradmin");
        sellerua.setUsername("selleradmin");
        sellerua.setRole(new AdminRole());

        Address selleraddrs = new Address("433 W Harrison St", "Chicago", "60699", "IL", "USA");
        sellerua.setAddress(selleraddrs);
        sellerEnterprise.getUserAccountDirectory().getUserAccountList().add(sellerua);
        sellerEnterprise.getPersonDirectory().getPersonList().add(sellerperson);

        //Seller inventory org
        InventoryManagementOrganization org = new InventoryManagementOrganization("ABC Org");
        sellerEnterprise.getOrganizationDirectory().getOrganizationList().add(org);

        Person personSeller = org.getPersonDirectory().createEmployee("seller", "seller", 40);
        ContactDetails contactDetailsSeller = new ContactDetails("seller@gmail.com", "8572564435");
        personSeller.setContactDetails(contactDetailsSeller);
        UserAccount ua1 = org.getUserAccountDirectory().createUserAccount("seller", "seller", personSeller, new SellerRole());

        Address orgAdrs = new Address("433 W Harrison St", "Chicago", "60699", "IL", "USA");
        orgAdrs.setAddressLine2("Fl Lbby");
        org.setAddress(orgAdrs);
        org.setContactDetails(contactDetailsSeller);

        //seller enterprise 2
        SellerEnterprise sellerEnterprise2 = new SellerEnterprise("EFG Seller Enterprise");
        countryNetwork.getEnterpriseDirectory().getEnterpriseList().add(sellerEnterprise2);
        
        InventoryManagementOrganization org2 = new InventoryManagementOrganization("EFG Org");
        sellerEnterprise2.getOrganizationDirectory().getOrganizationList().add(org2);
        
        Person personSeller2 = org2.getPersonDirectory().createEmployee("seller2", "seller2", 40);
        ContactDetails contactDetailsSeller2 = new ContactDetails("seller2@gmail.com", "8572564435");
        personSeller2.setContactDetails(contactDetailsSeller2);

        UserAccount ua2 = org2.getUserAccountDirectory().createUserAccount("seller2", "seller2", personSeller2, new SellerRole());
        Address orgAdrs2 = new Address("49 hill road", "Belmont", "02478", "MA", "USA");
        org2.setAddress(orgAdrs2);

        //seller enterprise 3
        SellerEnterprise sellerEnterprise3 = new SellerEnterprise("123 Seller Enterprise");
        countryNetwork.getEnterpriseDirectory().getEnterpriseList().add(sellerEnterprise3);
        
        InventoryManagementOrganization org3 = new InventoryManagementOrganization("123 Org");
        sellerEnterprise3.getOrganizationDirectory().getOrganizationList().add(org3);
        
        Person personSeller3 = org3.getPersonDirectory().createEmployee("seller3", "seller3", 40);
        ContactDetails contactDetailsSeller3 = new ContactDetails("seller3@gmail.com", "8572564435");
        personSeller3.setContactDetails(contactDetailsSeller3);
        UserAccount ua3 = org3.getUserAccountDirectory().createUserAccount("seller3", "seller3", personSeller3, new SellerRole());

        Address orgAdrs3 = new Address("20 mission main road", "Belmont", "02478", "MA", "USA");
        ua3.setAddress(orgAdrs3);
        
        
        //Shiping enterprise 1
        ShippingEnterprise shippingEnterprise = new ShippingEnterprise("FEDEX");
        countryNetwork.getEnterpriseDirectory().getEnterpriseList().add(shippingEnterprise);

        Person shipperson = new Person("shipadmin", "shipadmin", 21);
        UserAccount shipua = new UserAccount();
        shipua.setPerson(shipperson);
        shipua.setPassword("shipadmin");
        shipua.setUsername("shipadmin");
        shipua.setRole(new AdminRole());

        Address shipaddrs = new Address("55 hill road", "Belmont", "02478", "MA", "USA");
        shipua.setAddress(shipaddrs);
        shippingEnterprise.getUserAccountDirectory().getUserAccountList().add(shipua);
        shippingEnterprise.getPersonDirectory().getPersonList().add(shipperson);
        
        //fedex org1
        ShippingOrganization shiporg = new ShippingOrganization("FEDEX Boston");
        shippingEnterprise.getOrganizationDirectory().getOrganizationList().add(shiporg);

        Address adres = new Address("117 Western Ave", "Boston", "02163", "MA", "USA");
        shiporg.setAddress(adres);
        Person shipperson1 = new Person("FEDex", "Shipping", 21);
        UserAccount uaship = new UserAccount();
        uaship.setUsername("shipper");
        uaship.setPassword("shipper");
        uaship.setPerson(shipperson1);
        uaship.setRole(new ShippingRole());

        shiporg.getUserAccountDirectory().getUserAccountList().add(uaship);
        shiporg.getPersonDirectory().getPersonList().add(shipperson1);

        //fedex  org2
        ShippingOrganization shiporg1 = new ShippingOrganization("FEDEX Chicago");
        shippingEnterprise.getOrganizationDirectory().getOrganizationList().add(shiporg1);
        Address adres2 = new Address("875 W Division St", "Chicago", "60642", "IL", "USA");
        shiporg1.setAddress(adres2);
        
        Person shipperson2 = new Person("USPS", "Shipping", 21);
        UserAccount uaship2 = new UserAccount();
        uaship2.setUsername("shipper2");
        uaship2.setPassword("shipper2");
        uaship2.setPerson(shipperson2);
        uaship2.setRole(new ShippingRole());

        shiporg1.getUserAccountDirectory().getUserAccountList().add(uaship2);
        shiporg1.getPersonDirectory().getPersonList().add(shipperson2);

        //fedex org3
        ShippingOrganization shiporg2 = new ShippingOrganization("FEDEX Waltham");
        shippingEnterprise.getOrganizationDirectory().getOrganizationList().add(shiporg2);
        Address adres3 = new Address("874 Lexington St", "Waltham", "02452", "MA", "USA");
        shiporg2.setAddress(adres3);
        Person shipperson3 = new Person("DHL", "Shipping", 45);
        UserAccount uaship3 = new UserAccount();
        uaship3.setUsername("shipper3");
        uaship3.setPassword("shipper3");
        uaship3.setPerson(shipperson3);
        uaship3.setRole(new ShippingRole());

        shiporg2.getUserAccountDirectory().getUserAccountList().add(uaship3);
        shiporg2.getPersonDirectory().getPersonList().add(shipperson3);

        //departments
        DepartmentCatalog departmentCatalog = system.getDepartmentCatalog();

        Department department1 = new Department("Electronics");
        Department laptopdept = new Department("Laptop");
        Department headPhoneDept = new Department("HeadPhones");
        Department driveDept = new Department("Drives And Storages");
        Department cameraDept = new Department("Camera, Photo and Video");
        department1.getDepartmentList().add(headPhoneDept);
        department1.getDepartmentList().add(driveDept);
        department1.getDepartmentList().add(cameraDept);
        department1.getDepartmentList().add(laptopdept);

        Department department2 = new Department("Appliances");
        Department mixerdept = new Department("Mixer");
        Department machinedept = new Department("Washing Machine");
        Department ovendept = new Department("Microwave Oven");
        department2.getDepartmentList().add(mixerdept);
        department2.getDepartmentList().add(machinedept);
        department2.getDepartmentList().add(ovendept);

        Department department3 = new Department("Clothing");
        Department menDept = new Department("Men");
        Department womenDept = new Department("Women");
        Department babyDept = new Department("Baby");
        department3.getDepartmentList().add(menDept);
        department3.getDepartmentList().add(womenDept);
        department3.getDepartmentList().add(babyDept);

        Department department4 = new Department("Sports");
        Department exerciseDept = new Department("Exercise and Fitness");
        Department athClothingDept = new Department("Athletic Cloting");
        Department cyclingDept = new Department("Cycling");
        Department winterDept = new Department("Winter Sports");
        department4.getDepartmentList().add(exerciseDept);
        department4.getDepartmentList().add(athClothingDept);
        department4.getDepartmentList().add(cyclingDept);
        department4.getDepartmentList().add(winterDept);

        Department department5 = new Department("Fresh Grocery");
        Department beverageDept = new Department("Beverages");
        Department foodDept = new Department("Frozen Foods");
        Department snackDept = new Department("Snack Foods");
        Department dairyDept = new Department("Dairy, Cheese and Eggs");
        department5.getDepartmentList().add(beverageDept);
        department5.getDepartmentList().add(snackDept);
        department5.getDepartmentList().add(foodDept);
        department5.getDepartmentList().add(dairyDept);

        departmentCatalog.getDepartmentList().add(department1);
        departmentCatalog.getDepartmentList().add(department2);
        departmentCatalog.getDepartmentList().add(department3);
        departmentCatalog.getDepartmentList().add(department4);
        departmentCatalog.getDepartmentList().add(department5);

        ImageIcon imageICO = new ImageIcon(ConfigureSystem.class.getResource("/images/laptop.jpeg"));
        Product pr = new Product("Macbook Air");
        pr.setPrice(500);
        pr.setModelNo("Q32");
        pr.setBrand("Apple");
        pr.setImage(imageICO);

        ImageIcon imageICO1 = new ImageIcon(ConfigureSystem.class.getResource("/images/laptop.jpeg"));
        Product pr1 = new Product("laptop 3201");
        pr1.setPrice(450);
        pr1.setModelNo("15024");
        pr1.setBrand("Dell");
        pr1.setImage(imageICO1);

        ImageIcon imageICO2 = new ImageIcon(ConfigureSystem.class.getResource("/images/laptop.jpeg"));
        Product pr2 = new Product("laptop 3501");
        pr2.setPrice(482);
        pr2.setModelNo("15214");
        pr2.setBrand("Lenovo");
        pr2.setImage(imageICO2);

        ImageIcon imageICO3 = new ImageIcon(ConfigureSystem.class.getResource("/images/laptop.jpeg"));
        Product pr3 = new Product("Acer Aspire 1");
        pr2.setPrice(200);
        pr2.setModelNo("A11311");
        pr2.setBrand("Acer");

        ImageIcon imageICO4 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr4 = new Product("Dell Inspiron 13");
        pr4.setPrice(600);
        pr4.setModelNo("D3311");
        pr4.setBrand("Dell");
        pr4.setImage(imageICO4);

        ImageIcon imageICO5 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr5 = new Product("Samsung Washing Machine");
        pr5.setPrice(105);
        pr5.setModelNo("328011");
        pr5.setBrand("Samsung");
        pr5.setImage(imageICO5);

        ImageIcon imageICO6 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr6 = new Product("LG Washing Machine");
        pr6.setPrice(105);
        pr6.setModelNo("328011");
        pr6.setBrand("Samsung");
        pr6.setImage(imageICO6);

        Product pr7 = new Product("Onkyo Speaker");
        pr7.setPrice(120);
        pr7.setModelNo("SD8011");
        pr7.setBrand("Onkyo");
        pr7.setImage(imageICO6);

        ImageIcon imageICO8 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr8 = new Product("JBL Arena B16");
        pr8.setPrice(90);
        pr8.setModelNo("NK8011");
        pr8.setBrand("JBL");
        pr8.setImage(imageICO8);

        ImageIcon imageICO9 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr9 = new Product("Segate BackUp plus 2 TB");
        pr9.setPrice(90);
        pr9.setModelNo("KNf8011");
        pr9.setBrand("Segate");
        pr9.setImage(imageICO9);

        ImageIcon imageICO10 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr10 = new Product("WD Blue 1 TB");
        pr10.setPrice(80);
        pr10.setModelNo("3820232");
        pr10.setBrand("WD PLUS");
        pr10.setImage(imageICO10);

        ImageIcon imageICO11 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr11 = new Product("Fuji Film x32");
        pr11.setPrice(80);
        pr11.setModelNo("HSK0023");
        pr11.setBrand("FujiFilm");
        pr11.setImage(imageICO11);

        Product pr12 = new Product("Canon EOS Rebel");
        pr12.setPrice(80);
        pr12.setModelNo("3820232");
        pr12.setBrand("Canon");

        ImageIcon imageICO13 = new ImageIcon(ConfigureSystem.class.getResource("/images/customer.jpg"));
        Product pr13 = new Product("Denim");
        pr13.setPrice(30);
        pr13.setModelNo("3820232");
        pr13.setBrand("Calvin Klien");
        pr13.setImage(imageICO13);
        

        Product pr14 = new Product("Shirt");
        pr14.setPrice(80);
        pr14.setModelNo("3820232");
        pr14.setBrand("Aeropostle");

        Product pr15 = new Product("Formal Shirt");
        pr15.setPrice(80);
        pr15.setModelNo("3820232");
        pr15.setBrand("Aeropostle");

        Product pr16 = new Product("Long Sleeve Tee");
        pr16.setPrice(80);
        pr16.setModelNo("3820232");
        pr16.setBrand("Aeropostle");

        Product pr17 = new Product("Rain Boot");
        pr17.setPrice(30);
        pr17.setModelNo("32ff");
        pr17.setBrand("Crocs");

        Product pr18 = new Product("Tropicana Orange Juice");
        pr18.setPrice(10);
        pr18.setModelNo("3820232");
        pr18.setBrand("Tropicana");

        Product pr19 = new Product("Almond Breeze");
        pr19.setPrice(10);
        pr19.setModelNo("3820232");
        pr19.setBrand("Organic Valley");

        Product pr20 = new Product("Breakfast Biscuits");
        pr20.setPrice(2);
        pr20.setModelNo("3820232");
        pr20.setBrand("Nature Valley");

        Product pr21 = new Product("Cheedar Snacks");
        pr21.setPrice(3);
        pr21.setModelNo("3820232");
        pr21.setBrand("Chex Mix");

        Product pr22 = new Product(" Classic Pepporoni Pizza");
        pr22.setPrice(8);
        pr22.setModelNo("3820232");
        pr22.setBrand("Red Baron");

        Product pr23 = new Product("Cheese Pizza");
        pr23.setPrice(2);
        pr23.setModelNo("3420232");
        pr23.setBrand("Nature Valley");

        Product pr24 = new Product("White Eggs");
        pr24.setPrice(3);
        pr24.setModelNo("38562");
        pr24.setBrand("Happy Belly");

        Product pr25 = new Product("Shredded Cheese");
        pr25.setPrice(2);
        pr25.setModelNo("FH820232");
        pr25.setBrand("Stella");
        pr25.setImage(imageICO3);

        Product pr27 = new Product("Kitchenaid Pro Line Stand");
        pr27.setBrand("Kitchenaid");
        pr27.setModelNo("Qw344");
        pr27.setPrice(89);

        
        MasterProductCatalog mpc = countryNetwork.getMasterProductCatalog();
        mpc.getProductList().add(pr);
        mpc.getProductList().add(pr1);
        mpc.getProductList().add(pr2);
        mpc.getProductList().add(pr3);
        mpc.getProductList().add(pr4);
        mpc.getProductList().add(pr5);
        mpc.getProductList().add(pr6);
        mpc.getProductList().add(pr7);
        mpc.getProductList().add(pr8);
        mpc.getProductList().add(pr9);
        mpc.getProductList().add(pr10);
        mpc.getProductList().add(pr11);
        mpc.getProductList().add(pr12);
        mpc.getProductList().add(pr13);
        mpc.getProductList().add(pr14);
        mpc.getProductList().add(pr15);
        mpc.getProductList().add(pr16);
        mpc.getProductList().add(pr17);
        mpc.getProductList().add(pr18);
        mpc.getProductList().add(pr19);
        mpc.getProductList().add(pr20);
        mpc.getProductList().add(pr21);
        mpc.getProductList().add(pr22);
        mpc.getProductList().add(pr23);
        mpc.getProductList().add(pr24);
        mpc.getProductList().add(pr25);
        mpc.getProductList().add(pr27);
        
        SKU sku1 = new SKU(pr1);
        sku1.setQuantity(45);

        SKU sku2 = new SKU(pr2);
        sku2.setQuantity(55);

        SKU sku = new SKU(pr);
        sku.setQuantity(100);

        SKU sku4 = new SKU(pr4);
        sku4.setQuantity(45);

        SKU sku5 = new SKU(pr5);
        sku5.setQuantity(45);

        SKU sku6 = new SKU(pr6);
        sku6.setQuantity(45);

        SKU sku7 = new SKU(pr7);
        sku7.setQuantity(45);

        SKU sku8 = new SKU(pr8);
        sku8.setQuantity(45);

        SKU sku9 = new SKU(pr9);
        sku9.setQuantity(35);

        SKU sku10 = new SKU(pr10);
        sku10.setQuantity(45);

        SKU sku11 = new SKU(pr11);
        sku11.setQuantity(45);
        SKU sku12 = new SKU(pr12);
        sku12.setQuantity(45);
        SKU sku13 = new SKU(pr13);
        sku13.setQuantity(45);
        SKU sku14 = new SKU(pr14);
        sku14.setQuantity(45);
        SKU sku15 = new SKU(pr15);
        sku15.setQuantity(45);
        SKU sku16 = new SKU(pr16);
        sku16.setQuantity(45);
        SKU sku17 = new SKU(pr17);
        sku17.setQuantity(45);
        SKU sku18 = new SKU(pr18);
        sku18.setQuantity(45);
        SKU sku19 = new SKU(pr19);
        sku19.setQuantity(45);
        SKU sku20 = new SKU(pr20);
        sku20.setQuantity(45);
        SKU sku21 = new SKU(pr21);
        sku21.setQuantity(45);

        SKU sku22 = new SKU(pr22);
        sku22.setQuantity(45);

        SKU sku23 = new SKU(pr23);
        sku23.setQuantity(45);
        SKU sku24 = new SKU(pr24);
        sku24.setQuantity(45);
        SKU sku25 = new SKU(pr25);
        sku25.setQuantity(27);

        SKU sku27 = new SKU(pr27);
        sku27.setQuantity(45);

        org.getSkuCatalog().addSKU(sku);
        org.getSkuCatalog().addSKU(sku1);
        org.getSkuCatalog().addSKU(sku2);
        org.getSkuCatalog().addSKU(sku4);
        org.getSkuCatalog().addSKU(sku5);
        org.getSkuCatalog().addSKU(sku6);
        org.getSkuCatalog().addSKU(sku7);
        org.getSkuCatalog().addSKU(sku8);
        org2.getSkuCatalog().addSKU(sku9);
        org2.getSkuCatalog().addSKU(sku10);
        org2.getSkuCatalog().addSKU(sku11);
        org2.getSkuCatalog().addSKU(sku12);
        org2.getSkuCatalog().addSKU(sku13);
        org2.getSkuCatalog().addSKU(sku14);
        org2.getSkuCatalog().addSKU(sku15);
        org2.getSkuCatalog().addSKU(sku16);
        org.getSkuCatalog().addSKU(sku17);
        org.getSkuCatalog().addSKU(sku18);
        org.getSkuCatalog().addSKU(sku19);
        org.getSkuCatalog().addSKU(sku20);
        org.getSkuCatalog().addSKU(sku21);
        org.getSkuCatalog().addSKU(sku22);
        org.getSkuCatalog().addSKU(sku23);
        org.getSkuCatalog().addSKU(sku24);
        org.getSkuCatalog().addSKU(sku25);
        org.getSkuCatalog().addSKU(sku27);

        laptopdept.getProductList().add(pr);
        laptopdept.getProductList().add(pr1);
        laptopdept.getProductList().add(pr2);
        laptopdept.getProductList().add(pr3);
        laptopdept.getProductList().add(pr4);

        machinedept.getProductList().add(pr5);
        machinedept.getProductList().add(pr6);

        headPhoneDept.getProductList().add(pr7);
        headPhoneDept.getProductList().add(pr8);

        driveDept.getProductList().add(pr9);
        driveDept.getProductList().add(pr10);

        headPhoneDept.getProductList().add(pr7);
        headPhoneDept.getProductList().add(pr8);

        headPhoneDept.getProductList().add(pr9);
        headPhoneDept.getProductList().add(pr10);

        cameraDept.getProductList().add(pr11);
        cameraDept.getProductList().add(pr12);

        menDept.getProductList().add(pr13);
        menDept.getProductList().add(pr14);

        womenDept.getProductList().add(pr15);
        womenDept.getProductList().add(pr16);

        beverageDept.getProductList().add(pr18);
        beverageDept.getProductList().add(pr19);

        snackDept.getProductList().add(pr20);
        snackDept.getProductList().add(pr21);

        foodDept.getProductList().add(pr22);
        foodDept.getProductList().add(pr23);

        dairyDept.getProductList().add(pr24);
        dairyDept.getProductList().add(pr25);

        mixerdept.getProductList().add(pr27);

        SKUHolder holder = new SKUHolder(sku6, sellerEnterprise);
        SKU selectedSku = holder.sku;
        OrderItem item1 = new OrderItem(holder, 45, 120);
        Order order = new Order();
        order.addNewOrderItem(holder, 3, selectedSku.getProduct().getPrice());
        order.setDate(new Date());
        order.setTotalPrice(Double.parseDouble("150.0"));
        order.setCustomerwhodidtheorder(custACC2);
        sellerEnterprise = item1.getSkuHolder().seller;
        ProductOrderWorkRequest request = new ProductOrderWorkRequest(item1);
        request.setReceiver(ua1);
        request.setSender(custACC2);
        request.setStatus("Order Processing");
        sellerEnterprise.fulfillorders(request);

        SKUHolder holder2 = new SKUHolder(sku20, sellerEnterprise);
        SKU selectedSku2 = holder2.sku;
        OrderItem item2 = new OrderItem(holder2, 20, 120);
        Order order2 = new Order();
        order2.addNewOrderItem(holder2, 1, selectedSku2.getProduct().getPrice());
        order2.setDate(new Date());
        order2.setTotalPrice(Double.parseDouble("120.0"));
        order2.setCustomerwhodidtheorder(custACC2);
        sellerEnterprise = item2.getSkuHolder().seller;
        ProductOrderWorkRequest request2 = new ProductOrderWorkRequest(item2);
        request2.setReceiver(ua2);
        request2.setSender(custACC2);
        request2.setStatus("Order Processing");
        sellerEnterprise.fulfillorders(request2);

        SKUHolder holder3 = new SKUHolder(sku5, sellerEnterprise);
        SKU selectedSku3 = holder3.sku;
        OrderItem item3 = new OrderItem(holder3, 80, 120);
        Order order3 = new Order();
        order3.addNewOrderItem(holder3, 4, selectedSku3.getProduct().getPrice());
        order3.setDate(new Date());
        order3.setTotalPrice(Double.parseDouble("100.0"));
        order3.setCustomerwhodidtheorder(custACC);
        sellerEnterprise = item3.getSkuHolder().seller;
        ProductOrderWorkRequest request3 = new ProductOrderWorkRequest(item3);
        request3.setReceiver(ua3);
        request3.setSender(custACC);
        request3.setStatus("Order Processing");
        sellerEnterprise.fulfillorders(request3);

        SKUHolder holder4 = new SKUHolder(sku2, sellerEnterprise);
        SKU selectedSku4 = holder4.sku;
        OrderItem item4 = new OrderItem(holder4, 80, 120);
        Order order4 = new Order();
        order4.addNewOrderItem(holder4, 4, selectedSku4.getProduct().getPrice());
        order4.setDate(new Date());
        order4.setTotalPrice(Double.parseDouble("100.0"));
        order4.setCustomerwhodidtheorder(custACC);
        sellerEnterprise = item4.getSkuHolder().seller;
        ProductOrderWorkRequest request4 = new ProductOrderWorkRequest(item4);
        request4.setReceiver(ua3);
        request4.setSender(custACC);
        request4.setStatus("Order Processing");
        sellerEnterprise.fulfillorders(request4);

        SKUHolder holder5 = new SKUHolder(sku22, sellerEnterprise);
        SKU selectedSku5 = holder5.sku;
        OrderItem item5 = new OrderItem(holder5, 80, 120);
        Order order5 = new Order();
        order5.addNewOrderItem(holder5, 1, selectedSku5.getProduct().getPrice());
        order5.setDate(new Date());
        order5.setTotalPrice(Double.parseDouble("90.0"));
        order5.setCustomerwhodidtheorder(custACC);
        sellerEnterprise = item5.getSkuHolder().seller;
        ProductOrderWorkRequest request5 = new ProductOrderWorkRequest(item4);
        request5.setSender(custACC);
        request5.setStatus("Pending");
        sellerEnterprise.fulfillorders(request5);

        SKUHolder holder6 = new SKUHolder(sku6, sellerEnterprise);
        SKU selectedSku6 = holder6.sku;
        OrderItem item6 = new OrderItem(holder6, 80, 120);
        Order order6 = new Order();
        order6.addNewOrderItem(holder6, 1, selectedSku6.getProduct().getPrice());
        order6.setDate(new Date());
        order6.setTotalPrice(Double.parseDouble("90.0"));
        order6.setCustomerwhodidtheorder(custACC);
        sellerEnterprise = item6.getSkuHolder().seller;
        ProductOrderWorkRequest request6 = new ProductOrderWorkRequest(item6);
        request6.setSender(custACC2);
        request6.setStatus("Pending");
        sellerEnterprise.fulfillorders(request6);

        SKUHolder holder7 = new SKUHolder(sku10, sellerEnterprise);
        SKU selectedSku7 = holder7.sku;
        OrderItem item7 = new OrderItem(holder7, 80, 120);
        Order order7 = new Order();
        order7.addNewOrderItem(holder7, 1, selectedSku7.getProduct().getPrice());
        order7.setDate(new Date());
        order7.setTotalPrice(Double.parseDouble("90.0"));
        order7.setCustomerwhodidtheorder(custACC3);
        sellerEnterprise = item7.getSkuHolder().seller;
        ProductOrderWorkRequest request7 = new ProductOrderWorkRequest(item7);
        request7.setSender(custACC3);
        request7.setStatus("Pending");
        sellerEnterprise.fulfillorders(request7);

        SKUHolder holder8 = new SKUHolder(sku12, sellerEnterprise);
        SKU selectedSku8 = holder8.sku;
        OrderItem item8 = new OrderItem(holder7, 80, 120);
        Order order8 = new Order();
        order8.addNewOrderItem(holder8, 2, selectedSku8.getProduct().getPrice());
        order8.setDate(new Date());
        order8.setTotalPrice(Double.parseDouble("200.0"));
        order8.setCustomerwhodidtheorder(custACC3);
        sellerEnterprise = item8.getSkuHolder().seller;
        ProductOrderWorkRequest request8 = new ProductOrderWorkRequest(item8);
        request8.setSender(custACC3);
        request8.setReceiver(ua1);
        request8.setStatus("Order Processing");
        sellerEnterprise.fulfillorders(request8);

        ShippingOrderWorkRequest shippingrequest1 = new ShippingOrderWorkRequest(item1);
        shippingrequest1.setRequestDate(new Date());
        shippingrequest1.setReferenceNo(String.valueOf(UUID.randomUUID()));
        shippingrequest1.setCustomerAccount((CustomerAccount) request.getSender());
        shippingrequest1.setReceiver(uaship);
        shippingrequest1.setSender(request.getReceiver());
        shippingrequest1.setStatus("Pending");
        shiporg.getWorkQueue().getWorkRequestList().add(shippingrequest1);

        ShippingOrderWorkRequest shippingrequest2 = new ShippingOrderWorkRequest(item2);
        shippingrequest2.setRequestDate(new Date());
        shippingrequest2.setReferenceNo(String.valueOf(UUID.randomUUID()));
        shippingrequest2.setCustomerAccount((CustomerAccount) request2.getSender());
        shippingrequest2.setReceiver(uaship);
        shippingrequest2.setSender(request2.getReceiver());
        shippingrequest2.setStatus("Pending");
        shiporg.getWorkQueue().getWorkRequestList().add(shippingrequest2);

        ShippingOrderWorkRequest shippingrequest3 = new ShippingOrderWorkRequest(item3);
        shippingrequest3.setRequestDate(new Date());
        shippingrequest3.setReferenceNo(String.valueOf(UUID.randomUUID()));
        shippingrequest3.setCustomerAccount((CustomerAccount) request3.getSender());
        shippingrequest3.setReceiver(uaship2);
        shippingrequest3.setSender(request3.getReceiver());
        shippingrequest3.setStatus("Pending");
        shiporg.getWorkQueue().getWorkRequestList().add(shippingrequest3);

        ShippingOrderWorkRequest shippingrequest4 = new ShippingOrderWorkRequest(item4);
        shippingrequest4.setRequestDate(new Date());
        shippingrequest4.setReferenceNo(String.valueOf(UUID.randomUUID()));
        shippingrequest4.setCustomerAccount((CustomerAccount) request4.getSender());
        shippingrequest4.setReceiver(uaship3);
        shippingrequest4.setSender(request4.getReceiver());
        shippingrequest4.setStatus("Pending");
        shiporg.getWorkQueue().getWorkRequestList().add(shippingrequest4);

        return system;
    }

}
