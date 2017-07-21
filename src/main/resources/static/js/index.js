$(document).ready(function() {

  $('#get').click(loadData);
  $('#post').click(saveData);

  function loadData() {
    $.ajax({
      type: "GET",
      cache: false,
      dataType: "json",
      url: '/getRandomData',
      success: function (response) {
        if (response.content) {
          var html = "";
          $.each(response.content, function (i, it) {
            html = html.concat([it.code, it.value, it.time, "<br/>"].join(";"));
          });
          $('#container').html(html);
        }
      },
      error: processError
    });
  }

  function saveData() {
    if (!$("#data").val()) {
      alert("Enter your data!");
    } else {
      $.ajax({
        type: "POST",
        cache: false,
        url: '/persist',
        contentType: 'application/json',
        data: JSON.stringify({
          code: $("#data").val(),
          value: 'Value of [' + $("#data").val() + ']'
        }),
        success: loadData,
        error: processError
      });
    }
  }

  function processError(response) {
    alert(response.responseText);
  }
});