    function cargarClientes() {
        fetch("http://localhost:8080/api/clientes")
            .then(res => res.json())
            .then(clientes => {
                const select = document.getElementById("clienteSelect");
                clientes.forEach(cliente => {
                    const option = document.createElement("option");
                    option.value = cliente.dni; // ✅ Usa el ID correcto
                    option.textContent = `${cliente.nombre} (${cliente.email})`;
                    select.appendChild(option);
                });
            })
            .catch(err => console.error("Error al cargar clientes:", err));
    }

    function cargarPagos() {
        fetch("http://localhost:8080/api/pagos")
            .then(res => res.json())
            .then(pagos => {
                const select = document.getElementById("pagoSelect");
                pagos.forEach(pago => {
                    const option = document.createElement("option");
                    option.value = pago.id_Pago; // ✅ Usa el nombre de campo correcto
                    option.textContent = pago.tipo;
                    select.appendChild(option);
                });
            })
            .catch(err => console.error("Error al cargar métodos de pago:", err));
    }

// carga en el html
function cargarFunciones() {
    fetch("http://localhost:8080/api/funciones")
        .then(res => {
            if (!res.ok) {
                throw new Error(`HTTP error! status: ${res.status}`);
            }
            return res.json();
        })
        .then(funciones => {
            const select = document.getElementById("funcionSelect");
            // limpiar opciones previas y añadir la opción por defecto
            select.innerHTML = '<option value=""> Seleccione una función </option>';

            if (funciones.length === 0) {
                const option = document.createElement("option");
                option.value = "";
                option.textContent = "No hay funciones disponibles";
                select.appendChild(option);
            } else {
                funciones.forEach(funcion => {
                    const option = document.createElement("option");
                    option.value = funcion.id_Funcion;

                    // --- CAMBIO AQUÍ: Usar 'titulo' en lugar de 'nombre' para la película ---
                    const nombrePelicula = funcion.pelicula && funcion.pelicula.titulo ? funcion.pelicula.titulo : 'N/A';
                    // --- CAMBIO AQUÍ: Usar 'horario' en lugar de 'hora' ---
                    const horario = funcion.horario || 'N/A';

                    // Usar 'horario' aquí
                    option.textContent = `Película: ${nombrePelicula} - Hora: ${horario}`;
                    select.appendChild(option);
                });
            }
        })
        .catch(err => console.error("Error al cargar funciones:", err));
}



    function cargarCines() {
        fetch("http://localhost:8080/api/cines")
            .then(res => res.json())
            .then(cines => {
                const select = document.getElementById("cineSelect");
                cines.forEach(cine => {
                    const option = document.createElement("option");
                    option.value = cine.id_Cine; // ✅ Usa el nombre correcto
                    option.textContent = `${cine.nombre} - ${cine.direccion}`;
                    select.appendChild(option);
                });
            })
            .catch(err => console.error("Error al cargar cines:", err));
    }


    //cargo las ventas a la tablita
    function cargarVentas() {
        fetch("http://localhost:8080/api/ventas")
            .then(res => {
                if (!res.ok) {
                    throw new Error(`HTTP error! status: ${res.status}`);
                }
                return res.json();
            })
            .then(ventas => {
                const salesTableBody = document.getElementById("salesTableBody");
                salesTableBody.innerHTML = ''; // Clear existing rows

                if (ventas.length === 0) {
                    const row = salesTableBody.insertRow();
                    const cell = row.insertCell();
                    cell.colSpan = 5; // Span all columns
                    cell.textContent = "No hay ventas registradas.";
                    cell.style.textAlign = 'center';
                    cell.style.padding = '20px';
                } else {
                    ventas.forEach(venta => {
                        const row = salesTableBody.insertRow();

                        // ID Venta
                        row.insertCell().textContent = venta.id_Venta || 'N/A';

                        // Fecha
                        row.insertCell().textContent = venta.fecha || 'N/A';

                        // Cliente
                        const clienteNombre = venta.clientes && venta.clientes.length > 0
                            ? `${venta.clientes[0].nombre} (${venta.clientes[0].email})`
                            : 'N/A';
                        row.insertCell().textContent = clienteNombre;

                        // Método de Pago
                        const tipoPago = venta.pago && venta.pago.tipo ? venta.pago.tipo : 'N/A';
                        row.insertCell().textContent = tipoPago;

                        // Funciones
                        const funcionesText = venta.funciones && venta.funciones.length > 0
                            ? venta.funciones.map(f => `${f.pelicula ? f.pelicula.titulo : 'N/A'} (${f.horario || 'N/A'})`).join(', ')
                            : 'N/A';
                        row.insertCell().textContent = funcionesText;
                    });
                }
            })
            .catch(err => console.error("Error al cargar ventas:", err));
    }




    //envio de datos al back
    document.getElementById("ventaForm").addEventListener("submit", function (e) {
    e.preventDefault();

        const clienteId = parseInt(document.getElementById("clienteSelect").value);

        const selectedFuncionId = parseInt(document.getElementById("funcionSelect").value);

        const venta = {
            fecha: document.getElementById("fechaVenta").value,
            pago: {
                id_Pago: parseInt(document.getElementById("pagoSelect").value)
            },
            funciones: [ // Envuelve la función seleccionada en un array
            {
                id_Funcion: selectedFuncionId // Objeto función con su ID
            }
                ],
            clientes: [{ dni: clienteId }]


        };

        console.log("Enviando venta:", JSON.stringify(venta, null, 2));

        fetch("http://localhost:8080/api/ventas", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(venta)
        })
        .then(res => {
            if (res.ok) {
                alert("Venta registrada exitosamente");
                this.reset();
            } else {
                res.text().then(texto => alert("Error al registrar la venta:\n" + texto));
            }
        })
        .catch(err => {
            console.error("Error en la solicitud:", err);
            alert("Error en la conexión al servidor");
        });
    });


    window.addEventListener("DOMContentLoaded", () => {
        cargarClientes();
        cargarFunciones();
        cargarPagos();
        cargarCines();
        cargarVentas()
    });