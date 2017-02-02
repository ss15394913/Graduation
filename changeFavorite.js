$(".favoButton").click(function() {
  //�����ꂽ�{�^���̓���
  var num = $(this).data("favonum");
  var button = this;
  //���C�ɓ���{�^����data-condition�Ő���
  if($(this).data('condition') == false){

    //���C�ɓ���o�^
    $.ajax({
    	//���C�ɓ����ҏW����R�}���h�̃p�X���w��
      url: '/addFavoriteCommand',
      type: 'POST',
      dataType: 'json',
      data: {favonum: num},
    })
    .done(function(data, textStatus, jqXHR) {
      //�o�^����
      if(data.result == true){
        //���C�ɓ���{�^���̐F�����F��
        $(button).css('backgroundColor', '#FF0');
        //���C�ɓ���{�^����Ԃ̍X�V
        $(button).data('condition',true);
      }
    })
    .fail(function(data) {
      console.log("error");
    });
    
  }

  else if($(this).data('condition') == true){

    //���C�ɓ���o�^����
    $.ajax({
      url: '/removeFavoriteCommand',
      type: 'POST',
      dataType: 'json',
      data: {favonum: num},
    })
    .done(function(data, textStatus, jqXHR) {
      //�o�^��������
      if(data.result == true){
        //�w�i�F������
        $(button).css('backgroundColor', '');
        //���C�ɓ���{�^����Ԃ̍X�V
        $(button).data('condition',false);
      }
    })
    .fail(function(data) {
      console.log("error");
    });
  }
});