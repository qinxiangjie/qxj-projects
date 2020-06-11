USE COMPANYDATA;

INSERT INTO loginuser (accountId,password) VALUES('111@softuseing.com','000001');
INSERT INTO loginuser (accountId,password) VALUES('222@softuseing.com','000002');
INSERT INTO loginuser (accountId,password) VALUES('333@softuseing.com','000003');

INSERT INTO sex (sexCd,sexName) VALUES('01','女性');
INSERT INTO sex (sexCd,sexName) VALUES('02','男性');
INSERT INTO sex (sexCd,sexName) VALUES('03','不明');

INSERT INTO country (countryCd,countryName) VALUES('001','日本');
INSERT INTO country (countryCd,countryName) VALUES('002','中国');
INSERT INTO country (countryCd,countryName) VALUES('003','アメリカ');

INSERT INTO empinfo (empCd,name,birthday,countryCd,sexCd) VALUES('111111','山田花子',19900112,'001','01');
INSERT INTO empinfo (empCd,name,birthday,countryCd,sexCd) VALUES('222222','彭于晏',19911124,'002','02');
INSERT INTO empinfo (empCd,name,birthday,countryCd,sexCd) VALUES('333333','Damon',19920516,'003','03');

