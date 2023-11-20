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
//tính tổng tiền trong giỏ hàng
function tinhTongTien() {
    var table = document.getElementById("table_pay");
    var rows = table.rows;
    var total = 0;

    for (var i = 1; i < rows.length - 1; i++) {
        var cellQuantity = rows[i].querySelector('input[name="quantity"]');
        var cellPrice = rows[i].cells[3];
        var cellTotal = rows[i].cells[5];
        var quantity = parseInt(cellQuantity.value, 10);
        var price = parseInt(cellPrice.textContent.replace(' VND', '').trim(), 10);
        var subtotal = quantity * price;
        cellTotal.textContent = subtotal + ' VND';
        total += subtotal;
    }
    document.getElementById("tongTien").textContent = total + ' VND';
}
//--------------------------------------------------------------------------
//Xóa dòng trong giỏ hàng
    function removeRow(button) {
        // Xác định dòng (sản phẩm) cần xóa
        var row = button.parentNode.parentNode;
        row.remove();
        // Gọi hàm tính tổng tiền để cập nhật tổng sau khi xóa dòng
        tinhTongTien();
    }
//--------------------------------------------------------------------------
//Kiểm tra sdt trong form cart
    function validatePhoneNumber() {
        var phoneNumber = document.getElementById('customerPhone').value;
        var regex = /^[0-9]*$/; // Chỉ chấp nhận các ký tự số
        if (!regex.test(phoneNumber)) {
            alert('Vui lòng nhập số điện thoại hợp lệ.');
            document.getElementById('customerPhone').value = "";
            return false;
        }
        return true;
    }
//--------------------------------------------------------------------------
document.getElementById('paymentButton').get.addEventListener('click', function() {
    //Lấy số tổng tiền
    var totalText = document.getElementById('tongTien').innerText;
    var totalWithoutVND = totalText.replace(' VND', '').trim();
    var total = parseInt(totalWithoutVND, 10);

    // Chuyển hướng đến trang thanh toán với tham số totalAmount
    window.location.href = '/pages/payment?totalAmount=' + total;
});



