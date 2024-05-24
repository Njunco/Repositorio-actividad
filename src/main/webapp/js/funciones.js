function eliminarUsuario(IdUsuario){
	swal({
  title: "Esta Seguro de eliminar ?",
  text: "Esta apunto de eliminar un usuario!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/usuarios/eliminar/"+IdUsuario,
		    success: function(res) {
			console.log(res);
		}
	});
    swal("El usuario se elimino", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/usuarios";
	}
});
  } else {
    swal("Usuario no eliminado!");
  }
});
}

function eliminarCliente(IdCliente){
	swal({
  title: "Esta Seguro de eliminar ?",
  text: "Esta apunto de eliminar un Cliente!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/listaCliente/eliminar/"+IdCliente,
		    success: function(res) {
			console.log(res);
		}
	});
    swal("El cliente se elimino", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/listaCliente";
	}
});
  } else {
    swal("Cliente no eliminado!");
  }
});
}
function eliminarProductos(IdProducto){
	swal({
  title: "Esta Seguro de eliminar ?",
  text: "Esta apunto de eliminar un un producto!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/productos/eliminar/"+IdProducto,
		    success: function(res) {
			console.log(res);
		}
	});
    swal("El producto se elimino", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/productos";
	}
});
  } else {
    swal("Productos no eliminado!");
  }
});
}
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
function eliminarInsumos(IdInsumo){
	swal({
  title: "Esta Seguro de eliminar ?",
  text: "Esta apunto de eliminar un un Insumo!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((Ok) => {
  if (Ok) {
	$.ajax({
		url:"/Insumos/eliminar/"+IdInsumo,
		    success: function(res) {
			console.log(res);
		}
	});
    swal("El Insumo se elimino", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/Insumos";
	}
});
  } else {
    swal("Insumo no eliminado!");
  }
});
}

//_______________________________________________________________



//________________________________________________________________

function reporte(){
	
	var fecha1 = document.getElementById("fecha1").value;
	var fecha2 = document.getElementById("fecha2").value;
	var tip0 = document.getElementById("tip0").value;
	var dir = 
	
	window.open("http://productosclemy.jelastic.saveincloud.net/report/ventas/download?fecha_inicio="+fecha1+"&fecha_fin="+fecha2+"&tipo="+tip0);
	
	
}

function reporte2(){
	
	var fecha3 = document.getElementById("fecha3").value;
	var fecha4 = document.getElementById("fecha4").value;
	var tipo1 = document.getElementById("tipo1").value;
	var dir = 
	
	window.open("http://productosclemy.jelastic.saveincloud.net/Ventas/ventas/download?fechaInicio="+fecha3+"&fechaFin="+fecha4+"&tipo="+tipo1);
	
	
}

function reporte3(){
	
	var fecha5 = document.getElementById("fecha5").value;
	var fecha6 = document.getElementById("fecha6").value;
	var tipo2 = document.getElementById("tipo2").value;
	var dir = 
	
	window.open("http://productosclemy.jelastic.saveincloud.net/reporteTotales/ventas/download?fechaInicio="+fecha5+"&fechaFin="+fecha6+"&tipo="+tipo2);
	
	
}

