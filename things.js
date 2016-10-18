
$(function(){

    $('body').fadeIn()

    $('pre code').each( function(i, block){
        hljs.highlightBlock(block)
    });

    $('.code-list li').on('click', function(){
        var serviceName = $(this).text().trim();

        $('.active').removeClass('active')

        $('#' + serviceName).addClass('active')
    })

    $('.navbar-link').on('click', function(){
        var id = $(this).attr('scrollTo')
        var distance = $(id).offset().top-70

        $('html, body').animate({
            scrollTop: distance
        }, 300);
    })

})
