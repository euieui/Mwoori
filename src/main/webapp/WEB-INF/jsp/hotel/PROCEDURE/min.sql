SELECT * FROM book_view;


create or replace PROCEDURE selectHotelmember (
    p_id IN hotelmember.id%type,
    p_rc OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN p_rc FOR
        select * from hotelmember where id=p_id;
END;


create or replace PROCEDURE selectAddressByDong (
    p_dong IN address.dong%type,
    p_rc OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN p_rc FOR
        select * from address where dong like '%'||p_dong||'%';
END;


create or replace PROCEDURE insertHotelmember(
    p_id IN hotelmember.id%type,
    p_pwd IN hotelmember.pwd%type,
    p_name IN hotelmember.name%type,
    p_email IN hotelmember.email%type,
    p_phone IN hotelmember.phone%type,
    p_zip_num IN hotelmember.zip_num%type,
    p_address IN hotelmember.address%type
)
IS
BEGIN
   insert into hotelmember (id, pwd, name, email, zip_num, address, phone) 
		values(p_id, p_pwd, p_name, p_email, p_zip_num, p_address, p_phone);
    commit;
END;

create or replace PROCEDURE updateHotelmember (
    p_id IN hotelmember.id%type,
    p_pwd IN hotelmember.pwd%type,
    p_name IN hotelmember.name%type,
    p_email IN hotelmember.email%type,
    p_phone IN hotelmember.phone%type,
    p_zip_num IN hotelmember.zip_num%type,
    p_address IN hotelmember.address%type
)
IS
BEGIN
    update hotelmember set name=p_name, pwd=p_pwd, email=p_email, 
		phone=p_phone, address=p_address, zip_num=p_zip_num where id=p_id;
    commit;
END;

	
	
create or replace PROCEDURE confirmPhone1 (
    p_name IN hotelmember.name%type,
    p_phone IN hotelmember.phone%type,
    p_rc OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN p_rc FOR
        select * from hotelmember where name=p_name and phone=p_phone;
END;



create or replace PROCEDURE confirmPhone2 (
    p_id IN hotelmember.id%type,
    p_name IN hotelmember.name%type,
    p_phone IN hotelmember.phone%type,
    p_rc OUT SYS_REFCURSOR )
IS
BEGIN
    OPEN p_rc FOR
        select * from hotelmember where id=p_id and name=p_name and phone=p_phone;
END;
	
    

create or replace PROCEDURE resetPw (
    p_id IN hotelmember.id%type,
    p_pwd IN hotelmember.pwd%type)
IS
BEGIN
    update hotelmember set pwd=p_pwd where id=p_id;
    commit;
END;

create or replace procedure deleteHotelmember (
    p_id IN hotelmember.id%type)
IS
BEGIN
    delete from hotelmember where id=p_id;
    commit;
END;
