$(".favoButton").click(function() {
  var num = $(this).data("favonum");
  var button = this;
  if($(this).data('condition') == false){

    $.ajax({
	//コマンドを指定
      url: '/addFavoriteCommand',
      type: 'POST',
      dataType: 'json',
      data: {favonum: num},
    })
    .done(function(data, textStatus, jqXHR) {
      if(data.result == true){
        $(button).css('backgroundColor', '#FF0');
        $(button).data('condition',true);
      }
    })
    .fail(function(data) {
      console.log("error");
    });
    
  }

  else if($(this).data('condition') == true){

    //?¨?C??u?e?o?^?d??
    $.ajax({
      url: '/removeFavoriteCommand',
      type: 'POST',
      dataType: 'json',
      data: {favonum: num},
    })
    .done(function(data, textStatus, jqXHR) {
      //?o?^??￢?÷
      if(data.result == true){
        //?w?i?F?d?d??
        $(button).css('backgroundColor', '');
        //?¨?C??u?e?{?^???o???X?V
        $(button).data('condition',false);
      }
    })
    .fail(function(data) {
      console.log("error");
    });
  }
});