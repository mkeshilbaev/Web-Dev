var highlightRe = /<span class="highlight">(.*?)<\/span>/g,  //non-greedy regular expression (pattern/modifiers)
    highlightHtml = '<span class="highlight">$1</span>';    //refers to first match of regex

$(document).ready(function() {
    $('#search').change(function() {
        var term = $(this).val();
        var txt = $('#txt').html().replace(highlightRe,'$1');
       
        if(term !== '') {
            txt = txt.replace(new RegExp('(' + term + ')', 'gi'), highlightHtml);
        }    
        $('#txt').html(txt);    
    });
});

