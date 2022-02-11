-- get all count(전체)
create or replace procedure getAllCount(
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view;
    p_cnt:=v_cnt;
end;




-- get all count(id)
create or replace procedure getAllCountWithId(
    p_id in member.id%type,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where id=p_id;
    p_cnt:=v_cnt;
end;




-- get all count(id/booknum)
create or replace procedure getAllCountWithIdBooknum(
    p_id in member.id%type,
    p_booknum in book.booknum%type,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where id=p_id and booknum=p_booknum;
    p_cnt:=v_cnt;
end;




-- get all count(booknum)
create or replace procedure getAllCountWithBooknum(
    p_booknum in book.booknum%type,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where booknum=p_booknum;
    p_cnt:=v_cnt;
end;




-- get all count(indate/outdate)
create or replace procedure getAllCountWithIndateOutdate(
    p_indate in varchar2,
    p_outdate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where to_char(checkin, 'YYYYMMDD')=p_indate 
		and to_char(checkout, 'YYYYMMDD')=p_outdate;
    p_cnt:=v_cnt;
end;




-- get all count(indate)
create or replace procedure getAllCountWithIndate(
    p_indate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where to_char(checkin, 'YYYYMMDD')=p_indate;
    p_cnt:=v_cnt;
end;




-- get all count(outdate)
create or replace procedure getAllCountWithOutdate(
    p_outdate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where to_char(checkout, 'YYYYMMDD')=p_outdate;
    p_cnt:=v_cnt;
end;




-- get all count(id/indate/outdate)
create or replace procedure getAllCountWithIdIndateOutdate(
    p_id in member.id%type,
    p_indate in varchar2,
    p_outdate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where id=p_id and 
		to_char(checkin, 'YYYYMMDD')=p_indate 
		and to_char(checkout, 'YYYYMMDD')=p_outdate;
    p_cnt:=v_cnt;
end;




-- get all count(id/indate)
create or replace procedure getAllCountWithIdIndate(
    p_id in member.id%type,
    p_indate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where id=p_id and 
		to_char(checkin, 'YYYYMMDD')=p_indate;
    p_cnt:=v_cnt;
end;




-- get all count(id/outdate)
create or replace procedure getAllCountWithIdOutdate(
    p_id in member.id%type,
    p_outdate in varchar2,
    p_cnt out number
)
is
    v_cnt number;
begin
    select count(*) as cnt into v_cnt from book_view where id=p_id 
		and to_char(checkout, 'YYYYMMDD')=p_outdate;
    p_cnt:=v_cnt;
end;




--get all booklist

--get all booklist / get Member Book
create or replace procedure getAllBookList(
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(booknum) / getMemberBookWithBooknum
create or replace procedure getAllBookListWithBooknum(
    p_booknum in book.booknum%type,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where booknum=p_booknum order by result asc,  booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id) / getMemberBookWithId
create or replace procedure getAllBookListWithId(
    p_id in book.id%type,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id/booknum)
create or replace procedure getAllBookListWithIdBooknum(
    p_id in book.id%type,
    p_booknum in book.booknum%type,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id and booknum=p_booknum 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(indate/outdate) / getMemberBookWithIndateOutdate
create or replace procedure getAllBookListWithInOut(
    p_indate in varchar2,
    p_outdate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where to_char(checkin, 'YYYYMMDD')=p_indate 
		and to_char(checkout,'YYYYMMDD')=p_outdate order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(indate) / getMemberBookWithIndate
create or replace procedure getAllBookListWithIndate(
    p_indate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where to_char(checkin, 'YYYYMMDD')=p_indate 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(outdate) / getMemberBookWithOutdate
create or replace procedure getAllBookListWithOutdate(
    p_outdate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where to_char(checkout,'YYYYMMDD')=p_outdate 
        order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id/indate/outdate) / getMemberBookWithIdIndateOudate
create or replace procedure getAllBookListWithIdInOut(
    p_id in book.id%type,
    p_indate in varchar2,
    p_outdate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id and 
		to_char(checkin, 'YYYYMMDD')=p_indate and
		to_char(checkout, 'YYYYMMDD')=p_outdate 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id/indate) / getMemberBookWithIdIndate
create or replace procedure getAllBookListWithIdIndate(
    p_id in book.id%type,
    p_indate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id and 
		to_char(checkin, 'YYYYMMDD')=p_indate 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id/outdate) / getMemberBookWithIdOutdate
create or replace procedure getAllBookListWithIdOutdate(
    p_id in book.id%type,
    p_outdate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id and 
		to_char(checkout, 'YYYYMMDD')=p_outdate 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get all booklist(id/outdate)
create or replace procedure getAllBookListWithIdOutdate(
    p_id in book.id%type,
    p_outdate in varchar2,
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where id=p_id and 
		to_char(checkout, 'YYYYMMDD')=p_outdate 
		order by result asc, booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- 예약 상세 보기

-- get book detail
create or replace procedure getBookDetail(
    p_bdseq in bookdetail.bdseq%type,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from book_view where bdseq=p_bdseq;
end;




-- admin Book Cancel
create or replace procedure adminBookCancel(
    p_bdseq in bookdetail.bdseq%type
)
is
begin
    update bookdetail set result='3' where bdseq=p_bdseq;
    commit;
end;




-- get admin cancel list(취소 대기자 명단)
create or replace procedure getAdminCancelList(
    p_startnum in number,
    p_endnum in number,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
        select * from (select * from ( select rownum as rn, b.* from 
		( ( select * from book_view where result='2' order by booknum desc) b )) 
		where rn>=p_startnum) where rn<=p_endnum;
end;




-- get cancel all count(취소 예약 대기자 수)
create or replace procedure getCancelAllCount(
    p_cnt out number
)
is
    v_cnt number;
begin
        select count(*) as cnt into v_cnt from book_view where result='2';
        p_cnt:=v_cnt;
end;




-- update book result(예약 result 변경)
create or replace procedure updateBookResult(
    p_bdseq in bookdetail.bdseq%type
)
is
begin
    update bookdetail set result='1' where bdseq=p_bdseq;
    commit;
end;




-- get max bed
create or replace procedure getMaxBed(
    p_hotelnum in hotel.hotelnum%type,
    p_persons out number
)
is
    v_persons hotel.persons%type;
begin
    select persons into v_persons from hotel where hotelnum=p_hotelnum;
    p_persons:=v_persons;
end;




create or replace procedure changePeople(
    p_number in bookdetail.usernum%type,
    p_bdseq in bookdetail.bdseq%type
)
is
begin
    update bookdetail set usernum=p_number where bdseq=p_bdseq;
    commit;
end;




-- request book cancel
create or replace procedure requestBookCancel(
    p_refund in bookdetail.refund%type,
    p_bdseq in bookdetail.bdseq%type
)
is
begin
    update bookdetail set result='2' , refund=p_refund where bdseq=p_bdseq;
    commit;
end;