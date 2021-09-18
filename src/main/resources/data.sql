insert into ITEM (name, price, stock_Quantity, author, isbn, DTYPE) values ('클린 아키텍처', 25000, 999, '마틴 파울러', '1111', 'B');
insert into ITEM (name, price, stock_Quantity, author, isbn, DTYPE) values ('JavaScript', 15000, 999, '이선 브라운', '1112', 'B');
insert into ITEM (name, price, stock_Quantity, author, isbn, DTYPE) values ('도메인 주도 설계 철저 입문', 28000, 999, '나루세마사노부', '1113', 'B');

insert into MEMBER (CITY, STREET, ZIPCODE, NAME) values ('김포시', '사우로11', '10097', 'peter');
insert into MEMBER (CITY, STREET, ZIPCODE, NAME) values ('서울시', '송파대로570', '12023', 'parker');

insert into DELIVERY (CITY, STREET, ZIPCODE, STATUS) values ('김포시', '사우로11', '10097', 'READY');
insert into DELIVERY (CITY, STREET, ZIPCODE, STATUS) values ('서울시', '송파대로570', '12023', 'READY');

insert into ORDERS (ORDER_DATE, STATUS, DELIVERY_ID, MEMBER_ID) values (current_timestamp , 'ORDER', 1, 1);
insert into ORDERS (ORDER_DATE, STATUS, DELIVERY_ID, MEMBER_ID) values (current_timestamp, 'ORDER', 2, 2);

insert into ORDER_ITEM (COUNT, ORDER_PRICE, ITEM_ID, ORDER_ID) values (1, 25000, 1, 1);
insert into ORDER_ITEM (COUNT, ORDER_PRICE, ITEM_ID, ORDER_ID) values (5, 15000, 2, 2);
