select * from tproduct_coin_list

select * from tproduct_stock_list

select * from texternal_crypto_coingecko_market

select * from texternal_stock_finnhub_profile2

select * from texternal_stock_finnhub_quote

select * from tproduct_coins;

select * from tproduct_stocks;

select * from tproduct_stocks_daily;

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