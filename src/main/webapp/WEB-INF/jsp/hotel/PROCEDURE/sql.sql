select * from book;
select * from bookdetail;
select * from book_view;

select count(*) as cnt from book_view where booknum=3;
select count(*) as cnt from book_view where booknum=2;
select count(*) as cnt from book_view where booknum=1;
update bookdetail set result=1 where bdseq=6;
