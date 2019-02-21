
$('#addDatacenter').on('click', () => {
    $('#datacenterModal').modal('show');
    $('#datacenterName').val() = '';
});


$('#btn-addDatacenter').on('click', () => {

    var datacenterName = $('#datacenterName').val();
    var sendInfo = {
                     Name: datacenterName
                   };

          var url = "/addDatacenter";

          $.ajax({
                 type: "POST",
                 url: url,
                 data: sendInfo,
                 success: function(data)
                          {
                             alert('Datacenter agregado correctamente');
                             location.reload();
                          },
                 error: function ()
                          {
                             alert('ERROR al agregar el Datacenter');
                             location.reload();
                    	  }
          });
});