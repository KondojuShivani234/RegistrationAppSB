//SQL QUERIES TO INSERT DATA INTO Country_Master
Insert Into Country_Master (Country_ID, Country_Name) Values(1,'India');
Insert Into Country_Master (Country_ID, Country_Name) Values(2,'USA');

//SQL QUERIES TO INSERT DATA INTO States_Master
Insert Into States_Master (State_ID, Country_ID, State_Name) Values(1,1,'Andhra Pradesh');
Insert Into States_Master (State_ID, Country_ID, State_Name) Values(2,1,'Karnataka');
Insert Into States_Master (State_ID, Country_ID, State_Name) Values(3,2,'New Jersy');
insert into States_Master (State_ID, Country_ID, State_Name) values(4,2,'Ohio');

//SQL QUERIES TO INSERT DATA INTO Citys_Master
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(1,'Vizag',1);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(2,'Guntur',1);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(3,'Banglore',2);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(4,'Mysore',2);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(5,'Maywood',3);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(6,'Westwood',3);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(7,'Oakwood',4);
Insert Into Citys_Master (City_ID, City_Name, State_ID) Values(8,'Cuyahoga County',4);