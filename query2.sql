select * from tproduct_coin_list

select * from tproduct_stock_list

select * from texternal_crypto_coingecko_market

select * from texternal_stock_finnhub_profile2

select * from texternal_stock_finnhub_quote tsfq order by tsfq.id desc

select * from tproduct_coins;

select * from tproduct_stocks;

select * from tproduct_stocks_daily;

select  * from tproduct_stocks_daily tsd
where tsd.stock_id = 3

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


insert into tproduct_stocks_daily (day_close, day_high, day_low, day_open, stock_id, trade_data)
values(170.85, )