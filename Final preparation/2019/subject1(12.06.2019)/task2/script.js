$(function() {

   // $('#first th').each( function(){                       // loop first table
      $('#first tr').each( function(){ 
    //var name = $(this).find('td:first').text(),             // get the name
      $(this).clone().appendTo('.result');
// });
 });
    
  //$('#second th').each( function(){ 
    $('#second tr').each( function(){ 
                       // loop the second table
    //var name = $(this).find('td:first').text(),
      $(this).clone().appendTo('.result');
  //});
    });

});
