CREATE DATABASE companydata;
USE companydata;
CREATE
    TABLE loginUser(
        accountId VARCHAR(255) NOT NULL COMMENT '�A�J�E���g',
        password CHAR(6) NOT NULL COMMENT '�p�X���[�h',
        PRIMARY KEY (accountId) 
    );

CREATE
     TABLE country(
        countryCd CHAR(3) NOT NULL COMMENT '���ЃR�[�h',
		
        countryName CHAR(255) NOT NULL COMMENT '����',
        PRIMARY KEY (countryCd)
        
    );

CREATE
    TABLE sex(
       sexCd char(2) NOT NULL COMMENT '���ʃR�[�h',
	   
       sexName varchar(255) NOT NULL COMMENT '����',
       PRIMARY KEY (sexCd)
    );

CREATE
   TABLE empinfo(
        -- �Ј��ԍ�
        empCd CHAR(6) NOT NULL COMMENT '�Ј��ԍ�',
        -- ����
        name VARCHAR(255) NOT NULL COMMENT '����',
        -- ���N����
        birthday DATE NOT NULL COMMENT '���N����',
        -- ���ЃR�[�h
       countryCd CHAR(3) NOT NULL COMMENT '���ЃR�[�h',
        -- ���ʃR�[�h
        sexCd char(2) NOT NULL COMMENT '���ʃR�[�h',
        PRIMARY KEY (empCd)
    );



