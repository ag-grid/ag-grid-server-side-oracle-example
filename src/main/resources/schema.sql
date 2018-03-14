CREATE TABLE trade
  (
     product VARCHAR(255),
     portfolio VARCHAR(255),
     book VARCHAR(255),
     tradeId NUMBER,
     submitterId NUMBER,
     submitterDealId NUMBER,
     dealType VARCHAR(255),
     bidType VARCHAR(255),
     currentValue NUMBER,
     previousValue NUMBER,
     pl1 NUMBER,
     pl2 NUMBER,
     gainDx NUMBER,
     sxPx NUMBER,
     x99Out NUMBER,
     batch NUMBER
  );