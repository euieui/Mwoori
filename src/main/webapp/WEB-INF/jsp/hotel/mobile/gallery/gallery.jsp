<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<link
  rel="stylesheet"
  href="https://unpkg.com/swiper@7/swiper-bundle.min.css"
/>
<script src="https://unpkg.com/swiper@7/swiper-bundle.min.js"></script>
   <style>
   article{
   width: 100%;
   height: 100%;
   }
#sum_aa{position:relative;width:100%;  height:60px; border-bottom:6px solid #3a3125; 
	font-size:250%; line-height:64px;/* background:aqua; */ color:#9f876b;
	text-align: center;
	
	}
	
	#imgshow_view{
	width: 100%;
	height: 700px;
	margin: 0 auto;
	}

      body {
    
        font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
        font-size: 14px;
    
        margin: 0;
        padding: 0;
        width: 100%;
 
      }

      .swiper {
        width: 115%;
        height: 600px;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }

      body {
/*         background: #000;
        color: #000; */
      }

      .swiper {
        width: 100%;
        height: 300px;
        margin-left: auto;
        margin-right: auto;
      }

      .swiper-slide {
        background-size: cover;
        background-position: center;
      }

      .mySwiper2 {
        height: 80%;
        width: 100%;
      }

      .mySwiper {
        height: 20%;
        box-sizing: border-box;
        padding: 10px 0;
      }

      .mySwiper .swiper-slide {
        width: 25%;
        height: 100%;
        opacity: 0.4;
      }

      .mySwiper .swiper-slide-thumb-active {
        opacity: 1;
      }

      .swiper-slide img {
        display: block;
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    </style>
<meta charset="UTF-8">
<article>
<div id="imgshow_view">
<div id="sum_aa">사진</div>
<div style="  margin: 0 auto;
    width: 100%;"> 

  <div
      style="--swiper-navigation-color: #fff; --swiper-pagination-color: #fff"
      class="swiper mySwiper2"
    >
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images1.jpg'/> " />
        </div>
        <div class="swiper-slide">
           <img src="<c:url value='/gallery/galley_images2.jpg'/> " />
        </div>
        <div class="swiper-slide">
             <img src="<c:url value='/gallery/galley_images3.jpg'/> " />
        </div>
        <div class="swiper-slide">
             <img src="<c:url value='/gallery/galley_images4.jpg'/> " />
        </div>
        <div class="swiper-slide">
           <img src="<c:url value='/gallery/galley_images5.jpg'/> " />
        </div>
        <div class="swiper-slide">
              <img src="<c:url value='/gallery/galley_images6.jpg'/> " />
        </div>
        <div class="swiper-slide">
              <img src="<c:url value='/gallery/galley_images7.jpg'/> " />
        </div>
        <div class="swiper-slide">
             <img src="<c:url value='/gallery/galley_images8.jpg'/> " />
        </div>
        <div class="swiper-slide">
            <img src="<c:url value='/gallery/galley_images9.jpg'/> " />
        </div>
        <div class="swiper-slide">
              <img src="<c:url value='/gallery/galley_images10.jpg'/> " />
        </div>
               <div class="swiper-slide">
             <img src="<c:url value='/gallery/galley_images11.jpg'/> " />
        </div>
               <div class="swiper-slide">
              <img src="<c:url value='/gallery/galley_images12.jpg'/> " />
        </div>
               <div class="swiper-slide">
        <img src="<c:url value='/gallery/galley_images13.jpg'/> " />
        </div>
               <div class="swiper-slide">
            <img src="<c:url value='/gallery/galley_images14.jpg'/> " />
        </div>
      </div>
      <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
    </div>
    <div thumbsSlider="" class="swiper mySwiper">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
         <img src="<c:url value='/gallery/galley_images1.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images2.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images3.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images4.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images5.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images6.jpg'/> " />
        </div>
        <div class="swiper-slide">
       <img src="<c:url value='/gallery/galley_images7.jpg'/> " />
        </div>
        <div class="swiper-slide">
          <img src="<c:url value='/gallery/galley_images8.jpg'/> " />
        </div>
        <div class="swiper-slide">
        <img src="<c:url value='/gallery/galley_images9.jpg'/> " />
        </div>
        <div class="swiper-slide">
     <img src="<c:url value='/gallery/galley_images10.jpg'/> " />
        </div>
            <div class="swiper-slide">
         <img src="<c:url value='/gallery/galley_images11.jpg'/> " />
        </div>
            <div class="swiper-slide">
         <img src="<c:url value='/gallery/galley_images12.jpg'/> " />
        </div>
            <div class="swiper-slide">
        <img src="<c:url value='/gallery/galley_images13.jpg'/> " />
        </div>
            <div class="swiper-slide">
       <img src="<c:url value='/gallery/galley_images14.jpg'/> " />
        </div>
      </div>
    </div>

    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

    <!-- Initialize Swiper -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        spaceBetween: 10,
        slidesPerView: 4,
        freeMode: true,
        watchSlidesProgress: true,
      });
      var swiper2 = new Swiper(".mySwiper2", {
        spaceBetween: 10,
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
        thumbs: {
          swiper: swiper,
        },
      });
    </script>

</div>






</div>

<div style="margin: 0 auto; ">
<div id="sum_aa" style="margin-top: 50px;">비디오</div>

<div>
<iframe style="margin: 0 auto;" width="100%" height="678" src="<c:url value= 'https://www.youtube.com/embed/81xxCLvADlU?autoplay=1&mute=1'/> "   title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; 
encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

</div>


</div>

</article>



<%@ include file="../footer.jsp" %>