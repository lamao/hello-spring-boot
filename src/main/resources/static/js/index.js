$(document).ready(function() {

  $('#get').click(function () {
    $.ajax({
      type: "GET",
      cache: false,
      url: '/getRandomData',
      data: "",
      success: function (response) {
        if (response.data) {
          var html = "";
          $.each(response.data, function (i) {
            html = html + response.data[i] + "<br/>";
          });
          $('#container').html(html);
        }
      }
    });
  });

  $('#post').click(function () {
    if (!$("#data").val()) {
      alert("Enter your data!");
    } else {
      $.ajax({
        type: "POST",
        cache: false,
        url: '/persist',
        data: {
          'data': $("#data").val()
        },
        success: function (response) {
          $('#get').click();
        }
      });
    }

  });

});