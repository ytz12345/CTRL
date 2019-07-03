(function(){
    $("#btn-item").click(function(){
        $(this).addClass('current');
        $(this).siblings().removeClass('current');
    });
})();