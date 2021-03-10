Hi
Model a Sport Player management DB Hi, Bala
Players
1. Id IDNETITY(1,1) PRIMARY KEY
2. Name
3. Address
4. Phone
5. Email
6. IsActive
7. CreateDate
8. createBy
9. ModifiedDate
10. ModifiedBy


Team
1. Team Id VARCHAR(100) NOT NULL 
2. TeamName VARCHAR(100)
3. CreateDate
4. CreateBy
5. ModifiedBY

TeamAndPlayerMapping
1. SerialNo IDENTITY(1,1) INT PRIMARY KEY
2. TeamId VARCHAR
3. PlayerId VARCHAR
4. IsActive

Role
1. RoleId 
2. RoleType int 0:Manager, 1:Player

RolePLayerMapping
1. SerialNo
2. RoleId 
3. PlayerId
4. IsActive

Game


---------------------------------------------------


employee
-------
id
name
Age
manager_id


empployee_secure
--------------
emp_id
ssn
dateofbirth


1.Get report of emp_id,emp_name,age_correct
SELECT e.emp_id, name as [emp_name],
CASE WHEN e.Age = YEAR(Date())- YEAR(dateofBirth) THEN TRUE ELSE FALSE END AS [age_correct]
FROM employee e
INNER JOIN employee_secure s ON e.empId = s.emp_Id


2.Get list of managers with top 5 oldest employees

Select top 5 emp.emp_id from [employee] emp
inner join [Players] players on emp.id = players.id
inner join (Select * from [RolePLayerMapping] mapping, [Role] roles where mapping.RoleId = roles.RoleId and RoleType = 0) manageRole
on manageRole.PlayerId = players.id
order by emp.Age desc


//Create temp table 
create table #MeetCompDetailInit
(
    Date VARCHAR(100)
	,CaseID VARCHAR(100)
	,CreateUser int
    ...
)
insert into #MeetCompDetailInit
SELECT convert(varchar,m.Date,111) ...

with DEALData as (
        select '%' + Deal + '%' as dealNo from[CleanDataMst_His]
        where flag = 1 and uploaddate in (select convert(varchar(10), max(convert(date, uploaddate)), 101)uploaddate from CleanDataMst_His where flag = '1' )
)
SELECT c.dealNo, M.*
FROM[US-SUPER-NOVA3].[SalesQuote].[dbo].[vCQApprNote] as M join DEALData C
on M.note like c.dealNo

//declare variable
declare @countTemp int
declare @CaseID VARCHAR(100)
declare @wudItem VARCHAR(100)


//A recursive common table expression (CTE)
WITH cte_numbers (n, weekday) 
AS (
    //anchor 
    SELECT 
        0, 
        DATENAME(DW, 0)
    UNION ALL
    SELECT    
        n + 1, 
        DATENAME(DW, n + 1)
    FROM    
        cte_numbers
    WHERE n < 6
)
SELECT 
    weekday
FROM 
    cte_numbers;



Staff
(
    staff_id,
    name,
    manager_id,
)
With org As(
    Select
        staff_id,
        name,
        manager_id
    From Staff
    Union ALL
    Select
        s.staff_id,
        s.name,
        s.manager_id
    From
        Staff s
        Inner Join org o
        On o.staff_id = s.staff_id
)
Select * from org

