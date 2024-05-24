/**
 * 
 */
 
 $(document).ready(function() {
    $('#categoriass').DataTable({
        language: {
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",

                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing": "Procesando...",
        },
        responsive: "true",
        dom: 'fBlrtpli',
        buttons: [{
                extend: 'excelHtml5',
                text: '<i class="fas fa-file-excel"></i> ',
                titleAttr: 'Exportar a Excel',
                className: 'btn btn-success'
            },
            {
                extend: 'pdfHtml5',
                text: '<i class="fas fa-file-pdf"></i> ',
                titleAttr: 'Exportar a PDF',
                className: 'btn btn-danger'
            },
            {
                extend: 'print',
                text: '<i class="fa fa-print"></i> ',
                titleAttr: 'Imprimir',
                className: 'btn btn-primary'
            },
        ]
    });
});
 
 $(document).ready(function() {
    $('#example').DataTable({
        language: {
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar:",
            "oPaginate": {
                "sFirst": "Primero",

                "sLast": "Último",
                "sNext": "Siguiente",
                "sPrevious": "Anterior"
            },
            "sProcessing": "Procesando...",
        },
        responsive: "true",
        dom: 'fBlrtpli',
        buttons: [{
                extend: 'excelHtml5',
                text: '<i class="fas fa-file-excel"></i> ',
                titleAttr: 'Exportar a Excel',
                className: 'btn btn-success'
            },
            {
                extend: 'pdfHtml5',
                text: '<i class="fas fa-file-pdf"></i> ',
                titleAttr: 'Exportar a PDF',
                className: 'btn btn-danger'
            },
            {
                extend: 'print',
                text: '<i class="fa fa-print"></i> ',
                titleAttr: 'Imprimir',
                className: 'btn btn-primary'
            },
        ]
    });
});

function eliminarVentas(IdVenta){
	swal({
  title: "Esta Seguro de eliminar ?",
  text: "Esta apunto de eliminar una venta!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/ventas/eliminar/"+IdVenta,
		    success: function(res) {
			console.log(res);
		}
	});
    swal("La venta se elimino", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/Ventas";
	}
});
  } else {
    swal("Venta no eliminado!");
  }
});
}

const generatePDF = (id, namePDF) => {
    try{
        let pdf = new jsPDF('p', 'pt', 'letter')

        let source = $('#'+id)[0]
        
        let margins = {
            top: 80,
            bottom: 60,
            left: 40,
            width: 522
          };

        pdf.fromHTML(
            source // HTML string or DOM elem ref.
            , margins.left // x coord
            , margins.top // y coord
            , {
                'width': margins.width // max width of content on PDF
            },
            function (dispose) {
              // dispose: object with X, Y of the last line add to the PDF
              //          this allow the insertion of new lines after html
                pdf.save(namePDF+'.pdf');
              },
            margins
          )
    }catch(e){
        console.log(e);
    }
}