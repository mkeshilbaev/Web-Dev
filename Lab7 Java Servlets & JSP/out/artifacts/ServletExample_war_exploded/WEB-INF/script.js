$(document).ready(function(){
    $('#btn1').click(function(){
       var text = $('#div1').innerText;
       text.html("Hello world");
    });
});