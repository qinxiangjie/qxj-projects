CREATE DATABASE companydata;
USE companydata;
CREATE
    TABLE loginUser(
        accountId VARCHAR(255) NOT NULL COMMENT 'アカウント',
        password CHAR(6) NOT NULL COMMENT 'パスワード',
        PRIMARY KEY (accountId) 
    );

CREATE
     TABLE country(
        countryCd CHAR(3) NOT NULL COMMENT '国籍コード',
		
        countryName CHAR(255) NOT NULL COMMENT '国籍',
        PRIMARY KEY (countryCd)
        
    );

CREATE
    TABLE sex(
       sexCd char(2) NOT NULL COMMENT '性別コード',
	   
       sexName varchar(255) NOT NULL COMMENT '性別',
       PRIMARY KEY (sexCd)
    );

CREATE
   TABLE empinfo(
        -- 社員番号
        empCd CHAR(6) NOT NULL COMMENT '社員番号',
        -- 姓名
        name VARCHAR(255) NOT NULL COMMENT '姓名',
        -- 生年月日
        birthday DATE NOT NULL COMMENT '生年月日',
        -- 国籍コード
       countryCd CHAR(3) NOT NULL COMMENT '国籍コード',
        -- 性別コード
        sexCd char(2) NOT NULL COMMENT '性別コード',
        PRIMARY KEY (empCd)
    );



