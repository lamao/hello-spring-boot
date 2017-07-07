$(document).ready(function() {

  $('#get').click(function () {
    $.ajax({
      type: "GET",
      cache: false,
      url: '/getRandomData',
      data: "",
      success: function (response) {
        if (response.content) {
          var html = "";
          $.each(response.content, function (i, it) {
            html = html.concat([it.code, it.value, it.time, "<br/>"].join(";"));
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
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify({
          code: $("#data").val(),
          value: 'Value of <' + $("#data").val() + '>'
        }),
        success: function (response) {
          $('#get').click();
        }
      });
    }

  });

});