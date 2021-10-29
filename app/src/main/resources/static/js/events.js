// page component functionalities
$(window).scroll(() => {
    console.log("someting");
    if($(window).scrollTop() >= $('#navbar').height()){
        $('#navbar').addClass('fixed-top');
    }else{
        $('#navbar').remove('fixed-top');
    }
});

$(document).ready(()=>{
    $.get("/user", (res)=>{
        $('#unautenticated').hide();
        $('#logingMessage').text(`Hi ${res.name}!!`);
        $('#logingMessage').show();
        $('#imageProefile').attr('src', res.avatar_url);
    })
})