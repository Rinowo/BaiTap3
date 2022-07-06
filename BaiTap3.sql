CREATE DATABASE [Bai Tap 3]
USE [Bai Tap 3]
GO

CREATE TABLE [Person] (
	name VARCHAR(30),
	dob DATE,
	nationality VARCHAR(20),
	gender VARCHAR(10),
	address VARCHAR(50),
	idCard INT PRIMARY KEY
)
GO

INSERT INTO [Person] VALUES ('Ng Tung Anh', '1999/05/20', 'VN', 'Nam', 'Hang Buom', 001)
INSERT INTO [Person] VALUES ('Ng Hong Nhung', '2000/04/10', 'VN', 'Nu', 'Tan Mai', 002)
INSERT INTO [Person] VALUES ('Ng Hong Hao', '1995/05/10', 'VN', 'Nu', 'De La Thanh', 003)
GO

DROP TABLE [Exit Procedures]

CREATE TABLE [Exit Procedures] (
	idCard INT FOREIGN KEY(idCard) REFERENCES [Person](idCard),
	idStartDate DATE,
	idDayExpire DATE,
	passport VARCHAR(20),
	passportStartDate DATE,
	passportDayExpire DATE,
	visa VARCHAR(20),
	visaStartDate DATE,
	visaDayExpire DATE,
	immigrationTime VARCHAR(20), 
	immigrationReason VARCHAR(100),
	approval VARCHAR(30),
)
GO
SELECT * FROM [Exit Procedures]

INSERT INTO [Exit Procedures] VALUES (001, '2020/05/01', '2030/05/01', 'passport 01', '2021/06/02', '2026/06/02', 'visa 01', '2021/02/10', '2022/05/10', '1 nam', 'Du Lich', NULL)
INSERT INTO [Exit Procedures] VALUES (002, '2020/05/01', '2030/05/01', 'passport 02', '2021/06/02', '2026/06/02', 'visa 02', '2019/02/10', '2022/02/10', '3 nam', 'Du Hoc', NULL)
INSERT INTO [Exit Procedures] VALUES (003, '2020/05/01', '2030/05/01', 'passport 03', '2021/06/02', '2026/06/02', NULL, NULL, NULL, '1 nam', 'Du Lich', NULL)
GO

CREATE TABLE [Entry Procedures] (
	idCard INT FOREIGN KEY(idCard) REFERENCES [Person](idCard),
	idStartDate DATE,
	idDayExpire DATE,
	passport VARCHAR(20),
	passportStartDate DATE,
	passportDayExpire DATE,
	visa VARCHAR(20),
	visaStartDate DATE,
	visaDayExpire DATE,
	immigrationTime VARCHAR(20), 
	immigrationReason VARCHAR(100),
	approval VARCHAR(30),
)
GO

INSERT INTO [Entry Procedures] VALUES (001, '2020/05/01', '2030/05/01', 'passport 01', '2021/06/02', '2026/06/02', 'visa 01', '2021/02/10', '2022/05/10', '1 nam', 'Du Lich', NULL)
INSERT INTO [Entry Procedures] VALUES (002, '2020/05/01', '2030/05/01', 'passport 02', '2021/06/02', '2026/06/02', 'visa 02', '2019/02/10', '2022/02/10', '3 nam', 'Du Hoc', NULL)
INSERT INTO [Entry Procedures] VALUES (003, '2020/05/01', '2030/05/01', 'passport 03', '2021/06/02', '2026/06/02', NULL, NULL, NULL, '1 nam', 'Du Lich', NULL)
GO

SELECT * FROM [Exit Procedures]

--1
SELECT COUNT(idCard) AS [So Nguoi Nhap Canh] 
FROM [Entry Procedures]
GO

--2
SELECT COUNT(idCard) AS [So Nguoi Xuat Canh]
FROM [Exit Procedures]
GO

--3
SELECT E.name, E.gender, E.idCard, E.nationality, E.address
FROM [Exit Procedures] EP INNER JOIN [Person] E
ON EP.idCard = E.idCard
WHERE EP.passport IS NOT NULL
GO

--4
SELECT E.name, E.gender, E.idCard, E.nationality, E.address
FROM [Entry Procedures] EP INNER JOIN [Person] E
ON EP.idCard = E.idCard
WHERE EP.visa IS NOT NULL
GO

--5 
SELECT COUNT(EP.visa) AS [Using Visa]
FROM [Exit Procedures] EP INNER JOIN [Person] P
ON EP.idCard = P.idCard
WHERE EP.visa IS NOT NULL

SELECT COUNT(EP.visa) AS [Using Passport]
FROM [Exit Procedures] EP INNER JOIN [Person] P
ON EP.idCard = P.idCard
WHERE EP.passport IS NOT NULL
 GO

--6
SELECT COUNT(EP.approval) AS [Using approval]
FROM [Exit Procedures] EP INNER JOIN [Person] P
ON EP.idCard = P.idCard
WHERE EP.approval IS NOT NULL
GO

--7
SELECT E.name, E.gender, E.idCard, E.nationality 
FROM [Entry Procedures] EP INNER JOIN [Person] E 
ON EP.idCard = E.idCard
WHERE E.nationality = 'VN'
GO

--8
SELECT E.name, E.gender, E.idCard, E.nationality 
FROM [Entry Procedures] EP INNER JOIN [Person] E 
ON EP.idCard = E.idCard
WHERE E.gender = 'Nam' AND EP.immigrationReason = 'Du lich'
GO