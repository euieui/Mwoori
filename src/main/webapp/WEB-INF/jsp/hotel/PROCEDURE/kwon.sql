-- bookform.do  
-- 프로시저
create or replace procedure confirmRoom(
    p_checkin in book_view.checkin%type,
    p_checkout in book_view.checkout%type,
    p_kind in book_view.kind%type,
    p_usernum in book_view.usernum%type,
    p_roomnum in number,
    p_boolean out number
)
is
    vs_bookedCnt number;
    vs_maxPeopleNumber number;
    vs_maxRoomNumber number;
begin
    select count(*) into vs_bookedCnt from book_view where checkout > to_date(p_checkin,'yyyy-mm-dd') and checkin < to_date(p_checkin,'yyyy-mm-dd') and kind = p_kind;

    select distinct persons into vs_maxPeopleNumber from hotel where kind = p_kind;
    
    select count(*) into vs_maxRoomNumber from hotel where kind = p_kind;
    
    if  vs_maxPeopleNumber >= p_usernum / p_roomnum and (vs_maxRoomNumber - vs_bookedCnt) >= p_roomnum then p_boolean := 1;
    else p_boolean := 0;
    end if;
end;


-- 예약되어 있는 방 check 
-- 프로시저
create or replace procedure bookedRoom(
    p_checkin book_view.checkin%type,
    p_checkout book_view.checkout%type,
    p_kind book_view.kind%type,
    p_rc out sys_refcursor
    
)
is
begin
    open p_rc for
    select hotelnum from book_view where checkout > to_date(p_checkin,'yyyy-mm-dd') 
		and checkin < to_date(p_checkout,'yyyy-mm-dd') and kind = p_kind;
end;


-- kind 에 따른 총 방 갯수
-- 프로시저
create or replace procedure selectRoomNum(
    p_kind hotel.kind%type,
    p_rc out sys_refcursor
)
is
begin
    open p_rc for
    select hotelnum from hotel where kind=p_kind;
end;

-- insertBook  Book테이블에 있는 BookNum 만 insert 후 max(booknum)리턴
-- 프로시저
create or replace procedure insertBook(
    p_id book.id%type,
    p_maxBookNum out number
)
is 
    vs_maxBookNum number;
begin
    insert into book values (seq_book_booknum.nextval, p_id);
    select max(booknum) into vs_maxBookNum from book;
    p_maxBookNum := vs_maxBookNum;
end;

-- insertroom 
-- 프로시저
create or replace procedure insertRoom(
    p_booknum bookdetail.booknum%type,
    p_hotelnum bookdetail.hotelnum%type,
    p_usernum bookdetail.usernum%type,
    p_checkin bookdetail.checkin%type,
    p_checkout bookdetail.checkout%type
)
is
begin
    insert into bookdetail (usernum,checkin,checkout,bdseq,booknum,hotelnum) 
    values(p_usernum, to_date(TO_CHAR(p_checkin, 'YYYY-MM-DD'),'yyyy-mm-dd'),to_date(TO_CHAR(p_checkout, 'YYYY-MM-DD'),'yyyy-mm-dd'),seq_bookdetail_bdseq.nextval,p_booknum,p_hotelnum);
    commit;
end;


select * from bookdetail;

insert into bookdetail (usernum,checkin,checkout,bdseq,booknum,hotelnum) values (3, to_date('2022-03-01','yyyy-mm-dd'),to_date('2022-03-02','yyyy-mm-dd'),seq_bookdetail_bdseq.nextval,39,1402);
