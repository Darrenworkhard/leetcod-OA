Create Table CarInfo
(
  carId int primary key
);

Create Table Subscription
(
  subscriptionId int primary key,
  carId int,
  subscriptiontype int,
  startDate DateTime,
  endDate DateTime,
  isActive bit,
  autornew bit
);

Create Table CancalReason
(
  CancalReasonId int primary key,
  SubscriptionId int,
  CancalReason varchar(255)
);

Create Table SubscriptionTypeMapping
(
  type int,
  subscription varchar(255),
  subscription_Detail varchar(255),
  subscrition_level int
);

Select type mapping.subscription
from CarInfo carinfo
Join Subscription sub
On carinfo.carId = sub.carId
Join SubscriptionTypeMapping mapping
On mapping.type = sub.type
Where CarInfo.id = 'A123' and isActive = 1;
and endDate >= Current_Date()

//basic primune

Select subscription mapping.subscription
from SubscriptionTypeMapping mapping
Where subscription_Detail like '%netflix%'
and type <> type
(
  //basic
  Select type, subscrition_level mapping.subscription
  from CarInfo carinfo
  Join Subscription sub
  On carinfo.carId = sub.carId
  Join SubscriptionTypeMapping mapping
  On mapping.type = sub.type
  Where CarInfo.id = 'A123' and isActive = 1;
  and endDate >= Current_Date()
)
and subscrition_level > 
(
  //basic
  Select top 1 mapping.subscription
  from CarInfo carinfo
  Join Subscription sub
  On carinfo.carId = sub.carId
  Join SubscriptionTypeMapping mapping
  On mapping.type = sub.type
  Where CarInfo.id = 'A123' and isActive = 1;
  and endDate >= Current_Date()
  order by subscrition_level desc
)

