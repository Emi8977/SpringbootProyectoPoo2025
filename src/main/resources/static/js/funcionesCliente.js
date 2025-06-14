    // Botón que redirige a la página para crear una venta
  document.getElementById('btnCrearVenta').addEventListener('click', () => {
    window.location.href = 'crear-venta.html'; // Cambia esta URL a la ruta real de tu página
  });

    // Función para cargar clientes en el select
    function cargarClientes() {
      fetch("http://localhost:8080/api/clientes")
        .then(response => response.json())
        .then(clientes => {
          const select = document.getElementById("clienteSelect");
          select.innerHTML = '<option value=""> Verifique los clientes o recargue la pagina</option>'; // Limpiar
          clientes.forEach(cliente => {
            const option = document.createElement("option");
            //option.value = cliente.dni;
            option.textContent = cliente.nombre + " (" + cliente.email+ ")";
            select.appendChild(option);
          });
        })
        .catch(error => {
          console.error("Error al cargar los clientes:", error);
        });
    }

    // Al enviar el formulario, se crea un nuevo cliente
    document.getElementById("clienteForm").addEventListener("submit", function (event) {
      event.preventDefault();

      const cliente = {
        nombre: document.getElementById("nombre").value,
        email: document.getElementById("email").value,
        //dni: document.getElementById("dni").value
      };

      fetch("http://localhost:8080/api/clientes", {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(cliente)  //convierte el objeto JS a JSON
        })
        .then(response => {
          if (response.ok) {
            alert("Cliente creado con éxito");
          } else {
            alert("Error al crear cliente");
          }
        });

    });

    // Cargar clientes al cargar la página
    window.onload = cargarClientes;