function reporte4(){
	
	var fecha7 = document.getElementById("fecha7").value;
	var fecha8 = document.getElementById("fecha8").value;
	var tipo3 = document.getElementById("tipo3").value;
	var dir = 
	
	window.open("http://productosclemy.jelastic.saveincloud.net/Vendedor/ventas/download?fechaInicio="+fecha7+"&fechaFin="+fecha8+"&tipo="+tipo3);
	
	
}
function checkPasswordMatch(fieldConfirmPassword) {
    if (fieldConfirmPassword.value != $("#password").val()) {
        fieldConfirmPassword.setCustomValidity("las contraseñas no conciden!");
    } else {
        fieldConfirmPassword.setCustomValidity("");
    }
}

	const addProduct = async (id) => {
		let data = '{}';
		try{
			let url = `/ventas/addProduct/${id}`;
			let response = await fetch(url);
			data = await response.text();
		}catch(e){
			console.log(e);
		}
		return JSON.parse(data);
	}
	
	const saveProduct = async (idVenta) => {
		let status = 500;
		try{
			let url = `/ventas_productos/guardar`;
			
			let length = Object.keys(document.getElementById('tbProductos').rows).length - 1;
			for(let i = 1; i < length; i++){
				let idProducto = document.getElementsByName('idProducto[]')[i].innerText;
				let precioProducto = document.getElementsByName('precio[]')[i].innerText;
				let cantidadProducto = document.getElementsByName('cantidad[]')[i].value;
				
				let formdata = new FormData();
				formdata.append("productos", idProducto);
				formdata.append("ventas", idVenta);
				formdata.append("precio", precioProducto);
				formdata.append("CantidadCompra", cantidadProducto);

				let requestOptions = {
				  method: 'POST',
				  body: formdata,
				  redirect: 'follow'
				};
				
				let response = await fetch(url, requestOptions);
				status = await response.status;
				if(status == 500)
					break;
			}
		}catch(e){
			console.log(e);
		}
		return status;
	}
	
	const validFields = () => {
		let isValid = true;
		try{
			if(document.getElementById('idCliente').value == -1){
				isValid = false;
				alert('Debe seleccionar un cliente');
			}else if(document.getElementsByName('idProducto[]')[1] == undefined){
				isValid = false;
				alert('Debe seleccionar al menos un producto');
			}
				
		}catch(e){
			console.log(e);
		}
		return isValid;
	}
	
	const saveSale = async () => {
		let id = 0;
		try{
			let url = `/ventas/guardar`;
			let formdata = new FormData();
			let idCliente = document.getElementById('idCliente').value;
			let valorTotalVenta = document.getElementById('totalCompra').innerText;
			
			formdata.append('ValorVenta', valorTotalVenta);
			formdata.append('Cliente', idCliente);

			let requestOptions = {
			  method: 'POST',
			  body: formdata,
			  redirect: 'follow'
			};
			
			let response = await fetch(url, requestOptions);
			let data = await response.json();
			id = data.id;
			
		}catch(e){
			console.log(e);
		}
		return id;
	}
	
	const editSale = async (idVenta) => {
		let status = 500;
		try{
			let url = `/ventas/editar`;
			let formdata = new FormData();
			let idCliente = document.getElementById('idCliente').value;
			let valorTotalVenta = document.getElementById('totalCompra').innerText;
			
			formdata.append('IdVenta', idVenta);
			formdata.append('ValorVenta', valorTotalVenta);
			formdata.append('Cliente', idCliente);

			let requestOptions = {
			  method: 'POST',
			  body: formdata,
			  redirect: 'follow'
			};
			
			let response = await fetch(url, requestOptions);
			status = await response.status;
		}catch(e){
			console.log(e);
		}
		return status;
	}
	
	const addRow = async () => { 
		try{
			let id = document.getElementById('idProducto').value;
			if(id == -1)
				return;
			
			let rowsHeader = {
						0: 'idProducto[]', 
						1: 'nombreProducto[]',
						2: 'precio[]',
						3: 'cantidad[]',
						4: 'totalProducto[]'
					};
			
			let rowsValue = {
					0: 'id',
					1: 'nombre',
					2: 'precio',
					3: 'cantidad',
					4: 'total'
			}
			
			let data = await addProduct(id);
			data = {...data, cantidad: 1, total: data.precio};
			let table = document.getElementById('tbProductos');
			let rowCount = table.rows.length;
			let cellCount = table.rows[0].cells.length; 
			let row = table.insertRow(rowCount);
			
			Object.keys(rowsValue).forEach(i => {
				document.getElementsByName(rowsHeader[i] || '')[0].textContent = data[rowsValue[i]];
			});
			
			for(let i =0; i < cellCount; i++){
				let cell = 'cell'+i;
				cell = row.insertCell(i);
				let copycel = document.getElementById('col'+i).innerHTML;
				cell.innerHTML = copycel;
			}
			calculatePriceTotal();
		}catch(e){
			console.log(e);
		}
	}
	
	const deleteRow = row => {
		try{
			let rowId = row.parentNode.parentNode.rowIndex;
			document.getElementById("tbProductos").deleteRow(rowId);
			calculatePriceTotal();
		}catch(e){
			console.log(e);
		}
	}
	
	const calculatePrice = row => {
		try{
			let rowId = row.parentNode.parentNode.rowIndex - 1;
			let cantidad = document.getElementsByName('cantidad[]')[rowId];
			
			if(cantidad.value < 1){
				alert('La cantidad debe ser mayor a 1');
				cantidad.value = 1;
			}
			
			let precio = parseInt(document.getElementsByName('precio[]')[rowId].innerText);
			document.getElementsByName('totalProducto[]')[rowId].innerText = precio * cantidad.value;
			calculatePriceTotal();
		}catch(e)
		{
			console.log("Error en la app:" + e);
		}
	}
	
	const calculateParcialPriceInvoice = (isEdit) => {
		try
		{
			let length = Object.keys(document.getElementById('tbProductos').rows).length - 1;

			for(let i = 0; i < length; i++){
				let cantidad = 0;
				let precio = parseInt(document.getElementsByName('precio[]')[i].innerText);
				
				if(isEdit){
					cantidad = parseInt(document.getElementsByName('cantidad[]')[i].value);
				}else{
					cantidad = parseInt(document.getElementsByName('cantidad[]')[i].innerText);
				}
				
				document.getElementsByName('totalProducto[]')[i].innerText = precio * cantidad;
			}
		}catch(e)
		{
			console.log("Error en la app:" + e);
		}
	}
	
	const calculatePriceTotal = () => {
		try{
			let length = Object.keys(document.getElementById('tbProductos').rows).length - 1;
			let total = 0;
			for(let i = 1; i < length; i++){
				total += parseInt(document.getElementsByName('totalProducto[]')[i].innerText);
			}
			document.getElementById('totalCompra').innerText = total;
		}catch(e)
		{
			console.log("Error en la app:" + e);
		}
	}
	
	const isValidAmountProduct = async () => {
		let isValid = true;
		try{
			let length = Object.keys(document.getElementById('tbProductos').rows).length - 1;
			for(let i = 1; i < length; i++){
				let cantidad = parseInt(document.getElementsByName('cantidad[]')[i].value);
				let idProducto = parseInt(document.getElementsByName('idProducto[]')[i].innerText);
				let nombreProducto = document.getElementsByName('nombreProducto[]')[i].innerText;
				let url = `/ventas/validarProducto/${idProducto}/${cantidad}`;
				let response = await fetch(url);
				let data = await response.json();
				if(!data.isValid){
					isValid = false;
					alert(`No hay suficientes: ${nombreProducto} - cantidad disponible: ${data.cantidad}`);
					break;
				}
			}
		}catch(e){
			console.log("Error en la app:" + e);
			isValid = false;
		}
		return isValid;
	}
	
	const onSubmitAddSale = async (form) => {
		try{
			if(!validFields())
				return;
			let isValidAmount = await isValidAmountProduct();
			if(!isValidAmount)
				return;
			let idVenta = await saveSale();
			let statusProduct = await saveProduct(idVenta);
			if(statusProduct == 200){
				window.location = '/ventas';
				return;
			}
				
			alert('Error en la app');
		}catch(e){
			console.log("Error en la app:" + e);
		}
	}
	
	const onSubmitEditSale = async (form) => {
		try{
			if(!validFields())
				return;
			let idVenta = document.getElementById('idVenta').innerText;
			let statusSale = await editSale(idVenta);
			if(statusSale == 200){
				let statusProduct = await saveProduct(idVenta);
				if(statusProduct == 200){
					window.location = '/ventas';
					return;
				}
			}
			
				
			alert('Error en la app');
		}catch(e){
			console.log("Error en la app:" + e);
		}
	}
	
const deleteVenta = async id => {
	try{
		let confirmDelete = confirm('¿Esta seguro de eliminar esta venta?');
		if(confirmDelete){
			let url = `/ventas/eliminar/${id}`;
			let response = await fetch(url);
			let status = await response.status;
			if(status == 200){
				window.location = '/ventas';
				return;
			}
		} 
	}catch(e){
		alert('Error en la app: ' + e);
	}
}
