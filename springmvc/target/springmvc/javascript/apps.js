// var slideIndex =1;
var sl = 0;
shownSlidesn();

// function slideclick(n){
//     shownSlides(slideIndex = n)
// }
// function shownSlides(n){
//     var i;
//     var slides = document.getElementsByClassName("mySlides");
//     var dots = document.getElementsByClassName("dot");

//     //if greater than max image go to first
//     if(n>slides.length){
//         slideIndex =1;
//     }

//     if(n<1){
//         slideIndex =slides.length;
//     }
//     //hide all slide
//     for(i=0;i<slides.length;i++){
//         slides[i].style.display = "none";
//     }
//     //remove active class on dot
//     for(i=0;i<dots.length;i++){
//         dots[i].className = dots[i].className.replace(" active", "");
//     }
//     //shown slide
//     slides[slideIndex-1].style.display = "block";
//     dots[slideIndex-1].className += " active";

    //active dot
    //setTimeout(shownSlides, 2000) /*change image after 2 section*/
//}
function shownSlidesn(){
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("dot");

    //hide all slide
    for(i=0;i<slides.length;i++){
        slides[i].style.display = "none";
    }

    //go to next image
    sl++;

    //if greater than max image go to first
    if(sl>slides.length){
        sl =1;
    }

    //remove active class on dot
    for(i=0;i<dots.length;i++){
        dots[i].className = dots[i].className.replace("active", "");
    }
    //shown slide
    slides[sl-1].style.display = "block";

    //active dot
    setTimeout(shownSlidesn, 2000) /*change image after 2 section*/
}