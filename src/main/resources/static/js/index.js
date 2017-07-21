$(document).ready(function() {

  $("#entity-type").find(".js-get").click(getEntityTypes);
  $("#entity-type").find(".js-add").click(addEntityType);

  $("#entity").find(".js-get").click(getEntities);
  $("#entity").find(".js-add").click(addEntity);

  function getEntityTypes() {
    $.ajax({
      type: "GET",
      cache: false,
      dataType: "json",
      url: "/api/entity-type",
      success: function (response) {
        if (response.content) {
          var html = "";
          $.each(response.content, function (i, it) {
            html = html.concat(it.code + "<br/>");
          });
          $("#entity-type").find(".js-content").html(html);
        }
      },
      error: processError
    });
  }

  function addEntityType() {
    if (!$("#entity-type").find(".js-code").val()) {
      alert("Enter your data!");
    } else {
      $.ajax({
        type: "POST",
        cache: false,
        url: "/api/entity-type",
        contentType: "application/json",
        data: JSON.stringify({
          code: $("#entity-type").find(".js-code").val()
        }),
        success: getEntityTypes,
        error: processError
      });
    }
  }

  function getEntities() {
    $.ajax({
      type: "GET",
      cache: false,
      dataType: "json",
      url: "/api/entity",
      success: function (response) {
        if (response.content) {
          var html = "";
          $.each(response.content, function (i, it) {
            html = html.concat(it.id + " - " + it.type.code + "<br/>");
          });
          $("#entity").find(".js-content").html(html);
        }
      },
      error: processError
    });
  }

  function addEntity() {
    if (!$("#entity").find(".js-type-code").val()) {
      alert("Enter your data!");
    } else {
      $.ajax({
        type: "POST",
        cache: false,
        url: "/api/entity",
        contentType: "application/json",
        data: JSON.stringify({
          type: {
            code: $("#entity").find(".js-type-code").val()
          }
        }),
        success: getEntities,
        error: processError
      });
    }
  }

  function processError(response) {
    alert(response.responseText);
  }
});