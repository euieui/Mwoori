select *from qna;
---qna  프로시저-------

create or replace procedure deleteQna
   (p_qnaseq in qna.qnaseq%type)
   is 
   begin

   delete from qna where qnaseq=p_qnaseq;
   commit;
   end;
   ---------------------------------------
   create or replace procedure insertQna
 ( 

    p_id in qna.id%type,
    p_title in qna.title%type,
    p_content in qna.content%type

    )
   is
   begin insert into qna (qnaseq,id,title,content)
   values(QNA_SEQ.nextval,p_id,p_title,p_content);
   commit;
   end;
   ------------------------------------------------
   create or replace procedure listQna
   (p_id in qna.id%type,
     p_rc out sys_refcursor
   )
   is 
   begin
open p_rc for
   select * from qna
   where id=p_id order by qnaseq desc;


   end;
   ---------------------------------------------------
   create or replace procedure getQna
   (p_qnaseq in qna.qnaseq%type,
     p_rc out sys_refcursor
   )
   is 
   begin
open p_rc for
   select * from qna
   where qnaseq=p_qnaseq order by qnaseq desc;


   end;
   
   ----------------------------------------------
   create or replace procedure updateQna
    (   p_qnaseq in qna.qnaseq%type,
    p_id in qna.id%type,
    p_title in qna.title%type,
    p_content in qna.content%type

  )
   is
   begin 
  update qna set  id=p_id,title=p_title,content=p_content where qnaseq=p_qnaseq;

   commit;
   end;   
   
   
   -------------------------------------------------메인--------------------------------
   
   create or replace procedure imglist
(p_kind in hotelimg.kind%type,
p_rc out sys_refcursor)
is
begin
open p_rc for
 select *from hotelimg where kind=p_kind;

 end;
 
 
 
 
 
 ---어드민 qna------------------
  create or replace PROCEDURE adminlistQna1(
p_startnum  number,
p_endnum number,
p_key qna.title%type,
p_rc out sys_refcursor)

is

begin    
 open p_rc for
    
 
	 	select * from( 
		select * from ( 
				select rownum as rn, p.* from 
				 ((select * from qna  where id like '%'||p_key||'%' order by qnaseq desc   ) p) 
				) where rn >= p_startNum 
            	) where rn <= p_endNum;
        commit;
        end; 
    -----------------------------------------------------------    
 create or replace PROCEDURE adminlistQna2(
p_startnum  number,
p_endnum number,
p_key qna.title%type,
p_rc out sys_refcursor)

is

begin    
 open p_rc for
    
      
	 	select * from( 
		select * from ( 
				select rownum as rn, p.* from 
				 ((select * from qna  where id like '%'||p_key||'%' order by qnaseq asc   ) p) 
				) where rn >= p_startNum 
            	) where rn <= p_endNum;
        commit;
        end;
   -----------------------------------------------------------                 
create or replace PROCEDURE adminlistQna3(
p_startnum  number,
p_endnum number,
p_key qna.title%type,
p_rc out sys_refcursor)

is

begin    
 open p_rc for
    
 
	 	select * from( 
		select * from ( 
				select rownum as rn, p.* from 
				 ((select * from qna  where id like '%'||p_key||'%' order by rep desc   ) p) 
				) where rn >= p_startNum 
            	) where rn <= p_endNum;
        commit;
        end; 
        
     -----------------------------------------------------------       
 create or replace PROCEDURE adminlistQna4(
p_startnum  number,
p_endnum number,
p_key qna.title%type,
p_rc out sys_refcursor)

is

begin    
 open p_rc for
    
 
	 	select * from( 
		select * from ( 
				select rownum as rn, p.* from 
				 ((select * from qna  where id like '%'||p_key||'%' order by rep asc   ) p) 
				) where rn >= p_startNum 
            	) where rn <= p_endNum;
        commit;
        end; 
        
        
     -----------------------------------------------------------       
create or replace procedure getallcountQnaList(
p_count out number
)
is
vs_count number;
begin

select count(*) into vs_count from qna ; 
p_count:=vs_count;
end; 

   -----------------------------------------------------------         
create or replace procedure getallcountQnaList1(
p_key qna.id%type,
p_count out number

)
is
vs_count number;
begin

select count(*) into vs_count from qna where id like '%'||p_key||'%' ; 
p_count:=vs_count;
end; 


   ----------------------------------------------------------- 
         create or replace procedure updateQnaReply
 (   p_qnaseq in qna.qnaseq%type,
    p_reply in qna.reply%type
  )
   is
   begin 
  update qna set reply=p_reply,rep='2' where qnaseq=p_qnaseq;

   commit;
   end;
        
        