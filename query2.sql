select * from tproduct_coin_list

select * from tproduct_stock_list

select * from texternal_crypto_coingecko_market

select * from texternal_stock_finnhub_profile2

select * from texternal_stock_finnhub_quote tsfq order by tsfq.id desc

select * from texternal_stock_finnhub_quote tsfq 
inner join tproduct_stock_list tsl on tsfq.quote_stock_code = tsl.stock_code
where tsl.stock_code = 3
order by tsfq.id

select * from tproduct_coins;

select * from tproduct_stocks;

select * from tproduct_stocks_daily tsd
order by tsd.id desc;

select  * from tproduct_stocks_daily tsd
--inner join tproduct_stock_list tsl on tsd.stock_id = tsl.id
where tsd.stock_id = 1
order by tsd.id

select distinct tsd.day_close,tsd.day_high, tsd.day_low, tsd.day_open, tsd.stock_id, tsd.trade_date
from tproduct_stocks_daily tsd
where tsd.stock_id = 1 
and tsd.trade_date = '2024-04-09'
-- and (tsd.trade_date = '2024-04-08'
-- 	 or tsd.trade_date = '2024-04-09'
-- 	or tsd.trade_date = '2024-04-11')
--and tsd.day_high = 427.2
order by tsd.trade_date

select tsd.id, tsd.day_close,tsd.day_high, tsd.day_low, tsd.day_open, tsd.stock_id, tsd.trade_date
from tproduct_stocks_daily tsd
where tsd.stock_id = 1
and tsd.trade_date = '2024-04-09'
order by tsd.trade_date

delete 
from tproduct_stocks_daily tsd
where tsd.stock_id = 1
and tsd.id between 190 and 262
-- and tsd.id = 39
and tsd.trade_date = '2024-04-09'
-- and tsd.id between 192 and 264
-- and tsd.day_high = 427.28

drop table texternal_crypto_coingecko_market;
drop table texternal_stock_finnhub_profile2;
drop table texternal_stock_finnhub_quote;
drop table tproduct_coin;
drop table tproduct_stock;
drop table tproduct_stocks_daily;

delete from tproduct_stocks_daily tc 
where tc.id = 1;

select * from texternal_crypto_coingecko_market tccm
where tccm.quote_coin_code = '0chain'
order by tccm.id desc


insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(169.890, 170.610,168.151,169.525,1,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(399.040,399.890,388.030,394.030,2,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(826.320,833.230 ,782.230,788.680,3,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(170.180,170.880, 158.360,158.960,4,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(156.000,156.490,150.870,156.490,5,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(441.380,445.770,414.500,421.400,6,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(173.670,173.920,166.320,169.680,7,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(35.110,35.295,34.500,34.560,8,'2024-04-26')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(153.760,155.140,146.750,149.150,9,'2024-04-26')

insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(170.330, 172.690,169.110,169.800,1,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(392.440,401.7199,390.310,392.440,2,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(864.020,859.990 ,812.5456,850.500,3,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(170.180,170.880, 158.360,158.960,4,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(156.000,156.490,150.870,156.490,5,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(441.380,445.770,414.500,421.400,6,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(173.670,173.920,166.320,169.680,7,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(35.110,35.295,34.500,34.560,8,'2024-05-01')
insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_date)
values(153.760,155.140,146.750,149.150,9,'2024-05-01')


update tproduct_stocks_daily
set trade_date = '2024-04-27'
where trade_date = '2024-04-28'

delete from tproduct_stocks_daily
where trade_date = '2024-04-20'