//news-blog
    const box = document.getElementById("box");
    animate(box);

    function animate(element) {
        let elementWidth = element.offsetWidth;
        let parentWidth = element.parentElement.offsetWidth;
        let flag = 0;

        setInterval(() => {
            element.style.marginLeft = --flag + "px";

            if (elementWidth == -flag) {
                flag = parentWidth;
            }
        }, 20);
    }
//--------------------------------------------------------------------------
    //time
    function Dong_ho() {
      var gio = document.getElementById("gio");
      var phut = document.getElementById("phut");
      var giay = document.getElementById("giay");
      var Gio_hien_tai = new Date().getHours();
      var Phut_hien_tai = new Date().getMinutes();
      var Giay_hien_tai = new Date().getSeconds();
      gio.innerHTML = Gio_hien_tai;
      phut.innerHTML = Phut_hien_tai;
      giay.innerHTML = Giay_hien_tai;
    }
    var Dem_gio = setInterval(Dong_ho, 1000);
//--------------------------------------------------------------------------
    //slideshows
    let slideIndex = 0;
    showSlides();

    function showSlides() {
      let i;
      let slides = document.getElementsByClassName("mySlides");
      let dots = document.getElementsByClassName("dot");
      for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
      }
      slideIndex++;
      if (slideIndex > slides.length) {slideIndex = 1}
      for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
      }
      slides[slideIndex-1].style.display = "block";
      dots[slideIndex-1].className += " active";
      setTimeout(showSlides, 5000); // Change image every 5 seconds
    }
//--------------------------------------------------------------------------
    //wrapper
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 5,
      spaceBetween: 30,
      slidesPerGroup: 5,
      loop: true,
      loopFillGroupWithBlank: true,
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
//--------------------------------------------------------------------------
    //backtop
    mybacktop = document.getElementById("backtop");
    // When the user scrolls down 20px from the top of the document, show the button
    window.onscroll = function() {scrollFunction()};
    function scrollFunction() {
      if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
        mybacktop.style.display = "flex";
      } else {
        mybacktop.style.display = "none";
      }
    }
    // When the user clicks on the button, scroll to the top of the document
    function topFunction() {
      document.body.scrollTop = 0; // For Safari
      document.documentElement.scrollTop = 0; // For Chrome, Firefox, IE and Opera
    }
//--------------------------------------------------------------------------
    //dark-mode
    var darkmode =document.getElementById("darkmode");

    darkmode.onclick=function(){
      document.body.classList.toggle("dark-theme");
      if (document.body.classList.contains("dark-theme")) {
        darkmode.style.background= "white";
        document.getElementById("sun-moon").src = "/img/icon/icon-sun.png";
      }
      else {
        darkmode.style.background= "#595959";
        document.getElementById("sun-moon").src = "/img/icon/icon-moon.png";
      }

    }
//--------------------------------------------------------------------------
    //Swiper
    var swiper = new Swiper(".mySwiper", {
        slidesPerView: 5, // Số sản phẩm hiển thị trên mỗi slide
        spaceBetween: 20, // Khoảng cách giữa các sản phẩm
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
    });
//--------------------------------------------------------------------------
//--------------------------------------------------------------------------




